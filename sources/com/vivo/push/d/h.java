package com.vivo.push.d;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class h extends z {
    public h(com.vivo.push.o oVar) {
        super(oVar);
    }

    @Override // com.vivo.push.l
    public final void a(com.vivo.push.o oVar) {
        com.vivo.push.b.t tVar = (com.vivo.push.b.t) oVar;
        ArrayList<String> d2 = tVar.d();
        List<String> e2 = tVar.e();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int h2 = tVar.h();
        String g2 = tVar.g();
        if (d2 != null) {
            for (String str : d2) {
                if (str.startsWith("ali/")) {
                    arrayList2.add(str.replace("ali/", ""));
                } else if (str.startsWith("tag/")) {
                    arrayList.add(str.replace("tag/", ""));
                }
            }
        }
        if (e2 != null) {
            for (String str2 : e2) {
                if (str2.startsWith("ali/")) {
                    arrayList4.add(str2.replace("ali/", ""));
                } else if (str2.startsWith("tag/")) {
                    arrayList3.add(str2.replace("tag/", ""));
                }
            }
        }
        if (arrayList.size() > 0 || arrayList3.size() > 0) {
            if (arrayList.size() > 0) {
                com.vivo.push.e.a().b(arrayList);
            }
            com.vivo.push.e.a().a(tVar.g(), arrayList3.size() > 0 ? 10000 : h2);
            com.vivo.push.m.b(new i(this, h2, arrayList, arrayList3, g2));
        }
        if (arrayList2.size() > 0 || arrayList4.size() > 0) {
            if (arrayList2.size() > 0) {
                com.vivo.push.e.a().c(arrayList2);
            }
            com.vivo.push.e.a().a(tVar.g(), h2);
            com.vivo.push.m.b(new j(this, h2, arrayList2, arrayList4, g2));
        }
    }
}
