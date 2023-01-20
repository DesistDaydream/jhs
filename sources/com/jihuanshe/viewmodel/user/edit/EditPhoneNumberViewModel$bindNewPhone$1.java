package com.jihuanshe.viewmodel.user.edit;

import com.jihuanshe.R;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.User;
import com.vector.util.Res;
import e.l.h.d.f;
import e.l.h.d.i;
import e.l.j.a;
import h.k2.u.l;
import h.t1;
import java.util.Objects;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class EditPhoneNumberViewModel$bindNewPhone$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ String $phone;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditPhoneNumberViewModel$bindNewPhone$1(String str) {
        super(1);
        this.$phone = str;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke */
    public final void invoke2(@e t1 t1Var) {
        UserKV userKV = UserKV.f3913c;
        User w = userKV.w();
        if (w != null) {
            Res res = Res.a;
            String str = this.$phone;
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
            w.setPhone(res.v(R.string.login_send_to, StringsKt__StringsKt.I4(str, 3, 7, "****").toString()));
        }
        userKV.C(w);
        i.d(f.b, a.B, null, 2, null);
    }
}
