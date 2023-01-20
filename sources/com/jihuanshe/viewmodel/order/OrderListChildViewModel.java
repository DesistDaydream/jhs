package com.jihuanshe.viewmodel.order;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.OrderInfo;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.k;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class OrderListChildViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c */
    private final NLive<List<OrderInfo>> f4492c = new NLive<>(null, 1, null);

    public static /* synthetic */ a s0(OrderListChildViewModel orderListChildViewModel, String str, String str2, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            state = null;
        }
        return orderListChildViewModel.q0(str, str2, state);
    }

    @d
    public final a<e<OrderInfo>> q0(@d String str, @k.e.a.e String str2, @k.e.a.e LoadMore.State state) {
        return a.h(a.o(BinderKt.b(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).b0(str, str2, this.b.a(state).d())), this.f4492c, this.b.f()), null, new OrderListChildViewModel$getData$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<OrderInfo>> r0() {
        return this.f4492c;
    }
}
