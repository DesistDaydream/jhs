package com.jihuanshe.ui.page.order;

import android.view.View;
import com.jihuanshe.model.OrderDetailInfo;
import com.jihuanshe.viewmodel.order.OrderDetailViewModel;
import e.l.q.b.f.g;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderDetailActivity$onCommunity$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ OrderDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailActivity$onCommunity$1(OrderDetailActivity orderDetailActivity) {
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
        OrderDetailActivity orderDetailActivity = this.this$0;
        OrderDetailInfo value = ((OrderDetailViewModel) orderDetailActivity.L()).y0().getValue();
        String valueOf = String.valueOf(value == null ? null : value.getUid());
        OrderDetailInfo value2 = ((OrderDetailViewModel) this.this$0.L()).y0().getValue();
        g.a(orderDetailActivity, valueOf, value2 != null ? value2.getUserName() : null);
    }
}
