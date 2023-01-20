package com.huawei.hms.hatool;

/* loaded from: classes2.dex */
public class x {
    public static x b = new x();
    public a a = new a();

    /* loaded from: classes2.dex */
    public class a {
        public String a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public long f3612c = 0;

        public a() {
        }

        public void a(long j2) {
            x.this.a.f3612c = j2;
        }

        public void a(String str) {
            x.this.a.b = str;
        }

        public void b(String str) {
            x.this.a.a = str;
        }
    }

    public static x d() {
        return b;
    }

    public String a() {
        return this.a.b;
    }

    public void a(String str, String str2) {
        long b2 = b();
        String b3 = r0.b(str, str2);
        if (b3 == null || b3.isEmpty()) {
            y.e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (b2 == 0) {
            b2 = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - b2 <= com.heytap.mcssdk.constant.a.f3317g) {
            return;
        }
        String e2 = e.k.c.a.a.h.g.b.e(16);
        String a2 = e.a(b3, e2);
        this.a.a(b2);
        this.a.b(e2);
        this.a.a(a2);
    }

    public long b() {
        return this.a.f3612c;
    }

    public String c() {
        return this.a.a;
    }
}
