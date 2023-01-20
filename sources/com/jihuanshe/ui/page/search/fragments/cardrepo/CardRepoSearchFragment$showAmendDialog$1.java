package com.jihuanshe.ui.page.search.fragments.cardrepo;

import com.jihuanshe.model.ApplyForItem;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardRepoSearchFragment$showAmendDialog$1 extends Lambda implements a<t1> {
    public final /* synthetic */ ApplyForItem $it;
    public final /* synthetic */ CardRepoSearchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardRepoSearchFragment$showAmendDialog$1(ApplyForItem applyForItem, CardRepoSearchFragment cardRepoSearchFragment) {
        super(0);
        this.$it = applyForItem;
        this.this$0 = cardRepoSearchFragment;
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
        CardRepoSearchFragment cardRepoSearchFragment = this.this$0;
        e.g.d.a.j(cardRepoSearchFragment.l0().q0(warehouseOrderProductId.intValue()), null, new CardRepoSearchFragment$showAmendDialog$1$1$1(cardRepoSearchFragment), 1, null);
    }
}
