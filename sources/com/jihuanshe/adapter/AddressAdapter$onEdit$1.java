package com.jihuanshe.adapter;

import android.view.View;
import com.jihuanshe.model.UserAddress;
import com.jihuanshe.ui.page.order.AddAddressActivityCreator;
import e.l.j.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddressAdapter$onEdit$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ UserAddress $item;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddressAdapter$onEdit$1(UserAddress userAddress) {
        super(1);
        this.$item = userAddress;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        AddAddressActivityCreator.create(a.f12237g).oldAddress(this.$item).start(view.getContext());
    }
}
