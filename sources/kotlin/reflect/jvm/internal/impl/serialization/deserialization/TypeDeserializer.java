package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import h.a2.u;
import h.k2.u.l;
import h.p2.b0.g.t.b.h;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.g.b;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.l.b.i;
import h.p2.b0.g.t.l.b.q;
import h.p2.b0.g.t.l.b.t;
import h.p2.b0.g.t.l.b.v;
import h.p2.b0.g.t.n.a0;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.i0;
import h.p2.b0.g.t.n.j;
import h.p2.b0.g.t.n.j0;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.s;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.u0;
import h.p2.b0.g.t.n.z;
import h.t2.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes3.dex */
public final class TypeDeserializer {
    @d
    private final i a;
    @e
    private final TypeDeserializer b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final String f16802c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final String f16803d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16804e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final l<Integer, f> f16805f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final l<Integer, f> f16806g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final Map<Integer, t0> f16807h;

    public TypeDeserializer(@d i iVar, @e TypeDeserializer typeDeserializer, @d List<ProtoBuf.TypeParameter> list, @d String str, @d String str2, boolean z) {
        Map<Integer, t0> linkedHashMap;
        this.a = iVar;
        this.b = typeDeserializer;
        this.f16802c = str;
        this.f16803d = str2;
        this.f16804e = z;
        this.f16805f = iVar.h().g(new TypeDeserializer$classifierDescriptors$1(this));
        this.f16806g = iVar.h().g(new TypeDeserializer$typeAliasDescriptors$1(this));
        if (list.isEmpty()) {
            linkedHashMap = h.a2.t0.z();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i2 = 0;
            for (ProtoBuf.TypeParameter typeParameter : list) {
                linkedHashMap.put(Integer.valueOf(typeParameter.getId()), new DeserializedTypeParameterDescriptor(this.a, typeParameter, i2));
                i2++;
            }
        }
        this.f16807h = linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final f d(int i2) {
        b a = q.a(this.a.g(), i2);
        if (a.k()) {
            return this.a.c().b(a);
        }
        return FindClassInModuleKt.b(this.a.c().p(), a);
    }

    private final f0 e(int i2) {
        if (q.a(this.a.g(), i2).k()) {
            return this.a.c().n().a();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final f f(int i2) {
        b a = q.a(this.a.g(), i2);
        if (a.k()) {
            return null;
        }
        return FindClassInModuleKt.d(this.a.c().p(), a);
    }

    private final f0 g(z zVar, z zVar2) {
        h.p2.b0.g.t.b.f h2 = TypeUtilsKt.h(zVar);
        h.p2.b0.g.t.c.b1.e annotations = zVar.getAnnotations();
        z h3 = h.p2.b0.g.t.b.e.h(zVar);
        List<s0> Q1 = CollectionsKt___CollectionsKt.Q1(h.p2.b0.g.t.b.e.j(zVar), 1);
        ArrayList arrayList = new ArrayList(u.Y(Q1, 10));
        for (s0 s0Var : Q1) {
            arrayList.add(s0Var.getType());
        }
        return h.p2.b0.g.t.b.e.a(h2, annotations, h3, arrayList, null, zVar2, true).P0(zVar.J0());
    }

    private final f0 h(h.p2.b0.g.t.c.b1.e eVar, q0 q0Var, List<? extends s0> list, boolean z) {
        int size;
        int size2 = q0Var.getParameters().size() - list.size();
        f0 f0Var = null;
        if (size2 == 0) {
            f0Var = i(eVar, q0Var, list, z);
        } else if (size2 == 1 && (size = list.size() - 1) >= 0) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            f0Var = KotlinTypeFactory.i(eVar, q0Var.k().W(size).j(), list, z, null, 16, null);
        }
        return f0Var == null ? s.n(h.k2.v.f0.C("Bad suspend function in metadata with constructor: ", q0Var), list) : f0Var;
    }

    private final f0 i(h.p2.b0.g.t.c.b1.e eVar, q0 q0Var, List<? extends s0> list, boolean z) {
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        f0 i2 = KotlinTypeFactory.i(eVar, q0Var, list, z, null, 16, null);
        if (h.p2.b0.g.t.b.e.n(i2)) {
            return o(i2);
        }
        return null;
    }

    private static final List<ProtoBuf.Type.Argument> m(ProtoBuf.Type type, TypeDeserializer typeDeserializer) {
        List<ProtoBuf.Type.Argument> argumentList = type.getArgumentList();
        ProtoBuf.Type f2 = h.p2.b0.g.t.f.z.f.f(type, typeDeserializer.a.j());
        List<ProtoBuf.Type.Argument> m2 = f2 == null ? null : m(f2, typeDeserializer);
        if (m2 == null) {
            m2 = CollectionsKt__CollectionsKt.E();
        }
        return CollectionsKt___CollectionsKt.q4(argumentList, m2);
    }

    public static /* synthetic */ f0 n(TypeDeserializer typeDeserializer, ProtoBuf.Type type, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return typeDeserializer.l(type, z);
    }

    private final f0 o(z zVar) {
        boolean g2 = this.a.c().g().g();
        s0 s0Var = (s0) CollectionsKt___CollectionsKt.i3(h.p2.b0.g.t.b.e.j(zVar));
        z type = s0Var == null ? null : s0Var.getType();
        if (type == null) {
            return null;
        }
        f c2 = type.I0().c();
        c i2 = c2 == null ? null : DescriptorUtilsKt.i(c2);
        boolean z = true;
        if (type.H0().size() == 1 && (h.a(i2, true) || h.a(i2, false))) {
            z type2 = ((s0) CollectionsKt___CollectionsKt.U4(type.H0())).getType();
            k e2 = this.a.e();
            if (!(e2 instanceof a)) {
                e2 = null;
            }
            a aVar = (a) e2;
            if (h.k2.v.f0.g(aVar != null ? DescriptorUtilsKt.e(aVar) : null, v.a)) {
                return g(zVar, type2);
            }
            if (!this.f16804e && (!g2 || !h.a(i2, !g2))) {
                z = false;
            }
            this.f16804e = z;
            return g(zVar, type2);
        }
        return (f0) zVar;
    }

    private final s0 q(t0 t0Var, ProtoBuf.Type.Argument argument) {
        if (argument.getProjection() == ProtoBuf.Type.Argument.Projection.STAR) {
            if (t0Var == null) {
                return new j0(this.a.c().p().k());
            }
            return new StarProjectionImpl(t0Var);
        }
        Variance c2 = t.a.c(argument.getProjection());
        ProtoBuf.Type l2 = h.p2.b0.g.t.f.z.f.l(argument, this.a.j());
        return l2 == null ? new u0(s.j("No type recorded")) : new u0(c2, p(l2));
    }

    private final q0 r(ProtoBuf.Type type) {
        Object obj;
        if (type.hasClassName()) {
            f invoke = this.f16805f.invoke(Integer.valueOf(type.getClassName()));
            if (invoke == null) {
                invoke = s(this, type, type.getClassName());
            }
            return invoke.j();
        } else if (type.hasTypeParameter()) {
            q0 t = t(type.getTypeParameter());
            if (t == null) {
                return s.k("Unknown type parameter " + type.getTypeParameter() + ". Please try recompiling module containing \"" + this.f16803d + y.a);
            }
            return t;
        } else if (type.hasTypeParameterName()) {
            k e2 = this.a.e();
            String string = this.a.g().getString(type.getTypeParameterName());
            Iterator<T> it = k().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (h.k2.v.f0.g(((t0) obj).getName().b(), string)) {
                    break;
                }
            }
            t0 t0Var = (t0) obj;
            q0 j2 = t0Var != null ? t0Var.j() : null;
            if (j2 == null) {
                return s.k("Deserialized type parameter " + string + " in " + e2);
            }
            return j2;
        } else if (type.hasTypeAliasName()) {
            f invoke2 = this.f16806g.invoke(Integer.valueOf(type.getTypeAliasName()));
            if (invoke2 == null) {
                invoke2 = s(this, type, type.getTypeAliasName());
            }
            return invoke2.j();
        } else {
            return s.k("Unknown type");
        }
    }

    private static final h.p2.b0.g.t.c.d s(TypeDeserializer typeDeserializer, ProtoBuf.Type type, int i2) {
        b a = q.a(typeDeserializer.a.g(), i2);
        List<Integer> W2 = SequencesKt___SequencesKt.W2(SequencesKt___SequencesKt.d1(SequencesKt__SequencesKt.o(type, new TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$1(typeDeserializer)), TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2.INSTANCE));
        int Z = SequencesKt___SequencesKt.Z(SequencesKt__SequencesKt.o(a, TypeDeserializer$typeConstructor$notFoundClass$classNestingLevel$1.INSTANCE));
        while (W2.size() < Z) {
            W2.add(0);
        }
        return typeDeserializer.a.c().q().d(a, W2);
    }

    private final q0 t(int i2) {
        t0 t0Var = this.f16807h.get(Integer.valueOf(i2));
        q0 j2 = t0Var == null ? null : t0Var.j();
        if (j2 == null) {
            TypeDeserializer typeDeserializer = this.b;
            if (typeDeserializer == null) {
                return null;
            }
            return typeDeserializer.t(i2);
        }
        return j2;
    }

    public final boolean j() {
        return this.f16804e;
    }

    @d
    public final List<t0> k() {
        return CollectionsKt___CollectionsKt.I5(this.f16807h.values());
    }

    @d
    public final f0 l(@d ProtoBuf.Type type, boolean z) {
        f0 e2;
        f0 i2;
        f0 j2;
        if (type.hasClassName()) {
            e2 = e(type.getClassName());
        } else {
            e2 = type.hasTypeAliasName() ? e(type.getTypeAliasName()) : null;
        }
        if (e2 != null) {
            return e2;
        }
        q0 r = r(type);
        if (s.r(r.c())) {
            return s.o(r.toString(), r);
        }
        h.p2.b0.g.t.l.b.x.b bVar = new h.p2.b0.g.t.l.b.x.b(this.a.h(), new TypeDeserializer$simpleType$annotations$1(this, type));
        List<ProtoBuf.Type.Argument> m2 = m(type, this);
        ArrayList arrayList = new ArrayList(u.Y(m2, 10));
        int i3 = 0;
        for (Object obj : m2) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            arrayList.add(q((t0) CollectionsKt___CollectionsKt.J2(r.getParameters(), i3), (ProtoBuf.Type.Argument) obj));
            i3 = i4;
        }
        List<? extends s0> I5 = CollectionsKt___CollectionsKt.I5(arrayList);
        f c2 = r.c();
        if (z && (c2 instanceof h.p2.b0.g.t.c.s0)) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            f0 b = KotlinTypeFactory.b((h.p2.b0.g.t.c.s0) c2, I5);
            i2 = b.P0(a0.b(b) || type.getNullable()).Q0(h.p2.b0.g.t.c.b1.e.w0.a(CollectionsKt___CollectionsKt.m4(bVar, b.getAnnotations())));
        } else if (h.p2.b0.g.t.f.z.b.a.d(type.getFlags()).booleanValue()) {
            i2 = h(bVar, r, I5, type.getNullable());
        } else {
            KotlinTypeFactory kotlinTypeFactory2 = KotlinTypeFactory.a;
            i2 = KotlinTypeFactory.i(bVar, r, I5, type.getNullable(), null, 16, null);
            if (h.p2.b0.g.t.f.z.b.b.d(type.getFlags()).booleanValue()) {
                j c3 = j.a.c(j.f15584d, i2, false, 2, null);
                if (c3 == null) {
                    throw new IllegalStateException(("null DefinitelyNotNullType for '" + i2 + '\'').toString());
                }
                i2 = c3;
            }
        }
        ProtoBuf.Type a = h.p2.b0.g.t.f.z.f.a(type, this.a.j());
        if (a != null && (j2 = i0.j(i2, l(a, false))) != null) {
            i2 = j2;
        }
        return type.hasClassName() ? this.a.c().t().a(q.a(this.a.g(), type.getClassName()), i2) : i2;
    }

    @d
    public final z p(@d ProtoBuf.Type type) {
        if (type.hasFlexibleTypeCapabilitiesId()) {
            return this.a.c().l().a(type, this.a.g().getString(type.getFlexibleTypeCapabilitiesId()), n(this, type, false, 2, null), n(this, h.p2.b0.g.t.f.z.f.c(type, this.a.j()), false, 2, null));
        }
        return l(type, true);
    }

    @d
    public String toString() {
        String str = this.f16802c;
        TypeDeserializer typeDeserializer = this.b;
        return h.k2.v.f0.C(str, typeDeserializer == null ? "" : h.k2.v.f0.C(". Child of ", typeDeserializer.f16802c));
    }

    public /* synthetic */ TypeDeserializer(i iVar, TypeDeserializer typeDeserializer, List list, String str, String str2, boolean z, int i2, h.k2.v.u uVar) {
        this(iVar, typeDeserializer, list, str, str2, (i2 & 32) != 0 ? false : z);
    }
}
