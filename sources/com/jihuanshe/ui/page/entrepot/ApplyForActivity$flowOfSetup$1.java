package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.model.ApplyForOrder;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ApplyForActivity$flowOfSetup$1 extends Lambda implements l<ApplyForOrder, t1> {
    public final /* synthetic */ ApplyForActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyForActivity$flowOfSetup$1(ApplyForActivity applyForActivity) {
        super(1);
        this.this$0 = applyForActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ApplyForOrder applyForOrder) {
        invoke2(applyForOrder);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d ApplyForOrder applyForOrder) {
        ApplyForActivity applyForActivity = this.this$0;
        Integer warehouseOrderId = applyForOrder.getWarehouseOrderId();
        applyForActivity.l0(warehouseOrderId == null ? 0 : warehouseOrderId.intValue());
    }
}
