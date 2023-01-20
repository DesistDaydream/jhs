package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class c {
    private static volatile c a;

    /* loaded from: classes.dex */
    public interface a {
        public static final String a = "remote_adserv";
        public static final String b = "remote_novel";
    }

    private c() {
    }

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    public am a(String str) {
        return new am(str);
    }
}
