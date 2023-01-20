package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.ApplyForItem;
import com.jihuanshe.ui.page.entrepot.ConOrderDetailsActivity;

/* loaded from: classes2.dex */
public final class q extends e.t.k.a.c.a<ApplyForItem> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final ConOrderDetailsActivity f12044d;

    public q(@k.e.a.d ConOrderDetailsActivity conOrderDetailsActivity) {
        super(null, 1, null);
        this.f12044d = conOrderDetailsActivity;
    }

    @k.e.a.d
    public final ConOrderDetailsActivity getActivity() {
        return this.f12044d;
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_con_order_detail;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: v */
    public void u(@k.e.a.d ApplyForItem applyForItem, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(1, this.f12044d);
        viewDataBinding.setVariable(8, applyForItem);
    }
}
