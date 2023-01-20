package com.jihuanshe.viewmodel.entrepot;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.SoldProductInfo;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.k;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class SearchSoldViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<List<SoldProductInfo>> f4439c = new NLive<>(null, 1, null);

    public static /* synthetic */ a s0(SearchSoldViewModel searchSoldViewModel, Integer num, String str, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = null;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        if ((i2 & 4) != 0) {
            state = null;
        }
        return searchSoldViewModel.q0(num, str, state);
    }

    @d
    public final a<e<SoldProductInfo>> q0(@k.e.a.e Integer num, @k.e.a.e String str, @k.e.a.e LoadMore.State state) {
        return a.h(a.o(BinderKt.b(FlowKt.c(k.a.g((k) e.l.n.a.d(k.class, true, false, false, 60L, true), num, str, this.b.a(state).d(), null, null, 24, null)), this.f4439c, this.b.f()), null, new SearchSoldViewModel$getSoldProducts$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<SoldProductInfo>> r0() {
        return this.f4439c;
    }
}
