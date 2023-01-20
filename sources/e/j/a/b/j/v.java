package e.j.a.b.j;

/* loaded from: classes2.dex */
public final class v implements Runnable {
    private final /* synthetic */ u a;

    public v(u uVar) {
        this.a = uVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        d dVar;
        d dVar2;
        obj = this.a.b;
        synchronized (obj) {
            dVar = this.a.f10548c;
            if (dVar != null) {
                dVar2 = this.a.f10548c;
                dVar2.a();
            }
        }
    }
}
