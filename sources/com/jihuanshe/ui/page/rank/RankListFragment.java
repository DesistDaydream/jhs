package com.jihuanshe.ui.page.rank;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.RankTypeInfo;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.ui.page.rank.RankListFragment;
import com.jihuanshe.viewmodel.rank.RankListViewModel;
import com.jihuanshe.viewmodel.rank.RankViewModel;
import com.vector.design.ui.frag.SimpleFragEx;
import com.vector.ext.bind.BindViewKt;
import com.vector.ext.view.ViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.p0;
import e.l.k.g7;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.d0;
import e.t.j.h.l;
import e.t.j.h.p;
import e.t.o.d;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class RankListFragment extends BaseFragment<RankListViewModel> {
    @d
    public static final a E;
    public static final /* synthetic */ n<Object>[] F;
    @d
    private static final String G;
    @d
    private static final String H;
    @d
    private final d0 A;
    @e
    private ValueAnimator B;
    @d
    private final p C;
    @e
    private RankActivity D;
    @f.a.a.a
    @e
    private RankTypeInfo rankTypeInfo;
    @d
    private final l v;
    @d
    private final w w;
    private int x;
    private final int y;
    private boolean z;
    @d
    private final w r = z.c(new RankListFragment$parentViewModel$2(this));
    @d
    private final h.m2.e s = BindViewKt.s(this, R.id.listView);
    @d
    private final e.t.r.a.a t = new e.t.r.a.a(0, 0, 3, null);
    @d
    private final w u = z.c(RankListFragment$adapter$2.INSTANCE);

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final String a() {
            return RankListFragment.H;
        }

        @d
        public final String b() {
            return RankListFragment.G;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements Animator.AnimatorListener {
        public b() {
            RankListFragment.this = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@d Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@d Animator animator) {
            RankListFragment rankListFragment = RankListFragment.this;
            rankListFragment.D0(!rankListFragment.z0());
            if (RankListFragment.this.w0() > RankListFragment.this.x0() && RankListFragment.this.z0()) {
                RankListFragment rankListFragment2 = RankListFragment.this;
                rankListFragment2.G0(0, -rankListFragment2.k0().Y().getHeight(), 300L);
            } else if (RankListFragment.this.w0() >= RankListFragment.this.x0() || RankListFragment.this.z0()) {
            } else {
                RankListFragment rankListFragment3 = RankListFragment.this;
                rankListFragment3.G0(-rankListFragment3.k0().Y().getHeight(), 0, 300L);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@d Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@d Animator animator) {
        }
    }

    static {
        n<Object>[] nVarArr = new n[4];
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(RankListFragment.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        F = nVarArr;
        E = new a(null);
        G = "pack";
        H = "card_version";
    }

    public RankListFragment() {
        d.e eVar = d.e.a;
        this.v = eVar.a(new RankListFragment$onItemClick$1(this));
        this.w = z.c(RankListFragment$layoutManager$2.INSTANCE);
        this.y = d.a.c(e.t.o.d.a, null, 1, null).d(300);
        this.z = true;
        this.A = eVar.c(new RankListFragment$onViewScroll$1(this));
        this.C = d.g.a.a(new RankListFragment$onLoadMore$1(this));
    }

    public final void B0() {
        ViewKt.v(this.D.Y(), 0, 0, 0, 0);
        this.z = true;
        this.x = 0;
    }

    public final void G0(int i2, int i3, long j2) {
        ValueAnimator e2 = e.t.u.b.a.e(i2, i3, j2);
        this.B = e2;
        if (e2 != null) {
            e2.setInterpolator(new AccelerateDecelerateInterpolator());
        }
        ValueAnimator valueAnimator = this.B;
        if (valueAnimator != null) {
            valueAnimator.addUpdateListener(m0());
        }
        ValueAnimator valueAnimator2 = this.B;
        if (valueAnimator2 != null) {
            valueAnimator2.addListener(n0());
        }
        ValueAnimator valueAnimator3 = this.B;
        if (valueAnimator3 == null) {
            return;
        }
        valueAnimator3.start();
    }

    public static final void e0(RankListFragment rankListFragment, ValueAnimator valueAnimator) {
        ConstraintLayout Y = rankListFragment.k0().Y();
        Object animatedValue = valueAnimator == null ? null : valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        ViewKt.v(Y, 0, Integer.valueOf(((Integer) animatedValue).intValue()), 0, 0);
    }

    private final ValueAnimator.AnimatorUpdateListener m0() {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: e.l.q.b.i.b
            {
                RankListFragment.this = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RankListFragment.e0(RankListFragment.this, valueAnimator);
            }
        };
    }

    private final Animator.AnimatorListener n0() {
        return new b();
    }

    private final void y0() {
        f.g(t0().q0(), null, new RankListFragment$initObserver$1(this), 1, null);
        f.g(t0().p0(), null, new RankListFragment$initObserver$2(this), 1, null);
    }

    public final void C0(@e RankActivity rankActivity) {
        this.D = rankActivity;
    }

    public final void D0(boolean z) {
        this.z = z;
    }

    public final void E0(@e RankTypeInfo rankTypeInfo) {
        this.rankTypeInfo = rankTypeInfo;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public SimpleFragEx.LazyLoadMode F() {
        return SimpleFragEx.LazyLoadMode.RESUME;
    }

    public final void F0(int i2) {
        this.x = i2;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    public void M() {
        e.g.d.a r0;
        RankListViewModel rankListViewModel = (RankListViewModel) T();
        Integer value = t0().p0().getValue();
        String str = (value != null && value.intValue() == 1) ? H : G;
        RankTypeInfo rankTypeInfo = this.rankTypeInfo;
        int rankingTypeID = rankTypeInfo == null ? 0 : rankTypeInfo.getRankingTypeID();
        Game value2 = t0().r0().getValue();
        String gameKey = value2 == null ? null : value2.getGameKey();
        if (gameKey == null) {
            gameKey = "";
        }
        Game value3 = t0().r0().getValue();
        String gameSubKey = value3 != null ? value3.getGameSubKey() : null;
        r0 = rankListViewModel.r0(str, rankingTypeID, (r13 & 4) != 0 ? null : gameKey, (r13 & 8) != 0 ? null : gameSubKey != null ? gameSubKey : "", (r13 & 16) != 0 ? null : null);
        BinderKt.p(r0);
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        y0();
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void f() {
        FragmentActivity activity = getActivity();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type com.jihuanshe.ui.page.rank.RankActivity");
        this.D = (RankActivity) activity;
        M();
    }

    @e
    public final RankActivity k0() {
        return this.D;
    }

    @k.e.a.d
    public final p0 l0() {
        return (p0) this.u.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a o0() {
        return (LayoutManagers.a) this.w.getValue();
    }

    @k.e.a.d
    public final ListView p0() {
        return (ListView) this.s.a(this, F[1]);
    }

    @k.e.a.d
    public final l q0() {
        return this.v;
    }

    @k.e.a.d
    public final p r0() {
        return this.C;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        g7 e2 = g7.e(getLayoutInflater());
        e2.i(this);
        e2.j((RankListViewModel) T());
        return e2;
    }

    @k.e.a.d
    public final d0 s0() {
        return this.A;
    }

    @k.e.a.d
    public final RankViewModel t0() {
        return (RankViewModel) this.r.getValue();
    }

    @e
    public final RankTypeInfo u0() {
        return this.rankTypeInfo;
    }

    @k.e.a.d
    public final e.t.r.a.a v0() {
        return this.t;
    }

    public final int w0() {
        return this.x;
    }

    public final int x0() {
        return this.y;
    }

    public final boolean z0() {
        return this.z;
    }
}
