package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.ApplyForItem;
import com.jihuanshe.ui.page.entrepot.ApplyForActivity;

/* loaded from: classes2.dex */
public final class a extends e.t.k.a.c.a<ApplyForItem> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final ApplyForActivity f12011d;

    public a(@k.e.a.d ApplyForActivity applyForActivity) {
        super(null, 1, null);
        this.f12011d = applyForActivity;
    }

    @k.e.a.d
    public final ApplyForActivity getActivity() {
        return this.f12011d;
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_apply_for;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: v */
    public void u(@k.e.a.d ApplyForItem applyForItem, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(1, this.f12011d);
        viewDataBinding.setVariable(8, applyForItem);
    }
}
