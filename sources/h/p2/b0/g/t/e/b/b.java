package h.p2.b0.g.t.e.b;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import h.k2.v.f0;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.k0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.y0;
import h.p2.b0.g.t.n.z;
import h.t1;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* loaded from: classes3.dex */
public final class b {
    @k.e.a.d
    public static final String a(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d t<?> tVar) {
        String b = tVar.b(dVar);
        if (b == null) {
            h.p2.b0.g.t.c.k b2 = dVar.b();
            String identifier = h.p2.b0.g.t.g.h.c(dVar.getName()).getIdentifier();
            if (b2 instanceof b0) {
                h.p2.b0.g.t.g.c e2 = ((b0) b2).e();
                if (e2.d()) {
                    return identifier;
                }
                return h.t2.u.j2(e2.b(), '.', Attributes.InternalPrefix, false, 4, null) + Attributes.InternalPrefix + identifier;
            }
            h.p2.b0.g.t.c.d dVar2 = b2 instanceof h.p2.b0.g.t.c.d ? (h.p2.b0.g.t.c.d) b2 : null;
            if (dVar2 != null) {
                String c2 = tVar.c(dVar2);
                if (c2 == null) {
                    c2 = a(dVar2, tVar);
                }
                return c2 + '$' + identifier;
            }
            throw new IllegalArgumentException("Unexpected container: " + b2 + " for " + dVar);
        }
        return b;
    }

    public static /* synthetic */ String b(h.p2.b0.g.t.c.d dVar, t tVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            tVar = u.a;
        }
        return a(dVar, tVar);
    }

    public static final boolean c(@k.e.a.d h.p2.b0.g.t.c.a aVar) {
        if (aVar instanceof h.p2.b0.g.t.c.j) {
            return true;
        }
        return (!h.p2.b0.g.t.b.f.z0(aVar.getReturnType()) || y0.l(aVar.getReturnType()) || (aVar instanceof k0)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [T, java.lang.Object] */
    @k.e.a.d
    public static final <T> T d(@k.e.a.d z zVar, @k.e.a.d i<T> iVar, @k.e.a.d v vVar, @k.e.a.d t<? extends T> tVar, @k.e.a.e f<T> fVar, @k.e.a.d h.k2.u.q<? super z, ? super T, ? super v, t1> qVar) {
        Object obj;
        z zVar2;
        Object d2;
        z d3 = tVar.d(zVar);
        if (d3 == null) {
            if (h.p2.b0.g.t.b.e.o(zVar)) {
                return (T) d(h.p2.b0.g.t.b.h.b(zVar, tVar.e()), iVar, vVar, tVar, fVar, qVar);
            }
            h.p2.b0.g.t.n.e1.q qVar2 = h.p2.b0.g.t.n.e1.q.a;
            Object b = w.b(qVar2, zVar, iVar, vVar);
            if (b == null) {
                q0 I0 = zVar.I0();
                if (I0 instanceof IntersectionTypeConstructor) {
                    IntersectionTypeConstructor intersectionTypeConstructor = (IntersectionTypeConstructor) I0;
                    z g2 = intersectionTypeConstructor.g();
                    if (g2 == null) {
                        g2 = tVar.g(intersectionTypeConstructor.j());
                    }
                    return (T) d(TypeUtilsKt.s(g2), iVar, vVar, tVar, fVar, qVar);
                }
                h.p2.b0.g.t.c.f c2 = I0.c();
                if (c2 != null) {
                    if (h.p2.b0.g.t.n.s.r(c2)) {
                        T t = (T) iVar.e("error/NonExistentClass");
                        tVar.f(zVar, (h.p2.b0.g.t.c.d) c2);
                        if (fVar != 0) {
                            fVar.c(t);
                        }
                        return t;
                    }
                    boolean z = c2 instanceof h.p2.b0.g.t.c.d;
                    if (z && h.p2.b0.g.t.b.f.b0(zVar)) {
                        if (zVar.H0().size() == 1) {
                            s0 s0Var = zVar.H0().get(0);
                            z type = s0Var.getType();
                            if (s0Var.c() == Variance.IN_VARIANCE) {
                                d2 = iVar.e("java/lang/Object");
                                if (fVar != 0) {
                                    fVar.b();
                                    fVar.c(d2);
                                    fVar.a();
                                }
                            } else {
                                if (fVar != 0) {
                                    fVar.b();
                                }
                                d2 = d(type, iVar, vVar.f(s0Var.c(), true), tVar, fVar, qVar);
                                if (fVar != 0) {
                                    fVar.a();
                                }
                            }
                            return (T) iVar.a(f0.C("[", iVar.d(d2)));
                        }
                        throw new UnsupportedOperationException("arrays must have one type argument");
                    } else if (z) {
                        if (h.p2.b0.g.t.k.d.b(c2) && !vVar.c() && (zVar2 = (z) h.p2.b0.g.t.n.t.a(qVar2, zVar)) != null) {
                            return (T) d(zVar2, iVar, vVar.g(), tVar, fVar, qVar);
                        }
                        if (vVar.e() && h.p2.b0.g.t.b.f.i0((h.p2.b0.g.t.c.d) c2)) {
                            obj = (Object) iVar.f();
                        } else {
                            h.p2.b0.g.t.c.d dVar = (h.p2.b0.g.t.c.d) c2;
                            T a = tVar.a(dVar.a());
                            if (a == null) {
                                if (dVar.i() == ClassKind.ENUM_ENTRY) {
                                    dVar = (h.p2.b0.g.t.c.d) dVar.b();
                                }
                                obj = (Object) iVar.e(a(dVar.a(), tVar));
                            } else {
                                obj = (Object) a;
                            }
                        }
                        qVar.invoke(zVar, obj, vVar);
                        return (T) obj;
                    } else if (c2 instanceof t0) {
                        T t2 = (T) d(TypeUtilsKt.i((t0) c2), iVar, vVar, tVar, null, FunctionsKt.b());
                        if (fVar != 0) {
                            fVar.e(c2.getName(), t2);
                        }
                        return t2;
                    } else if ((c2 instanceof h.p2.b0.g.t.c.s0) && vVar.b()) {
                        return (T) d(((h.p2.b0.g.t.c.s0) c2).H(), iVar, vVar, tVar, fVar, qVar);
                    } else {
                        throw new UnsupportedOperationException(f0.C("Unknown type ", zVar));
                    }
                }
                throw new UnsupportedOperationException(f0.C("no descriptor for type constructor of ", zVar));
            }
            ?? r9 = (Object) w.a(iVar, b, vVar.d());
            qVar.invoke(zVar, r9, vVar);
            return r9;
        }
        return (T) d(d3, iVar, vVar, tVar, fVar, qVar);
    }

    public static /* synthetic */ Object e(z zVar, i iVar, v vVar, t tVar, f fVar, h.k2.u.q qVar, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            qVar = FunctionsKt.b();
        }
        return d(zVar, iVar, vVar, tVar, fVar, qVar);
    }
}
