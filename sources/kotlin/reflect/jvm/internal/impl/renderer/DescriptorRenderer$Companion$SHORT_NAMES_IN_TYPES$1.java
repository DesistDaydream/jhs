package kotlin.reflect.jvm.internal.impl.renderer;

import h.k2.u.l;
import h.p2.b0.g.t.j.a;
import h.p2.b0.g.t.j.b;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1 extends Lambda implements l<b, t1> {
    public static final DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1 INSTANCE = new DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1();

    public DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(b bVar) {
        invoke2(bVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d b bVar) {
        bVar.o(a.b.a);
        bVar.b(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
    }
}
