package g.a.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import e.b.a.p.m.d.d0;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class f extends a {

    /* renamed from: e  reason: collision with root package name */
    private static final int f14768e = 1;

    /* renamed from: f  reason: collision with root package name */
    private static final String f14769f = "jp.wasabeef.glide.transformations.CropCircleWithBorderTransformation.1";

    /* renamed from: c  reason: collision with root package name */
    private final int f14770c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14771d;

    public f() {
        this.f14770c = g.a.a.a.k.c.a(4);
        this.f14771d = ViewCompat.MEASURED_STATE_MASK;
    }

    @Override // g.a.a.a.a
    public Bitmap b(@NonNull Context context, @NonNull e.b.a.p.k.x.e pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        Bitmap d2 = d0.d(pool, toTransform, outWidth, outHeight);
        a(toTransform, d2);
        Paint paint = new Paint();
        paint.setColor(this.f14771d);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f14770c);
        paint.setAntiAlias(true);
        new Canvas(d2).drawCircle(outWidth / 2.0f, outHeight / 2.0f, (Math.max(outWidth, outHeight) / 2.0f) - (this.f14770c / 2.0f), paint);
        return d2;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        if (o instanceof f) {
            f fVar = (f) o;
            if (fVar.f14770c == this.f14770c && fVar.f14771d == this.f14771d) {
                return true;
            }
        }
        return false;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return 882652245 + (this.f14770c * 100) + this.f14771d + 10;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f14769f + this.f14770c + this.f14771d).getBytes(e.b.a.p.c.b));
    }

    public f(int borderSize, @ColorInt int borderColor) {
        this.f14770c = borderSize;
        this.f14771d = borderColor;
    }
}
