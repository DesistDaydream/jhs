package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import h.a2.u;
import h.k2.u.a;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.d1.e0;
import h.p2.b0.g.t.k.r.b;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class LazyPackageViewDescriptorImpl$memberScope$1 extends Lambda implements a<MemberScope> {
    public final /* synthetic */ LazyPackageViewDescriptorImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl$memberScope$1(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        super(0);
        this.this$0 = lazyPackageViewDescriptorImpl;
    }

    @Override // h.k2.u.a
    @d
    public final MemberScope invoke() {
        if (this.this$0.isEmpty()) {
            return MemberScope.b.b;
        }
        List<b0> g0 = this.this$0.g0();
        ArrayList arrayList = new ArrayList(u.Y(g0, 10));
        for (b0 b0Var : g0) {
            arrayList.add(b0Var.q());
        }
        List r4 = CollectionsKt___CollectionsKt.r4(arrayList, new e0(this.this$0.y0(), this.this$0.e()));
        b.a aVar = b.f15478d;
        return aVar.a("package view scope for " + this.this$0.e() + " in " + this.this$0.y0().getName(), r4);
    }
}
