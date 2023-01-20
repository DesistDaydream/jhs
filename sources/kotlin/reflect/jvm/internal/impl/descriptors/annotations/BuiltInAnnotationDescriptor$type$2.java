package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import h.k2.u.a;
import h.p2.b0.g.t.b.f;
import h.p2.b0.g.t.n.f0;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class BuiltInAnnotationDescriptor$type$2 extends Lambda implements a<f0> {
    public final /* synthetic */ BuiltInAnnotationDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuiltInAnnotationDescriptor$type$2(BuiltInAnnotationDescriptor builtInAnnotationDescriptor) {
        super(0);
        this.this$0 = builtInAnnotationDescriptor;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final f0 invoke() {
        f fVar;
        fVar = this.this$0.a;
        return fVar.o(this.this$0.e()).r();
    }
}
