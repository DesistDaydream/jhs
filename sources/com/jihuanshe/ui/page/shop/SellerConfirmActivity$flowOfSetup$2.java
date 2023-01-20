package com.jihuanshe.ui.page.shop;

import android.widget.TextView;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerConfirmActivity$flowOfSetup$2 extends Lambda implements l<CharSequence, t1> {
    public final /* synthetic */ SellerConfirmActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerConfirmActivity$flowOfSetup$2(SellerConfirmActivity sellerConfirmActivity) {
        super(1);
        this.this$0 = sellerConfirmActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(CharSequence charSequence) {
        invoke2(charSequence);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d CharSequence charSequence) {
        TextView Q0;
        TextView Q02;
        Q0 = this.this$0.Q0();
        Q0.setText(charSequence, TextView.BufferType.SPANNABLE);
        Q02 = this.this$0.Q0();
        Q02.setMovementMethod(this.this$0.A0());
    }
}
