package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.entrepot.SearchSoldViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchSoldFragment$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ SearchSoldFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchSoldFragment$onLoadMore$1(SearchSoldFragment searchSoldFragment) {
        super(2);
        this.this$0 = searchSoldFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        BinderKt.p(BinderKt.d(((SearchSoldViewModel) this.this$0.T()).q0(Integer.valueOf(this.this$0.getType()), this.this$0.l0().s0().getValue(), state), this.this$0, gVar, true));
    }
}