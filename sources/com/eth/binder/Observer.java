package com.eth.binder;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.qcloud.tuicore.TUIConstants;
import h.k2.u.l;
import h.t1;
import h.w;
import h.z;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J0\u0010\r\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00028\u0000`\fJ\u0013\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012RD\u0010\u0004\u001a8\u00124\u00122\u0012.\u0012,\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00028\u0000`\f0\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/eth/binder/Observer;", "R", "", "()V", "observers", "Lkotlin/Lazy;", "", "Lkotlin/Pair;", "Ljava/lang/ref/WeakReference;", "Landroidx/lifecycle/LifecycleOwner;", "Lkotlin/Function1;", "", "Lcom/eth/binder/ObserveAction;", "addObserver", TUIConstants.TUIChat.OWNER, "action", "setValue", "value", "(Ljava/lang/Object;)V", "eth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class Observer<R> {
    @d
    private final w<List<Pair<WeakReference<LifecycleOwner>, l<R, t1>>>> a = z.c(Observer$observers$1.INSTANCE);

    public static /* synthetic */ void c(Observer observer, LifecycleOwner lifecycleOwner, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            lifecycleOwner = null;
        }
        observer.b(lifecycleOwner, lVar);
    }

    public final void b(@e final LifecycleOwner lifecycleOwner, @d l<? super R, t1> lVar) {
        final Pair<WeakReference<LifecycleOwner>, l<R, t1>> pair;
        Lifecycle lifecycle;
        if (lifecycleOwner == null) {
            pair = new Pair<>(null, lVar);
        } else {
            pair = new Pair<>(new WeakReference(lifecycleOwner), lVar);
        }
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.eth.binder.Observer$addObserver$1
                @Override // androidx.lifecycle.LifecycleEventObserver
                public void onStateChanged(@d LifecycleOwner lifecycleOwner2, @d Lifecycle.Event event) {
                    w wVar;
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        WeakReference<LifecycleOwner> first = pair.getFirst();
                        if (first != null) {
                            first.clear();
                        }
                        wVar = ((Observer) this).a;
                        ((List) wVar.getValue()).remove(pair);
                        lifecycleOwner.getLifecycle().removeObserver(this);
                    }
                }
            });
        }
        this.a.getValue().add(pair);
    }

    public final void d(R r) {
        if (this.a.isInitialized()) {
            Iterator<T> it = this.a.getValue().iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                WeakReference weakReference = (WeakReference) pair.getFirst();
                if (weakReference == null) {
                    ((l) pair.getSecond()).invoke(r);
                } else {
                    LifecycleOwner lifecycleOwner = (LifecycleOwner) weakReference.get();
                    if (lifecycleOwner != null && lifecycleOwner.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
                        ((l) pair.getSecond()).invoke(r);
                    }
                }
            }
        }
    }
}
