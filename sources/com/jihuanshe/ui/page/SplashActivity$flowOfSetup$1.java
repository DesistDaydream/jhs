package com.jihuanshe.ui.page;

import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.PrivateDialog;
import com.jihuanshe.ui.dialog.UseDialog;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SplashActivity$flowOfSetup$1 extends Lambda implements l<PrivateDialog, t1> {
    public final /* synthetic */ SplashActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashActivity$flowOfSetup$1(SplashActivity splashActivity) {
        super(1);
        this.this$0 = splashActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(PrivateDialog privateDialog) {
        invoke2(privateDialog);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d PrivateDialog privateDialog) {
        UseDialog useDialog = new UseDialog(this.this$0);
        SplashActivity splashActivity = this.this$0;
        Res res = Res.a;
        useDialog.setTitle(Res.w(res, R.string.common_private_guide_title, null, 2, null));
        useDialog.setContent(Res.w(res, R.string.guide_tip_content, null, 2, null));
        useDialog.setLeftButtonText(Res.w(res, R.string.common_exit_app, null, 2, null));
        useDialog.setRightButtonText(Res.w(res, R.string.common_see_again, null, 2, null));
        useDialog.setOnClickLeftButton(new SplashActivity$flowOfSetup$1$1$1(privateDialog, splashActivity));
        useDialog.setOnClickRightButton(new SplashActivity$flowOfSetup$1$1$2(useDialog));
        useDialog.y();
    }
}
