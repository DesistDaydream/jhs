package com.jihuanshe.ui.page.search.fragments.global;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.ui.widget.GameFilterBtn;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.design.ui.frag.SimpleFragEx;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.Res;
import e.l.k.u6;
import e.l.s.m.d.a;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.y;
import e.t.k.a.c.h.c;
import h.k2.u.l;
import h.k2.v.n0;
import h.m2.e;
import h.p2.n;
import h.t1;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class GlobalSearchProductFragment extends BaseFragment<a> {
    public static final /* synthetic */ n<Object>[] z;
    @d
    private final e r = BindViewKt.s(this, R.id.gameFilter);
    @d
    private final e s = BindViewKt.s(this, R.id.rarityFilter);
    @d
    private final w t = z.c(new GlobalSearchProductFragment$parentViewModel$2(this));
    @d
    private final l<Game, t1> u = new GlobalSearchProductFragment$onFilterGame$1(this);
    @d
    private final l<List<Rarity>, t1> v = new GlobalSearchProductFragment$onFilterRarity$1(this);
    @d
    private final y w = d.j.a.c(new GlobalSearchProductFragment$onPageSelected$1(this));
    @k.e.a.d
    private final c x;
    @k.e.a.d
    private final w y;

    static {
        n<Object>[] nVarArr = new n[4];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(GlobalSearchProductFragment.class), "gameBtn", "getGameBtn()Lcom/jihuanshe/ui/widget/GameFilterBtn;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(GlobalSearchProductFragment.class), "rarityBtn", "getRarityBtn()Lcom/jihuanshe/ui/widget/RarityFilterBtn;"));
        z = nVarArr;
    }

    public GlobalSearchProductFragment() {
        List P = CollectionsKt__CollectionsKt.P(GlobalSearchProductFragment$pagers$1.INSTANCE, GlobalSearchProductFragment$pagers$2.INSTANCE);
        Res res = Res.a;
        this.x = e.t.k.a.c.h.d.a(P, CollectionsKt__CollectionsKt.P(Res.w(res, R.string.common_tab_card, null, 2, null), Res.w(res, R.string.common_tab_series, null, 2, null)));
        this.y = z.c(new GlobalSearchProductFragment$adapter$2(this));
    }

    private final GameFilterBtn g0() {
        return (GameFilterBtn) this.r.a(this, z[0]);
    }

    private final e.l.s.m.c l0() {
        return (e.l.s.m.c) this.t.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RarityFilterBtn m0() {
        return (RarityFilterBtn) this.s.a(this, z[1]);
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public SimpleFragEx.LazyLoadMode F() {
        return SimpleFragEx.LazyLoadMode.RESUME;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        f<Game> p0 = ((a) T()).p0();
        GameBar.a aVar = GameBar.b;
        p0.setValue(aVar.a().getValue());
        g0().setCurrentGame(aVar.a().getValue());
        l0().s0().f(this, new GlobalSearchProductFragment$flowOfSetup$1(this));
    }

    @k.e.a.d
    public final FragPagerAdapter f0() {
        return (FragPagerAdapter) this.y.getValue();
    }

    @k.e.a.d
    public final l<Game, t1> h0() {
        return this.u;
    }

    @k.e.a.d
    public final l<List<Rarity>, t1> i0() {
        return this.v;
    }

    @k.e.a.d
    public final y j0() {
        return this.w;
    }

    @k.e.a.d
    public final c k0() {
        return this.x;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        u6 e2 = u6.e(getLayoutInflater());
        e2.i(this);
        e2.j((a) T());
        return e2;
    }
}
