package e.l.q.c.t0;

import java.util.Objects;

/* loaded from: classes2.dex */
public class b {
    private volatile e.l.q.c.t0.c.b a;

    /* renamed from: e.l.q.c.t0.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0397b {
        public static b a = new b();

        private C0397b() {
        }
    }

    public static b a() {
        return C0397b.a;
    }

    public e.l.q.c.t0.c.b b() {
        Objects.requireNonNull(this.a, "ZoomMediaLoader loader  no init");
        return this.a;
    }

    public void c(e.l.q.c.t0.c.b bVar) {
        this.a = bVar;
    }

    private b() {
    }
}
