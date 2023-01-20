package e.j.f.u.b0.g.e;

/* loaded from: classes2.dex */
public abstract class h extends j {

    /* renamed from: c  reason: collision with root package name */
    public static final int f11607c = 40;

    public h(e.j.f.q.a aVar) {
        super(aVar);
    }

    private static void e(StringBuilder sb, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < 13; i4++) {
            int charAt = sb.charAt(i4 + i2) - '0';
            if ((i4 & 1) == 0) {
                charAt *= 3;
            }
            i3 += charAt;
        }
        int i5 = 10 - (i3 % 10);
        sb.append(i5 != 10 ? i5 : 0);
    }

    public final void f(StringBuilder sb, int i2) {
        sb.append("(01)");
        int length = sb.length();
        sb.append('9');
        g(sb, i2, length);
    }

    public final void g(StringBuilder sb, int i2, int i3) {
        for (int i4 = 0; i4 < 4; i4++) {
            int f2 = b().f((i4 * 10) + i2, 10);
            if (f2 / 100 == 0) {
                sb.append('0');
            }
            if (f2 / 10 == 0) {
                sb.append('0');
            }
            sb.append(f2);
        }
        e(sb, i3);
    }
}
