package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.WarehouseProductInfo;
import com.jihuanshe.ui.page.entrepot.SearchChildCheckFragment;

/* loaded from: classes2.dex */
public final class s0 extends e.t.k.a.c.a<WarehouseProductInfo> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final SearchChildCheckFragment f12052d;

    public s0(@k.e.a.d SearchChildCheckFragment searchChildCheckFragment) {
        super(null, 1, null);
        this.f12052d = searchChildCheckFragment;
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_search_child_check;
    }

    @k.e.a.d
    public final SearchChildCheckFragment v() {
        return this.f12052d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d WarehouseProductInfo warehouseProductInfo, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(5, this.f12052d);
        viewDataBinding.setVariable(8, warehouseProductInfo);
    }
}
