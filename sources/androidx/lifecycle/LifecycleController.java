package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import i.b.b2;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082\b¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/lifecycle/LifecycleController;", "", "Li/b/b2;", "parentJob", "Lh/t1;", "handleDestroy", "(Li/b/b2;)V", "finish", "()V", "Landroidx/lifecycle/DispatchQueue;", "dispatchQueue", "Landroidx/lifecycle/DispatchQueue;", "Landroidx/lifecycle/Lifecycle$State;", "minState", "Landroidx/lifecycle/Lifecycle$State;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/LifecycleEventObserver;", "observer", "Landroidx/lifecycle/LifecycleEventObserver;", "<init>", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/DispatchQueue;Li/b/b2;)V", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 4, 1})
@MainThread
/* loaded from: classes.dex */
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(@d Lifecycle lifecycle, @d Lifecycle.State state, @d DispatchQueue dispatchQueue, @d final b2 b2Var) {
        this.lifecycle = lifecycle;
        this.minState = state;
        this.dispatchQueue = dispatchQueue;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.LifecycleController$observer$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(@d LifecycleOwner lifecycleOwner, @d Lifecycle.Event event) {
                Lifecycle.State state2;
                DispatchQueue dispatchQueue2;
                DispatchQueue dispatchQueue3;
                if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                    LifecycleController lifecycleController = LifecycleController.this;
                    b2.a.b(b2Var, null, 1, null);
                    lifecycleController.finish();
                    return;
                }
                Lifecycle.State currentState = lifecycleOwner.getLifecycle().getCurrentState();
                state2 = LifecycleController.this.minState;
                if (currentState.compareTo(state2) < 0) {
                    dispatchQueue3 = LifecycleController.this.dispatchQueue;
                    dispatchQueue3.pause();
                    return;
                }
                dispatchQueue2 = LifecycleController.this.dispatchQueue;
                dispatchQueue2.resume();
            }
        };
        this.observer = lifecycleEventObserver;
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            b2.a.b(b2Var, null, 1, null);
            finish();
            return;
        }
        lifecycle.addObserver(lifecycleEventObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDestroy(b2 b2Var) {
        b2.a.b(b2Var, null, 1, null);
        finish();
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
