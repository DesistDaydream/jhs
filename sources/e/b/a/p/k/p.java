package e.b.a.p.k;

import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class p {
    private final Map<e.b.a.p.c, j<?>> a = new HashMap();
    private final Map<e.b.a.p.c, j<?>> b = new HashMap();

    private Map<e.b.a.p.c, j<?>> c(boolean z) {
        return z ? this.b : this.a;
    }

    public j<?> a(e.b.a.p.c cVar, boolean z) {
        return c(z).get(cVar);
    }

    @VisibleForTesting
    public Map<e.b.a.p.c, j<?>> b() {
        return Collections.unmodifiableMap(this.a);
    }

    public void d(e.b.a.p.c cVar, j<?> jVar) {
        c(jVar.q()).put(cVar, jVar);
    }

    public void e(e.b.a.p.c cVar, j<?> jVar) {
        Map<e.b.a.p.c, j<?>> c2 = c(jVar.q());
        if (jVar.equals(c2.get(cVar))) {
            c2.remove(cVar);
        }
    }
}
