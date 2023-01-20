package h.p2.b0.g.t.o;

import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.o.b;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes3.dex */
public final class g implements b {
    @k.e.a.d
    public static final g a = new g();
    @k.e.a.d
    private static final String b = "should not have varargs or parameters with default values";

    private g() {
    }

    @Override // h.p2.b0.g.t.o.b
    @k.e.a.e
    public String a(@k.e.a.d v vVar) {
        return b.a.a(this, vVar);
    }

    @Override // h.p2.b0.g.t.o.b
    public boolean b(@k.e.a.d v vVar) {
        boolean z;
        List<v0> h2 = vVar.h();
        if (!(h2 instanceof Collection) || !h2.isEmpty()) {
            for (v0 v0Var : h2) {
                if (DescriptorUtilsKt.a(v0Var) || v0Var.t0() != null) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (!z) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // h.p2.b0.g.t.o.b
    @k.e.a.d
    public String getDescription() {
        return b;
    }
}
