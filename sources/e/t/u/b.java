package e.t.u;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tJ(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tJ \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00112\b\b\u0002\u0010\b\u001a\u00020\tJ\u001f\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\"\u00020\u0016¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u001a\u001a\u00020\u00192\b\u0010\f\u001a\u0004\u0018\u00010\r¨\u0006\u001b"}, d2 = {"Lcom/vector/util/AnimateUtil;", "", "()V", "ofFloatValue", "Landroid/animation/ValueAnimator;", "from", "", "to", "duration", "", "ofFloatX", "Landroid/animation/ObjectAnimator;", "view", "Landroid/view/View;", "x", "y", "ofIntValue", "", "playTogether", "Landroid/animation/AnimatorSet;", "animators", "", "Landroid/animation/Animator;", "([Landroid/animation/Animator;)Landroid/animation/AnimatorSet;", "startFlick", "", "stopFlick", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    @k.e.a.d
    public static final b a = new b();

    private b() {
    }

    public static /* synthetic */ ValueAnimator b(b bVar, float f2, float f3, long j2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j2 = 500;
        }
        return bVar.a(f2, f3, j2);
    }

    public static /* synthetic */ ObjectAnimator d(b bVar, View view, float f2, float f3, long j2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            j2 = 500;
        }
        return bVar.c(view, f2, f3, j2);
    }

    public static /* synthetic */ ValueAnimator f(b bVar, int i2, int i3, long j2, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            j2 = 500;
        }
        return bVar.e(i2, i3, j2);
    }

    @k.e.a.d
    public final ValueAnimator a(float f2, float f3, long j2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f3);
        ofFloat.setDuration(j2);
        return ofFloat;
    }

    @k.e.a.d
    public final ObjectAnimator c(@k.e.a.d View view, float f2, float f3, long j2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", f2, f3);
        ofFloat.setDuration(j2);
        return ofFloat;
    }

    @k.e.a.d
    public final ValueAnimator e(int i2, int i3, long j2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(i2, i3);
        ofInt.setDuration(j2);
        return ofInt;
    }

    @k.e.a.d
    public final AnimatorSet g(@k.e.a.d Animator... animatorArr) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether((Animator[]) Arrays.copyOf(animatorArr, animatorArr.length));
        animatorSet.start();
        return animatorSet;
    }

    public final void h(@k.e.a.e View view) {
        if (view == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.5f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillBefore(true);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setRepeatCount(-1);
        alphaAnimation.setRepeatMode(2);
        view.startAnimation(alphaAnimation);
    }

    public final void i(@k.e.a.e View view) {
        if (view == null) {
            return;
        }
        view.clearAnimation();
    }
}
