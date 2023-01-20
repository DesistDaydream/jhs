package com.jihuanshe.ui.dialog;

import com.vector.ext.AnyKt;
import com.xres.address_selector.db.entity.City;
import com.xres.address_selector.db.entity.Province;
import h.k2.u.p;
import h.k2.u.q;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddressDialog3$createBinding$1 extends Lambda implements p<Province, City, t1> {
    public final /* synthetic */ AddressDialog3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddressDialog3$createBinding$1(AddressDialog3 addressDialog3) {
        super(2);
        this.this$0 = addressDialog3;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(Province province, City city) {
        invoke2(province, city);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Province province, @d City city) {
        if (AnyKt.k(province) && AnyKt.k(city)) {
            q<String, String, String, t1> listener = this.this$0.getListener();
            if (listener != null) {
                listener.invoke(province.getName(), city.getName(), city.getCode());
            }
            this.this$0.h();
        }
    }
}
