package com.jihuanshe.viewmodel.shop;

import com.jihuanshe.model.CityCodeSet;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerConfirmViewModel$fetchCityCode$1 extends Lambda implements l<CityCodeSet, t1> {
    public final /* synthetic */ SellerConfirmViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerConfirmViewModel$fetchCityCode$1(SellerConfirmViewModel sellerConfirmViewModel) {
        super(1);
        this.this$0 = sellerConfirmViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(CityCodeSet cityCodeSet) {
        invoke2(cityCodeSet);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e CityCodeSet cityCodeSet) {
        this.this$0.V0(cityCodeSet);
    }
}
