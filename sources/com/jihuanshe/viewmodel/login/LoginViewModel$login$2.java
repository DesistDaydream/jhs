package com.jihuanshe.viewmodel.login;

import com.jihuanshe.model.User;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class LoginViewModel$login$2 extends Lambda implements l<User, t1> {
    public final /* synthetic */ LoginViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginViewModel$login$2(LoginViewModel loginViewModel) {
        super(1);
        this.this$0 = loginViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(User user) {
        invoke2(user);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e User user) {
        this.this$0.N0(false);
    }
}
