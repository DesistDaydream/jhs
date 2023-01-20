package h.p2.b0.g.t.b.k;

import h.k2.v.f0;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.g.h;
import h.t2.t;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes3.dex */
public final class c {
    @k.e.a.d
    public static final c a;
    @k.e.a.d
    private static final String b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f15064c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f15065d;
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final String f15066e;
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final h.p2.b0.g.t.g.b f15067f;
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private static final h.p2.b0.g.t.g.c f15068g;
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private static final h.p2.b0.g.t.g.b f15069h;
    @k.e.a.d

    /* renamed from: i  reason: collision with root package name */
    private static final h.p2.b0.g.t.g.b f15070i;
    @k.e.a.d

    /* renamed from: j  reason: collision with root package name */
    private static final h.p2.b0.g.t.g.b f15071j;
    @k.e.a.d

    /* renamed from: k  reason: collision with root package name */
    private static final HashMap<h.p2.b0.g.t.g.d, h.p2.b0.g.t.g.b> f15072k;
    @k.e.a.d

    /* renamed from: l  reason: collision with root package name */
    private static final HashMap<h.p2.b0.g.t.g.d, h.p2.b0.g.t.g.b> f15073l;
    @k.e.a.d

    /* renamed from: m  reason: collision with root package name */
    private static final HashMap<h.p2.b0.g.t.g.d, h.p2.b0.g.t.g.c> f15074m;
    @k.e.a.d
    private static final HashMap<h.p2.b0.g.t.g.d, h.p2.b0.g.t.g.c> n;
    @k.e.a.d
    private static final List<a> o;

    /* loaded from: classes3.dex */
    public static final class a {
        @k.e.a.d
        private final h.p2.b0.g.t.g.b a;
        @k.e.a.d
        private final h.p2.b0.g.t.g.b b;
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        private final h.p2.b0.g.t.g.b f15075c;

        public a(@k.e.a.d h.p2.b0.g.t.g.b bVar, @k.e.a.d h.p2.b0.g.t.g.b bVar2, @k.e.a.d h.p2.b0.g.t.g.b bVar3) {
            this.a = bVar;
            this.b = bVar2;
            this.f15075c = bVar3;
        }

        @k.e.a.d
        public final h.p2.b0.g.t.g.b a() {
            return this.a;
        }

        @k.e.a.d
        public final h.p2.b0.g.t.g.b b() {
            return this.b;
        }

        @k.e.a.d
        public final h.p2.b0.g.t.g.b c() {
            return this.f15075c;
        }

        @k.e.a.d
        public final h.p2.b0.g.t.g.b d() {
            return this.a;
        }

        public boolean equals(@k.e.a.e Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return f0.g(this.a, aVar.a) && f0.g(this.b, aVar.b) && f0.g(this.f15075c, aVar.f15075c);
            }
            return false;
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.f15075c.hashCode();
        }

