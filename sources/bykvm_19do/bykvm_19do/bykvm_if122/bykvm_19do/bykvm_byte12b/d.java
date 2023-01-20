package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b;

import android.text.TextUtils;

/* loaded from: classes.dex */
public abstract class d {
    public String a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f720c;

    /* renamed from: d  reason: collision with root package name */
    public String f721d;

    /* renamed from: e  reason: collision with root package name */
    public int f722e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f723f;

    public d(String str, String str2, String str3, String str4, int i2) {
        this.a = str;
        this.f720c = str3;
        this.f722e = i2;
        this.b = str2;
        this.f723f = !TextUtils.isEmpty(str2);
        this.f721d = str4;
    }

    public boolean a() {
        return this.f722e == 1;
    }

    public String b() {
        return this.f721d;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.f720c;
    }

    public int f() {
        return this.f722e;
    }

    public String g() {
        if (TextUtils.isEmpty(this.b)) {
            return this.a;
        }
        return this.a + "_" + this.b;
    }

    public boolean h() {
        return this.f723f;
    }
}
