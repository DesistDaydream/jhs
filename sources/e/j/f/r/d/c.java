package e.j.f.r.d;

/* loaded from: classes2.dex */
public class c implements g {
    private int c(h hVar, StringBuilder sb, StringBuilder sb2, int i2) {
        int length = sb.length();
        sb.delete(length - i2, length);
        hVar.f11521f--;
        int d2 = d(hVar.d(), sb2);
        hVar.l();
        return d2;
    }

    private static String e(CharSequence charSequence, int i2) {
        int charAt = (charSequence.charAt(i2) * 1600) + (charSequence.charAt(i2 + 1) * '(') + charSequence.charAt(i2 + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }

    public static void g(h hVar, StringBuilder sb) {
        hVar.t(e(sb, 0));
        sb.delete(0, 3);
    }

    @Override // e.j.f.r.d.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.j()) {
                break;
            }
            char d2 = hVar.d();
            hVar.f11521f++;
            int d3 = d(d2, sb);
            int a = hVar.a() + ((sb.length() / 3) << 1);
            hVar.r(a);
            int b = hVar.h().b() - a;
            if (!hVar.j()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (b < 2 || b > 2)) {
                    d3 = c(hVar, sb, sb2, d3);
                }
                while (sb.length() % 3 == 1 && ((d3 <= 3 && b != 1) || d3 > 3)) {
                    d3 = c(hVar, sb, sb2, d3);
                }
            } else if (sb.length() % 3 == 0 && j.o(hVar.e(), hVar.f11521f, b()) != b()) {
                hVar.p(0);
                break;
            }
        }
        f(hVar, sb);
    }

    @Override // e.j.f.r.d.g
    public int b() {
        return 1;
    }

    public int d(char c2, StringBuilder sb) {
        if (c2 == ' ') {
            sb.append((char) 3);
            return 1;
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
            return 1;
        } else if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) ((c2 - 'A') + 14));
            return 1;
        } else if (c2 < ' ') {
            sb.append((char) 0);
            sb.append(c2);
            return 2;
        } else if (c2 >= '!' && c2 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c2 - '!'));
            return 2;
        } else if (c2 >= ':' && c2 <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c2 - ':') + 15));
            return 2;
        } else if (c2 >= '[' && c2 <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c2 - '[') + 22));
            return 2;
        } else if (c2 >= '`' && c2 <= 127) {
            sb.append((char) 2);
            sb.append((char) (c2 - '`'));
            return 2;
        } else {
            sb.append("\u0001\u001e");
            return d((char) (c2 - 128), sb) + 2;
        }
    }

    public void f(h hVar, StringBuilder sb) {
        int length = sb.length() % 3;
        int a = hVar.a() + ((sb.length() / 3) << 1);
        hVar.r(a);
        int b = hVar.h().b() - a;
        if (length == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                g(hVar, sb);
            }
            if (hVar.j()) {
                hVar.s((char) 254);
            }
        } else if (b == 1 && length == 1) {
            while (sb.length() >= 3) {
                g(hVar, sb);
            }
            if (hVar.j()) {
                hVar.s((char) 254);
            }
            hVar.f11521f--;
        } else if (length == 0) {
            while (sb.length() >= 3) {
                g(hVar, sb);
            }
            if (b > 0 || hVar.j()) {
                hVar.s((char) 254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        hVar.p(0);
    }
}
