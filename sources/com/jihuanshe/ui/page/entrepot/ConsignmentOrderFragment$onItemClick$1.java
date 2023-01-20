package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.model.CardConsignmentInfo;
import com.jihuanshe.model.Constants;
import com.jihuanshe.viewmodel.entrepot.ConsignmentOrderChildViewModel;
import h.k2.u.p;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ConsignmentOrderFragment$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ ConsignmentOrderFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsignmentOrderFragment$onItemClick$1(ConsignmentOrderFragment consignmentOrderFragment) {
        super(2);
        this.this$0 = consignmentOrderFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        int warehouseReturnOrderId;
        List<CardConsignmentInfo> value = ((ConsignmentOrderChildViewModel) this.this$0.T()).s0().getValue();
        CardConsignmentInfo cardConsignmentInfo = value == null ? null : (CardConsignmentInfo) CollectionsKt___CollectionsKt.J2(value, i2);
        if (cardConsignmentInfo == null) {
            return;
        }
        Integer l0 = this.this$0.l0();
        if (l0 != null && l0.intValue() == 1) {
            warehouseReturnOrderId = cardConsignmentInfo.getWarehouseOrderId();
        } else {
            warehouseReturnOrderId = cardConsignmentInfo.getWarehouseReturnOrderId();
        }
        if (f0.g(this.this$0.getType(), Constants.STATE_WAITING_PAY)) {
            SubmitOrderReturnActivityCreator.create(Integer.valueOf(warehouseReturnOrderId)).start(this.this$0.getActivity());
        } else {
            ConOrderDetailsActivityCreator.create(Integer.valueOf(warehouseReturnOrderId), this.this$0.l0()).start(this.this$0.getContext());
        }
    }
}
