package e.j.a.c.v;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;

/* loaded from: classes2.dex */
public final class c extends g<CircularProgressIndicatorSpec> {

    /* renamed from: c  reason: collision with root package name */
    private int f11012c;

    /* renamed from: d  reason: collision with root package name */
    private float f11013d;

    /* renamed from: e  reason: collision with root package name */
    private float f11014e;

    /* renamed from: f  reason: collision with root package name */
    private float f11015f;

    public c(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.f11012c = 1;
    }

    private void h(Canvas canvas, Paint paint, float f2, float f3, float f4, boolean z, RectF rectF) {
        float f5 = z ? -1.0f : 1.0f;
        canvas.save();
        canvas.rotate(f4);
        float f6 = f2 / 2.0f;
        float f7 = f5 * f3;
        canvas.drawRect((this.f11015f - f6) + f3, Math.min(0.0f, this.f11012c * f7), (this.f11015f + f6) - f3, Math.max(0.0f, f7 * this.f11012c), paint);
        canvas.translate((this.f11015f - f6) + f3, 0.0f);
        canvas.drawArc(rectF, 180.0f, (-f5) * 90.0f * this.f11012c, true, paint);
        canvas.translate(f2 - (f3 * 2.0f), 0.0f);
        canvas.drawArc(rectF, 0.0f, f5 * 90.0f * this.f11012c, true, paint);
        canvas.restore();
    }

    private int i() {
        S s = this.a;
        return ((CircularProgressIndicatorSpec) s).f3013g + (((CircularProgressIndicatorSpec) s).f3014h * 2);
    }

    @Override // e.j.a.c.v.g
    public void a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        S s;
        S s2 = this.a;
        float f3 = (((CircularProgressIndicatorSpec) s2).f3013g / 2.0f) + ((CircularProgressIndicatorSpec) s2).f3014h;
        canvas.translate(f3, f3);
        canvas.rotate(-90.0f);
        float f4 = -f3;
        canvas.clipRect(f4, f4, f3, f3);
        this.f11012c = ((CircularProgressIndicatorSpec) this.a).f3015i == 0 ? 1 : -1;
        this.f11013d = ((CircularProgressIndicatorSpec) s).a * f2;
        this.f11014e = ((CircularProgressIndicatorSpec) s).b * f2;
        this.f11015f = (((CircularProgressIndicatorSpec) s).f3013g - ((CircularProgressIndicatorSpec) s).a) / 2.0f;
        if ((this.b.k() && ((CircularProgressIndicatorSpec) this.a).f11010e == 2) || (this.b.j() && ((CircularProgressIndicatorSpec) this.a).f11011f == 1)) {
            this.f11015f += ((1.0f - f2) * ((CircularProgressIndicatorSpec) this.a).a) / 2.0f;
        } else if ((this.b.k() && ((CircularProgressIndicatorSpec) this.a).f11010e == 1) || (this.b.j() && ((CircularProgressIndicatorSpec) this.a).f11011f == 2)) {
            this.f11015f -= ((1.0f - f2) * ((CircularProgressIndicatorSpec) this.a).a) / 2.0f;
        }
    }

    @Override // e.j.a.c.v.g
    public void b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @ColorInt int i2) {
        if (f2 == f3) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(i2);
        paint.setStrokeWidth(this.f11013d);
        int i3 = this.f11012c;
        float f4 = f2 * 360.0f * i3;
        float f5 = (f3 >= f2 ? f3 - f2 : (f3 + 1.0f) - f2) * 360.0f * i3;
        float f6 = this.f11015f;
        canvas.drawArc(new RectF(-f6, -f6, f6, f6), f4, f5, false, paint);
        if (this.f11014e <= 0.0f || Math.abs(f5) >= 360.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        float f7 = this.f11014e;
        RectF rectF = new RectF(-f7, -f7, f7, f7);
        h(canvas, paint, this.f11013d, this.f11014e, f4, true, rectF);
        h(canvas, paint, this.f11013d, this.f11014e, f4 + f5, false, rectF);
    }

    @Override // e.j.a.c.v.g
    public void c(@NonNull Canvas canvas, @NonNull Paint paint) {
        int a = e.j.a.c.l.a.a(((CircularProgressIndicatorSpec) this.a).f11009d, this.b.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(a);
        paint.setStrokeWidth(this.f11013d);
        float f2 = this.f11015f;
        canvas.drawArc(new RectF(-f2, -f2, f2, f2), 0.0f, 360.0f, false, paint);
    }

    @Override // e.j.a.c.v.g
    public int d() {
        return i();
    }

    @Override // e.j.a.c.v.g
    public int e() {
        return i();
    }
}
