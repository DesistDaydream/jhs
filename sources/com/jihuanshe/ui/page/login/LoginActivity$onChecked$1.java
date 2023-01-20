package com.jihuanshe.ui.page.login;

import android.widget.CompoundButton;
import com.jihuanshe.viewmodel.login.LoginViewModel;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class LoginActivity$onChecked$1 extends Lambda implements p<CompoundButton, Boolean, t1> {
    public final /* synthetic */ LoginActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginActivity$onChecked$1(LoginActivity loginActivity) {
        super(2);
        this.this$0 = loginActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(CompoundButton compoundButton, Boolean bool) {
        invoke(compoundButton, bool.booleanValue());
        return t1.a;
    }

    public final void invoke(@d CompoundButton compoundButton, boolean z) {
        ((LoginViewModel) this.this$0.L()).J0().setValue(Boolean.valueOf(z));
    }
}
