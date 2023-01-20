package com.jihuanshe.ui.page.search.fragments.wantcard;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.user.WantCardListViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchWantCardListFragment$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ SearchWantCardListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchWantCardListFragment$onLoadMore$1(SearchWantCardListFragment searchWantCardListFragment) {
        super(2);
        this.this$0 = searchWantCardListFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        String str;
        WantCardListViewModel wantCardListViewModel = (WantCardListViewModel) this.this$0.T();
        Integer i0 = this.this$0.i0();
        int intValue = i0 == null ? 0 : i0.intValue();
        str = this.this$0.x;
        BinderKt.d(wantCardListViewModel.u0(intValue, str, state), this.this$0, gVar, true);
    }
}
