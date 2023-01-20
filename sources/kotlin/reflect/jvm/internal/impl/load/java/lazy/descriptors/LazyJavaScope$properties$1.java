package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.k.c;
import h.p2.b0.g.t.m.g;
import h.p2.b0.g.t.p.a;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaScope$properties$1 extends Lambda implements l<f, List<? extends j0>> {
    public final /* synthetic */ LazyJavaScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$properties$1(LazyJavaScope lazyJavaScope) {
        super(1);
        this.this$0 = lazyJavaScope;
    }

    @Override // h.k2.u.l
    @d
    public final List<j0> invoke(@d f fVar) {
        g gVar;
        ArrayList arrayList = new ArrayList();
        gVar = this.this$0.f16541g;
        a.a(arrayList, gVar.invoke(fVar));
        this.this$0.t(fVar, arrayList);
        if (c.t(this.this$0.D())) {
            return CollectionsKt___CollectionsKt.I5(arrayList);
        }
        return CollectionsKt___CollectionsKt.I5(this.this$0.x().a().r().e(this.this$0.x(), arrayList));
    }
}
