package com.jihuanshe.ui.page.shop;

import com.jihuanshe.viewmodel.shop.SellerConfirmViewModel;
import h.k2.u.p;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerConfirmActivity$onChecked$1 extends Lambda implements p<Integer, Integer, t1> {
    public final /* synthetic */ SellerConfirmActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerConfirmActivity$onChecked$1(SellerConfirmActivity sellerConfirmActivity) {
        super(2);
        this.this$0 = sellerConfirmActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return t1.a;
    }

    public final void invoke(int i2, int i3) {
        ((SellerConfirmViewModel) this.this$0.L()).P0().setValue(Boolean.valueOf(i2 == 1));
    }
}
