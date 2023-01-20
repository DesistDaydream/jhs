package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: classes4.dex */
public class OpenId {
    public long a;
    public String b;

    /* renamed from: c */
    public String f17118c;

    /* renamed from: d */
    public int f17119d;

    public OpenId(String str) {
        this.f17118c = str;
    }

    public void a(int i2) {
        this.f17119d = i2;
    }

    public void a(long j2) {
        this.a = j2;
    }

    public void a(String str) {
        this.b = str;
    }

    public boolean a() {
        return this.a > System.currentTimeMillis();
    }

    public void b() {
        this.a = 0L;
    }
}
