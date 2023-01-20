package com.jihuanshe.viewmodel.user;

import com.jihuanshe.model.WarehouseInfo;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class MineEntrepotViewModel$getWarehouseInfo$1 extends Lambda implements l<WarehouseInfo, t1> {
    public final /* synthetic */ MineEntrepotViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineEntrepotViewModel$getWarehouseInfo$1(MineEntrepotViewModel mineEntrepotViewModel) {
        super(1);
        this.this$0 = mineEntrepotViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(WarehouseInfo warehouseInfo) {
        invoke2(warehouseInfo);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e WarehouseInfo warehouseInfo) {
        this.this$0.r0().setValue(warehouseInfo);
    }
}
