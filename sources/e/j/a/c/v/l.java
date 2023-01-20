package e.j.a.c.v;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.R;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class l extends h<ObjectAnimator> {

    /* renamed from: l */
    private static final int f11050l = 1800;

    /* renamed from: m */
    private static final int[] f11051m = {533, 567, 850, 750};
    private static final int[] n = {1267, 1000, 333, 0};
    private static final Property<l, Float> o = new b(Float.class, "animationFraction");

    /* renamed from: d */
    private ObjectAnimator f11052d;

    /* renamed from: e */
    private final Interpolator[] f11053e;

    /* renamed from: f */
    private final e.j.a.c.v.b f11054f;

    /* renamed from: g */
    private int f11055g;

    /* renamed from: h */
    private boolean f11056h;

    /* renamed from: i */
    private float f11057i;

    /* renamed from: j */
    private boolean f11058j;

    /* renamed from: k */
    public Animatable2Compat.AnimationCallback f11059k;

    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
            l.this = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (l.this.f11058j) {
                l.this.f11052d.setRepeatCount(-1);
                l lVar = l.this;
                lVar.f11059k.onAnimationEnd(lVar.a);
                l.this.f11058j = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            l lVar = l.this;
            lVar.f11055g = (lVar.f11055g + 1) % l.this.f11054f.f11008c.length;
            l.this.f11056h = true;
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends Property<l, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(l lVar) {
            return Float.valueOf(lVar.q());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(l lVar, Float f2) {
            lVar.u(f2.floatValue());
        }
    }

    public l(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.f11055g = 0;
        this.f11059k = null;
        this.f11054f = linearProgressIndicatorSpec;
        this.f11053e = new Interpolator[]{AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line1_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line1_tail_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line2_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.animator.linear_indeterminate_line2_tail_interpolator)};
    }

    public float q() {
        return this.f11057i;
    }

    private void r() {
        if (this.f11052d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, o, 0.0f, 1.0f);
            this.f11052d = ofFloat;
            ofFloat.setDuration(1800L);
            this.f11052d.setInterpolator(null);
            this.f11052d.setRepeatCount(-1);
            this.f11052d.addListener(new a());
        }
    }

    private void s() {
        if (this.f11056h) {
            Arrays.fill(this.f11037c, e.j.a.c.l.a.a(this.f11054f.f11008c[this.f11055g], this.a.getAlpha()));
            this.f11056h = false;
        }
    }

    private void v(int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            this.b[i3] = Math.max(0.0f, Math.min(1.0f, this.f11053e[i3].getInterpolation(b(i2, n[i3], f11051m[i3]))));
        }
    }

    @Override // e.j.a.c.v.h
    public void a() {
        ObjectAnimator objectAnimator = this.f11052d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // e.j.a.c.v.h
    public void c() {
        t();
    }

    @Override // e.j.a.c.v.h
    public void d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.f11059k = animationCallback;
    }

    @Override // e.j.a.c.v.h
    public void f() {
        if (this.a.isVisible()) {
            this.f11058j = true;
            this.f11052d.setRepeatCount(0);
            return;
        }
        a();
    }

    @Override // e.j.a.c.v.h
    public void g() {
        r();
        t();
        this.f11052d.start();
    }

    @Override // e.j.a.c.v.h
    public void h() {
        this.f11059k = null;
    }

    @VisibleForTesting
    public void t() {
        this.f11055g = 0;
        int a2 = e.j.a.c.l.a.a(this.f11054f.f11008c[0], this.a.getAlpha());
        int[] iArr = this.f11037c;
        iArr[0] = a2;
        iArr[1] = a2;
    }

    @VisibleForTesting
    public void u(float f2) {
        this.f11057i = f2;
        v((int) (f2 * 1800.0f));
        s();
        this.a.invalidateSelf();
    }
}
