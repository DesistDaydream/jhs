package com.jihuanshe.ui.page.search.fragments.global;

import com.jihuanshe.model.Game;
import com.jihuanshe.viewmodel.search.globals.SearchProductViewModel;
import e.l.s.m.d.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchProductFragment$flowOfSetup$3 extends Lambda implements l<Game, t1> {
    public final /* synthetic */ SearchProductFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchProductFragment$flowOfSetup$3(SearchProductFragment searchProductFragment) {
        super(1);
        this.this$0 = searchProductFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Game game) {
        invoke2(game);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Game game) {
        a q0;
        q0 = this.this$0.q0();
        if (f0.g(q0.r0().getValue(), this.this$0.k0())) {
            this.this$0.s0();
        } else {
            ((SearchProductViewModel) this.this$0.T()).w0("");
        }
    }
}
