package com.jihuanshe.ui.page.shop;

import android.view.View;
import com.jihuanshe.model.Product;
import com.jihuanshe.ui.page.detail.CardPackDetailActivityCreator;
import com.jihuanshe.viewmodel.shop.SellCalendarViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellCalendarActivity$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ SellCalendarActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellCalendarActivity$onItemClick$1(SellCalendarActivity sellCalendarActivity) {
        super(2);
        this.this$0 = sellCalendarActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        Product product;
        List<Product> value = ((SellCalendarViewModel) this.this$0.L()).v0().getValue();
        if (value == null || (product = (Product) CollectionsKt___CollectionsKt.J2(value, i2)) == null) {
            return;
        }
        CardPackDetailActivityCreator.create(product.getId(), product.getGameKey(), product.getGameSubKey()).from("发售日历").start(this.this$0);
    }
}
