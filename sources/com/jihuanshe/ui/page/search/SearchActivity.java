package com.jihuanshe.ui.page.search;

import android.view.ViewGroup;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.appbar.AppBarLayout;
import com.jihuanshe.R;
import com.jihuanshe.model.CardPackage;
import com.jihuanshe.model.Constants;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.page.entrepot.SearchHouseProductFragmentCreator;
import com.jihuanshe.ui.page.entrepot.SearchMyStorehouseFragmentCreator;
import com.jihuanshe.ui.page.search.fragments.cardrepo.CardRepoSearchFragmentCreator;
import com.jihuanshe.ui.page.search.fragments.desire.SearchDesireFragmentCreator;
import com.jihuanshe.ui.page.search.fragments.global.GlobalSearchFragmentCreator;
import com.jihuanshe.ui.page.search.fragments.global.SearchUserFragmentCreator;
import com.jihuanshe.ui.page.search.fragments.order.SearchOrderFragmentCreator;
import com.jihuanshe.ui.page.search.fragments.order.SearchSellerOrderFragmentCreator;
import com.jihuanshe.ui.page.search.fragments.wantcard.SearchWantCardListFragmentCreator;
import com.jihuanshe.ui.page.user.selling.SellingFragmentCreator;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.Res;
import e.l.k.c2;
import e.l.s.m.c;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.h;
import e.t.j.h.h0;
import e.t.j.h.i;
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
public final class SearchActivity extends BaseActivity<c> {
    public static final int A = 3;
    public static final int B = 4;
    public static final int C = 5;
    public static final int D = 6;
    public static final int E = 7;
    public static final int F = 9;
    public static final int G = 10;
    public static final int H = 11;
    public static final int I = 12;
    public static final int J = 13;
    @d
    public static final a w;
    public static final /* synthetic */ n<Object>[] x;
    public static final int y = 1;
    public static final int z = 2;
    @f.a.a.a(true)
    @e
    private CardPackage cardPackage;
    @f.a.a.a(true)
    @e
    private Integer cardRepoType;
    @d
    private final h r;
    @d
    private final h0 s;
    @f.a.a.a(true)
    private boolean sellerOrderList;
    @d
    private final i t;
    @d
    private final g u;
    @f.a.a.a(true)
    @e
    private Integer uid;
    @d
    private final g v;
    @f.a.a.a(true)
    @e
    private Integer wid;
    @f.a.a.a
    private int type = 1;
    @d
    private final h.m2.e n = BindViewKt.n(this, R.id.edit);
    @d
    private final h.m2.e o = BindViewKt.n(this, R.id.cl_search);
    @d
    private final w p = z.c(new SearchActivity$searchBarHeight$2(this));
    @d
    private final w q = z.c(new SearchActivity$marginTop$2(this));

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        n<Object>[] nVarArr = new n[4];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(SearchActivity.class), "searchEdit", "getSearchEdit()Landroid/widget/EditText;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(SearchActivity.class), "appbarLayout", "getAppbarLayout()Lcom/google/android/material/appbar/AppBarLayout;"));
        x = nVarArr;
        w = new a(null);
    }

    public SearchActivity() {
        d.c cVar = d.c.a;
        this.r = cVar.c(new SearchActivity$onEditAction$1(this));
        this.s = cVar.d(new SearchActivity$onTextChange$1(this));
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.t = dVar.b(new SearchActivity$onFocusChanged$1(this));
        this.u = dVar.a(new SearchActivity$cancelOnClick$1(this));
        this.v = dVar.a(new SearchActivity$delOnClick$1(this));
    }

    private final AppBarLayout Y() {
        return (AppBarLayout) this.o.a(this, x[1]);
    }

    public final EditText i0() {
        return (EditText) this.n.a(this, x[0]);
    }

    private final Fragment k0() {
        switch (this.type) {
            case 1:
                return GlobalSearchFragmentCreator.create().get();
            case 2:
                return SearchHouseProductFragmentCreator.create(this.uid).get();
            case 3:
                return SearchHouseProductFragmentCreator.create(Integer.valueOf(Constants.Companion.getWAREHOUSE_SELLER_USER_ID())).get();
            case 4:
                return SearchMyStorehouseFragmentCreator.create(4).get();
            case 5:
                return SearchMyStorehouseFragmentCreator.create(5).get();
            case 6:
                return SearchMyStorehouseFragmentCreator.create(6).get();
            case 7:
                return SellingFragmentCreator.create().search(Boolean.TRUE).get();
            case 8:
            default:
                return new Fragment();
            case 9:
                return CardRepoSearchFragmentCreator.create(this.cardRepoType, this.wid, this.cardPackage).get();
            case 10:
                return SearchDesireFragmentCreator.create().get();
            case 11:
                return SearchWantCardListFragmentCreator.create(this.wid).get();
            case 12:
                if (this.sellerOrderList) {
                    return SearchSellerOrderFragmentCreator.create(null).get();
                }
                return SearchOrderFragmentCreator.create(null).get();
            case 13:
                return SearchUserFragmentCreator.create().get();
        }
    }

    public final void n0(boolean z2) {
        if (z2) {
            w().setBackgroundColor(Res.k(R.color.transparent));
            ((c) L()).r0().setValue(Boolean.TRUE);
            return;
        }
        w().setBackgroundColor(Res.k(R.color.white));
        ((c) L()).r0().setValue(Boolean.FALSE);
    }

    @k.e.a.d
    public final g Z() {
        return this.u;
    }

    @e
    public final CardPackage a0() {
        return this.cardPackage;
    }

    @e
    public final Integer b0() {
        return this.cardRepoType;
    }

    @k.e.a.d
    public final g c0() {
        return this.v;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.frgContainer, k0());
        beginTransaction.commitAllowingStateLoss();
        ViewGroup.LayoutParams layoutParams = Y().getChildAt(0).getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
        ((AppBarLayout.LayoutParams) layoutParams).d(this.type == 1 ? 5 : 0);
    }

    public final int d0() {
        return ((Number) this.q.getValue()).intValue();
    }

    @k.e.a.d
    public final h e0() {
        return this.r;
    }

    @k.e.a.d
    public final i f0() {
        return this.t;
    }

    @k.e.a.d
    public final h0 g0() {
        return this.s;
    }

    public final int getType() {
        return this.type;
    }

    public final int h0() {
        return ((Number) this.p.getValue()).intValue();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        n0(false);
    }

    public final boolean j0() {
        return this.sellerOrderList;
    }

    @e
    public final Integer l0() {
        return this.uid;
    }

    @e
    public final Integer m0() {
        return this.wid;
    }

    public final void o0(@e CardPackage cardPackage) {
        this.cardPackage = cardPackage;
    }

    public final void p0(@e Integer num) {
        this.cardRepoType = num;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        c2 e2 = c2.e(getLayoutInflater());
        e2.i(this);
        e2.j((c) L());
        return e2;
    }

    public final void q0(boolean z2) {
        this.sellerOrderList = z2;
    }

    public final void r0(int i2) {
        this.type = i2;
    }

    public final void s0(@e Integer num) {
        this.uid = num;
    }

    public final void t0(@e Integer num) {
        this.wid = num;
    }
}
