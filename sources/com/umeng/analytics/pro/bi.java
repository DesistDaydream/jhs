package com.umeng.analytics.pro;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class bi implements Serializable {
    private final boolean a;
    public final byte b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7068c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f7069d;

    public bi(byte b, boolean z) {
        this.b = b;
        this.a = false;
        this.f7068c = null;
        this.f7069d = z;
    }

    public boolean a() {
        return this.a;
    }

    public String b() {
        return this.f7068c;
    }

    public boolean c() {
        return this.b == 12;
    }

    public boolean d() {
        byte b = this.b;
        return b == 15 || b == 13 || b == 14;
    }

    public boolean e() {
        return this.f7069d;
    }

    public bi(byte b) {
        this(b, false);
    }

    public bi(byte b, String str) {
        this.b = b;
        this.a = true;
        this.f7068c = str;
        this.f7069d = false;
    }
}
