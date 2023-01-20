package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyScopeAdapter$lazyScope$1 extends Lambda implements a<MemberScope> {
    public final /* synthetic */ a<MemberScope> $getScope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyScopeAdapter$lazyScope$1(a<? extends MemberScope> aVar) {
        super(0);
        this.$getScope = aVar;
    }

    @Override // h.k2.u.a
    @d
    public final MemberScope invoke() {
        MemberScope invoke = this.$getScope.invoke();
        return invoke instanceof h.p2.b0.g.t.k.r.a ? ((h.p2.b0.g.t.k.r.a) invoke).i() : invoke;
    }
}
