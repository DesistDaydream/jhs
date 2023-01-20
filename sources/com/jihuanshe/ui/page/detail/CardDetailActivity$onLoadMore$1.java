package com.jihuanshe.ui.page.detail;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardDetailInfo;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ CardDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$onLoadMore$1(CardDetailActivity cardDetailActivity) {
        super(2);
        this.this$0 = cardDetailActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        Integer id;
        CardDetailViewModel cardDetailViewModel = (CardDetailViewModel) this.this$0.L();
        CardDetailInfo value = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
        int i2 = 0;
        if (value != null && (id = value.getId()) != null) {
            i2 = id.intValue();
        }
        BinderKt.d(cardDetailViewModel.Q0(i2, this.this$0.w0(), this.this$0.x0(), state), this.this$0, gVar, true);
    }
}
