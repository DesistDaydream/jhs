package com.xiaomi.push;

import java.util.Objects;

/* loaded from: classes3.dex */
public final class db {

    /* loaded from: classes3.dex */
    public static final class a extends de {
        private boolean a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8366c;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8368e;

        /* renamed from: g  reason: collision with root package name */
        private boolean f8370g;

        /* renamed from: i  reason: collision with root package name */
        private boolean f8372i;

        /* renamed from: k  reason: collision with root package name */
        private boolean f8374k;

        /* renamed from: m  reason: collision with root package name */
        private boolean f8376m;
        private boolean o;
        private boolean q;
        private boolean s;
        private boolean u;
        private int b = 0;

        /* renamed from: d  reason: collision with root package name */
        private long f8367d = 0;

        /* renamed from: f  reason: collision with root package name */
        private String f8369f = "";

        /* renamed from: h  reason: collision with root package name */
        private String f8371h = "";

        /* renamed from: j  reason: collision with root package name */
        private String f8373j = "";

        /* renamed from: l  reason: collision with root package name */
        private String f8375l = "";
        private String n = "";
        private int p = 1;
        private int r = 0;
        private int t = 0;
        private String v = "";
        private int w = -1;

        public int a() {
            return this.b;
        }

        public a a(int i2) {
            this.a = true;
            this.b = i2;
            return this;
        }

        public a a(long j2) {
            this.f8366c = true;
            this.f8367d = j2;
            return this;
        }

