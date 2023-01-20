package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ApplyForReturnActivity$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ ApplyForReturnActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyForReturnActivity$onLoadMore$1(ApplyForReturnActivity applyForReturnActivity) {
        super(2);
        this.this$0 = applyForReturnActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        Integer value = ((ApplyForReturnViewModel) this.this$0.L()).A0().getValue();
        if (value != null && value.intValue() == 2) {
            BinderKt.d(((ApplyForReturnViewModel) this.this$0.L()).t0(state), this.this$0, gVar, true);
        } else {
            BinderKt.d(((ApplyForReturnViewModel) this.this$0.L()).v0(state), this.this$0, gVar, true);
        }
    }
}
