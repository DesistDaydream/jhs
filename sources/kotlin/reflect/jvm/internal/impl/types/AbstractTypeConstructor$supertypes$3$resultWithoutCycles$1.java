package kotlin.reflect.jvm.internal.impl.types;

import h.k2.u.l;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.z;
import java.util.Collection;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1 extends Lambda implements l<q0, Iterable<? extends z>> {
    public final /* synthetic */ AbstractTypeConstructor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1(AbstractTypeConstructor abstractTypeConstructor) {
        super(1);
        this.this$0 = abstractTypeConstructor;
    }

    @Override // h.k2.u.l
    @d
    public final Iterable<z> invoke(@d q0 q0Var) {
        Collection g2;
        g2 = this.this$0.g(q0Var, false);
        return g2;
    }
}
