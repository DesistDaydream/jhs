package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class i {
    public static Map<String, m> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static i f3539c;
    public l a = new l();

    public static i c() {
        if (f3539c == null) {
            d();
        }
        return f3539c;
    }

    public static synchronized void d() {
        synchronized (i.class) {
            if (f3539c == null) {
                f3539c = new i();
            }
        }
    }

    public m a(String str) {
        return b.get(str);
    }

    public Set<String> a() {
        return b.keySet();
    }

    public void a(String str, m mVar) {
        b.put(str, mVar);
    }

    public l b() {
        return this.a;
    }
}
