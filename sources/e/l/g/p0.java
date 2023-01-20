package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.RankCardInfo;
import com.jihuanshe.ui.page.rank.RankListFragment;

/* loaded from: classes2.dex */
public final class p0 extends e.t.k.a.c.f<RankCardInfo> {

    /* renamed from: d  reason: collision with root package name */
    private final int f12042d;

    /* renamed from: e  reason: collision with root package name */
    private final int f12043e;

    public p0() {
        super(null, 1, null);
        this.f12043e = 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i2) {
        RankCardInfo item = getItem(i2);
        if (h.k2.v.f0.g(item == null ? null : item.getType(), RankListFragment.E.b())) {
            return this.f12042d;
        }
        return this.f12043e;
    }

    @Override // e.t.k.a.c.f
    public int h(int i2) {
        return i2 == this.f12042d ? R.layout.item_rank_pack : R.layout.item_rank_card;
    }

    @Override // e.t.k.a.c.f
    public boolean l() {
        return true;
    }

    @Override // e.t.k.a.c.f
    /* renamed from: t */
    public boolean b(@k.e.a.d RankCardInfo rankCardInfo, @k.e.a.d RankCardInfo rankCardInfo2) {
        return h.k2.v.f0.g(rankCardInfo, rankCardInfo2);
    }

    @Override // e.t.k.a.c.f
    /* renamed from: u */
    public void n(int i2, @k.e.a.d RankCardInfo rankCardInfo, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(2, this);
        viewDataBinding.setVariable(8, rankCardInfo);
    }
}
