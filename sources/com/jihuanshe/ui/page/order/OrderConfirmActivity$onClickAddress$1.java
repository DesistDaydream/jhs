package com.jihuanshe.ui.page.order;

import android.view.View;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderConfirmActivity$onClickAddress$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ OrderConfirmActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderConfirmActivity$onClickAddress$1(OrderConfirmActivity orderConfirmActivity) {
        super(1);
        this.this$0 = orderConfirmActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        AddressActivityCreator.create().start(this.this$0);
    }
}
