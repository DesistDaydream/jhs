package h.p2.b0.g.t.e.a.x;

import h.k2.v.f0;
import java.util.Iterator;

/* loaded from: classes3.dex */
public interface c0 extends d {

    /* loaded from: classes3.dex */
    public static final class a {
        @k.e.a.e
        public static h.p2.b0.g.t.e.a.x.a a(@k.e.a.d c0 c0Var, @k.e.a.d h.p2.b0.g.t.g.c cVar) {
            Object obj;
            Iterator<T> it = c0Var.getAnnotations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                h.p2.b0.g.t.g.b b = ((h.p2.b0.g.t.e.a.x.a) next).b();
                if (f0.g(b != null ? b.b() : null, cVar)) {
                    obj = next;
                    break;
                }
            }
            return (h.p2.b0.g.t.e.a.x.a) obj;
        }
    }
}
