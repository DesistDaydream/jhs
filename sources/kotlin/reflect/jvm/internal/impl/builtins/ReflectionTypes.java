package kotlin.reflect.jvm.internal.impl.builtins;

import h.a2.t;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.n.z;
import h.p2.n;
import h.w;
import k.e.a.d;
import k.e.a.e;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;

/* loaded from: classes3.dex */
public final class ReflectionTypes {
    @d

    /* renamed from: k  reason: collision with root package name */
    public static final b f16411k;

    /* renamed from: l  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f16412l;
    @d
    private final NotFoundClasses a;
    @d
    private final w b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final a f16413c = new a(1);
    @d

    /* renamed from: d  reason: collision with root package name */
    private final a f16414d = new a(1);
    @d

    /* renamed from: e  reason: collision with root package name */
    private final a f16415e = new a(1);
    @d

    /* renamed from: f  reason: collision with root package name */
    private final a f16416f = new a(2);
    @d

    /* renamed from: g  reason: collision with root package name */
    private final a f16417g = new a(3);
    @d

    /* renamed from: h  reason: collision with root package name */
    private final a f16418h = new a(1);
    @d

    /* renamed from: i  reason: collision with root package name */
    private final a f16419i = new a(2);
    @d

    /* renamed from: j  reason: collision with root package name */
    private final a f16420j = new a(3);

    /* loaded from: classes3.dex */
    public static final class a {
        private final int a;

        public a(int i2) {
            this.a = i2;
        }

        @d
        public final h.p2.b0.g.t.c.d a(@d ReflectionTypes reflectionTypes, @d n<?> nVar) {
            return reflectionTypes.b(h.p2.b0.g.t.o.j.a.a(nVar.getName()), this.a);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @e
        public final z a(@d h.p2.b0.g.t.c.z zVar) {
            h.p2.b0.g.t.c.d a = FindClassInModuleKt.a(zVar, g.a.n0);
            if (a == null) {
                return null;
            }
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            return KotlinTypeFactory.g(h.p2.b0.g.t.c.b1.e.w0.b(), a, t.k(new StarProjectionImpl((t0) CollectionsKt___CollectionsKt.U4(a.j().getParameters()))));
        }
    }

    static {
        n<Object>[] nVarArr = new n[9];
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(ReflectionTypes.class), "kClass", "getKClass()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(ReflectionTypes.class), "kProperty", "getKProperty()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        nVarArr[3] = n0.r(new PropertyReference1Impl(n0.d(ReflectionTypes.class), "kProperty0", "getKProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        nVarArr[4] = n0.r(new PropertyReference1Impl(n0.d(ReflectionTypes.class), "kProperty1", "getKProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        nVarArr[5] = n0.r(new PropertyReference1Impl(n0.d(ReflectionTypes.class), "kProperty2", "getKProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        nVarArr[6] = n0.r(new PropertyReference1Impl(n0.d(ReflectionTypes.class), "kMutableProperty0", "getKMutableProperty0()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        nVarArr[7] = n0.r(new PropertyReference1Impl(n0.d(ReflectionTypes.class), "kMutableProperty1", "getKMutableProperty1()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        nVarArr[8] = n0.r(new PropertyReference1Impl(n0.d(ReflectionTypes.class), "kMutableProperty2", "getKMutableProperty2()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;"));
        f16412l = nVarArr;
        f16411k = new b(null);
    }

    public ReflectionTypes(@d h.p2.b0.g.t.c.z zVar, @d NotFoundClasses notFoundClasses) {
        this.a = notFoundClasses;
        this.b = h.z.b(LazyThreadSafetyMode.PUBLICATION, new ReflectionTypes$kotlinReflectScope$2(zVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h.p2.b0.g.t.c.d b(String str, int i2) {
        f f2 = f.f(str);
        h.p2.b0.g.t.c.f f3 = d().f(f2, NoLookupLocation.FROM_REFLECTION);
        h.p2.b0.g.t.c.d dVar = f3 instanceof h.p2.b0.g.t.c.d ? (h.p2.b0.g.t.c.d) f3 : null;
        return dVar == null ? this.a.d(new h.p2.b0.g.t.g.b(g.f15033k, f2), t.k(Integer.valueOf(i2))) : dVar;
    }

    private final MemberScope d() {
        return (MemberScope) this.b.getValue();
    }

    @d
    public final h.p2.b0.g.t.c.d c() {
        return this.f16413c.a(this, f16412l[1]);
    }
}
