package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class dd {
    public static void a(Context context, String str, int i2, String str2) {
        m.a(context).a(new df(context, str, i2, str2));
    }

    private static void a(Context context, HashMap<String, String> hashMap) {
        dm a = di.a(context).a();
        if (a != null) {
            a.a(context, hashMap);
        }
    }

    private static void b(Context context, HashMap<String, String> hashMap) {
        dm a = di.a(context).a();
        if (a != null) {
            a.c(context, hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Context context, String str, int i2, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("awake_info", str);
            hashMap.put("event_type", String.valueOf(i2));
            hashMap.put(com.heytap.mcssdk.constant.b.f3341i, str2);
            int d2 = di.a(context).d();
            if (d2 != 1) {
                if (d2 != 2) {
                    if (d2 == 3) {
                        a(context, hashMap);
                    }
                }
                c(context, hashMap);
            } else {
                a(context, hashMap);
            }
            b(context, hashMap);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2);
        }
    }

    private static void c(Context context, HashMap<String, String> hashMap) {
        dm a = di.a(context).a();
        if (a != null) {
            a.b(context, hashMap);
        }
    }
}
