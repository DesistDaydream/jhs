package com.jihuanshe.ui.page.main.me;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import com.jihuanshe.R;
import com.jihuanshe.base.bus.Bus;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.viewmodel.main.me.MeViewModel;
import com.vector.design.ui.frag.SimpleFragEx;
import e.l.h.d.f;
import e.l.h.d.h;
import e.l.k.y6;
import e.t.j.h.g;
import h.k2.v.f0;
import h.k2.v.u;
import inject.annotation.creator.Creator;
import k.e.a.d;

@Creator
/* loaded from: classes2.dex */
public final class MeFragment extends BaseFragment<MeViewModel> {
    @d
    public static final a O = new a(null);
    @d
    private static final String P = "MeFragment";
    @d
    private final g A;
    @d
    private final g B;
    @d
    private final g C;
    @d
    private final g D;
    @d
    private final g E;
    @d
    private final g F;
    @d
    private final g G;
    @d
    private final g H;
    @d
    private final g I;
    @d
    private final g J;
    @d
    private final g K;
    @d
    private final g L;
    @d
    private final g M;
    private boolean N;
    @d
    private final e.t.r.a.a r = new e.t.r.a.a(0, 0, 3, null);
    @d
    private final g s;
    @d
    private final g t;
    @d
    private final g u;
    @d
    private final g v;
    @d
    private final g w;
    @d
    private final g x;
    @d
    private final g y;
    @d
    private final g z;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<T> implements Observer {
        public final /* synthetic */ Bus a;
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MeFragment f4027c;

        public b(Bus bus, String str, MeFragment meFragment) {
            this.a = bus;
            this.b = str;
            this.f4027c = meFragment;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(h hVar) {
            if (this.a.e().getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED || !f0.g(hVar.g(), this.b)) {
                return;
            }
            Object f2 = hVar.f();
            if (f2 != null && (f2 instanceof User)) {
                ((MeViewModel) this.f4027c.T()).s0().r((User) f2);
            }
            new e.t.l.h();
        }
    }

    public MeFragment() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.s = dVar.a(new MeFragment$onClickBuyIn$1(this));
        this.t = dVar.a(new MeFragment$onClickSellOut$1(this));
        this.u = dVar.a(new MeFragment$onClickFollow$1(this));
        this.v = dVar.a(new MeFragment$onClickFans$1(this));
        this.w = dVar.a(new MeFragment$onClickCoin$1(this));
        this.x = dVar.a(new MeFragment$onClickEdit$1(this));
        this.y = dVar.a(new MeFragment$onClickShopCart$1(this));
        this.z = dVar.a(new MeFragment$onClickSelling$1(this));
        this.A = dVar.a(new MeFragment$onClickBlackList$1(this));
        this.B = dVar.a(new MeFragment$onClickWantBuy$1(this));
        this.C = dVar.a(new MeFragment$onClickSellerConfirm$1(this));
        this.D = dVar.a(new MeFragment$onClickMineEntrepot$1(this));
        this.E = dVar.a(new MeFragment$onClickWishList$1(this));
        this.F = dVar.a(new MeFragment$onClickBanRecord$1(this));
        this.G = dVar.a(new MeFragment$onClickHelp$1(this));
        this.H = dVar.a(new MeFragment$onClickAbout$1(this));
        this.I = dVar.a(new MeFragment$onClickAccountManager$1(this));
        this.J = dVar.a(MeFragment$onClickGM$1.INSTANCE);
        this.K = dVar.a(new MeFragment$onClickRealNameConfirm$1(this));
        this.L = dVar.a(new MeFragment$onClickMyShop$1(this));
        this.M = dVar.a(new MeFragment$onClickGroup$1(this));
        this.N = true;
    }

    private final void A0() {
        f fVar = f.b;
        Bus e2 = fVar.e(this);
        e2.l(e2.e(), e2.d(), new b(e2, e.l.j.a.f12239i, this));
        fVar.e(this).g(e.l.j.a.s, new MeFragment$initObserver$2(this));
    }

    public final void B0() {
        if (this.N) {
            this.N = false;
        } else {
            ((MeViewModel) T()).t0();
        }
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @d
    public SimpleFragEx.LazyLoadMode F() {
        return SimpleFragEx.LazyLoadMode.RESUME;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    public void M() {
        ((MeViewModel) T()).t0();
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        A0();
        M();
    }

    @d
    public final g e0() {
        return this.H;
    }

    @d
    public final g f0() {
        return this.I;
    }

    @d
    public final g g0() {
        return this.F;
    }

    @d
    public final g h0() {
        return this.A;
    }

    @d
    public final g i0() {
        return this.s;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void j() {
        super.j();
        A().setBackgroundResource(R.color.common_color_1);
    }

    @d
    public final g j0() {
        return this.w;
    }

    @d
    public final g k0() {
        return this.x;
    }

    @d
    public final g l0() {
        return this.v;
    }

    @d
    public final g m0() {
        return this.u;
    }

    @d
    public final g n0() {
        return this.J;
    }

    @d
    public final g o0() {
        return this.M;
    }

    @Override // com.jihuanshe.ui.BaseFragment, e.l.h.j.a.a, com.vector.design.ui.frag.SimpleFragEx, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((MeViewModel) T()).p0();
    }

    @d
    public final g p0() {
        return this.G;
    }

    @d
    public final g q0() {
        return this.D;
    }

    @d
    public final g r0() {
        return this.L;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @d
    public ViewDataBinding s() {
        y6 e2 = y6.e(getLayoutInflater());
        e2.i(this);
        e2.j((MeViewModel) T());
        return e2;
    }

    @d
    public final g s0() {
        return this.K;
    }

    @d
    public final g t0() {
        return this.t;
    }

    @d
    public final g u0() {
        return this.C;
    }

    @d
    public final g v0() {
        return this.z;
    }

    @d
    public final g w0() {
        return this.y;
    }

    @d
    public final g x0() {
        return this.B;
    }

    @d
    public final g y0() {
        return this.E;
    }

    @d
    public final e.t.r.a.a z0() {
        return this.r;
    }
}
