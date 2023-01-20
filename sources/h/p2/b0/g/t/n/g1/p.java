package h.p2.b0.g.t.n.g1;

import h.k2.v.n0;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* loaded from: classes3.dex */
public interface p extends s {

    /* loaded from: classes3.dex */
    public static final class a {
        @k.e.a.e
        public static List<i> a(@k.e.a.d p pVar, @k.e.a.d i iVar, @k.e.a.d m mVar) {
            return null;
        }

        @k.e.a.d
        public static l b(@k.e.a.d p pVar, @k.e.a.d k kVar, int i2) {
            if (kVar instanceof i) {
                return pVar.A((g) kVar, i2);
            }
            if (kVar instanceof ArgumentList) {
                return ((ArgumentList) kVar).get(i2);
            }
            throw new IllegalStateException(("unknown type argument list type: " + kVar + ", " + n0.d(kVar.getClass())).toString());
        }

        @k.e.a.e
        public static l c(@k.e.a.d p pVar, @k.e.a.d i iVar, int i2) {
            boolean z = false;
            if (i2 >= 0 && i2 < pVar.g(iVar)) {
                z = true;
            }
            if (z) {
                return pVar.A(iVar, i2);
            }
            return null;
        }

        public static boolean d(@k.e.a.d p pVar, @k.e.a.d g gVar) {
            return pVar.v(pVar.j0(gVar)) != pVar.v(pVar.u(gVar));
        }

        public static boolean e(@k.e.a.d p pVar, @k.e.a.d i iVar) {
            return pVar.e0(pVar.c(iVar));
        }

        public static boolean f(@k.e.a.d p pVar, @k.e.a.d g gVar) {
            i b = pVar.b(gVar);
            return (b == null ? null : pVar.p0(b)) != null;
        }

        public static boolean g(@k.e.a.d p pVar, @k.e.a.d g gVar) {
            e Y = pVar.Y(gVar);
            return (Y == null ? null : pVar.r0(Y)) != null;
        }

        public static boolean h(@k.e.a.d p pVar, @k.e.a.d i iVar) {
            return pVar.F(pVar.c(iVar));
        }

        public static boolean i(@k.e.a.d p pVar, @k.e.a.d g gVar) {
            return (gVar instanceof i) && pVar.v((i) gVar);
        }

        public static boolean j(@k.e.a.d p pVar, @k.e.a.d g gVar) {
            return pVar.O(pVar.S(gVar)) && !pVar.E(gVar);
        }

        @k.e.a.d
        public static i k(@k.e.a.d p pVar, @k.e.a.d g gVar) {
            e Y = pVar.Y(gVar);
            return Y == null ? pVar.b(gVar) : pVar.a(Y);
        }

        public static int l(@k.e.a.d p pVar, @k.e.a.d k kVar) {
            if (kVar instanceof i) {
                return pVar.g((g) kVar);
            }
            if (kVar instanceof ArgumentList) {
                return ((ArgumentList) kVar).size();
            }
            throw new IllegalStateException(("unknown type argument list type: " + kVar + ", " + n0.d(kVar.getClass())).toString());
        }

        @k.e.a.d
        public static m m(@k.e.a.d p pVar, @k.e.a.d g gVar) {
            i b = pVar.b(gVar);
            if (b == null) {
                b = pVar.j0(gVar);
            }
            return pVar.c(b);
        }

        @k.e.a.d
        public static i n(@k.e.a.d p pVar, @k.e.a.d g gVar) {
            e Y = pVar.Y(gVar);
            return Y == null ? pVar.b(gVar) : pVar.e(Y);
        }
    }

    @k.e.a.d
    l A(@k.e.a.d g gVar, int i2);

    boolean C(@k.e.a.d m mVar);

    boolean D(@k.e.a.d i iVar);

    boolean E(@k.e.a.d g gVar);

    boolean F(@k.e.a.d m mVar);

