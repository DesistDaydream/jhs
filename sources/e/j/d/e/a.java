package e.j.d.e;

import e.j.a.b.c.r.a0;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class a<T> {
    private final Class<T> a;
    private final T b;

    @e.j.a.b.c.m.a
    public a(Class<T> cls, T t) {
        this.a = (Class) a0.k(cls);
        this.b = (T) a0.k(t);
    }

    @e.j.a.b.c.m.a
    public T a() {
        return this.b;
    }

    @e.j.a.b.c.m.a
    public Class<T> getType() {
        return this.a;
    }

    public String toString() {
        return String.format("Event{type: %s, payload: %s}", this.a, this.b);
    }
}
