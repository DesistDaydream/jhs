package com.jihuanshe.viewmodel.user;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CoinLog;
import com.jihuanshe.model.User;
import com.jihuanshe.model.WithDrawResult;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.i;
import e.l.n.c.k;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public class CoinViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<List<CoinLog>> f4565c = new NLive<>(null, 1, null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private final NLive<User> f4566d = new NLive<>(null, 1, null);

    public static /* synthetic */ a t0(CoinViewModel coinViewModel, LoadMore.State state, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                state = null;
            }
            return coinViewModel.s0(state);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getLog");
    }

    @d
    public final a<User> q0(int i2) {
        if (i2 == 0) {
            return a.h(FlowKt.a(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).M(), this.f4566d), ViewModelKt.getViewModelScope(this), null, 2, null);
        }
        return a.h(FlowKt.a(i.a.a((i) e.l.n.a.d(i.class, true, false, false, 60L, true), null, 1, null), this.f4566d), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<CoinLog>> r0() {
        return this.f4565c;
    }

    @d
    public final a<e<CoinLog>> s0(@k.e.a.e LoadMore.State state) {
        return a.h(a.o(BinderKt.b(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).e(this.b.a(state).d())), this.f4565c, this.b.f()), null, new CoinViewModel$getLog$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<User> u0() {
        return this.f4566d;
    }

    @d
    public final a<WithDrawResult> v0(int i2) {
        if (i2 == 0) {
            return a.h(a.j(FlowKt.c(k.a.w((k) e.l.n.a.d(k.class, true, false, false, 60L, true), null, 1, null)), null, new CoinViewModel$withDraw$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
        }
        return a.h(a.j(FlowKt.c(k.a.v((k) e.l.n.a.d(k.class, true, false, false, 60L, true), null, 1, null)), null, new CoinViewModel$withDraw$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
