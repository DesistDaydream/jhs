package d.a.a.e;

/* loaded from: classes.dex */
public class d implements a {
    public byte[] a;
    public String b;

    @Override // d.a.a.e.a
    public String a() {
        return "AES";
    }

    @Override // d.a.a.e.a
    public String a(String str) {
        return c.b(this.a, str);
    }

    @Override // d.a.a.e.a
    public String b() {
        return "RSA";
    }

    @Override // d.a.a.e.a
    public String b(String str) {
        try {
            byte[] e2 = c.e();
            this.a = e2;
            String a = c.a(str, e2);
            this.b = a;
            return a;
        } catch (Exception unused) {
            return null;
        }
    }
}
