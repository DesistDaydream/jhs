package kotlin.reflect.jvm.internal.impl.util;

import h.k2.u.l;
import h.k2.v.f0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.c.v0;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes3.dex */
public final class OperatorChecks$checks$1 extends Lambda implements l<v, String> {
    public static final OperatorChecks$checks$1 INSTANCE = new OperatorChecks$checks$1();

    public OperatorChecks$checks$1() {
        super(1);
    }

    @Override // h.k2.u.l
    @e
    public final String invoke(@d v vVar) {
        Boolean valueOf;
        v0 v0Var = (v0) CollectionsKt___CollectionsKt.i3(vVar.h());
        if (v0Var == null) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(!DescriptorUtilsKt.a(v0Var) && v0Var.t0() == null);
        }
        boolean g2 = f0.g(valueOf, Boolean.TRUE);
        OperatorChecks operatorChecks = OperatorChecks.a;
        if (g2) {
            return null;
        }
        return "last parameter should not have a default value or be a vararg";
    }
}
