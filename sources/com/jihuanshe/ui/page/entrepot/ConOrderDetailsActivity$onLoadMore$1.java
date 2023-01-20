package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ConOrderDetailsActivity$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ ConOrderDetailsActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConOrderDetailsActivity$onLoadMore$1(ConOrderDetailsActivity conOrderDetailsActivity) {
        super(2);
        this.this$0 = conOrderDetailsActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        Integer j0 = this.this$0.j0();
        if (j0 != null && j0.intValue() == 1) {
            BinderKt.p(BinderKt.d(((ConOrderDetailsViewModel) this.this$0.L()).C0(this.this$0.i0().intValue(), state), this.this$0, gVar, true));
        } else {
            BinderKt.p(BinderKt.d(((ConOrderDetailsViewModel) this.this$0.L()).x0(this.this$0.i0().intValue(), state), this.this$0, gVar, true));
        }
    }
}
