package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.model.WantCard;
import com.jihuanshe.model.WarehouseProductInfo;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class MineStorehouseFragment$onItemClick$1$2$1$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ WarehouseProductInfo $card;
    public final /* synthetic */ Boolean $isShowSold;
    public final /* synthetic */ WantCard $wantCard;
    public final /* synthetic */ MineStorehouseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineStorehouseFragment$onItemClick$1$2$1$1(MineStorehouseFragment mineStorehouseFragment, Boolean bool, WantCard wantCard, WarehouseProductInfo warehouseProductInfo) {
        super(1);
        this.this$0 = mineStorehouseFragment;
        this.$isShowSold = bool;
        this.$wantCard = wantCard;
        this.$card = warehouseProductInfo;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        this.this$0.w0(this.$isShowSold, this.$wantCard.getWishPrice(), this.$card);
    }
}
