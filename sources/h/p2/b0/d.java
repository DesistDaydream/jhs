package h.p2.b0;

import h.k2.g;
import h.k2.v.n0;
import h.p2.r;
import h.p2.s;
import h.s0;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;

@g(name = "KTypesJvm")
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001c\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\"\u0010\u0000\u001a\u0006\u0012\u0002\b\u00030\u0001*\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0003\u0010\b¨\u0006\t"}, d2 = {"jvmErasure", "Lkotlin/reflect/KClass;", "Lkotlin/reflect/KClassifier;", "getJvmErasure", "(Lkotlin/reflect/KClassifier;)Lkotlin/reflect/KClass;", "Lkotlin/reflect/KType;", "getJvmErasure$annotations", "(Lkotlin/reflect/KType;)V", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KClass;", "kotlin-reflection"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class d {
    @k.e.a.d
    public static final h.p2.d<?> a(@k.e.a.d h.p2.g gVar) {
        Object obj;
        h.p2.d<?> b;
        boolean z;
        if (gVar instanceof h.p2.d) {
            return (h.p2.d) gVar;
        }
        if (gVar instanceof s) {
            List<r> upperBounds = ((s) gVar).getUpperBounds();
            Iterator<T> it = upperBounds.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                r rVar = (r) next;
                Objects.requireNonNull(rVar, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                Object c2 = ((KTypeImpl) rVar).getType().I0().c();
                h.p2.b0.g.t.c.d dVar = (h.p2.b0.g.t.c.d) (c2 instanceof h.p2.b0.g.t.c.d ? c2 : null);
                if (dVar == null || dVar.i() == ClassKind.INTERFACE || dVar.i() == ClassKind.ANNOTATION_CLASS) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    obj = next;
                    break;
                }
            }
            r rVar2 = (r) obj;
            if (rVar2 == null) {
                rVar2 = (r) CollectionsKt___CollectionsKt.t2(upperBounds);
            }
            return (rVar2 == null || (b = b(rVar2)) == null) ? n0.d(Object.class) : b;
        }
        throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + gVar);
    }

    @k.e.a.d
    public static final h.p2.d<?> b(@k.e.a.d r rVar) {
        h.p2.d<?> a;
        h.p2.g a2 = rVar.a();
        if (a2 == null || (a = a(a2)) == null) {
            throw new KotlinReflectionInternalError("Cannot calculate JVM erasure for type: " + rVar);
        }
        return a;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void c(r rVar) {
    }
}
