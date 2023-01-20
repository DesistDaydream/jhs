package com.jihuanshe.ui.page.order;

import com.jihuanshe.model.ExpressData;
import com.jihuanshe.model.OrderDetailInfo;
import com.jihuanshe.viewmodel.order.SellerOrderDetailViewModel;
import e.g.d.a;
import e.l.k.k2;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerOrderDetailActivity$flowOfSetup$2 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ SellerOrderDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.order.SellerOrderDetailActivity$flowOfSetup$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<List<? extends ExpressData>, t1> {
        public final /* synthetic */ SellerOrderDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SellerOrderDetailActivity sellerOrderDetailActivity) {
            super(1);
            this.this$0 = sellerOrderDetailActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(List<? extends ExpressData> list) {
            invoke2((List<ExpressData>) list);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e List<ExpressData> list) {
            if ((list == null ? 0 : list.size()) > 1) {
                this.this$0.b0().z(2);
                this.this$0.b0().notifyDataSetChanged();
                return;
            }
            if ((list != null ? list.size() : 0) == 1) {
                this.this$0.b0().z(1);
                this.this$0.b0().notifyDataSetChanged();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerOrderDetailActivity$flowOfSetup$2(SellerOrderDetailActivity sellerOrderDetailActivity) {
        super(1);
        this.this$0 = sellerOrderDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        k2 Y = this.this$0.Y();
        if (Y != null) {
            Y.invalidateAll();
        }
        if (i2 == 3) {
            OrderDetailInfo value = ((SellerOrderDetailViewModel) this.this$0.L()).C0().getValue();
            if (value == null ? false : f0.g(value.getExpressType(), 1)) {
                a.j(((SellerOrderDetailViewModel) this.this$0.L()).y0(this.this$0.c0()), null, new AnonymousClass1(this.this$0), 1, null);
            }
        }
    }
}
