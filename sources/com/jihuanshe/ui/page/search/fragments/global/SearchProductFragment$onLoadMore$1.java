package com.jihuanshe.ui.page.search.fragments.global;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Game;
import com.jihuanshe.viewmodel.search.globals.SearchProductViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.l.s.m.d.a;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchProductFragment$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ SearchProductFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchProductFragment$onLoadMore$1(SearchProductFragment searchProductFragment) {
        super(2);
        this.this$0 = searchProductFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        a q0;
        a q02;
        a q03;
        SearchProductViewModel searchProductViewModel = (SearchProductViewModel) this.this$0.T();
        String type = this.this$0.getType();
        q0 = this.this$0.q0();
        Game value = q0.p0().getValue();
        String gameKey = value == null ? null : value.getGameKey();
        q02 = this.this$0.q0();
        Game value2 = q02.p0().getValue();
        String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
        q03 = this.this$0.q0();
        BinderKt.d(searchProductViewModel.u0(type, gameKey, gameSubKey, q03.s0().getValue(), state), this.this$0, gVar, true);
    }
}
