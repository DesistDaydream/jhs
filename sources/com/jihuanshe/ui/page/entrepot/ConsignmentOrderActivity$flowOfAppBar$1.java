package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.R;
import com.vector.design.ui.nav.TextAttrs;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ConsignmentOrderActivity$flowOfAppBar$1 extends Lambda implements l<TextAttrs, t1> {
    public final /* synthetic */ ConsignmentOrderActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsignmentOrderActivity$flowOfAppBar$1(ConsignmentOrderActivity consignmentOrderActivity) {
        super(1);
        this.this$0 = consignmentOrderActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(TextAttrs textAttrs) {
        invoke2(textAttrs);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d TextAttrs textAttrs) {
        int i2;
        Integer Z = this.this$0.Z();
        if (Z != null && Z.intValue() == 1) {
            i2 = Integer.valueOf((int) R.string.common_consignment_orders);
        } else if (Z != null && Z.intValue() == 2) {
            i2 = Integer.valueOf((int) R.string.common_mail_order);
        } else {
            i2 = 0;
        }
        textAttrs.K(i2);
    }
}
