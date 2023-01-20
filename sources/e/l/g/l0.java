package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.OrderReturnInfo;

/* loaded from: classes2.dex */
public final class l0 extends e.t.k.a.c.a<OrderReturnInfo> {
    public l0() {
        super(null, 1, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_order_return_product;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: v */
    public void u(@k.e.a.d OrderReturnInfo orderReturnInfo, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, orderReturnInfo);
    }
}
