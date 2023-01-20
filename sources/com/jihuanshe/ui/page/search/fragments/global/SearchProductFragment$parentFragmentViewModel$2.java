package com.jihuanshe.ui.page.search.fragments.global;

import androidx.lifecycle.ViewModelProvider;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchProductFragment$parentFragmentViewModel$2 extends Lambda implements a<e.l.s.m.d.a> {
    public final /* synthetic */ SearchProductFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchProductFragment$parentFragmentViewModel$2(SearchProductFragment searchProductFragment) {
        super(0);
        this.this$0 = searchProductFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final e.l.s.m.d.a invoke() {
        return (e.l.s.m.d.a) new ViewModelProvider(this.this$0.requireParentFragment()).get(e.l.s.m.d.a.class);
    }
}
