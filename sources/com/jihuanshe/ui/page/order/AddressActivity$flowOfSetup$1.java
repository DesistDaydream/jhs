package com.jihuanshe.ui.page.order;

import com.jihuanshe.model.UserAddress;
import e.l.j.a;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddressActivity$flowOfSetup$1 extends Lambda implements l<List<? extends UserAddress>, t1> {
    public final /* synthetic */ AddressActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddressActivity$flowOfSetup$1(AddressActivity addressActivity) {
        super(1);
        this.this$0 = addressActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends UserAddress> list) {
        invoke2((List<UserAddress>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e List<UserAddress> list) {
        if (!(list == null || list.isEmpty()) || this.this$0.Z()) {
            return;
        }
        AddAddressActivityCreator.create(a.f12235e).start(this.this$0);
        this.this$0.finish();
    }
}
