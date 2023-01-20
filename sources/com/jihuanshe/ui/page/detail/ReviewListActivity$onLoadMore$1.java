package com.jihuanshe.ui.page.detail;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Constants;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.t.v.j.g;
import h.k2.u.p;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReviewListActivity$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ ReviewListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReviewListActivity$onLoadMore$1(ReviewListActivity reviewListActivity) {
        super(2);
        this.this$0 = reviewListActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        ReviewListViewModel reviewListViewModel = (ReviewListViewModel) this.this$0.L();
        String type = this.this$0.getType();
        if (type == null) {
            type = "";
        }
        String str = type;
        Integer j0 = this.this$0.j0();
        Integer A0 = this.this$0.A0();
        Pair<String, String> value = ((ReviewListViewModel) this.this$0.L()).B0().getValue();
        BinderKt.d(reviewListViewModel.H0(str, j0, A0, value == null ? null : value.getSecond(), 0, f0.g(this.this$0.getType(), Constants.Companion.getTYPE_CARD()) ? ((ReviewListViewModel) this.this$0.L()).A0().getValue() : null, this.this$0.m0(), this.this$0.n0(), state), this.this$0, gVar, true);
    }
}
