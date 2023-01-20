package com.jihuanshe.ui.page.order;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.order.OrderConfirmViewModel;
import e.l.h.j.b.e;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderConfirmActivity$onClickConfirm$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ OrderConfirmActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderConfirmActivity$onClickConfirm$1(OrderConfirmActivity orderConfirmActivity) {
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
        if (((OrderConfirmViewModel) this.this$0.L()).q0().getValue() == null) {
            e.a(this.this$0, "请先选择收货地址");
        } else {
            BinderKt.p(BinderKt.k(((OrderConfirmViewModel) this.this$0.L()).p0(Integer.valueOf(this.this$0.d0()), this.this$0.X().getText().toString()), this.this$0, false, 2, null));
        }
    }
}
