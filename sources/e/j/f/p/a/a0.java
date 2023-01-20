package e.j.f.p.a;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class a0 extends q {
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f11375c;

    public a0(String str, String str2) {
        super(ParsedResultType.TEXT);
        this.b = str;
        this.f11375c = str2;
    }

    @Override // e.j.f.p.a.q
    public String a() {
        return this.b;
    }

    public String d() {
        return this.f11375c;
    }

    public String e() {
        return this.b;
    }
}
