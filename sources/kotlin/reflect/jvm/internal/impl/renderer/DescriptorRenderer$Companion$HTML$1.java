package kotlin.reflect.jvm.internal.impl.renderer;

import h.k2.u.l;
import h.p2.b0.g.t.j.b;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class DescriptorRenderer$Companion$HTML$1 extends Lambda implements l<b, t1> {
    public static final DescriptorRenderer$Companion$HTML$1 INSTANCE = new DescriptorRenderer$Companion$HTML$1();

    public DescriptorRenderer$Companion$HTML$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(b bVar) {
        invoke2(bVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d b bVar) {
        bVar.g(RenderingFormat.HTML);
        bVar.m(DescriptorRendererModifier.ALL);
    }
}
