package e.j.a.b.j;

/* loaded from: classes2.dex */
public final class b0 implements Runnable {
    private final /* synthetic */ k a;
    private final /* synthetic */ a0 b;

    public b0(a0 a0Var, k kVar) {
        this.b = a0Var;
        this.a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        g gVar;
        g gVar2;
        obj = this.b.b;
        synchronized (obj) {
            gVar = this.b.f10533c;
            if (gVar != null) {
                gVar2 = this.b.f10533c;
                gVar2.onSuccess(this.a.r());
            }
        }
    }
}