        @Override // com.xiaomi.push.de
        /* renamed from: a */
        public a c(ab abVar) {
            while (true) {
                int a = abVar.a();
                switch (a) {
                    case 0:
                        return this;
                    case 8:
                        a(abVar.e());
                        break;
                    case 16:
                        a(abVar.d());
                        break;
                    case 26:
                        a(abVar.g());
                        break;
                    case 34:
                        b(abVar.g());
                        break;
                    case 42:
                        c(abVar.g());
                        break;
                    case 50:
                        d(abVar.g());
                        break;
                    case 58:
                        e(abVar.g());
                        break;
                    case 64:
                        b(abVar.e());
                        break;
                    case 72:
                        c(abVar.e());
                        break;
                    case 80:
                        d(abVar.e());
                        break;
                    case 90:
                        f(abVar.g());
                        break;
                    default:
                        if (a(abVar, a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public a a(String str) {
            this.f8368e = true;
            this.f8369f = str;
            return this;
        }

        @Override // com.xiaomi.push.de
        public void a(bc bcVar) {
            if (b()) {
                bcVar.a(1, a());
            }
            if (d()) {
                bcVar.b(2, c());
            }
            if (f()) {
                bcVar.a(3, e());
            }
            if (h()) {
                bcVar.a(4, g());
            }
            if (j()) {
                bcVar.a(5, i());
            }
            if (n()) {
                bcVar.a(6, m());
            }
            if (q()) {
                bcVar.a(7, p());
            }
            if (r()) {
                bcVar.a(8, s());
            }
            if (u()) {
                bcVar.a(9, t());
            }
            if (w()) {
                bcVar.a(10, v());
            }
            if (y()) {
                bcVar.a(11, x());
            }
        }

        public a b(int i2) {
            this.o = true;
            this.p = i2;
            return this;
        }

        public a b(String str) {
            this.f8370g = true;
            this.f8371h = str;
            return this;
        }

        public boolean b() {
            return this.a;
        }

        public long c() {
            return this.f8367d;
        }

        public a c(int i2) {
            this.q = true;
            this.r = i2;
            return this;
        }

        public a c(String str) {
            this.f8372i = true;
            this.f8373j = str;
            return this;
        }

        public a d(int i2) {
            this.s = true;
            this.t = i2;
            return this;
        }

        public a d(String str) {
            this.f8374k = true;
            this.f8375l = str;
            return this;
        }

        public boolean d() {
            return this.f8366c;
        }

        public a e(String str) {
            this.f8376m = true;
            this.n = str;
            return this;
        }

        public String e() {
            return this.f8369f;
        }

        public a f(String str) {
            this.u = true;
            this.v = str;
            return this;
        }

        public boolean f() {
            return this.f8368e;
        }

        public String g() {
            return this.f8371h;
        }

        public boolean h() {
            return this.f8370g;
        }

        public String i() {
            return this.f8373j;
        }

        public boolean j() {
            return this.f8372i;
        }

        @Override // com.xiaomi.push.de
        public int k() {
            if (this.w < 0) {
                l();
            }
            return this.w;
        }

        @Override // com.xiaomi.push.de
        public int l() {
            int c2 = b() ? 0 + bc.c(1, a()) : 0;
            if (d()) {
                c2 += bc.d(2, c());
            }
            if (f()) {
                c2 += bc.b(3, e());
            }
            if (h()) {
                c2 += bc.b(4, g());
            }
            if (j()) {
                c2 += bc.b(5, i());
            }
            if (n()) {
                c2 += bc.b(6, m());
            }
            if (q()) {
                c2 += bc.b(7, p());
            }
            if (r()) {
                c2 += bc.c(8, s());
            }
            if (u()) {
                c2 += bc.c(9, t());
            }
            if (w()) {
                c2 += bc.c(10, v());
            }
            if (y()) {
                c2 += bc.b(11, x());
            }
            this.w = c2;
            return c2;
        }

        public String m() {
            return this.f8375l;
        }

        public boolean n() {
            return this.f8374k;
        }

        public a o() {
            this.f8374k = false;
            this.f8375l = "";
            return this;
        }

        public String p() {
            return this.n;
        }

        public boolean q() {
            return this.f8376m;
        }

        public boolean r() {
            return this.o;
        }

        public int s() {
            return this.p;
        }

        public int t() {
            return this.r;
        }

        public boolean u() {
            return this.q;
        }

        public int v() {
            return this.t;
        }

        public boolean w() {
            return this.s;
        }

        public String x() {
            return this.v;
        }

        public boolean y() {
            return this.u;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends de {
        private boolean a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8377c;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8379e;

        /* renamed from: g  reason: collision with root package name */
        private boolean f8381g;
        private boolean b = false;

        /* renamed from: d  reason: collision with root package name */
        private int f8378d = 0;

        /* renamed from: f  reason: collision with root package name */
        private int f8380f = 0;

        /* renamed from: h  reason: collision with root package name */
        private int f8382h = 0;

        /* renamed from: i  reason: collision with root package name */
        private int f8383i = -1;

        public static b a(byte[] bArr) {
            return (b) new b().b(bArr);
        }

        public b a(int i2) {
            this.f8377c = true;
            this.f8378d = i2;
            return this;
        }

        @Override // com.xiaomi.push.de
        /* renamed from: a */
        public b c(ab abVar) {
            while (true) {
                int a = abVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 8) {
                    a(abVar.f());
                } else if (a == 24) {
                    a(abVar.e());
                } else if (a == 32) {
                    b(abVar.e());
                } else if (a == 40) {
                    c(abVar.e());
                } else if (!a(abVar, a)) {
                    return this;
                }
            }
        }

        public b a(boolean z) {
            this.a = true;
            this.b = z;
            return this;
        }

        @Override // com.xiaomi.push.de
        public void a(bc bcVar) {
            if (b()) {
                bcVar.a(1, a());
            }
            if (d()) {
                bcVar.a(3, c());
            }
            if (f()) {
                bcVar.a(4, e());
            }
            if (h()) {
                bcVar.a(5, g());
            }
        }

        public boolean a() {
            return this.b;
        }

        public b b(int i2) {
            this.f8379e = true;
            this.f8380f = i2;
            return this;
        }

        public boolean b() {
            return this.a;
        }

        public int c() {
            return this.f8378d;
        }

        public b c(int i2) {
            this.f8381g = true;
            this.f8382h = i2;
            return this;
        }

        public boolean d() {
            return this.f8377c;
        }

        public int e() {
            return this.f8380f;
        }

        public boolean f() {
            return this.f8379e;
        }

        public int g() {
            return this.f8382h;
        }

        public boolean h() {
            return this.f8381g;
        }

        @Override // com.xiaomi.push.de
        public int k() {
            if (this.f8383i < 0) {
                l();
            }
            return this.f8383i;
        }

        @Override // com.xiaomi.push.de
        public int l() {
            int b = b() ? 0 + bc.b(1, a()) : 0;
            if (d()) {
                b += bc.c(3, c());
            }
            if (f()) {
                b += bc.c(4, e());
            }
            if (h()) {
                b += bc.c(5, g());
            }
            this.f8383i = b;
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends de {
        private boolean a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8384c;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8386e;

        /* renamed from: g  reason: collision with root package name */
        private boolean f8388g;

        /* renamed from: i  reason: collision with root package name */
        private boolean f8390i;

        /* renamed from: k  reason: collision with root package name */
        private boolean f8392k;
        private String b = "";

        /* renamed from: d  reason: collision with root package name */
        private String f8385d = "";

        /* renamed from: f  reason: collision with root package name */
        private String f8387f = "";

        /* renamed from: h  reason: collision with root package name */
        private String f8389h = "";

        /* renamed from: j  reason: collision with root package name */
        private String f8391j = "";

        /* renamed from: l  reason: collision with root package name */
        private String f8393l = "";

        /* renamed from: m  reason: collision with root package name */
        private int f8394m = -1;

        @Override // com.xiaomi.push.de
        /* renamed from: a */
        public c c(ab abVar) {
            while (true) {
                int a = abVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    a(abVar.g());
                } else if (a == 18) {
                    b(abVar.g());
                } else if (a == 26) {
                    c(abVar.g());
                } else if (a == 34) {
                    d(abVar.g());
                } else if (a == 42) {
                    e(abVar.g());
                } else if (a == 50) {
                    f(abVar.g());
                } else if (!a(abVar, a)) {
                    return this;
                }
            }
        }

        public c a(String str) {
            this.a = true;
            this.b = str;
            return this;
        }

        public String a() {
            return this.b;
        }

        @Override // com.xiaomi.push.de
        public void a(bc bcVar) {
            if (b()) {
                bcVar.a(1, a());
            }
            if (d()) {
                bcVar.a(2, c());
            }
            if (f()) {
                bcVar.a(3, e());
            }
            if (h()) {
                bcVar.a(4, g());
            }
            if (j()) {
                bcVar.a(5, i());
            }
            if (n()) {
                bcVar.a(6, m());
            }
        }

        public c b(String str) {
            this.f8384c = true;
            this.f8385d = str;
            return this;
        }

        public boolean b() {
            return this.a;
        }

        public c c(String str) {
            this.f8386e = true;
            this.f8387f = str;
            return this;
        }

        public String c() {
            return this.f8385d;
        }

        public c d(String str) {
            this.f8388g = true;
            this.f8389h = str;
            return this;
        }

        public boolean d() {
            return this.f8384c;
        }

        public c e(String str) {
            this.f8390i = true;
            this.f8391j = str;
            return this;
        }

        public String e() {
            return this.f8387f;
        }

        public c f(String str) {
            this.f8392k = true;
            this.f8393l = str;
            return this;
        }

        public boolean f() {
            return this.f8386e;
        }

        public String g() {
            return this.f8389h;
        }

        public boolean h() {
            return this.f8388g;
        }

        public String i() {
            return this.f8391j;
        }

        public boolean j() {
            return this.f8390i;
        }

        @Override // com.xiaomi.push.de
        public int k() {
            if (this.f8394m < 0) {
                l();
            }
            return this.f8394m;
        }

        @Override // com.xiaomi.push.de
        public int l() {
            int b = b() ? 0 + bc.b(1, a()) : 0;
            if (d()) {
                b += bc.b(2, c());
            }
            if (f()) {
                b += bc.b(3, e());
            }
            if (h()) {
                b += bc.b(4, g());
            }
            if (j()) {
                b += bc.b(5, i());
            }
            if (n()) {
                b += bc.b(6, m());
            }
            this.f8394m = b;
            return b;
        }

        public String m() {
            return this.f8393l;
        }

        public boolean n() {
            return this.f8392k;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends de {
        private boolean a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8395c;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8397e;

        /* renamed from: g  reason: collision with root package name */
        private boolean f8399g;
        private boolean b = false;

        /* renamed from: d  reason: collision with root package name */
        private String f8396d = "";

        /* renamed from: f  reason: collision with root package name */
        private String f8398f = "";

        /* renamed from: h  reason: collision with root package name */
        private String f8400h = "";

        /* renamed from: i  reason: collision with root package name */
        private int f8401i = -1;

        public static d a(byte[] bArr) {
            return (d) new d().b(bArr);
        }

        @Override // com.xiaomi.push.de
        /* renamed from: a */
        public d c(ab abVar) {
            while (true) {
                int a = abVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 8) {
                    a(abVar.f());
                } else if (a == 18) {
                    a(abVar.g());
                } else if (a == 26) {
                    b(abVar.g());
                } else if (a == 34) {
                    c(abVar.g());
                } else if (!a(abVar, a)) {
                    return this;
                }
            }
        }

        public d a(String str) {
            this.f8395c = true;
            this.f8396d = str;
            return this;
        }

        public d a(boolean z) {
            this.a = true;
            this.b = z;
            return this;
        }

        @Override // com.xiaomi.push.de
        public void a(bc bcVar) {
            if (b()) {
                bcVar.a(1, a());
            }
            if (d()) {
                bcVar.a(2, c());
            }
            if (f()) {
                bcVar.a(3, e());
            }
            if (h()) {
                bcVar.a(4, g());
            }
        }

        public boolean a() {
            return this.b;
        }

        public d b(String str) {
            this.f8397e = true;
            this.f8398f = str;
            return this;
        }

        public boolean b() {
            return this.a;
        }

        public d c(String str) {
            this.f8399g = true;
            this.f8400h = str;
            return this;
        }

        public String c() {
            return this.f8396d;
        }

        public boolean d() {
            return this.f8395c;
        }

        public String e() {
            return this.f8398f;
        }

        public boolean f() {
            return this.f8397e;
        }

        public String g() {
            return this.f8400h;
        }

        public boolean h() {
            return this.f8399g;
        }

        @Override // com.xiaomi.push.de
        public int k() {
            if (this.f8401i < 0) {
                l();
            }
            return this.f8401i;
        }

        @Override // com.xiaomi.push.de
        public int l() {
            int b = b() ? 0 + bc.b(1, a()) : 0;
            if (d()) {
                b += bc.b(2, c());
            }
            if (f()) {
                b += bc.b(3, e());
            }
            if (h()) {
                b += bc.b(4, g());
            }
            this.f8401i = b;
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends de {
        private boolean a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8402c;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8404e;

        /* renamed from: g  reason: collision with root package name */
        private boolean f8406g;

        /* renamed from: i  reason: collision with root package name */
        private boolean f8408i;

        /* renamed from: k  reason: collision with root package name */
        private boolean f8410k;

        /* renamed from: m  reason: collision with root package name */
        private boolean f8412m;
        private boolean o;
        private boolean q;
        private boolean s;
        private int b = 0;

        /* renamed from: d  reason: collision with root package name */
        private String f8403d = "";

        /* renamed from: f  reason: collision with root package name */
        private String f8405f = "";

        /* renamed from: h  reason: collision with root package name */
        private String f8407h = "";

        /* renamed from: j  reason: collision with root package name */
        private int f8409j = 0;

        /* renamed from: l  reason: collision with root package name */
        private String f8411l = "";
        private String n = "";
        private String p = "";
        private b r = null;
        private int t = 0;
        private int u = -1;

        public int a() {
            return this.b;
        }

        public e a(int i2) {
            this.a = true;
            this.b = i2;
            return this;
        }

        @Override // com.xiaomi.push.de
        /* renamed from: a */
        public e c(ab abVar) {
            while (true) {
                int a = abVar.a();
                switch (a) {
                    case 0:
                        return this;
                    case 8:
                        a(abVar.i());
                        break;
                    case 18:
                        a(abVar.g());
                        break;
                    case 26:
                        b(abVar.g());
                        break;
                    case 34:
                        c(abVar.g());
                        break;
                    case 40:
                        b(abVar.e());
                        break;
                    case 50:
                        d(abVar.g());
                        break;
                    case 58:
                        e(abVar.g());
                        break;
                    case 66:
                        f(abVar.g());
                        break;
                    case 74:
                        b bVar = new b();
                        abVar.a(bVar);
                        a(bVar);
                        break;
                    case 80:
                        c(abVar.e());
                        break;
                    default:
                        if (a(abVar, a)) {
                            break;
                        } else {
                            return this;
                        }
                }
            }
        }

        public e a(b bVar) {
            Objects.requireNonNull(bVar);
            this.q = true;
            this.r = bVar;
            return this;
        }

        public e a(String str) {
            this.f8402c = true;
            this.f8403d = str;
            return this;
        }

        @Override // com.xiaomi.push.de
        public void a(bc bcVar) {
            if (b()) {
                bcVar.b(1, a());
            }
            if (d()) {
                bcVar.a(2, c());
            }
            if (f()) {
                bcVar.a(3, e());
            }
            if (h()) {
                bcVar.a(4, g());
            }
            if (j()) {
                bcVar.a(5, i());
            }
            if (n()) {
                bcVar.a(6, m());
            }
            if (p()) {
                bcVar.a(7, o());
            }
            if (r()) {
                bcVar.a(8, q());
            }
            if (s()) {
                bcVar.a(9, t());
            }
            if (v()) {
                bcVar.a(10, u());
            }
        }

        public e b(int i2) {
            this.f8408i = true;
            this.f8409j = i2;
            return this;
        }

        public e b(String str) {
            this.f8404e = true;
            this.f8405f = str;
            return this;
        }

        public boolean b() {
            return this.a;
        }

        public e c(int i2) {
            this.s = true;
            this.t = i2;
            return this;
        }

        public e c(String str) {
            this.f8406g = true;
            this.f8407h = str;
            return this;
        }

        public String c() {
            return this.f8403d;
        }

        public e d(String str) {
            this.f8410k = true;
            this.f8411l = str;
            return this;
        }

        public boolean d() {
            return this.f8402c;
        }

        public e e(String str) {
            this.f8412m = true;
            this.n = str;
            return this;
        }

        public String e() {
            return this.f8405f;
        }

        public e f(String str) {
            this.o = true;
            this.p = str;
            return this;
        }

        public boolean f() {
            return this.f8404e;
        }

        public String g() {
            return this.f8407h;
        }

        public boolean h() {
            return this.f8406g;
        }

        public int i() {
            return this.f8409j;
        }

        public boolean j() {
            return this.f8408i;
        }

        @Override // com.xiaomi.push.de
        public int k() {
            if (this.u < 0) {
                l();
            }
            return this.u;
        }

        @Override // com.xiaomi.push.de
        public int l() {
            int d2 = b() ? 0 + bc.d(1, a()) : 0;
            if (d()) {
                d2 += bc.b(2, c());
            }
            if (f()) {
                d2 += bc.b(3, e());
            }
            if (h()) {
                d2 += bc.b(4, g());
            }
            if (j()) {
                d2 += bc.c(5, i());
            }
            if (n()) {
                d2 += bc.b(6, m());
            }
            if (p()) {
                d2 += bc.b(7, o());
            }
            if (r()) {
                d2 += bc.b(8, q());
            }
            if (s()) {
                d2 += bc.b(9, t());
            }
            if (v()) {
                d2 += bc.c(10, u());
            }
            this.u = d2;
            return d2;
        }

        public String m() {
            return this.f8411l;
        }

        public boolean n() {
            return this.f8410k;
        }

        public String o() {
            return this.n;
        }

        public boolean p() {
            return this.f8412m;
        }

        public String q() {
            return this.p;
        }

        public boolean r() {
            return this.o;
        }

        public boolean s() {
            return this.q;
        }

        public b t() {
            return this.r;
        }

        public int u() {
            return this.t;
        }

        public boolean v() {
            return this.s;
        }
    }

    /* loaded from: classes3.dex */
    public static final class f extends de {
        private boolean a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8413c;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8415e;
        private String b = "";

        /* renamed from: d  reason: collision with root package name */
        private String f8414d = "";

        /* renamed from: f  reason: collision with root package name */
        private b f8416f = null;

        /* renamed from: g  reason: collision with root package name */
        private int f8417g = -1;

        public static f a(byte[] bArr) {
            return (f) new f().b(bArr);
        }

        @Override // com.xiaomi.push.de
        /* renamed from: a */
        public f c(ab abVar) {
            while (true) {
                int a = abVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    a(abVar.g());
                } else if (a == 18) {
                    b(abVar.g());
                } else if (a == 26) {
                    b bVar = new b();
                    abVar.a(bVar);
                    a(bVar);
                } else if (!a(abVar, a)) {
                    return this;
                }
            }
        }

        public f a(b bVar) {
            Objects.requireNonNull(bVar);
            this.f8415e = true;
            this.f8416f = bVar;
            return this;
        }

        public f a(String str) {
            this.a = true;
            this.b = str;
            return this;
        }

        public String a() {
            return this.b;
        }

        @Override // com.xiaomi.push.de
        public void a(bc bcVar) {
            if (b()) {
                bcVar.a(1, a());
            }
            if (d()) {
                bcVar.a(2, c());
            }
            if (e()) {
                bcVar.a(3, f());
            }
        }

        public f b(String str) {
            this.f8413c = true;
            this.f8414d = str;
            return this;
        }

        public boolean b() {
            return this.a;
        }

        public String c() {
            return this.f8414d;
        }

        public boolean d() {
            return this.f8413c;
        }

        public boolean e() {
            return this.f8415e;
        }

        public b f() {
            return this.f8416f;
        }

        @Override // com.xiaomi.push.de
        public int k() {
            if (this.f8417g < 0) {
                l();
            }
            return this.f8417g;
        }

        @Override // com.xiaomi.push.de
        public int l() {
            int b = b() ? 0 + bc.b(1, a()) : 0;
            if (d()) {
                b += bc.b(2, c());
            }
            if (e()) {
                b += bc.b(3, f());
            }
            this.f8417g = b;
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class g extends de {
        private boolean a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8418c;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8420e;
        private String b = "";

        /* renamed from: d  reason: collision with root package name */
        private String f8419d = "";

        /* renamed from: f  reason: collision with root package name */
        private String f8421f = "";

        /* renamed from: g  reason: collision with root package name */
        private int f8422g = -1;

        public static g a(byte[] bArr) {
            return (g) new g().b(bArr);
        }

        @Override // com.xiaomi.push.de
        /* renamed from: a */
        public g c(ab abVar) {
            while (true) {
                int a = abVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    a(abVar.g());
                } else if (a == 18) {
                    b(abVar.g());
                } else if (a == 26) {
                    c(abVar.g());
                } else if (!a(abVar, a)) {
                    return this;
                }
            }
        }

        public g a(String str) {
            this.a = true;
            this.b = str;
            return this;
        }

        public String a() {
            return this.b;
        }

        @Override // com.xiaomi.push.de
        public void a(bc bcVar) {
            if (b()) {
                bcVar.a(1, a());
            }
            if (d()) {
                bcVar.a(2, c());
            }
            if (f()) {
                bcVar.a(3, e());
            }
        }

        public g b(String str) {
            this.f8418c = true;
            this.f8419d = str;
            return this;
        }

        public boolean b() {
            return this.a;
        }

        public g c(String str) {
            this.f8420e = true;
            this.f8421f = str;
            return this;
        }

        public String c() {
            return this.f8419d;
        }

        public boolean d() {
            return this.f8418c;
        }

        public String e() {
            return this.f8421f;
        }

        public boolean f() {
            return this.f8420e;
        }

        @Override // com.xiaomi.push.de
        public int k() {
            if (this.f8422g < 0) {
                l();
            }
            return this.f8422g;
        }

        @Override // com.xiaomi.push.de
        public int l() {
            int b = b() ? 0 + bc.b(1, a()) : 0;
            if (d()) {
                b += bc.b(2, c());
            }
            if (f()) {
                b += bc.b(3, e());
            }
            this.f8422g = b;
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class h extends de {
        private boolean a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8423c;
        private int b = 0;

        /* renamed from: d  reason: collision with root package name */
        private String f8424d = "";

        /* renamed from: e  reason: collision with root package name */
        private int f8425e = -1;

        public static h a(byte[] bArr) {
            return (h) new h().b(bArr);
        }

        public int a() {
            return this.b;
        }

        public h a(int i2) {
            this.a = true;
            this.b = i2;
            return this;
        }

        @Override // com.xiaomi.push.de
        /* renamed from: a */
        public h c(ab abVar) {
            while (true) {
                int a = abVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 8) {
                    a(abVar.e());
                } else if (a == 18) {
                    a(abVar.g());
                } else if (!a(abVar, a)) {
                    return this;
                }
            }
        }

        public h a(String str) {
            this.f8423c = true;
            this.f8424d = str;
            return this;
        }

        @Override // com.xiaomi.push.de
        public void a(bc bcVar) {
            if (b()) {
                bcVar.a(1, a());
            }
            if (d()) {
                bcVar.a(2, c());
            }
        }

        public boolean b() {
            return this.a;
        }

        public String c() {
            return this.f8424d;
        }

        public boolean d() {
            return this.f8423c;
        }

        @Override // com.xiaomi.push.de
        public int k() {
            if (this.f8425e < 0) {
                l();
            }
            return this.f8425e;
        }

        @Override // com.xiaomi.push.de
        public int l() {
            int c2 = b() ? 0 + bc.c(1, a()) : 0;
            if (d()) {
                c2 += bc.b(2, c());
            }
            this.f8425e = c2;
            return c2;
        }
    }

    /* loaded from: classes3.dex */
    public static final class i extends de {
        private boolean a;
        private com.xiaomi.push.a b = com.xiaomi.push.a.a;

        /* renamed from: c  reason: collision with root package name */
        private int f8426c = -1;

        public static i a(byte[] bArr) {
            return (i) new i().b(bArr);
        }

        public com.xiaomi.push.a a() {
            return this.b;
        }

        public i a(com.xiaomi.push.a aVar) {
            this.a = true;
            this.b = aVar;
            return this;
        }

        @Override // com.xiaomi.push.de
        /* renamed from: a */
        public i c(ab abVar) {
            while (true) {
                int a = abVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    a(abVar.h());
                } else if (!a(abVar, a)) {
                    return this;
                }
            }
        }

        @Override // com.xiaomi.push.de
        public void a(bc bcVar) {
            if (b()) {
                bcVar.a(1, a());
            }
        }

        public boolean b() {
            return this.a;
        }

        @Override // com.xiaomi.push.de
        public int k() {
            if (this.f8426c < 0) {
                l();
            }
            return this.f8426c;
        }

        @Override // com.xiaomi.push.de
        public int l() {
            int b = b() ? 0 + bc.b(1, a()) : 0;
            this.f8426c = b;
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class j extends de {
        private boolean a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8427c;
        private com.xiaomi.push.a b = com.xiaomi.push.a.a;

        /* renamed from: d  reason: collision with root package name */
        private b f8428d = null;

        /* renamed from: e  reason: collision with root package name */
        private int f8429e = -1;

        public static j a(byte[] bArr) {
            return (j) new j().b(bArr);
        }

        public com.xiaomi.push.a a() {
            return this.b;
        }

        public j a(com.xiaomi.push.a aVar) {
            this.a = true;
            this.b = aVar;
            return this;
        }

        @Override // com.xiaomi.push.de
        /* renamed from: a */
        public j c(ab abVar) {
            while (true) {
                int a = abVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    a(abVar.h());
                } else if (a == 18) {
                    b bVar = new b();
                    abVar.a(bVar);
                    a(bVar);
                } else if (!a(abVar, a)) {
                    return this;
                }
            }
        }

        public j a(b bVar) {
            Objects.requireNonNull(bVar);
            this.f8427c = true;
            this.f8428d = bVar;
            return this;
        }

        @Override // com.xiaomi.push.de
        public void a(bc bcVar) {
            if (b()) {
                bcVar.a(1, a());
            }
            if (c()) {
                bcVar.a(2, d());
            }
        }

        public boolean b() {
            return this.a;
        }

        public boolean c() {
            return this.f8427c;
        }

        public b d() {
            return this.f8428d;
        }

        @Override // com.xiaomi.push.de
        public int k() {
            if (this.f8429e < 0) {
                l();
            }
            return this.f8429e;
        }

        @Override // com.xiaomi.push.de
        public int l() {
            int b = b() ? 0 + bc.b(1, a()) : 0;
            if (c()) {
                b += bc.b(2, d());
            }
            this.f8429e = b;
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class k extends de {
        private boolean a;

        /* renamed from: c  reason: collision with root package name */
        private boolean f8430c;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8432e;

        /* renamed from: g  reason: collision with root package name */
        private boolean f8434g;

        /* renamed from: i  reason: collision with root package name */
        private boolean f8436i;

        /* renamed from: k  reason: collision with root package name */
        private boolean f8438k;
        private String b = "";

        /* renamed from: d  reason: collision with root package name */
        private String f8431d = "";

        /* renamed from: f  reason: collision with root package name */
        private long f8433f = 0;

        /* renamed from: h  reason: collision with root package name */
        private long f8435h = 0;

        /* renamed from: j  reason: collision with root package name */
        private boolean f8437j = false;

        /* renamed from: l  reason: collision with root package name */
        private int f8439l = 0;

        /* renamed from: m  reason: collision with root package name */
        private int f8440m = -1;

        public static k a(byte[] bArr) {
            return (k) new k().b(bArr);
        }

        public k a(int i2) {
            this.f8438k = true;
            this.f8439l = i2;
            return this;
        }

        public k a(long j2) {
            this.f8432e = true;
            this.f8433f = j2;
            return this;
        }

        @Override // com.xiaomi.push.de
        /* renamed from: a */
        public k c(ab abVar) {
            while (true) {
                int a = abVar.a();
                if (a == 0) {
                    return this;
                }
                if (a == 10) {
                    a(abVar.g());
                } else if (a == 18) {
                    b(abVar.g());
                } else if (a == 24) {
                    a(abVar.c());
                } else if (a == 32) {
                    b(abVar.c());
                } else if (a == 40) {
                    a(abVar.f());
                } else if (a == 48) {
                    a(abVar.e());
                } else if (!a(abVar, a)) {
                    return this;
                }
            }
        }

        public k a(String str) {
            this.a = true;
            this.b = str;
            return this;
        }

        public k a(boolean z) {
            this.f8436i = true;
            this.f8437j = z;
            return this;
        }

        public String a() {
            return this.b;
        }

        @Override // com.xiaomi.push.de
        public void a(bc bcVar) {
            if (b()) {
                bcVar.a(1, a());
            }
            if (d()) {
                bcVar.a(2, c());
            }
            if (f()) {
                bcVar.a(3, e());
            }
            if (h()) {
                bcVar.a(4, g());
            }
            if (j()) {
                bcVar.a(5, i());
            }
            if (n()) {
                bcVar.a(6, m());
            }
        }

        public k b(long j2) {
            this.f8434g = true;
            this.f8435h = j2;
            return this;
        }

        public k b(String str) {
            this.f8430c = true;
            this.f8431d = str;
            return this;
        }

        public boolean b() {
            return this.a;
        }

        public String c() {
            return this.f8431d;
        }

        public boolean d() {
            return this.f8430c;
        }

        public long e() {
            return this.f8433f;
        }

        public boolean f() {
            return this.f8432e;
        }

        public long g() {
            return this.f8435h;
        }

        public boolean h() {
            return this.f8434g;
        }

        public boolean i() {
            return this.f8437j;
        }

        public boolean j() {
            return this.f8436i;
        }

        @Override // com.xiaomi.push.de
        public int k() {
            if (this.f8440m < 0) {
                l();
            }
            return this.f8440m;
        }

        @Override // com.xiaomi.push.de
        public int l() {
            int b = b() ? 0 + bc.b(1, a()) : 0;
            if (d()) {
                b += bc.b(2, c());
            }
            if (f()) {
                b += bc.c(3, e());
            }
            if (h()) {
                b += bc.c(4, g());
            }
            if (j()) {
                b += bc.b(5, i());
            }
            if (n()) {
                b += bc.c(6, m());
            }
            this.f8440m = b;
            return b;
        }

        public int m() {
            return this.f8439l;
        }

        public boolean n() {
            return this.f8438k;
        }
    }
}
