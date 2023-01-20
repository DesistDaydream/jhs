package k.c.a;

/* loaded from: classes4.dex */
public class a implements Runnable, k {
    private final j a = new j();
    private final c b;

    public a(c cVar) {
        this.b = cVar;
    }

    @Override // k.c.a.k
    public void a(p pVar, Object obj) {
        this.a.a(i.a(pVar, obj));
        this.b.g().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        i b = this.a.b();
        if (b != null) {
            this.b.l(b);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
