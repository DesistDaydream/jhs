package androidx.core.animation;

import android.animation.Animator;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"androidx/core/animation/AnimatorKt$addPauseListener$listener$1", "Landroid/animation/Animator$AnimatorPauseListener;", "onAnimationPause", "", "animator", "Landroid/animation/Animator;", "onAnimationResume", "core-ktx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AnimatorKt$addPauseListener$listener$1 implements Animator.AnimatorPauseListener {
    public final /* synthetic */ l<Animator, t1> $onPause;
    public final /* synthetic */ l<Animator, t1> $onResume;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimatorKt$addPauseListener$listener$1(l<? super Animator, t1> lVar, l<? super Animator, t1> lVar2) {
        this.$onPause = lVar;
        this.$onResume = lVar2;
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationPause(@d Animator animator) {
        this.$onPause.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationResume(@d Animator animator) {
        this.$onResume.invoke(animator);
    }
}
