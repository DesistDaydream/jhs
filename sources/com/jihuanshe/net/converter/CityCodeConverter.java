package com.jihuanshe.net.converter;

import com.jihuanshe.model.CityCodeSet;
import com.xres.address_selector.db.entity.City;
import com.xres.address_selector.db.entity.Province;
import e.j.e.f;
import e.j.e.g;
import e.j.e.h;
import e.j.e.j;
import java.lang.reflect.Type;
import java.util.ArrayList;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public final class CityCodeConverter implements g<CityCodeSet> {
    @Override // e.j.e.g
    @d
    /* renamed from: b */
    public CityCodeSet a(@e h hVar, @e Type type, @e f fVar) {
        j r = hVar == null ? null : hVar.r();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        for (Object obj : r.N()) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            String str = (String) obj;
            arrayList.add(new Province(String.valueOf(i2), str));
            e.j.e.e<h> J = r.J(str);
            ArrayList arrayList3 = new ArrayList();
            for (h hVar2 : J) {
                j r2 = hVar2.r();
                arrayList3.add(new City(String.valueOf(r2.I("code").m()), r2.I("city").w(), ""));
            }
            arrayList2.add(arrayList3);
            i2 = i3;
        }
        return new CityCodeSet(arrayList, arrayList2);
    }
}
