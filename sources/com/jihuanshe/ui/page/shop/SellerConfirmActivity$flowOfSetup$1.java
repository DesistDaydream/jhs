package com.jihuanshe.ui.page.shop;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.ConfirmState;
import com.jihuanshe.viewmodel.shop.SellerConfirmViewModel;
import com.vector.design.ui.decor.ViewState;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerConfirmActivity$flowOfSetup$1 extends Lambda implements l<ConfirmState, t1> {
    public final /* synthetic */ SellerConfirmActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerConfirmActivity$flowOfSetup$1(SellerConfirmActivity sellerConfirmActivity) {
        super(1);
        this.this$0 = sellerConfirmActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ConfirmState confirmState) {
        invoke2(confirmState);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d ConfirmState confirmState) {
        if (confirmState.isAuditing()) {
            this.this$0.G(ViewState.NORMAL);
        } else if (confirmState.isFinish()) {
            BinderKt.s(((SellerConfirmViewModel) this.this$0.L()).R0(), this.this$0, false, false, 6, null);
        } else if (confirmState.isSigning()) {
            this.this$0.G(ViewState.NORMAL);
        }
    }
}
