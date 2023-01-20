package com.jihuanshe.ui.page.user;

import com.jihuanshe.adapter.ShopCarAdapter;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$shopCarAdapter$2 extends Lambda implements a<ShopCarAdapter> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$shopCarAdapter$2(SellerDetailActivity sellerDetailActivity) {
        super(0);
        this.this$0 = sellerDetailActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final ShopCarAdapter invoke() {
        return new ShopCarAdapter(this.this$0);
    }
}
