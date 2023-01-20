package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import h.k2.u.l;
import h.p2.b0.g.t.n.c1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class AbstractTypeAliasDescriptor$isInner$1 extends Lambda implements l<c1, Boolean> {
    public final /* synthetic */ AbstractTypeAliasDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeAliasDescriptor$isInner$1(AbstractTypeAliasDescriptor abstractTypeAliasDescriptor) {
        super(1);
        this.this$0 = abstractTypeAliasDescriptor;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
        if (((r5 instanceof h.p2.b0.g.t.c.t0) && !h.k2.v.f0.g(((h.p2.b0.g.t.c.t0) r5).b(), r0)) != false) goto L9;
     */
    @Override // h.k2.u.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Boolean invoke(h.p2.b0.g.t.n.c1 r5) {
        /*
            r4 = this;
            boolean r0 = h.p2.b0.g.t.n.a0.a(r5)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L28
            kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor r0 = r4.this$0
            h.p2.b0.g.t.n.q0 r5 = r5.I0()
            h.p2.b0.g.t.c.f r5 = r5.c()
            boolean r3 = r5 instanceof h.p2.b0.g.t.c.t0
            if (r3 == 0) goto L24
            h.p2.b0.g.t.c.t0 r5 = (h.p2.b0.g.t.c.t0) r5
            h.p2.b0.g.t.c.k r5 = r5.b()
            boolean r5 = h.k2.v.f0.g(r5, r0)
            if (r5 != 0) goto L24
            r5 = 1
            goto L25
        L24:
            r5 = 0
        L25:
            if (r5 == 0) goto L28
            goto L29
        L28:
            r1 = 0
        L29:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor$isInner$1.invoke(h.p2.b0.g.t.n.c1):java.lang.Boolean");
    }
}
