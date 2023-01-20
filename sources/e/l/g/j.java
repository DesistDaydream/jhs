package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.GameCard;

/* loaded from: classes2.dex */
public final class j extends e.t.k.a.c.a<GameCard> {
    public j() {
        super(null, 1, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_card_list;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: v */
    public void u(@k.e.a.d GameCard gameCard, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, gameCard);
    }
}
