package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.entrepot.SubmitOrderReturnViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SubmitOrderReturnActivity$onClickPay$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SubmitOrderReturnActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubmitOrderReturnActivity$onClickPay$1(SubmitOrderReturnActivity submitOrderReturnActivity) {
        super(1);
        this.this$0 = submitOrderReturnActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Integer d0 = this.this$0.d0();
        if (d0 == null) {
            return;
        }
        d0.intValue();
        BinderKt.p(BinderKt.k(((SubmitOrderReturnViewModel) this.this$0.L()).G0(this.this$0.d0().intValue()), this.this$0, false, 2, null));
    }
}
