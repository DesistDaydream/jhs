package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* loaded from: classes2.dex */
public abstract class l1 {
    public static j1 a;

    public static synchronized j1 a() {
        j1 j1Var;
        synchronized (l1.class) {
            if (a == null) {
                a = o1.c().b();
            }
            j1Var = a;
        }
        return j1Var;
    }

    public static void a(int i2, String str, LinkedHashMap<String, String> linkedHashMap) {
        if (a() == null || !w0.b().a()) {
            return;
        }
        if (i2 == 1 || i2 == 0) {
            a.a(i2, str, linkedHashMap);
            return;
        }
        y.d("hmsSdk", "Data type no longer collects range.type: " + i2);
    }

    @Deprecated
    public static void a(Context context, String str, String str2) {
        if (a() != null) {
            a.a(context, str, str2);
        }
    }

    public static boolean b() {
        return o1.c().a();
    }

    public static void c() {
        if (a() == null || !w0.b().a()) {
            return;
        }
        a.a(-1);
    }
}
