package com.jihuanshe.ui.page.user.selling;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.user.selling.SellingChildViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingChildFragment$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ SellingChildFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingChildFragment$onLoadMore$1(SellingChildFragment sellingChildFragment) {
        super(2);
        this.this$0 = sellingChildFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        SellingChildViewModel sellingChildViewModel = (SellingChildViewModel) this.this$0.T();
        int intValue = this.this$0.getType().intValue();
        String value = this.this$0.m0().q0().getValue();
        Pair<String, String> value2 = this.this$0.m0().v0().getValue();
        BinderKt.d(sellingChildViewModel.C0(intValue, value, value2 == null ? null : value2.getSecond(), state), this.this$0, gVar, true);
    }
}
