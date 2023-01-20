package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.OrderReturnDetail;
import com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel;
import com.vector.view.scrollable.ListView;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ConOrderDetailsActivity$flowOfSetup$2 extends Lambda implements l<OrderReturnDetail, t1> {
    public final /* synthetic */ ConOrderDetailsActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConOrderDetailsActivity$flowOfSetup$2(ConOrderDetailsActivity conOrderDetailsActivity) {
        super(1);
        this.this$0 = conOrderDetailsActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(OrderReturnDetail orderReturnDetail) {
        invoke2(orderReturnDetail);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e OrderReturnDetail orderReturnDetail) {
        ListView c0;
        a y0 = ConOrderDetailsViewModel.y0((ConOrderDetailsViewModel) this.this$0.L(), this.this$0.i0().intValue(), null, 2, null);
        ConOrderDetailsActivity conOrderDetailsActivity = this.this$0;
        c0 = conOrderDetailsActivity.c0();
        BinderKt.p(BinderKt.e(y0, conOrderDetailsActivity, c0, false, 4, null));
    }
}
