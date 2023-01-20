package com.jihuanshe.ui.page.login;

import android.widget.TextView;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.User;
import com.jihuanshe.viewmodel.login.LoginViewModel;
import com.jihuanshe.wxapi.WXTool;
import com.vector.util.Res;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class LoginActivity$flowOfSetup$1 extends Lambda implements l<String, t1> {
    public final /* synthetic */ LoginActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.login.LoginActivity$flowOfSetup$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<User, t1> {
        public final /* synthetic */ LoginActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(LoginActivity loginActivity) {
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
            TextView textView;
            if (user == null) {
                return;
            }
            String phone = user.getPhone();
            if (phone == null || phone.length() == 0) {
                this.this$0.y = user;
                textView = this.this$0.G;
                if (textView != null) {
                    textView.setText(Res.w(Res.a, R.string.common_change_phone, null, 2, null));
                }
                ((LoginViewModel) this.this$0.L()).getType().setValue(Integer.valueOf(LoginActivity.H.a()));
                return;
            }
            this.this$0.J0(user);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoginActivity$flowOfSetup$1(LoginActivity loginActivity) {
        super(1);
        this.this$0 = loginActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(String str) {
        invoke2(str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d String str) {
        LoginActivity loginActivity;
        a<User> i2;
        a k2;
        if (str.length() == 0) {
            return;
        }
        WXTool.a.d().p();
        a<User> L0 = ((LoginViewModel) this.this$0.L()).L0(str);
        if (L0 == null || (i2 = L0.i((loginActivity = this.this$0), new AnonymousClass1(loginActivity))) == null || (k2 = BinderKt.k(i2, this.this$0, false, 2, null)) == null) {
            return;
        }
        BinderKt.p(k2);
    }
}
