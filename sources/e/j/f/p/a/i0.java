package e.j.f.p.a;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class i0 extends q {
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11425c;

    /* renamed from: d  reason: collision with root package name */
    private final String f11426d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f11427e;

    /* renamed from: f  reason: collision with root package name */
    private final String f11428f;

    /* renamed from: g  reason: collision with root package name */
    private final String f11429g;

    /* renamed from: h  reason: collision with root package name */
    private final String f11430h;

    /* renamed from: i  reason: collision with root package name */
    private final String f11431i;

    public i0(String str, String str2, String str3) {
        this(str, str2, str3, false);
    }

    @Override // e.j.f.p.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(80);
        q.b(this.b, sb);
        q.b(this.f11425c, sb);
        q.b(this.f11426d, sb);
        q.b(Boolean.toString(this.f11427e), sb);
        return sb.toString();
    }

    public String d() {
        return this.f11429g;
    }

    public String e() {
        return this.f11430h;
    }

    public String f() {
        return this.f11428f;
    }

    public String g() {
        return this.f11425c;
    }

    public String h() {
        return this.f11426d;
    }

    public String i() {
        return this.f11431i;
    }

    public String j() {
        return this.b;
    }

    public boolean k() {
        return this.f11427e;
    }

    public i0(String str, String str2, String str3, boolean z) {
        this(str, str2, str3, z, null, null, null, null);
    }

    public i0(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7) {
        super(ParsedResultType.WIFI);
        this.b = str2;
        this.f11425c = str;
        this.f11426d = str3;
        this.f11427e = z;
        this.f11428f = str4;
        this.f11429g = str5;
        this.f11430h = str6;
        this.f11431i = str7;
    }
}
