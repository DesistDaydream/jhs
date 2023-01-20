package com.jihuanshe.ui.page.user;

import com.jihuanshe.model.Constants;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$initObserver$4 extends Lambda implements l<Boolean, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$initObserver$4(SellerDetailActivity sellerDetailActivity) {
        super(1);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return t1.a;
    }

    public final void invoke(boolean z) {
        int Z0 = this.this$0.Z0();
        Constants.Companion companion = Constants.Companion;
        if (Z0 == companion.getWAREHOUSE_SELLER_USER_ID()) {
            ((SellerDetailViewModel) this.this$0.L()).v(companion.getTYPE_WAREHOUSE_SELLER());
        } else {
            ((SellerDetailViewModel) this.this$0.L()).v(companion.getTYPE_SELLER());
        }
        this.this$0.m1(true);
    }
}
