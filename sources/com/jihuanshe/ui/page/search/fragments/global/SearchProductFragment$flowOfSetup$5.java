package com.jihuanshe.ui.page.search.fragments.global;

import com.jihuanshe.model.Rarity;
import e.l.s.m.d.a;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchProductFragment$flowOfSetup$5 extends Lambda implements l<List<? extends Rarity>, t1> {
    public final /* synthetic */ SearchProductFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchProductFragment$flowOfSetup$5(SearchProductFragment searchProductFragment) {
        super(1);
        this.this$0 = searchProductFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends Rarity> list) {
        invoke2((List<Rarity>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d List<Rarity> list) {
        a q0;
        q0 = this.this$0.q0();
        q0.N().r(list);
    }
}
