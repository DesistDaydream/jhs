package h.p2.b0.g.t.n;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;

/* loaded from: classes3.dex */
public final class f {
    @k.e.a.d
    public static final f a = new f();
    @h.k2.d
    public static boolean b;

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[TypeVariance.values().length];
            iArr[TypeVariance.INV.ordinal()] = 1;
            iArr[TypeVariance.OUT.ordinal()] = 2;
            iArr[TypeVariance.IN.ordinal()] = 3;
            a = iArr;
            int[] iArr2 = new int[AbstractTypeCheckerContext.LowerCapturedTypePolicy.values().length];
            iArr2[AbstractTypeCheckerContext.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
            iArr2[AbstractTypeCheckerContext.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            iArr2[AbstractTypeCheckerContext.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
            b = iArr2;
        }
    }

    private f() {
    }

    private final Boolean a(AbstractTypeCheckerContext abstractTypeCheckerContext, h.p2.b0.g.t.n.g1.i iVar, h.p2.b0.g.t.n.g1.i iVar2) {
        Boolean bool = Boolean.TRUE;
        h.p2.b0.g.t.n.g1.p j2 = abstractTypeCheckerContext.j();
        if (j2.W(iVar) || j2.W(iVar2)) {
            if (j2.W(iVar) && j2.W(iVar2)) {
                return bool;
            }
            if (j2.W(iVar)) {
                if (c(j2, abstractTypeCheckerContext, iVar, iVar2, false)) {
                    return bool;
                }
            } else if (j2.W(iVar2) && (b(j2, iVar) || c(j2, abstractTypeCheckerContext, iVar2, iVar, true))) {
                return bool;
            }
            return null;
        }
        return null;
    }

    private static final boolean b(h.p2.b0.g.t.n.g1.p pVar, h.p2.b0.g.t.n.g1.i iVar) {
        boolean z;
        h.p2.b0.g.t.n.g1.m c2 = pVar.c(iVar);
        if (c2 instanceof h.p2.b0.g.t.n.g1.f) {
            Collection<h.p2.b0.g.t.n.g1.g> Q = pVar.Q(c2);
            if (!(Q instanceof Collection) || !Q.isEmpty()) {
                for (h.p2.b0.g.t.n.g1.g gVar : Q) {
                    h.p2.b0.g.t.n.g1.i b2 = pVar.b(gVar);
                    if (h.k2.v.f0.g(b2 == null ? null : Boolean.valueOf(pVar.W(b2)), Boolean.TRUE)) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return false;
    }

    private static final boolean c(h.p2.b0.g.t.n.g1.p pVar, AbstractTypeCheckerContext abstractTypeCheckerContext, h.p2.b0.g.t.n.g1.i iVar, h.p2.b0.g.t.n.g1.i iVar2, boolean z) {
        boolean z2;
        Collection<h.p2.b0.g.t.n.g1.g> R = pVar.R(iVar);
        if (!(R instanceof Collection) || !R.isEmpty()) {
            for (h.p2.b0.g.t.n.g1.g gVar : R) {
                if (h.k2.v.f0.g(pVar.S(gVar), pVar.c(iVar2)) || (z && p(a, abstractTypeCheckerContext, iVar2, gVar, false, 8, null))) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    private final Boolean d(AbstractTypeCheckerContext abstractTypeCheckerContext, h.p2.b0.g.t.n.g1.i iVar, h.p2.b0.g.t.n.g1.i iVar2) {
        h.p2.b0.g.t.n.g1.i iVar3;
        h.p2.b0.g.t.n.g1.n k2;
        Boolean bool = Boolean.TRUE;
        h.p2.b0.g.t.n.g1.p j2 = abstractTypeCheckerContext.j();
        boolean z = false;
        if (j2.w(iVar) || j2.w(iVar2)) {
            return abstractTypeCheckerContext.n() ? bool : (!j2.v(iVar) || j2.v(iVar2)) ? Boolean.valueOf(d.a.b(j2, j2.d(iVar, false), j2.d(iVar2, false))) : Boolean.FALSE;
        } else if (!j2.D(iVar) && !j2.D(iVar2)) {
            h.p2.b0.g.t.n.g1.c p0 = j2.p0(iVar2);
            if (p0 == null || (iVar3 = j2.p(p0)) == null) {
                iVar3 = iVar2;
            }
            h.p2.b0.g.t.n.g1.b h0 = j2.h0(iVar3);
            h.p2.b0.g.t.n.g1.g d0 = h0 == null ? null : j2.d0(h0);
            if (h0 != null && d0 != null) {
                if (j2.v(iVar2)) {
                    d0 = j2.o(d0, true);
                } else if (j2.V(iVar2)) {
                    d0 = j2.b0(d0);
                }
                h.p2.b0.g.t.n.g1.g gVar = d0;
                int i2 = a.b[abstractTypeCheckerContext.g(iVar, h0).ordinal()];
                if (i2 != 1) {
                    if (i2 == 2 && p(a, abstractTypeCheckerContext, iVar, gVar, false, 8, null)) {
                        return bool;
                    }
                } else {
                    return Boolean.valueOf(p(a, abstractTypeCheckerContext, iVar, gVar, false, 8, null));
                }
            }
            h.p2.b0.g.t.n.g1.m c2 = j2.c(iVar2);
            if (j2.f0(c2)) {
                j2.v(iVar2);
                Collection<h.p2.b0.g.t.n.g1.g> Q = j2.Q(c2);
                if (!(Q instanceof Collection) || !Q.isEmpty()) {
                    for (h.p2.b0.g.t.n.g1.g gVar2 : Q) {
                        if (!p(a, abstractTypeCheckerContext, iVar, gVar2, false, 8, null)) {
                            break;
                        }
                    }
                }
                z = true;
                return Boolean.valueOf(z);
            } else if ((iVar instanceof h.p2.b0.g.t.n.g1.b) && (k2 = a.k(abstractTypeCheckerContext.j(), iVar2, iVar)) != null && j2.i(k2, j2.c(iVar2))) {
                return bool;
            } else {
                return null;
            }
        } else {
            return Boolean.valueOf(abstractTypeCheckerContext.o());
        }
    }

    private final List<h.p2.b0.g.t.n.g1.i> e(AbstractTypeCheckerContext abstractTypeCheckerContext, h.p2.b0.g.t.n.g1.i iVar, h.p2.b0.g.t.n.g1.m mVar) {
        AbstractTypeCheckerContext.a r;
        h.p2.b0.g.t.n.g1.p j2 = abstractTypeCheckerContext.j();
        List<h.p2.b0.g.t.n.g1.i> N = j2.N(iVar, mVar);
        if (N == null) {
            if (!j2.e0(mVar) && j2.H(iVar)) {
                return CollectionsKt__CollectionsKt.E();
            }
            if (j2.q0(mVar)) {
                if (j2.s0(j2.c(iVar), mVar)) {
                    h.p2.b0.g.t.n.g1.i o0 = j2.o0(iVar, CaptureStatus.FOR_SUBTYPING);
                    if (o0 != null) {
                        iVar = o0;
                    }
                    return h.a2.t.k(iVar);
                }
                return CollectionsKt__CollectionsKt.E();
            }
            N = new h.p2.b0.g.t.p.d<>();
            abstractTypeCheckerContext.k();
            ArrayDeque<h.p2.b0.g.t.n.g1.i> h2 = abstractTypeCheckerContext.h();
            Set<h.p2.b0.g.t.n.g1.i> i2 = abstractTypeCheckerContext.i();
            h2.push(iVar);
            while (!h2.isEmpty()) {
                if (i2.size() > 1000) {
                    throw new IllegalStateException(("Too many supertypes for type: " + iVar + ". Supertypes = " + CollectionsKt___CollectionsKt.Z2(i2, null, null, null, 0, null, null, 63, null)).toString());
                }
                h.p2.b0.g.t.n.g1.i pop = h2.pop();
                if (i2.add(pop)) {
                    h.p2.b0.g.t.n.g1.i o02 = j2.o0(pop, CaptureStatus.FOR_SUBTYPING);
                    if (o02 == null) {
                        o02 = pop;
                    }
                    if (j2.s0(j2.c(o02), mVar)) {
                        N.add(o02);
                        r = AbstractTypeCheckerContext.a.c.a;
                    } else if (j2.g(o02) == 0) {
                        r = AbstractTypeCheckerContext.a.b.a;
                    } else {
                        r = abstractTypeCheckerContext.r(o02);
                    }
                    if (!(!h.k2.v.f0.g(r, AbstractTypeCheckerContext.a.c.a))) {
                        r = null;
                    }
                    if (r != null) {
                        h.p2.b0.g.t.n.g1.p j3 = abstractTypeCheckerContext.j();
                        for (h.p2.b0.g.t.n.g1.g gVar : j3.Q(j3.c(pop))) {
                            h2.add(r.a(abstractTypeCheckerContext, gVar));
                        }
                    }
                }
            }
            abstractTypeCheckerContext.e();
        }
        return N;
    }

    private final List<h.p2.b0.g.t.n.g1.i> f(AbstractTypeCheckerContext abstractTypeCheckerContext, h.p2.b0.g.t.n.g1.i iVar, h.p2.b0.g.t.n.g1.m mVar) {
        return s(abstractTypeCheckerContext, e(abstractTypeCheckerContext, iVar, mVar));
    }

    private final boolean g(AbstractTypeCheckerContext abstractTypeCheckerContext, h.p2.b0.g.t.n.g1.g gVar, h.p2.b0.g.t.n.g1.g gVar2, boolean z) {
        h.p2.b0.g.t.n.g1.p j2 = abstractTypeCheckerContext.j();
        h.p2.b0.g.t.n.g1.g p = abstractTypeCheckerContext.p(abstractTypeCheckerContext.q(gVar));
        h.p2.b0.g.t.n.g1.g p2 = abstractTypeCheckerContext.p(abstractTypeCheckerContext.q(gVar2));
        f fVar = a;
        Boolean d2 = fVar.d(abstractTypeCheckerContext, j2.j0(p), j2.u(p2));
        if (d2 == null) {
            Boolean c2 = abstractTypeCheckerContext.c(p, p2, z);
            if (c2 == null) {
                return fVar.q(abstractTypeCheckerContext, j2.j0(p), j2.u(p2));
            }
            return c2.booleanValue();
        }
        boolean booleanValue = d2.booleanValue();
        abstractTypeCheckerContext.c(p, p2, z);
        return booleanValue;
    }

    private final h.p2.b0.g.t.n.g1.n k(h.p2.b0.g.t.n.g1.p pVar, h.p2.b0.g.t.n.g1.g gVar, h.p2.b0.g.t.n.g1.g gVar2) {
        int g2 = pVar.g(gVar);
        if (g2 > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                h.p2.b0.g.t.n.g1.l A = pVar.A(gVar, i2);
                if (!(!pVar.q(A))) {
                    A = null;
                }
                if (A != null) {
                    if (h.k2.v.f0.g(pVar.getType(A), gVar2)) {
                        return pVar.l(pVar.S(gVar), i2);
                    }
                    h.p2.b0.g.t.n.g1.n k2 = k(pVar, pVar.getType(A), gVar2);
                    if (k2 != null) {
                        return k2;
                    }
                }
                if (i3 >= g2) {
                    break;
                }
                i2 = i3;
            }
        }
        return null;
    }

    private final boolean l(AbstractTypeCheckerContext abstractTypeCheckerContext, h.p2.b0.g.t.n.g1.i iVar) {
        AbstractTypeCheckerContext.a aVar;
        h.p2.b0.g.t.n.g1.p j2 = abstractTypeCheckerContext.j();
        h.p2.b0.g.t.n.g1.m c2 = j2.c(iVar);
        if (j2.e0(c2)) {
            return j2.O(c2);
        }
        if (j2.O(j2.c(iVar))) {
            return true;
        }
        abstractTypeCheckerContext.k();
        ArrayDeque<h.p2.b0.g.t.n.g1.i> h2 = abstractTypeCheckerContext.h();
        Set<h.p2.b0.g.t.n.g1.i> i2 = abstractTypeCheckerContext.i();
        h2.push(iVar);
        while (!h2.isEmpty()) {
            if (i2.size() > 1000) {
                throw new IllegalStateException(("Too many supertypes for type: " + iVar + ". Supertypes = " + CollectionsKt___CollectionsKt.Z2(i2, null, null, null, 0, null, null, 63, null)).toString());
            }
            h.p2.b0.g.t.n.g1.i pop = h2.pop();
            if (i2.add(pop)) {
                if (j2.H(pop)) {
                    aVar = AbstractTypeCheckerContext.a.c.a;
                } else {
                    aVar = AbstractTypeCheckerContext.a.b.a;
                }
                if (!(!h.k2.v.f0.g(aVar, AbstractTypeCheckerContext.a.c.a))) {
                    aVar = null;
                }
                if (aVar == null) {
                    continue;
                } else {
                    h.p2.b0.g.t.n.g1.p j3 = abstractTypeCheckerContext.j();
                    for (h.p2.b0.g.t.n.g1.g gVar : j3.Q(j3.c(pop))) {
                        h.p2.b0.g.t.n.g1.i a2 = aVar.a(abstractTypeCheckerContext, gVar);
                        if (j2.O(j2.c(a2))) {
                            abstractTypeCheckerContext.e();
                            return true;
                        }
                        h2.add(a2);
                    }
                    continue;
                }
            }
        }
        abstractTypeCheckerContext.e();
        return false;
    }

    private final boolean m(h.p2.b0.g.t.n.g1.p pVar, h.p2.b0.g.t.n.g1.g gVar) {
        return pVar.T(pVar.S(gVar)) && !pVar.P(gVar) && !pVar.V(gVar) && h.k2.v.f0.g(pVar.c(pVar.j0(gVar)), pVar.c(pVar.u(gVar)));
    }

    public static /* synthetic */ boolean p(f fVar, AbstractTypeCheckerContext abstractTypeCheckerContext, h.p2.b0.g.t.n.g1.g gVar, h.p2.b0.g.t.n.g1.g gVar2, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        return fVar.o(abstractTypeCheckerContext, gVar, gVar2, z);
    }

    private final boolean q(AbstractTypeCheckerContext abstractTypeCheckerContext, h.p2.b0.g.t.n.g1.i iVar, h.p2.b0.g.t.n.g1.i iVar2) {
        boolean z;
        h.p2.b0.g.t.n.g1.m mVar;
        h.p2.b0.g.t.n.g1.m mVar2;
        h.p2.b0.g.t.n.g1.p j2 = abstractTypeCheckerContext.j();
        if (b) {
            if (!j2.s(iVar) && !j2.f0(j2.c(iVar))) {
                abstractTypeCheckerContext.m(iVar);
            }
            if (!j2.s(iVar2)) {
                abstractTypeCheckerContext.m(iVar2);
            }
        }
        if (c.a.d(abstractTypeCheckerContext, iVar, iVar2)) {
            f fVar = a;
            Boolean a2 = fVar.a(abstractTypeCheckerContext, j2.j0(iVar), j2.u(iVar2));
            if (a2 == null) {
                h.p2.b0.g.t.n.g1.m c2 = j2.c(iVar2);
                if ((j2.s0(j2.c(iVar), c2) && j2.K(c2) == 0) || j2.C(j2.c(iVar2))) {
                    return true;
                }
                List<h.p2.b0.g.t.n.g1.i> j3 = fVar.j(abstractTypeCheckerContext, iVar, c2);
                int i2 = 10;
                ArrayList<h.p2.b0.g.t.n.g1.i> arrayList = new ArrayList(h.a2.u.Y(j3, 10));
                for (h.p2.b0.g.t.n.g1.i iVar3 : j3) {
                    h.p2.b0.g.t.n.g1.i b2 = j2.b(abstractTypeCheckerContext.p(iVar3));
                    if (b2 != null) {
                        iVar3 = b2;
                    }
                    arrayList.add(iVar3);
                }
                int size = arrayList.size();
                if (size != 0) {
                    if (size != 1) {
                        ArgumentList argumentList = new ArgumentList(j2.K(c2));
                        int K = j2.K(c2);
                        if (K > 0) {
                            int i3 = 0;
                            z = false;
                            while (true) {
                                int i4 = i3 + 1;
                                z = z || j2.r(j2.l(c2, i3)) != TypeVariance.OUT;
                                if (z) {
                                    mVar = c2;
                                } else {
                                    List<? extends h.p2.b0.g.t.n.g1.g> arrayList2 = new ArrayList<>(h.a2.u.Y(arrayList, i2));
                                    for (h.p2.b0.g.t.n.g1.i iVar4 : arrayList) {
                                        h.p2.b0.g.t.n.g1.l I = j2.I(iVar4, i3);
                                        h.p2.b0.g.t.n.g1.g gVar = null;
                                        if (I == null) {
                                            mVar2 = c2;
                                        } else {
                                            mVar2 = c2;
                                            if (!(j2.k0(I) == TypeVariance.INV)) {
                                                I = null;
                                            }
                                            if (I != null) {
                                                gVar = j2.getType(I);
                                            }
                                        }
                                        h.p2.b0.g.t.n.g1.g gVar2 = gVar;
                                        if (gVar2 == null) {
                                            throw new IllegalStateException(("Incorrect type: " + iVar4 + ", subType: " + iVar + ", superType: " + iVar2).toString());
                                        }
                                        arrayList2.add(gVar2);
                                        c2 = mVar2;
                                    }
                                    mVar = c2;
                                    argumentList.add(j2.y(j2.Z(arrayList2)));
                                }
                                if (i4 >= K) {
                                    break;
                                }
                                i3 = i4;
                                c2 = mVar;
                                i2 = 10;
                            }
                        } else {
                            z = false;
                        }
                        if (z || !a.n(abstractTypeCheckerContext, argumentList, iVar2)) {
                            if (!arrayList.isEmpty()) {
                                for (h.p2.b0.g.t.n.g1.i iVar5 : arrayList) {
                                    if (a.n(abstractTypeCheckerContext, j2.j(iVar5), iVar2)) {
                                        return true;
                                    }
                                }
                            }
                            return false;
                        }
                        return true;
                    }
                    return a.n(abstractTypeCheckerContext, j2.j((h.p2.b0.g.t.n.g1.i) CollectionsKt___CollectionsKt.o2(arrayList)), iVar2);
                }
                return a.l(abstractTypeCheckerContext, iVar);
            }
            boolean booleanValue = a2.booleanValue();
            AbstractTypeCheckerContext.d(abstractTypeCheckerContext, iVar, iVar2, false, 4, null);
            return booleanValue;
        }
        return false;
    }

    private final boolean r(h.p2.b0.g.t.n.g1.p pVar, h.p2.b0.g.t.n.g1.g gVar, h.p2.b0.g.t.n.g1.g gVar2, h.p2.b0.g.t.n.g1.m mVar) {
        h.p2.b0.g.t.n.g1.i b2 = pVar.b(gVar);
        if (b2 instanceof h.p2.b0.g.t.n.g1.b) {
            h.p2.b0.g.t.n.g1.b bVar = (h.p2.b0.g.t.n.g1.b) b2;
            if (pVar.q(pVar.c0(pVar.z(bVar))) && pVar.a0(bVar) == CaptureStatus.FOR_SUBTYPING) {
                h.p2.b0.g.t.n.g1.m S = pVar.S(gVar2);
                h.p2.b0.g.t.n.g1.t tVar = S instanceof h.p2.b0.g.t.n.g1.t ? (h.p2.b0.g.t.n.g1.t) S : null;
                if (tVar == null) {
                    return false;
                }
                h.p2.b0.g.t.n.g1.n m0 = pVar.m0(tVar);
                return h.k2.v.f0.g(m0 != null ? Boolean.valueOf(pVar.i(m0, mVar)) : null, Boolean.TRUE);
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List<h.p2.b0.g.t.n.g1.i> s(AbstractTypeCheckerContext abstractTypeCheckerContext, List<? extends h.p2.b0.g.t.n.g1.i> list) {
        h.p2.b0.g.t.n.g1.p j2 = abstractTypeCheckerContext.j();
        if (list.size() < 2) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            h.p2.b0.g.t.n.g1.k j3 = j2.j((h.p2.b0.g.t.n.g1.i) next);
            int t = j2.t(j3);
            int i2 = 0;
            while (true) {
                if (i2 >= t) {
                    break;
                }
                if (!(j2.Y(j2.getType(j2.k(j3, i2))) == null)) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        return arrayList.isEmpty() ^ true ? arrayList : list;
    }

    @k.e.a.e
    public final TypeVariance h(@k.e.a.d TypeVariance typeVariance, @k.e.a.d TypeVariance typeVariance2) {
        TypeVariance typeVariance3 = TypeVariance.INV;
        if (typeVariance == typeVariance3) {
            return typeVariance2;
        }
        if (typeVariance2 == typeVariance3 || typeVariance == typeVariance2) {
            return typeVariance;
        }
        return null;
    }

    public final boolean i(@k.e.a.d AbstractTypeCheckerContext abstractTypeCheckerContext, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar2) {
        h.p2.b0.g.t.n.g1.p j2 = abstractTypeCheckerContext.j();
        if (gVar == gVar2) {
            return true;
        }
        f fVar = a;
        if (fVar.m(j2, gVar) && fVar.m(j2, gVar2)) {
            h.p2.b0.g.t.n.g1.g q = abstractTypeCheckerContext.q(gVar);
            h.p2.b0.g.t.n.g1.g q2 = abstractTypeCheckerContext.q(gVar2);
            h.p2.b0.g.t.n.g1.i j0 = j2.j0(q);
            if (!j2.s0(j2.S(q), j2.S(q2))) {
                return false;
            }
            if (j2.g(j0) == 0) {
                return j2.U(q) || j2.U(q2) || j2.v(j0) == j2.v(j2.j0(q2));
            }
        }
        return p(fVar, abstractTypeCheckerContext, gVar, gVar2, false, 8, null) && p(fVar, abstractTypeCheckerContext, gVar2, gVar, false, 8, null);
    }

    @k.e.a.d
    public final List<h.p2.b0.g.t.n.g1.i> j(@k.e.a.d AbstractTypeCheckerContext abstractTypeCheckerContext, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
        AbstractTypeCheckerContext.a aVar;
        h.p2.b0.g.t.n.g1.p j2 = abstractTypeCheckerContext.j();
        if (j2.H(iVar)) {
            return a.f(abstractTypeCheckerContext, iVar, mVar);
        }
        if (!j2.e0(mVar) && !j2.F(mVar)) {
            return a.e(abstractTypeCheckerContext, iVar, mVar);
        }
        h.p2.b0.g.t.p.d<h.p2.b0.g.t.n.g1.i> dVar = new h.p2.b0.g.t.p.d();
        abstractTypeCheckerContext.k();
        ArrayDeque<h.p2.b0.g.t.n.g1.i> h2 = abstractTypeCheckerContext.h();
        Set<h.p2.b0.g.t.n.g1.i> i2 = abstractTypeCheckerContext.i();
        h2.push(iVar);
        while (!h2.isEmpty()) {
            if (i2.size() > 1000) {
                throw new IllegalStateException(("Too many supertypes for type: " + iVar + ". Supertypes = " + CollectionsKt___CollectionsKt.Z2(i2, null, null, null, 0, null, null, 63, null)).toString());
            }
            h.p2.b0.g.t.n.g1.i pop = h2.pop();
            if (i2.add(pop)) {
                if (j2.H(pop)) {
                    dVar.add(pop);
                    aVar = AbstractTypeCheckerContext.a.c.a;
                } else {
                    aVar = AbstractTypeCheckerContext.a.b.a;
                }
                if (!(!h.k2.v.f0.g(aVar, AbstractTypeCheckerContext.a.c.a))) {
                    aVar = null;
                }
                if (aVar != null) {
                    h.p2.b0.g.t.n.g1.p j3 = abstractTypeCheckerContext.j();
                    for (h.p2.b0.g.t.n.g1.g gVar : j3.Q(j3.c(pop))) {
                        h2.add(aVar.a(abstractTypeCheckerContext, gVar));
                    }
                }
            }
        }
        abstractTypeCheckerContext.e();
        ArrayList arrayList = new ArrayList();
        for (h.p2.b0.g.t.n.g1.i iVar2 : dVar) {
            h.a2.y.q0(arrayList, a.f(abstractTypeCheckerContext, iVar2, mVar));
        }
        return arrayList;
    }

    public final boolean n(@k.e.a.d AbstractTypeCheckerContext abstractTypeCheckerContext, @k.e.a.d h.p2.b0.g.t.n.g1.k kVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar) {
        int i2;
        int i3;
        boolean i4;
        int i5;
        h.p2.b0.g.t.n.g1.p j2 = abstractTypeCheckerContext.j();
        h.p2.b0.g.t.n.g1.m c2 = j2.c(iVar);
        int t = j2.t(kVar);
        int K = j2.K(c2);
        if (t == K && t == j2.g(iVar)) {
            if (K > 0) {
                int i6 = 0;
                while (true) {
                    int i7 = i6 + 1;
                    h.p2.b0.g.t.n.g1.l A = j2.A(iVar, i6);
                    if (!j2.q(A)) {
                        h.p2.b0.g.t.n.g1.g type = j2.getType(A);
                        h.p2.b0.g.t.n.g1.l k2 = j2.k(kVar, i6);
                        j2.k0(k2);
                        TypeVariance typeVariance = TypeVariance.INV;
                        h.p2.b0.g.t.n.g1.g type2 = j2.getType(k2);
                        f fVar = a;
                        TypeVariance h2 = fVar.h(j2.r(j2.l(c2, i6)), j2.k0(A));
                        if (h2 == null) {
                            return abstractTypeCheckerContext.n();
                        }
                        if (!(h2 == typeVariance && (fVar.r(j2, type2, type, c2) || fVar.r(j2, type, type2, c2)))) {
                            i2 = abstractTypeCheckerContext.a;
                            if (i2 <= 100) {
                                i3 = abstractTypeCheckerContext.a;
                                abstractTypeCheckerContext.a = i3 + 1;
                                int i8 = a.a[h2.ordinal()];
                                if (i8 == 1) {
                                    i4 = fVar.i(abstractTypeCheckerContext, type2, type);
                                } else if (i8 == 2) {
                                    i4 = p(fVar, abstractTypeCheckerContext, type2, type, false, 8, null);
                                } else if (i8 != 3) {
                                    throw new NoWhenBranchMatchedException();
                                } else {
                                    i4 = p(fVar, abstractTypeCheckerContext, type, type2, false, 8, null);
                                }
                                i5 = abstractTypeCheckerContext.a;
                                abstractTypeCheckerContext.a = i5 - 1;
                                if (!i4) {
                                    return false;
                                }
                            } else {
                                throw new IllegalStateException(h.k2.v.f0.C("Arguments depth is too high. Some related argument: ", type2).toString());
                            }
                        }
                    }
                    if (i7 >= K) {
                        break;
                    }
                    i6 = i7;
                }
            }
            return true;
        }
        return false;
    }

    public final boolean o(@k.e.a.d AbstractTypeCheckerContext abstractTypeCheckerContext, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar2, boolean z) {
        if (gVar == gVar2) {
            return true;
        }
        if (abstractTypeCheckerContext.f(gVar, gVar2)) {
            return g(abstractTypeCheckerContext, gVar, gVar2, z);
        }
        return false;
    }
}
