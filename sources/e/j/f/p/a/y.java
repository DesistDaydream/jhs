package e.j.f.p.a;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class y extends q {
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11455c;

    /* renamed from: d  reason: collision with root package name */
    private final String f11456d;

    public y(String str, String str2, String str3) {
        super(ParsedResultType.TEL);
        this.b = str;
        this.f11455c = str2;
        this.f11456d = str3;
    }

    @Override // e.j.f.p.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        q.b(this.b, sb);
        q.b(this.f11456d, sb);
        return sb.toString();
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.f11455c;
    }

    public String f() {
        return this.f11456d;
    }
}
