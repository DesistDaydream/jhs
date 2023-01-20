package com.jihuanshe.viewmodel.entrepot;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.GameCard;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.p;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class SearchHouseProductViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<List<GameCard>> f4438c = new NLive<>(null, 1, null);

    public static /* synthetic */ a s0(SearchHouseProductViewModel searchHouseProductViewModel, int i2, String str, String str2, String str3, LoadMore.State state, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            state = null;
        }
        return searchHouseProductViewModel.r0(i2, str, str2, str3, state);
    }

    @d
    public final NLive<List<GameCard>> q0() {
        return this.f4438c;
    }

    @d
    public final a<e<GameCard>> r0(int i2, @k.e.a.e String str, @d String str2, @d String str3, @k.e.a.e LoadMore.State state) {
        return a.h(a.o(BinderKt.b(FlowKt.c(((p) e.l.n.a.d(p.class, true, false, false, 60L, true)).b(i2, null, null, str, str2, str3, this.b.a(state).d())), this.f4438c, this.b.f()), null, new SearchHouseProductViewModel$getSellerProducts$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
