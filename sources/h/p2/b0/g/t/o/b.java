package h.p2.b0.g.t.o;

import h.p2.b0.g.t.c.v;

/* loaded from: classes3.dex */
public interface b {

    /* loaded from: classes3.dex */
    public static final class a {
        @k.e.a.e
        public static String a(@k.e.a.d b bVar, @k.e.a.d v vVar) {
            if (bVar.b(vVar)) {
                return null;
            }
            return bVar.getDescription();
        }
    }

    @k.e.a.e
    String a(@k.e.a.d v vVar);

    boolean b(@k.e.a.d v vVar);

    @k.e.a.d
    String getDescription();
}
