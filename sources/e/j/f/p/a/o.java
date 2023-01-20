package e.j.f.p.a;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class o extends q {
    private final String b;

    public o(String str) {
        super(ParsedResultType.ISBN);
        this.b = str;
    }

    @Override // e.j.f.p.a.q
    public String a() {
        return this.b;
    }

    public String d() {
        return this.b;
    }
}
