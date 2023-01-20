package e.j.f.p.a;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class r extends q {
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11448c;

    public r(String str) {
        this(str, str);
    }

    @Override // e.j.f.p.a.q
    public String a() {
        return this.b;
    }

    public String d() {
        return this.f11448c;
    }

    public String e() {
        return this.b;
    }

    public r(String str, String str2) {
        super(ParsedResultType.PRODUCT);
        this.b = str;
        this.f11448c = str2;
    }
}
