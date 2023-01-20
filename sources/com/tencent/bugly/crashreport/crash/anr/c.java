package com.tencent.bugly.crashreport.crash.anr;

/* loaded from: classes3.dex */
public final class c {
    private String a = "";
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private String f6585c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6586d;

    public c(String str, long j2) {
        this.f6585c = "";
        this.f6586d = false;
        this.f6585c = str == null ? "" : str;
        this.b = j2;
        this.f6586d = false;
    }

    public final String a() {
        return this.f6585c;
    }

    public final String b() {
        return this.a;
    }

    public final long c() {
        return this.b;
    }

    public final boolean d() {
        return this.f6586d;
    }

    public final void a(String str) {
        if (str == null) {
            str = "";
        }
        this.a = str;
    }

    public final void a(boolean z) {
        this.f6586d = z;
    }
}
