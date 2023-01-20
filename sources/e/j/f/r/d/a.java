package e.j.f.r.d;

/* loaded from: classes2.dex */
public final class a implements g {
    private static char c(char c2, char c3) {
        if (j.g(c2) && j.g(c3)) {
            return (char) (((c2 - '0') * 10) + (c3 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c2 + c3);
    }

    @Override // e.j.f.r.d.g
    public void a(h hVar) {
        if (j.a(hVar.e(), hVar.f11521f) >= 2) {
            hVar.s(c(hVar.e().charAt(hVar.f11521f), hVar.e().charAt(hVar.f11521f + 1)));
            hVar.f11521f += 2;
            return;
        }
        char d2 = hVar.d();
        int o = j.o(hVar.e(), hVar.f11521f, b());
        if (o == b()) {
            if (j.h(d2)) {
                hVar.s(j.f11529d);
                hVar.s((char) ((d2 - 128) + 1));
                hVar.f11521f++;
                return;
            }
            hVar.s((char) (d2 + 1));
            hVar.f11521f++;
        } else if (o == 1) {
            hVar.s(j.b);
            hVar.p(1);
        } else if (o == 2) {
            hVar.s(j.f11533h);
            hVar.p(2);
        } else if (o == 3) {
            hVar.s(j.f11532g);
            hVar.p(3);
        } else if (o == 4) {
            hVar.s(j.f11534i);
            hVar.p(4);
        } else if (o == 5) {
            hVar.s(j.f11528c);
            hVar.p(5);
        } else {
            throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(o)));
        }
    }

    @Override // e.j.f.r.d.g
    public int b() {
        return 0;
    }
}
