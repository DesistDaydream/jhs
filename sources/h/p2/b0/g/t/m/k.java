package h.p2.b0.g.t.m;

/* loaded from: classes3.dex */
public class k<T> {
    private final T a;
    private final Thread b = Thread.currentThread();

    public k(T t) {
        this.a = t;
    }

    public T a() {
        if (b()) {
            return this.a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean b() {
        return this.b == Thread.currentThread();
    }
}
