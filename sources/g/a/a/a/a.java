package g.a.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import e.b.a.p.k.s;
import e.b.a.v.n;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public abstract class a implements e.b.a.p.i<Bitmap> {
    public void a(@NonNull Bitmap toTransform, @NonNull Bitmap canvasBitmap) {
        canvasBitmap.setDensity(toTransform.getDensity());
    }

    public abstract Bitmap b(@NonNull Context context, @NonNull e.b.a.p.k.x.e pool, @NonNull Bitmap toTransform, int outWidth, int outHeight);

    @Override // e.b.a.p.c
    public abstract boolean equals(Object o);

    @Override // e.b.a.p.c
    public abstract int hashCode();

    @Override // e.b.a.p.i
    @NonNull
    public final s<Bitmap> transform(@NonNull Context context, @NonNull s<Bitmap> resource, int outWidth, int outHeight) {
        if (n.w(outWidth, outHeight)) {
            e.b.a.p.k.x.e h2 = e.b.a.c.e(context).h();
            Bitmap bitmap = resource.get();
            if (outWidth == Integer.MIN_VALUE) {
                outWidth = bitmap.getWidth();
            }
            int i2 = outWidth;
            if (outHeight == Integer.MIN_VALUE) {
                outHeight = bitmap.getHeight();
            }
            Bitmap b = b(context.getApplicationContext(), h2, bitmap, i2, outHeight);
            return bitmap.equals(b) ? resource : e.b.a.p.m.d.g.d(b, h2);
        }
        throw new IllegalArgumentException("Cannot apply transformation on width: " + outWidth + " or height: " + outHeight + " less than or equal to zero and not Target.SIZE_ORIGINAL");
    }

    @Override // e.b.a.p.c
    public abstract void updateDiskCacheKey(@NonNull MessageDigest messageDigest);
}
