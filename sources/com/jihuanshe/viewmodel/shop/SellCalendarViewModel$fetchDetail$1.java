package com.jihuanshe.viewmodel.shop;

import com.jihuanshe.model.Product;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import java.util.Iterator;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellCalendarViewModel$fetchDetail$1 extends Lambda implements l<List<? extends Product>, t1> {
    public final /* synthetic */ int $record;
    public final /* synthetic */ SellCalendarViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellCalendarViewModel$fetchDetail$1(SellCalendarViewModel sellCalendarViewModel, int i2) {
        super(1);
        this.this$0 = sellCalendarViewModel;
        this.$record = i2;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends Product> list) {
        invoke2((List<Product>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e List<Product> list) {
        Object obj;
        if (this.this$0.A0().size() > this.$record) {
            this.this$0.A0().set(this.$record, 2);
        }
        if (list != null) {
            SellCalendarViewModel sellCalendarViewModel = this.this$0;
            for (Product product : list) {
                List<Product> value = sellCalendarViewModel.v0().getValue();
                if (value != null) {
                    Iterator<T> it = value.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (f0.g(((Product) obj).getTempId(), product.getTempId())) {
                            break;
                        }
                    }
                    Product product2 = (Product) obj;
                    if (product2 != null) {
                        product2.updateData(product);
                    }
                }
            }
        }
        this.this$0.v0().n();
    }
}
