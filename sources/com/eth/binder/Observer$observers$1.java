package com.eth.binder;

import androidx.lifecycle.LifecycleOwner;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a2\u0012.\u0012,\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\b\u0012\u0004\u0012\u0002H\u0006`\b0\u00020\u0001\"\u0004\b\u0000\u0010\u0006H\n"}, d2 = {"<anonymous>", "", "Lkotlin/Pair;", "Ljava/lang/ref/WeakReference;", "Landroidx/lifecycle/LifecycleOwner;", "Lkotlin/Function1;", "R", "", "Lcom/eth/binder/ObserveAction;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class Observer$observers$1 extends Lambda implements a<List<Pair<? extends WeakReference<LifecycleOwner>, ? extends l<? super R, ? extends t1>>>> {
    public static final Observer$observers$1 INSTANCE = new Observer$observers$1();

    public Observer$observers$1() {
        super(0);
    }

    @Override // h.k2.u.a
    @d
    public final List<Pair<WeakReference<LifecycleOwner>, l<R, t1>>> invoke() {
        return new ArrayList();
    }
}
