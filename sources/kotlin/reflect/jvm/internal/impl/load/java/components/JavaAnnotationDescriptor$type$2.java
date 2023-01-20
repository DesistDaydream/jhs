package kotlin.reflect.jvm.internal.impl.load.java.components;

import h.k2.u.a;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.n.f0;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class JavaAnnotationDescriptor$type$2 extends Lambda implements a<f0> {
    public final /* synthetic */ e $c;
    public final /* synthetic */ JavaAnnotationDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaAnnotationDescriptor$type$2(e eVar, JavaAnnotationDescriptor javaAnnotationDescriptor) {
        super(0);
        this.$c = eVar;
        this.this$0 = javaAnnotationDescriptor;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final f0 invoke() {
        return this.$c.d().k().o(this.this$0.e()).r();
    }
}
