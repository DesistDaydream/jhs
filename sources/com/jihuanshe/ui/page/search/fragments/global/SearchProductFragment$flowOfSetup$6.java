package com.jihuanshe.ui.page.search.fragments.global;

import com.jihuanshe.viewmodel.search.globals.SearchProductViewModel;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchProductFragment$flowOfSetup$6 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ SearchProductFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchProductFragment$flowOfSetup$6(SearchProductFragment searchProductFragment) {
        super(1);
        this.this$0 = searchProductFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        if (((SearchProductViewModel) this.this$0.T()).r0().length() > 0) {
            this.this$0.s0();
        }
    }
}
