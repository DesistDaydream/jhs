package com.jihuanshe.ui.page.user.wish;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.BaseFragment;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.util.Res;
import e.l.k.o6;
import e.l.s.o.e.a;
import e.t.j.h.d;
import e.t.j.h.y;
import e.t.k.a.c.h.c;
import h.k2.u.l;
import h.t1;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;

@Creator
/* loaded from: classes2.dex */
public class DesireFragment extends BaseFragment<a> {
    private final boolean r;
    @d
    private final c s;
    @d
    private final w t;
    @d
    private final l<Game, t1> u;
    @d
    private final y v;

    public DesireFragment() {
        List P = CollectionsKt__CollectionsKt.P(new DesireFragment$pagers$1(this), new DesireFragment$pagers$2(this), new DesireFragment$pagers$3(this));
        Res res = Res.a;
        this.s = e.t.k.a.c.h.d.a(P, CollectionsKt__CollectionsKt.P(Res.w(res, R.string.common_tab_all_product, null, 2, null), Res.w(res, R.string.common_tab_card, null, 2, null), Res.w(res, R.string.common_tab_series, null, 2, null)));
        this.t = z.c(new DesireFragment$adapter$2(this));
        this.u = new DesireFragment$onFilterGame$1(this);
        this.v = d.j.a.c(new DesireFragment$onPageSelected$1(this));
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        super.d();
        m(R.color.white);
    }

    @k.e.a.d
    public final FragPagerAdapter e0() {
        return (FragPagerAdapter) this.t.getValue();
    }

    @k.e.a.d
    public final l<Game, t1> f0() {
        return this.u;
    }

    @k.e.a.d
    public final y g0() {
        return this.v;
    }

    @k.e.a.d
    public final c h0() {
        return this.s;
    }

    public boolean i0() {
        return this.r;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        o6 d2 = o6.d(getLayoutInflater());
        d2.h(this);
        return d2;
    }
}
