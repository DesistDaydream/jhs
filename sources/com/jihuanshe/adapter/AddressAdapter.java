package com.jihuanshe.adapter;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.UserAddress;
import e.t.j.h.g;
import e.t.k.a.c.a;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class AddressAdapter extends a<UserAddress> {
    public AddressAdapter() {
        super(null, 1, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_address;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: v */
    public void u(@d UserAddress userAddress, @d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, userAddress);
        viewDataBinding.setVariable(10, this);
    }

    @d
    public final g w(@d UserAddress userAddress) {
        return e.t.j.h.d.a.a(new AddressAdapter$onEdit$1(userAddress));
    }
}
