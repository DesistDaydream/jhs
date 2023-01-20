package e.j.f.u.b0.g.e;

import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class e extends i {

    /* renamed from: f */
    private static final int f11599f = 8;

    /* renamed from: g */
    private static final int f11600g = 20;

    /* renamed from: h */
    private static final int f11601h = 16;

    /* renamed from: d */
    private final String f11602d;

    /* renamed from: e */
    private final String f11603e;

    public e(e.j.f.q.a aVar, String str, String str2) {
        super(aVar);
        this.f11602d = str2;
        this.f11603e = str;
    }

    private void k(StringBuilder sb, int i2) {
        int f2 = b().f(i2, 16);
        if (f2 == 38400) {
            return;
        }
        sb.append('(');
        sb.append(this.f11602d);
        sb.append(')');
        int i3 = f2 % 32;
        int i4 = f2 / 32;
        int i5 = (i4 % 12) + 1;
        int i6 = i4 / 12;
        if (i6 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i6);
        if (i5 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i5);
        if (i3 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i3);
    }

    @Override // e.j.f.u.b0.g.e.j
    public String d() throws NotFoundException {
        if (c().n() == 84) {
            StringBuilder sb = new StringBuilder();
            f(sb, 8);
            j(sb, 48, 20);
            k(sb, 68);
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // e.j.f.u.b0.g.e.i
    public void h(StringBuilder sb, int i2) {
        sb.append('(');
        sb.append(this.f11603e);
        sb.append(i2 / 100000);
        sb.append(')');
    }

    @Override // e.j.f.u.b0.g.e.i
    public int i(int i2) {
        return i2 % 100000;
    }
}
