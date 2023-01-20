package com.jihuanshe.ui.page.user;

import com.jihuanshe.model.WarehouseInfo;
import com.jihuanshe.viewmodel.user.MineEntrepotViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class MineEntrepotActivity$onRetryClick$1 extends Lambda implements l<WarehouseInfo, t1> {
    public final /* synthetic */ MineEntrepotActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineEntrepotActivity$onRetryClick$1(MineEntrepotActivity mineEntrepotActivity) {
        super(1);
        this.this$0 = mineEntrepotActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(WarehouseInfo warehouseInfo) {
        invoke2(warehouseInfo);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e WarehouseInfo warehouseInfo) {
        ((MineEntrepotViewModel) this.this$0.L()).p0().setValue(Integer.valueOf(this.this$0.W().getHeight()));
    }
}
