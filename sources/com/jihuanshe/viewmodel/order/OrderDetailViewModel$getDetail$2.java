package com.jihuanshe.viewmodel.order;

import com.jihuanshe.model.OrderDetailInfo;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderDetailViewModel$getDetail$2 extends Lambda implements l<OrderDetailInfo, t1> {
    public final /* synthetic */ OrderDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailViewModel$getDetail$2(OrderDetailViewModel orderDetailViewModel) {
        super(1);
        this.this$0 = orderDetailViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(OrderDetailInfo orderDetailInfo) {
        invoke2(orderDetailInfo);
        return t1.a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0090  */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invoke2(@k.e.a.e com.jihuanshe.model.OrderDetailInfo r9) {
        /*
            r8 = this;
            com.jihuanshe.viewmodel.order.OrderDetailViewModel r0 = r8.this$0
            e.n.l r0 = r0.A0()
            r1 = 0
            if (r9 != 0) goto Lb
            r2 = r1
            goto Lf
        Lb:
            java.lang.String r2 = r9.getStatus()
        Lf:
            if (r2 == 0) goto L85
            int r3 = r2.hashCode()
            switch(r3) {
                case -1561989414: goto L76;
                case -599445191: goto L67;
                case -14663463: goto L58;
                case 503799574: goto L49;
                case 1715318318: goto L3a;
                case 1846491729: goto L2b;
                case 2137879114: goto L1a;
                default: goto L18;
            }
        L18:
            goto L85
        L1a:
            java.lang.String r3 = "waiting_to_refund"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L24
            goto L85
        L24:
            r2 = 5
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L8a
        L2b:
            java.lang.String r3 = "waiting_to_receive"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L34
            goto L85
        L34:
            r2 = 3
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L8a
        L3a:
            java.lang.String r3 = "waiting_to_confirm"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L43
            goto L85
        L43:
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L8a
        L49:
            java.lang.String r3 = "waiting_to_pay"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L52
            goto L85
        L52:
            r2 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L8a
        L58:
            java.lang.String r3 = "waiting_to_return_goods"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L61
            goto L85
        L61:
            r2 = 6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L8a
        L67:
            java.lang.String r3 = "complete"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L70
            goto L85
        L70:
            r2 = 4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L8a
        L76:
            java.lang.String r3 = "waiting_to_send"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L7f
            goto L85
        L7f:
            r2 = 2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L8a
        L85:
            r2 = -1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L8a:
            r0.setValue(r2)
            if (r9 != 0) goto L90
            goto L94
        L90:
            java.lang.Integer r1 = r9.getPayTimeLeft()
        L94:
            if (r1 == 0) goto Lc0
            int r9 = r1.intValue()
            if (r9 != 0) goto L9d
            goto Lc0
        L9d:
            com.jihuanshe.viewmodel.order.OrderDetailViewModel r9 = r8.this$0
            com.jihuanshe.viewmodel.order.OrderDetailViewModel$a r0 = new com.jihuanshe.viewmodel.order.OrderDetailViewModel$a
            int r1 = r1.intValue()
            int r1 = r1 * 1000
            long r3 = (long) r1
            r5 = 1100(0x44c, double:5.435E-321)
            com.jihuanshe.viewmodel.order.OrderDetailViewModel r1 = r8.this$0
            e.n.p r7 = r1.z0()
            r2 = r0
            r2.<init>(r3, r5, r7)
            r9.F0(r0)
            com.jihuanshe.viewmodel.order.OrderDetailViewModel r9 = r8.this$0
            com.jihuanshe.viewmodel.order.OrderDetailViewModel$a r9 = r9.B0()
            r9.start()
        Lc0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.order.OrderDetailViewModel$getDetail$2.invoke2(com.jihuanshe.model.OrderDetailInfo):void");
    }
}
