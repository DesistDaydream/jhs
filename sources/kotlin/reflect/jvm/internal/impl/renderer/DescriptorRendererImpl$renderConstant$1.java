package kotlin.reflect.jvm.internal.impl.renderer;

import h.k2.u.l;
import h.p2.b0.g.t.k.n.g;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class DescriptorRendererImpl$renderConstant$1 extends Lambda implements l<g<?>, CharSequence> {
    public final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DescriptorRendererImpl$renderConstant$1(DescriptorRendererImpl descriptorRendererImpl) {
        super(1);
        this.this$0 = descriptorRendererImpl;
    }

    @Override // h.k2.u.l
    @d
    public final CharSequence invoke(@d g<?> gVar) {
        String e1;
        e1 = this.this$0.e1(gVar);
        return e1;
    }
}
