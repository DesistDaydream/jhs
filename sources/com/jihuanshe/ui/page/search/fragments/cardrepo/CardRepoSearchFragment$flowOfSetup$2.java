package com.jihuanshe.ui.page.search.fragments.cardrepo;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.ApplyForOrder;
import com.jihuanshe.viewmodel.entrepot.ApplyForViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardRepoSearchFragment$flowOfSetup$2 extends Lambda implements l<ApplyForOrder, t1> {
    public final /* synthetic */ CardRepoSearchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardRepoSearchFragment$flowOfSetup$2(CardRepoSearchFragment cardRepoSearchFragment) {
        super(1);
        this.this$0 = cardRepoSearchFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ApplyForOrder applyForOrder) {
        invoke2(applyForOrder);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d ApplyForOrder applyForOrder) {
        ApplyForViewModel l0 = this.this$0.l0();
        Integer warehouseOrderId = applyForOrder.getWarehouseOrderId();
        BinderKt.p(l0.u0(Integer.valueOf(warehouseOrderId == null ? 0 : warehouseOrderId.intValue()), null));
    }
}
