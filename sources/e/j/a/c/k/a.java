package e.j.a.c.k;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;
import e.j.a.c.k.c;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: e.j.a.c.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0365a extends AnimatorListenerAdapter {
        public final /* synthetic */ c a;

        public C0365a(c cVar) {
            this.a = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.b();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.a();
        }
    }

    private a() {
    }

    @NonNull
    public static Animator a(@NonNull c cVar, float f2, float f3, float f4) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(cVar, (Property<c, V>) c.C0367c.a, (TypeEvaluator) c.b.b, (Object[]) new c.e[]{new c.e(f2, f3, f4)});
        if (Build.VERSION.SDK_INT >= 21) {
            c.e revealInfo = cVar.getRevealInfo();
            if (revealInfo != null) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) cVar, (int) f2, (int) f3, revealInfo.f10868c, f4);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(ofObject, createCircularReveal);
                return animatorSet;
            }
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        return ofObject;
    }

    @NonNull
    public static Animator b(c cVar, float f2, float f3, float f4, float f5) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(cVar, (Property<c, V>) c.C0367c.a, (TypeEvaluator) c.b.b, (Object[]) new c.e[]{new c.e(f2, f3, f4), new c.e(f2, f3, f5)});
        if (Build.VERSION.SDK_INT >= 21) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) cVar, (int) f2, (int) f3, f4, f5);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofObject, createCircularReveal);
            return animatorSet;
        }
        return ofObject;
    }

    @NonNull
    public static Animator.AnimatorListener c(@NonNull c cVar) {
        return new C0365a(cVar);
    }
}
