package com.jihuanshe.viewmodel.entrepot;

import com.jihuanshe.model.UserAddress;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ApplyForReturnViewModel$getAddress$2 extends Lambda implements l<List<? extends UserAddress>, t1> {
    public final /* synthetic */ ApplyForReturnViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyForReturnViewModel$getAddress$2(ApplyForReturnViewModel applyForReturnViewModel) {
        super(1);
        this.this$0 = applyForReturnViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends UserAddress> list) {
        invoke2((List<UserAddress>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e List<UserAddress> list) {
        this.this$0.s0().setValue(list);
    }
}
