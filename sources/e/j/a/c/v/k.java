package e.j.a.c.v;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class k extends h<ObjectAnimator> {

    /* renamed from: j */
    private static final int f11041j = 667;

    /* renamed from: k */
    private static final int f11042k = 333;

    /* renamed from: l */
    private static final Property<k, Float> f11043l = new b(Float.class, "animationFraction");

    /* renamed from: d */
    private ObjectAnimator f11044d;

    /* renamed from: e */
    private FastOutSlowInInterpolator f11045e;

    /* renamed from: f */
    private final e.j.a.c.v.b f11046f;

    /* renamed from: g */
    private int f11047g;

    /* renamed from: h */
    private boolean f11048h;

    /* renamed from: i */
    private float f11049i;

    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
            k.this = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            k kVar = k.this;
            kVar.f11047g = (kVar.f11047g + 1) % k.this.f11046f.f11008c.length;
            k.this.f11048h = true;
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends Property<k, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(k kVar) {
            return Float.valueOf(kVar.n());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(k kVar, Float f2) {
            kVar.r(f2.floatValue());
        }
    }

    public k(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f11047g = 1;
        this.f11046f = linearProgressIndicatorSpec;
        this.f11045e = new FastOutSlowInInterpolator();
    }

    public float n() {
        return this.f11049i;
    }

    private void o() {
        if (this.f11044d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f11043l, 0.0f, 1.0f);
            this.f11044d = ofFloat;
            ofFloat.setDuration(333L);
            this.f11044d.setInterpolator(null);
            this.f11044d.setRepeatCount(-1);
            this.f11044d.addListener(new a());
        }
    }

    private void p() {
        if (!this.f11048h || this.b[3] >= 1.0f) {
            return;
        }
        int[] iArr = this.f11037c;
        iArr[2] = iArr[1];
        iArr[1] = iArr[0];
        iArr[0] = e.j.a.c.l.a.a(this.f11046f.f11008c[this.f11047g], this.a.getAlpha());
        this.f11048h = false;
    }

    private void s(int i2) {
        this.b[0] = 0.0f;
        float b2 = b(i2, 0, f11041j);
        float[] fArr = this.b;
        float interpolation = this.f11045e.getInterpolation(b2);
        fArr[2] = interpolation;
        fArr[1] = interpolation;
        float[] fArr2 = this.b;
        float interpolation2 = this.f11045e.getInterpolation(b2 + 0.49925038f);
        fArr2[4] = interpolation2;
        fArr2[3] = interpolation2;
        this.b[5] = 1.0f;
    }

    @Override // e.j.a.c.v.h
    public void a() {
        ObjectAnimator objectAnimator = this.f11044d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // e.j.a.c.v.h
    public void c() {
        q();
    }

    @Override // e.j.a.c.v.h
    public void d(@Nullable Animatable2Compat.AnimationCallback animationCallback) {
    }

    @Override // e.j.a.c.v.h
    public void f() {
    }

    @Override // e.j.a.c.v.h
    public void g() {
        o();
        q();
        this.f11044d.start();
    }

    @Override // e.j.a.c.v.h
    public void h() {
    }

    @VisibleForTesting
    public void q() {
        this.f11048h = true;
        this.f11047g = 1;
        Arrays.fill(this.f11037c, e.j.a.c.l.a.a(this.f11046f.f11008c[0], this.a.getAlpha()));
    }

    @VisibleForTesting
    public void r(float f2) {
        this.f11049i = f2;
        s((int) (f2 * 333.0f));
        p();
        this.a.invalidateSelf();
    }
}
