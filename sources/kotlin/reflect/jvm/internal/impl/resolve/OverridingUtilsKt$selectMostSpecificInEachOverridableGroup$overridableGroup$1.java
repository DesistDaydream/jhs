package kotlin.reflect.jvm.internal.impl.resolve;

import h.k2.u.l;
import h.p2.b0.g.t.p.e;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1 extends Lambda implements l<H, t1> {
    public final /* synthetic */ e<H> $conflictedHandles;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1(e<H> eVar) {
        super(1);
        this.$conflictedHandles = eVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Object obj) {
        invoke2((OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1) obj);
        return t1.a;
    }

    @Override // h.k2.u.l
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(H h2) {
        this.$conflictedHandles.add(h2);
    }
}
