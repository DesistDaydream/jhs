package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.c.d1.m;
import h.p2.b0.g.t.e.a.i;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.x.g;
import h.p2.b0.g.t.e.a.x.n;
import h.p2.b0.g.t.g.b;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.m.h;
import java.util.Map;
import java.util.Set;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes3.dex */
public final class LazyJavaClassMemberScope$nestedClasses$1 extends Lambda implements l<f, h.p2.b0.g.t.c.d1.f> {
    public final /* synthetic */ e $c;
    public final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$nestedClasses$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, e eVar) {
        super(1);
        this.this$0 = lazyJavaClassMemberScope;
        this.$c = eVar;
    }

    @Override // h.k2.u.l
    @k.e.a.e
    public final h.p2.b0.g.t.c.d1.f invoke(@d f fVar) {
        h hVar;
        g gVar;
        h hVar2;
        hVar = this.this$0.r;
        if (!((Set) hVar.invoke()).contains(fVar)) {
            hVar2 = this.this$0.s;
            n nVar = (n) ((Map) hVar2.invoke()).get(fVar);
            if (nVar != null) {
                return m.H0(this.$c.e(), this.this$0.D(), fVar, this.$c.e().c(new LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1(this.this$0)), h.p2.b0.g.t.e.a.v.d.a(this.$c, nVar), this.$c.a().t().a(nVar));
            }
            return null;
        }
        i d2 = this.$c.a().d();
        b d3 = DescriptorUtilsKt.h(this.this$0.D()).d(fVar);
        gVar = this.this$0.o;
        g a = d2.a(new i.a(d3, null, gVar, 2, null));
        if (a == null) {
            return null;
        }
        e eVar = this.$c;
        LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(eVar, this.this$0.D(), a, null, 8, null);
        eVar.a().e().a(lazyJavaClassDescriptor);
        return lazyJavaClassDescriptor;
    }
}
