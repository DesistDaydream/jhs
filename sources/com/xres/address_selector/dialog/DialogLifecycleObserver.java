package com.xres.address_selector.dialog;

import androidx.annotation.RestrictTo;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import h.k2.u.a;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0004H\u0007R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/xres/address_selector/dialog/DialogLifecycleObserver;", "Landroidx/lifecycle/LifecycleObserver;", "dismiss", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "onDismiss", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes3.dex */
public final class DialogLifecycleObserver implements LifecycleObserver {
    @d
    private final a<t1> a;

    public DialogLifecycleObserver(@d a<t1> aVar) {
        this.a = aVar;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDismiss() {
        this.a.invoke();
    }
}
