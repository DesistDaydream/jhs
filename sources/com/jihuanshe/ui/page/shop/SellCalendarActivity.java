package com.jihuanshe.ui.page.shop;

import android.view.MotionEvent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.base.ui.widget.SlideIndicatorView;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.Product;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.shop.SellCalendarViewModel;
import com.jihuanshe.viewmodel.user.wish.WishListViewModel;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.pager.ViewPager;
import com.vector.view.scrollable.ListView;
import e.l.g.t0;
import e.l.k.e2;
import e.l.q.c.r0.a;
import e.l.q.c.u0.b;
import e.t.j.h.d;
import e.t.j.h.d0;
import e.t.j.h.g;
import h.k2.u.l;
import h.k2.v.f0;
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
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class SellCalendarActivity extends BaseActivity<SellCalendarViewModel> implements a.InterfaceC0395a {
    public static final /* synthetic */ n<Object>[] C;
    private boolean A;
    @d
    private final g B;
    @d
    private final e n = BindViewKt.n(this, R.id.listView);
    @d
    private final e o = BindViewKt.n(this, R.id.indicator);
    @d
    private final e p = BindViewKt.n(this, R.id.viewPager);
    @d
    private final w q = z.c(new SellCalendarActivity$wishViewModel$2(this));
    @d
    private final w r = z.c(new SellCalendarActivity$viewPagerAdapter$2(this));
    @d
    private final w s = z.c(new SellCalendarActivity$adapter$2(this));
    @d
    private final w t = z.c(SellCalendarActivity$layoutManger$2.INSTANCE);
    @d
    private final w u = z.c(new SellCalendarActivity$stickerDecoration$2(this));
    @d
    private final l<Integer, t1> v = new SellCalendarActivity$onChooseMonth$1(this);
    @d
    private final d0 w;
    @d
    private final g x;
    @d
    private final l<List<Game>, t1> y;
    @d
    private final e.t.j.h.l z;

    /* loaded from: classes2.dex */
    public static final class a implements RecyclerView.OnItemTouchListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@d RecyclerView recyclerView, @d MotionEvent motionEvent) {
            boolean z = true;
            SellCalendarActivity.this.A = (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) ? false : false;
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean z) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@d RecyclerView recyclerView, @d MotionEvent motionEvent) {
        }
    }

    static {
        n<Object>[] nVarArr = new n[8];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(SellCalendarActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(SellCalendarActivity.class), "indicator", "getIndicator()Lcom/jihuanshe/base/ui/widget/SlideIndicatorView;"));
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(SellCalendarActivity.class), "viewPager", "getViewPager()Lcom/vector/view/pager/ViewPager;"));
        C = nVarArr;
    }

    public SellCalendarActivity() {
        d.e eVar = d.e.a;
        this.w = eVar.c(new SellCalendarActivity$onScroll$1(this));
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.x = dVar.a(new SellCalendarActivity$onClickBack$1(this));
        this.y = new SellCalendarActivity$onFilterGame$1(this);
        this.z = eVar.a(new SellCalendarActivity$onItemClick$1(this));
        this.B = dVar.a(new SellCalendarActivity$onClickWish$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SlideIndicatorView e0() {
        return (SlideIndicatorView) this.o.a(this, C[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListView g0() {
        return (ListView) this.n.a(this, C[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewPager o0() {
        return (ViewPager) this.p.a(this, C[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WishListViewModel q0() {
        return (WishListViewModel) this.q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0() {
        List<Product> value = ((SellCalendarViewModel) L()).v0().getValue();
        if (value == null) {
            return;
        }
        int i2 = 0;
        for (Object obj : value) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            Product product = (Product) obj;
            if (c(i2) > 0) {
                o0().setCurrentItem(product.getGroupIndex());
                RecyclerView.LayoutManager layoutManager = g0().getScrollable().getLayoutManager();
                LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                if (linearLayoutManager == null) {
                    return;
                }
                linearLayoutManager.scrollToPositionWithOffset(Math.max(i2 - 1, 0), 0);
                return;
            }
            i2 = i3;
        }
    }

    @Override // e.l.q.c.r0.a.InterfaceC0395a
    @k.e.a.d
    public String a(int i2) {
        Product product;
        List<Product> value = ((SellCalendarViewModel) L()).v0().getValue();
        String str = null;
        if (value != null && (product = (Product) CollectionsKt___CollectionsKt.J2(value, i2)) != null) {
            str = product.getBelongGroup();
        }
        return str != null ? str : "";
    }

    @Override // e.l.q.c.r0.a.InterfaceC0395a
    public int c(int i2) {
        if (((SellCalendarViewModel) L()).D0() == null) {
            return 0;
        }
        List<Product> value = ((SellCalendarViewModel) L()).v0().getValue();
        Product product = value == null ? null : (Product) CollectionsKt___CollectionsKt.J2(value, i2);
        if (product != null && f0.g(product, ((SellCalendarViewModel) L()).D0())) {
            return ((SellCalendarViewModel) L()).z0() ? 2 : 1;
        }
        return 0;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        b.j();
        BinderKt.p(BinderKt.s(e.g.d.a.j(((SellCalendarViewModel) L()).s0(), null, new SellCalendarActivity$flowOfSetup$1(this), 1, null), this, false, true, 2, null));
        g0().getScrollable().addOnItemTouchListener(new a());
    }

    @k.e.a.d
    public final t0 d0() {
        return (t0) this.s.getValue();
    }

    @Override // e.l.q.c.r0.a.InterfaceC0395a
    public boolean e(int i2) {
        Product product;
        List<Product> value = ((SellCalendarViewModel) L()).v0().getValue();
        String str = null;
        if (value != null && (product = (Product) CollectionsKt___CollectionsKt.J2(value, i2)) != null) {
            str = product.getGroupMonth();
        }
        return true ^ (str == null || str.length() == 0);
    }

    @k.e.a.d
    public final LayoutManagers.a f0() {
        return (LayoutManagers.a) this.t.getValue();
    }

    @Override // e.l.q.c.r0.a.InterfaceC0395a
    public boolean h(int i2) {
        Product product;
        List<Product> value = ((SellCalendarViewModel) L()).v0().getValue();
        String str = null;
        if (value != null && (product = (Product) CollectionsKt___CollectionsKt.J2(value, i2)) != null) {
            str = product.getShowTimeStr();
        }
        return true ^ (str == null || str.length() == 0);
    }

    @k.e.a.d
    public final l<Integer, t1> h0() {
        return this.v;
    }

    @k.e.a.d
    public final g i0() {
        return this.x;
    }

    @k.e.a.d
    public final g j0() {
        return this.B;
    }

    @Override // e.l.q.c.r0.a.InterfaceC0395a
    @k.e.a.d
    public String k(int i2) {
        Product product;
        List<Product> value = ((SellCalendarViewModel) L()).v0().getValue();
        String str = null;
        if (value != null && (product = (Product) CollectionsKt___CollectionsKt.J2(value, i2)) != null) {
            str = product.getBelongGroup();
        }
        return str != null ? str : "";
    }

    @k.e.a.d
    public final l<List<Game>, t1> k0() {
        return this.y;
    }

    @k.e.a.d
    public final e.t.j.h.l l0() {
        return this.z;
    }

    @k.e.a.d
    public final d0 m0() {
        return this.w;
    }

    @k.e.a.d
    public final e.l.q.c.r0.a n0() {
        return (e.l.q.c.r0.a) this.u.getValue();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        b.l();
        super.onDestroy();
    }

    @k.e.a.d
    public final FragPagerAdapter p0() {
        return (FragPagerAdapter) this.r.getValue();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        e2 e2 = e2.e(getLayoutInflater());
        e2.i(this);
        e2.j((SellCalendarViewModel) L());
        return e2;
    }
}
