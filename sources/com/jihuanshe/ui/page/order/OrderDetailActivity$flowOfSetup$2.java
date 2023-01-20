package com.jihuanshe.ui.page.order;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.ExpressData;
import com.jihuanshe.model.OrderDetailInfo;
import com.jihuanshe.viewmodel.order.OrderDetailViewModel;
import e.g.d.a;
import e.l.k.q1;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderDetailActivity$flowOfSetup$2 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ OrderDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.order.OrderDetailActivity$flowOfSetup$2$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<List<? extends ExpressData>, t1> {
        public final /* synthetic */ OrderDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OrderDetailActivity orderDetailActivity) {
            super(1);
            this.this$0 = orderDetailActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(List<? extends ExpressData> list) {
            invoke2((List<ExpressData>) list);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e List<ExpressData> list) {
            if ((list == null ? 0 : list.size()) > 1) {
                this.this$0.a0().z(2);
                this.this$0.a0().notifyDataSetChanged();
                return;
            }
            if ((list != null ? list.size() : 0) == 1) {
                this.this$0.a0().z(1);
                this.this$0.a0().notifyDataSetChanged();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailActivity$flowOfSetup$2(OrderDetailActivity orderDetailActivity) {
        super(1);
        this.this$0 = orderDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        q1 X = this.this$0.X();
        if (X != null) {
            X.invalidateAll();
        }
        if (i2 == 1) {
            if (f0.g(this.this$0.M(), String.valueOf(Constants.Companion.getWAREHOUSE_SELLER_USER_ID()))) {
                BinderKt.p(BinderKt.k(((OrderDetailViewModel) this.this$0.L()).D0(this.this$0.c0()), this.this$0, false, 2, null));
            }
        } else if (i2 != 3) {
        } else {
            OrderDetailInfo value = ((OrderDetailViewModel) this.this$0.L()).y0().getValue();
            if (value != null ? f0.g(value.getExpressType(), 1) : false) {
                a.j(((OrderDetailViewModel) this.this$0.L()).w0(this.this$0.c0()), null, new AnonymousClass1(this.this$0), 1, null);
            }
        }
    }
}
