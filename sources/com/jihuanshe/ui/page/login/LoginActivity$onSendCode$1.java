package com.jihuanshe.ui.page.login;

import android.view.View;
import android.widget.EditText;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.page.login.LoginActivity;
import com.jihuanshe.viewmodel.login.LoginViewModel;
import com.vector.util.Res;
import e.g.d.a;
import e.n.p;
import h.k2.u.l;
import h.t1;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class LoginActivity$onSendCode$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ LoginActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.login.LoginActivity$onSendCode$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ LoginActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LoginActivity loginActivity) {
            super(1);
            this.this$0 = loginActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            Integer valueOf;
            e.n.l type = ((LoginViewModel) this.this$0.L()).getType();
            Integer value = ((LoginViewModel) this.this$0.L()).getType().getValue();
            LoginActivity.a aVar = LoginActivity.H;
            int a = aVar.a();
            if (value != null && value.intValue() == a) {
                valueOf = Integer.valueOf(aVar.c());
            } else {
                valueOf = Integer.valueOf(aVar.g());
            }
            type.setValue(valueOf);
            ((LoginViewModel) this.this$0.L()).C0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginActivity$onSendCode$1(LoginActivity loginActivity) {
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
        EditText q0;
        String obj;
        String str;
        String str2;
        String str3;
        String str4;
        EditText o0;
        LoginActivity loginActivity = this.this$0;
        Integer value = ((LoginViewModel) loginActivity.L()).getType().getValue();
        LoginActivity.a aVar = LoginActivity.H;
        int a = aVar.a();
        if (value != null && value.intValue() == a) {
            o0 = this.this$0.o0();
            String obj2 = o0.getText().toString();
            Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.CharSequence");
            obj = StringsKt__StringsKt.B5(obj2).toString();
        } else {
            q0 = this.this$0.q0();
            String obj3 = q0.getText().toString();
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.CharSequence");
            obj = StringsKt__StringsKt.B5(obj3).toString();
        }
        loginActivity.t = obj;
        str = this.this$0.t;
        if (!(str.length() == 0)) {
            str2 = this.this$0.t;
            if (str2.length() != 11) {
                e.l.h.j.b.e.h(this.this$0, Res.w(Res.a, R.string.login_no_input_11_number, null, 2, null), null, null, null, 0, null, 62, null);
                return;
            }
            Integer value2 = ((LoginViewModel) this.this$0.L()).getType().getValue();
            int a2 = aVar.a();
            if ((value2 == null || value2.intValue() != a2) && !((LoginViewModel) this.this$0.L()).J0().getValue().booleanValue()) {
                e.l.h.j.b.e.h(this.this$0, Res.w(Res.a, R.string.login_no_checked_private, null, 2, null), null, null, null, 0, null, 62, null);
                return;
            }
            p F0 = ((LoginViewModel) this.this$0.L()).F0();
            Res res = Res.a;
            str3 = this.this$0.t;
            Objects.requireNonNull(str3, "null cannot be cast to non-null type kotlin.CharSequence");
            F0.setValue(res.v(R.string.login_send_to, StringsKt__StringsKt.I4(str3, 3, 7, "****").toString()));
            str4 = this.this$0.t;
            BinderKt.p(BinderKt.k(a.j(((LoginViewModel) this.this$0.L()).E0(str4), null, new AnonymousClass1(this.this$0), 1, null), this.this$0, false, 2, null));
            return;
        }
        e.l.h.j.b.e.h(this.this$0, Res.w(Res.a, R.string.login_no_input_phone_number, null, 2, null), null, null, null, 0, null, 62, null);
    }
}
