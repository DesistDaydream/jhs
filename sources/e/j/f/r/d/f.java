package e.j.f.r.d;

/* loaded from: classes2.dex */
public final class f implements g {
    private static void c(char c2, StringBuilder sb) {
        if (c2 >= ' ' && c2 <= '?') {
            sb.append(c2);
        } else if (c2 >= '@' && c2 <= '^') {
            sb.append((char) (c2 - '@'));
        } else {
            j.f(c2);
        }
    }

    private static String d(CharSequence charSequence, int i2) {
        int length = charSequence.length() - i2;
        if (length != 0) {
            int charAt = (charSequence.charAt(i2) << 18) + ((length >= 2 ? charSequence.charAt(i2 + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i2 + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i2 + 3) : (char) 0);
            char c2 = (char) ((charAt >> 8) & 255);
            char c3 = (char) (charAt & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) ((charAt >> 16) & 255));
            if (length >= 2) {
                sb.append(c2);
            }
            if (length >= 3) {
                sb.append(c3);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }

    private static void e(h hVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z = true;
            if (length == 1) {
                hVar.q();
                int b = hVar.h().b() - hVar.a();
                int g2 = hVar.g();
                if (g2 > b) {
                    hVar.r(hVar.a() + 1);
                    b = hVar.h().b() - hVar.a();
                }
                if (g2 <= b && b <= 2) {
                    return;
                }
            }
            if (length <= 4) {
                int i2 = length - 1;
                String d2 = d(charSequence, 0);
                if (!(!hVar.j()) || i2 > 2) {
                    z = false;
                }
                if (i2 <= 2) {
                    hVar.r(hVar.a() + i2);
                    if (hVar.h().b() - hVar.a() >= 3) {
                        hVar.r(hVar.a() + d2.length());
                        z = false;
                    }
                }
                if (z) {
                    hVar.l();
                    hVar.f11521f -= i2;
                } else {
                    hVar.t(d2);
                }
                return;
            }
            throw new IllegalStateException("Count must not exceed 4");
        } finally {
            hVar.p(0);
        }
    }

    @Override // e.j.f.r.d.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.j()) {
                break;
            }
            c(hVar.d(), sb);
            hVar.f11521f++;
            if (sb.length() >= 4) {
                hVar.t(d(sb, 0));
                sb.delete(0, 4);
                if (j.o(hVar.e(), hVar.f11521f, b()) != b()) {
                    hVar.p(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        e(hVar, sb);
    }

    @Override // e.j.f.r.d.g
    public int b() {
        return 4;
    }
}
