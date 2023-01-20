package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.GameCard;
import com.tencent.qcloud.tuicore.util.ScreenUtil;

/* loaded from: classes2.dex */
public final class u0 extends e.t.k.a.c.a<GameCard> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final e.t.r.a.b f12056d;

    public u0() {
        super(null, 1, null);
        this.f12056d = new e.t.r.a.b(ScreenUtil.dip2px(3.0f));
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_seller_detail_card;
    }

    @k.e.a.d
    public final e.t.r.a.b v() {
        return this.f12056d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d GameCard gameCard, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(2, this);
        viewDataBinding.setVariable(8, gameCard);
    }
}
