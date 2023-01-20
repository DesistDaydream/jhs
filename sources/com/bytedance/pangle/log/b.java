package com.bytedance.pangle.log;

/* loaded from: classes.dex */
public final class b {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f2305c;

    /* renamed from: d  reason: collision with root package name */
    private long f2306d;

    /* renamed from: e  reason: collision with root package name */
    private long f2307e;

    private b(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.f2305c = str3;
        long currentTimeMillis = System.currentTimeMillis();
        this.f2307e = currentTimeMillis;
        this.f2306d = currentTimeMillis;
        String str4 = this.a;
        ZeusLogger.i(str4, this.b + String.format(" watcher[%s]-start", str3));
    }

    public static b a(String str, String str2, String str3) {
        return new b(str, str2, str3);
    }

    public final long b(String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.f2307e;
        long currentTimeMillis2 = System.currentTimeMillis() - this.f2306d;
        String str2 = this.a;
        ZeusLogger.i(str2, this.b + String.format(" watcher[%s]-%s cost=%s, total=%s", this.f2305c, str, Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2)));
        return currentTimeMillis2;
    }

    public final long a(String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.f2307e;
        String str2 = this.a;
        ZeusLogger.i(str2, this.b + String.format(" watcher[%s]-%s cost=%s", this.f2305c, str, Long.valueOf(currentTimeMillis)));
        this.f2307e = System.currentTimeMillis();
        return currentTimeMillis;
    }

    public final long a() {
        return System.currentTimeMillis() - this.f2306d;
    }
}
