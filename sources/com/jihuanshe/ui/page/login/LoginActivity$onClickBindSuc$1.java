package com.jihuanshe.ui.page.login;

import android.view.View;
import com.jihuanshe.model.User;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class LoginActivity$onClickBindSuc$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ LoginActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginActivity$onClickBindSuc$1(LoginActivity loginActivity) {
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
        User user;
        User user2;
        String str;
        user = this.this$0.y;
        if (user == null) {
            return;
        }
        LoginActivity loginActivity = this.this$0;
        user2 = loginActivity.y;
        str = this.this$0.t;
        user2.setPhone(str);
        t1 t1Var = t1.a;
        loginActivity.J0(user2);
    }
}