        @k.e.a.d
        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.a + ", kotlinReadOnly=" + this.b + ", kotlinMutable=" + this.f15075c + ')';
        }
    }

    static {
        c cVar = new c();
        a = cVar;
        StringBuilder sb = new StringBuilder();
        FunctionClassKind functionClassKind = FunctionClassKind.Function;
        sb.append(functionClassKind.getPackageFqName().toString());
        sb.append('.');
        sb.append(functionClassKind.getClassNamePrefix());
        b = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        FunctionClassKind functionClassKind2 = FunctionClassKind.KFunction;
        sb2.append(functionClassKind2.getPackageFqName().toString());
        sb2.append('.');
        sb2.append(functionClassKind2.getClassNamePrefix());
        f15064c = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        FunctionClassKind functionClassKind3 = FunctionClassKind.SuspendFunction;
        sb3.append(functionClassKind3.getPackageFqName().toString());
        sb3.append('.');
        sb3.append(functionClassKind3.getClassNamePrefix());
        f15065d = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        FunctionClassKind functionClassKind4 = FunctionClassKind.KSuspendFunction;
        sb4.append(functionClassKind4.getPackageFqName().toString());
        sb4.append('.');
        sb4.append(functionClassKind4.getClassNamePrefix());
        f15066e = sb4.toString();
        h.p2.b0.g.t.g.b m2 = h.p2.b0.g.t.g.b.m(new h.p2.b0.g.t.g.c("kotlin.jvm.functions.FunctionN"));
        f15067f = m2;
        f15068g = m2.b();
        f15069h = h.p2.b0.g.t.g.b.m(new h.p2.b0.g.t.g.c("kotlin.reflect.KFunction"));
        f15070i = h.p2.b0.g.t.g.b.m(new h.p2.b0.g.t.g.c("kotlin.reflect.KClass"));
        f15071j = cVar.h(Class.class);
        f15072k = new HashMap<>();
        f15073l = new HashMap<>();
        f15074m = new HashMap<>();
        n = new HashMap<>();
        h.p2.b0.g.t.g.b m3 = h.p2.b0.g.t.g.b.m(g.a.O);
        int i2 = 0;
        h.p2.b0.g.t.g.b bVar = new h.p2.b0.g.t.g.b(m3.h(), h.p2.b0.g.t.g.e.d(g.a.W, m3.h()), false);
        h.p2.b0.g.t.g.b m4 = h.p2.b0.g.t.g.b.m(g.a.N);
        h.p2.b0.g.t.g.b bVar2 = new h.p2.b0.g.t.g.b(m4.h(), h.p2.b0.g.t.g.e.d(g.a.V, m4.h()), false);
        h.p2.b0.g.t.g.b m5 = h.p2.b0.g.t.g.b.m(g.a.P);
        h.p2.b0.g.t.g.b bVar3 = new h.p2.b0.g.t.g.b(m5.h(), h.p2.b0.g.t.g.e.d(g.a.X, m5.h()), false);
        h.p2.b0.g.t.g.b m6 = h.p2.b0.g.t.g.b.m(g.a.Q);
        h.p2.b0.g.t.g.b bVar4 = new h.p2.b0.g.t.g.b(m6.h(), h.p2.b0.g.t.g.e.d(g.a.Y, m6.h()), false);
        h.p2.b0.g.t.g.b m7 = h.p2.b0.g.t.g.b.m(g.a.S);
        h.p2.b0.g.t.g.b bVar5 = new h.p2.b0.g.t.g.b(m7.h(), h.p2.b0.g.t.g.e.d(g.a.a0, m7.h()), false);
        h.p2.b0.g.t.g.b m8 = h.p2.b0.g.t.g.b.m(g.a.R);
        h.p2.b0.g.t.g.b bVar6 = new h.p2.b0.g.t.g.b(m8.h(), h.p2.b0.g.t.g.e.d(g.a.Z, m8.h()), false);
        h.p2.b0.g.t.g.c cVar2 = g.a.T;
        h.p2.b0.g.t.g.b m9 = h.p2.b0.g.t.g.b.m(cVar2);
        h.p2.b0.g.t.g.b bVar7 = new h.p2.b0.g.t.g.b(m9.h(), h.p2.b0.g.t.g.e.d(g.a.b0, m9.h()), false);
        h.p2.b0.g.t.g.b d2 = h.p2.b0.g.t.g.b.m(cVar2).d(g.a.U.g());
        List<a> L = CollectionsKt__CollectionsKt.L(new a(cVar.h(Iterable.class), m3, bVar), new a(cVar.h(Iterator.class), m4, bVar2), new a(cVar.h(Collection.class), m5, bVar3), new a(cVar.h(List.class), m6, bVar4), new a(cVar.h(Set.class), m7, bVar5), new a(cVar.h(ListIterator.class), m8, bVar6), new a(cVar.h(Map.class), m9, bVar7), new a(cVar.h(Map.Entry.class), d2, new h.p2.b0.g.t.g.b(d2.h(), h.p2.b0.g.t.g.e.d(g.a.c0, d2.h()), false)));
        o = L;
        cVar.g(Object.class, g.a.b);
        cVar.g(String.class, g.a.f15041h);
        cVar.g(CharSequence.class, g.a.f15040g);
        cVar.f(Throwable.class, g.a.u);
        cVar.g(Cloneable.class, g.a.f15037d);
        cVar.g(Number.class, g.a.r);
        cVar.f(Comparable.class, g.a.v);
        cVar.g(Enum.class, g.a.s);
        cVar.f(Annotation.class, g.a.E);
        for (a aVar : L) {
            a.e(aVar);
        }
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int length = values.length;
        int i3 = 0;
        while (i3 < length) {
            JvmPrimitiveType jvmPrimitiveType = values[i3];
            i3++;
            c cVar3 = a;
            h.p2.b0.g.t.g.b m10 = h.p2.b0.g.t.g.b.m(jvmPrimitiveType.getWrapperFqName());
            h.p2.b0.g.t.b.g gVar = h.p2.b0.g.t.b.g.a;
            cVar3.b(m10, h.p2.b0.g.t.g.b.m(h.p2.b0.g.t.b.g.c(jvmPrimitiveType.getPrimitiveType())));
        }
        for (h.p2.b0.g.t.g.b bVar8 : CompanionObjectMapping.a.a()) {
            a.b(h.p2.b0.g.t.g.b.m(new h.p2.b0.g.t.g.c("kotlin.jvm.internal." + bVar8.j().b() + "CompanionObject")), bVar8.d(h.f15419c));
        }
        int i4 = 0;
        while (true) {
            int i5 = i4 + 1;
            c cVar4 = a;
            h.p2.b0.g.t.g.b m11 = h.p2.b0.g.t.g.b.m(new h.p2.b0.g.t.g.c(f0.C("kotlin.jvm.functions.Function", Integer.valueOf(i4))));
            h.p2.b0.g.t.b.g gVar2 = h.p2.b0.g.t.b.g.a;
            cVar4.b(m11, h.p2.b0.g.t.b.g.a(i4));
            cVar4.d(new h.p2.b0.g.t.g.c(f0.C(f15064c, Integer.valueOf(i4))), f15069h);
            if (i5 >= 23) {
                break;
            }
            i4 = i5;
        }
        while (true) {
            int i6 = i2 + 1;
            FunctionClassKind functionClassKind5 = FunctionClassKind.KSuspendFunction;
            c cVar5 = a;
            cVar5.d(new h.p2.b0.g.t.g.c(f0.C(functionClassKind5.getPackageFqName().toString() + '.' + functionClassKind5.getClassNamePrefix(), Integer.valueOf(i2))), f15069h);
            if (i6 >= 22) {
                cVar5.d(g.a.f15036c.l(), cVar5.h(Void.class));
                return;
            }
            i2 = i6;
        }
    }

    private c() {
    }

    private final void b(h.p2.b0.g.t.g.b bVar, h.p2.b0.g.t.g.b bVar2) {
        c(bVar, bVar2);
        d(bVar2.b(), bVar);
    }

    private final void c(h.p2.b0.g.t.g.b bVar, h.p2.b0.g.t.g.b bVar2) {
        f15072k.put(bVar.b().j(), bVar2);
    }

    private final void d(h.p2.b0.g.t.g.c cVar, h.p2.b0.g.t.g.b bVar) {
        f15073l.put(cVar.j(), bVar);
    }

    private final void e(a aVar) {
        h.p2.b0.g.t.g.b a2 = aVar.a();
        h.p2.b0.g.t.g.b b2 = aVar.b();
        h.p2.b0.g.t.g.b c2 = aVar.c();
        b(a2, b2);
        d(c2.b(), a2);
        h.p2.b0.g.t.g.c b3 = b2.b();
        h.p2.b0.g.t.g.c b4 = c2.b();
        f15074m.put(c2.b().j(), b3);
        n.put(b3.j(), b4);
    }

    private final void f(Class<?> cls, h.p2.b0.g.t.g.c cVar) {
        b(h(cls), h.p2.b0.g.t.g.b.m(cVar));
    }

    private final void g(Class<?> cls, h.p2.b0.g.t.g.d dVar) {
        f(cls, dVar.l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h.p2.b0.g.t.g.b h(Class<?> cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            return h.p2.b0.g.t.g.b.m(new h.p2.b0.g.t.g.c(cls.getCanonicalName()));
        }
        return h(declaringClass).d(h.p2.b0.g.t.g.f.f(cls.getSimpleName()));
    }

    private final boolean k(h.p2.b0.g.t.g.d dVar, String str) {
        Integer X0;
        String k5 = StringsKt__StringsKt.k5(dVar.b(), str, "");
        return (k5.length() > 0) && !StringsKt__StringsKt.a5(k5, '0', false, 2, null) && (X0 = t.X0(k5)) != null && X0.intValue() >= 23;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.g.c i() {
        return f15068g;
    }

    @k.e.a.d
    public final List<a> j() {
        return o;
    }

    public final boolean l(@k.e.a.e h.p2.b0.g.t.g.d dVar) {
        HashMap<h.p2.b0.g.t.g.d, h.p2.b0.g.t.g.c> hashMap = f15074m;
        Objects.requireNonNull(hashMap, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return hashMap.containsKey(dVar);
    }

    public final boolean m(@k.e.a.e h.p2.b0.g.t.g.d dVar) {
        HashMap<h.p2.b0.g.t.g.d, h.p2.b0.g.t.g.c> hashMap = n;
        Objects.requireNonNull(hashMap, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return hashMap.containsKey(dVar);
    }

    @k.e.a.e
    public final h.p2.b0.g.t.g.b n(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
        return f15072k.get(cVar.j());
    }

    @k.e.a.e
    public final h.p2.b0.g.t.g.b o(@k.e.a.d h.p2.b0.g.t.g.d dVar) {
        if (!k(dVar, b) && !k(dVar, f15065d)) {
            if (!k(dVar, f15064c) && !k(dVar, f15066e)) {
                return f15073l.get(dVar);
            }
            return f15069h;
        }
        return f15067f;
    }

    @k.e.a.e
    public final h.p2.b0.g.t.g.c p(@k.e.a.e h.p2.b0.g.t.g.d dVar) {
        return f15074m.get(dVar);
    }

    @k.e.a.e
    public final h.p2.b0.g.t.g.c q(@k.e.a.e h.p2.b0.g.t.g.d dVar) {
        return n.get(dVar);
    }
}
