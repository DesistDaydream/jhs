package com.jihuanshe.ui.page.order;

import android.view.View;
import com.jihuanshe.ui.dialog.ExpressDetailsDialog;
import com.jihuanshe.viewmodel.order.OrderDetailViewModel;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderDetailActivity$onClickFold$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ OrderDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailActivity$onClickFold$1(OrderDetailActivity orderDetailActivity) {
        super(1);
        this.this$0 = orderDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        if (((OrderDetailViewModel) this.this$0.L()).y0().getValue() == null || ((OrderDetailViewModel) this.this$0.L()).x0().getValue() == null || !f0.g(((OrderDetailViewModel) this.this$0.L()).C0().getValue(), Boolean.TRUE)) {
            return;
        }
        OrderDetailActivity orderDetailActivity = this.this$0;
        new ExpressDetailsDialog(orderDetailActivity, ((OrderDetailViewModel) orderDetailActivity.L()).y0().getValue(), ((OrderDetailViewModel) this.this$0.L()).x0().getValue()).y();
    }
}
