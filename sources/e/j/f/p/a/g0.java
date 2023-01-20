package e.j.f.p.a;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class g0 extends q {
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11410c;

    /* renamed from: d  reason: collision with root package name */
    private final String f11411d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11412e;

    /* renamed from: f  reason: collision with root package name */
    private final String f11413f;

    /* renamed from: g  reason: collision with root package name */
    private final String f11414g;

    /* renamed from: h  reason: collision with root package name */
    private final int f11415h;

    /* renamed from: i  reason: collision with root package name */
    private final char f11416i;

    /* renamed from: j  reason: collision with root package name */
    private final String f11417j;

    public g0(String str, String str2, String str3, String str4, String str5, String str6, int i2, char c2, String str7) {
        super(ParsedResultType.VIN);
        this.b = str;
        this.f11410c = str2;
        this.f11411d = str3;
        this.f11412e = str4;
        this.f11413f = str5;
        this.f11414g = str6;
        this.f11415h = i2;
        this.f11416i = c2;
        this.f11417j = str7;
    }

    @Override // e.j.f.p.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(50);
        sb.append(this.f11410c);
        sb.append(' ');
        sb.append(this.f11411d);
        sb.append(' ');
        sb.append(this.f11412e);
        sb.append('\n');
        String str = this.f11413f;
        if (str != null) {
            sb.append(str);
            sb.append(' ');
        }
        sb.append(this.f11415h);
        sb.append(' ');
        sb.append(this.f11416i);
        sb.append(' ');
        sb.append(this.f11417j);
        sb.append('\n');
        return sb.toString();
    }

    public String d() {
        return this.f11413f;
    }

    public int e() {
        return this.f11415h;
    }

    public char f() {
        return this.f11416i;
    }

    public String g() {
        return this.f11417j;
    }

    public String h() {
        return this.b;
    }

    public String i() {
        return this.f11414g;
    }

    public String j() {
        return this.f11411d;
    }

    public String k() {
        return this.f11412e;
    }

    public String l() {
        return this.f11410c;
    }
}
