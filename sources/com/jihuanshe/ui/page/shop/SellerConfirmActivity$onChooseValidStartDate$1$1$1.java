package com.jihuanshe.ui.page.shop;

import android.widget.TextView;
import h.k2.u.q;
import h.t1;
import k.b.a.a.n.l;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerConfirmActivity$onChooseValidStartDate$1$1$1 extends Lambda implements q<String, String, String, t1> {
    public final /* synthetic */ SellerConfirmActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerConfirmActivity$onChooseValidStartDate$1$1$1(SellerConfirmActivity sellerConfirmActivity) {
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
        TextView O0;
        this.this$0.N = str;
        this.this$0.O = str2;
        this.this$0.P = str3;
        O0 = this.this$0.O0();
        O0.setText(str + l.f16189d + str2 + l.f16189d + str3);
    }
}
