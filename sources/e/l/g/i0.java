package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.WarehouseProductInfo;
import com.jihuanshe.ui.page.entrepot.MineStorehouseFragment;

/* loaded from: classes2.dex */
public final class i0 extends e.t.k.a.c.a<WarehouseProductInfo> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final MineStorehouseFragment f12032d;

    public i0(@k.e.a.d MineStorehouseFragment mineStorehouseFragment) {
        super(null, 1, null);
        this.f12032d = mineStorehouseFragment;
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_mine_storehouse;
    }

    @k.e.a.d
    public final MineStorehouseFragment v() {
        return this.f12032d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d WarehouseProductInfo warehouseProductInfo, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(5, this.f12032d);
        viewDataBinding.setVariable(8, warehouseProductInfo);
    }
}
