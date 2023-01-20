package kotlin.reflect.jvm.internal.impl.resolve.constants;

import h.a2.t;
import h.k2.u.a;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.u0;
import h.p2.b0.g.t.n.w0;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class IntegerLiteralTypeConstructor$supertypes$2 extends Lambda implements a<List<f0>> {
    public final /* synthetic */ IntegerLiteralTypeConstructor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntegerLiteralTypeConstructor$supertypes$2(IntegerLiteralTypeConstructor integerLiteralTypeConstructor) {
        super(0);
        this.this$0 = integerLiteralTypeConstructor;
    }

    @Override // h.k2.u.a
    @d
    public final List<f0> invoke() {
        f0 f0Var;
        boolean m2;
        f0 r = this.this$0.k().x().r();
        Variance variance = Variance.IN_VARIANCE;
        f0Var = this.this$0.f16780d;
        List<f0> P = CollectionsKt__CollectionsKt.P(w0.f(r, t.k(new u0(variance, f0Var)), null, 2, null));
        m2 = this.this$0.m();
        if (!m2) {
            P.add(this.this$0.k().L());
        }
        return P;
    }
}
