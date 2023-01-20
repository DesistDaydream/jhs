package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.ui.page.user.WantBuyActivity;

/* loaded from: classes2.dex */
public final class z0 extends e.t.k.a.c.a<WantBuyList> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final WantBuyActivity f12060d;

    public z0(@k.e.a.d WantBuyActivity wantBuyActivity) {
        super(null, 1, null);
        this.f12060d = wantBuyActivity;
    }

    @k.e.a.d
    public final WantBuyActivity getActivity() {
        return this.f12060d;
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_want_buy_list;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: v */
    public void u(@k.e.a.d WantBuyList wantBuyList, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(1, this.f12060d);
        viewDataBinding.setVariable(8, wantBuyList);
    }
}
