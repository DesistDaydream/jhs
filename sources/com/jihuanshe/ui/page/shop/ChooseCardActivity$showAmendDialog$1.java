package com.jihuanshe.ui.page.shop;

import com.jihuanshe.model.ApplyForItem;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ChooseCardActivity$showAmendDialog$1 extends Lambda implements a<t1> {
    public final /* synthetic */ ApplyForItem $it;
    public final /* synthetic */ ChooseCardActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseCardActivity$showAmendDialog$1(ApplyForItem applyForItem, ChooseCardActivity chooseCardActivity) {
        super(0);
        this.$it = applyForItem;
        this.this$0 = chooseCardActivity;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Integer warehouseOrderProductId = this.$it.getWarehouseOrderProductId();
        if (warehouseOrderProductId == null) {
            return;
        }
        ChooseCardActivity chooseCardActivity = this.this$0;
        e.g.d.a.j(chooseCardActivity.Z().q0(warehouseOrderProductId.intValue()), null, new ChooseCardActivity$showAmendDialog$1$1$1(chooseCardActivity), 1, null);
    }
}
