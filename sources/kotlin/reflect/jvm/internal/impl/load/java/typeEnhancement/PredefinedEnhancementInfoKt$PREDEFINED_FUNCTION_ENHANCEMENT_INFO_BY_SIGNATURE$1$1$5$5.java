package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import h.k2.u.l;
import h.p2.b0.g.t.e.a.y.e;
import h.p2.b0.g.t.e.a.y.i;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$5 extends Lambda implements l<i.a.C0446a, t1> {
    public final /* synthetic */ String $JFBiFunction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$5$5(String str) {
        super(1);
        this.$JFBiFunction = str;
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
        e eVar3;
        e eVar4;
        String str = this.$JFBiFunction;
        eVar = PredefinedEnhancementInfoKt.b;
        eVar2 = PredefinedEnhancementInfoKt.b;
        eVar3 = PredefinedEnhancementInfoKt.b;
        eVar4 = PredefinedEnhancementInfoKt.b;
        c0446a.c(str, eVar, eVar2, eVar3, eVar4);
    }
}
