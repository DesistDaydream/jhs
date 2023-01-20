package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.x.g;
import h.p2.b0.g.t.n.e1.h;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaClassDescriptor$scopeHolder$1 extends Lambda implements l<h, LazyJavaClassMemberScope> {
    public final /* synthetic */ LazyJavaClassDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassDescriptor$scopeHolder$1(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(1);
        this.this$0 = lazyJavaClassDescriptor;
    }

    @Override // h.k2.u.l
    @d
    public final LazyJavaClassMemberScope invoke(@d h hVar) {
        LazyJavaClassMemberScope lazyJavaClassMemberScope;
        e eVar = this.this$0.f16525m;
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.this$0;
        g L0 = lazyJavaClassDescriptor.L0();
        boolean z = this.this$0.f16524l != null;
        lazyJavaClassMemberScope = this.this$0.t;
        return new LazyJavaClassMemberScope(eVar, lazyJavaClassDescriptor, L0, z, lazyJavaClassMemberScope);
    }
}
