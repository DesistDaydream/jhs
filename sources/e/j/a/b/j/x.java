package e.j.a.b.j;

/* loaded from: classes2.dex */
public final class x implements Runnable {
    private final /* synthetic */ k a;
    private final /* synthetic */ w b;

    public x(w wVar, k kVar) {
        this.b = wVar;
        this.a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        e eVar;
        e eVar2;
        obj = this.b.b;
        synchronized (obj) {
            eVar = this.b.f10549c;
            if (eVar != null) {
                eVar2 = this.b.f10549c;
                eVar2.onComplete(this.a);
            }
        }
    }
}
