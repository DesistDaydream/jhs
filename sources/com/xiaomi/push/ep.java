package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.db;
import com.xiaomi.push.service.aj;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ep {
    public static void a(aj.b bVar, String str, fb fbVar) {
        String a;
        db.c cVar = new db.c();
        if (!TextUtils.isEmpty(bVar.f9075c)) {
            cVar.a(bVar.f9075c);
        }
        if (!TextUtils.isEmpty(bVar.f9078f)) {
            cVar.d(bVar.f9078f);
        }
        if (!TextUtils.isEmpty(bVar.f9079g)) {
            cVar.e(bVar.f9079g);
        }
        cVar.b(bVar.f9077e ? "1" : "0");
        if (TextUtils.isEmpty(bVar.f9076d)) {
            cVar.c("XIAOMI-SASL");
        } else {
            cVar.c(bVar.f9076d);
        }
        eq eqVar = new eq();
        eqVar.c(bVar.b);
        eqVar.a(Integer.parseInt(bVar.f9080h));
        eqVar.b(bVar.a);
        eqVar.a("BIND", (String) null);
        eqVar.a(eqVar.h());
        com.xiaomi.a.a.a.c.a("[Slim]: bind id=" + eqVar.h());
        HashMap hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.f9075c);
        hashMap.put("chid", bVar.f9080h);
        hashMap.put("from", bVar.b);
        hashMap.put("id", eqVar.h());
        hashMap.put("to", "xiaomi.com");
        if (bVar.f9077e) {
            hashMap.put("kick", "1");
        } else {
            hashMap.put("kick", "0");
        }
        if (TextUtils.isEmpty(bVar.f9078f)) {
            hashMap.put("client_attrs", "");
        } else {
            hashMap.put("client_attrs", bVar.f9078f);
        }
        if (TextUtils.isEmpty(bVar.f9079g)) {
            hashMap.put("cloud_attrs", "");
        } else {
            hashMap.put("cloud_attrs", bVar.f9079g);
        }
        if (bVar.f9076d.equals("XIAOMI-PASS") || bVar.f9076d.equals("XMPUSH-PASS")) {
            a = ap.a(bVar.f9076d, null, hashMap, bVar.f9081i);
        } else {
            bVar.f9076d.equals("XIAOMI-SASL");
            a = null;
        }
        cVar.f(a);
        eqVar.a(cVar.z(), (String) null);
        fbVar.b(eqVar);
    }

    public static void a(String str, String str2, fb fbVar) {
        eq eqVar = new eq();
        eqVar.c(str2);
        eqVar.a(Integer.parseInt(str));
        eqVar.a("UBND", (String) null);
        fbVar.b(eqVar);
    }
}
