package com.jihuanshe.ui.page.order;

import android.view.View;
import com.jihuanshe.model.SellerOrderInfo;
import com.jihuanshe.viewmodel.order.SellerOrderListViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerOrderListFragment$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ SellerOrderListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerOrderListFragment$onItemClick$1(SellerOrderListFragment sellerOrderListFragment) {
        super(2);
        this.this$0 = sellerOrderListFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<SellerOrderInfo> value = ((SellerOrderListViewModel) this.this$0.T()).r0().getValue();
        SellerOrderInfo sellerOrderInfo = value == null ? null : (SellerOrderInfo) CollectionsKt___CollectionsKt.J2(value, i2);
        if (sellerOrderInfo == null) {
            return;
        }
        SellerOrderDetailActivityCreator.create(Integer.valueOf(sellerOrderInfo.getId())).start(this.this$0.getActivity());
    }
}
