package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.g.b;
import h.p2.b0.g.t.g.c;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class LazyJavaAnnotationDescriptor$fqName$2 extends Lambda implements a<c> {
    public final /* synthetic */ LazyJavaAnnotationDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaAnnotationDescriptor$fqName$2(LazyJavaAnnotationDescriptor lazyJavaAnnotationDescriptor) {
        super(0);
        this.this$0 = lazyJavaAnnotationDescriptor;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @e
    public final c invoke() {
        h.p2.b0.g.t.e.a.x.a aVar;
        aVar = this.this$0.b;
        b b = aVar.b();
        if (b == null) {
            return null;
        }
        return b.b();
    }
}
