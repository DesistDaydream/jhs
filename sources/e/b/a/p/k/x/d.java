package e.b.a.p.k.x;

import e.b.a.p.k.x.m;
import java.util.Queue;

/* loaded from: classes.dex */
public abstract class d<T extends m> {
    private static final int b = 20;
    private final Queue<T> a = e.b.a.v.n.f(20);

    public abstract T a();

    public T b() {
        T poll = this.a.poll();
        return poll == null ? a() : poll;
    }

    public void c(T t) {
        if (this.a.size() < 20) {
            this.a.offer(t);
        }
    }
}
