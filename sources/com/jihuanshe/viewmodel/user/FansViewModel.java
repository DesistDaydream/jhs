package com.jihuanshe.viewmodel.user;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.User;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.v;
import e.l.n.c.w;
import h.t1;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class FansViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<List<User>> f4567c = new NLive<>(null, 1, null);

    public static /* synthetic */ a t0(FansViewModel fansViewModel, int i2, LoadMore.State state, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            state = null;
        }
        return fansViewModel.s0(i2, state);
    }

    @d
    public final a<t1> q0(int i2) {
        return a.h(FlowKt.c(((w) e.l.n.a.d(w.class, false, false, false, 60L, true)).b(i2)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<User>> r0() {
        return this.f4567c;
    }

    @d
    public final a<e<User>> s0(int i2, @k.e.a.e LoadMore.State state) {
        return a.h(a.o(BinderKt.b(FlowKt.c(((v) e.l.n.a.d(v.class, true, false, false, 60L, true)).c(i2, this.b.a(state).d())), this.f4567c, this.b.f()), null, new FansViewModel$getUser$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
