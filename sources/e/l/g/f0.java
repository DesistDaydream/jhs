package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.ShopCartItem;
import com.jihuanshe.ui.page.user.ShopCarActivity;

/* loaded from: classes2.dex */
public final class f0 extends e.t.k.a.c.a<ShopCartItem> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final ShopCarActivity f12027d;

    public f0(@k.e.a.d ShopCarActivity shopCarActivity) {
        super(null, 1, null);
        this.f12027d = shopCarActivity;
    }

    @k.e.a.d
    public final ShopCarActivity getActivity() {
        return this.f12027d;
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_shop_cart;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: v */
    public void u(@k.e.a.d ShopCartItem shopCartItem, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(1, this.f12027d);
        viewDataBinding.setVariable(8, shopCartItem);
    }
}
