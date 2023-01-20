package com.jihuanshe.ui.page.rank;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.widget.GameFilterBtn;
import com.jihuanshe.ui.widget.RankIndicatorView;
import com.jihuanshe.viewmodel.rank.RankViewModel;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.design.ui.nav.AppBar;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.Res;
import e.l.k.u1;
import e.n.f;
import e.t.j.h.g;
import f.a.a.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.n0;
import h.p2.n;
import h.t1;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class RankActivity extends BaseActivity<RankViewModel> {
    public static final /* synthetic */ n<Object>[] w;
    @a(true)
    @e
    private Integer allGame;
    @a(true)
    @e
    private String fromType;
    @a(true)
    @e
    private Integer rankTypeId;
    @e
    private TextView v;
    @a(true)
    @e
    private String gameKey = "";
    @a(true)
    @e
    private String gameSubKey = "";
    private final int n = Res.k(R.color.white);
    @d
    private final h.m2.e o = BindViewKt.n(this, R.id.llTop);
    @d
    private final h.m2.e p = BindViewKt.n(this, R.id.clDesc);
    @d
    private final h.m2.e q = BindViewKt.n(this, R.id.tabBar);
    @d
    private final h.m2.e r = BindViewKt.n(this, R.id.gameFilter);
    @d
    private final w s = z.c(new RankActivity$adapter$2(this));
    @d
    private final l<Game, t1> t = new RankActivity$onFilterGame$1(this);
    @d
    private final l<Integer, t1> u = new RankActivity$onChooseCategory$1(this);

    static {
        n<Object>[] nVarArr = new n[5];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(RankActivity.class), "llTop", "getLlTop()Landroid/widget/LinearLayout;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(RankActivity.class), "clDesc", "getClDesc()Landroidx/constraintlayout/widget/ConstraintLayout;"));
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(RankActivity.class), "tabBar", "getTabBar()Lcom/jihuanshe/ui/widget/RankIndicatorView;"));
        nVarArr[3] = n0.r(new PropertyReference1Impl(n0.d(RankActivity.class), "gameBtn", "getGameBtn()Lcom/jihuanshe/ui/widget/GameFilterBtn;"));
        w = nVarArr;
    }

    private final LinearLayout e0() {
        return (LinearLayout) this.o.a(this, w[0]);
    }

    private final void k0() {
        f.g(((RankViewModel) L()).q0(), null, new RankActivity$initObserver$1(this), 1, null);
        f.g(((RankViewModel) L()).t0(), null, new RankActivity$initObserver$2(this), 1, null);
    }

    @d
    public final FragPagerAdapter W() {
        return (FragPagerAdapter) this.s.getValue();
    }

    @e
    public final Integer X() {
        return this.allGame;
    }

    @d
    public final ConstraintLayout Y() {
        return (ConstraintLayout) this.p.a(this, w[1]);
    }

    public final int Z() {
        return this.n;
    }

    @e
    public final String a0() {
        return this.fromType;
    }

    @d
    public final GameFilterBtn b0() {
        return (GameFilterBtn) this.r.a(this, w[3]);
    }

    @e
    public final String c0() {
        return this.gameKey;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        super.d();
        k0();
        Integer num = this.allGame;
        if (num != null && num.intValue() == 1) {
            this.gameKey = "";
            this.gameSubKey = "";
        }
        b0().setCurrentGame(e.l.l.a.b(this.gameKey, this.gameSubKey));
        ((RankViewModel) L()).r0().setValue(e.l.l.a.b(this.gameKey, this.gameSubKey));
        if (f0.g(this.fromType, Constants.Companion.getTYPE_CARD())) {
            ((RankViewModel) L()).p0().setValue(1);
        } else {
            ((RankViewModel) L()).p0().setValue(0);
        }
        BinderKt.n(((RankViewModel) L()).A0(), this);
        e.l.h.d.f.b.e(this).g(e.l.j.a.u, new RankActivity$flowOfSetup$1(this));
    }

    @e
    public final String d0() {
        return this.gameSubKey;
    }

    @d
    public final l<Integer, t1> f0() {
        return this.u;
    }

    @d
    public final l<Game, t1> g0() {
        return this.t;
    }

    @e
    public final Integer h0() {
        return this.rankTypeId;
    }

    @d
    public final RankIndicatorView i0() {
        return (RankIndicatorView) this.q.a(this, w[2]);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        super.j();
        AppBar appBar = new AppBar(this, null, 0, 6, null);
        appBar.setBackgroundResource(R.color.transparent);
        AppBarKt.d(appBar, this, R.drawable.bg_game_bar, null, 4, null);
        TextView g2 = appBar.getMid().g(RankActivity$flowOfAppBar$1.INSTANCE);
        this.v = g2;
        if (g2 != null) {
            g2.setTextColor(-1);
        }
        e0().addView(appBar, 0);
    }

    @e
    public final TextView j0() {
        return this.v;
    }

    @d
    public final g l0(int i2) {
        return e.t.j.h.d.a.a(new RankActivity$onChoiceType$1(this, i2));
    }

    public final void m0(@e Integer num) {
        this.allGame = num;
    }

    public final void n0(@e String str) {
        this.fromType = str;
    }

    public final void o0(@e String str) {
        this.gameKey = str;
    }

    public final void p0(@e String str) {
        this.gameSubKey = str;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        u1 e2 = u1.e(getLayoutInflater());
        e2.i(this);
        e2.j((RankViewModel) L());
        return e2;
    }

    public final void q0(@e Integer num) {
        this.rankTypeId = num;
    }

    public final void r0(@e TextView textView) {
        this.v = textView;
    }
}
