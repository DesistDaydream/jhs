package com.jihuanshe.viewmodel.entrepot;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardConsignmentInfo;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.k;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class ConsignmentOrderChildViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<List<CardConsignmentInfo>> f4425c = new NLive<>(null, 1, null);

    public static /* synthetic */ a r0(ConsignmentOrderChildViewModel consignmentOrderChildViewModel, String str, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            state = null;
        }
        return consignmentOrderChildViewModel.q0(str, state);
    }

    public static /* synthetic */ a u0(ConsignmentOrderChildViewModel consignmentOrderChildViewModel, String str, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            state = null;
        }
        return consignmentOrderChildViewModel.t0(str, state);
    }

    @d
    public final a<e<CardConsignmentInfo>> q0(@d String str, @k.e.a.e LoadMore.State state) {
        return a.h(a.o(BinderKt.b(FlowKt.c(k.a.j((k) e.l.n.a.d(k.class, true, false, false, 60L, true), str, this.b.a(state).d(), null, null, 12, null)), this.f4425c, this.b.f()), null, new ConsignmentOrderChildViewModel$getCardListData$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<CardConsignmentInfo>> s0() {
        return this.f4425c;
    }

    @d
    public final a<e<CardConsignmentInfo>> t0(@d String str, @k.e.a.e LoadMore.State state) {
        return a.h(a.o(BinderKt.b(FlowKt.c(k.a.l((k) e.l.n.a.d(k.class, true, false, false, 60L, true), str, this.b.a(state).d(), null, null, 12, null)), this.f4425c, this.b.f()), null, new ConsignmentOrderChildViewModel$getReturnCardListData$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
