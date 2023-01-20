package kotlin.reflect.jvm.internal.impl.load.java;

import h.p2.b0.g.t.b.f;
import h.p2.b0.g.t.e.a.c;
import java.util.Collection;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes3.dex */
public final class ClassicBuiltinSpecialProperties {
    @d
    public static final ClassicBuiltinSpecialProperties a = new ClassicBuiltinSpecialProperties();

    private ClassicBuiltinSpecialProperties() {
    }

    private final boolean c(CallableMemberDescriptor callableMemberDescriptor) {
        if (CollectionsKt___CollectionsKt.J1(c.a.c(), DescriptorUtilsKt.e(callableMemberDescriptor)) && callableMemberDescriptor.h().isEmpty()) {
            return true;
        }
        if (f.d0(callableMemberDescriptor)) {
            Collection<? extends CallableMemberDescriptor> d2 = callableMemberDescriptor.d();
            if (!d2.isEmpty()) {
                for (CallableMemberDescriptor callableMemberDescriptor2 : d2) {
                    if (a.b(callableMemberDescriptor2)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    @e
    public final String a(@d CallableMemberDescriptor callableMemberDescriptor) {
        h.p2.b0.g.t.g.f fVar;
        f.d0(callableMemberDescriptor);
        CallableMemberDescriptor d2 = DescriptorUtilsKt.d(DescriptorUtilsKt.o(callableMemberDescriptor), false, ClassicBuiltinSpecialProperties$getBuiltinSpecialPropertyGetterName$descriptor$1.INSTANCE, 1, null);
        if (d2 == null || (fVar = c.a.a().get(DescriptorUtilsKt.i(d2))) == null) {
            return null;
        }
        return fVar.b();
    }

    public final boolean b(@d CallableMemberDescriptor callableMemberDescriptor) {
        if (c.a.d().contains(callableMemberDescriptor.getName())) {
            return c(callableMemberDescriptor);
        }
        return false;
    }
}
