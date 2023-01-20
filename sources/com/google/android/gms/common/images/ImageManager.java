package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import android.widget.ImageView;
import androidx.collection.LruCache;
import com.google.android.gms.common.annotation.KeepName;
import e.j.a.b.c.r.h;
import e.j.a.b.f.a.j;
import e.j.a.b.f.a.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public final class ImageManager {

    /* renamed from: i  reason: collision with root package name */
    private static final Object f2641i = new Object();

    /* renamed from: j  reason: collision with root package name */
    private static HashSet<Uri> f2642j = new HashSet<>();

    /* renamed from: k  reason: collision with root package name */
    private static ImageManager f2643k;
    private final Context a;
    private final Handler b = new o(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final ExecutorService f2644c = Executors.newFixedThreadPool(4);

    /* renamed from: d  reason: collision with root package name */
    private final b f2645d = null;

    /* renamed from: e  reason: collision with root package name */
    private final j f2646e = new j();

    /* renamed from: f  reason: collision with root package name */
    private final Map<e.j.a.b.c.q.b, ImageReceiver> f2647f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private final Map<Uri, ImageReceiver> f2648g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private final Map<Uri, Long> f2649h = new HashMap();

    @KeepName
    /* loaded from: classes2.dex */
    public final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        private final ArrayList<e.j.a.b.c.q.b> zamq;

        public ImageReceiver(Uri uri) {
            super(new o(Looper.getMainLooper()));
            this.mUri = uri;
            this.zamq = new ArrayList<>();
        }

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i2, Bundle bundle) {
            ImageManager.this.f2644c.execute(new c(this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public final void zab(e.j.a.b.c.q.b bVar) {
            e.j.a.b.c.r.d.a("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zamq.add(bVar);
        }

        public final void zac(e.j.a.b.c.q.b bVar) {
            e.j.a.b.c.r.d.a("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zamq.remove(bVar);
        }

        public final void zace() {
            Intent intent = new Intent(h.f10417c);
            intent.putExtra(h.f10418d, this.mUri);
            intent.putExtra(h.f10419e, this);
            intent.putExtra(h.f10420f, 3);
            ImageManager.this.a.sendBroadcast(intent);
        }
    }

    /* loaded from: classes2.dex */
    public interface a {
        void a(Uri uri, Drawable drawable, boolean z);
    }

    /* loaded from: classes2.dex */
    public static final class b extends LruCache<e.j.a.b.c.q.c, Bitmap> {
        @Override // androidx.collection.LruCache
        public final /* synthetic */ void entryRemoved(boolean z, e.j.a.b.c.q.c cVar, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, cVar, bitmap, bitmap2);
        }

        @Override // androidx.collection.LruCache
        public final /* synthetic */ int sizeOf(e.j.a.b.c.q.c cVar, Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            return bitmap2.getHeight() * bitmap2.getRowBytes();
        }
    }

    /* loaded from: classes2.dex */
    public final class c implements Runnable {
        private final Uri a;
        private final ParcelFileDescriptor b;

        public c(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.a = uri;
            this.b = parcelFileDescriptor;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            Bitmap bitmap;
            e.j.a.b.c.r.d.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            ParcelFileDescriptor parcelFileDescriptor = this.b;
            boolean z2 = false;
            Bitmap bitmap2 = null;
            if (parcelFileDescriptor != null) {
                try {
                    bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                } catch (OutOfMemoryError e2) {
                    String valueOf = String.valueOf(this.a);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34);
                    sb.append("OOM while loading bitmap for uri: ");
                    sb.append(valueOf);
                    Log.e("ImageManager", sb.toString(), e2);
                    z2 = true;
                }
                try {
                    this.b.close();
                } catch (IOException e3) {
                    Log.e("ImageManager", "closed failed", e3);
                }
                z = z2;
                bitmap = bitmap2;
            } else {
                bitmap = null;
                z = false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.b.post(new e(this.a, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                String valueOf2 = String.valueOf(this.a);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 32);
                sb2.append("Latch interrupted while posting ");
                sb2.append(valueOf2);
                Log.w("ImageManager", sb2.toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    public final class d implements Runnable {
        private final e.j.a.b.c.q.b a;

        public d(e.j.a.b.c.q.b bVar) {
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.j.a.b.c.r.d.a("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f2647f.get(this.a);
            if (imageReceiver != null) {
                ImageManager.this.f2647f.remove(this.a);
                imageReceiver.zac(this.a);
            }
            e.j.a.b.c.q.b bVar = this.a;
            e.j.a.b.c.q.c cVar = bVar.a;
            if (cVar.a != null) {
                Bitmap h2 = ImageManager.this.h(cVar);
                if (h2 != null) {
                    this.a.a(ImageManager.this.a, h2, true);
                    return;
                }
                Long l2 = (Long) ImageManager.this.f2649h.get(cVar.a);
                if (l2 != null) {
                    if (SystemClock.elapsedRealtime() - l2.longValue() >= com.heytap.mcssdk.constant.a.f3315e) {
                        ImageManager.this.f2649h.remove(cVar.a);
                    } else {
                        this.a.c(ImageManager.this.a, ImageManager.this.f2646e, true);
                        return;
                    }
                }
                this.a.b(ImageManager.this.a, ImageManager.this.f2646e);
                ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.f2648g.get(cVar.a);
                if (imageReceiver2 == null) {
                    imageReceiver2 = new ImageReceiver(cVar.a);
                    ImageManager.this.f2648g.put(cVar.a, imageReceiver2);
                }
                imageReceiver2.zab(this.a);
                if (!(this.a instanceof e.j.a.b.c.q.e)) {
                    ImageManager.this.f2647f.put(this.a, imageReceiver2);
                }
                synchronized (ImageManager.f2641i) {
                    if (!ImageManager.f2642j.contains(cVar.a)) {
                        ImageManager.f2642j.add(cVar.a);
                        imageReceiver2.zace();
                    }
                }
                return;
            }
            bVar.c(ImageManager.this.a, ImageManager.this.f2646e, true);
        }
    }

    /* loaded from: classes2.dex */
    public final class e implements Runnable {
        private final Uri a;
        private final Bitmap b;

        /* renamed from: c  reason: collision with root package name */
        private final CountDownLatch f2651c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2652d;

        public e(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.a = uri;
            this.b = bitmap;
            this.f2652d = z;
            this.f2651c = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.j.a.b.c.r.d.a("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.b != null;
            if (ImageManager.this.f2645d != null) {
                if (this.f2652d) {
                    ImageManager.this.f2645d.evictAll();
                    System.gc();
                    this.f2652d = false;
                    ImageManager.this.b.post(this);
                    return;
                } else if (z) {
                    ImageManager.this.f2645d.put(new e.j.a.b.c.q.c(this.a), this.b);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f2648g.remove(this.a);
            if (imageReceiver != null) {
                ArrayList arrayList = imageReceiver.zamq;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    e.j.a.b.c.q.b bVar = (e.j.a.b.c.q.b) arrayList.get(i2);
                    if (z) {
                        bVar.a(ImageManager.this.a, this.b, false);
                    } else {
                        ImageManager.this.f2649h.put(this.a, Long.valueOf(SystemClock.elapsedRealtime()));
                        bVar.c(ImageManager.this.a, ImageManager.this.f2646e, false);
                    }
                    if (!(bVar instanceof e.j.a.b.c.q.e)) {
                        ImageManager.this.f2647f.remove(bVar);
                    }
                }
            }
            this.f2651c.countDown();
            synchronized (ImageManager.f2641i) {
                ImageManager.f2642j.remove(this.a);
            }
        }
    }

    private ImageManager(Context context, boolean z) {
        this.a = context.getApplicationContext();
    }

    public static ImageManager a(Context context) {
        if (f2643k == null) {
            f2643k = new ImageManager(context, false);
        }
        return f2643k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap h(e.j.a.b.c.q.c cVar) {
        b bVar = this.f2645d;
        if (bVar == null) {
            return null;
        }
        return bVar.get(cVar);
    }

    private final void j(e.j.a.b.c.q.b bVar) {
        e.j.a.b.c.r.d.a("ImageManager.loadImage() must be called in the main thread");
        new d(bVar).run();
    }

    public final void b(ImageView imageView, int i2) {
        j(new e.j.a.b.c.q.d(imageView, i2));
    }

    public final void c(ImageView imageView, Uri uri) {
        j(new e.j.a.b.c.q.d(imageView, uri));
    }

    public final void d(ImageView imageView, Uri uri, int i2) {
        e.j.a.b.c.q.d dVar = new e.j.a.b.c.q.d(imageView, uri);
        dVar.f10359c = i2;
        j(dVar);
    }

    public final void e(a aVar, Uri uri) {
        j(new e.j.a.b.c.q.e(aVar, uri));
    }

    public final void f(a aVar, Uri uri, int i2) {
        e.j.a.b.c.q.e eVar = new e.j.a.b.c.q.e(aVar, uri);
        eVar.f10359c = i2;
        j(eVar);
    }
}
