package g.a.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.RSRuntimeException;
import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: e  reason: collision with root package name */
    private static final int f14756e = 1;

    /* renamed from: f  reason: collision with root package name */
    private static final String f14757f = "jp.wasabeef.glide.transformations.BlurTransformation.1";

    /* renamed from: g  reason: collision with root package name */
    private static final int f14758g = 25;

    /* renamed from: h  reason: collision with root package name */
    private static final int f14759h = 1;

    /* renamed from: c  reason: collision with root package name */
    private final int f14760c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14761d;

    public b() {
        this(25, 1);
    }

    @Override // g.a.a.a.a
    public Bitmap b(@NonNull Context context, @NonNull e.b.a.p.k.x.e pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        int width = toTransform.getWidth();
        int height = toTransform.getHeight();
        int i2 = this.f14761d;
        Bitmap f2 = pool.f(width / i2, height / i2, Bitmap.Config.ARGB_8888);
        a(toTransform, f2);
        Canvas canvas = new Canvas(f2);
        int i3 = this.f14761d;
        canvas.scale(1.0f / i3, 1.0f / i3);
        Paint paint = new Paint();
        paint.setFlags(2);
        canvas.drawBitmap(toTransform, 0.0f, 0.0f, paint);
        try {
            return g.a.a.a.k.b.a(context, f2, this.f14760c);
        } catch (RSRuntimeException unused) {
            return g.a.a.a.k.a.a(f2, this.f14760c, true);
        }
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public boolean equals(Object o) {
        if (o instanceof b) {
            b bVar = (b) o;
            if (bVar.f14760c == this.f14760c && bVar.f14761d == this.f14761d) {
                return true;
            }
        }
        return false;
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public int hashCode() {
        return 737513610 + (this.f14760c * 1000) + (this.f14761d * 10);
    }

    public String toString() {
        return "BlurTransformation(radius=" + this.f14760c + ", sampling=" + this.f14761d + ")";
    }

    @Override // g.a.a.a.a, e.b.a.p.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update((f14757f + this.f14760c + this.f14761d).getBytes(e.b.a.p.c.b));
    }

    public b(int radius) {
        this(radius, 1);
    }

    public b(int radius, int sampling) {
        this.f14760c = radius;
        this.f14761d = sampling;
    }
}
