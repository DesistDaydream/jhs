package com.jihuanshe.ui.page.user;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.user.FansViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FansActivity$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ FansActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FansActivity$onLoadMore$1(FansActivity fansActivity) {
        super(2);
        this.this$0 = fansActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        FansViewModel fansViewModel = (FansViewModel) this.this$0.L();
        Integer d0 = this.this$0.d0();
        BinderKt.d(fansViewModel.s0(d0 == null ? 0 : d0.intValue(), state), this.this$0, gVar, true);
    }
}
