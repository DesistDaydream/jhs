package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ConsignmentOrderActivity$onClickButton$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ConsignmentOrderActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsignmentOrderActivity$onClickButton$1(ConsignmentOrderActivity consignmentOrderActivity) {
        super(1);
        this.this$0 = consignmentOrderActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Integer Z = this.this$0.Z();
        if (Z != null && Z.intValue() == 1) {
            ApplyForActivityCreator.create().start(this.this$0);
        } else if (Z != null && Z.intValue() == 2) {
            ApplyForReturnActivityCreator.create().start(this.this$0);
        }
    }
}
