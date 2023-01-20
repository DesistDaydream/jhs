package com.jihuanshe.ui.page.login;

import android.view.View;
import android.widget.EditText;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.UpdateUserInfoResult;
import com.jihuanshe.model.User;
import com.jihuanshe.viewmodel.login.LoginViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class LoginActivity$onClickUpdate$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ LoginActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.login.LoginActivity$onClickUpdate$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<UpdateUserInfoResult, t1> {
        public final /* synthetic */ String $name;
        public final /* synthetic */ LoginActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LoginActivity loginActivity, String str) {
            super(1);
            this.this$0 = loginActivity;
            this.$name = str;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(UpdateUserInfoResult updateUserInfoResult) {
            invoke2(updateUserInfoResult);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e UpdateUserInfoResult updateUserInfoResult) {
            User user;
            User user2;
            user = this.this$0.y;
            if (user == null) {
                e.l.h.j.b.e.b(this.this$0, R.string.error_unknown, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
                return;
            }
            LoginActivity loginActivity = this.this$0;
            user2 = loginActivity.y;
            user2.setName(this.$name);
            t1 t1Var = t1.a;
            loginActivity.J0(user2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginActivity$onClickUpdate$1(LoginActivity loginActivity) {
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
        EditText s0;
        String str;
        User user;
        s0 = this.this$0.s0();
        String obj = s0.getText().toString();
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
        String obj2 = StringsKt__StringsKt.B5(obj).toString();
        if (obj2.length() == 0) {
            e.l.h.j.b.e.b(this.this$0, R.string.error_name_empty, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        } else if (obj2.length() > 12) {
            e.l.h.j.b.e.b(this.this$0, R.string.error_name_length, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        } else {
            LoginViewModel loginViewModel = (LoginViewModel) this.this$0.L();
            str = this.this$0.u;
            user = this.this$0.y;
            BinderKt.p(BinderKt.k(a.j(loginViewModel.R0(obj2, str, user == null ? null : user.getToken()), null, new AnonymousClass1(this.this$0, obj2), 1, null), this.this$0, false, 2, null));
        }
    }
}
