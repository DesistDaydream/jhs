package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import h.k2.u.l;
import h.p2.b0.g.t.e.a.y.e;
import h.p2.b0.g.t.e.a.y.i;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;

/* loaded from: classes3.dex */
public final class PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$2$1 extends Lambda implements l<i.a.C0446a, t1> {
    public final /* synthetic */ SignatureBuildingComponents $this_signatures;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$2$1(SignatureBuildingComponents signatureBuildingComponents) {
        super(1);
        this.$this_signatures = signatureBuildingComponents;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(i.a.C0446a c0446a) {
        invoke2(c0446a);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d i.a.C0446a c0446a) {
        e eVar;
        e eVar2;
        String i2 = this.$this_signatures.i("Spliterator");
        eVar = PredefinedEnhancementInfoKt.b;
        eVar2 = PredefinedEnhancementInfoKt.b;
        c0446a.d(i2, eVar, eVar2);
    }
}
