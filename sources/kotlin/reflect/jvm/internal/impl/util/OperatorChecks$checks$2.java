package kotlin.reflect.jvm.internal.impl.util;

import h.k2.u.l;
import h.p2.b0.g.t.b.f;
import h.p2.b0.g.t.c.d;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.v;
import java.util.Collection;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class OperatorChecks$checks$2 extends Lambda implements l<v, String> {
    public static final OperatorChecks$checks$2 INSTANCE = new OperatorChecks$checks$2();

    public OperatorChecks$checks$2() {
        super(1);
    }

    private static final boolean invoke$isAny(k kVar) {
        return (kVar instanceof d) && f.Z((d) kVar);
    }

    @Override // h.k2.u.l
    @e
    public final String invoke(@k.e.a.d v vVar) {
        boolean z;
        OperatorChecks operatorChecks = OperatorChecks.a;
        boolean z2 = true;
        if (!invoke$isAny(vVar.b())) {
            Collection<? extends v> d2 = vVar.d();
            if (!d2.isEmpty()) {
                for (v vVar2 : d2) {
                    if (invoke$isAny(vVar2.b())) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (!z) {
                z2 = false;
            }
        }
        if (z2) {
            return null;
        }
        return "must override ''equals()'' in Any";
    }
}
