package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.OrderInfo;

/* loaded from: classes2.dex */
public final class k0 extends e.t.k.a.c.a<OrderInfo> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final e.t.r.a.a f12035d;

    public k0() {
        super(null, 1, null);
        this.f12035d = new e.t.r.a.a(0, 0, 3, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_order;
    }

    @k.e.a.d
    public final e.t.r.a.a v() {
        return this.f12035d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d OrderInfo orderInfo, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(2, this);
        viewDataBinding.setVariable(8, orderInfo);
    }
}
