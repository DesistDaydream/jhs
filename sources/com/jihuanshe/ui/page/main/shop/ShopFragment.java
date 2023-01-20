package com.jihuanshe.ui.page.main.shop;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardPackage;
import com.jihuanshe.model.Category;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.ui.page.main.shop.ShopFragment;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;
import com.vector.design.ui.decor.ViewState;
import com.vector.ext.bind.BindViewKt;
import com.vector.ext.view.ViewKt;
import com.vector.util.LayoutManagers;
import com.vector.util.Res;
import com.vector.view.scrollable.ListView;
import e.l.h.d.f;
import e.l.k.i8;
import e.l.r.r;
import e.t.j.h.d;
import e.t.j.h.d0;
import e.t.j.h.g;
import e.t.j.h.p;
import e.t.l.s;
import e.t.o.d;
import e.t.r.a.b;
import h.k2.u.l;
import h.k2.v.n0;
import h.p2.n;
import h.t1;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;

@Creator
/* loaded from: classes2.dex */
public final class ShopFragment extends BaseFragment<ShopViewModel> {
    public static final /* synthetic */ n<Object>[] S;
    @d
    private final w A;
    @d
    private final w B;
    @d
    private final p C;
    @d
    private final l<Integer, t1> D;
    @d
    private final l<Integer, t1> E;
    @d
    private final g F;
    @d
    private final l<Pair<String, String>, t1> G;
    @d
    private final l<Pair<String, String>, t1> H;
    @d
    private final l<List<Rarity>, t1> I;
    @d
    private final l<Boolean, t1> J;
    private boolean K;
    @d
    private final d0 L;
    @e
    private ValueAnimator M;
    @d
    private final g N;
    @d
    private final g O;
    @d
    private final e.t.j.h.l P;
    @d
    private final g Q;
    @e
    private ImageView R;
    private final int r;
    private final int s;
    @d
    private final h.m2.e t;
    @d
    private final h.m2.e u;
    @d
    private final h.m2.e v;
    @d
    private final h.m2.e w;
    @d
    private final b x;
    @d
    private final w y;
    @d
    private final w z;

    /* loaded from: classes2.dex */
    public static final class a implements Animator.AnimatorListener {
        public a() {
            ShopFragment.this = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@d Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@d Animator animator) {
            ShopFragment shopFragment = ShopFragment.this;
            shopFragment.P0(!shopFragment.N0());
            RecyclerView.LayoutManager layoutManager = ShopFragment.this.u0().getScrollable().getLayoutManager();
            Integer valueOf = layoutManager == null ? null : Integer.valueOf(s.a(layoutManager));
            if ((valueOf == null ? 0 : valueOf.intValue()) > 1 && ShopFragment.this.N0()) {
                ShopFragment shopFragment2 = ShopFragment.this;
                shopFragment2.Q0(0, -shopFragment2.w0().getHeight(), 300L);
                return;
            }
            if ((valueOf == null ? 0 : valueOf.intValue()) > 1 || ShopFragment.this.N0()) {
                return;
            }
            ShopFragment shopFragment3 = ShopFragment.this;
            shopFragment3.Q0(-shopFragment3.w0().getHeight(), 0, 300L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@d Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@d Animator animator) {
        }
    }

