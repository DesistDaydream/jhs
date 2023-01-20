package kotlin.reflect.jvm.internal.impl.load.java;

import h.k2.g;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.i0;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.e.a.c;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.n.e1.u;
import h.p2.b0.g.t.n.f0;
import k.e.a.d;
import k.e.a.e;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

@g(name = "SpecialBuiltinMembers")
/* loaded from: classes3.dex */
public final class SpecialBuiltinMembers {
    public static final boolean a(@d CallableMemberDescriptor callableMemberDescriptor) {
        return d(callableMemberDescriptor) != null;
    }

    @e
    public static final String b(@d CallableMemberDescriptor callableMemberDescriptor) {
        f i2;
        CallableMemberDescriptor c2 = c(callableMemberDescriptor);
        CallableMemberDescriptor o = c2 == null ? null : DescriptorUtilsKt.o(c2);
        if (o == null) {
            return null;
        }
        if (o instanceof j0) {
            return ClassicBuiltinSpecialProperties.a.a(o);
        }
        if (!(o instanceof n0) || (i2 = BuiltinMethodsWithDifferentJvmName.n.i((n0) o)) == null) {
            return null;
        }
        return i2.b();
    }

    private static final CallableMemberDescriptor c(CallableMemberDescriptor callableMemberDescriptor) {
        if (h.p2.b0.g.t.b.f.d0(callableMemberDescriptor)) {
            return d(callableMemberDescriptor);
        }
        return null;
    }

    @e
    public static final <T extends CallableMemberDescriptor> T d(@d T t) {
        if (SpecialGenericSignatures.a.g().contains(t.getName()) || c.a.d().contains(DescriptorUtilsKt.o(t).getName())) {
            if (t instanceof j0 ? true : t instanceof i0) {
                return (T) DescriptorUtilsKt.d(t, false, SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$1.INSTANCE, 1, null);
            }
            if (t instanceof n0) {
                return (T) DescriptorUtilsKt.d(t, false, SpecialBuiltinMembers$getOverriddenBuiltinWithDifferentJvmName$2.INSTANCE, 1, null);
            }
            return null;
        }
        return null;
    }

    @e
    public static final <T extends CallableMemberDescriptor> T e(@d T t) {
        T t2 = (T) d(t);
        if (t2 == null) {
            if (BuiltinMethodsWithSpecialGenericSignature.n.l(t.getName())) {
                return (T) DescriptorUtilsKt.d(t, false, SpecialBuiltinMembers$getOverriddenSpecialBuiltin$2.INSTANCE, 1, null);
            }
            return null;
        }
        return t2;
    }

    public static final boolean f(@d h.p2.b0.g.t.c.d dVar, @d a aVar) {
        f0 r = ((h.p2.b0.g.t.c.d) aVar.b()).r();
        h.p2.b0.g.t.c.d s = h.p2.b0.g.t.k.c.s(dVar);
        while (true) {
            if (s == null) {
                return false;
            }
            if (!(s instanceof h.p2.b0.g.t.e.a.u.c)) {
                if (u.b(s.r(), r) != null) {
                    return !h.p2.b0.g.t.b.f.d0(s);
                }
            }
            s = h.p2.b0.g.t.k.c.s(s);
        }
    }

    public static final boolean g(@d CallableMemberDescriptor callableMemberDescriptor) {
        return DescriptorUtilsKt.o(callableMemberDescriptor).b() instanceof h.p2.b0.g.t.e.a.u.c;
    }

    public static final boolean h(@d CallableMemberDescriptor callableMemberDescriptor) {
        return g(callableMemberDescriptor) || h.p2.b0.g.t.b.f.d0(callableMemberDescriptor);
    }
}
