package com.jihuanshe.viewmodel.entrepot;

import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.CardConsignmentInfo;
import com.vector.util.Res;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.e;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ConOrderDetailsViewModel$getWarehouseOrderDetail$2 extends Lambda implements l<CardConsignmentInfo, t1> {
    public final /* synthetic */ ConOrderDetailsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConOrderDetailsViewModel$getWarehouseOrderDetail$2(ConOrderDetailsViewModel conOrderDetailsViewModel) {
        super(1);
        this.this$0 = conOrderDetailsViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(CardConsignmentInfo cardConsignmentInfo) {
        invoke2(cardConsignmentInfo);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e CardConsignmentInfo cardConsignmentInfo) {
        Pair<String, String> pair;
        NLive<Pair<String, String>> z0 = this.this$0.z0();
        String status = cardConsignmentInfo == null ? null : cardConsignmentInfo.getStatus();
        if (f0.g(status, "waiting_receive")) {
            Res res = Res.a;
            pair = new Pair<>(Res.w(res, R.string.pending_review, null, 2, null), Res.w(res, R.string.pending_review_desc, null, 2, null));
        } else if (f0.g(status, "complete")) {
            Res res2 = Res.a;
            pair = new Pair<>(Res.w(res2, R.string.order_completed, null, 2, null), Res.w(res2, R.string.order_completed_desc, null, 2, null));
        } else {
            pair = new Pair<>("", "");
        }
        z0.setValue(pair);
    }
}
