package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.c.k;
import java.util.Collection;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class LazyJavaScope$allDescriptors$1 extends Lambda implements a<Collection<? extends k>> {
    public final /* synthetic */ LazyJavaScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaScope$allDescriptors$1(LazyJavaScope lazyJavaScope) {
        super(0);
        this.this$0 = lazyJavaScope;
    }

    @Override // h.k2.u.a
    @d
    public final Collection<? extends k> invoke() {
        return this.this$0.n(h.p2.b0.g.t.k.r.d.o, MemberScope.a.a());
    }
}
