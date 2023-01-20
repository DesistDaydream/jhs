package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.model.ApplyForOrder;
import com.jihuanshe.ui.page.shop.AddCardActivityCreator;
import com.jihuanshe.viewmodel.entrepot.ApplyForViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ApplyForActivity$addCardClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ApplyForActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyForActivity$addCardClick$1(ApplyForActivity applyForActivity) {
        super(1);
        this.this$0 = applyForActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        ApplyForOrder value = ((ApplyForViewModel) this.this$0.L()).s0().getValue();
        AddCardActivityCreator.create(3, value == null ? null : value.getWarehouseOrderId()).start(this.this$0);
    }
}
