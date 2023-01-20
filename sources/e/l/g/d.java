package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.BankDetail;

/* loaded from: classes2.dex */
public final class d extends e.t.k.a.c.a<BankDetail> {
    public d() {
        super(null, 1, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_bank;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: v */
    public void u(@k.e.a.d BankDetail bankDetail, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, bankDetail);
    }
}
