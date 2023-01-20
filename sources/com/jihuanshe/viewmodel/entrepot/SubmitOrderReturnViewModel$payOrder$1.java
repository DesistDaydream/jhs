package com.jihuanshe.viewmodel.entrepot;

import com.jihuanshe.model.PayParams;
import com.jihuanshe.wxapi.WXTool;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SubmitOrderReturnViewModel$payOrder$1 extends Lambda implements l<PayParams, t1> {
    public static final SubmitOrderReturnViewModel$payOrder$1 INSTANCE = new SubmitOrderReturnViewModel$payOrder$1();

    public SubmitOrderReturnViewModel$payOrder$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(PayParams payParams) {
        invoke2(payParams);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e PayParams payParams) {
        if (payParams == null) {
            return;
        }
        WXTool.a.f(payParams);
    }
}
