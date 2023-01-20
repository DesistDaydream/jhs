package e.j.f.p.a;

import com.google.zxing.client.result.ParsedResultType;
import java.util.Map;

/* loaded from: classes2.dex */
public final class k extends q {
    public static final String q = "KG";
    public static final String r = "LB";
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11433c;

    /* renamed from: d  reason: collision with root package name */
    private final String f11434d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11435e;

    /* renamed from: f  reason: collision with root package name */
    private final String f11436f;

    /* renamed from: g  reason: collision with root package name */
    private final String f11437g;

    /* renamed from: h  reason: collision with root package name */
    private final String f11438h;

    /* renamed from: i  reason: collision with root package name */
    private final String f11439i;

    /* renamed from: j  reason: collision with root package name */
    private final String f11440j;

    /* renamed from: k  reason: collision with root package name */
    private final String f11441k;

    /* renamed from: l  reason: collision with root package name */
    private final String f11442l;

    /* renamed from: m  reason: collision with root package name */
    private final String f11443m;
    private final String n;
    private final String o;
    private final Map<String, String> p;

    public k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(ParsedResultType.PRODUCT);
        this.b = str;
        this.f11433c = str2;
        this.f11434d = str3;
        this.f11435e = str4;
        this.f11436f = str5;
        this.f11437g = str6;
        this.f11438h = str7;
        this.f11439i = str8;
        this.f11440j = str9;
        this.f11441k = str10;
        this.f11442l = str11;
        this.f11443m = str12;
        this.n = str13;
        this.o = str14;
        this.p = map;
    }

    private static boolean d(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static int t(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // e.j.f.p.a.q
    public String a() {
        return String.valueOf(this.b);
    }

    public String e() {
        return this.f11438h;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            k kVar = (k) obj;
            return d(this.f11433c, kVar.f11433c) && d(this.f11434d, kVar.f11434d) && d(this.f11435e, kVar.f11435e) && d(this.f11436f, kVar.f11436f) && d(this.f11438h, kVar.f11438h) && d(this.f11439i, kVar.f11439i) && d(this.f11440j, kVar.f11440j) && d(this.f11441k, kVar.f11441k) && d(this.f11442l, kVar.f11442l) && d(this.f11443m, kVar.f11443m) && d(this.n, kVar.n) && d(this.o, kVar.o) && d(this.p, kVar.p);
        }
        return false;
    }

    public String f() {
        return this.f11439i;
    }

    public String g() {
        return this.f11435e;
    }

    public String h() {
        return this.f11437g;
    }

    public int hashCode() {
        return ((((((((((((t(this.f11433c) ^ 0) ^ t(this.f11434d)) ^ t(this.f11435e)) ^ t(this.f11436f)) ^ t(this.f11438h)) ^ t(this.f11439i)) ^ t(this.f11440j)) ^ t(this.f11441k)) ^ t(this.f11442l)) ^ t(this.f11443m)) ^ t(this.n)) ^ t(this.o)) ^ t(this.p);
    }

    public String i() {
        return this.f11443m;
    }

    public String j() {
        return this.o;
    }

    public String k() {
        return this.n;
    }

    public String l() {
        return this.f11433c;
    }

    public String m() {
        return this.f11436f;
    }

    public String n() {
        return this.b;
    }

    public String o() {
        return this.f11434d;
    }

    public Map<String, String> p() {
        return this.p;
    }

    public String q() {
        return this.f11440j;
    }

    public String r() {
        return this.f11442l;
    }

    public String s() {
        return this.f11441k;
    }
}
