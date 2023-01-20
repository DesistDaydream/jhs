package kotlin.reflect.jvm.internal.impl.types;

import h.k2.u.a;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.z;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyWrappedType$refine$1 extends Lambda implements a<z> {
    public final /* synthetic */ h $kotlinTypeRefiner;
    public final /* synthetic */ LazyWrappedType this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyWrappedType$refine$1(h hVar, LazyWrappedType lazyWrappedType) {
        super(0);
        this.$kotlinTypeRefiner = hVar;
        this.this$0 = lazyWrappedType;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final z invoke() {
        a aVar;
        h hVar = this.$kotlinTypeRefiner;
        aVar = this.this$0.f16871c;
        return hVar.g((z) aVar.invoke());
    }
}
