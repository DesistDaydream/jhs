package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.a2.e1;
import h.k2.u.a;
import h.p2.b0.g.t.g.f;
import java.util.Set;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1 extends Lambda implements a<Set<? extends f>> {
    public final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(0);
        this.this$0 = lazyJavaClassMemberScope;
    }

    @Override // h.k2.u.a
    @d
    public final Set<? extends f> invoke() {
        return e1.C(this.this$0.b(), this.this$0.d());
    }
}
