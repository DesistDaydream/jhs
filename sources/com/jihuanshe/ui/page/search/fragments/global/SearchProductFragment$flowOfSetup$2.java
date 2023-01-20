package com.jihuanshe.ui.page.search.fragments.global;

import com.jihuanshe.viewmodel.search.globals.SearchProductViewModel;
import e.l.s.m.c;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchProductFragment$flowOfSetup$2 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ SearchProductFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchProductFragment$flowOfSetup$2(SearchProductFragment searchProductFragment) {
        super(1);
        this.this$0 = searchProductFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        c r0;
        Integer k0;
        c r02;
        c r03;
        r0 = this.this$0.r0();
        if (r0.s0().getValue() == null || (k0 = this.this$0.k0()) == null || i2 != k0.intValue()) {
            return;
        }
        String r04 = ((SearchProductViewModel) this.this$0.T()).r0();
        r02 = this.this$0.r0();
        if (f0.g(r04, r02.s0().getValue())) {
            return;
        }
        SearchProductViewModel searchProductViewModel = (SearchProductViewModel) this.this$0.T();
        r03 = this.this$0.r0();
        String value = r03.s0().getValue();
        if (value == null) {
            value = "";
        }
        searchProductViewModel.w0(value);
        this.this$0.s0();
    }
}
