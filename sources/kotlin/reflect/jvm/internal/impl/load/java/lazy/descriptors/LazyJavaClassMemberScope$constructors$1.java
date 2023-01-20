package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.a;
import h.k2.v.f0;
import h.p2.b0.g.t.c.c;
import h.p2.b0.g.t.e.a.u.b;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.x.g;
import h.p2.b0.g.t.e.a.x.k;
import h.p2.b0.g.t.e.b.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;

/* loaded from: classes3.dex */
public final class LazyJavaClassMemberScope$constructors$1 extends Lambda implements a<List<? extends c>> {
    public final /* synthetic */ e $c;
    public final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$constructors$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, e eVar) {
        super(0);
        this.this$0 = lazyJavaClassMemberScope;
        this.$c = eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.List] */
    @Override // h.k2.u.a
    @d
    public final List<? extends c> invoke() {
        g gVar;
        g gVar2;
        c e0;
        c f0;
        g gVar3;
        b G0;
        gVar = this.this$0.o;
        Collection<k> g2 = gVar.g();
        ArrayList<c> arrayList = new ArrayList(g2.size());
        for (k kVar : g2) {
            G0 = this.this$0.G0(kVar);
            arrayList.add(G0);
        }
        gVar2 = this.this$0.o;
        if (gVar2.o()) {
            f0 = this.this$0.f0();
            boolean z = false;
            String c2 = r.c(f0, false, false, 2, null);
            if (!arrayList.isEmpty()) {
                for (c cVar : arrayList) {
                    if (f0.g(r.c(cVar, false, false, 2, null), c2)) {
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                arrayList.add(f0);
                h.p2.b0.g.t.e.a.t.d h2 = this.$c.a().h();
                gVar3 = this.this$0.o;
                h2.a(gVar3, f0);
            }
        }
        this.$c.a().w().b(this.this$0.D(), arrayList);
        SignatureEnhancement r = this.$c.a().r();
        e eVar = this.$c;
        LazyJavaClassMemberScope lazyJavaClassMemberScope = this.this$0;
        boolean isEmpty = arrayList.isEmpty();
        ArrayList arrayList2 = arrayList;
        if (isEmpty) {
            e0 = lazyJavaClassMemberScope.e0();
            arrayList2 = CollectionsKt__CollectionsKt.M(e0);
        }
        return CollectionsKt___CollectionsKt.I5(r.e(eVar, arrayList2));
    }
}
