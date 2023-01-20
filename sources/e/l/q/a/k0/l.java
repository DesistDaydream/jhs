package e.l.q.a.k0;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class l extends k {

    /* renamed from: c */
    private final float f14127c;

    /* renamed from: d */
    private final int f14128d;

    /* renamed from: e */
    private final int f14129e;
    @k.e.a.d

    /* renamed from: f */
    private final ArgbEvaluator f14130f;

    public l(float f2, @k.e.a.d View view) {
        super(view);
        this.f14127c = f2;
        this.f14129e = Color.argb((int) (f2 * 255), 0, 0, 0);
        this.f14130f = new ArgbEvaluator();
    }

    public static final void i(l lVar, ValueAnimator valueAnimator) {
        View d2 = lVar.d();
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        d2.setBackgroundColor(((Integer) animatedValue).intValue());
    }

    public static final void j(l lVar, ValueAnimator valueAnimator) {
        View d2 = lVar.d();
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        d2.setBackgroundColor(((Integer) animatedValue).intValue());
    }

    public static /* synthetic */ void l(l lVar, ValueAnimator valueAnimator) {
        i(lVar, valueAnimator);
    }

    public static /* synthetic */ void m(l lVar, ValueAnimator valueAnimator) {
        j(lVar, valueAnimator);
    }

    @Override // e.l.q.a.k0.k
    public void a() {
        ValueAnimator ofObject = ValueAnimator.ofObject(this.f14130f, Integer.valueOf(this.f14129e), Integer.valueOf(this.f14128d));
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: e.l.q.a.k0.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                l.l(l.this, valueAnimator);
            }
        });
        ofObject.setInterpolator(new FastOutSlowInInterpolator());
        ofObject.setDuration(c()).start();
    }

    @Override // e.l.q.a.k0.k
    public void b() {
        ValueAnimator ofObject = ValueAnimator.ofObject(this.f14130f, Integer.valueOf(this.f14128d), Integer.valueOf(this.f14129e));
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: e.l.q.a.k0.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                l.m(l.this, valueAnimator);
            }
        });
        ofObject.setInterpolator(new FastOutSlowInInterpolator());
        ofObject.setDuration(c()).start();
    }

    @Override // e.l.q.a.k0.k
    public void e() {
        d().setBackgroundColor(this.f14128d);
    }

    public final float k() {
        return this.f14127c;
    }
}
