package com.jihuanshe.ui.page.search.fragments.cardrepo;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardPackage;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.s.m.c;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardRepoSearchFragment$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ CardRepoSearchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardRepoSearchFragment$onLoadMore$1(CardRepoSearchFragment cardRepoSearchFragment) {
        super(2);
        this.this$0 = cardRepoSearchFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        c u0;
        CardRepoSearchViewModel cardRepoSearchViewModel = (CardRepoSearchViewModel) this.this$0.T();
        Game value = GameBar.b.a().getValue();
        CardPackage m0 = this.this$0.m0();
        u0 = this.this$0.u0();
        String value2 = u0.s0().getValue();
        if (value2 == null) {
            value2 = "";
        }
        a<?> t0 = cardRepoSearchViewModel.t0(value, m0, value2, state);
        if (t0 == null) {
            return;
        }
        BinderKt.d(t0, this.this$0, gVar, true);
    }
}
