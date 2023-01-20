package com.jihuanshe.ui.page.login;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.viewmodel.login.LoginViewModel;
import com.jihuanshe.wxapi.WXTool;
import com.vector.util.Res;
import e.l.h.j.b.e;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class LoginActivity$onLogin$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ LoginActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginActivity$onLogin$1(LoginActivity loginActivity) {
        super(1);
        this.this$0 = loginActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        if (!((LoginViewModel) this.this$0.L()).J0().getValue().booleanValue()) {
            e.h(this.this$0, Res.w(Res.a, R.string.login_no_checked_private, null, 2, null), null, null, null, 0, null, 62, null);
        } else {
            WXTool.a.e();
        }
    }
}
