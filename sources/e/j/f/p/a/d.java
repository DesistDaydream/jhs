package e.j.f.p.a;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class d extends q {
    private final String[] b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f11380c;

    /* renamed from: d  reason: collision with root package name */
    private final String f11381d;

    /* renamed from: e  reason: collision with root package name */
    private final String[] f11382e;

    /* renamed from: f  reason: collision with root package name */
    private final String[] f11383f;

    /* renamed from: g  reason: collision with root package name */
    private final String[] f11384g;

    /* renamed from: h  reason: collision with root package name */
    private final String[] f11385h;

    /* renamed from: i  reason: collision with root package name */
    private final String f11386i;

    /* renamed from: j  reason: collision with root package name */
    private final String f11387j;

    /* renamed from: k  reason: collision with root package name */
    private final String[] f11388k;

    /* renamed from: l  reason: collision with root package name */
    private final String[] f11389l;

    /* renamed from: m  reason: collision with root package name */
    private final String f11390m;
    private final String n;
    private final String o;
    private final String[] p;
    private final String[] q;

    public d(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String[] strArr7) {
        this(strArr, null, null, strArr2, strArr3, strArr4, strArr5, null, null, strArr6, strArr7, null, null, null, null, null);
    }

    @Override // e.j.f.p.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        q.c(this.b, sb);
        q.c(this.f11380c, sb);
        q.b(this.f11381d, sb);
        q.b(this.o, sb);
        q.b(this.f11390m, sb);
        q.c(this.f11388k, sb);
        q.c(this.f11382e, sb);
        q.c(this.f11384g, sb);
        q.b(this.f11386i, sb);
        q.c(this.p, sb);
        q.b(this.n, sb);
        q.c(this.q, sb);
        q.b(this.f11387j, sb);
        return sb.toString();
    }

    public String[] d() {
        return this.f11389l;
    }

    public String[] e() {
        return this.f11388k;
    }

    public String f() {
        return this.n;
    }

    public String[] g() {
        return this.f11385h;
    }

    public String[] h() {
        return this.f11384g;
    }

    public String[] i() {
        return this.q;
    }

    public String j() {
        return this.f11386i;
    }

    public String[] k() {
        return this.b;
    }

    public String[] l() {
        return this.f11380c;
    }

    public String m() {
        return this.f11387j;
    }

    public String n() {
        return this.f11390m;
    }

    public String[] o() {
        return this.f11382e;
    }

    public String[] p() {
        return this.f11383f;
    }

    public String q() {
        return this.f11381d;
    }

    public String r() {
        return this.o;
    }

    public String[] s() {
        return this.p;
    }

    public d(String[] strArr, String[] strArr2, String str, String[] strArr3, String[] strArr4, String[] strArr5, String[] strArr6, String str2, String str3, String[] strArr7, String[] strArr8, String str4, String str5, String str6, String[] strArr9, String[] strArr10) {
        super(ParsedResultType.ADDRESSBOOK);
        if (strArr3 != null && strArr4 != null && strArr3.length != strArr4.length) {
            throw new IllegalArgumentException("Phone numbers and types lengths differ");
        }
        if (strArr5 != null && strArr6 != null && strArr5.length != strArr6.length) {
            throw new IllegalArgumentException("Emails and types lengths differ");
        }
        if (strArr7 != null && strArr8 != null && strArr7.length != strArr8.length) {
            throw new IllegalArgumentException("Addresses and types lengths differ");
        }
        this.b = strArr;
        this.f11380c = strArr2;
        this.f11381d = str;
        this.f11382e = strArr3;
        this.f11383f = strArr4;
        this.f11384g = strArr5;
        this.f11385h = strArr6;
        this.f11386i = str2;
        this.f11387j = str3;
        this.f11388k = strArr7;
        this.f11389l = strArr8;
        this.f11390m = str4;
        this.n = str5;
        this.o = str6;
        this.p = strArr9;
        this.q = strArr10;
    }
}
