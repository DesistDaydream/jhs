package com.jihuanshe.ui.page.order;

import com.jihuanshe.model.UserAddress;
import e.l.h.d.f;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddAddressActivity$save$2 extends Lambda implements l<UserAddress, t1> {
    public final /* synthetic */ AddAddressActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddAddressActivity$save$2(AddAddressActivity addAddressActivity) {
        super(1);
        this.this$0 = addAddressActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(UserAddress userAddress) {
        invoke2(userAddress);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e UserAddress userAddress) {
        f fVar = f.b;
        String b0 = this.this$0.b0();
        if (b0 == null) {
            b0 = "";
        }
        fVar.c(b0, userAddress);
        this.this$0.finish();
    }
}
