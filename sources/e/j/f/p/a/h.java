package e.j.f.p.a;

import androidx.core.net.MailTo;
import com.google.zxing.client.result.ParsedResultType;

/* loaded from: classes2.dex */
public final class h extends q {
    private final String[] b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f11418c;

    /* renamed from: d  reason: collision with root package name */
    private final String[] f11419d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11420e;

    /* renamed from: f  reason: collision with root package name */
    private final String f11421f;

    public h(String str) {
        this(new String[]{str}, null, null, null, null);
    }

    @Override // e.j.f.p.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(30);
        q.c(this.b, sb);
        q.c(this.f11418c, sb);
        q.c(this.f11419d, sb);
        q.b(this.f11420e, sb);
        q.b(this.f11421f, sb);
        return sb.toString();
    }

    public String[] d() {
        return this.f11419d;
    }

    public String e() {
        return this.f11421f;
    }

    public String[] f() {
        return this.f11418c;
    }

    @Deprecated
    public String g() {
        String[] strArr = this.b;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        return strArr[0];
    }

    @Deprecated
    public String h() {
        return MailTo.MAILTO_SCHEME;
    }

    public String i() {
        return this.f11420e;
    }

    public String[] j() {
        return this.b;
    }

    public h(String[] strArr, String[] strArr2, String[] strArr3, String str, String str2) {
        super(ParsedResultType.EMAIL_ADDRESS);
        this.b = strArr;
        this.f11418c = strArr2;
        this.f11419d = strArr3;
        this.f11420e = str;
        this.f11421f = str2;
    }
}
