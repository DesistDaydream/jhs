package kotlin.reflect.jvm.internal.impl.descriptors;

import h.k2.u.a;
import h.k2.u.l;
import h.p2.b0.g.t.n.e1.h;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class ScopesHolderForClass$getScope$1 extends Lambda implements a<T> {
    public final /* synthetic */ h $kotlinTypeRefiner;
    public final /* synthetic */ ScopesHolderForClass<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScopesHolderForClass$getScope$1(ScopesHolderForClass<T> scopesHolderForClass, h hVar) {
        super(0);
        this.this$0 = scopesHolderForClass;
        this.$kotlinTypeRefiner = hVar;
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    @Override // h.k2.u.a
    @d
    public final MemberScope invoke() {
        l lVar;
        lVar = ((ScopesHolderForClass) this.this$0).b;
        return (MemberScope) lVar.invoke(this.$kotlinTypeRefiner);
    }
}
