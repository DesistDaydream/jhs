package com.jihuanshe.ui.page.user;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import com.jihuanshe.R;
import com.jihuanshe.base.bus.Bus;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ext.AppbarKt;
import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.user.WantCardListViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.a1;
import e.l.h.d.f;
import e.l.h.d.h;
import e.l.k.c3;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.l;
import e.t.j.h.p;
import h.k2.v.f0;
import h.k2.v.n0;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class WantCardListActivity extends BaseActivity<WantCardListViewModel> {
    public static final /* synthetic */ n<Object>[] w;
    @e
    private String n;
    @d
    private final h.m2.e o = BindViewKt.n(this, R.id.listView);
    @d
    private final w p = z.c(WantCardListActivity$adapter$2.INSTANCE);
    @d
    private final w q = z.c(WantCardListActivity$layoutManager$2.INSTANCE);
    @d
    private final w r = z.c(WantCardListActivity$decoration$2.INSTANCE);
    @d
    private final l s = d.e.a.a(new WantCardListActivity$onItemClick$1(this));
    @k.e.a.d
    private final g t;
    @k.e.a.d
    private final g u;
    @k.e.a.d
    private final p v;
    @f.a.a.a
    @e
    private WantBuyList wantBuyList;

    /* loaded from: classes2.dex */
    public static final class a<T> implements Observer {
        public final /* synthetic */ Bus a;
        public final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ WantCardListActivity f4039c;

        public a(Bus bus, String str, WantCardListActivity wantCardListActivity) {
            this.a = bus;
            this.b = str;
            this.f4039c = wantCardListActivity;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(h hVar) {
            if (this.a.e().getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED || !f0.g(hVar.g(), this.b)) {
                return;
            }
            Object f2 = hVar.f();
            if (f2 != null && (f2 instanceof WantCard)) {
                WantCard wantCard = (WantCard) f2;
                List<WantCard> value = ((WantCardListViewModel) this.f4039c.L()).v0().getValue();
                List<WantCard> L5 = value == null ? null : CollectionsKt___CollectionsKt.L5(value);
                if (L5 != null) {
                    L5.set(L5.indexOf(wantCard), wantCard);
                }
                ((WantCardListViewModel) this.f4039c.L()).v0().setValue(L5);
            }
            new e.t.l.h();
        }
    }

    static {
        n<Object>[] nVarArr = new n[4];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(WantCardListActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        w = nVarArr;
    }

    public WantCardListActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.t = dVar.a(new WantCardListActivity$onMatch$1(this));
        this.u = dVar.a(new WantCardListActivity$onAdd$1(this));
        this.v = d.g.a.a(new WantCardListActivity$onLoadMore$1(this));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        BinderKt.s(BinderKt.e(WantCardListViewModel.w0((WantCardListViewModel) L(), this.wantBuyList.getId(), null, null, 4, null), this, a0(), false, 4, null), this, false, false, 6, null);
    }

    @k.e.a.d
    public final a1 X() {
        return (a1) this.p.getValue();
    }

    @k.e.a.d
    public final e.l.h.j.b.f.a Y() {
        return (e.l.h.j.b.f.a) this.r.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a Z() {
        return (LayoutManagers.a) this.q.getValue();
    }

    @k.e.a.d
    public final ListView a0() {
        return (ListView) this.o.a(this, w[0]);
    }

    @k.e.a.d
    public final g b0() {
        return this.u;
    }

    @k.e.a.d
    public final l c0() {
        return this.s;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        F();
        f fVar = f.b;
        Bus e2 = fVar.e(this);
        e2.l(e2.e(), e2.d(), new a(e2, e.l.j.a.A, this));
        fVar.e(this).g(e.l.j.a.n, new WantCardListActivity$flowOfSetup$2(this));
    }

    @k.e.a.d
    public final p d0() {
        return this.v;
    }

    @k.e.a.d
    public final g e0() {
        return this.t;
    }

    @e
    public final WantBuyList f0() {
        return this.wantBuyList;
    }

    public final void g0(@e WantBuyList wantBuyList) {
        this.wantBuyList = wantBuyList;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(new WantCardListActivity$flowOfAppBar$1(this));
        AppbarKt.c(w(), 0, new WantCardListActivity$flowOfAppBar$2(this));
        AppbarKt.b(w(), 0, new WantCardListActivity$flowOfAppBar$3(this), 1, null);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        c3 e2 = c3.e(getLayoutInflater());
        e2.i(this);
        e2.j((WantCardListViewModel) L());
        return e2;
    }
}
