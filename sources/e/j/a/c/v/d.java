package e.j.a.c.v;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;

/* loaded from: classes2.dex */
public final class d extends h<ObjectAnimator> {

    /* renamed from: l */
    private static final int f11016l = 4;

    /* renamed from: m */
    private static final int f11017m = 5400;
    private static final int n = 667;
    private static final int o = 667;
    private static final int p = 333;
    private static final int q = 333;
    private static final int u = -20;
    private static final int v = 250;
    private static final int w = 1520;

    /* renamed from: d */
    private ObjectAnimator f11018d;

    /* renamed from: e */
    private ObjectAnimator f11019e;

    /* renamed from: f */
    private final FastOutSlowInInterpolator f11020f;

    /* renamed from: g */
    private final e.j.a.c.v.b f11021g;

    /* renamed from: h */
    private int f11022h;

    /* renamed from: i */
    private float f11023i;

    /* renamed from: j */
    private float f11024j;

    /* renamed from: k */
    public Animatable2Compat.AnimationCallback f11025k;
    private static final int[] r = {0, 1350, 2700, 4050};
    private static final int[] s = {667, 2017, 3367, 4717};
    private static final int[] t = {1000, 2350, 3700, 5050};
    private static final Property<d, Float> x = new c(Float.class, "animationFraction");
    private static final Property<d, Float> y = new C0372d(Float.class, "completeEndFraction");

    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
            d.this = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            d dVar = d.this;
            dVar.f11022h = (dVar.f11022h + 4) % d.this.f11021g.f11008c.length;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
            d.this = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            d.this.a();
            d dVar = d.this;
            dVar.f11025k.onAnimationEnd(dVar.a);
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends Property<d, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(d dVar) {
            return Float.valueOf(dVar.o());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(d dVar, Float f2) {
            dVar.t(f2.floatValue());
        }
    }

    /* renamed from: e.j.a.c.v.d$d */
    /* loaded from: classes2.dex */
    public static class C0372d extends Property<d, Float> {
        public C0372d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(d dVar) {
            return Float.valueOf(dVar.p());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(d dVar, Float f2) {
            dVar.u(f2.floatValue());
        }
    }

    public d(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f11022h = 0;
        this.f11025k = null;
        this.f11021g = circularProgressIndicatorSpec;
        this.f11020f = new FastOutSlowInInterpolator();
    }

    public float o() {
        return this.f11023i;
    }

    public float p() {
        return this.f11024j;
    }

    private void q() {
        if (this.f11018d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, x, 0.0f, 1.0f);
            this.f11018d = ofFloat;
            ofFloat.setDuration(5400L);
            this.f11018d.setInterpolator(null);
            this.f11018d.setRepeatCount(-1);
            this.f11018d.addListener(new a());
        }
        if (this.f11019e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, y, 0.0f, 1.0f);
            this.f11019e = ofFloat2;
            ofFloat2.setDuration(333L);
            this.f11019e.setInterpolator(this.f11020f);
            this.f11019e.addListener(new b());
        }
    }

    private void r(int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            float b2 = b(i2, t[i3], 333);
            if (b2 >= 0.0f && b2 <= 1.0f) {
                int i4 = i3 + this.f11022h;
                int[] iArr = this.f11021g.f11008c;
                int length = i4 % iArr.length;
                int a2 = e.j.a.c.l.a.a(iArr[length], this.a.getAlpha());
                int a3 = e.j.a.c.l.a.a(this.f11021g.f11008c[(length + 1) % iArr.length], this.a.getAlpha());
                this.f11037c[0] = e.j.a.c.a.c.b().evaluate(this.f11020f.getInterpolation(b2), Integer.valueOf(a2), Integer.valueOf(a3)).intValue();
                return;
            }
        }
    }

    public void u(float f2) {
        this.f11024j = f2;
    }

    private void v(int i2) {
        float[] fArr = this.b;
        float f2 = this.f11023i;
        fArr[0] = (f2 * 1520.0f) - 20.0f;
        fArr[1] = f2 * 1520.0f;
        for (int i3 = 0; i3 < 4; i3++) {
            float b2 = b(i2, r[i3], 667);
            float[] fArr2 = this.b;
            fArr2[1] = fArr2[1] + (this.f11020f.getInterpolation(b2) * 250.0f);
            float b3 = b(i2, s[i3], 667);
            float[] fArr3 = this.b;
            fArr3[0] = fArr3[0] + (this.f11020f.getInterpolation(b3) * 250.0f);
        }
        float[] fArr4 = this.b;
        fArr4[0] = fArr4[0] + ((fArr4[1] - fArr4[0]) * this.f11024j);
        fArr4[0] = fArr4[0] / 360.0f;
        fArr4[1] = fArr4[1] / 360.0f;
    }

    @Override // e.j.a.c.v.h
    public void a() {
        ObjectAnimator objectAnimator = this.f11018d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // e.j.a.c.v.h
    public void c() {
        s();
    }

    @Override // e.j.a.c.v.h
    public void d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.f11025k = animationCallback;
    }

    @Override // e.j.a.c.v.h
    public void f() {
        if (this.f11019e.isRunning()) {
            return;
        }
        if (this.a.isVisible()) {
            this.f11019e.start();
        } else {
            a();
        }
    }

    @Override // e.j.a.c.v.h
    public void g() {
        q();
        s();
        this.f11018d.start();
    }

    @Override // e.j.a.c.v.h
    public void h() {
        this.f11025k = null;
    }

    @VisibleForTesting
    public void s() {
        this.f11022h = 0;
        this.f11037c[0] = e.j.a.c.l.a.a(this.f11021g.f11008c[0], this.a.getAlpha());
        this.f11024j = 0.0f;
    }

    @VisibleForTesting
    public void t(float f2) {
        this.f11023i = f2;
        int i2 = (int) (f2 * 5400.0f);
        v(i2);
        r(i2);
        this.a.invalidateSelf();
    }
}
