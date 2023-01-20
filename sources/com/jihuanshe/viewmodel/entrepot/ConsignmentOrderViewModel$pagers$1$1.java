package com.jihuanshe.viewmodel.entrepot;

import com.jihuanshe.ui.page.entrepot.ConsignmentOrderFragment;
import com.jihuanshe.ui.page.entrepot.ConsignmentOrderFragmentCreator;
import h.k2.u.l;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ConsignmentOrderViewModel$pagers$1$1 extends Lambda implements l<Integer, ConsignmentOrderFragment> {
    public final /* synthetic */ String $s;
    public final /* synthetic */ ConsignmentOrderViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsignmentOrderViewModel$pagers$1$1(String str, ConsignmentOrderViewModel consignmentOrderViewModel) {
        super(1);
        this.$s = str;
        this.this$0 = consignmentOrderViewModel;
    }

    public final ConsignmentOrderFragment invoke(int i2) {
        return ConsignmentOrderFragmentCreator.create(this.$s, Integer.valueOf(this.this$0.q0())).get();
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ ConsignmentOrderFragment invoke(Integer num) {
        return invoke(num.intValue());
    }
}
