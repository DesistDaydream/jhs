package com.xiaomi.push.service;

import android.util.Pair;
import com.xiaomi.push.gw;
import com.xiaomi.push.gx;
import com.xiaomi.push.gz;
import com.xiaomi.push.hb;
import com.xiaomi.push.ho;
import com.xiaomi.push.hp;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ae {
    public static int a(ad adVar, gw gwVar) {
        return adVar.a(gwVar, af.a[gwVar.ordinal()] != 1 ? 0 : 1);
    }

    private static List<Pair<Integer, Object>> a(List<hb> list, boolean z) {
        if (com.xiaomi.push.h.a(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (hb hbVar : list) {
            int a = hbVar.a();
            gx a2 = gx.a(hbVar.c());
            if (a2 != null) {
                if (z && hbVar.f8761c) {
                    arrayList.add(new Pair(Integer.valueOf(a), null));
                } else {
                    int i2 = af.b[a2.ordinal()];
                    arrayList.add(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? null : new Pair(Integer.valueOf(a), Boolean.valueOf(hbVar.l())) : new Pair(Integer.valueOf(a), hbVar.j()) : new Pair(Integer.valueOf(a), Long.valueOf(hbVar.h())) : new Pair(Integer.valueOf(a), Integer.valueOf(hbVar.f())));
                }
            }
        }
        return arrayList;
    }

    public static void a(ad adVar, ho hoVar) {
        adVar.a(a(hoVar.a(), true));
        adVar.b();
    }

    public static void a(ad adVar, hp hpVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (gz gzVar : hpVar.a()) {
            arrayList.add(new Pair<>(gzVar.d(), Integer.valueOf(gzVar.a())));
            List<Pair<Integer, Object>> a = a(gzVar.b, false);
            if (!com.xiaomi.push.h.a(a)) {
                arrayList2.addAll(a);
            }
        }
        adVar.a(arrayList, arrayList2);
        adVar.b();
    }
}
