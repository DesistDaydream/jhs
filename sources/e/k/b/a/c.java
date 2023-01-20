package e.k.b.a;

/* loaded from: classes2.dex */
public class c {
    private e.k.b.a.o.c a = new e.k.b.a.o.c();

    public void a() {
        e.k.b.a.o.c cVar = this.a;
        if (cVar.f11797c) {
            return;
        }
        synchronized (cVar.b) {
            cVar.f11797c = true;
            for (Runnable runnable : cVar.a) {
                runnable.run();
            }
        }
    }

    public b b() {
        return this.a;
    }
}
