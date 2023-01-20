package com.jihuanshe.ui.page.main.shop;

import com.jihuanshe.model.Constants;
import com.jihuanshe.ui.page.user.SellerDetailActivityCreator;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$initObserver$1 extends Lambda implements a<t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$initObserver$1(ShopFragment shopFragment) {
        super(0);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        SellerDetailActivityCreator.create(Integer.valueOf(Constants.Companion.getWAREHOUSE_SELLER_USER_ID()), -1).start(this.this$0.getActivity());
    }
}
