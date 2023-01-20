package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.g.b;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes3.dex */
public final class LazyJavaClassDescriptor$moduleAnnotations$2 extends Lambda implements a<List<? extends h.p2.b0.g.t.e.a.x.a>> {
    public final /* synthetic */ LazyJavaClassDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassDescriptor$moduleAnnotations$2(LazyJavaClassDescriptor lazyJavaClassDescriptor) {
        super(0);
        this.this$0 = lazyJavaClassDescriptor;
    }

    @Override // h.k2.u.a
    @e
    public final List<? extends h.p2.b0.g.t.e.a.x.a> invoke() {
        b h2 = DescriptorUtilsKt.h(this.this$0);
        if (h2 == null) {
            return null;
        }
        return this.this$0.N0().a().f().a(h2);
    }
}
