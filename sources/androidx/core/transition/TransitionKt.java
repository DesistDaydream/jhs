package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\u001aÉ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00022#\b\u0006\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00042#\b\u0006\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u001a5\u0010\r\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u001a5\u0010\u000f\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u001a5\u0010\u0010\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u001a5\u0010\u0011\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u001a5\u0010\u0012\u001a\u00020\u0001*\u00020\u00022#\b\u0004\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"addListener", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "onEnd", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "transition", "", "onStart", "onCancel", "onResume", "onPause", "doOnCancel", "action", "doOnEnd", "doOnPause", "doOnResume", "doOnStart", "core-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class TransitionKt {
    @RequiresApi(19)
    @d
    public static final Transition.TransitionListener addListener(@d Transition transition, @d l<? super Transition, t1> lVar, @d l<? super Transition, t1> lVar2, @d l<? super Transition, t1> lVar3, @d l<? super Transition, t1> lVar4, @d l<? super Transition, t1> lVar5) {
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(lVar, lVar4, lVar5, lVar3, lVar2);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition transition, l lVar, l lVar2, l lVar3, l lVar4, l lVar5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lVar = TransitionKt$addListener$1.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            lVar2 = TransitionKt$addListener$2.INSTANCE;
        }
        l lVar6 = lVar2;
        if ((i2 & 4) != 0) {
            lVar3 = TransitionKt$addListener$3.INSTANCE;
        }
        l lVar7 = lVar3;
        if ((i2 & 8) != 0) {
            lVar4 = TransitionKt$addListener$4.INSTANCE;
        }
        if ((i2 & 16) != 0) {
            lVar5 = TransitionKt$addListener$5.INSTANCE;
        }
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(lVar, lVar4, lVar5, lVar7, lVar6);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @RequiresApi(19)
    @d
    public static final Transition.TransitionListener doOnCancel(@d Transition transition, @d final l<? super Transition, t1> lVar) {
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@d Transition transition2) {
                l.this.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@d Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@d Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@d Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@d Transition transition2) {
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @d
    public static final Transition.TransitionListener doOnEnd(@d Transition transition, @d final l<? super Transition, t1> lVar) {
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@d Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@d Transition transition2) {
                l.this.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@d Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@d Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@d Transition transition2) {
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @d
    public static final Transition.TransitionListener doOnPause(@d Transition transition, @d final l<? super Transition, t1> lVar) {
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@d Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@d Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@d Transition transition2) {
                l.this.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@d Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@d Transition transition2) {
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @d
    public static final Transition.TransitionListener doOnResume(@d Transition transition, @d final l<? super Transition, t1> lVar) {
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@d Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@d Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@d Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@d Transition transition2) {
                l.this.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@d Transition transition2) {
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    @d
    public static final Transition.TransitionListener doOnStart(@d Transition transition, @d final l<? super Transition, t1> lVar) {
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(@d Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(@d Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(@d Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(@d Transition transition2) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(@d Transition transition2) {
                l.this.invoke(transition2);
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }
}
