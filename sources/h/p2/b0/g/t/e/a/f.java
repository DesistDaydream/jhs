package h.p2.b0.g.t.e.a;

import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.u;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: classes3.dex */
public final class f {
    private static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        if (i2 == 1 || i2 == 2) {
            objArr[0] = "companionObject";
        } else if (i2 != 3) {
            objArr[0] = "propertyDescriptor";
        } else {
            objArr[0] = "memberDescriptor";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i2 == 1) {
            objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        } else if (i2 == 2) {
            objArr[2] = "isMappedIntrinsicCompanionObject";
        } else if (i2 != 3) {
            objArr[2] = "isPropertyWithBackingFieldInOuterClass";
        } else {
            objArr[2] = "hasJvmFieldAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean b(@k.e.a.d CallableMemberDescriptor callableMemberDescriptor) {
        u u0;
        if (callableMemberDescriptor == null) {
            a(3);
        }
        if ((callableMemberDescriptor instanceof j0) && (u0 = ((j0) callableMemberDescriptor).u0()) != null && u0.getAnnotations().n(o.b)) {
            return true;
        }
        return callableMemberDescriptor.getAnnotations().n(o.b);
    }

    public static boolean c(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
        if (kVar == null) {
            a(1);
        }
        return h.p2.b0.g.t.k.c.x(kVar) && h.p2.b0.g.t.k.c.w(kVar.b()) && !d((h.p2.b0.g.t.c.d) kVar);
    }

    public static boolean d(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        if (dVar == null) {
            a(2);
        }
        return h.p2.b0.g.t.b.b.a(CompanionObjectMapping.a, dVar);
    }

    public static boolean e(@k.e.a.d j0 j0Var) {
        if (j0Var == null) {
            a(0);
        }
        if (j0Var.i() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            return false;
        }
        if (c(j0Var.b())) {
            return true;
        }
        return h.p2.b0.g.t.k.c.x(j0Var.b()) && b(j0Var);
    }
}