    boolean H(@k.e.a.d i iVar);

    @k.e.a.e
    l I(@k.e.a.d i iVar, int i2);

    boolean J(@k.e.a.d i iVar);

    int K(@k.e.a.d m mVar);

    @k.e.a.e
    List<i> N(@k.e.a.d i iVar, @k.e.a.d m mVar);

    boolean O(@k.e.a.d m mVar);

    boolean P(@k.e.a.d g gVar);

    @k.e.a.d
    Collection<g> Q(@k.e.a.d m mVar);

    @k.e.a.d
    Collection<g> R(@k.e.a.d i iVar);

    @k.e.a.d
    m S(@k.e.a.d g gVar);

    boolean T(@k.e.a.d m mVar);

    boolean U(@k.e.a.d g gVar);

    boolean V(@k.e.a.d g gVar);

    boolean W(@k.e.a.d i iVar);

    @k.e.a.e
    e Y(@k.e.a.d g gVar);

    @k.e.a.d
    g Z(@k.e.a.d List<? extends g> list);

    @k.e.a.d
    i a(@k.e.a.d e eVar);

    @k.e.a.d
    CaptureStatus a0(@k.e.a.d b bVar);

    @k.e.a.e
    i b(@k.e.a.d g gVar);

    @k.e.a.d
    g b0(@k.e.a.d g gVar);

    @k.e.a.d
    m c(@k.e.a.d i iVar);

    @k.e.a.d
    l c0(@k.e.a.d h.p2.b0.g.t.n.g1.a aVar);

    @k.e.a.d
    i d(@k.e.a.d i iVar, boolean z);

    @k.e.a.e
    g d0(@k.e.a.d b bVar);

    @k.e.a.d
    i e(@k.e.a.d e eVar);

    boolean e0(@k.e.a.d m mVar);

    boolean f0(@k.e.a.d m mVar);

    int g(@k.e.a.d g gVar);

    @k.e.a.d
    g getType(@k.e.a.d l lVar);

    boolean h(@k.e.a.d b bVar);

    @k.e.a.e
    b h0(@k.e.a.d i iVar);

    boolean i(@k.e.a.d n nVar, @k.e.a.d m mVar);

    boolean i0(@k.e.a.d g gVar);

    @k.e.a.d
    k j(@k.e.a.d i iVar);

    @k.e.a.d
    i j0(@k.e.a.d g gVar);

    @k.e.a.d
    l k(@k.e.a.d k kVar, int i2);

    @k.e.a.d
    TypeVariance k0(@k.e.a.d l lVar);

    @k.e.a.d
    n l(@k.e.a.d m mVar, int i2);

    @k.e.a.e
    n m0(@k.e.a.d t tVar);

    boolean n0(@k.e.a.d g gVar);

    @k.e.a.d
    g o(@k.e.a.d g gVar, boolean z);

    @k.e.a.e
    i o0(@k.e.a.d i iVar, @k.e.a.d CaptureStatus captureStatus);

    @k.e.a.d
    i p(@k.e.a.d c cVar);

    @k.e.a.e
    c p0(@k.e.a.d i iVar);

    boolean q(@k.e.a.d l lVar);

    boolean q0(@k.e.a.d m mVar);

    @k.e.a.d
    TypeVariance r(@k.e.a.d n nVar);

    @k.e.a.e
    d r0(@k.e.a.d e eVar);

    boolean s(@k.e.a.d i iVar);

    boolean s0(@k.e.a.d m mVar, @k.e.a.d m mVar2);

    int t(@k.e.a.d k kVar);

    @k.e.a.d
    i u(@k.e.a.d g gVar);

    boolean v(@k.e.a.d i iVar);

    boolean w(@k.e.a.d g gVar);

    @k.e.a.d
    l y(@k.e.a.d g gVar);

    @k.e.a.d
    h.p2.b0.g.t.n.g1.a z(@k.e.a.d b bVar);
}
