package kotlin.reflect.jvm.internal.impl.descriptors;

import h.k2.u.l;
import h.k2.v.f0;
import h.p2.b0.g.t.c.d;
import h.p2.b0.g.t.c.e;
import h.p2.b0.g.t.c.n;
import h.p2.b0.g.t.g.b;
import h.p2.b0.g.t.m.f;
import h.p2.b0.g.t.m.m;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;

/* loaded from: classes3.dex */
public final class NotFoundClasses$classes$1 extends Lambda implements l<NotFoundClasses.a, d> {
    public final /* synthetic */ NotFoundClasses this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotFoundClasses$classes$1(NotFoundClasses notFoundClasses) {
        super(1);
        this.this$0 = notFoundClasses;
    }

    @Override // h.k2.u.l
    @k.e.a.d
    public final d invoke(@k.e.a.d NotFoundClasses.a aVar) {
        m mVar;
        f fVar;
        b a = aVar.a();
        List<Integer> b = aVar.b();
        if (!a.k()) {
            b g2 = a.g();
            n d2 = g2 == null ? null : this.this$0.d(g2, CollectionsKt___CollectionsKt.P1(b, 1));
            if (d2 == null) {
                fVar = this.this$0.f16437c;
                d2 = (e) fVar.invoke(a.h());
            }
            n nVar = d2;
            boolean l2 = a.l();
            mVar = this.this$0.a;
            h.p2.b0.g.t.g.f j2 = a.j();
            Integer num = (Integer) CollectionsKt___CollectionsKt.t2(b);
            return new NotFoundClasses.b(mVar, nVar, j2, l2, num == null ? 0 : num.intValue());
        }
        throw new UnsupportedOperationException(f0.C("Unresolved local class: ", a));
    }
}
