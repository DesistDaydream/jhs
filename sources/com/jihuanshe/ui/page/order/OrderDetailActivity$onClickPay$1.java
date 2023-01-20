package com.jihuanshe.ui.page.order;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.model.OrderDetailInfo;
import com.jihuanshe.ui.dialog.UseDialog;
import com.jihuanshe.viewmodel.order.OrderDetailViewModel;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderDetailActivity$onClickPay$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ OrderDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailActivity$onClickPay$1(OrderDetailActivity orderDetailActivity) {
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
        UseDialog useDialog = new UseDialog(this.this$0);
        OrderDetailActivity orderDetailActivity = this.this$0;
        Res res = Res.a;
        Object[] objArr = new Object[1];
        OrderDetailInfo value = ((OrderDetailViewModel) orderDetailActivity.L()).y0().getValue();
        String f2 = value == null ? null : Float.valueOf(value.getOrderPrice()).toString();
        if (f2 == null) {
            f2 = "";
        }
        objArr[0] = f2;
        useDialog.setContent(res.v(R.string.order_confirm_pay, objArr));
        useDialog.setRightButtonText(Res.w(res, R.string.common_confirm, null, 2, null));
        useDialog.setOnClickRightButton(new OrderDetailActivity$onClickPay$1$1$1(orderDetailActivity));
        useDialog.y();
    }
}
