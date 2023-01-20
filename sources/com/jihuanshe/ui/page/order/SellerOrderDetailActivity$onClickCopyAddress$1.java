package com.jihuanshe.ui.page.order;

import android.view.View;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.jihuanshe.model.OrderDetailInfo;
import com.jihuanshe.utils.StringUtil;
import com.jihuanshe.viewmodel.order.SellerOrderDetailViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerOrderDetailActivity$onClickCopyAddress$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerOrderDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerOrderDetailActivity$onClickCopyAddress$1(SellerOrderDetailActivity sellerOrderDetailActivity) {
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
        StringBuilder sb = new StringBuilder();
        OrderDetailInfo value = ((SellerOrderDetailViewModel) this.this$0.L()).C0().getValue();
        String receiverName = value == null ? null : value.getReceiverName();
        if (receiverName == null) {
            receiverName = "";
        }
        sb.append(receiverName);
        sb.append(ExpandableTextView.N);
        OrderDetailInfo value2 = ((SellerOrderDetailViewModel) this.this$0.L()).C0().getValue();
        String phoneNumber = value2 == null ? null : value2.getPhoneNumber();
        if (phoneNumber == null) {
            phoneNumber = "";
        }
        sb.append(phoneNumber);
        sb.append(ExpandableTextView.N);
        OrderDetailInfo value3 = ((SellerOrderDetailViewModel) this.this$0.L()).C0().getValue();
        String province = value3 == null ? null : value3.getProvince();
        if (province == null) {
            province = "";
        }
        sb.append(province);
        OrderDetailInfo value4 = ((SellerOrderDetailViewModel) this.this$0.L()).C0().getValue();
        String city = value4 == null ? null : value4.getCity();
        if (city == null) {
            city = "";
        }
        sb.append(city);
        OrderDetailInfo value5 = ((SellerOrderDetailViewModel) this.this$0.L()).C0().getValue();
        String district = value5 == null ? null : value5.getDistrict();
        if (district == null) {
            district = "";
        }
        sb.append(district);
        OrderDetailInfo value6 = ((SellerOrderDetailViewModel) this.this$0.L()).C0().getValue();
        String address = value6 != null ? value6.getAddress() : null;
        sb.append(address != null ? address : "");
        StringUtil.a.a(sb.toString());
    }
}
