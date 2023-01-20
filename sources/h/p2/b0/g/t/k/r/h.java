package h.p2.b0.g.t.k.r;

import h.k2.u.l;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.v;
import java.util.Collection;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public interface h {

    /* loaded from: classes3.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection a(h hVar, d dVar, l lVar, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    dVar = d.o;
                }
                l<h.p2.b0.g.t.g.f, Boolean> lVar2 = lVar;
                if ((i2 & 2) != 0) {
                    lVar2 = MemberScope.a.a();
                }
                return hVar.g(dVar, lVar2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
        }

        public static void b(@k.e.a.d h hVar, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
            hVar.a(fVar, bVar);
        }
    }

    @k.e.a.d
    Collection<? extends v> a(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar);

    @k.e.a.e
    h.p2.b0.g.t.c.f f(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar);

    @k.e.a.d
    Collection<k> g(@k.e.a.d d dVar, @k.e.a.d l<? super h.p2.b0.g.t.g.f, Boolean> lVar);

    void h(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar);
}
