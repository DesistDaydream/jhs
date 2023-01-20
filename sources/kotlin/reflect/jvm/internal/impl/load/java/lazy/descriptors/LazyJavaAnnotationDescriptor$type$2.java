package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.x.g;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.s;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaAnnotationDescriptor$type$2 extends Lambda implements a<f0> {
    public final /* synthetic */ LazyJavaAnnotationDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaAnnotationDescriptor$type$2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        super(0);
        this.this$0 = lazyJavaAnnotationDescriptor;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final f0 invoke() {
        e eVar;
        h.p2.b0.g.t.e.a.x.a aVar;
        e eVar2;
        h.p2.b0.g.t.e.a.x.a aVar2;
        c e2 = this.this$0.e();
        if (e2 == null) {
            aVar2 = this.this$0.b;
            return s.j(h.k2.v.f0.C("No fqName: ", aVar2));
        }
        h.p2.b0.g.t.b.k.d dVar = h.p2.b0.g.t.b.k.d.a;
        eVar = this.this$0.a;
        h.p2.b0.g.t.c.d h2 = h.p2.b0.g.t.b.k.d.h(dVar, e2, eVar.d().k(), null, 4, null);
        if (h2 == null) {
            aVar = this.this$0.b;
            g t = aVar.t();
            if (t == null) {
                h2 = null;
            } else {
                eVar2 = this.this$0.a;
                h2 = eVar2.a().n().a(t);
            }
            if (h2 == null) {
                h2 = this.this$0.h(e2);
            }
        }
        return h2.r();
    }
}
