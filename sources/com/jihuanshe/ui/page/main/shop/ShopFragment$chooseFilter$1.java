package com.jihuanshe.ui.page.main.shop;

import com.jihuanshe.viewmodel.main.shop.ShopViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$chooseFilter$1 extends Lambda implements l<Pair<? extends String, ? extends String>, t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$chooseFilter$1(ShopFragment shopFragment) {
        super(1);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Pair<? extends String, ? extends String> pair) {
        invoke2((Pair<String, String>) pair);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Pair<String, String> pair) {
        ((ShopViewModel) this.this$0.T()).r(pair);
    }
}
