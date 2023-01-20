package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import h.k2.u.l;
import h.p2.b0.g.t.e.a.y.e;
import h.p2.b0.g.t.e.a.y.i;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$3 extends Lambda implements l<i.a.C0446a, t1> {
    public final /* synthetic */ String $JLObject;
    public final /* synthetic */ String $JUOptional;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PredefinedEnhancementInfoKt$PREDEFINED_FUNCTION_ENHANCEMENT_INFO_BY_SIGNATURE$1$1$6$3(String str, String str2) {
        super(1);
        this.$JLObject = str;
        this.$JUOptional = str2;
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
        String str = this.$JLObject;
        eVar = PredefinedEnhancementInfoKt.a;
        c0446a.c(str, eVar);
        String str2 = this.$JUOptional;
        eVar2 = PredefinedEnhancementInfoKt.b;
        eVar3 = PredefinedEnhancementInfoKt.f16555c;
        c0446a.d(str2, eVar2, eVar3);
    }
}
