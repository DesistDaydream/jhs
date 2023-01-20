package e.j.d.d;

/* loaded from: classes2.dex */
public final /* synthetic */ class j implements e.j.d.g.a {
    private final m a;
    private final e b;

    private j(m mVar, e eVar) {
        this.a = mVar;
        this.b = eVar;
    }

    public static e.j.d.g.a a(m mVar, e eVar) {
        return new j(mVar, eVar);
    }

    @Override // e.j.d.g.a
    public Object get() {
        Object a;
        a = r1.d().a(new s(this.b, this.a));
        return a;
    }
}
