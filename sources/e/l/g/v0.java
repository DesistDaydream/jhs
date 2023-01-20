package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.SellerOrderInfo;

/* loaded from: classes2.dex */
public final class v0 extends e.t.k.a.c.a<SellerOrderInfo> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final e.t.r.a.a f12057d;

    public v0() {
        super(null, 1, null);
        this.f12057d = new e.t.r.a.a(0, 0, 3, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_seller_order;
    }

    @k.e.a.d
    public final e.t.r.a.a v() {
        return this.f12057d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d SellerOrderInfo sellerOrderInfo, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(2, this);
        viewDataBinding.setVariable(8, sellerOrderInfo);
    }
}
