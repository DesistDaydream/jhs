package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Product;
import com.jihuanshe.ui.page.shop.SellCalendarActivity;

/* loaded from: classes2.dex */
public final class t0 extends e.t.k.a.c.a<Product> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final SellCalendarActivity f12054d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f12055e;

    public t0(@k.e.a.d SellCalendarActivity sellCalendarActivity) {
        super(null, 1, null);
        this.f12054d = sellCalendarActivity;
    }

    @k.e.a.d
    public final SellCalendarActivity getActivity() {
        return this.f12054d;
    }

    @Override // e.t.k.a.c.f
    public boolean l() {
        return this.f12055e;
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_sell_calendar;
    }

    @Override // e.t.k.a.c.f
    /* renamed from: v */
    public boolean b(@k.e.a.d Product product, @k.e.a.d Product product2) {
        return h.k2.v.f0.g(product, product2);
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d Product product, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, product);
        viewDataBinding.setVariable(10, this);
    }
}
