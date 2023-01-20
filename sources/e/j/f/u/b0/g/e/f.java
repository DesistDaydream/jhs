package e.j.f.u.b0.g.e;

import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public abstract class f extends i {

    /* renamed from: d  reason: collision with root package name */
    private static final int f11604d = 5;

    /* renamed from: e  reason: collision with root package name */
    private static final int f11605e = 15;

    public f(e.j.f.q.a aVar) {
        super(aVar);
    }

    @Override // e.j.f.u.b0.g.e.j
    public String d() throws NotFoundException {
        if (c().n() == 60) {
            StringBuilder sb = new StringBuilder();
            f(sb, 5);
            j(sb, 45, 15);
            return sb.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
