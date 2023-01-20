package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import h.a2.u;
import h.k2.v.f0;
import h.p2.b0.g.t.b.e;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.c.d1.a0;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.f.z.b;
import h.p2.b0.g.t.f.z.h;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.i.n;
import h.p2.b0.g.t.l.b.c;
import h.p2.b0.g.t.l.b.i;
import h.p2.b0.g.t.l.b.q;
import h.p2.b0.g.t.l.b.s;
import h.p2.b0.g.t.l.b.t;
import h.p2.b0.g.t.l.b.v;
import h.p2.b0.g.t.l.b.x.g;
import h.p2.b0.g.t.l.b.x.h;
import h.p2.b0.g.t.l.b.x.j;
import h.p2.b0.g.t.n.s0;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import k.e.a.d;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class MemberDeserializer {
    @d
    private final i a;
    @d
    private final c b;

    public MemberDeserializer(@d i iVar) {
        this.a = iVar;
        this.b = new c(iVar.c().p(), iVar.c().q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final s c(k kVar) {
        if (kVar instanceof b0) {
            return new s.b(((b0) kVar).e(), this.a.g(), this.a.j(), this.a.d());
        }
        if (kVar instanceof DeserializedClassDescriptor) {
            return ((DeserializedClassDescriptor) kVar).X0();
        }
        return null;
    }

    private final DeserializedMemberDescriptor.CoroutinesCompatibilityMode d(DeserializedMemberDescriptor deserializedMemberDescriptor, TypeDeserializer typeDeserializer) {
        if (s(deserializedMemberDescriptor)) {
            g(typeDeserializer);
            if (typeDeserializer.j()) {
                return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            }
            return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
        }
        return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }

    private final DeserializedMemberDescriptor.CoroutinesCompatibilityMode e(h.p2.b0.g.t.l.b.x.c cVar, m0 m0Var, Collection<? extends v0> collection, Collection<? extends t0> collection2, z zVar, boolean z) {
        boolean z2;
        boolean z3;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode2;
        boolean z4;
        if (s(cVar) && !f0.g(DescriptorUtilsKt.e(cVar), v.a)) {
            ArrayList arrayList = new ArrayList(u.Y(collection, 10));
            for (v0 v0Var : collection) {
                arrayList.add(v0Var.getType());
            }
            List<z> q4 = CollectionsKt___CollectionsKt.q4(arrayList, CollectionsKt__CollectionsKt.M(m0Var == null ? null : m0Var.getType()));
            if (f0.g(zVar != null ? Boolean.valueOf(f(zVar)) : null, Boolean.TRUE)) {
                return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            }
            if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
                for (t0 t0Var : collection2) {
                    List<z> upperBounds = t0Var.getUpperBounds();
                    if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                        for (z zVar2 : upperBounds) {
                            if (f(zVar2)) {
                                z2 = true;
                                continue;
                                break;
                            }
                        }
                    }
                    z2 = false;
                    continue;
                    if (z2) {
                        z3 = true;
                        break;
                    }
                }
            }
            z3 = false;
            if (z3) {
                return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            }
            ArrayList arrayList2 = new ArrayList(u.Y(q4, 10));
            for (z zVar3 : q4) {
                if (e.o(zVar3) && zVar3.H0().size() <= 3) {
                    List<s0> H0 = zVar3.H0();
                    if (!(H0 instanceof Collection) || !H0.isEmpty()) {
                        for (s0 s0Var : H0) {
                            if (f(s0Var.getType())) {
                                z4 = true;
                                break;
                            }
                        }
                    }
                    z4 = false;
                    if (z4) {
                        coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
                    } else {
                        coroutinesCompatibilityMode2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.NEEDS_WRAPPER;
                    }
                } else {
                    coroutinesCompatibilityMode2 = f(zVar3) ? DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE : DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
                }
                arrayList2.add(coroutinesCompatibilityMode2);
            }
            DeserializedMemberDescriptor.CoroutinesCompatibilityMode coroutinesCompatibilityMode3 = (DeserializedMemberDescriptor.CoroutinesCompatibilityMode) CollectionsKt___CollectionsKt.F3(arrayList2);
            if (coroutinesCompatibilityMode3 == null) {
                coroutinesCompatibilityMode3 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
            }
            if (z) {
                coroutinesCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.NEEDS_WRAPPER;
            } else {
                coroutinesCompatibilityMode = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
            }
            return (DeserializedMemberDescriptor.CoroutinesCompatibilityMode) h.b2.c.O(coroutinesCompatibilityMode, coroutinesCompatibilityMode3);
        }
        return DeserializedMemberDescriptor.CoroutinesCompatibilityMode.COMPATIBLE;
    }

    private final boolean f(z zVar) {
        return TypeUtilsKt.b(zVar, MemberDeserializer$containsSuspendFunctionType$1.INSTANCE);
    }

    private final void g(TypeDeserializer typeDeserializer) {
        for (t0 t0Var : typeDeserializer.k()) {
            t0Var.getUpperBounds();
        }
    }

    private final h.p2.b0.g.t.c.b1.e h(n nVar, int i2, AnnotatedCallableKind annotatedCallableKind) {
        if (!b.f15386c.d(i2).booleanValue()) {
            return h.p2.b0.g.t.c.b1.e.w0.b();
        }
        return new j(this.a.h(), new MemberDeserializer$getAnnotations$1(this, nVar, annotatedCallableKind));
    }

    private final m0 i() {
        k e2 = this.a.e();
        h.p2.b0.g.t.c.d dVar = e2 instanceof h.p2.b0.g.t.c.d ? (h.p2.b0.g.t.c.d) e2 : null;
        if (dVar == null) {
            return null;
        }
        return dVar.F0();
    }

    private final h.p2.b0.g.t.c.b1.e j(ProtoBuf.Property property, boolean z) {
        if (!b.f15386c.d(property.getFlags()).booleanValue()) {
            return h.p2.b0.g.t.c.b1.e.w0.b();
        }
        return new j(this.a.h(), new MemberDeserializer$getPropertyFieldAnnotations$1(this, z, property));
    }

    private final h.p2.b0.g.t.c.b1.e k(n nVar, AnnotatedCallableKind annotatedCallableKind) {
        return new h.p2.b0.g.t.l.b.x.b(this.a.h(), new MemberDeserializer$getReceiverParameterAnnotations$1(this, nVar, annotatedCallableKind));
    }

    private final void l(h hVar, m0 m0Var, m0 m0Var2, List<? extends t0> list, List<? extends v0> list2, z zVar, Modality modality, h.p2.b0.g.t.c.s sVar, Map<? extends a.InterfaceC0434a<?>, ?> map, boolean z) {
        hVar.n1(m0Var, m0Var2, list, list2, zVar, modality, sVar, map, e(hVar, m0Var, list2, list, zVar, z));
    }

    private final int o(int i2) {
        return (i2 & 63) + ((i2 >> 8) << 6);
    }

    private final List<v0> r(List<ProtoBuf.ValueParameter> list, n nVar, AnnotatedCallableKind annotatedCallableKind) {
        j b;
        a aVar = (a) this.a.e();
        s c2 = c(aVar.b());
        ArrayList arrayList = new ArrayList(u.Y(list, 10));
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            ProtoBuf.ValueParameter valueParameter = (ProtoBuf.ValueParameter) obj;
            int flags = valueParameter.hasFlags() ? valueParameter.getFlags() : 0;
            if (c2 != null && b.f15386c.d(flags).booleanValue()) {
                b = new j(this.a.h(), new MemberDeserializer$valueParameters$1$annotations$1(this, c2, nVar, annotatedCallableKind, i2, valueParameter));
            } else {
                b = h.p2.b0.g.t.c.b1.e.w0.b();
            }
            f b2 = q.b(this.a.g(), valueParameter.getName());
            z p = this.a.i().p(h.p2.b0.g.t.f.z.f.m(valueParameter, this.a.j()));
            boolean booleanValue = b.G.d(flags).booleanValue();
            boolean booleanValue2 = b.H.d(flags).booleanValue();
            boolean booleanValue3 = b.I.d(flags).booleanValue();
            ProtoBuf.Type p2 = h.p2.b0.g.t.f.z.f.p(valueParameter, this.a.j());
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new ValueParameterDescriptorImpl(aVar, null, i2, b, b2, p, booleanValue, booleanValue2, booleanValue3, p2 == null ? null : this.a.i().p(p2), o0.a));
            arrayList = arrayList2;
            i2 = i3;
        }
        return CollectionsKt___CollectionsKt.I5(arrayList);
    }

    private final boolean s(DeserializedMemberDescriptor deserializedMemberDescriptor) {
        boolean z;
        boolean z2;
        if (this.a.c().g().g()) {
            List<h.p2.b0.g.t.f.z.h> E0 = deserializedMemberDescriptor.E0();
            if (!(E0 instanceof Collection) || !E0.isEmpty()) {
                for (h.p2.b0.g.t.f.z.h hVar : E0) {
                    if (f0.g(hVar.b(), new h.b(1, 3, 0, 4, null)) && hVar.a() == ProtoBuf.VersionRequirement.VersionKind.LANGUAGE_VERSION) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        z2 = false;
                        break;
                    }
                }
            }
            z2 = true;
            return z2;
        }
        return false;
    }

    @d
    public final h.p2.b0.g.t.c.c m(@d ProtoBuf.Constructor constructor, boolean z) {
        h.p2.b0.g.t.l.b.x.d dVar;
        DeserializedMemberDescriptor.CoroutinesCompatibilityMode e2;
        TypeDeserializer i2;
        h.p2.b0.g.t.c.d dVar2 = (h.p2.b0.g.t.c.d) this.a.e();
        int flags = constructor.getFlags();
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        h.p2.b0.g.t.l.b.x.d dVar3 = new h.p2.b0.g.t.l.b.x.d(dVar2, null, h(constructor, flags, annotatedCallableKind), z, CallableMemberDescriptor.Kind.DECLARATION, constructor, this.a.g(), this.a.j(), this.a.k(), this.a.d(), null, 1024, null);
        dVar3.l1(i.b(this.a, dVar3, CollectionsKt__CollectionsKt.E(), null, null, null, null, 60, null).f().r(constructor.getValueParameterList(), constructor, annotatedCallableKind), h.p2.b0.g.t.l.b.u.a(t.a, b.f15387d.d(constructor.getFlags())));
        dVar3.c1(dVar2.r());
        boolean z2 = true;
        dVar3.U0(!b.n.d(constructor.getFlags()).booleanValue());
        k e3 = this.a.e();
        Boolean bool = null;
        DeserializedClassDescriptor deserializedClassDescriptor = e3 instanceof DeserializedClassDescriptor ? (DeserializedClassDescriptor) e3 : null;
        i S0 = deserializedClassDescriptor == null ? null : deserializedClassDescriptor.S0();
        if (S0 != null && (i2 = S0.i()) != null) {
            bool = Boolean.valueOf(i2.j());
        }
        if ((f0.g(bool, Boolean.TRUE) && s(dVar3)) ? false : false) {
            e2 = DeserializedMemberDescriptor.CoroutinesCompatibilityMode.INCOMPATIBLE;
            dVar = dVar3;
        } else {
            dVar = dVar3;
            e2 = e(dVar3, null, dVar3.h(), dVar3.getTypeParameters(), dVar3.getReturnType(), false);
        }
        dVar.q1(e2);
        return dVar;
    }

    @d
    public final n0 n(@d ProtoBuf.Function function) {
        h.p2.b0.g.t.c.b1.e b;
        h.p2.b0.g.t.f.z.i k2;
        z p;
        int flags = function.hasFlags() ? function.getFlags() : o(function.getOldFlags());
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        h.p2.b0.g.t.c.b1.e h2 = h(function, flags, annotatedCallableKind);
        if (h.p2.b0.g.t.f.z.f.d(function)) {
            b = k(function, annotatedCallableKind);
        } else {
            b = h.p2.b0.g.t.c.b1.e.w0.b();
        }
        if (f0.g(DescriptorUtilsKt.i(this.a.e()).c(q.b(this.a.g(), function.getName())), v.a)) {
            k2 = h.p2.b0.g.t.f.z.i.b.b();
        } else {
            k2 = this.a.k();
        }
        h.p2.b0.g.t.f.z.i iVar = k2;
        k e2 = this.a.e();
        f b2 = q.b(this.a.g(), function.getName());
        t tVar = t.a;
        h.p2.b0.g.t.l.b.x.h hVar = new h.p2.b0.g.t.l.b.x.h(e2, null, h2, b2, h.p2.b0.g.t.l.b.u.b(tVar, b.o.d(flags)), function, this.a.g(), this.a.j(), iVar, this.a.d(), null, 1024, null);
        i b3 = i.b(this.a, hVar, function.getTypeParameterList(), null, null, null, null, 60, null);
        ProtoBuf.Type g2 = h.p2.b0.g.t.f.z.f.g(function, this.a.j());
        m0 m0Var = null;
        if (g2 != null && (p = b3.i().p(g2)) != null) {
            m0Var = h.p2.b0.g.t.k.b.f(hVar, p, b);
        }
        m0 i2 = i();
        List<t0> k3 = b3.i().k();
        List<v0> r = b3.f().r(function.getValueParameterList(), function, annotatedCallableKind);
        z p2 = b3.i().p(h.p2.b0.g.t.f.z.f.i(function, this.a.j()));
        Modality b4 = tVar.b(b.f15388e.d(flags));
        h.p2.b0.g.t.c.s a = h.p2.b0.g.t.l.b.u.a(tVar, b.f15387d.d(flags));
        Map<? extends a.InterfaceC0434a<?>, ?> z = h.a2.t0.z();
        b.C0456b c0456b = b.u;
        l(hVar, m0Var, i2, k3, r, p2, b4, a, z, c0456b.d(flags).booleanValue());
        hVar.b1(b.p.d(flags).booleanValue());
        hVar.Y0(b.q.d(flags).booleanValue());
        hVar.T0(b.t.d(flags).booleanValue());
        hVar.a1(b.r.d(flags).booleanValue());
        hVar.e1(b.s.d(flags).booleanValue());
        hVar.d1(c0456b.d(flags).booleanValue());
        hVar.S0(b.v.d(flags).booleanValue());
        hVar.U0(!b.w.d(flags).booleanValue());
        Pair<a.InterfaceC0434a<?>, Object> a2 = this.a.c().h().a(function, hVar, this.a.j(), b3.i());
        if (a2 != null) {
            hVar.Q0(a2.getFirst(), a2.getSecond());
        }
        return hVar;
    }

    @d
    public final j0 p(@d ProtoBuf.Property property) {
        ProtoBuf.Property property2;
        h.p2.b0.g.t.c.b1.e b;
        z p;
        g gVar;
        m0 f2;
        b.d<ProtoBuf.Modality> dVar;
        b.d<ProtoBuf.Visibility> dVar2;
        t tVar;
        a0 a0Var;
        g gVar2;
        ProtoBuf.Property property3;
        int i2;
        boolean z;
        h.p2.b0.g.t.c.d1.b0 b0Var;
        a0 b2;
        int flags = property.hasFlags() ? property.getFlags() : o(property.getOldFlags());
        k e2 = this.a.e();
        h.p2.b0.g.t.c.b1.e h2 = h(property, flags, AnnotatedCallableKind.PROPERTY);
        t tVar2 = t.a;
        b.d<ProtoBuf.Modality> dVar3 = b.f15388e;
        Modality b3 = tVar2.b(dVar3.d(flags));
        b.d<ProtoBuf.Visibility> dVar4 = b.f15387d;
        g gVar3 = new g(e2, null, h2, b3, h.p2.b0.g.t.l.b.u.a(tVar2, dVar4.d(flags)), b.x.d(flags).booleanValue(), q.b(this.a.g(), property.getName()), h.p2.b0.g.t.l.b.u.b(tVar2, b.o.d(flags)), b.B.d(flags).booleanValue(), b.A.d(flags).booleanValue(), b.D.d(flags).booleanValue(), b.E.d(flags).booleanValue(), b.F.d(flags).booleanValue(), property, this.a.g(), this.a.j(), this.a.k(), this.a.d());
        i b4 = i.b(this.a, gVar3, property.getTypeParameterList(), null, null, null, null, 60, null);
        boolean booleanValue = b.y.d(flags).booleanValue();
        if (booleanValue && h.p2.b0.g.t.f.z.f.e(property)) {
            property2 = property;
            b = k(property2, AnnotatedCallableKind.PROPERTY_GETTER);
        } else {
            property2 = property;
            b = h.p2.b0.g.t.c.b1.e.w0.b();
        }
        z p2 = b4.i().p(h.p2.b0.g.t.f.z.f.j(property2, this.a.j()));
        List<t0> k2 = b4.i().k();
        m0 i3 = i();
        ProtoBuf.Type h3 = h.p2.b0.g.t.f.z.f.h(property2, this.a.j());
        if (h3 == null || (p = b4.i().p(h3)) == null) {
            gVar = gVar3;
            f2 = null;
        } else {
            gVar = gVar3;
            f2 = h.p2.b0.g.t.k.b.f(gVar, p, b);
        }
        gVar.W0(p2, k2, i3, f2);
        int b5 = b.b(b.f15386c.d(flags).booleanValue(), dVar4.d(flags), dVar3.d(flags), false, false, false);
        if (booleanValue) {
            int getterFlags = property.hasGetterFlags() ? property.getGetterFlags() : b5;
            boolean booleanValue2 = b.J.d(getterFlags).booleanValue();
            boolean booleanValue3 = b.K.d(getterFlags).booleanValue();
            boolean booleanValue4 = b.L.d(getterFlags).booleanValue();
            h.p2.b0.g.t.c.b1.e h4 = h(property2, getterFlags, AnnotatedCallableKind.PROPERTY_GETTER);
            if (booleanValue2) {
                tVar = tVar2;
                dVar = dVar3;
                dVar2 = dVar4;
                b2 = new a0(gVar, h4, tVar2.b(dVar3.d(getterFlags)), h.p2.b0.g.t.l.b.u.a(tVar2, dVar4.d(getterFlags)), !booleanValue2, booleanValue3, booleanValue4, gVar.i(), null, o0.a);
            } else {
                dVar = dVar3;
                dVar2 = dVar4;
                tVar = tVar2;
                b2 = h.p2.b0.g.t.k.b.b(gVar, h4);
            }
            b2.M0(gVar.getReturnType());
            a0Var = b2;
        } else {
            dVar = dVar3;
            dVar2 = dVar4;
            tVar = tVar2;
            a0Var = null;
        }
        if (b.z.d(flags).booleanValue()) {
            if (property.hasSetterFlags()) {
                b5 = property.getSetterFlags();
            }
            int i4 = b5;
            boolean booleanValue5 = b.J.d(i4).booleanValue();
            boolean booleanValue6 = b.K.d(i4).booleanValue();
            boolean booleanValue7 = b.L.d(i4).booleanValue();
            AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.PROPERTY_SETTER;
            h.p2.b0.g.t.c.b1.e h5 = h(property2, i4, annotatedCallableKind);
            if (booleanValue5) {
                t tVar3 = tVar;
                h.p2.b0.g.t.c.d1.b0 b0Var2 = new h.p2.b0.g.t.c.d1.b0(gVar, h5, tVar3.b(dVar.d(i4)), h.p2.b0.g.t.l.b.u.a(tVar3, dVar2.d(i4)), !booleanValue5, booleanValue6, booleanValue7, gVar.i(), null, o0.a);
                z = true;
                gVar2 = gVar;
                property3 = property2;
                i2 = flags;
                b0Var2.N0((v0) CollectionsKt___CollectionsKt.U4(i.b(b4, b0Var2, CollectionsKt__CollectionsKt.E(), null, null, null, null, 60, null).f().r(h.a2.t.k(property.getSetterValueParameter()), property3, annotatedCallableKind)));
                b0Var = b0Var2;
            } else {
                gVar2 = gVar;
                property3 = property2;
                i2 = flags;
                z = true;
                b0Var = h.p2.b0.g.t.k.b.c(gVar2, h5, h.p2.b0.g.t.c.b1.e.w0.b());
            }
        } else {
            gVar2 = gVar;
            property3 = property2;
            i2 = flags;
            z = true;
            b0Var = null;
        }
        if (b.C.d(i2).booleanValue()) {
            gVar2.H0(this.a.h().e(new MemberDeserializer$loadProperty$3(this, property3, gVar2)));
        }
        gVar2.Z0(a0Var, b0Var, new h.p2.b0.g.t.c.d1.n(j(property3, false), gVar2), new h.p2.b0.g.t.c.d1.n(j(property3, z), gVar2), d(gVar2, b4.i()));
        return gVar2;
    }

    @d
    public final h.p2.b0.g.t.c.s0 q(@d ProtoBuf.TypeAlias typeAlias) {
        e.a aVar = h.p2.b0.g.t.c.b1.e.w0;
        List<ProtoBuf.Annotation> annotationList = typeAlias.getAnnotationList();
        ArrayList arrayList = new ArrayList(u.Y(annotationList, 10));
        for (ProtoBuf.Annotation annotation : annotationList) {
            arrayList.add(this.b.a(annotation, this.a.g()));
        }
        h.p2.b0.g.t.l.b.x.i iVar = new h.p2.b0.g.t.l.b.x.i(this.a.h(), this.a.e(), aVar.a(arrayList), q.b(this.a.g(), typeAlias.getName()), h.p2.b0.g.t.l.b.u.a(t.a, b.f15387d.d(typeAlias.getFlags())), typeAlias, this.a.g(), this.a.j(), this.a.k(), this.a.d());
        i b = i.b(this.a, iVar, typeAlias.getTypeParameterList(), null, null, null, null, 60, null);
        iVar.M0(b.i().k(), b.i().l(h.p2.b0.g.t.f.z.f.n(typeAlias, this.a.j()), false), b.i().l(h.p2.b0.g.t.f.z.f.b(typeAlias, this.a.j()), false), d(iVar, b.i()));
        return iVar;
    }
}
