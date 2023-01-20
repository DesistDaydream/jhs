package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.CoinLog;

/* loaded from: classes2.dex */
public final class o extends e.t.k.a.c.a<CoinLog> {
    public o() {
        super(null, 1, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_coin;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: v */
    public void u(@k.e.a.d CoinLog coinLog, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, coinLog);
    }
}
