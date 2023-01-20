package e.j.f.r.d;

import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import java.nio.charset.StandardCharsets;

/* loaded from: classes2.dex */
public final class h {
    private final String a;
    private SymbolShapeHint b;

    /* renamed from: c  reason: collision with root package name */
    private e.j.f.c f11518c;

    /* renamed from: d  reason: collision with root package name */
    private e.j.f.c f11519d;

    /* renamed from: e  reason: collision with root package name */
    private final StringBuilder f11520e;

    /* renamed from: f  reason: collision with root package name */
    public int f11521f;

    /* renamed from: g  reason: collision with root package name */
    private int f11522g;

    /* renamed from: h  reason: collision with root package name */
    private k f11523h;

    /* renamed from: i  reason: collision with root package name */
    private int f11524i;

    public h(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.ISO_8859_1);
        StringBuilder sb = new StringBuilder(bytes.length);
        int length = bytes.length;
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = (char) (bytes[i2] & 255);
            if (c2 == '?' && str.charAt(i2) != '?') {
                throw new IllegalArgumentException("Message contains characters outside ISO-8859-1 encoding.");
            }
            sb.append(c2);
        }
        this.a = sb.toString();
        this.b = SymbolShapeHint.FORCE_NONE;
        this.f11520e = new StringBuilder(str.length());
        this.f11522g = -1;
    }

    private int i() {
        return this.a.length() - this.f11524i;
    }

    public int a() {
        return this.f11520e.length();
    }

    public StringBuilder b() {
        return this.f11520e;
    }

    public char c() {
        return this.a.charAt(this.f11521f);
    }

    public char d() {
        return this.a.charAt(this.f11521f);
    }

    public String e() {
        return this.a;
    }

    public int f() {
        return this.f11522g;
    }

    public int g() {
        return i() - this.f11521f;
    }

    public k h() {
        return this.f11523h;
    }

    public boolean j() {
        return this.f11521f < i();
    }

    public void k() {
        this.f11522g = -1;
    }

    public void l() {
        this.f11523h = null;
    }

    public void m(e.j.f.c cVar, e.j.f.c cVar2) {
        this.f11518c = cVar;
        this.f11519d = cVar2;
    }

    public void n(int i2) {
        this.f11524i = i2;
    }

    public void o(SymbolShapeHint symbolShapeHint) {
        this.b = symbolShapeHint;
    }

    public void p(int i2) {
        this.f11522g = i2;
    }

    public void q() {
        r(a());
    }

    public void r(int i2) {
        k kVar = this.f11523h;
        if (kVar == null || i2 > kVar.b()) {
            this.f11523h = k.o(i2, this.b, this.f11518c, this.f11519d, true);
        }
    }

    public void s(char c2) {
        this.f11520e.append(c2);
    }

    public void t(String str) {
        this.f11520e.append(str);
    }
}
