package com.jihuanshe.ui.page.login;

import com.jihuanshe.model.User;
import com.jihuanshe.viewmodel.login.LoginViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class LoginActivity$onVerify$1$onComplete$2 extends Lambda implements l<User, t1> {
    public final /* synthetic */ LoginActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginActivity$onVerify$1$onComplete$2(LoginActivity loginActivity) {
        super(1);
        this.this$0 = loginActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(User user) {
        invoke2(user);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e User user) {
        if (user == null) {
            return;
        }
        String name = user.getName();
        if (!(name == null || name.length() == 0)) {
            this.this$0.J0(user);
            return;
        }
        ((LoginViewModel) this.this$0.L()).getType().setValue(Integer.valueOf(LoginActivity.H.i()));
        this.this$0.y = user;
    }
}
