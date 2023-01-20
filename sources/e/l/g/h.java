package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.GameCard;
import e.t.o.d;

/* loaded from: classes2.dex */
public final class h extends e.t.k.a.c.a<GameCard> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final e.t.r.a.a f12029d;
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private final e.t.r.a.b f12030e;

    public h() {
        super(null, 1, null);
        this.f12029d = new e.t.r.a.a(0, 0, 3, null);
        this.f12030e = new e.t.r.a.b(d.a.c(e.t.o.d.a, null, 1, null).d(2));
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_card_detail_list;
    }

    @k.e.a.d
    public final e.t.r.a.b v() {
        return this.f12030e;
    }

    @k.e.a.d
    public final e.t.r.a.a w() {
        return this.f12029d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: x */
    public void u(@k.e.a.d GameCard gameCard, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(17, this.f12030e);
        viewDataBinding.setVariable(8, gameCard);
        viewDataBinding.setVariable(2, this);
    }
}
