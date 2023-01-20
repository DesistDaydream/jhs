package e.j.f.p.a;

import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class v extends q {
    private final String[] b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f11452c;

    /* renamed from: d  reason: collision with root package name */
    private final String f11453d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11454e;

    public v(String str, String str2, String str3, String str4) {
        super(ParsedResultType.SMS);
        this.b = new String[]{str};
        this.f11452c = new String[]{str2};
        this.f11453d = str3;
        this.f11454e = str4;
    }

    @Override // e.j.f.p.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        q.c(this.b, sb);
        q.b(this.f11453d, sb);
        q.b(this.f11454e, sb);
        return sb.toString();
    }

    public String d() {
        return this.f11454e;
    }

    public String[] e() {
        return this.b;
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append("sms:");
        boolean z = true;
        for (int i2 = 0; i2 < this.b.length; i2++) {
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            sb.append(this.b[i2]);
            String[] strArr = this.f11452c;
            if (strArr != null && strArr[i2] != null) {
                sb.append(";via=");
                sb.append(this.f11452c[i2]);
            }
        }
        boolean z2 = this.f11454e != null;
        boolean z3 = this.f11453d != null;
        if (z2 || z3) {
            sb.append(k.b.a.a.o.e.a);
            if (z2) {
                sb.append("body=");
                sb.append(this.f11454e);
            }
            if (z3) {
                if (z2) {
                    sb.append(h.t2.y.f15690c);
                }
                sb.append("subject=");
                sb.append(this.f11453d);
            }
        }
        return sb.toString();
    }

    public String g() {
        return this.f11453d;
    }

    public String[] h() {
        return this.f11452c;
    }

    public v(String[] strArr, String[] strArr2, String str, String str2) {
        super(ParsedResultType.SMS);
        this.b = strArr;
        this.f11452c = strArr2;
        this.f11453d = str;
        this.f11454e = str2;
    }
}
