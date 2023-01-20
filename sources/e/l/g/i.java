package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.GameCard;

/* loaded from: classes2.dex */
public final class i extends e.t.k.a.c.a<GameCard> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final e.t.r.a.a f12031d;

    public i() {
        super(null, 1, null);
        this.f12031d = new e.t.r.a.a(0, 0, 3, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_card_detail;
    }

    @k.e.a.d
    public final e.t.r.a.a v() {
        return this.f12031d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d GameCard gameCard, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(17, this.f12031d);
        viewDataBinding.setVariable(8, gameCard);
    }
}
