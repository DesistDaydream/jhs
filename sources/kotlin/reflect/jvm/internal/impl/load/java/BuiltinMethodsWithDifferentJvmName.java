package kotlin.reflect.jvm.internal.impl.load.java;

import h.k2.v.f0;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.e.b.r;
import h.p2.b0.g.t.g.f;
import java.util.Map;
import k.e.a.d;
import k.e.a.e;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes3.dex */
public final class BuiltinMethodsWithDifferentJvmName extends SpecialGenericSignatures {
    @d
    public static final BuiltinMethodsWithDifferentJvmName n = new BuiltinMethodsWithDifferentJvmName();

    private BuiltinMethodsWithDifferentJvmName() {
    }

    @e
    public final f i(@d n0 n0Var) {
        Map<String, f> j2 = SpecialGenericSignatures.a.j();
        String d2 = r.d(n0Var);
        if (d2 == null) {
            return null;
        }
        return j2.get(d2);
    }

    public final boolean j(@d n0 n0Var) {
        return h.p2.b0.g.t.b.f.d0(n0Var) && DescriptorUtilsKt.d(n0Var, false, new BuiltinMethodsWithDifferentJvmName$isBuiltinFunctionWithDifferentNameInJvm$1(n0Var), 1, null) != null;
    }

    public final boolean k(@d n0 n0Var) {
        return f0.g(n0Var.getName().b(), "removeAt") && f0.g(r.d(n0Var), SpecialGenericSignatures.a.h().b());
    }
}
