package com.jihuanshe.ui.page.shop;

import com.jihuanshe.viewmodel.shop.SellerConfirmViewModel;
import e.n.p;
import h.k2.u.q;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerConfirmActivity$onClickBankLoc$1$1$1 extends Lambda implements q<String, String, String, t1> {
    public final /* synthetic */ SellerConfirmActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerConfirmActivity$onClickBankLoc$1$1$1(SellerConfirmActivity sellerConfirmActivity) {
        super(3);
        this.this$0 = sellerConfirmActivity;
    }

    @Override // h.k2.u.q
    public /* bridge */ /* synthetic */ t1 invoke(String str, String str2, String str3) {
        invoke2(str, str2, str3);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d String str, @d String str2, @d String str3) {
        p J0 = ((SellerConfirmViewModel) this.this$0.L()).J0();
        J0.setValue(str + (char) 65292 + str2);
        this.this$0.I = str3;
    }
}
