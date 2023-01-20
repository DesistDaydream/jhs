package kotlin.reflect.jvm.internal.impl.renderer;

import h.a2.e1;
import h.a2.t;
import h.k2.u.a;
import h.k2.u.l;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.j.b;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class DescriptorRendererImpl$functionTypeAnnotationsRenderer$2 extends Lambda implements a<DescriptorRendererImpl> {
    public final /* synthetic */ DescriptorRendererImpl this$0;

    /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$functionTypeAnnotationsRenderer$2$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements l<b, t1> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(b bVar) {
            invoke2(bVar);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d b bVar) {
            bVar.l(e1.C(bVar.i(), t.k(g.a.C)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DescriptorRendererImpl$functionTypeAnnotationsRenderer$2(DescriptorRendererImpl descriptorRendererImpl) {
        super(0);
        this.this$0 = descriptorRendererImpl;
    }

    @Override // h.k2.u.a
    @d
    public final DescriptorRendererImpl invoke() {
        return (DescriptorRendererImpl) this.this$0.A(AnonymousClass1.INSTANCE);
    }
}
