package kotlin.reflect.jvm.internal.impl.types;

import h.k2.u.l;
import h.p2.b0.g.t.n.z;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2 extends Lambda implements l<z, t1> {
    public final /* synthetic */ AbstractTypeConstructor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2(AbstractTypeConstructor abstractTypeConstructor) {
        super(1);
        this.this$0 = abstractTypeConstructor;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(z zVar) {
        invoke2(zVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d z zVar) {
        this.this$0.t(zVar);
    }
}
