package com.jihuanshe.ui.page.user.edit;

import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.User;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EditUserActivity$flowOfSetup$1 extends Lambda implements a<t1> {
    public final /* synthetic */ EditUserActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditUserActivity$flowOfSetup$1(EditUserActivity editUserActivity) {
        super(0);
        this.this$0 = editUserActivity;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        User d0 = this.this$0.d0();
        if (d0 != null) {
            User w = UserKV.f3913c.w();
            d0.setPhone(w == null ? null : w.getPhone());
        }
        ((e.l.s.o.c.a) this.this$0.L()).A0().r(this.this$0.d0());
    }
}
