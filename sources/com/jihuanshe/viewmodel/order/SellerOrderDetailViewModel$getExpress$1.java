package com.jihuanshe.viewmodel.order;

import com.jihuanshe.model.ExpressList;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerOrderDetailViewModel$getExpress$1 extends Lambda implements l<ExpressList, t1> {
    public final /* synthetic */ SellerOrderDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerOrderDetailViewModel$getExpress$1(SellerOrderDetailViewModel sellerOrderDetailViewModel) {
        super(1);
        this.this$0 = sellerOrderDetailViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ExpressList expressList) {
        invoke2(expressList);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e ExpressList expressList) {
        List<String> x0 = this.this$0.x0();
        List<String> data = expressList == null ? null : expressList.getData();
        if (data == null) {
            data = CollectionsKt__CollectionsKt.E();
        }
        x0.addAll(data);
    }
}
