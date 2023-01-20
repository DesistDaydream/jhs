package e.l.r;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import h.t1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import kotlin.Result;

/* loaded from: classes2.dex */
public final class g0 {
    @k.e.a.d
    public static final a a = new a(null);
    @k.e.a.d
    public static final String b = "content";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public static final String f14275c = "file";

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int i2, int i3, int i4, int i5) {
            double min = Math.min(i2 / i4, i3 / i5);
            float f2 = 1.0f;
            while (2 * f2 <= min) {
                f2 *= 2.0f;
            }
            return (int) f2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int i2, int i3, int i4, int i5) {
            if (i2 == 0 && i3 == 0) {
                return i4;
            }
            if (i2 == 0) {
                return (int) (i4 * (i3 / i5));
            } else if (i3 == 0) {
                return i2;
            } else {
                double d2 = i5 / i4;
                double d3 = i3;
                return ((double) i2) * d2 > d3 ? (int) (d3 / d2) : i2;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {
        @k.e.a.d

        /* renamed from: g  reason: collision with root package name */
        public static final a f14276g = new a(null);

        /* renamed from: h  reason: collision with root package name */
        public static final int f14277h = 1080;

        /* renamed from: i  reason: collision with root package name */
        public static final int f14278i = 1920;
        @k.e.a.e

        /* renamed from: c  reason: collision with root package name */
        private File f14279c;
        @k.e.a.e

        /* renamed from: f  reason: collision with root package name */
        private Uri f14282f;
        private int a = f14277h;
        private int b = f14278i;
        @k.e.a.d

        /* renamed from: d  reason: collision with root package name */
        private Bitmap.CompressFormat f14280d = Bitmap.CompressFormat.JPEG;

        /* renamed from: e  reason: collision with root package name */
        private int f14281e = 90;

        /* loaded from: classes2.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(h.k2.v.u uVar) {
                this();
            }
        }

        @k.e.a.e
        public final File a() {
            return this.f14279c;
        }

        @k.e.a.d
        public final Bitmap.CompressFormat b() {
            return this.f14280d;
        }

        public final int c() {
            return this.b;
        }

        public final int d() {
            return this.a;
        }

        public final int e() {
            return this.f14281e;
        }

        @k.e.a.e
        public final Uri f() {
            return this.f14282f;
        }

        public final void g(@k.e.a.e File file) {
            this.f14279c = file;
        }

        public final void h(@k.e.a.d Bitmap.CompressFormat compressFormat) {
            this.f14280d = compressFormat;
        }

        public final void i(int i2) {
            this.b = i2;
        }

        public final void j(int i2) {
            this.a = i2;
        }

        public final void k(int i2) {
            this.f14281e = i2;
        }

        public final void l(@k.e.a.e Uri uri) {
            this.f14282f = uri;
        }
    }

    private final void a(b bVar, Bitmap bitmap) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(bVar.a());
        } catch (FileNotFoundException e2) {
            Log.e("ImageCompress", e2.getMessage());
            fileOutputStream = null;
        }
        bitmap.compress(bVar.b(), bVar.e(), fileOutputStream);
    }

    @SuppressLint({"Range"})
    private final String c(Context context, Uri uri) {
        String str;
        if (h.t2.u.K1("content", uri.getScheme(), true)) {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (query == null) {
                return null;
            }
            try {
                if (query.moveToNext()) {
                    try {
                        Result.a aVar = Result.Companion;
                        str = query.getString(query.getColumnIndex("_data"));
                    } catch (Throwable th) {
                        th = th;
                        str = null;
                    }
                    try {
                        Result.m106constructorimpl(t1.a);
                    } catch (Throwable th2) {
                        th = th2;
                        Result.a aVar2 = Result.Companion;
                        Result.m106constructorimpl(h.r0.a(th));
                        t1 t1Var = t1.a;
                        h.h2.b.a(query, null);
                        return str;
                    }
                } else {
                    str = null;
                }
                t1 t1Var2 = t1.a;
                h.h2.b.a(query, null);
                return str;
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    h.h2.b.a(query, th3);
                    throw th4;
                }
            }
        } else if (h.t2.u.K1("file", uri.getScheme(), true)) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    @k.e.a.e
    public final Bitmap b(@k.e.a.d Context context, @k.e.a.d b bVar) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(context.getContentResolver().openInputStream(bVar.f()), null, options);
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        a aVar = a;
        int d2 = aVar.d(bVar.d(), bVar.c(), i2, i3);
        int d3 = aVar.d(bVar.c(), bVar.d(), i3, i2);
        options.inJustDecodeBounds = false;
        options.inSampleSize = aVar.c(i2, i3, d2, d3);
        Bitmap decodeStream = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(bVar.f()), null, options);
        if (decodeStream == null) {
            return null;
        }
        if (decodeStream.getWidth() > d2 || decodeStream.getHeight() > d3) {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, d2, d3, true);
            decodeStream.recycle();
            decodeStream = createScaledBitmap;
        }
        if (bVar.a() != null) {
            a(bVar, decodeStream);
        }
        return decodeStream;
    }
}
