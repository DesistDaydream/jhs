package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import h.k2.u.a;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.v;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class GivenFunctionsMemberScope$allDescriptors$2 extends Lambda implements a<List<? extends k>> {
    public final /* synthetic */ GivenFunctionsMemberScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GivenFunctionsMemberScope$allDescriptors$2(GivenFunctionsMemberScope givenFunctionsMemberScope) {
        super(0);
        this.this$0 = givenFunctionsMemberScope;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends k> invoke() {
        List k2;
        List<v> j2 = this.this$0.j();
        k2 = this.this$0.k(j2);
        return CollectionsKt___CollectionsKt.q4(j2, k2);
    }
}
