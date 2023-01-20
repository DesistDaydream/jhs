package com.jihuanshe.ui.page.user.edit;

import com.jihuanshe.R;
import com.jihuanshe.viewmodel.user.edit.EditPhoneNumberViewModel;
import com.vector.util.Res;
import e.n.p;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class EditPhoneNumberActivity$flowOfSetup$1 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ EditPhoneNumberActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditPhoneNumberActivity$flowOfSetup$1(EditPhoneNumberActivity editPhoneNumberActivity) {
        super(1);
        this.this$0 = editPhoneNumberActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        String str;
        if (i2 == this.this$0.i0()) {
            p X0 = ((EditPhoneNumberViewModel) this.this$0.L()).X0();
            Res res = Res.a;
            X0.setValue(Res.w(res, R.string.common_edit_original_phone, null, 2, null));
            ((EditPhoneNumberViewModel) this.this$0.L()).W0().setValue(Res.w(res, R.string.common_edit_input_original_phone, null, 2, null));
            return;
        }
        if (i2 == this.this$0.h0() || i2 == this.this$0.f0()) {
            p X02 = ((EditPhoneNumberViewModel) this.this$0.L()).X0();
            Res res2 = Res.a;
            X02.setValue(Res.w(res2, R.string.login_input_code, null, 2, null));
            p W0 = ((EditPhoneNumberViewModel) this.this$0.L()).W0();
            Object[] objArr = new Object[1];
            str = this.this$0.t;
            String obj = str != null ? StringsKt__StringsKt.I4(str, 3, 7, "****").toString() : null;
            if (obj == null) {
                obj = "";
            }
            objArr[0] = obj;
            W0.setValue(res2.v(R.string.login_send_to, objArr));
        } else if (i2 == this.this$0.e0()) {
            p X03 = ((EditPhoneNumberViewModel) this.this$0.L()).X0();
            Res res3 = Res.a;
            X03.setValue(Res.w(res3, R.string.common_edit_new_phone, null, 2, null));
            ((EditPhoneNumberViewModel) this.this$0.L()).W0().setValue(Res.w(res3, R.string.common_edit_input_new_phone, null, 2, null));
        }
    }
}
