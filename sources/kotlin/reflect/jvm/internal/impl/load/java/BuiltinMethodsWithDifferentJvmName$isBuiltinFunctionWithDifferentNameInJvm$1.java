package kotlin.reflect.jvm.internal.impl.load.java;

import h.k2.u.l;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.e.b.r;
import h.p2.b0.g.t.g.f;
import java.util.Map;
import java.util.Objects;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: classes3.dex */
public final class BuiltinMethodsWithDifferentJvmName$isBuiltinFunctionWithDifferentNameInJvm$1 extends Lambda implements l<CallableMemberDescriptor, Boolean> {
    public final /* synthetic */ n0 $functionDescriptor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuiltinMethodsWithDifferentJvmName$isBuiltinFunctionWithDifferentNameInJvm$1(n0 n0Var) {
        super(1);
        this.$functionDescriptor = n0Var;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(invoke2(callableMemberDescriptor));
    }

    /* renamed from: invoke */
    public final boolean invoke2(@d CallableMemberDescriptor callableMemberDescriptor) {
        Map<String, f> j2 = SpecialGenericSignatures.a.j();
        String d2 = r.d(this.$functionDescriptor);
        Objects.requireNonNull(j2, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        return j2.containsKey(d2);
    }
}
