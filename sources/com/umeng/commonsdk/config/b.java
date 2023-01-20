package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class b implements f {
    private static Map<String, Boolean> a = new HashMap();
    private static Object b = new Object();

    /* loaded from: classes3.dex */
    public static class a {
        private static final b a = new b();

        private a() {
        }
    }

    public static b b() {
        return a.a;
    }

    public void a() {
        synchronized (b) {
            a.clear();
        }
    }

    private b() {
    }

    public static boolean a(String str) {
        if (d.a(str)) {
            synchronized (b) {
                if (a.containsKey(str)) {
                    return a.get(str).booleanValue();
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (b) {
                Map<String, Boolean> map = a;
                if (map != null) {
                    map.put(str, bool);
                }
            }
        }
    }
}
