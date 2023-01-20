package com.jihuanshe.ui.page.user;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.user.FollowViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FollowActivity$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ FollowActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowActivity$onLoadMore$1(FollowActivity followActivity) {
        super(2);
        this.this$0 = followActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        FollowViewModel followViewModel = (FollowViewModel) this.this$0.L();
        Integer g0 = this.this$0.g0();
        BinderKt.d(followViewModel.r0(g0 == null ? 0 : g0.intValue(), this.this$0.Z(), state), this.this$0, gVar, true);
    }
}
