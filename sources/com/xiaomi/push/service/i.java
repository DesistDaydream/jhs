package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.hn;
import java.util.Map;

/* loaded from: classes3.dex */
public class i {
    private static a a;
    private static b b;

    /* loaded from: classes3.dex */
    public interface a {
        void a(Context context, hn hnVar);

        boolean a(Context context, hn hnVar, boolean z);

        Map<String, String> b(Context context, hn hnVar);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String str);

        boolean a(hn hnVar);

        void b(hn hnVar);
    }

    public static void a(Context context, hn hnVar) {
        a aVar = a;
        if (aVar == null || hnVar == null) {
            com.xiaomi.a.a.a.c.a("handle msg wrong");
        } else {
            aVar.a(context, hnVar);
        }
    }

    public static void a(String str) {
        b bVar = b;
        if (bVar == null || str == null) {
            com.xiaomi.a.a.a.c.a("pepa clearMessage is null");
        } else {
            bVar.a(str);
        }
    }

    public static boolean a(Context context, hn hnVar, boolean z) {
        a aVar = a;
        if (aVar == null || hnVar == null) {
            com.xiaomi.a.a.a.c.a("pepa judement listener or container is null");
            return false;
        }
        return aVar.a(context, hnVar, z);
    }

    public static boolean a(hn hnVar) {
        b bVar = b;
        if (bVar == null || hnVar == null) {
            com.xiaomi.a.a.a.c.a("pepa handleReceiveMessage is null");
            return false;
        }
        return bVar.a(hnVar);
    }

    public static Map<String, String> b(Context context, hn hnVar) {
        a aVar = a;
        if (aVar == null || hnVar == null) {
            com.xiaomi.a.a.a.c.a("pepa listener or container is null");
            return null;
        }
        return aVar.b(context, hnVar);
    }

    public static void b(hn hnVar) {
        b bVar = b;
        if (bVar == null || hnVar == null) {
            com.xiaomi.a.a.a.c.a("pepa clearMessage is null");
        } else {
            bVar.b(hnVar);
        }
    }
}
