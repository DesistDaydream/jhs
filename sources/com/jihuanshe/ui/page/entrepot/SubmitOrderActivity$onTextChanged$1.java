package com.jihuanshe.ui.page.entrepot;

import android.text.Editable;
import com.jihuanshe.model.WareCache;
import com.jihuanshe.viewmodel.entrepot.SubmitOrderViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SubmitOrderActivity$onTextChanged$1 extends Lambda implements l<Editable, t1> {
    public final /* synthetic */ SubmitOrderActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubmitOrderActivity$onTextChanged$1(SubmitOrderActivity submitOrderActivity) {
        super(1);
        this.this$0 = submitOrderActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Editable editable) {
        invoke2(editable);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Editable editable) {
        WareCache value = ((SubmitOrderViewModel) this.this$0.L()).B0().getValue();
        if (value != null) {
            value.setExpressNumber(editable.toString());
        }
        ((SubmitOrderViewModel) this.this$0.L()).B0().n();
    }
}
