package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.OrderReturnInfo;
import com.jihuanshe.viewmodel.entrepot.SubmitOrderReturnViewModel;
import com.vector.design.ui.delegate.LoadMore;
import com.vector.view.scrollable.ListView;
import e.g.d.a;
import e.l.h.i.e;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SubmitOrderReturnActivity$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ SubmitOrderReturnActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubmitOrderReturnActivity$onLoadMore$1(SubmitOrderReturnActivity submitOrderReturnActivity) {
        super(2);
        this.this$0 = submitOrderReturnActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        ListView a0;
        SubmitOrderReturnViewModel submitOrderReturnViewModel = (SubmitOrderReturnViewModel) this.this$0.L();
        Integer d0 = this.this$0.d0();
        a<e<OrderReturnInfo>> D0 = submitOrderReturnViewModel.D0(d0 == null ? 0 : d0.intValue(), state);
        SubmitOrderReturnActivity submitOrderReturnActivity = this.this$0;
        a0 = submitOrderReturnActivity.a0();
        BinderKt.p(BinderKt.d(D0, submitOrderReturnActivity, a0, true));
    }
}
