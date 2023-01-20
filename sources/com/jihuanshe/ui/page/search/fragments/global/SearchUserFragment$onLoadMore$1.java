package com.jihuanshe.ui.page.search.fragments.global;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.search.globals.SearchUserViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.l.s.m.c;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchUserFragment$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ SearchUserFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchUserFragment$onLoadMore$1(SearchUserFragment searchUserFragment) {
        super(2);
        this.this$0 = searchUserFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        c m0;
        SearchUserViewModel searchUserViewModel = (SearchUserViewModel) this.this$0.T();
        m0 = this.this$0.m0();
        String value = m0.s0().getValue();
        if (value == null) {
            value = "";
        }
        BinderKt.d(searchUserViewModel.s0(value, state), this.this$0, gVar, true);
    }
}
