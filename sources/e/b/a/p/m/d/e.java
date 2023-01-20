package e.b.a.p.m.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.EncodeStrategy;

/* loaded from: classes.dex */
public class e implements e.b.a.p.h<Bitmap> {
    public static final e.b.a.p.e<Integer> b = e.b.a.p.e.g("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: c  reason: collision with root package name */
    public static final e.b.a.p.e<Bitmap.CompressFormat> f9751c = e.b.a.p.e.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: d  reason: collision with root package name */
    private static final String f9752d = "BitmapEncoder";
    @Nullable
    private final e.b.a.p.k.x.b a;

    public e(@NonNull e.b.a.p.k.x.b bVar) {
        this.a = bVar;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, e.b.a.p.f fVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) fVar.a(f9751c);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // e.b.a.p.h
    @NonNull
    public EncodeStrategy b(@NonNull e.b.a.p.f fVar) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
        if (r6 != null) goto L14;
     */
    @Override // e.b.a.p.a
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(@androidx.annotation.NonNull e.b.a.p.k.s<android.graphics.Bitmap> r9, @androidx.annotation.NonNull java.io.File r10, @androidx.annotation.NonNull e.b.a.p.f r11) {
        /*
            r8 = this;
            java.lang.String r0 = "BitmapEncoder"
            java.lang.Object r9 = r9.get()
            android.graphics.Bitmap r9 = (android.graphics.Bitmap) r9
            android.graphics.Bitmap$CompressFormat r1 = r8.d(r9, r11)
            int r2 = r9.getWidth()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            int r3 = r9.getHeight()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.String r4 = "encode: [%dx%d] %s"
            e.b.a.v.p.b.d(r4, r2, r3, r1)
            long r2 = e.b.a.v.h.b()     // Catch: java.lang.Throwable -> Lc0
            e.b.a.p.e<java.lang.Integer> r4 = e.b.a.p.m.d.e.b     // Catch: java.lang.Throwable -> Lc0
            java.lang.Object r4 = r11.a(r4)     // Catch: java.lang.Throwable -> Lc0
            java.lang.Integer r4 = (java.lang.Integer) r4     // Catch: java.lang.Throwable -> Lc0
            int r4 = r4.intValue()     // Catch: java.lang.Throwable -> Lc0
            r5 = 0
            r6 = 0
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r7.<init>(r10)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            e.b.a.p.k.x.b r10 = r8.a     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            if (r10 == 0) goto L45
            e.b.a.p.j.c r10 = new e.b.a.p.j.c     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            e.b.a.p.k.x.b r6 = r8.a     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r10.<init>(r7, r6)     // Catch: java.lang.Throwable -> L51 java.io.IOException -> L54
            r6 = r10
            goto L46
        L45:
            r6 = r7
        L46:
            r9.compress(r1, r4, r6)     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r6.close()     // Catch: java.lang.Throwable -> L57 java.io.IOException -> L59
            r5 = 1
        L4d:
            r6.close()     // Catch: java.io.IOException -> L69 java.lang.Throwable -> Lc0
            goto L69
        L51:
            r9 = move-exception
            r6 = r7
            goto Lba
        L54:
            r10 = move-exception
            r6 = r7
            goto L5a
        L57:
            r9 = move-exception
            goto Lba
        L59:
            r10 = move-exception
        L5a:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L57
            if (r4 == 0) goto L66
            java.lang.String r4 = "Failed to encode Bitmap"
            android.util.Log.d(r0, r4, r10)     // Catch: java.lang.Throwable -> L57
        L66:
            if (r6 == 0) goto L69
            goto L4d
        L69:
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r0, r10)     // Catch: java.lang.Throwable -> Lc0
            if (r10 == 0) goto Lb6
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc0
            r10.<init>()     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r4 = "Compressed with type: "
            r10.append(r4)     // Catch: java.lang.Throwable -> Lc0
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r1 = " of size "
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc0
            int r1 = e.b.a.v.n.h(r9)     // Catch: java.lang.Throwable -> Lc0
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r1 = " in "
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc0
            double r1 = e.b.a.v.h.a(r2)     // Catch: java.lang.Throwable -> Lc0
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r1 = ", options format: "
            r10.append(r1)     // Catch: java.lang.Throwable -> Lc0
            e.b.a.p.e<android.graphics.Bitmap$CompressFormat> r1 = e.b.a.p.m.d.e.f9751c     // Catch: java.lang.Throwable -> Lc0
            java.lang.Object r11 = r11.a(r1)     // Catch: java.lang.Throwable -> Lc0
            r10.append(r11)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r11 = ", hasAlpha: "
            r10.append(r11)     // Catch: java.lang.Throwable -> Lc0
            boolean r9 = r9.hasAlpha()     // Catch: java.lang.Throwable -> Lc0
            r10.append(r9)     // Catch: java.lang.Throwable -> Lc0
            java.lang.String r9 = r10.toString()     // Catch: java.lang.Throwable -> Lc0
            android.util.Log.v(r0, r9)     // Catch: java.lang.Throwable -> Lc0
        Lb6:
            e.b.a.v.p.b.e()
            return r5
        Lba:
            if (r6 == 0) goto Lbf
            r6.close()     // Catch: java.io.IOException -> Lbf java.lang.Throwable -> Lc0
        Lbf:
            throw r9     // Catch: java.lang.Throwable -> Lc0
        Lc0:
            r9 = move-exception
            e.b.a.v.p.b.e()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: e.b.a.p.m.d.e.a(e.b.a.p.k.s, java.io.File, e.b.a.p.f):boolean");
    }

    @Deprecated
    public e() {
        this.a = null;
    }
}
