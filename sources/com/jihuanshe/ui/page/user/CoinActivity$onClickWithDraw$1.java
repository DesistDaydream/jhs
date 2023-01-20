package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.UseDialog;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CoinActivity$onClickWithDraw$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CoinActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoinActivity$onClickWithDraw$1(CoinActivity coinActivity) {
        super(1);
        this.this$0 = coinActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        UseDialog useDialog = new UseDialog(this.this$0);
        CoinActivity coinActivity = this.this$0;
        Res res = Res.a;
        useDialog.setContent(Res.w(res, R.string.withdraw_deposit_tip, null, 2, null));
        useDialog.setRightButtonText(Res.w(res, R.string.sure, null, 2, null));
        useDialog.setOnClickRightButton(new CoinActivity$onClickWithDraw$1$1$1(coinActivity));
        useDialog.y();
    }
}
