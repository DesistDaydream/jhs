package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.ReturnCardInfo;
import com.jihuanshe.ui.page.entrepot.ApplyForReturnActivity;

/* loaded from: classes2.dex */
public final class b extends e.t.k.a.c.a<ReturnCardInfo> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final ApplyForReturnActivity f12013d;

    public b(@k.e.a.d ApplyForReturnActivity applyForReturnActivity) {
        super(null, 1, null);
        this.f12013d = applyForReturnActivity;
    }

    @k.e.a.d
    public final ApplyForReturnActivity getActivity() {
        return this.f12013d;
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_apply_for_return;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: v */
    public void u(@k.e.a.d ReturnCardInfo returnCardInfo, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(1, this.f12013d);
        viewDataBinding.setVariable(8, returnCardInfo);
    }
}
