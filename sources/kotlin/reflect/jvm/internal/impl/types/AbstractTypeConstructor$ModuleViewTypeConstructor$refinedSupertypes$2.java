package kotlin.reflect.jvm.internal.impl.types;

import h.k2.u.a;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.e1.i;
import h.p2.b0.g.t.n.z;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;

/* loaded from: classes3.dex */
public final class AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2 extends Lambda implements a<List<? extends z>> {
    public final /* synthetic */ AbstractTypeConstructor.ModuleViewTypeConstructor this$0;
    public final /* synthetic */ AbstractTypeConstructor this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2(AbstractTypeConstructor.ModuleViewTypeConstructor moduleViewTypeConstructor, AbstractTypeConstructor abstractTypeConstructor) {
        super(0);
        this.this$0 = moduleViewTypeConstructor;
        this.this$1 = abstractTypeConstructor;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends z> invoke() {
        h hVar;
        hVar = this.this$0.a;
        return i.b(hVar, this.this$1.j());
    }
}
