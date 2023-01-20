package h.p2.b0.g.t.n.e1;

import h.k2.v.n0;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.s0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.x;
import h.p2.b0.g.t.n.a0;
import h.p2.b0.g.t.n.c1;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.g1.r;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.x0;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public interface c extends x0, h.p2.b0.g.t.n.g1.r {

    /* loaded from: classes3.dex */
    public static final class a {
        public static boolean A(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar, @k.e.a.d h.p2.b0.g.t.g.c cVar2) {
            if (gVar instanceof z) {
                return ((z) gVar).getAnnotations().n(cVar2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + n0.d(gVar.getClass())).toString());
        }

        public static boolean B(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
            return r.a.d(cVar, gVar);
        }

        public static boolean C(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.n nVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
            if (nVar instanceof t0) {
                if (mVar instanceof q0) {
                    return TypeUtilsKt.k((t0) nVar, (q0) mVar, null, 4, null);
                }
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + n0.d(nVar.getClass())).toString());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + n0.d(nVar.getClass())).toString());
        }

        public static boolean D(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar2) {
            if (iVar instanceof f0) {
                if (iVar2 instanceof f0) {
                    return ((f0) iVar).H0() == ((f0) iVar2).H0();
                }
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar2 + ", " + n0.d(iVar2.getClass())).toString());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + n0.d(iVar.getClass())).toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.g E(@k.e.a.d c cVar, @k.e.a.d List<? extends h.p2.b0.g.t.n.g1.g> list) {
            return e.a(list);
        }

        public static boolean F(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
            if (mVar instanceof q0) {
                return h.p2.b0.g.t.b.f.t0((q0) mVar, g.a.b);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + n0.d(mVar.getClass())).toString());
        }

        public static boolean G(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar) {
            return r.a.e(cVar, iVar);
        }

        public static boolean H(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
            if (mVar instanceof q0) {
                return ((q0) mVar).c() instanceof h.p2.b0.g.t.c.d;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + n0.d(mVar.getClass())).toString());
        }

        public static boolean I(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
            if (mVar instanceof q0) {
                h.p2.b0.g.t.c.f c2 = ((q0) mVar).c();
                h.p2.b0.g.t.c.d dVar = c2 instanceof h.p2.b0.g.t.c.d ? (h.p2.b0.g.t.c.d) c2 : null;
                return (dVar == null || !x.a(dVar) || dVar.i() == ClassKind.ENUM_ENTRY || dVar.i() == ClassKind.ANNOTATION_CLASS) ? false : true;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + n0.d(mVar.getClass())).toString());
        }

        public static boolean J(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
            return r.a.f(cVar, gVar);
        }

        public static boolean K(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
            if (mVar instanceof q0) {
                return ((q0) mVar).d();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + n0.d(mVar.getClass())).toString());
        }

        public static boolean L(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
            return r.a.g(cVar, gVar);
        }

        public static boolean M(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
            if (gVar instanceof z) {
                return a0.a((z) gVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + n0.d(gVar.getClass())).toString());
        }

        public static boolean N(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
            if (mVar instanceof q0) {
                h.p2.b0.g.t.c.f c2 = ((q0) mVar).c();
                h.p2.b0.g.t.c.d dVar = c2 instanceof h.p2.b0.g.t.c.d ? (h.p2.b0.g.t.c.d) c2 : null;
                return h.k2.v.f0.g(dVar != null ? Boolean.valueOf(h.p2.b0.g.t.k.d.b(dVar)) : null, Boolean.TRUE);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + n0.d(mVar.getClass())).toString());
        }

        public static boolean O(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar) {
            return r.a.h(cVar, iVar);
        }

        public static boolean P(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
            if (mVar instanceof q0) {
                return mVar instanceof IntegerLiteralTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + n0.d(mVar.getClass())).toString());
        }

        public static boolean Q(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
            if (mVar instanceof q0) {
                return mVar instanceof IntersectionTypeConstructor;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + n0.d(mVar.getClass())).toString());
        }

        public static boolean R(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
            return r.a.i(cVar, gVar);
        }

        public static boolean S(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar) {
            if (iVar instanceof f0) {
                return ((f0) iVar).J0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + n0.d(iVar.getClass())).toString());
        }

        public static boolean T(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
            return r.a.j(cVar, gVar);
        }

        public static boolean U(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
            if (mVar instanceof q0) {
                return h.p2.b0.g.t.b.f.t0((q0) mVar, g.a.f15036c);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + n0.d(mVar.getClass())).toString());
        }

        public static boolean V(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
            if (gVar instanceof z) {
                return y0.l((z) gVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + n0.d(gVar.getClass())).toString());
        }

        public static boolean W(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar) {
            if (iVar instanceof z) {
                return h.p2.b0.g.t.b.f.p0((z) iVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + n0.d(iVar.getClass())).toString());
        }

        public static boolean X(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.b bVar) {
            if (bVar instanceof j) {
                return ((j) bVar).U0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + bVar + ", " + n0.d(bVar.getClass())).toString());
        }

        public static boolean Y(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar) {
            if (iVar instanceof f0) {
                if (!a0.a((z) iVar)) {
                    f0 f0Var = (f0) iVar;
                    if (!(f0Var.I0().c() instanceof s0) && (f0Var.I0().c() != null || (iVar instanceof h.p2.b0.g.t.k.m.a.a) || (iVar instanceof j) || (iVar instanceof h.p2.b0.g.t.n.j) || (f0Var.I0() instanceof IntegerLiteralTypeConstructor))) {
                        return true;
                    }
                }
                return false;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + n0.d(iVar.getClass())).toString());
        }

        public static boolean Z(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.l lVar) {
            if (lVar instanceof h.p2.b0.g.t.n.s0) {
                return ((h.p2.b0.g.t.n.s0) lVar).b();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + n0.d(lVar.getClass())).toString());
        }

        public static boolean a(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar2) {
            if (mVar instanceof q0) {
                if (mVar2 instanceof q0) {
                    return h.k2.v.f0.g(mVar, mVar2);
                }
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar2 + ", " + n0.d(mVar2.getClass())).toString());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + n0.d(mVar.getClass())).toString());
        }

        public static boolean a0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar) {
            if (iVar instanceof f0) {
                return iVar instanceof h.p2.b0.g.t.n.e;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + n0.d(iVar.getClass())).toString());
        }

        public static int b(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
            if (gVar instanceof z) {
                return ((z) gVar).H0().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + n0.d(gVar.getClass())).toString());
        }

        public static boolean b0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
            if (mVar instanceof q0) {
                h.p2.b0.g.t.c.f c2 = ((q0) mVar).c();
                return h.k2.v.f0.g(c2 == null ? null : Boolean.valueOf(h.p2.b0.g.t.b.f.y0(c2)), Boolean.TRUE);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + n0.d(mVar.getClass())).toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.k c(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar) {
            if (iVar instanceof f0) {
                return (h.p2.b0.g.t.n.g1.k) iVar;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + n0.d(iVar.getClass())).toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.i c0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.e eVar) {
            if (eVar instanceof h.p2.b0.g.t.n.u) {
                return ((h.p2.b0.g.t.n.u) eVar).Q0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + eVar + ", " + n0.d(eVar.getClass())).toString());
        }

        @k.e.a.e
        public static h.p2.b0.g.t.n.g1.b d(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar) {
            if (iVar instanceof f0) {
                if (iVar instanceof j) {
                    return (j) iVar;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + n0.d(iVar.getClass())).toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.i d0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
            return r.a.k(cVar, gVar);
        }

        @k.e.a.e
        public static h.p2.b0.g.t.n.g1.c e(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar) {
            if (iVar instanceof f0) {
                if (iVar instanceof h.p2.b0.g.t.n.j) {
                    return (h.p2.b0.g.t.n.j) iVar;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + n0.d(iVar.getClass())).toString());
        }

        @k.e.a.e
        public static h.p2.b0.g.t.n.g1.g e0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.b bVar) {
            if (bVar instanceof j) {
                return ((j) bVar).T0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + bVar + ", " + n0.d(bVar.getClass())).toString());
        }

        @k.e.a.e
        public static h.p2.b0.g.t.n.g1.d f(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.e eVar) {
            if (eVar instanceof h.p2.b0.g.t.n.u) {
                if (eVar instanceof h.p2.b0.g.t.n.p) {
                    return (h.p2.b0.g.t.n.p) eVar;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + eVar + ", " + n0.d(eVar.getClass())).toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.g f0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
            c1 b;
            if (gVar instanceof c1) {
                b = d.b((c1) gVar);
                return b;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + n0.d(gVar.getClass())).toString());
        }

        @k.e.a.e
        public static h.p2.b0.g.t.n.g1.e g(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
            if (gVar instanceof z) {
                c1 L0 = ((z) gVar).L0();
                if (L0 instanceof h.p2.b0.g.t.n.u) {
                    return (h.p2.b0.g.t.n.u) L0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + n0.d(gVar.getClass())).toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.g g0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
            return x0.a.a(cVar, gVar);
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.g getType(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.l lVar) {
            if (lVar instanceof h.p2.b0.g.t.n.s0) {
                return ((h.p2.b0.g.t.n.s0) lVar).getType().L0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + n0.d(lVar.getClass())).toString());
        }

        @k.e.a.e
        public static h.p2.b0.g.t.n.g1.i h(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
            if (gVar instanceof z) {
                c1 L0 = ((z) gVar).L0();
                if (L0 instanceof f0) {
                    return (f0) L0;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + n0.d(gVar.getClass())).toString());
        }

        @k.e.a.d
        public static AbstractTypeCheckerContext h0(@k.e.a.d c cVar, boolean z, boolean z2) {
            return new h.p2.b0.g.t.n.e1.a(z, z2, false, null, null, cVar, 28, null);
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.l i(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
            if (gVar instanceof z) {
                return TypeUtilsKt.a((z) gVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + n0.d(gVar.getClass())).toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.i i0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.c cVar2) {
            if (cVar2 instanceof h.p2.b0.g.t.n.j) {
                return ((h.p2.b0.g.t.n.j) cVar2).U0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + cVar2 + ", " + n0.d(cVar2.getClass())).toString());
        }

        @k.e.a.e
        public static h.p2.b0.g.t.n.g1.i j(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar, @k.e.a.d CaptureStatus captureStatus) {
            if (iVar instanceof f0) {
                return k.b((f0) iVar, captureStatus);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + n0.d(iVar.getClass())).toString());
        }

        public static int j0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
            if (mVar instanceof q0) {
                return ((q0) mVar).getParameters().size();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + n0.d(mVar.getClass())).toString());
        }

        @k.e.a.d
        public static CaptureStatus k(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.b bVar) {
            if (bVar instanceof j) {
                return ((j) bVar).R0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + bVar + ", " + n0.d(bVar.getClass())).toString());
        }

        @k.e.a.d
        public static Collection<h.p2.b0.g.t.n.g1.g> k0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar) {
            h.p2.b0.g.t.n.g1.m c2 = cVar.c(iVar);
            if (c2 instanceof IntegerLiteralTypeConstructor) {
                return ((IntegerLiteralTypeConstructor) c2).i();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + n0.d(iVar.getClass())).toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.g l(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar2) {
            if (iVar instanceof f0) {
                if (iVar2 instanceof f0) {
                    KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
                    return KotlinTypeFactory.d((f0) iVar, (f0) iVar2);
                }
                throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + cVar + ", " + n0.d(cVar.getClass())).toString());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + cVar + ", " + n0.d(cVar.getClass())).toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.l l0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.a aVar) {
            if (aVar instanceof NewCapturedTypeConstructor) {
                return ((NewCapturedTypeConstructor) aVar).b();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + aVar + ", " + n0.d(aVar.getClass())).toString());
        }

        @k.e.a.e
        public static List<h.p2.b0.g.t.n.g1.i> m(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
            return r.a.a(cVar, iVar, mVar);
        }

        public static int m0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.k kVar) {
            return r.a.l(cVar, kVar);
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.l n(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.k kVar, int i2) {
            return r.a.b(cVar, kVar, i2);
        }

        @k.e.a.d
        public static Collection<h.p2.b0.g.t.n.g1.g> n0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
            if (mVar instanceof q0) {
                return ((q0) mVar).j();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + n0.d(mVar.getClass())).toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.l o(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar, int i2) {
            if (gVar instanceof z) {
                return ((z) gVar).H0().get(i2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + n0.d(gVar.getClass())).toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.a o0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.b bVar) {
            if (bVar instanceof j) {
                return ((j) bVar).I0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + bVar + ", " + n0.d(bVar.getClass())).toString());
        }

        @k.e.a.e
        public static h.p2.b0.g.t.n.g1.l p(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar, int i2) {
            return r.a.c(cVar, iVar, i2);
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.m p0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
            return r.a.m(cVar, gVar);
        }

        @k.e.a.d
        public static h.p2.b0.g.t.g.d q(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
            if (mVar instanceof q0) {
                h.p2.b0.g.t.c.f c2 = ((q0) mVar).c();
                Objects.requireNonNull(c2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return DescriptorUtilsKt.j((h.p2.b0.g.t.c.d) c2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + n0.d(mVar.getClass())).toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.m q0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar) {
            if (iVar instanceof f0) {
                return ((f0) iVar).I0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + n0.d(iVar.getClass())).toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.n r(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar, int i2) {
            if (mVar instanceof q0) {
                return ((q0) mVar).getParameters().get(i2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + n0.d(mVar.getClass())).toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.i r0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.e eVar) {
            if (eVar instanceof h.p2.b0.g.t.n.u) {
                return ((h.p2.b0.g.t.n.u) eVar).R0();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + eVar + ", " + n0.d(eVar.getClass())).toString());
        }

        @k.e.a.e
        public static PrimitiveType s(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
            if (mVar instanceof q0) {
                h.p2.b0.g.t.c.f c2 = ((q0) mVar).c();
                Objects.requireNonNull(c2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return h.p2.b0.g.t.b.f.O((h.p2.b0.g.t.c.d) c2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + n0.d(mVar.getClass())).toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.i s0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
            return r.a.n(cVar, gVar);
        }

        @k.e.a.e
        public static PrimitiveType t(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
            if (mVar instanceof q0) {
                h.p2.b0.g.t.c.f c2 = ((q0) mVar).c();
                Objects.requireNonNull(c2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return h.p2.b0.g.t.b.f.R((h.p2.b0.g.t.c.d) c2);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + n0.d(mVar.getClass())).toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.g t0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar, boolean z) {
            if (gVar instanceof h.p2.b0.g.t.n.g1.i) {
                return cVar.d((h.p2.b0.g.t.n.g1.i) gVar, z);
            }
            if (gVar instanceof h.p2.b0.g.t.n.g1.e) {
                h.p2.b0.g.t.n.g1.e eVar = (h.p2.b0.g.t.n.g1.e) gVar;
                return cVar.m(cVar.d(cVar.a(eVar), z), cVar.d(cVar.e(eVar), z));
            }
            throw new IllegalStateException("sealed".toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.g u(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.n nVar) {
            if (nVar instanceof t0) {
                return TypeUtilsKt.i((t0) nVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + n0.d(nVar.getClass())).toString());
        }

        @k.e.a.d
        public static h.p2.b0.g.t.n.g1.i u0(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar, boolean z) {
            if (iVar instanceof f0) {
                return ((f0) iVar).P0(z);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + iVar + ", " + n0.d(iVar.getClass())).toString());
        }

        @k.e.a.e
        public static h.p2.b0.g.t.n.g1.g v(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.g gVar) {
            if (gVar instanceof z) {
                return h.p2.b0.g.t.k.d.e((z) gVar);
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + gVar + ", " + n0.d(gVar.getClass())).toString());
        }

        @k.e.a.e
        public static h.p2.b0.g.t.n.g1.n w(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.t tVar) {
            if (tVar instanceof n) {
                return ((n) tVar).a();
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + tVar + ", " + n0.d(tVar.getClass())).toString());
        }

        @k.e.a.e
        public static h.p2.b0.g.t.n.g1.n x(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.m mVar) {
            if (mVar instanceof q0) {
                h.p2.b0.g.t.c.f c2 = ((q0) mVar).c();
                if (c2 instanceof t0) {
                    return (t0) c2;
                }
                return null;
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + mVar + ", " + n0.d(mVar.getClass())).toString());
        }

        @k.e.a.d
        public static TypeVariance y(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.l lVar) {
            if (lVar instanceof h.p2.b0.g.t.n.s0) {
                return h.p2.b0.g.t.n.g1.q.a(((h.p2.b0.g.t.n.s0) lVar).c());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + lVar + ", " + n0.d(lVar.getClass())).toString());
        }

        @k.e.a.d
        public static TypeVariance z(@k.e.a.d c cVar, @k.e.a.d h.p2.b0.g.t.n.g1.n nVar) {
            if (nVar instanceof t0) {
                return h.p2.b0.g.t.n.g1.q.a(((t0) nVar).o());
            }
            throw new IllegalArgumentException(("ClassicTypeSystemContext couldn't handle: " + nVar + ", " + n0.d(nVar.getClass())).toString());
        }
    }

    @Override // h.p2.b0.g.t.n.g1.p
    @k.e.a.d
    h.p2.b0.g.t.n.g1.i a(@k.e.a.d h.p2.b0.g.t.n.g1.e eVar);

    @Override // h.p2.b0.g.t.n.g1.p
    @k.e.a.e
    h.p2.b0.g.t.n.g1.i b(@k.e.a.d h.p2.b0.g.t.n.g1.g gVar);

    @Override // h.p2.b0.g.t.n.g1.p
    @k.e.a.d
    h.p2.b0.g.t.n.g1.m c(@k.e.a.d h.p2.b0.g.t.n.g1.i iVar);

    @Override // h.p2.b0.g.t.n.g1.p
    @k.e.a.d
    h.p2.b0.g.t.n.g1.i d(@k.e.a.d h.p2.b0.g.t.n.g1.i iVar, boolean z);

    @Override // h.p2.b0.g.t.n.g1.p
    @k.e.a.d
    h.p2.b0.g.t.n.g1.i e(@k.e.a.d h.p2.b0.g.t.n.g1.e eVar);

    @k.e.a.d
    h.p2.b0.g.t.n.g1.g m(@k.e.a.d h.p2.b0.g.t.n.g1.i iVar, @k.e.a.d h.p2.b0.g.t.n.g1.i iVar2);
}
