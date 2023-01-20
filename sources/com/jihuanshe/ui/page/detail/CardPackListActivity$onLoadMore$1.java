package com.jihuanshe.ui.page.detail;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.PackDetailResult;
import com.jihuanshe.viewmodel.detail.CardPackListViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardPackListActivity$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ CardPackListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackListActivity$onLoadMore$1(CardPackListActivity cardPackListActivity) {
        super(2);
        this.this$0 = cardPackListActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        Integer id;
        CardPackListViewModel cardPackListViewModel = (CardPackListViewModel) this.this$0.L();
        Game a0 = this.this$0.a0();
        PackDetailResult l0 = this.this$0.l0();
        BinderKt.d(cardPackListViewModel.q0(a0, (l0 == null || (id = l0.getId()) == null) ? 0 : id.intValue(), state, false), this.this$0, gVar, true);
    }
}
