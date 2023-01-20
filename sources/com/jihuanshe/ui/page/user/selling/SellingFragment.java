package com.jihuanshe.ui.page.user.selling;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.ui.page.search.DefaultSearchHistoryViewImpl;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import e.l.g.w0;
import e.l.k.g8;
import e.l.s.o.d.a;
import e.t.j.h.d;
import e.t.j.h.g;
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
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class SellingFragment extends BaseFragment<a> {
    public static final /* synthetic */ n<Object>[] H;
    @d
    private final g B;
    @d
    private final l<Pair<String, String>, t1> C;
    @d
    private final l<Boolean, t1> D;
    @d
    private final g E;
    @d
    private final w F;
    @d
    private final w G;
    @f.a.a.a(true)
    private boolean search;
    @d
    private final e r = BindViewKt.s(this, R.id.rarityBtn);
    @d
    private final e s = BindViewKt.s(this, R.id.maskView);
    @d
    private final w t = z.c(new SellingFragment$adapter$2(this));
    @d
    private final w u = z.c(new SellingFragment$searchViewModel$2(this));
    @d
    private final y v = d.j.a.c(new SellingFragment$onPageSelected$1(this));
    @k.e.a.d
    private final l<List<Rarity>, t1> w = new SellingFragment$onFilterRarity$1(this);
    @k.e.a.d
    private final w x = z.c(SellingFragment$sortAdapter$2.INSTANCE);
    @k.e.a.d
    private final w y = z.c(SellingFragment$sortData$2.INSTANCE);
    @k.e.a.d
    private final w z = z.c(SellingFragment$layoutManager$2.INSTANCE);
    @k.e.a.d
    private final e.t.j.h.l A = d.e.a.a(new SellingFragment$onItemClick$1(this));

    static {
        n<Object>[] nVarArr = new n[9];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(SellingFragment.class), "rarityBtn", "getRarityBtn()Lcom/jihuanshe/ui/widget/RarityFilterBtn;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(SellingFragment.class), "mask", "getMask()Landroid/view/View;"));
        H = nVarArr;
    }

    public SellingFragment() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.B = dVar.a(new SellingFragment$onClickSort$1(this));
        this.C = new SellingFragment$chooseFilter$1(this);
        this.D = new SellingFragment$showState$1(this);
        this.E = dVar.a(new SellingFragment$onClickSearch$1(this));
        this.F = z.c(new SellingFragment$searchHistoryViewImpl$2(this));
        this.G = z.c(new SellingFragment$pagers$2(this));
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        if (this.search) {
            r0().s0().f(this, new SellingFragment$flowOfSetup$1(this));
            ((a) T()).E().f(this, new SellingFragment$flowOfSetup$2(this));
        }
    }

    @k.e.a.d
    public final FragPagerAdapter e0() {
        return (FragPagerAdapter) this.t.getValue();
    }

    @k.e.a.d
    public final l<Pair<String, String>, t1> f0() {
        return this.C;
    }

    @k.e.a.d
    public final LayoutManagers.a g0() {
        return (LayoutManagers.a) this.z.getValue();
    }

    @k.e.a.d
    public final View h0() {
        return (View) this.s.a(this, H[1]);
    }

    @k.e.a.d
    public final g i0() {
        return this.E;
    }

    @k.e.a.d
    public final g j0() {
        return this.B;
    }

    @k.e.a.d
    public final l<List<Rarity>, t1> k0() {
        return this.w;
    }

    @k.e.a.d
    public final e.t.j.h.l l0() {
        return this.A;
    }

    @k.e.a.d
    public final y m0() {
        return this.v;
    }

    @k.e.a.d
    public final c n0() {
        return (c) this.G.getValue();
    }

    @k.e.a.d
    public final RarityFilterBtn o0() {
        return (RarityFilterBtn) this.r.a(this, H[0]);
    }

    public final boolean p0() {
        return this.search;
    }

    @k.e.a.d
    public final DefaultSearchHistoryViewImpl q0() {
        return (DefaultSearchHistoryViewImpl) this.F.getValue();
    }

    @k.e.a.d
    public final e.l.s.m.c r0() {
        return (e.l.s.m.c) this.u.getValue();
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        g8 e2 = g8.e(getLayoutInflater());
        e2.i(this);
        e2.j((a) T());
        return e2;
    }

    @k.e.a.d
    public final l<Boolean, t1> s0() {
        return this.D;
    }

    @k.e.a.d
    public final w0 t0() {
        return (w0) this.x.getValue();
    }

    @k.e.a.d
    public final List<Pair<String, String>> u0() {
        return (List) this.y.getValue();
    }

    public final void v0(boolean z) {
        this.search = z;
    }
}
