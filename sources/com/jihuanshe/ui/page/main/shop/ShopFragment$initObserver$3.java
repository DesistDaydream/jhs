package com.jihuanshe.ui.page.main.shop;

import com.jihuanshe.model.CardPackage;
import com.jihuanshe.model.Constants;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$initObserver$3 extends Lambda implements l<CardPackage, t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$initObserver$3(ShopFragment shopFragment) {
        super(1);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(CardPackage cardPackage) {
        invoke2(cardPackage);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d CardPackage cardPackage) {
        ShopViewModel shopViewModel = (ShopViewModel) this.this$0.T();
        Integer type = cardPackage.getType();
        shopViewModel.v(type == null ? Constants.Companion.getTYPE_NEWEST() : type.intValue());
        ((ShopViewModel) this.this$0.T()).y0().setValue(CollectionsKt__CollectionsKt.E());
        RarityFilterBtn.h(this.this$0.G0(), false, 1, null);
    }
}
