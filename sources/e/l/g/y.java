package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Game;

/* loaded from: classes2.dex */
public final class y extends e.t.k.a.c.a<Game> {
    @k.e.a.e

    /* renamed from: d  reason: collision with root package name */
    private final Boolean f12059d;

    public y() {
        this(null, 1, null);
    }

    public y(@k.e.a.e Boolean bool) {
        super(null, 1, null);
        this.f12059d = bool;
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_pop_game_filter;
    }

    @k.e.a.e
    public final Boolean v() {
        return this.f12059d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d Game game, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(2, this);
        viewDataBinding.setVariable(8, game);
    }

    public /* synthetic */ y(Boolean bool, int i2, h.k2.v.u uVar) {
        this((i2 & 1) != 0 ? Boolean.FALSE : bool);
    }
}
