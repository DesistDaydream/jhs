package h.p2.b0.g.t.o;

import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.o.c;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.util.Checks;

/* loaded from: classes3.dex */
public abstract class a {
    @k.e.a.d
    public final c a(@k.e.a.d v vVar) {
        for (Checks checks : b()) {
            if (checks.b(vVar)) {
                return checks.a(vVar);
            }
        }
        return c.a.b;
    }

    @k.e.a.d
    public abstract List<Checks> b();
}
