package kotlin.reflect.jvm.internal.impl.resolve;

import h.k2.u.p;
import h.k2.v.f0;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.w;
import h.p2.b0.g.t.k.c;
import h.p2.b0.g.t.n.e1.f;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.q0;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;

/* loaded from: classes3.dex */
public final class DescriptorEquivalenceForOverrides {
    @d
    public static final DescriptorEquivalenceForOverrides a = new DescriptorEquivalenceForOverrides();

    private DescriptorEquivalenceForOverrides() {
    }

    public static /* synthetic */ boolean b(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, a aVar, a aVar2, boolean z, boolean z2, boolean z3, h hVar, int i2, Object obj) {
        return descriptorEquivalenceForOverrides.a(aVar, aVar2, z, (i2 & 8) != 0 ? true : z2, (i2 & 16) != 0 ? false : z3, hVar);
    }

    private final boolean c(h.p2.b0.g.t.c.d dVar, h.p2.b0.g.t.c.d dVar2) {
        return f0.g(dVar.j(), dVar2.j());
    }

    public static /* synthetic */ boolean e(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, k kVar, k kVar2, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        return descriptorEquivalenceForOverrides.d(kVar, kVar2, z, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean h(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, t0 t0Var, t0 t0Var2, boolean z, p pVar, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            pVar = DescriptorEquivalenceForOverrides$areTypeParametersEquivalent$1.INSTANCE;
        }
        return descriptorEquivalenceForOverrides.g(t0Var, t0Var2, z, pVar);
    }

    private final boolean i(k kVar, k kVar2, p<? super k, ? super k, Boolean> pVar, boolean z) {
        k b = kVar.b();
        k b2 = kVar2.b();
        if (!(b instanceof CallableMemberDescriptor) && !(b2 instanceof CallableMemberDescriptor)) {
            return e(this, b, b2, z, false, 8, null);
        }
        return pVar.invoke(b, b2).booleanValue();
    }

    private final o0 j(a aVar) {
        while (aVar instanceof CallableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) aVar;
            if (callableMemberDescriptor.i() != CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                break;
            }
            aVar = (CallableMemberDescriptor) CollectionsKt___CollectionsKt.V4(callableMemberDescriptor.d());
            if (aVar == null) {
                return null;
            }
        }
        return aVar.getSource();
    }

    public final boolean a(@d final a aVar, @d final a aVar2, final boolean z, boolean z2, boolean z3, @d h hVar) {
        if (f0.g(aVar, aVar2)) {
            return true;
        }
        if (f0.g(aVar.getName(), aVar2.getName())) {
            if (z2 && (aVar instanceof w) && (aVar2 instanceof w) && ((w) aVar).i0() != ((w) aVar2).i0()) {
                return false;
            }
            if ((!f0.g(aVar.b(), aVar2.b()) || (z && f0.g(j(aVar), j(aVar2)))) && !c.E(aVar) && !c.E(aVar2) && i(aVar, aVar2, DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$1.INSTANCE, z)) {
                OverridingUtil i2 = OverridingUtil.i(hVar, new f.a() { // from class: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1

                    /* renamed from: kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1$1  reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass1 extends Lambda implements p<k, k, Boolean> {
                        public final /* synthetic */ a $a;
                        public final /* synthetic */ a $b;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(a aVar, a aVar2) {
                            super(2);
                            this.$a = aVar;
                            this.$b = aVar2;
                        }

                        @Override // h.k2.u.p
                        public /* bridge */ /* synthetic */ Boolean invoke(k kVar, k kVar2) {
                            return Boolean.valueOf(invoke2(kVar, kVar2));
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final boolean invoke2(@e k kVar, @e k kVar2) {
                            return f0.g(kVar, this.$a) && f0.g(kVar2, this.$b);
                        }
                    }

                    @Override // h.p2.b0.g.t.n.e1.f.a
                    public final boolean a(@d q0 q0Var, @d q0 q0Var2) {
                        if (f0.g(q0Var, q0Var2)) {
                            return true;
                        }
                        h.p2.b0.g.t.c.f c2 = q0Var.c();
                        h.p2.b0.g.t.c.f c3 = q0Var2.c();
                        if ((c2 instanceof t0) && (c3 instanceof t0)) {
                            return DescriptorEquivalenceForOverrides.a.g((t0) c2, (t0) c3, z, new AnonymousClass1(aVar, aVar2));
                        }
                        return false;
                    }
                });
                OverridingUtil.OverrideCompatibilityInfo.Result c2 = i2.F(aVar, aVar2, null, !z3).c();
                OverridingUtil.OverrideCompatibilityInfo.Result result = OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE;
                return c2 == result && i2.F(aVar2, aVar, null, z3 ^ true).c() == result;
            }
            return false;
        }
        return false;
    }

    public final boolean d(@e k kVar, @e k kVar2, boolean z, boolean z2) {
        if ((kVar instanceof h.p2.b0.g.t.c.d) && (kVar2 instanceof h.p2.b0.g.t.c.d)) {
            return c((h.p2.b0.g.t.c.d) kVar, (h.p2.b0.g.t.c.d) kVar2);
        }
        if ((kVar instanceof t0) && (kVar2 instanceof t0)) {
            return h(this, (t0) kVar, (t0) kVar2, z, null, 8, null);
        }
        if ((kVar instanceof a) && (kVar2 instanceof a)) {
            return b(this, (a) kVar, (a) kVar2, z, z2, false, h.a.a, 16, null);
        }
        return ((kVar instanceof b0) && (kVar2 instanceof b0)) ? f0.g(((b0) kVar).e(), ((b0) kVar2).e()) : f0.g(kVar, kVar2);
    }

    @h.k2.h
    public final boolean f(@d t0 t0Var, @d t0 t0Var2, boolean z) {
        return h(this, t0Var, t0Var2, z, null, 8, null);
    }

    @h.k2.h
    public final boolean g(@d t0 t0Var, @d t0 t0Var2, boolean z, @d p<? super k, ? super k, Boolean> pVar) {
        if (f0.g(t0Var, t0Var2)) {
            return true;
        }
        return !f0.g(t0Var.b(), t0Var2.b()) && i(t0Var, t0Var2, pVar, z) && t0Var.f() == t0Var2.f();
    }
}
