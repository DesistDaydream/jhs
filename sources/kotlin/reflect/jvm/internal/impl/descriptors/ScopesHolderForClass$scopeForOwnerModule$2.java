package kotlin.reflect.jvm.internal.impl.descriptors;

import h.k2.u.a;
import h.k2.u.l;
import h.p2.b0.g.t.n.e1.h;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class ScopesHolderForClass$scopeForOwnerModule$2 extends Lambda implements a<T> {
    public final /* synthetic */ ScopesHolderForClass<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScopesHolderForClass$scopeForOwnerModule$2(ScopesHolderForClass<T> scopesHolderForClass) {
        super(0);
        this.this$0 = scopesHolderForClass;
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    @Override // h.k2.u.a
    @d
    public final MemberScope invoke() {
        l lVar;
        h hVar;
        lVar = ((ScopesHolderForClass) this.this$0).b;
        hVar = ((ScopesHolderForClass) this.this$0).f16444c;
        return (MemberScope) lVar.invoke(hVar);
    }
}
