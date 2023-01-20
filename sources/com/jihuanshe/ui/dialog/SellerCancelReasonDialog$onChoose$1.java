package com.jihuanshe.ui.dialog;

import android.view.View;
import android.widget.TextView;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerCancelReasonDialog$onChoose$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerCancelReasonDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerCancelReasonDialog$onChoose$1(SellerCancelReasonDialog sellerCancelReasonDialog) {
        super(1);
        this.this$0 = sellerCancelReasonDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        this.this$0.h();
        this.this$0.getListener().invoke(((TextView) view).getText().toString());
    }
}
