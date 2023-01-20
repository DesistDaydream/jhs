package com.jihuanshe.viewmodel.user.edit;

import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EditPhoneNumberViewModel$checkBindPhone$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ String $code;
    public final /* synthetic */ String $phone;
    public final /* synthetic */ EditPhoneNumberViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditPhoneNumberViewModel$checkBindPhone$1(EditPhoneNumberViewModel editPhoneNumberViewModel, String str, String str2) {
        super(1);
        this.this$0 = editPhoneNumberViewModel;
        this.$phone = str;
        this.$code = str2;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        this.this$0.Z0(this.$phone);
        this.this$0.Y0(this.$code);
    }
}
