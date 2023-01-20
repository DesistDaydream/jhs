package com.jihuanshe.ui.page.order;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.UseDialog;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderDetailActivity$onClickConfirmReceive$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ OrderDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailActivity$onClickConfirmReceive$1(OrderDetailActivity orderDetailActivity) {
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
        useDialog.setContent(Res.w(res, R.string.order_confirm_receive, null, 2, null));
        useDialog.setRightButtonText(Res.w(res, R.string.common_confirm, null, 2, null));
        useDialog.setOnClickRightButton(new OrderDetailActivity$onClickConfirmReceive$1$1$1(orderDetailActivity));
        useDialog.y();
    }
}
