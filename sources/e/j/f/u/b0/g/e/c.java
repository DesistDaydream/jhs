package e.j.f.u.b0.g.e;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class c extends h {

    /* renamed from: d  reason: collision with root package name */
    private static final int f11594d = 8;

    /* renamed from: e  reason: collision with root package name */
    private static final int f11595e = 2;

    public c(e.j.f.q.a aVar) {
        super(aVar);
    }

    @Override // e.j.f.u.b0.g.e.j
    public String d() throws NotFoundException, FormatException {
        if (c().n() >= 48) {
            StringBuilder sb = new StringBuilder();
            f(sb, 8);
            int f2 = b().f(48, 2);
            sb.append("(392");
            sb.append(f2);
            sb.append(')');
            sb.append(b().c(50, null).b());
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
