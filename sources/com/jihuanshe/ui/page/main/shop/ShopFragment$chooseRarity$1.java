package com.jihuanshe.ui.page.main.shop;

import com.jihuanshe.model.Rarity;
import com.jihuanshe.model.stat.STATConstant;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$chooseRarity$1 extends Lambda implements l<List<? extends Rarity>, t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$chooseRarity$1(ShopFragment shopFragment) {
        super(1);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends Rarity> list) {
        invoke2((List<Rarity>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e List<Rarity> list) {
        this.this$0.R0(STATConstant.OP_HOME_SHOP.CHANGE_FILTER);
    }
}
