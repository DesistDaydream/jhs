package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.e.a.x.r;
import h.p2.b0.g.t.g.f;
import java.util.ArrayList;
import java.util.Collection;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;

/* loaded from: classes3.dex */
public final class LazyJavaScope$declaredFunctions$1 extends Lambda implements l<f, Collection<? extends n0>> {
    public final /* synthetic */ LazyJavaScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$declaredFunctions$1(LazyJavaScope lazyJavaScope) {
        super(1);
        this.this$0 = lazyJavaScope;
    }

    @Override // h.k2.u.l
    @d
    public final Collection<n0> invoke(@d f fVar) {
        h.p2.b0.g.t.m.f fVar2;
        if (this.this$0.C() != null) {
            fVar2 = this.this$0.C().f16540f;
            return (Collection) fVar2.invoke(fVar);
        }
        ArrayList arrayList = new ArrayList();
        for (r rVar : this.this$0.z().invoke().d(fVar)) {
            JavaMethodDescriptor J = this.this$0.J(rVar);
            if (this.this$0.H(J)) {
                this.this$0.x().a().h().c(rVar, J);
                arrayList.add(J);
            }
        }
        this.this$0.p(arrayList, fVar);
        return arrayList;
    }
}
