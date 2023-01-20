package com.jihuanshe.viewmodel.login;

import com.jihuanshe.R;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class LoginViewModel$countResend$2 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ LoginViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginViewModel$countResend$2(LoginViewModel loginViewModel) {
        super(1);
        this.this$0 = loginViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke2(num);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Integer num) {
        if (num.intValue() > 0) {
            this.this$0.G0().setValue(Boolean.FALSE);
            this.this$0.H0().setValue(Res.a.v(R.string.login_resend_count, num));
            return;
        }
        this.this$0.G0().setValue(Boolean.TRUE);
        this.this$0.H0().setValue(Res.w(Res.a, R.string.login_resend, null, 2, null));
    }
}
