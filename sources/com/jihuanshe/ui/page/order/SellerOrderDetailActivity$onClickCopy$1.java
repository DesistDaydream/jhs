package com.jihuanshe.ui.page.order;

import android.view.View;
import com.jihuanshe.model.OrderDetailInfo;
import com.jihuanshe.utils.StringUtil;
import com.jihuanshe.viewmodel.order.SellerOrderDetailViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerOrderDetailActivity$onClickCopy$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerOrderDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerOrderDetailActivity$onClickCopy$1(SellerOrderDetailActivity sellerOrderDetailActivity) {
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
        StringUtil stringUtil = StringUtil.a;
        OrderDetailInfo value = ((SellerOrderDetailViewModel) this.this$0.L()).C0().getValue();
        String uuid = value == null ? null : value.getUuid();
        if (uuid == null) {
            uuid = "";
        }
        stringUtil.a(uuid);
    }
}
