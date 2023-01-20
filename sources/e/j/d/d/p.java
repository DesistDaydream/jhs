package e.j.d.d;

import java.util.Map;

/* loaded from: classes2.dex */
public final /* synthetic */ class p implements Runnable {
    private final Map.Entry a;
    private final e.j.d.e.a b;

    private p(Map.Entry entry, e.j.d.e.a aVar) {
        this.a = entry;
        this.b = aVar;
    }

    public static Runnable a(Map.Entry entry, e.j.d.e.a aVar) {
        return new p(entry, aVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        ((e.j.d.e.b) this.a.getKey()).a(this.b);
    }
}
