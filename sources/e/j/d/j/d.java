package e.j.d.j;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class d {
    private static volatile d b;
    private final Set<e> a = new HashSet();

    public static d a() {
        d dVar = b;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = b;
                if (dVar == null) {
                    dVar = new d();
                    b = dVar;
                }
            }
        }
        return dVar;
    }

    public Set<e> b() {
        Set<e> unmodifiableSet;
        synchronized (this.a) {
            unmodifiableSet = Collections.unmodifiableSet(this.a);
        }
        return unmodifiableSet;
    }

    public void c(String str, String str2) {
        synchronized (this.a) {
            this.a.add(e.a(str, str2));
        }
    }
}
