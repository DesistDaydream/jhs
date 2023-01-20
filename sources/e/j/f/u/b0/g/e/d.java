package e.j.f.u.b0.g.e;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class d extends h {

    /* renamed from: d  reason: collision with root package name */
    private static final int f11596d = 8;

    /* renamed from: e  reason: collision with root package name */
    private static final int f11597e = 2;

    /* renamed from: f  reason: collision with root package name */
    private static final int f11598f = 10;

    public d(e.j.f.q.a aVar) {
        super(aVar);
    }

    @Override // e.j.f.u.b0.g.e.j
    public String d() throws NotFoundException, FormatException {
        if (c().n() >= 48) {
            StringBuilder sb = new StringBuilder();
            f(sb, 8);
            int f2 = b().f(48, 2);
            sb.append("(393");
            sb.append(f2);
            sb.append(')');
            int f3 = b().f(50, 10);
            if (f3 / 100 == 0) {
                sb.append('0');
            }
            if (f3 / 10 == 0) {
                sb.append('0');
            }
            sb.append(f3);
            sb.append(b().c(60, null).b());
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
