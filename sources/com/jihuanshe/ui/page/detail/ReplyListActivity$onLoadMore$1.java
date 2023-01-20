package com.jihuanshe.ui.page.detail;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.detail.ReplyListViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ReplyListActivity$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ ReplyListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReplyListActivity$onLoadMore$1(ReplyListActivity replyListActivity) {
        super(2);
        this.this$0 = replyListActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        ReplyListViewModel replyListViewModel = (ReplyListViewModel) this.this$0.L();
        int intValue = this.this$0.x0().intValue();
        Pair<String, String> value = this.this$0.y0().B0().getValue();
        BinderKt.d(replyListViewModel.C0(intValue, value == null ? null : value.getSecond(), state), this.this$0, gVar, true);
    }
}
