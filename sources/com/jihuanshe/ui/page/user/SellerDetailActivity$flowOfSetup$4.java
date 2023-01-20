package com.jihuanshe.ui.page.user;

import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.model.Constants;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$flowOfSetup$4 extends Lambda implements l<Result<List<? extends CardProduct>>, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$flowOfSetup$4(SellerDetailActivity sellerDetailActivity) {
        super(1);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Result<List<? extends CardProduct>> result) {
        invoke2((Result<List<CardProduct>>) result);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Result<List<CardProduct>> result) {
        List<CardProduct> data = result == null ? null : result.getData();
        if ((data == null || data.isEmpty()) || !f0.g(this.this$0.M(), Constants.Companion.getSHOP_CAR_ACTIVITY())) {
            return;
        }
        ((SellerDetailViewModel) this.this$0.L()).V0().setValue(Boolean.TRUE);
    }
}
