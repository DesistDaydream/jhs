package kotlin.reflect.full;

import androidx.exifinterface.media.ExifInterface;
import h.a2.t;
import h.a2.t0;
import h.a2.u;
import h.k2.g;
import h.k2.u.l;
import h.k2.v.f0;
import h.p2.b0.g.t.c.j;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.n.z;
import h.p2.b0.g.t.p.b;
import h.p2.i;
import h.p2.o;
import h.p2.p;
import h.p2.q;
import h.p2.r;
import h.s0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

@g(name = "KClasses")
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\r\u001a+\u0010S\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00022\b\u0010T\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010U\u001a!\u0010V\u001a\u0002H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u0002H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001c\u0010W\u001a\u000203*\u0006\u0012\u0002\b\u00030\u00022\n\u0010X\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007\u001a\u001c\u0010Y\u001a\u000203*\u0006\u0012\u0002\b\u00030\u00022\n\u0010Z\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007\u001a-\u0010[\u001a\u0004\u0018\u0001H\u001d\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00022\b\u0010T\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010U\",\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"(\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0002*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e\"$\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0013\",\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\",\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"B\u0010\u001b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\",\u0010 \u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\">\u0010#\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u00030$0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\",\u0010'\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030(0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0004\u001a\u0004\b*\u0010\u0006\"\"\u0010+\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010.\",\u0010/\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u001c\u00102\u001a\u000203*\u0006\u0012\u0002\b\u0003048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00105\"\u001c\u00106\u001a\u000203*\u0006\u0012\u0002\b\u0003048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00105\",\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006\"B\u0010:\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001c0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0004\u001a\u0004\b<\u0010\u0006\",\u0010=\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0004\u001a\u0004\b?\u0010\u0006\">\u0010@\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u0002H\u001d\u0012\u0002\b\u00030$0\u0001\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010\u0004\u001a\u0004\bB\u0010\u0006\"6\u0010C\u001a\n\u0012\u0004\u0012\u0002H\u001d\u0018\u00010\u0015\"\b\b\u0000\u0010\u001d*\u00020\u0010*\b\u0012\u0004\u0012\u0002H\u001d0\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\bD\u0010\u0004\u001a\u0004\bE\u0010F\",\u0010G\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00150\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006\",\u0010J\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030K0\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0006\",\u0010N\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020O*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\bP\u0010\u0004\u001a\u0004\bQ\u0010R¨\u0006\\"}, d2 = {"allSuperclasses", "", "Lkotlin/reflect/KClass;", "getAllSuperclasses$annotations", "(Lkotlin/reflect/KClass;)V", "getAllSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/Collection;", "allSupertypes", "Lkotlin/reflect/KType;", "getAllSupertypes$annotations", "getAllSupertypes", "companionObject", "getCompanionObject$annotations", "getCompanionObject", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KClass;", "companionObjectInstance", "", "getCompanionObjectInstance$annotations", "getCompanionObjectInstance", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "declaredFunctions", "Lkotlin/reflect/KFunction;", "getDeclaredFunctions$annotations", "getDeclaredFunctions", "declaredMemberExtensionFunctions", "getDeclaredMemberExtensionFunctions$annotations", "getDeclaredMemberExtensionFunctions", "declaredMemberExtensionProperties", "Lkotlin/reflect/KProperty2;", ExifInterface.GPS_DIRECTION_TRUE, "getDeclaredMemberExtensionProperties$annotations", "getDeclaredMemberExtensionProperties", "declaredMemberFunctions", "getDeclaredMemberFunctions$annotations", "getDeclaredMemberFunctions", "declaredMemberProperties", "Lkotlin/reflect/KProperty1;", "getDeclaredMemberProperties$annotations", "getDeclaredMemberProperties", "declaredMembers", "Lkotlin/reflect/KCallable;", "getDeclaredMembers$annotations", "getDeclaredMembers", "defaultType", "getDefaultType$annotations", "getDefaultType", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KType;", "functions", "getFunctions$annotations", "getFunctions", "isExtension", "", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "(Lkotlin/reflect/jvm/internal/KCallableImpl;)Z", "isNotExtension", "memberExtensionFunctions", "getMemberExtensionFunctions$annotations", "getMemberExtensionFunctions", "memberExtensionProperties", "getMemberExtensionProperties$annotations", "getMemberExtensionProperties", "memberFunctions", "getMemberFunctions$annotations", "getMemberFunctions", "memberProperties", "getMemberProperties$annotations", "getMemberProperties", "primaryConstructor", "getPrimaryConstructor$annotations", "getPrimaryConstructor", "(Lkotlin/reflect/KClass;)Lkotlin/reflect/KFunction;", "staticFunctions", "getStaticFunctions$annotations", "getStaticFunctions", "staticProperties", "Lkotlin/reflect/KProperty0;", "getStaticProperties$annotations", "getStaticProperties", "superclasses", "", "getSuperclasses$annotations", "getSuperclasses", "(Lkotlin/reflect/KClass;)Ljava/util/List;", "cast", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "createInstance", "isSubclassOf", "base", "isSuperclassOf", "derived", "safeCast", "kotlin-reflection"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KClasses {

    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\u0010\u0000\u001a$\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002 \u0003*\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u00040\u00012\u000e\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/KType;", "kotlin.jvm.PlatformType", "", "current", "getNeighbors"}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class a<N> implements b.d<r> {
        public static final a a = new a();

        @Override // h.p2.b0.g.t.p.b.d
        @d
        /* renamed from: b */
        public final Iterable<r> a(r rVar) {
            h.p2.g a2 = rVar.a();
            if (!(a2 instanceof h.p2.d)) {
                a2 = null;
            }
            h.p2.d dVar = (h.p2.d) a2;
            if (dVar != null) {
                List<r> j2 = dVar.j();
                if (rVar.u().isEmpty()) {
                    return j2;
                }
                Objects.requireNonNull(rVar, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                TypeSubstitutor f2 = TypeSubstitutor.f(((KTypeImpl) rVar).getType());
                ArrayList arrayList = new ArrayList(u.Y(j2, 10));
                for (r rVar2 : j2) {
                    Objects.requireNonNull(rVar2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KTypeImpl");
                    z p = f2.p(((KTypeImpl) rVar2).getType(), Variance.INVARIANT);
                    if (p != null) {
                        arrayList.add(new KTypeImpl(p, null, 2, null));
                    } else {
                        throw new KotlinReflectionInternalError("Type substitution failed: " + rVar2 + " (" + rVar + ')');
                    }
                }
                return arrayList;
            }
            throw new KotlinReflectionInternalError("Supertype not a class: " + rVar);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"kotlin/reflect/full/KClasses$allSupertypes$2", "Lkotlin/reflect/jvm/internal/impl/utils/DFS$NodeHandlerWithListResult;", "Lkotlin/reflect/KType;", "beforeChildren", "", "current", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public static final class b extends b.f<r, r> {
        @Override // h.p2.b0.g.t.p.b.AbstractC0472b, h.p2.b0.g.t.p.b.e
        /* renamed from: f */
        public boolean c(@d r rVar) {
            ((LinkedList) this.a).add(rVar);
            return true;
        }
    }

    @d
    public static final Collection<i<?>> A(@d h.p2.d<?> dVar) {
        Collection<KCallableImpl<?>> h2 = ((KClassImpl.Data) ((KClassImpl) dVar).Y().invoke()).h();
        ArrayList arrayList = new ArrayList();
        for (Object obj : h2) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (Q(kCallableImpl) && (kCallableImpl instanceof i)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void B(h.p2.d dVar) {
    }

    @d
    public static final <T> Collection<q<T, ?, ?>> C(@d h.p2.d<T> dVar) {
        Collection<KCallableImpl<?>> h2 = ((KClassImpl) dVar).Y().invoke().h();
        ArrayList arrayList = new ArrayList();
        for (T t : h2) {
            KCallableImpl kCallableImpl = (KCallableImpl) t;
            if (Q(kCallableImpl) && (kCallableImpl instanceof q)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void D(h.p2.d dVar) {
    }

    @d
    public static final Collection<i<?>> E(@d h.p2.d<?> dVar) {
        Collection<KCallableImpl<?>> h2 = ((KClassImpl.Data) ((KClassImpl) dVar).Y().invoke()).h();
        ArrayList arrayList = new ArrayList();
        for (Object obj : h2) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (R(kCallableImpl) && (kCallableImpl instanceof i)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void F(h.p2.d dVar) {
    }

    @d
    public static final <T> Collection<p<T, ?>> G(@d h.p2.d<T> dVar) {
        Collection<KCallableImpl<?>> h2 = ((KClassImpl) dVar).Y().invoke().h();
        ArrayList arrayList = new ArrayList();
        for (T t : h2) {
            KCallableImpl kCallableImpl = (KCallableImpl) t;
            if (R(kCallableImpl) && (kCallableImpl instanceof p)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void H(h.p2.d dVar) {
    }

    @e
    public static final <T> i<T> I(@d h.p2.d<T> dVar) {
        T t;
        Iterator<T> it = ((KClassImpl) dVar).g().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            i iVar = (i) t;
            Objects.requireNonNull(iVar, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KFunctionImpl");
            v J = ((KFunctionImpl) iVar).J();
            Objects.requireNonNull(J, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ConstructorDescriptor");
            if (((j) J).b0()) {
                break;
            }
        }
        return (i) t;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void J(h.p2.d dVar) {
    }

    @d
    public static final Collection<i<?>> K(@d h.p2.d<?> dVar) {
        Collection<KCallableImpl<?>> i2 = ((KClassImpl.Data) ((KClassImpl) dVar).Y().invoke()).i();
        ArrayList arrayList = new ArrayList();
        for (Object obj : i2) {
            if (obj instanceof i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void L(h.p2.d dVar) {
    }

    @d
    public static final Collection<o<?>> M(@d h.p2.d<?> dVar) {
        Collection<KCallableImpl<?>> i2 = ((KClassImpl.Data) ((KClassImpl) dVar).Y().invoke()).i();
        ArrayList arrayList = new ArrayList();
        for (Object obj : i2) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (R(kCallableImpl) && (kCallableImpl instanceof o)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void N(h.p2.d dVar) {
    }

    @d
    public static final List<h.p2.d<?>> O(@d h.p2.d<?> dVar) {
        List<r> j2 = dVar.j();
        ArrayList arrayList = new ArrayList();
        for (r rVar : j2) {
            h.p2.g a2 = rVar.a();
            if (!(a2 instanceof h.p2.d)) {
                a2 = null;
            }
            h.p2.d dVar2 = (h.p2.d) a2;
            if (dVar2 != null) {
                arrayList.add(dVar2);
            }
        }
        return arrayList;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void P(h.p2.d dVar) {
    }

    private static final boolean Q(KCallableImpl<?> kCallableImpl) {
        return kCallableImpl.J().Q() != null;
    }

    private static final boolean R(KCallableImpl<?> kCallableImpl) {
        return !Q(kCallableImpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.reflect.full.KClasses$c] */
    @s0(version = "1.1")
    public static final boolean S(@d h.p2.d<?> dVar, @d h.p2.d<?> dVar2) {
        if (!f0.g(dVar, dVar2)) {
            List k2 = t.k(dVar);
            final p pVar = KClasses$isSubclassOf$1.INSTANCE;
            if (pVar != null) {
                pVar = new b.d() { // from class: kotlin.reflect.full.KClasses.c
                    @Override // h.p2.b0.g.t.p.b.d
                    @d
                    public final /* synthetic */ Iterable a(Object obj) {
                        return (Iterable) l.this.invoke(obj);
                    }
                };
            }
            if (!h.p2.b0.g.t.p.b.e(k2, (b.d) pVar, new KClasses$isSubclassOf$2(dVar2)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @s0(version = "1.1")
    public static final boolean T(@d h.p2.d<?> dVar, @d h.p2.d<?> dVar2) {
        return S(dVar2, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @e
    @s0(version = "1.1")
    public static final <T> T U(@d h.p2.d<T> dVar, @e Object obj) {
        if (dVar.C(obj)) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type T");
            return obj;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @s0(version = "1.1")
    @d
    public static final <T> T a(@d h.p2.d<T> dVar, @e Object obj) {
        if (dVar.C(obj)) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type T");
            return obj;
        }
        throw new TypeCastException("Value cannot be cast to " + dVar.D());
    }

    @s0(version = "1.1")
    @d
    public static final <T> T b(@d h.p2.d<T> dVar) {
        boolean z;
        Iterator<T> it = dVar.g().iterator();
        i iVar = null;
        i iVar2 = null;
        boolean z2 = false;
        while (true) {
            if (it.hasNext()) {
                T next = it.next();
                List<KParameter> parameters = ((i) next).getParameters();
                if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                    for (KParameter kParameter : parameters) {
                        if (!kParameter.s()) {
                            z = false;
                            break;
                        }
                    }
                }
                z = true;
                if (z) {
                    if (z2) {
                        break;
                    }
                    iVar2 = next;
                    z2 = true;
                }
            } else if (z2) {
                iVar = iVar2;
            }
        }
        i iVar3 = iVar;
        if (iVar3 != null) {
            return (T) iVar3.callBy(t0.z());
        }
        throw new IllegalArgumentException("Class should have a single no-arg constructor: " + dVar);
    }

    @d
    public static final Collection<h.p2.d<?>> c(@d h.p2.d<?> dVar) {
        Collection<r> e2 = e(dVar);
        ArrayList arrayList = new ArrayList(u.Y(e2, 10));
        for (r rVar : e2) {
            h.p2.g a2 = rVar.a();
            if (!(a2 instanceof h.p2.d)) {
                a2 = null;
            }
            h.p2.d dVar2 = (h.p2.d) a2;
            if (dVar2 == null) {
                throw new KotlinReflectionInternalError("Supertype not a class: " + rVar);
            }
            arrayList.add(dVar2);
        }
        return arrayList;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void d(h.p2.d dVar) {
    }

    @d
    public static final Collection<r> e(@d h.p2.d<?> dVar) {
        return (Collection) h.p2.b0.g.t.p.b.c(dVar.j(), a.a, new b.h(), new b());
    }

    @s0(version = "1.1")
    public static /* synthetic */ void f(h.p2.d dVar) {
    }

    @e
    public static final h.p2.d<?> g(@d h.p2.d<?> dVar) {
        Object obj;
        Iterator<T> it = dVar.z().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            h.p2.d dVar2 = (h.p2.d) obj;
            Objects.requireNonNull(dVar2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<*>");
            if (((KClassImpl) dVar2).e().a0()) {
                break;
            }
        }
        return (h.p2.d) obj;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void h(h.p2.d dVar) {
    }

    @e
    public static final Object i(@d h.p2.d<?> dVar) {
        h.p2.d<?> g2 = g(dVar);
        if (g2 != null) {
            return g2.A();
        }
        return null;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void j(h.p2.d dVar) {
    }

    @d
    public static final Collection<i<?>> k(@d h.p2.d<?> dVar) {
        Collection<KCallableImpl<?>> l2 = ((KClassImpl.Data) ((KClassImpl) dVar).Y().invoke()).l();
        ArrayList arrayList = new ArrayList();
        for (Object obj : l2) {
            if (obj instanceof i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void l(h.p2.d dVar) {
    }

    @d
    public static final Collection<i<?>> m(@d h.p2.d<?> dVar) {
        Collection<KCallableImpl<?>> m2 = ((KClassImpl.Data) ((KClassImpl) dVar).Y().invoke()).m();
        ArrayList arrayList = new ArrayList();
        for (Object obj : m2) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (Q(kCallableImpl) && (kCallableImpl instanceof i)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void n(h.p2.d dVar) {
    }

    @d
    public static final <T> Collection<q<T, ?, ?>> o(@d h.p2.d<T> dVar) {
        Collection<KCallableImpl<?>> m2 = ((KClassImpl) dVar).Y().invoke().m();
        ArrayList arrayList = new ArrayList();
        for (T t : m2) {
            KCallableImpl kCallableImpl = (KCallableImpl) t;
            if (Q(kCallableImpl) && (kCallableImpl instanceof q)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void p(h.p2.d dVar) {
    }

    @d
    public static final Collection<i<?>> q(@d h.p2.d<?> dVar) {
        Collection<KCallableImpl<?>> m2 = ((KClassImpl.Data) ((KClassImpl) dVar).Y().invoke()).m();
        ArrayList arrayList = new ArrayList();
        for (Object obj : m2) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (R(kCallableImpl) && (kCallableImpl instanceof i)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void r(h.p2.d dVar) {
    }

    @d
    public static final <T> Collection<p<T, ?>> s(@d h.p2.d<T> dVar) {
        Collection<KCallableImpl<?>> m2 = ((KClassImpl) dVar).Y().invoke().m();
        ArrayList arrayList = new ArrayList();
        for (T t : m2) {
            KCallableImpl kCallableImpl = (KCallableImpl) t;
            if (R(kCallableImpl) && (kCallableImpl instanceof p)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void t(h.p2.d dVar) {
    }

    @d
    public static final Collection<h.p2.c<?>> u(@d h.p2.d<?> dVar) {
        return ((KClassImpl.Data) ((KClassImpl) dVar).Y().invoke()).l();
    }

    @s0(version = "1.1")
    public static /* synthetic */ void v(h.p2.d dVar) {
    }

    @d
    public static final r w(@d h.p2.d<?> dVar) {
        return new KTypeImpl(((KClassImpl) dVar).e().r(), new KClasses$defaultType$1(dVar));
    }

    @h.i(message = "This function creates a type which rarely makes sense for generic classes. For example, such type can only be used in signatures of members of that class. Use starProjectedType or createType() for clearer semantics.")
    @s0(version = "1.1")
    public static /* synthetic */ void x(h.p2.d dVar) {
    }

    @d
    public static final Collection<i<?>> y(@d h.p2.d<?> dVar) {
        Collection<h.p2.c<?>> q = dVar.q();
        ArrayList arrayList = new ArrayList();
        for (Object obj : q) {
            if (obj instanceof i) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void z(h.p2.d dVar) {
    }
}
