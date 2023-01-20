package com.xiaomi.push.service;

import com.xiaomi.push.hq;
import com.xiaomi.push.jc;
import com.xiaomi.push.jl;

/* loaded from: classes3.dex */
public class ce {
    private static b a;
    private static a b;

    /* loaded from: classes3.dex */
    public interface a {
        boolean a(hq hqVar);
    }

    /* loaded from: classes3.dex */
    public interface b {
    }

    public static void a(b bVar) {
        a = bVar;
    }

    public static boolean a(hq hqVar) {
        String str;
        if (b == null || hqVar == null) {
            str = "rc params is null, not cpra";
        } else if (jc.a(jl.a())) {
            return b.a(hqVar);
        } else {
            str = "rc app not permission to cpra";
        }
        com.xiaomi.a.a.a.c.a(str);
        return false;
    }
}
