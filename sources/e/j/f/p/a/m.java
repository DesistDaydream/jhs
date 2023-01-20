package e.j.f.p.a;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class m extends q {
    private final double b;

    /* renamed from: c  reason: collision with root package name */
    private final double f11444c;

    /* renamed from: d  reason: collision with root package name */
    private final double f11445d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11446e;

    public m(double d2, double d3, double d4, String str) {
        super(ParsedResultType.GEO);
        this.b = d2;
        this.f11444c = d3;
        this.f11445d = d4;
        this.f11446e = str;
    }

    @Override // e.j.f.p.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.b);
        sb.append(", ");
        sb.append(this.f11444c);
        if (this.f11445d > 0.0d) {
            sb.append(", ");
            sb.append(this.f11445d);
            sb.append('m');
        }
        if (this.f11446e != null) {
            sb.append(" (");
            sb.append(this.f11446e);
            sb.append(')');
        }
        return sb.toString();
    }

    public double d() {
        return this.f11445d;
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        sb.append("geo:");
        sb.append(this.b);
        sb.append(',');
        sb.append(this.f11444c);
        if (this.f11445d > 0.0d) {
            sb.append(',');
            sb.append(this.f11445d);
        }
        if (this.f11446e != null) {
            sb.append(k.b.a.a.o.e.a);
            sb.append(this.f11446e);
        }
        return sb.toString();
    }

    public double f() {
        return this.b;
    }

    public double g() {
        return this.f11444c;
    }

    public String h() {
        return this.f11446e;
    }
}
