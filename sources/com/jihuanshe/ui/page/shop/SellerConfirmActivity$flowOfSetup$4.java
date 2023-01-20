package com.jihuanshe.ui.page.shop;

import com.jihuanshe.model.UseBank;
import com.jihuanshe.viewmodel.shop.SellerConfirmViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerConfirmActivity$flowOfSetup$4 extends Lambda implements l<UseBank, t1> {
    public final /* synthetic */ SellerConfirmActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerConfirmActivity$flowOfSetup$4(SellerConfirmActivity sellerConfirmActivity) {
        super(1);
        this.this$0 = sellerConfirmActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(UseBank useBank) {
        invoke2(useBank);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d UseBank useBank) {
        if (useBank.isVerifying()) {
            ((SellerConfirmViewModel) this.this$0.L()).D0().r(2);
        }
    }
}
