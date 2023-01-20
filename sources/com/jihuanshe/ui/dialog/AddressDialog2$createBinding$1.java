package com.jihuanshe.ui.dialog;

import com.vector.ext.AnyKt;
import com.xres.address_selector.db.entity.Area;
import com.xres.address_selector.db.entity.City;
import com.xres.address_selector.db.entity.Province;
import h.k2.u.q;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddressDialog2$createBinding$1 extends Lambda implements q<Province, City, Area, t1> {
    public final /* synthetic */ AddressDialog2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddressDialog2$createBinding$1(AddressDialog2 addressDialog2) {
        super(3);
        this.this$0 = addressDialog2;
    }

    @Override // h.k2.u.q
    public /* bridge */ /* synthetic */ t1 invoke(Province province, City city, Area area) {
        invoke2(province, city, area);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Province province, @d City city, @d Area area) {
        if (AnyKt.k(province) && AnyKt.k(city) && AnyKt.k(area)) {
            q<String, String, String, t1> listener = this.this$0.getListener();
            if (listener != null) {
                listener.invoke(province.getName(), city.getName(), area.getName());
            }
            this.this$0.h();
        }
    }
}
