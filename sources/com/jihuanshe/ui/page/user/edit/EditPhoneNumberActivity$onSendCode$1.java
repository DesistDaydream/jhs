package com.jihuanshe.ui.page.user.edit;

import android.view.View;
import android.widget.EditText;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.user.edit.EditPhoneNumberViewModel;
import com.vector.util.Res;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class EditPhoneNumberActivity$onSendCode$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ EditPhoneNumberActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.edit.EditPhoneNumberActivity$onSendCode$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ EditPhoneNumberActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EditPhoneNumberActivity editPhoneNumberActivity) {
            super(1);
            this.this$0 = editPhoneNumberActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            e.n.l type = ((EditPhoneNumberViewModel) this.this$0.L()).getType();
            Integer value = ((EditPhoneNumberViewModel) this.this$0.L()).getType().getValue();
            type.setValue(Integer.valueOf((value != null && value.intValue() == this.this$0.i0()) ? this.this$0.h0() : this.this$0.f0()));
            ((EditPhoneNumberViewModel) this.this$0.L()).C0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditPhoneNumberActivity$onSendCode$1(EditPhoneNumberActivity editPhoneNumberActivity) {
        super(1);
        this.this$0 = editPhoneNumberActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        EditText Z;
        String str;
        String str2;
        EditText Z2;
        String str3;
        EditPhoneNumberActivity editPhoneNumberActivity = this.this$0;
        Z = editPhoneNumberActivity.Z();
        String obj = Z.getText().toString();
        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
        editPhoneNumberActivity.t = StringsKt__StringsKt.B5(obj).toString();
        str = this.this$0.t;
        if (!(str == null || str.length() == 0)) {
            str2 = this.this$0.t;
            if (str2.length() == 11) {
                Z2 = this.this$0.Z();
                Z2.getText().clear();
                str3 = this.this$0.t;
                BinderKt.p(BinderKt.k(a.j(((EditPhoneNumberViewModel) this.this$0.L()).E0(str3), null, new AnonymousClass1(this.this$0), 1, null), this.this$0, false, 2, null));
                return;
            }
            e.l.h.j.b.e.h(this.this$0, Res.w(Res.a, R.string.login_no_input_11_number, null, 2, null), null, null, null, 0, null, 62, null);
            return;
        }
        e.l.h.j.b.e.h(this.this$0, Res.w(Res.a, R.string.login_no_input_phone_number, null, 2, null), null, null, null, 0, null, 62, null);
    }
}
