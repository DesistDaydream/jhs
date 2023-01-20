package kotlin.reflect;

import h.a2.u;
import h.k2.a;
import h.k2.v.g0;
import h.o;
import h.p2.d;
import h.p2.g;
import h.p2.r;
import h.p2.s;
import h.p2.t;
import h.p2.x;
import h.p2.y;
import h.p2.z;
import h.q2.m;
import h.s0;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import okhttp3.HttpUrl;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH\u0003\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\u0003\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00078BX\u0083\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\b\u001a\u0004\b\u0005\u0010\t¨\u0006\u0015"}, d2 = {"javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", "", "typeToString", "", "type", "computeJavaType", "forceWrapper", "", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class TypesJVMKt {
    /* JADX INFO: Access modifiers changed from: private */
    @o
    public static final Type c(r rVar, boolean z) {
        int i2;
        g a = rVar.a();
        if (a instanceof s) {
            return new x((s) a);
        }
        if (a instanceof d) {
            d dVar = (d) a;
            Class e2 = z ? a.e(dVar) : a.c(dVar);
            List<t> u = rVar.u();
            if (u.isEmpty()) {
                return e2;
            }
            if (e2.isArray()) {
                if (e2.getComponentType().isPrimitive()) {
                    return e2;
                }
                t tVar = (t) CollectionsKt___CollectionsKt.X4(u);
                if (tVar != null) {
                    KVariance a2 = tVar.a();
                    r b = tVar.b();
                    if (a2 == null || (i2 = y.a[a2.ordinal()]) == 1) {
                        return e2;
                    }
                    if (i2 != 2 && i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Type d2 = d(b, false, 1, null);
                    return d2 instanceof Class ? e2 : new h.p2.a(d2);
                }
                throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + rVar);
            }
            return e(e2, u);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + rVar);
    }

    public static /* synthetic */ Type d(r rVar, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return c(rVar, z);
    }

    @o
    private static final Type e(Class<?> cls, List<t> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass != null) {
            if (Modifier.isStatic(cls.getModifiers())) {
                ArrayList arrayList = new ArrayList(u.Y(list, 10));
                for (t tVar : list) {
                    arrayList.add(g(tVar));
                }
                return new ParameterizedTypeImpl(cls, declaringClass, arrayList);
            }
            int length = cls.getTypeParameters().length;
            Type e2 = e(declaringClass, list.subList(length, list.size()));
            List<t> subList = list.subList(0, length);
            ArrayList arrayList2 = new ArrayList(u.Y(subList, 10));
            for (t tVar2 : subList) {
                arrayList2.add(g(tVar2));
            }
            return new ParameterizedTypeImpl(cls, e2, arrayList2);
        }
        ArrayList arrayList3 = new ArrayList(u.Y(list, 10));
        for (t tVar3 : list) {
            arrayList3.add(g(tVar3));
        }
        return new ParameterizedTypeImpl(cls, null, arrayList3);
    }

    @k.e.a.d
    public static final Type f(@k.e.a.d r rVar) {
        Type c2;
        return (!(rVar instanceof g0) || (c2 = ((g0) rVar).c()) == null) ? d(rVar, false, 1, null) : c2;
    }

    private static final Type g(t tVar) {
        KVariance g2 = tVar.g();
        if (g2 != null) {
            r type = tVar.getType();
            int i2 = y.b[g2.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        return new z(c(type, true), null);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return new z(null, c(type, true));
            }
            return c(type, true);
        }
        return z.f15643d.a();
    }

    @h.g2.g
    @o
    @s0(version = "1.4")
    public static /* synthetic */ void h(r rVar) {
    }

    @o
    private static /* synthetic */ void i(t tVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String j(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                m o = SequencesKt__SequencesKt.o(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
                return ((Class) SequencesKt___SequencesKt.Y0(o)).getName() + h.t2.u.g2(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, SequencesKt___SequencesKt.Z(o));
            }
            return cls.getName();
        }
        return type.toString();
    }
}
