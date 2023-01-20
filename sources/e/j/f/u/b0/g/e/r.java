package e.j.f.u.b0.g.e;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.oned.rss.expanded.decoders.CurrentParsingState;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import h.t2.y;

/* loaded from: classes2.dex */
public final class r {
    private final e.j.f.q.a a;
    private final CurrentParsingState b = new CurrentParsingState();

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f11617c = new StringBuilder();

    public r(e.j.f.q.a aVar) {
        this.a = aVar;
    }

    private m b(int i2) {
        char c2;
        int f2 = f(i2, 5);
        if (f2 == 15) {
            return new m(i2 + 5, '$');
        }
        if (f2 >= 5 && f2 < 15) {
            return new m(i2 + 5, (char) ((f2 + 48) - 5));
        }
        int f3 = f(i2, 6);
        if (f3 >= 32 && f3 < 58) {
            return new m(i2 + 6, (char) (f3 + 33));
        }
        switch (f3) {
            case 58:
                c2 = '*';
                break;
            case 59:
                c2 = ',';
                break;
            case 60:
                c2 = k.b.a.a.n.l.f16189d;
                break;
            case 61:
                c2 = '.';
                break;
            case 62:
                c2 = Attributes.InternalPrefix;
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(f3)));
        }
        return new m(i2 + 6, c2);
    }

    private m d(int i2) throws FormatException {
        char c2;
        int f2 = f(i2, 5);
        if (f2 == 15) {
            return new m(i2 + 5, '$');
        }
        if (f2 >= 5 && f2 < 15) {
            return new m(i2 + 5, (char) ((f2 + 48) - 5));
        }
        int f3 = f(i2, 7);
        if (f3 < 64 || f3 >= 90) {
            if (f3 >= 90 && f3 < 116) {
                return new m(i2 + 7, (char) (f3 + 7));
            }
            switch (f(i2, 8)) {
                case 232:
                    c2 = '!';
                    break;
                case 233:
                    c2 = y.a;
                    break;
                case 234:
                    c2 = '%';
                    break;
                case 235:
                    c2 = y.f15690c;
                    break;
                case 236:
                    c2 = '\'';
                    break;
                case 237:
                    c2 = '(';
                    break;
                case 238:
                    c2 = ')';
                    break;
                case 239:
                    c2 = '*';
                    break;
                case 240:
                    c2 = '+';
                    break;
                case 241:
                    c2 = ',';
                    break;
                case 242:
                    c2 = k.b.a.a.n.l.f16189d;
                    break;
                case 243:
                    c2 = '.';
                    break;
                case 244:
                    c2 = Attributes.InternalPrefix;
                    break;
                case 245:
                    c2 = ':';
                    break;
                case 246:
                    c2 = ';';
                    break;
                case 247:
                    c2 = y.f15691d;
                    break;
                case 248:
                    c2 = '=';
                    break;
                case 249:
                    c2 = y.f15692e;
                    break;
                case 250:
                    c2 = k.b.a.a.o.e.a;
                    break;
                case 251:
                    c2 = '_';
                    break;
                case 252:
                    c2 = ' ';
                    break;
                default:
                    throw FormatException.getFormatInstance();
            }
            return new m(i2 + 8, c2);
        }
        return new m(i2 + 7, (char) (f3 + 1));
    }

    private o e(int i2) throws FormatException {
        int i3 = i2 + 7;
        if (i3 > this.a.n()) {
            int f2 = f(i2, 4);
            if (f2 == 0) {
                return new o(this.a.n(), 10, 10);
            }
            return new o(this.a.n(), f2 - 1, 10);
        }
        int f3 = f(i2, 7) - 8;
        return new o(i3, f3 / 11, f3 % 11);
    }

    public static int g(e.j.f.q.a aVar, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            if (aVar.j(i2 + i5)) {
                i4 |= 1 << ((i3 - i5) - 1);
            }
        }
        return i4;
    }

    private boolean h(int i2) {
        int i3 = i2 + 3;
        if (i3 > this.a.n()) {
            return false;
        }
        while (i2 < i3) {
            if (this.a.j(i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private boolean i(int i2) {
        int i3;
        if (i2 + 1 > this.a.n()) {
            return false;
        }
        for (int i4 = 0; i4 < 5 && (i3 = i4 + i2) < this.a.n(); i4++) {
            if (i4 == 2) {
                if (!this.a.j(i2 + 2)) {
                    return false;
                }
            } else if (this.a.j(i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean j(int i2) {
        int i3;
        if (i2 + 1 > this.a.n()) {
            return false;
        }
        for (int i4 = 0; i4 < 4 && (i3 = i4 + i2) < this.a.n(); i4++) {
            if (this.a.j(i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean k(int i2) {
        int f2;
        if (i2 + 5 > this.a.n()) {
            return false;
        }
        int f3 = f(i2, 5);
        if (f3 < 5 || f3 >= 16) {
            return i2 + 6 <= this.a.n() && (f2 = f(i2, 6)) >= 16 && f2 < 63;
        }
        return true;
    }

    private boolean l(int i2) {
        int f2;
        if (i2 + 5 > this.a.n()) {
            return false;
        }
        int f3 = f(i2, 5);
        if (f3 < 5 || f3 >= 16) {
            if (i2 + 7 > this.a.n()) {
                return false;
            }
            int f4 = f(i2, 7);
            if (f4 < 64 || f4 >= 116) {
                return i2 + 8 <= this.a.n() && (f2 = f(i2, 8)) >= 232 && f2 < 253;
            }
            return true;
        }
        return true;
    }

    private boolean m(int i2) {
        if (i2 + 7 > this.a.n()) {
            return i2 + 4 <= this.a.n();
        }
        int i3 = i2;
        while (true) {
            int i4 = i2 + 3;
            if (i3 < i4) {
                if (this.a.j(i3)) {
                    return true;
                }
                i3++;
            } else {
                return this.a.j(i4);
            }
        }
    }

    private l n() {
        while (k(this.b.a())) {
            m b = b(this.b.a());
            this.b.i(b.a());
            if (b.c()) {
                return new l(new n(this.b.a(), this.f11617c.toString()), true);
            }
            this.f11617c.append(b.b());
        }
        if (h(this.b.a())) {
            this.b.b(3);
            this.b.h();
        } else if (i(this.b.a())) {
            if (this.b.a() + 5 < this.a.n()) {
                this.b.b(5);
            } else {
                this.b.i(this.a.n());
            }
            this.b.g();
        }
        return new l(false);
    }

    private n o() throws FormatException {
        l q;
        boolean b;
        do {
            int a = this.b.a();
            if (this.b.c()) {
                q = n();
                b = q.b();
            } else if (this.b.d()) {
                q = p();
                b = q.b();
            } else {
                q = q();
                b = q.b();
            }
            if (!(a != this.b.a()) && !b) {
                break;
            }
        } while (!b);
        return q.a();
    }

    private l p() throws FormatException {
        while (l(this.b.a())) {
            m d2 = d(this.b.a());
            this.b.i(d2.a());
            if (d2.c()) {
                return new l(new n(this.b.a(), this.f11617c.toString()), true);
            }
            this.f11617c.append(d2.b());
        }
        if (h(this.b.a())) {
            this.b.b(3);
            this.b.h();
        } else if (i(this.b.a())) {
            if (this.b.a() + 5 < this.a.n()) {
                this.b.b(5);
            } else {
                this.b.i(this.a.n());
            }
            this.b.f();
        }
        return new l(false);
    }

    private l q() throws FormatException {
        n nVar;
        while (m(this.b.a())) {
            o e2 = e(this.b.a());
            this.b.i(e2.a());
            if (e2.f()) {
                if (e2.g()) {
                    nVar = new n(this.b.a(), this.f11617c.toString());
                } else {
                    nVar = new n(this.b.a(), this.f11617c.toString(), e2.c());
                }
                return new l(nVar, true);
            }
            this.f11617c.append(e2.b());
            if (e2.g()) {
                return new l(new n(this.b.a(), this.f11617c.toString()), true);
            }
            this.f11617c.append(e2.c());
        }
        if (j(this.b.a())) {
            this.b.f();
            this.b.b(4);
        }
        return new l(false);
    }

    public String a(StringBuilder sb, int i2) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            n c2 = c(i2, str);
            String a = q.a(c2.b());
            if (a != null) {
                sb.append(a);
            }
            String valueOf = c2.d() ? String.valueOf(c2.c()) : null;
            if (i2 != c2.a()) {
                i2 = c2.a();
                str = valueOf;
            } else {
                return sb.toString();
            }
        }
    }

    public n c(int i2, String str) throws FormatException {
        this.f11617c.setLength(0);
        if (str != null) {
            this.f11617c.append(str);
        }
        this.b.i(i2);
        n o = o();
        if (o != null && o.d()) {
            return new n(this.b.a(), this.f11617c.toString(), o.c());
        }
        return new n(this.b.a(), this.f11617c.toString());
    }

    public int f(int i2, int i3) {
        return g(this.a, i2, i3);
    }
}
