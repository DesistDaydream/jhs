package com.jihuanshe.ui.page.main.shop;

import com.jihuanshe.model.stat.STATConstant;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$onChooseCategory$1 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$onChooseCategory$1(ShopFragment shopFragment) {
        super(1);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        ((ShopViewModel) this.this$0.T()).F0(i2);
        this.this$0.R0(STATConstant.OP_HOME_SHOP.CHANGE_CATEGORY);
    }
}
