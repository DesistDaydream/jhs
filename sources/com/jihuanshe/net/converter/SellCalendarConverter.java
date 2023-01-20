package com.jihuanshe.net.converter;

import com.jihuanshe.model.SellCalendar;
import e.j.e.f;
import e.j.e.g;
import e.j.e.h;
import e.j.e.j;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class SellCalendarConverter implements g<SellCalendar> {
    @Override // e.j.e.g
    @d
    /* renamed from: b */
    public SellCalendar a(@e h hVar, @e Type type, @e f fVar) {
        Set<String> N;
        SellCalendar sellCalendar = new SellCalendar(null, null, 3, null);
        j r = hVar != null ? hVar.r() : null;
        if (r != null && (N = r.N()) != null) {
            Iterator<T> it = N.iterator();
            if (it.hasNext()) {
                String str = (String) it.next();
                sellCalendar.setId(str);
                sellCalendar.setTime(r.I(str).w());
            }
        }
        return sellCalendar;
    }
}
