package h.p2.a0;

import h.a2.u;
import h.k2.g;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.u0;
import h.p2.b0.g.t.n.z;
import h.p2.r;
import h.p2.t;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;

@g(name = "KClassifiers")
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\u001a.\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a6\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000eH\u0007\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"starProjectedType", "Lkotlin/reflect/KType;", "Lkotlin/reflect/KClassifier;", "getStarProjectedType$annotations", "(Lkotlin/reflect/KClassifier;)V", "getStarProjectedType", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KType;", "createKotlinType", "Lkotlin/reflect/jvm/internal/impl/types/SimpleType;", "typeAnnotations", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotations;", "typeConstructor", "Lkotlin/reflect/jvm/internal/impl/types/TypeConstructor;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "nullable", "", "createType", "annotations", "", "kotlin-reflection"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class c {
    private static final f0 a(h.p2.b0.g.t.c.b1.e eVar, q0 q0Var, List<t> list, boolean z) {
        s0 u0Var;
        List<t0> parameters = q0Var.getParameters();
        ArrayList arrayList = new ArrayList(u.Y(list, 10));
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            t tVar = (t) obj;
            KTypeImpl kTypeImpl = (KTypeImpl) tVar.getType();
            z type = kTypeImpl != null ? kTypeImpl.getType() : null;
            KVariance g2 = tVar.g();
            if (g2 == null) {
                u0Var = new StarProjectionImpl(parameters.get(i2));
            } else {
                int i4 = b.a[g2.ordinal()];
                if (i4 == 1) {
                    u0Var = new u0(Variance.INVARIANT, type);
                } else if (i4 == 2) {
                    u0Var = new u0(Variance.IN_VARIANCE, type);
                } else if (i4 == 3) {
                    u0Var = new u0(Variance.OUT_VARIANCE, type);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            arrayList.add(u0Var);
            i2 = i3;
        }
        return KotlinTypeFactory.i(eVar, q0Var, arrayList, z, null, 16, null);
    }

    @h.s0(version = "1.1")
    @k.e.a.d
    public static final r b(@k.e.a.d h.p2.g gVar, @k.e.a.d List<t> list, boolean z, @k.e.a.d List<? extends Annotation> list2) {
        f e2;
        h.p2.b0.g.g gVar2 = (h.p2.b0.g.g) (!(gVar instanceof h.p2.b0.g.g) ? null : gVar);
        if (gVar2 != null && (e2 = gVar2.e()) != null) {
            q0 j2 = e2.j();
            List<t0> parameters = j2.getParameters();
            if (parameters.size() == list.size()) {
                return new KTypeImpl(a(list2.isEmpty() ? h.p2.b0.g.t.c.b1.e.w0.b() : h.p2.b0.g.t.c.b1.e.w0.b(), j2, list, z), null, 2, null);
            }
            throw new IllegalArgumentException("Class declares " + parameters.size() + " type parameters, but " + list.size() + " were provided.");
        }
        throw new KotlinReflectionInternalError("Cannot create type for an unsupported classifier: " + gVar + " (" + gVar.getClass() + ')');
    }

    public static /* synthetic */ r c(h.p2.g gVar, List list, boolean z, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = CollectionsKt__CollectionsKt.E();
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            list2 = CollectionsKt__CollectionsKt.E();
        }
        return b(gVar, list, z, list2);
    }

    @k.e.a.d
    public static final r d(@k.e.a.d h.p2.g gVar) {
        f e2;
        h.p2.b0.g.g gVar2 = (h.p2.b0.g.g) (!(gVar instanceof h.p2.b0.g.g) ? null : gVar);
        if (gVar2 != null && (e2 = gVar2.e()) != null) {
            List<t0> parameters = e2.j().getParameters();
            if (parameters.isEmpty()) {
                return c(gVar, null, false, null, 7, null);
            }
            ArrayList arrayList = new ArrayList(u.Y(parameters, 10));
            for (t0 t0Var : parameters) {
                arrayList.add(t.f15641d.c());
            }
            return c(gVar, arrayList, false, null, 6, null);
        }
        return c(gVar, null, false, null, 7, null);
    }

    @h.s0(version = "1.1")
    public static /* synthetic */ void e(h.p2.g gVar) {
    }
}
