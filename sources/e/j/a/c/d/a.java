package e.j.a.c.d;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import e.j.a.c.z.g;
import e.j.a.c.z.q;

/* loaded from: classes2.dex */
public class a extends g implements Cloneable {

    /* renamed from: g  reason: collision with root package name */
    private static final int f10588g = 90;

    /* renamed from: h  reason: collision with root package name */
    private static final int f10589h = 180;

    /* renamed from: i  reason: collision with root package name */
    private static final int f10590i = 270;

    /* renamed from: j  reason: collision with root package name */
    private static final int f10591j = 180;

    /* renamed from: k  reason: collision with root package name */
    private static final float f10592k = 1.75f;
    private float a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f10593c;

    /* renamed from: d  reason: collision with root package name */
    private float f10594d;

    /* renamed from: e  reason: collision with root package name */
    private float f10595e;

    /* renamed from: f  reason: collision with root package name */
    private float f10596f = -1.0f;

    public a(float f2, float f3, float f4) {
        this.b = f2;
        this.a = f3;
        l(f4);
        this.f10595e = 0.0f;
    }

    @Override // e.j.a.c.z.g
    public void b(float f2, float f3, float f4, @NonNull q qVar) {
        float f5;
        float f6;
        float f7 = this.f10593c;
        if (f7 == 0.0f) {
            qVar.n(f2, 0.0f);
            return;
        }
        float f8 = ((this.b * 2.0f) + f7) / 2.0f;
        float f9 = f4 * this.a;
        float f10 = f3 + this.f10595e;
        float f11 = (this.f10594d * f4) + ((1.0f - f4) * f8);
        if (f11 / f8 >= 1.0f) {
            qVar.n(f2, 0.0f);
            return;
        }
        float f12 = this.f10596f;
        float f13 = f12 * f4;
        boolean z = f12 == -1.0f || Math.abs((f12 * 2.0f) - f7) < 0.1f;
        if (z) {
            f5 = f11;
            f6 = 0.0f;
        } else {
            f6 = 1.75f;
            f5 = 0.0f;
        }
        float f14 = f8 + f9;
        float f15 = f5 + f9;
        float sqrt = (float) Math.sqrt((f14 * f14) - (f15 * f15));
        float f16 = f10 - sqrt;
        float f17 = f10 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f15));
        float f18 = (90.0f - degrees) + f6;
        qVar.n(f16, 0.0f);
        float f19 = f9 * 2.0f;
        qVar.a(f16 - f9, 0.0f, f16 + f9, f19, 270.0f, degrees);
        if (z) {
            qVar.a(f10 - f8, (-f8) - f5, f10 + f8, f8 - f5, 180.0f - f18, (f18 * 2.0f) - 180.0f);
        } else {
            float f20 = this.b;
            float f21 = f13 * 2.0f;
            float f22 = f10 - f8;
            qVar.a(f22, -(f13 + f20), f22 + f20 + f21, f20 + f13, 180.0f - f18, ((f18 * 2.0f) - 180.0f) / 2.0f);
            float f23 = f10 + f8;
            float f24 = this.b;
            qVar.n(f23 - ((f24 / 2.0f) + f13), f24 + f13);
            float f25 = this.b;
            qVar.a(f23 - (f21 + f25), -(f13 + f25), f23, f25 + f13, 90.0f, f18 - 90.0f);
        }
        qVar.a(f17 - f9, 0.0f, f17 + f9, f19, 270.0f - degrees, degrees);
        qVar.n(f2, 0.0f);
    }

    public float e() {
        return this.f10594d;
    }

    public float f() {
        return this.f10596f;
    }

    public float g() {
        return this.b;
    }

    public float h() {
        return this.a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float j() {
        return this.f10593c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float k() {
        return this.f10595e;
    }

    public void l(@FloatRange(from = 0.0d) float f2) {
        if (f2 >= 0.0f) {
            this.f10594d = f2;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void m(float f2) {
        this.f10596f = f2;
    }

    public void n(float f2) {
        this.b = f2;
    }

    public void o(float f2) {
        this.a = f2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void p(float f2) {
        this.f10593c = f2;
    }

    public void q(float f2) {
        this.f10595e = f2;
    }
}
