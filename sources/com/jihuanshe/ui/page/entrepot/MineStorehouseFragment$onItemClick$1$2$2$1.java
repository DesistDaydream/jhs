package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.model.WantCard;
import com.jihuanshe.model.WarehouseProductInfo;
import com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class MineStorehouseFragment$onItemClick$1$2$2$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ WarehouseProductInfo $card;
    public final /* synthetic */ WantCard $wantCard;
    public final /* synthetic */ MineStorehouseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineStorehouseFragment$onItemClick$1$2$2$1(WarehouseProductInfo warehouseProductInfo, WantCard wantCard, MineStorehouseFragment mineStorehouseFragment) {
        super(1);
        this.$card = warehouseProductInfo;
        this.$wantCard = wantCard;
        this.this$0 = mineStorehouseFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        this.$card.setPrice(this.$wantCard.getWishPrice().floatValue());
        ((MineStorehouseViewModel) this.this$0.T()).v0().n();
    }
}
