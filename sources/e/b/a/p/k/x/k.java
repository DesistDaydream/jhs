package e.b.a.p.k.x;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class k implements e {

    /* renamed from: k  reason: collision with root package name */
    private static final String f9618k = "LruBitmapPool";

    /* renamed from: l  reason: collision with root package name */
    private static final Bitmap.Config f9619l = Bitmap.Config.ARGB_8888;
    private final l a;
    private final Set<Bitmap.Config> b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9620c;

    /* renamed from: d  reason: collision with root package name */
    private final a f9621d;

    /* renamed from: e  reason: collision with root package name */
    private long f9622e;

    /* renamed from: f  reason: collision with root package name */
    private long f9623f;

    /* renamed from: g  reason: collision with root package name */
    private int f9624g;

    /* renamed from: h  reason: collision with root package name */
    private int f9625h;

    /* renamed from: i  reason: collision with root package name */
    private int f9626i;

    /* renamed from: j  reason: collision with root package name */
    private int f9627j;

    /* loaded from: classes.dex */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* loaded from: classes.dex */
    public static final class b implements a {
        @Override // e.b.a.p.k.x.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // e.b.a.p.k.x.k.a
        public void b(Bitmap bitmap) {
        }
    }

    /* loaded from: classes.dex */
    public static class c implements a {
        private final Set<Bitmap> a = Collections.synchronizedSet(new HashSet());

        private c() {
        }

        @Override // e.b.a.p.k.x.k.a
        public void a(Bitmap bitmap) {
            if (this.a.contains(bitmap)) {
                this.a.remove(bitmap);
                return;
            }
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }

        @Override // e.b.a.p.k.x.k.a
        public void b(Bitmap bitmap) {
            if (!this.a.contains(bitmap)) {
                this.a.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }
    }

    public k(long j2, l lVar, Set<Bitmap.Config> set) {
        this.f9620c = j2;
        this.f9622e = j2;
        this.a = lVar;
        this.b = set;
        this.f9621d = new b();
    }

    @TargetApi(26)
    private static void h(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    private static Bitmap i(int i2, int i3, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f9619l;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    private void j() {
        if (Log.isLoggable(f9618k, 2)) {
            k();
        }
    }

    private void k() {
        Log.v(f9618k, "Hits=" + this.f9624g + ", misses=" + this.f9625h + ", puts=" + this.f9626i + ", evictions=" + this.f9627j + ", currentSize=" + this.f9623f + ", maxSize=" + this.f9622e + "\nStrategy=" + this.a);
    }

    private void l() {
        v(this.f9622e);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> o() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            hashSet.add(null);
        }
        if (i2 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static l p() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new n();
        }
        return new e.b.a.p.k.x.c();
    }

    @Nullable
    private synchronized Bitmap q(int i2, int i3, @Nullable Bitmap.Config config) {
        Bitmap f2;
        h(config);
        f2 = this.a.f(i2, i3, config != null ? config : f9619l);
        if (f2 == null) {
            if (Log.isLoggable(f9618k, 3)) {
                Log.d(f9618k, "Missing bitmap=" + this.a.c(i2, i3, config));
            }
            this.f9625h++;
        } else {
            this.f9624g++;
            this.f9623f -= this.a.e(f2);
            this.f9621d.a(f2);
            u(f2);
        }
        if (Log.isLoggable(f9618k, 2)) {
            Log.v(f9618k, "Get bitmap=" + this.a.c(i2, i3, config));
        }
        j();
        return f2;
    }

    @TargetApi(19)
    private static void s(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private static void u(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        s(bitmap);
    }

    private synchronized void v(long j2) {
        while (this.f9623f > j2) {
            Bitmap b2 = this.a.b();
            if (b2 == null) {
                if (Log.isLoggable(f9618k, 5)) {
                    Log.w(f9618k, "Size mismatch, resetting");
                    k();
                }
                this.f9623f = 0L;
                return;
            }
            this.f9621d.a(b2);
            this.f9623f -= this.a.e(b2);
            this.f9627j++;
            if (Log.isLoggable(f9618k, 3)) {
                Log.d(f9618k, "Evicting bitmap=" + this.a.a(b2));
            }
            j();
            b2.recycle();
        }
    }

    @Override // e.b.a.p.k.x.e
    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (Log.isLoggable(f9618k, 3)) {
            Log.d(f9618k, "trimMemory, level=" + i2);
        }
        if (i2 >= 40 || (Build.VERSION.SDK_INT >= 23 && i2 >= 20)) {
            b();
        } else if (i2 >= 20 || i2 == 15) {
            v(e() / 2);
        }
    }

    @Override // e.b.a.p.k.x.e
    public void b() {
        if (Log.isLoggable(f9618k, 3)) {
            Log.d(f9618k, "clearMemory");
        }
        v(0L);
    }

    @Override // e.b.a.p.k.x.e
    public synchronized void c(float f2) {
        this.f9622e = Math.round(((float) this.f9620c) * f2);
        l();
    }

    @Override // e.b.a.p.k.x.e
    public synchronized void d(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.a.e(bitmap) <= this.f9622e && this.b.contains(bitmap.getConfig())) {
                        int e2 = this.a.e(bitmap);
                        this.a.d(bitmap);
                        this.f9621d.b(bitmap);
                        this.f9626i++;
                        this.f9623f += e2;
                        if (Log.isLoggable(f9618k, 2)) {
                            Log.v(f9618k, "Put bitmap in pool=" + this.a.a(bitmap));
                        }
                        j();
                        l();
                        return;
                    }
                    if (Log.isLoggable(f9618k, 2)) {
                        Log.v(f9618k, "Reject bitmap from pool, bitmap: " + this.a.a(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.b.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // e.b.a.p.k.x.e
    public long e() {
        return this.f9622e;
    }

    @Override // e.b.a.p.k.x.e
    @NonNull
    public Bitmap f(int i2, int i3, Bitmap.Config config) {
        Bitmap q = q(i2, i3, config);
        if (q != null) {
            q.eraseColor(0);
            return q;
        }
        return i(i2, i3, config);
    }

    @Override // e.b.a.p.k.x.e
    @NonNull
    public Bitmap g(int i2, int i3, Bitmap.Config config) {
        Bitmap q = q(i2, i3, config);
        return q == null ? i(i2, i3, config) : q;
    }

    public long m() {
        return this.f9627j;
    }

    public long n() {
        return this.f9623f;
    }

    public long r() {
        return this.f9624g;
    }

    public long t() {
        return this.f9625h;
    }

    public k(long j2) {
        this(j2, p(), o());
    }

    public k(long j2, Set<Bitmap.Config> set) {
        this(j2, p(), set);
    }
}