    static {
        n<Object>[] nVarArr = new n[8];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(ShopFragment.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(ShopFragment.class), "ll_scrollView", "getLl_scrollView()Landroid/widget/LinearLayout;"));
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(ShopFragment.class), "rarityFilter", "getRarityFilter()Lcom/jihuanshe/ui/widget/RarityFilterBtn;"));
        nVarArr[3] = n0.r(new PropertyReference1Impl(n0.d(ShopFragment.class), "llBar", "getLlBar()Landroid/widget/LinearLayout;"));
        S = nVarArr;
    }

    public ShopFragment() {
        d.a aVar = e.t.o.d.a;
        this.r = d.a.c(aVar, null, 1, null).d(12);
        this.s = d.a.c(aVar, null, 1, null).d(16);
        this.t = BindViewKt.s(this, R.id.listView);
        this.u = BindViewKt.s(this, R.id.ll_scrollView);
        this.v = BindViewKt.s(this, R.id.rarityFilter);
        this.w = BindViewKt.s(this, R.id.llBar);
        this.x = new b(d.a.c(aVar, null, 1, null).d(9));
        this.y = z.c(ShopFragment$layoutManager$2.INSTANCE);
        this.z = z.c(ShopFragment$decoration$2.INSTANCE);
        this.A = z.c(new ShopFragment$header$2(this));
        this.B = z.c(ShopFragment$adapter$2.INSTANCE);
        this.C = d.g.a.a(new ShopFragment$onLoadMore$1(this));
        this.D = new ShopFragment$onChooseCategory$1(this);
        this.E = new ShopFragment$onChooseCardPkg$1(this);
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.F = dVar.a(new ShopFragment$onClickRank$1(this));
        this.G = new ShopFragment$chooseFilter$1(this);
        this.H = new ShopFragment$statFilter$1(this);
        this.I = new ShopFragment$chooseRarity$1(this);
        this.J = new ShopFragment$showState$1(this);
        this.K = true;
        d.e eVar = d.e.a;
        this.L = eVar.c(new ShopFragment$onViewScroll$1(this));
        this.N = dVar.a(new ShopFragment$onBannerClick$1(this));
        this.O = dVar.a(new ShopFragment$onBannerDetailClick$1(this));
        this.P = eVar.a(new ShopFragment$onItemClick$1(this));
        this.Q = dVar.a(new ShopFragment$onClickCalendar$1(this));
    }

    public final void L0() {
        GameBar.b.a().f(this, new ShopFragment$initGameObserver$1(this));
    }

    private final void M0() {
        f.b.e(this).g(e.l.j.a.t, new ShopFragment$initObserver$1(this));
        e.n.f.g(((ShopViewModel) T()).x0(), null, new ShopFragment$initObserver$2(this), 1, null);
        ((ShopViewModel) T()).w0().f(this, new ShopFragment$initObserver$3(this));
        ((ShopViewModel) T()).n().f(this, new ShopFragment$initObserver$4(this));
        ((ShopViewModel) T()).M().f(this, new ShopFragment$initObserver$5(this));
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        ((ShopViewModel) T()).W().f(this, new ShopFragment$initObserver$6(booleanRef, this));
    }

    public final void Q0(int i2, int i3, long j2) {
        ValueAnimator e2 = e.t.u.b.a.e(i2, i3, j2);
        this.M = e2;
        if (e2 != null) {
            e2.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        ValueAnimator valueAnimator = this.M;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(m0());
        }
        ValueAnimator valueAnimator2 = this.M;
        if (valueAnimator2 != null) {
            valueAnimator2.addListener(r0());
        }
        ValueAnimator valueAnimator3 = this.M;
        if (valueAnimator3 == null) {
            return;
        }
        valueAnimator3.start();
    }

    public final void R0(String str) {
        r rVar = r.a;
        Game value = GameBar.b.a().getValue();
        String shortName = value == null ? null : value.getShortName();
        Category value2 = ((ShopViewModel) T()).x0().getValue();
        String name = value2 == null ? null : value2.getName();
        CardPackage value3 = ((ShopViewModel) T()).w0().getValue();
        String packName = value3 == null ? null : value3.getPackName();
        CardPackage value4 = ((ShopViewModel) T()).w0().getValue();
        rVar.i(shortName, name, packName, value4 != null ? value4.getPackAlias() : null, str);
    }

    public static final void e0(ShopFragment shopFragment, ValueAnimator valueAnimator) {
        LinearLayout w0 = shopFragment.w0();
        Object animatedValue = valueAnimator == null ? null : valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        ViewKt.v(w0, 0, Integer.valueOf(((Integer) animatedValue).intValue()), 0, 0);
    }

    private final ValueAnimator.AnimatorUpdateListener m0() {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: e.l.q.b.g.b.e
            {
                ShopFragment.this = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShopFragment.e0(ShopFragment.this, valueAnimator);
            }
        };
    }

    private final Animator.AnimatorListener r0() {
        return new a();
    }

    public final LinearLayout v0() {
        return (LinearLayout) this.w.a(this, S[3]);
    }

    @k.e.a.d
    public final l<Integer, t1> A0() {
        return this.D;
    }

    @k.e.a.d
    public final g B0() {
        return this.Q;
    }

    @k.e.a.d
    public final g C0() {
        return this.F;
    }

    @k.e.a.d
    public final e.t.j.h.l D0() {
        return this.P;
    }

    @k.e.a.d
    public final p E0() {
        return this.C;
    }

    @k.e.a.d
    public final d0 F0() {
        return this.L;
    }

    @k.e.a.d
    public final RarityFilterBtn G0() {
        return (RarityFilterBtn) this.v.a(this, S[2]);
    }

    @k.e.a.d
    public final l<Boolean, t1> H0() {
        return this.J;
    }

    @k.e.a.d
    public final l<Pair<String, String>, t1> I0() {
        return this.H;
    }

    public final int J0() {
        return this.s;
    }

    public final int K0() {
        return this.r;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    public void M() {
        BinderKt.p(BinderKt.e(e.g.d.a.o(e.g.d.a.j(((ShopViewModel) T()).D0(), null, new ShopFragment$onRetryClick$1(this), 1, null), null, new ShopFragment$onRetryClick$2(this), 1, null), this, u0(), false, 4, null));
    }

    public final boolean N0() {
        return this.K;
    }

    public final void P0(boolean z) {
        this.K = z;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    @RequiresApi(23)
    public void d() {
        super.d();
        M0();
        M();
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void j() {
        super.j();
        A().setBackgroundResource(R.color.black_f8f8fa);
        ImageView imageView = new ImageView(getActivity());
        ViewKt.v(imageView, Integer.valueOf(d.a.c(e.t.o.d.a, null, 1, null).d(12)), 0, 0, 0);
        Drawable q = Res.q(Res.a, R.drawable.svg_search, null, 2, null);
        if (q != null) {
            q.setTint(Res.k(R.color.black));
        }
        imageView.setImageDrawable(q);
        imageView.setBackgroundResource(R.drawable.bg_search_left_bar);
        ViewKt.x(imageView, new ShopFragment$flowOfAppBar$1$1(this));
        t1 t1Var = t1.a;
        this.R = imageView;
        A().getStart().b(new ShopFragment$flowOfAppBar$2(this));
        A().getMid().b(new ShopFragment$flowOfAppBar$3(this));
    }

    @k.e.a.d
    public final e.l.g.g l0() {
        return (e.l.g.g) this.B.getValue();
    }

    @k.e.a.d
    public final b n0() {
        return this.x;
    }

    @k.e.a.d
    public final l<Pair<String, String>, t1> o0() {
        return this.G;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@k.e.a.d View view, @e Bundle bundle) {
        List<Category> value = ((ShopViewModel) T()).u0().getValue();
        if (value == null || value.isEmpty()) {
            R(ViewState.LOADING);
        }
        super.onViewCreated(view, bundle);
    }

    @k.e.a.d
    public final l<List<Rarity>, t1> p0() {
        return this.I;
    }

    @k.e.a.d
    public final e.l.h.j.b.f.a q0() {
        return (e.l.h.j.b.f.a) this.z.getValue();
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        i8 e2 = i8.e(getLayoutInflater());
        e2.i(this);
        e2.j((ShopViewModel) T());
        return e2;
    }

    @k.e.a.d
    public final View s0() {
        return (View) this.A.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a t0() {
        return (LayoutManagers.a) this.y.getValue();
    }

    @k.e.a.d
    public final ListView u0() {
        return (ListView) this.t.a(this, S[0]);
    }

    @k.e.a.d
    public final LinearLayout w0() {
        return (LinearLayout) this.u.a(this, S[1]);
    }

    @k.e.a.d
    public final g x0() {
        return this.N;
    }

    @k.e.a.d
    public final g y0() {
        return this.O;
    }

    @k.e.a.d
    public final l<Integer, t1> z0() {
        return this.E;
    }
}
