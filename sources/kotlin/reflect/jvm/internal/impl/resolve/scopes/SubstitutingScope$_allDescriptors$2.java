package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import h.k2.u.a;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.k.r.h;
import java.util.Collection;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class SubstitutingScope$_allDescriptors$2 extends Lambda implements a<Collection<? extends k>> {
    public final /* synthetic */ SubstitutingScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubstitutingScope$_allDescriptors$2(SubstitutingScope substitutingScope) {
        super(0);
        this.this$0 = substitutingScope;
    }

    @Override // h.k2.u.a
    @d
    public final Collection<? extends k> invoke() {
        MemberScope memberScope;
        Collection<? extends k> l2;
        SubstitutingScope substitutingScope = this.this$0;
        memberScope = substitutingScope.b;
        l2 = substitutingScope.l(h.a.a(memberScope, null, null, 3, null));
        return l2;
    }
}
