package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.R;
import com.jihuanshe.model.WarehouseProductInfo;
import com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel;
import com.vector.util.Res;
import h.k2.u.l;
import h.k2.v.t0;
import h.t1;
import java.util.List;
import java.util.Objects;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class MineStorehouseFragment$onSoldOrOffSold$2$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ WarehouseProductInfo $card;
    public final /* synthetic */ MineStorehouseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineStorehouseFragment$onSoldOrOffSold$2$1(MineStorehouseFragment mineStorehouseFragment, WarehouseProductInfo warehouseProductInfo) {
        super(1);
        this.this$0 = mineStorehouseFragment;
        this.$card = warehouseProductInfo;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        List<WarehouseProductInfo> value = ((MineStorehouseViewModel) this.this$0.T()).v0().getValue();
        Objects.requireNonNull(value, "null cannot be cast to non-null type kotlin.collections.MutableList<com.jihuanshe.model.WarehouseProductInfo>");
        t0.g(value).remove(this.$card);
        ((MineStorehouseViewModel) this.this$0.T()).v0().n();
        e.l.h.j.b.e.d(this.this$0, Res.w(Res.a, R.string.common_complete, null, 2, null), (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? 1 : 0, (r13 & 32) == 0 ? null : null);
    }
}
