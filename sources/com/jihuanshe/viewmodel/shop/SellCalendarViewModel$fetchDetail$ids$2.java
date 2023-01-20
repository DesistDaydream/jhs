package com.jihuanshe.viewmodel.shop;

import com.jihuanshe.model.Product;
import h.k2.u.l;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellCalendarViewModel$fetchDetail$ids$2 extends Lambda implements l<Product, CharSequence> {
    public static final SellCalendarViewModel$fetchDetail$ids$2 INSTANCE = new SellCalendarViewModel$fetchDetail$ids$2();

    public SellCalendarViewModel$fetchDetail$ids$2() {
        super(1);
    }

    @Override // h.k2.u.l
    @d
    public final CharSequence invoke(@d Product product) {
        String tempId = product.getTempId();
        return tempId != null ? tempId : "";
    }
}
