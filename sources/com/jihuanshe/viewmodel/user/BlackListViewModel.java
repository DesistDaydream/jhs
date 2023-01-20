package com.jihuanshe.viewmodel.user;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.BanUser;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.k;
import h.t1;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class BlackListViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<List<BanUser>> f4564c = new NLive<>(null, 1, null);

    public static /* synthetic */ a s0(BlackListViewModel blackListViewModel, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            state = null;
        }
        return blackListViewModel.r0(state);
    }

    @d
    public final NLive<List<BanUser>> q0() {
        return this.f4564c;
    }

    @d
    public final a<e<BanUser>> r0(@k.e.a.e LoadMore.State state) {
        return a.h(a.o(BinderKt.b(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).m(this.b.a(state).d())), this.f4564c, this.b.f()), null, new BlackListViewModel$getUser$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> t0(@d BanUser banUser) {
        return a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).o0(banUser.getUid())), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
