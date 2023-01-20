package kotlin.reflect.jvm.internal.impl.builtins;

import h.k2.u.a;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.g.c;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class PrimitiveType$arrayTypeFqName$2 extends Lambda implements a<c> {
    public final /* synthetic */ PrimitiveType this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrimitiveType$arrayTypeFqName$2(PrimitiveType primitiveType) {
        super(0);
        this.this$0 = primitiveType;
    }

    @Override // h.k2.u.a
    @d
    public final c invoke() {
        return g.n.c(this.this$0.getArrayTypeName());
    }
}
