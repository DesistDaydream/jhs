package com.jihuanshe.ui.page.login;

import android.view.View;
import com.jihuanshe.viewmodel.login.LoginViewModel;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class LoginActivity$checkedBtn$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ LoginActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginActivity$checkedBtn$1(LoginActivity loginActivity) {
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
        ((LoginViewModel) this.this$0.L()).J0().setValue(Boolean.valueOf(!f0.g(((LoginViewModel) this.this$0.L()).J0().getValue(), Boolean.TRUE)));
    }
}
