package h.p2.b0.g.t.n.e1;

import h.p2.b0.g.t.c.y;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class i {
    @k.e.a.d
    private static final y<p<h>> a = new y<>("KotlinTypeRefiner");

    @k.e.a.d
    public static final y<p<h>> a() {
        return a;
    }

    @k.e.a.d
    public static final List<z> b(@k.e.a.d h hVar, @k.e.a.d Iterable<? extends z> iterable) {
        ArrayList arrayList = new ArrayList(h.a2.u.Y(iterable, 10));
        for (z zVar : iterable) {
            arrayList.add(hVar.g(zVar));
        }
        return arrayList;
    }
}
