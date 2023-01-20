package com.jihuanshe.viewmodel.order;

import com.jihuanshe.model.Constants;
import com.jihuanshe.model.OrderDetailInfo;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerOrderDetailViewModel$getDetail$2 extends Lambda implements l<OrderDetailInfo, t1> {
    public final /* synthetic */ SellerOrderDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerOrderDetailViewModel$getDetail$2(SellerOrderDetailViewModel sellerOrderDetailViewModel) {
        super(1);
        this.this$0 = sellerOrderDetailViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(OrderDetailInfo orderDetailInfo) {
        invoke2(orderDetailInfo);
        return t1.a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e OrderDetailInfo orderDetailInfo) {
        int i2;
        e.n.l D0 = this.this$0.D0();
        String status = orderDetailInfo == null ? null : orderDetailInfo.getStatus();
        if (status != null) {
            switch (status.hashCode()) {
                case -1561989414:
                    if (status.equals("waiting_to_send")) {
                        i2 = 2;
                        break;
                    }
                    break;
                case -599445191:
                    if (status.equals("complete")) {
                        i2 = 4;
                        break;
                    }
                    break;
                case -14663463:
                    if (status.equals("waiting_to_return_goods")) {
                        i2 = 6;
                        break;
                    }
                    break;
                case 503799574:
                    if (status.equals(Constants.STATE_WAITING_PAY)) {
                        i2 = 1;
                        break;
                    }
                    break;
                case 1715318318:
                    if (status.equals("waiting_to_confirm")) {
                        i2 = 0;
                        break;
                    }
                    break;
                case 1846491729:
                    if (status.equals("waiting_to_receive")) {
                        i2 = 3;
                        break;
                    }
                    break;
                case 2137879114:
                    if (status.equals("waiting_to_refund")) {
                        i2 = 5;
                        break;
                    }
                    break;
            }
            D0.setValue(i2);
        }
        i2 = -1;
        D0.setValue(i2);
    }
}
