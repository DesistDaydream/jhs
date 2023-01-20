package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.SoldProductInfo;

/* loaded from: classes2.dex */
public final class h0 extends e.t.k.a.c.a<SoldProductInfo> {
    public h0() {
        super(null, 1, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_mine_storehouse_sold;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: v */
    public void u(@k.e.a.d SoldProductInfo soldProductInfo, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, soldProductInfo);
    }
}
