package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Game;

/* loaded from: classes2.dex */
public final class x extends e.t.k.a.c.a<Game> {
    public x() {
        super(null, 1, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_pop_game;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: v */
    public void u(@k.e.a.d Game game, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, game);
    }
}
