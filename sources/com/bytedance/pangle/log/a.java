package com.bytedance.pangle.log;

/* loaded from: classes.dex */
public class a {
    private static volatile a a;

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                a = new a();
            }
        }
        return a;
    }

    public static void b() {
        ZeusLogger.d("Zeus/DefaultReporterImpl", "skip default report");
    }
}
