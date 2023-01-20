package com.jihuanshe.ui.page.order;

import com.jihuanshe.model.UserAddress;
import e.l.h.d.f;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddAddressActivity$save$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ String $a;
    public final /* synthetic */ String $c;
    public final /* synthetic */ String $p;
    public final /* synthetic */ AddAddressActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddAddressActivity$save$1(AddAddressActivity addAddressActivity, String str, String str2, String str3) {
        super(1);
        this.this$0 = addAddressActivity;
        this.$a = str;
        this.$c = str2;
        this.$p = str3;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        f fVar = f.b;
        String b0 = this.this$0.b0();
        if (b0 == null) {
            b0 = "";
        }
        UserAddress e0 = this.this$0.e0();
        if (e0 == null) {
            e0 = null;
        } else {
            String str = this.$a;
            AddAddressActivity addAddressActivity = this.this$0;
            String str2 = this.$c;
            String str3 = this.$p;
            e0.setAddress(str);
            e0.setCity(addAddressActivity.c0());
            e0.setProvince(addAddressActivity.l0());
            e0.setDistrict(addAddressActivity.a0());
            e0.setName(str2);
            e0.setPhone(str3);
            e0.setDefault(addAddressActivity.o0().isChecked() ? 1 : 0);
            t1 t1Var2 = t1.a;
        }
        fVar.c(b0, e0);
        this.this$0.finish();
    }
}
