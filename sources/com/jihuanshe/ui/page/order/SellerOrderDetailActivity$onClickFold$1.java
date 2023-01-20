package com.jihuanshe.ui.page.order;

import android.view.View;
import com.jihuanshe.ui.dialog.ExpressDetailsDialog;
import com.jihuanshe.viewmodel.order.SellerOrderDetailViewModel;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerOrderDetailActivity$onClickFold$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerOrderDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerOrderDetailActivity$onClickFold$1(SellerOrderDetailActivity sellerOrderDetailActivity) {
        super(1);
        this.this$0 = sellerOrderDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        if (((SellerOrderDetailViewModel) this.this$0.L()).C0().getValue() == null || ((SellerOrderDetailViewModel) this.this$0.L()).z0().getValue() == null || !f0.g(((SellerOrderDetailViewModel) this.this$0.L()).E0().getValue(), Boolean.TRUE)) {
            return;
        }
        SellerOrderDetailActivity sellerOrderDetailActivity = this.this$0;
        new ExpressDetailsDialog(sellerOrderDetailActivity, ((SellerOrderDetailViewModel) sellerOrderDetailActivity.L()).C0().getValue(), ((SellerOrderDetailViewModel) this.this$0.L()).z0().getValue()).y();
    }
}
