package g.a.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class d extends a {

    /* renamed from: d  reason: collision with root package name */
    private static final int f14763d = 1;

    /* renamed from: e  reason: collision with root package name */
    private static final String f14764e = "jp.wasabeef.glide.transformations.ColorFilterTransformation.1";

    /* renamed from: c  reason: collision with root package name */
    private final int f14765c;

    public d(int color) {
        this.f14765c = color;
    }

    @Override // g.a.a.a.a
    public Bitmap b(@NonNull Context context, @NonNull e.b.a.p.k.x.e pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap f2 = pool.f(toTransform.getWidth(), toTransform.getHeight(), toTransform.getConfig() != null ? toTransform.getConfig() : Bitmap.Config.ARGB_8888);
        a(toTransform, f2);
        Canvas canvas = new Canvas(f2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColorFilter(new PorterDuffColorFilter(this.f14765c, PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(toTransform, 0.0f, 0.0f, paint);
        return f2;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        return (o instanceof d) && ((d) o).f14765c == this.f14765c;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return 705373712 + (this.f14765c * 10);
    }

    public String toString() {
        return "ColorFilterTransformation(color=" + this.f14765c + ")";
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f14764e + this.f14765c).getBytes(e.b.a.p.c.b));
    }
}
