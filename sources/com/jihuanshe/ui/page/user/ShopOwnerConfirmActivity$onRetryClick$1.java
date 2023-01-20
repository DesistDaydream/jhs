package com.jihuanshe.ui.page.user;

import android.widget.TextView;
import com.jihuanshe.model.VerifyInfo;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopOwnerConfirmActivity$onRetryClick$1 extends Lambda implements l<VerifyInfo, t1> {
    public final /* synthetic */ ShopOwnerConfirmActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopOwnerConfirmActivity$onRetryClick$1(ShopOwnerConfirmActivity shopOwnerConfirmActivity) {
        super(1);
        this.this$0 = shopOwnerConfirmActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(VerifyInfo verifyInfo) {
        invoke2(verifyInfo);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e VerifyInfo verifyInfo) {
        TextView y0;
        y0 = this.this$0.y0();
        y0.setText(verifyInfo == null ? null : verifyInfo.getShopTips());
    }
}
