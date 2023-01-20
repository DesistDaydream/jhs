package kotlin.reflect.jvm.internal.impl.renderer;

import h.k2.u.l;
import h.p2.b0.g.t.n.s0;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class DescriptorRendererImpl$appendTypeProjections$1 extends Lambda implements l<s0, CharSequence> {
    public final /* synthetic */ DescriptorRendererImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DescriptorRendererImpl$appendTypeProjections$1(DescriptorRendererImpl descriptorRendererImpl) {
        super(1);
        this.this$0 = descriptorRendererImpl;
    }

    @Override // h.k2.u.l
    @d
    public final CharSequence invoke(@d s0 s0Var) {
        if (s0Var.b()) {
            return "*";
        }
        String y = this.this$0.y(s0Var.getType());
        if (s0Var.c() == Variance.INVARIANT) {
            return y;
        }
        return s0Var.c() + ' ' + y;
    }
}
