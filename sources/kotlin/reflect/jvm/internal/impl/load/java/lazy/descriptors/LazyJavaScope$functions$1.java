package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.g.f;
import java.util.Collection;
import java.util.LinkedHashSet;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaScope$functions$1 extends Lambda implements l<f, Collection<? extends n0>> {
    public final /* synthetic */ LazyJavaScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$functions$1(LazyJavaScope lazyJavaScope) {
        super(1);
        this.this$0 = lazyJavaScope;
    }

    @Override // h.k2.u.l
    @d
    public final Collection<n0> invoke(@d f fVar) {
        h.p2.b0.g.t.m.f fVar2;
        fVar2 = this.this$0.f16540f;
        LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) fVar2.invoke(fVar));
        this.this$0.M(linkedHashSet);
        this.this$0.s(linkedHashSet, fVar);
        return CollectionsKt___CollectionsKt.I5(this.this$0.x().a().r().e(this.this$0.x(), linkedHashSet));
    }
}
