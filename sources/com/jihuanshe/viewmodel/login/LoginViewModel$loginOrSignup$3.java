package com.jihuanshe.viewmodel.login;

import com.jihuanshe.model.stat.STATConstant;
import e.g.e.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class LoginViewModel$loginOrSignup$3 extends Lambda implements l<a, t1> {
    public final /* synthetic */ LoginViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginViewModel$loginOrSignup$3(LoginViewModel loginViewModel) {
        super(1);
        this.this$0 = loginViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d a aVar) {
        this.this$0.P0(null, STATConstant.LOGINTYPE.PHONE, false, aVar.h());
        this.this$0.N0(false);
    }
}
