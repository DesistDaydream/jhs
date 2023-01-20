package g.a.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class i extends a {

    /* renamed from: d  reason: collision with root package name */
    private static final int f14777d = 1;

    /* renamed from: e  reason: collision with root package name */
    private static final String f14778e = "jp.wasabeef.glide.transformations.MaskTransformation.1";

    /* renamed from: f  reason: collision with root package name */
    private static final Paint f14779f;

    /* renamed from: c  reason: collision with root package name */
    private final int f14780c;

    static {
        Paint paint = new Paint();
        f14779f = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public i(int maskId) {
        this.f14780c = maskId;
    }

    @Override // g.a.a.a.a
    public Bitmap b(@NonNull Context context, @NonNull e.b.a.p.k.x.e pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        int width = toTransform.getWidth();
        int height = toTransform.getHeight();
        Bitmap f2 = pool.f(width, height, Bitmap.Config.ARGB_8888);
        f2.setHasAlpha(true);
        Drawable drawable = context.getDrawable(this.f14780c);
        a(toTransform, f2);
        Canvas canvas = new Canvas(f2);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        canvas.drawBitmap(toTransform, 0.0f, 0.0f, f14779f);
        return f2;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        return (o instanceof i) && ((i) o).f14780c == this.f14780c;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return (-1949385457) + (this.f14780c * 10);
    }

    public String toString() {
        return "MaskTransformation(maskId=" + this.f14780c + ")";
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f14778e + this.f14780c).getBytes(e.b.a.p.c.b));
    }
}
