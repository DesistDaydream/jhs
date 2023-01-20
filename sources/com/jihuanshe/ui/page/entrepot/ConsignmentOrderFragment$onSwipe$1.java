package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.entrepot.ConsignmentOrderChildViewModel;
import com.vector.ext.AnyKt;
import e.t.v.j.g;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ConsignmentOrderFragment$onSwipe$1 extends Lambda implements l<g<?>, t1> {
    public final /* synthetic */ ConsignmentOrderFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsignmentOrderFragment$onSwipe$1(ConsignmentOrderFragment consignmentOrderFragment) {
        super(1);
        this.this$0 = consignmentOrderFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar) {
        invoke2(gVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar) {
        String type = this.this$0.getType();
        if ((type == null || type.length() == 0) || AnyKt.l(this.this$0.l0())) {
            return;
        }
        Integer l0 = this.this$0.l0();
        if (l0 != null && l0.intValue() == 1) {
            ConsignmentOrderChildViewModel consignmentOrderChildViewModel = (ConsignmentOrderChildViewModel) this.this$0.T();
            String type2 = this.this$0.getType();
            BinderKt.p(BinderKt.e(ConsignmentOrderChildViewModel.r0(consignmentOrderChildViewModel, type2 != null ? type2 : "", null, 2, null), this.this$0, gVar, false, 4, null));
            return;
        }
        ConsignmentOrderChildViewModel consignmentOrderChildViewModel2 = (ConsignmentOrderChildViewModel) this.this$0.T();
        String type3 = this.this$0.getType();
        BinderKt.p(BinderKt.e(ConsignmentOrderChildViewModel.u0(consignmentOrderChildViewModel2, type3 != null ? type3 : "", null, 2, null), this.this$0, gVar, false, 4, null));
    }
}
