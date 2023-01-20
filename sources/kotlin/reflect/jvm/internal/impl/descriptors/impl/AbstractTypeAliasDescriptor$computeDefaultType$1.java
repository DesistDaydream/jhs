package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import h.k2.u.l;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.n.e1.h;
import h.p2.b0.g.t.n.f0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class AbstractTypeAliasDescriptor$computeDefaultType$1 extends Lambda implements l<h, f0> {
    public final /* synthetic */ AbstractTypeAliasDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeAliasDescriptor$computeDefaultType$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        super(1);
        this.this$0 = abstractTypeAliasDescriptor;
    }

    @Override // h.k2.u.l
    public final f0 invoke(h hVar) {
        f e2 = hVar.e(this.this$0);
        if (e2 == null) {
            return null;
        }
        return e2.r();
    }
}
