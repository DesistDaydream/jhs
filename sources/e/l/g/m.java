package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.CardProduct;

/* loaded from: classes2.dex */
public final class m extends e.t.k.a.c.a<CardProduct> {
    @k.e.a.e

    /* renamed from: d  reason: collision with root package name */
    private CardProduct f12037d;

    public m() {
        super(null, 1, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_card_product;
    }

    @k.e.a.e
    public final CardProduct v() {
        return this.f12037d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d CardProduct cardProduct, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, cardProduct);
        viewDataBinding.setVariable(10, this);
    }

    public final void x(@k.e.a.e CardProduct cardProduct) {
        this.f12037d = cardProduct;
    }
}
