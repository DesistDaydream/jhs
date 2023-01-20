package com.jihuanshe.ui.page.main.shop;

import com.jihuanshe.model.Category;
import com.jihuanshe.model.Constants;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$initObserver$2 extends Lambda implements l<Category, t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$initObserver$2(ShopFragment shopFragment) {
        super(1);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Category category) {
        invoke2(category);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Category category) {
        int id = category.getId();
        Constants.Companion companion = Constants.Companion;
        if (id == companion.getCATEGORY_ID()) {
            ((ShopViewModel) this.this$0.T()).v(companion.getTYPE_WAREHOUSE_SELLER());
            ((ShopViewModel) this.this$0.T()).r0().setValue(null);
            ((ShopViewModel) this.this$0.T()).y0().setValue(CollectionsKt__CollectionsKt.E());
            RarityFilterBtn.h(this.this$0.G0(), false, 1, null);
        }
    }
}
