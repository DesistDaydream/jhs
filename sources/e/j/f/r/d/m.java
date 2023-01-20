package e.j.f.r.d;

/* loaded from: classes2.dex */
public final class m extends c {
    @Override // e.j.f.r.d.c, e.j.f.r.d.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.j()) {
                break;
            }
            char d2 = hVar.d();
            hVar.f11521f++;
            d(d2, sb);
            if (sb.length() % 3 == 0) {
                c.g(hVar, sb);
                if (j.o(hVar.e(), hVar.f11521f, b()) != b()) {
                    hVar.p(0);
                    break;
                }
            }
        }
        f(hVar, sb);
    }

    @Override // e.j.f.r.d.c, e.j.f.r.d.g
    public int b() {
        return 3;
    }

    @Override // e.j.f.r.d.c
    public int d(char c2, StringBuilder sb) {
        if (c2 == '\r') {
            sb.append((char) 0);
        } else if (c2 == ' ') {
            sb.append((char) 3);
        } else if (c2 == '*') {
            sb.append((char) 1);
        } else if (c2 == '>') {
            sb.append((char) 2);
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
        } else if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) ((c2 - 'A') + 14));
        } else {
            j.f(c2);
        }
        return 1;
    }

    @Override // e.j.f.r.d.c
    public void f(h hVar, StringBuilder sb) {
        hVar.q();
        int b = hVar.h().b() - hVar.a();
        hVar.f11521f -= sb.length();
        if (hVar.g() > 1 || b > 1 || hVar.g() != b) {
            hVar.s((char) 254);
        }
        if (hVar.f() < 0) {
            hVar.p(0);
        }
    }
}
