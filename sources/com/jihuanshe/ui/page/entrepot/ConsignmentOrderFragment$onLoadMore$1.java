package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.entrepot.ConsignmentOrderChildViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ConsignmentOrderFragment$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ ConsignmentOrderFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsignmentOrderFragment$onLoadMore$1(ConsignmentOrderFragment consignmentOrderFragment) {
        super(2);
        this.this$0 = consignmentOrderFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        Integer l0 = this.this$0.l0();
        if (l0 != null && l0.intValue() == 1) {
            ConsignmentOrderChildViewModel consignmentOrderChildViewModel = (ConsignmentOrderChildViewModel) this.this$0.T();
            String type = this.this$0.getType();
            BinderKt.d(consignmentOrderChildViewModel.q0(type != null ? type : "", state), this.this$0, gVar, true);
            return;
        }
        ConsignmentOrderChildViewModel consignmentOrderChildViewModel2 = (ConsignmentOrderChildViewModel) this.this$0.T();
        String type2 = this.this$0.getType();
        BinderKt.d(consignmentOrderChildViewModel2.t0(type2 != null ? type2 : "", state), this.this$0, gVar, true);
    }
}
