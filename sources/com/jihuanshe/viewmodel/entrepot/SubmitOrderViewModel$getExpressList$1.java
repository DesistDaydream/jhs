package com.jihuanshe.viewmodel.entrepot;

import com.jihuanshe.model.ExpressList;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SubmitOrderViewModel$getExpressList$1 extends Lambda implements l<ExpressList, t1> {
    public final /* synthetic */ SubmitOrderViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubmitOrderViewModel$getExpressList$1(SubmitOrderViewModel submitOrderViewModel) {
        super(1);
        this.this$0 = submitOrderViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ExpressList expressList) {
        invoke2(expressList);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e ExpressList expressList) {
        this.this$0.z0().setValue(expressList == null ? null : expressList.getData());
    }
}
