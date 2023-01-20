package com.jihuanshe.ui.page.search.fragments.global;

import com.jihuanshe.ui.widget.RarityFilterBtn;
import e.l.s.m.d.a;
import e.n.i;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GlobalSearchProductFragment$flowOfSetup$1 extends Lambda implements l<String, t1> {
    public final /* synthetic */ GlobalSearchProductFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSearchProductFragment$flowOfSetup$1(GlobalSearchProductFragment globalSearchProductFragment) {
        super(1);
        this.this$0 = globalSearchProductFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(String str) {
        invoke2(str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d String str) {
        RarityFilterBtn m0;
        ((a) this.this$0.T()).N().r(CollectionsKt__CollectionsKt.E());
        ((a) this.this$0.T()).s0().r(null);
        i u0 = ((a) this.this$0.T()).u0();
        Integer value = ((a) this.this$0.T()).r0().getValue();
        u0.setValue(Boolean.valueOf((value == null || value.intValue() != 1) && ((a) this.this$0.T()).p0().getValue() != null));
        m0 = this.this$0.m0();
        m0.g(false);
    }
}
