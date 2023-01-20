package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.CardConsignmentInfo;

/* loaded from: classes2.dex */
public final class p extends e.t.k.a.c.a<CardConsignmentInfo> {
    public p() {
        super(null, 1, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_card_con;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: v */
    public void u(@k.e.a.d CardConsignmentInfo cardConsignmentInfo, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(2, this);
        viewDataBinding.setVariable(8, cardConsignmentInfo);
    }
}
