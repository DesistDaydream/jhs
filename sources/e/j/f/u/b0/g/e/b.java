package e.j.f.u.b0.g.e;

/* loaded from: classes2.dex */
public final class b extends f {
    public b(e.j.f.q.a aVar) {
        super(aVar);
    }

    @Override // e.j.f.u.b0.g.e.i
    public void h(StringBuilder sb, int i2) {
        if (i2 < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // e.j.f.u.b0.g.e.i
    public int i(int i2) {
        return i2 < 10000 ? i2 : i2 - 10000;
    }
}
