package com.jihuanshe.ui.page.order;

import com.jihuanshe.R;
import com.vector.design.ui.nav.TextAttrs;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderListActivity$flowOfAppBar$1 extends Lambda implements l<TextAttrs, t1> {
    public final /* synthetic */ OrderListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderListActivity$flowOfAppBar$1(OrderListActivity orderListActivity) {
        super(1);
        this.this$0 = orderListActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(TextAttrs textAttrs) {
        invoke2(textAttrs);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d TextAttrs textAttrs) {
        textAttrs.K(Integer.valueOf(f0.g(this.this$0.Y(), Boolean.TRUE) ? R.string.order_my_sold : R.string.order_my_order));
    }
}
