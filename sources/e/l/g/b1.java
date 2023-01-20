package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Product;
import com.jihuanshe.ui.page.user.wish.WishListFragment;
import e.t.o.d;

/* loaded from: classes2.dex */
public final class b1 extends e.t.k.a.c.f<Product> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final WishListFragment f12015d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12016e;

    /* renamed from: f  reason: collision with root package name */
    private final int f12017f;
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private final e.t.r.a.b f12018g;

    public b1(@k.e.a.d WishListFragment wishListFragment) {
        super(null, 1, null);
        this.f12015d = wishListFragment;
        this.f12017f = 1;
        this.f12018g = new e.t.r.a.b(d.a.c(e.t.o.d.a, null, 1, null).d(2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        Product item = getItem(i2);
        if (h.k2.v.f0.g(item == null ? null : item.getType(), Constants.Companion.getTYPE_PACK())) {
            return this.f12017f;
        }
        return this.f12016e;
    }

    @Override // e.t.k.a.c.f
    public int h(int i2) {
        return i2 == this.f12017f ? R.layout.item_wish_pack : R.layout.item_wish_product;
    }

    @k.e.a.d
    public final WishListFragment t() {
        return this.f12015d;
    }

    @k.e.a.d
    public final e.t.r.a.b u() {
        return this.f12018g;
    }

    @Override // e.t.k.a.c.f
    /* renamed from: v */
    public void n(int i2, @k.e.a.d Product product, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(10, this);
        viewDataBinding.setVariable(8, product);
    }
}
