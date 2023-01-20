package e.j.d.j;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import e.j.d.d.o;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class c implements g {
    private final String a;
    private final d b;

    public c(Set<e> set, d dVar) {
        this.a = d(set);
        this.b = dVar;
    }

    public static e.j.d.d.e<g> b() {
        return e.j.d.d.e.a(g.class).b(o.i(e.class)).f(b.b()).d();
    }

    public static /* synthetic */ g c(e.j.d.d.f fVar) {
        return new c(fVar.c(e.class), d.a());
    }

    private static String d(Set<e> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<e> it = set.iterator();
        while (it.hasNext()) {
            e next = it.next();
            sb.append(next.b());
            sb.append(Attributes.InternalPrefix);
            sb.append(next.c());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override // e.j.d.j.g
    public String a() {
        if (this.b.b().isEmpty()) {
            return this.a;
        }
        return this.a + ' ' + d(this.b.b());
    }
}
