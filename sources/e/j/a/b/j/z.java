package e.j.a.b.j;

/* loaded from: classes2.dex */
public final class z implements Runnable {
    private final /* synthetic */ k a;
    private final /* synthetic */ y b;

    public z(y yVar, k kVar) {
        this.b = yVar;
        this.a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        f fVar;
        f fVar2;
        obj = this.b.b;
        synchronized (obj) {
            fVar = this.b.f10550c;
            if (fVar != null) {
                fVar2 = this.b.f10550c;
                fVar2.onFailure(this.a.q());
            }
        }
    }
}
