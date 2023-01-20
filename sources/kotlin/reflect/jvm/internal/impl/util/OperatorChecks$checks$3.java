package kotlin.reflect.jvm.internal.impl.util;

import h.k2.u.l;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.n.z;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class OperatorChecks$checks$3 extends Lambda implements l<v, String> {
    public static final OperatorChecks$checks$3 INSTANCE = new OperatorChecks$checks$3();

    public OperatorChecks$checks$3() {
        super(1);
    }

    @Override // h.k2.u.l
    @e
    public final String invoke(@d v vVar) {
        m0 M = vVar.M();
        if (M == null) {
            M = vVar.Q();
        }
        OperatorChecks operatorChecks = OperatorChecks.a;
        boolean z = false;
        if (M != null) {
            z returnType = vVar.getReturnType();
            if (returnType == null ? false : TypeUtilsKt.l(returnType, M.getType())) {
                z = true;
            }
        }
        if (z) {
            return null;
        }
        return "receiver must be a supertype of the return type";
    }
}
