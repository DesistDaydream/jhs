package com.jihuanshe.ui.page.user;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.appbar.AppBarLayout;
import com.jihuanshe.R;
import com.jihuanshe.adapter.ShopCarAdapter;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.dialog.CardErrorCorrectionDialog;
import com.jihuanshe.ui.dialog.CardProductDialogFragment;
import com.jihuanshe.ui.page.user.SellerDetailActivity;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.ui.widget.MinConstraintLayout;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import com.jihuanshe.ui.widget.UserBar;
import com.jihuanshe.utils.ImagePicker;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import com.vector.config.AppBarState;
import com.vector.ext.bind.BindViewKt;
import com.vector.ext.view.ViewKt;
import com.vector.network.image.NImageView;
import com.vector.util.LayoutManagers;
import com.vector.util.Res;
import com.vector.view.scrollable.ListView;
import e.l.g.u0;
import e.l.g.y;
import e.l.k.i2;
import e.l.q.a.k0.r;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.l;
import e.t.j.h.p;
import e.t.j.h.t;
import e.t.k.a.f.h;
import e.t.o.d;
import e.t.r.a.b;
import f.a.a.a;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.u;
import h.m2.e;
import h.p2.n;
import h.t1;
import h.w;
import h.z;
import i.b.b1;
import i.b.i;
import inject.annotation.creator.Creator;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class SellerDetailActivity extends BaseActivity<SellerDetailViewModel> {
    public static final /* synthetic */ n<Object>[] l0;
    @d
    private final w A;
    @d
    private final g B;
    @d
    private final w C;
    @d
    private final w D;
    @d
    private final l E;
    @d
    private final e F;
    @d
    private final w G;
    @d
    private final e H;
    @d
    private final w I;
    @d
    private final Runnable J;
    private boolean K;
    private boolean L;
    @d
    private final t M;
    @d
    private final g N;
    @d
    private final g O;
    @d
    private final g P;
    private boolean Q;
    @d
    private final g R;
    @d
    private final g S;
    @d
    private final g T;
    @d
    private final l U;
    @d
    private final g V;
    @d
    private final p W;
    @k.e.a.e
    private TextView X;
    @k.e.a.e
    private ImageView Y;
    @k.e.a.e
    private ImageView Z;
    @k.e.a.e
    private ImageView a0;
    @k.e.a.e
    private UserBar b0;
    @k.e.a.e
    private ImageView c0;
    @a
    private int cid;
    @k.e.a.e
    private TextView d0;
    @k.e.a.e
    private ImageView e0;
    private boolean f0;
    @d
    private final g g0;
    @d
    private final g h0;
    @d
    private final g i0;
    @a(true)
    private boolean ignoreVersion;
    @k.e.a.e
    private CardErrorCorrectionDialog j0;
    @k.e.a.e
    private h k0;
    @d
    private final ImagePicker n = new ImagePicker(this, 0, 0.0f, new SellerDetailActivity$imagePicker$1(this), 6, (u) null);
    private final int o;
    private final int p;
    @d
    private final e q;
    @d
    private final e r;
    @d
    private final e s;
    @d
    private final b t;
    @d
    private final e.t.r.a.a u;
    @a
    private int uid;
    @d
    private final w v;
    @d
    private final w w;
    @a(true)
    @k.e.a.e
    private Integer wid;
    @a(true)
    @k.e.a.e
    private Boolean wish;
    @d
    private final w x;
    @d
    private final w y;
    @d
    private final w z;

    static {
        n<Object>[] nVarArr = new n[15];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(SellerDetailActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(SellerDetailActivity.class), "minView", "getMinView()Lcom/jihuanshe/ui/widget/MinConstraintLayout;"));
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(SellerDetailActivity.class), "rarityFilterShop", "getRarityFilterShop()Lcom/jihuanshe/ui/widget/RarityFilterBtn;"));
        nVarArr[11] = n0.r(new PropertyReference1Impl(n0.d(SellerDetailActivity.class), "shopDialog", "getShopDialog()Landroid/view/View;"));
        nVarArr[13] = n0.r(new PropertyReference1Impl(n0.d(SellerDetailActivity.class), "shopCarBg", "getShopCarBg()Landroid/view/View;"));
        l0 = nVarArr;
    }

    public SellerDetailActivity() {
        d.a aVar = e.t.o.d.a;
        this.o = d.a.c(aVar, null, 1, null).d(79);
        this.p = d.a.c(aVar, null, 1, null).d(106);
        this.q = BindViewKt.n(this, R.id.listView);
        this.r = BindViewKt.n(this, R.id.minView);
        this.s = BindViewKt.n(this, R.id.rarityFilterShop);
        this.t = new b(d.a.c(aVar, null, 1, null).d(9));
        this.u = new e.t.r.a.a(0, 0, 3, null);
        this.v = z.c(new SellerDetailActivity$header$2(this));
        this.w = z.c(SellerDetailActivity$adapter$2.INSTANCE);
        this.x = z.c(new SellerDetailActivity$shopCarAdapter$2(this));
        this.y = z.c(SellerDetailActivity$layoutManager$2.INSTANCE);
        this.z = z.c(SellerDetailActivity$shopCarManager$2.INSTANCE);
        this.A = z.c(SellerDetailActivity$decoration$2.INSTANCE);
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.B = dVar.a(new SellerDetailActivity$onClickCancel$1(this));
        this.C = z.c(SellerDetailActivity$adapterFilter$2.INSTANCE);
        this.D = z.c(SellerDetailActivity$layoutManagerFilter$2.INSTANCE);
        d.e eVar = d.e.a;
        this.E = eVar.a(new SellerDetailActivity$onFilterItemClick$1(this));
        this.F = BindViewKt.n(this, R.id.shopCarDialog);
        this.G = z.c(new SellerDetailActivity$slideUp$2(this));
        this.H = BindViewKt.n(this, R.id.shopCarBg);
        this.I = z.c(new SellerDetailActivity$alphaBg$2(this));
        this.J = new Runnable() { // from class: e.l.q.b.l.a
            {
                SellerDetailActivity.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                SellerDetailActivity.n0(SellerDetailActivity.this);
            }
        };
        this.L = true;
        this.M = d.a.a.a(new SellerDetailActivity$onScroll$1(this));
        this.N = dVar.a(new SellerDetailActivity$onClickShopCar$1(this));
        this.O = dVar.a(SellerDetailActivity$onClickService$1.INSTANCE);
        this.P = dVar.a(new SellerDetailActivity$onBannerClick$1(this));
        this.Q = true;
        this.R = dVar.a(new SellerDetailActivity$onClickFollow$1(this));
        this.S = dVar.a(new SellerDetailActivity$onClickCl$1(this));
        this.T = dVar.a(new SellerDetailActivity$onClickContact$1(this));
        this.U = eVar.a(new SellerDetailActivity$onItemClick$1(this));
        this.V = dVar.a(new SellerDetailActivity$onConfirm$1(this));
        this.W = d.g.a.a(new SellerDetailActivity$onLoadMore$1(this));
        this.f0 = true;
        this.g0 = dVar.a(new SellerDetailActivity$clearShopCar$1(this));
        this.h0 = dVar.a(SellerDetailActivity$clickNo$1.INSTANCE);
        this.i0 = dVar.a(new SellerDetailActivity$closeShopCar$1(this));
    }

    public final View V0() {
        return (View) this.H.a(this, l0[13]);
    }

    public final View X0() {
        return (View) this.F.a(this, l0[11]);
    }

    public final r Y0() {
        return (r) this.G.getValue();
    }

    public final void c1(Uri uri) {
        if (uri == null) {
            return;
        }
        h hVar = this.k0;
        if (hVar != null) {
            hVar.n();
        }
        h hVar2 = new h(this, false, 2, null);
        this.k0 = hVar2;
        if (hVar2 != null) {
            hVar2.W();
        }
        i.f(LifecycleOwnerKt.getLifecycleScope(this), b1.c(), null, new SellerDetailActivity$handleUri$1(uri, this, null), 2, null);
    }

    private final void d1() {
        ((SellerDetailViewModel) L()).z(this, new SellerDetailActivity$initObserver$1(this));
        ((SellerDetailViewModel) L()).U(this, new SellerDetailActivity$initObserver$2(this));
        f.g(((SellerDetailViewModel) L()).H0(), null, new SellerDetailActivity$initObserver$3(this), 1, null);
        ((SellerDetailViewModel) L()).N0().f(this, new SellerDetailActivity$initObserver$4(this));
        ((SellerDetailViewModel) L()).V0().f(this, new SellerDetailActivity$initObserver$5(this));
        e.l.h.d.f.b.e(this).g(e.l.j.a.C, new SellerDetailActivity$initObserver$6(this));
    }

    public final void g1(CardProduct cardProduct, int i2) {
        BinderKt.p(BinderKt.k(e.g.d.a.j(((SellerDetailViewModel) L()).A0(cardProduct, i2), null, new SellerDetailActivity$joinShopCar$1(this, cardProduct), 1, null), this, false, 2, null));
    }

    public final void i1(CardProduct cardProduct) {
        BinderKt.p(BinderKt.k(e.g.d.a.j(((SellerDetailViewModel) L()).e1(cardProduct.getCid()), null, new SellerDetailActivity$minusShopCar$1(this, cardProduct), 1, null), this, false, 2, null));
    }

    public static final void n0(SellerDetailActivity sellerDetailActivity) {
        ViewKt.n(sellerDetailActivity.X0());
    }

    public static /* synthetic */ void n1(SellerDetailActivity sellerDetailActivity, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        sellerDetailActivity.m1(z);
    }

    public final e.l.q.a.k0.l q0() {
        return (e.l.q.a.k0.l) this.I.getValue();
    }

    @k.e.a.d
    public final View A0() {
        return (View) this.v.getValue();
    }

    public final boolean B0() {
        return this.ignoreVersion;
    }

    @k.e.a.d
    public final LayoutManagers.a C0() {
        return (LayoutManagers.a) this.y.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a D0() {
        return (LayoutManagers.a) this.D.getValue();
    }

    @k.e.a.d
    public final ListView E0() {
        return (ListView) this.q.a(this, l0[0]);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        BinderKt.s(e.g.d.a.j(((SellerDetailViewModel) L()).Y0(this.uid), null, new SellerDetailActivity$onRetryClick$1(this), 1, null), this, false, false, 4, null);
    }

    @k.e.a.d
    public final MinConstraintLayout F0() {
        return (MinConstraintLayout) this.r.a(this, l0[1]);
    }

    @k.e.a.d
    public final g G0() {
        return this.P;
    }

    @k.e.a.d
    public final g H0() {
        return this.B;
    }

    @k.e.a.d
    public final g I0() {
        return this.S;
    }

    @k.e.a.d
    public final g J0() {
        return this.T;
    }

    @k.e.a.d
    public final g K0() {
        return this.R;
    }

    @k.e.a.d
    public final g L0() {
        return this.O;
    }

    @k.e.a.d
    public final g M0() {
        return this.N;
    }

    @k.e.a.d
    public final g N0() {
        return this.V;
    }

    @k.e.a.d
    public final l O0() {
        return this.E;
    }

    @k.e.a.d
    public final l P0() {
        return this.U;
    }

    @k.e.a.d
    public final p Q0() {
        return this.W;
    }

    @k.e.a.d
    public final t R0() {
        return this.M;
    }

    @k.e.a.d
    public final RarityFilterBtn S0() {
        return (RarityFilterBtn) this.s.a(this, l0[2]);
    }

    @k.e.a.d
    public final e.t.r.a.a T0() {
        return this.u;
    }

    @k.e.a.d
    public final ShopCarAdapter U0() {
        return (ShopCarAdapter) this.x.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a W0() {
        return (LayoutManagers.a) this.z.getValue();
    }

    public final int Z0() {
        return this.uid;
    }

    @k.e.a.e
    public final Integer a1() {
        return this.wid;
    }

    @k.e.a.e
    public final Boolean b1() {
        return this.wish;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        super.d();
        ((SellerDetailViewModel) L()).U0().f(this, new SellerDetailActivity$flowOfSetup$1(this));
        ((SellerDetailViewModel) L()).X0().f(this, new SellerDetailActivity$flowOfSetup$2(this));
        GameBar.a aVar = GameBar.b;
        aVar.a().f(this, new SellerDetailActivity$flowOfSetup$3(this));
        e.n.l M0 = ((SellerDetailViewModel) L()).M0();
        Boolean bool = this.wish;
        Boolean bool2 = Boolean.TRUE;
        M0.r(Integer.valueOf(f0.g(bool, bool2) ? 1 : 0));
        E0().setNestedScrollingEnabled(false);
        ViewGroup.LayoutParams layoutParams = F0().getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        AppBarLayout.LayoutParams layoutParams2 = (AppBarLayout.LayoutParams) layoutParams;
        layoutParams2.d(0);
        F0().setLayoutParams(layoutParams2);
        d1();
        F();
        if (this.cid > 0 && !f0.g(this.wish, bool2)) {
            CardProductDialogFragment.a aVar2 = CardProductDialogFragment.w;
            Integer valueOf = Integer.valueOf(this.uid);
            Integer valueOf2 = Integer.valueOf(this.cid);
            Game value = aVar.a().getValue();
            String gameKey = value == null ? null : value.getGameKey();
            Game value2 = aVar.a().getValue();
            aVar2.a(valueOf, valueOf2, gameKey, value2 == null ? null : value2.getGameSubKey()).show(getSupportFragmentManager(), "card_product");
        }
        e.g.d.a.j(((SellerDetailViewModel) L()).L0(this.uid), null, new SellerDetailActivity$flowOfSetup$4(this), 1, null);
    }

    public final boolean e1() {
        return this.Q;
    }

    public final boolean f1() {
        return this.f0;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundColor(Res.k(R.color.white));
        w().setBackgroundAlpha(0);
        if (this.uid == Constants.Companion.getWAREHOUSE_SELLER_USER_ID()) {
            this.c0 = (ImageView) ((ViewGroup) w().getStart().d(new SellerDetailActivity$flowOfAppBar$1(this))).getChildAt(0);
            w().getMid().b(new SellerDetailActivity$flowOfAppBar$2(this));
            this.e0 = (ImageView) ((ViewGroup) w().getEnd().d(new SellerDetailActivity$flowOfAppBar$3(this))).getChildAt(0);
            return;
        }
        this.b0 = new UserBar(this, null, 2, null);
        w().getStart().a(this.b0);
        ImageView backImage = this.b0.getBackImage();
        this.a0 = backImage;
        if (backImage != null) {
            backImage.setImageTintList(ColorStateList.valueOf(-1));
        }
        TextView textView = new TextView(this);
        Drawable q = Res.q(Res.a, R.drawable.svg_arrow_down, null, 2, null);
        if (q != null) {
            q.setTint(Res.k(R.color.white));
        }
        q.setBounds(0, 0, q.getMinimumWidth(), q.getMinimumHeight());
        textView.setCompoundDrawables(null, null, q, null);
        Game value = GameBar.b.a().getValue();
        textView.setText(value == null ? null : value.getShortName());
        textView.setTextColor(Res.k(R.color.white));
        textView.setTextSize(2, 16.0f);
        textView.getPaint().setFakeBoldText(true);
        ViewKt.x(textView, new SellerDetailActivity$flowOfAppBar$4$1(this));
        t1 t1Var = t1.a;
        this.X = textView;
        w().getMid().b(new SellerDetailActivity$flowOfAppBar$5(this));
        ImageView imageView = (ImageView) ((ViewGroup) w().getEnd().d(new SellerDetailActivity$flowOfAppBar$6(this))).getChildAt(0);
        this.Y = imageView;
        if (imageView != null) {
            ViewKt.n(imageView);
        }
        this.Z = (ImageView) ((ViewGroup) w().getEnd().d(new SellerDetailActivity$flowOfAppBar$7(this))).getChildAt(0);
        w().setPadding(0, 0, d.a.c(e.t.o.d.a, null, 1, null).d(12), 0);
    }

    @k.e.a.d
    public final g j1(@k.e.a.d CardProduct cardProduct) {
        return e.t.j.h.d.a.a(new SellerDetailActivity$onAddClick$1(this, cardProduct));
    }

    @k.e.a.d
    public final g k1(@k.e.a.d NImageView nImageView) {
        return e.t.j.h.d.a.a(new SellerDetailActivity$onClickPreview$1(this, nImageView));
    }

    @k.e.a.d
    public final g l1(@k.e.a.d CardProduct cardProduct) {
        return e.t.j.h.d.a.a(new SellerDetailActivity$onMinusClick$1(cardProduct, this));
    }

    @Override // com.vector.design.ui.activity.ActivityEx
    @k.e.a.d
    /* renamed from: m0 */
    public SellerDetailViewModel K() {
        SellerDetailViewModel sellerDetailViewModel = (SellerDetailViewModel) new ViewModelProvider(this).get(SellerDetailViewModel.class);
        e.n.i b1 = sellerDetailViewModel.b1();
        int Z0 = Z0();
        Constants.Companion companion = Constants.Companion;
        int i2 = 1;
        b1.setValue(Boolean.valueOf(Z0 == companion.getWAREHOUSE_SELLER_USER_ID()));
        List<e.l.s.a> filter_seller = companion.getFILTER_SELLER();
        if (a1() == null) {
            i2 = 0;
        } else if (B0()) {
            i2 = 2;
        }
        sellerDetailViewModel.R(filter_seller, i2);
        return sellerDetailViewModel;
    }

    public final void m1(boolean z) {
        if (z) {
            RarityFilterBtn.h(S0(), false, 1, null);
        }
        SellerDetailViewModel sellerDetailViewModel = (SellerDetailViewModel) L();
        int i2 = this.uid;
        Integer num = this.wid;
        GameBar.a aVar = GameBar.b;
        Game value = aVar.a().getValue();
        String gameKey = value == null ? null : value.getGameKey();
        String str = gameKey != null ? gameKey : "";
        Game value2 = aVar.a().getValue();
        String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
        BinderKt.p(BinderKt.e(sellerDetailViewModel.R0(i2, num, str, gameSubKey != null ? gameSubKey : "", z, null), this, E0(), false, 4, null));
    }

    @k.e.a.d
    public final u0 o0() {
        return (u0) this.w.getValue();
    }

    @k.e.a.d
    public final g o1(@k.e.a.d CardProduct cardProduct) {
        return e.t.j.h.d.a.a(new SellerDetailActivity$removeShopCar$1(this, cardProduct));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        X0().removeCallbacks(this.J);
        Y0().d().animate().cancel();
        super.onDestroy();
    }

    @Override // com.jihuanshe.ui.BaseActivity, com.vector.design.ui.activity.SimpleActivityEx, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.Q) {
            this.Q = false;
            return;
        }
        ((SellerDetailViewModel) L()).L0(this.uid);
        SellerDetailViewModel sellerDetailViewModel = (SellerDetailViewModel) L();
        int i2 = this.uid;
        Integer num = this.wid;
        GameBar.a aVar = GameBar.b;
        Game value = aVar.a().getValue();
        String gameKey = value == null ? null : value.getGameKey();
        if (gameKey == null) {
            gameKey = "";
        }
        Game value2 = aVar.a().getValue();
        String gameSubKey = value2 != null ? value2.getGameSubKey() : null;
        if (gameSubKey == null) {
            gameSubKey = "";
        }
        BinderKt.e(sellerDetailViewModel.R0(i2, num, gameKey, gameSubKey, false, null), this, E0(), false, 4, null);
    }

    @k.e.a.d
    public final y p0() {
        return (y) this.C.getValue();
    }

    public final void p1(@k.e.a.e CardErrorCorrectionDialog cardErrorCorrectionDialog) {
        this.j0 = cardErrorCorrectionDialog;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        i2 e2 = i2.e(getLayoutInflater());
        e2.i(this);
        e2.j((SellerDetailViewModel) L());
        return e2;
    }

    public final void q1(int i2) {
        this.cid = i2;
    }

    @k.e.a.d
    public final b r0() {
        return this.t;
    }

    public final void r1(boolean z) {
        this.Q = z;
    }

    @k.e.a.e
    public final CardErrorCorrectionDialog s0() {
        return this.j0;
    }

    public final void s1(boolean z) {
        this.ignoreVersion = z;
    }

    public final int t0() {
        return this.cid;
    }

    public final void t1(boolean z) {
        this.f0 = z;
    }

    @k.e.a.d
    public final g u0() {
        return this.g0;
    }

    public final void u1(int i2) {
        this.uid = i2;
    }

    @k.e.a.d
    public final g v0() {
        return this.h0;
    }

    public final void v1(@k.e.a.e Integer num) {
        this.wid = num;
    }

    @k.e.a.d
    public final g w0() {
        return this.i0;
    }

    public final void w1(@k.e.a.e Boolean bool) {
        this.wish = bool;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public AppBarState x() {
        return AppBarState.FLOATING;
    }

    @k.e.a.d
    public final e.l.h.j.b.f.a x0() {
        return (e.l.h.j.b.f.a) this.A.getValue();
    }

    public final int y0() {
        return this.p;
    }

    public final int z0() {
        return this.o;
    }
}
