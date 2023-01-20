package g.a.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class h extends a {

    /* renamed from: c  reason: collision with root package name */
    private static final int f14775c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final String f14776d = "jp.wasabeef.glide.transformations.GrayscaleTransformation.1";

    @Override // g.a.a.a.a
    public Bitmap b(@NonNull Context context, @NonNull e.b.a.p.k.x.e pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap f2 = pool.f(toTransform.getWidth(), toTransform.getHeight(), toTransform.getConfig() != null ? toTransform.getConfig() : Bitmap.Config.ARGB_8888);
        a(toTransform, f2);
        Canvas canvas = new Canvas(f2);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(toTransform, 0.0f, 0.0f, paint);
        return f2;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        return o instanceof h;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return -1580689316;
    }

    public String toString() {
        return "GrayscaleTransformation()";
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f14776d.getBytes(e.b.a.p.c.b));
    }
}
