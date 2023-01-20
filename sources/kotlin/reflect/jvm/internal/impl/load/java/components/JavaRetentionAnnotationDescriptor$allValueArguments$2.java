package kotlin.reflect.jvm.internal.impl.load.java.components;

import h.a2.s0;
import h.a2.t0;
import h.k2.u.a;
import h.p2.b0.g.t.e.a.t.b;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.k.n.g;
import h.z0;
import java.util.Map;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class JavaRetentionAnnotationDescriptor$allValueArguments$2 extends Lambda implements a<Map<f, ? extends g<?>>> {
    public final /* synthetic */ JavaRetentionAnnotationDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaRetentionAnnotationDescriptor$allValueArguments$2(JavaRetentionAnnotationDescriptor javaRetentionAnnotationDescriptor) {
        super(0);
        this.this$0 = javaRetentionAnnotationDescriptor;
    }

    @Override // h.k2.u.a
    @d
    public final Map<f, ? extends g<?>> invoke() {
        g<?> a = JavaAnnotationTargetMapper.a.a(this.this$0.b());
        Map<f, ? extends g<?>> k2 = a == null ? null : s0.k(z0.a(b.a.c(), a));
        return k2 != null ? k2 : t0.z();
    }
}
