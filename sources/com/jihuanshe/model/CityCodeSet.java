package com.jihuanshe.model;

import com.xres.address_selector.db.entity.City;
import com.xres.address_selector.db.entity.Province;
import h.k2.v.u;
import java.util.List;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class CityCodeSet {
    @e
    private final List<List<City>> city;
    @e
    private final List<Province> province;

    public CityCodeSet() {
        this(null, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CityCodeSet(@e List<Province> list, @e List<? extends List<City>> list2) {
        this.province = list;
        this.city = list2;
    }

    @e
    public final List<List<City>> getCity() {
        return this.city;
    }

    @e
    public final List<Province> getProvince() {
        return this.province;
    }

    public /* synthetic */ CityCodeSet(List list, List list2, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? null : list2);
    }
}
