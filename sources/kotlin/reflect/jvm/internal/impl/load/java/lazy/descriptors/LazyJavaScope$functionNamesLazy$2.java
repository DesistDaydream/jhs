package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.g.f;
import java.util.Set;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaScope$functionNamesLazy$2 extends Lambda implements a<Set<? extends f>> {
    public final /* synthetic */ LazyJavaScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$functionNamesLazy$2(LazyJavaScope lazyJavaScope) {
        super(0);
        this.this$0 = lazyJavaScope;
    }

    @Override // h.k2.u.a
    @d
    public final Set<? extends f> invoke() {
        return this.this$0.o(h.p2.b0.g.t.k.r.d.v, null);
    }
}
