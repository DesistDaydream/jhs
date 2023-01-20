package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.WarehouseProductInfo;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel;
import com.vector.design.ui.frag.SimpleFragEx;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.g0;
import e.l.g.h0;
import e.l.g.i0;
import e.l.h.j.b.f.b;
import e.l.k.c7;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.l;
import e.t.j.h.p;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class MineStorehouseFragment extends BaseFragment<MineStorehouseViewModel> {
    @d
    public static final a F;
    public static final /* synthetic */ n<Object>[] G;
    @d
    public static final String H = "FRAGMENT_CHECK";
    @d
    public static final String I = "FRAGMENT_HOUSE";
    @d
    public static final String J = "FRAGMENT_OUT";
    @d
    private final g A;
    @d
    private final g B;
    @d
    private final l C;
    @d
    private final w D;
    @d
    private final p E;
    @f.a.a.a
    @e
    private String inType;
    @d
    private final w r = z.c(new MineStorehouseFragment$headerViewLeft$2(this));
    @d
    private final g s;
    @d
    private final h.m2.e t;
    @d
    private final h.m2.e u;
    @d
    private final h.m2.e v;
    @d
    private final w w;
    @d
    private final w x;
    @d
    private final w y;
    @d
    private final w z;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        n<Object>[] nVarArr = new n[9];
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(MineStorehouseFragment.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(MineStorehouseFragment.class), "listViewFail", "getListViewFail()Lcom/vector/view/scrollable/ListView;"));
        nVarArr[3] = n0.r(new PropertyReference1Impl(n0.d(MineStorehouseFragment.class), "listViewSold", "getListViewSold()Lcom/vector/view/scrollable/ListView;"));
        G = nVarArr;
        F = new a(null);
    }

    public MineStorehouseFragment() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.s = dVar.a(new MineStorehouseFragment$onClickExpress$1(this));
        this.t = BindViewKt.s(this, R.id.listView);
        this.u = BindViewKt.s(this, R.id.listView_fail);
        this.v = BindViewKt.s(this, R.id.listView_sold);
        this.w = z.c(MineStorehouseFragment$layoutManager$2.INSTANCE);
        this.x = z.c(new MineStorehouseFragment$adapter$2(this));
        this.y = z.c(MineStorehouseFragment$adapterFail$2.INSTANCE);
        this.z = z.c(MineStorehouseFragment$adapterSold$2.INSTANCE);
        this.A = dVar.a(new MineStorehouseFragment$onClickSearch$1(this));
        this.B = dVar.a(new MineStorehouseFragment$onClickSoldAll$1(this));
        this.C = d.e.a.a(new MineStorehouseFragment$onItemClick$1(this));
        this.D = z.c(MineStorehouseFragment$decoration$2.INSTANCE);
        this.E = d.g.a.a(new MineStorehouseFragment$onLoadMore$1(this));
    }

    private final void u0() {
        f.g(((MineStorehouseViewModel) T()).F0(), null, new MineStorehouseFragment$initObserve$1(this), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(Boolean bool, Float f2, WarehouseProductInfo warehouseProductInfo) {
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            if (f2 == null) {
                return;
            }
            BinderKt.p(e.g.d.a.j(((MineStorehouseViewModel) T()).M0(warehouseProductInfo.getWarehouseProductId(), f2.floatValue()), null, new MineStorehouseFragment$onSoldOrOffSold$1$1(this, warehouseProductInfo), 1, null));
        } else if (f2 == null) {
        } else {
            BinderKt.p(e.g.d.a.j(((MineStorehouseViewModel) T()).K0(warehouseProductInfo.getWarehouseProductId(), f2.floatValue()), null, new MineStorehouseFragment$onSoldOrOffSold$2$1(this, warehouseProductInfo), 1, null));
        }
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public SimpleFragEx.LazyLoadMode F() {
        return SimpleFragEx.LazyLoadMode.RESUME;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    public void M() {
        e.g.d.a G0;
        e.g.d.a G02;
        String str = this.inType;
        if (f0.g(str, "FRAGMENT_CHECK")) {
            Integer value = ((MineStorehouseViewModel) T()).F0().getValue();
            if (value != null && value.intValue() == 1) {
                ((MineStorehouseViewModel) T()).G0(SearchChildCheckFragment.B, (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null, (r13 & 32) == 0 ? null : null);
            } else {
                BinderKt.o(MineStorehouseViewModel.A0((MineStorehouseViewModel) T(), null, null, null, 7, null), this);
            }
        } else if (f0.g(str, "FRAGMENT_HOUSE")) {
            Integer value2 = ((MineStorehouseViewModel) T()).F0().getValue();
            if (value2 != null && value2.intValue() == 1) {
                G02 = ((MineStorehouseViewModel) T()).G0(SearchChildCheckFragment.C, (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null, (r13 & 32) == 0 ? null : null);
                BinderKt.o(G02, this);
                return;
            }
            G0 = ((MineStorehouseViewModel) T()).G0(SearchChildCheckFragment.D, (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null, (r13 & 32) == 0 ? null : null);
            BinderKt.o(G0, this);
        } else {
            Integer value3 = ((MineStorehouseViewModel) T()).F0().getValue();
            if (value3 != null && value3.intValue() == 1) {
                BinderKt.o(MineStorehouseViewModel.E0((MineStorehouseViewModel) T(), 1, null, 2, null), this);
            } else {
                BinderKt.o(MineStorehouseViewModel.E0((MineStorehouseViewModel) T(), 0, null, 2, null), this);
            }
        }
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        if (this.inType == null) {
            return;
        }
        u0();
        v0(this.inType);
    }

    @k.e.a.d
    public final i0 f0() {
        return (i0) this.x.getValue();
    }

    @k.e.a.d
    public final g0 g0() {
        return (g0) this.y.getValue();
    }

    @k.e.a.d
    public final h0 h0() {
        return (h0) this.z.getValue();
    }

    @k.e.a.d
    public final b i0() {
        return (b) this.D.getValue();
    }

    @k.e.a.d
    public final View j0() {
        return (View) this.r.getValue();
    }

    @e
    public final String k0() {
        return this.inType;
    }

    @k.e.a.d
    public final LayoutManagers.a l0() {
        return (LayoutManagers.a) this.w.getValue();
    }

    @k.e.a.d
    public final ListView m0() {
        return (ListView) this.t.a(this, G[1]);
    }

    @k.e.a.d
    public final ListView n0() {
        return (ListView) this.u.a(this, G[2]);
    }

    @k.e.a.d
    public final ListView o0() {
        return (ListView) this.v.a(this, G[3]);
    }

    @Override // com.jihuanshe.ui.BaseFragment, e.l.h.j.a.a, com.vector.design.ui.frag.SimpleFragEx, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        M();
    }

    @k.e.a.d
    public final g p0() {
        return this.s;
    }

    @k.e.a.d
    public final g q0() {
        return this.A;
    }

    @k.e.a.d
    public final g r0() {
        return this.B;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        c7 e2 = c7.e(getLayoutInflater());
        e2.i(this);
        e2.j((MineStorehouseViewModel) T());
        return e2;
    }

    @k.e.a.d
    public final l s0() {
        return this.C;
    }

    @k.e.a.d
    public final p t0() {
        return this.E;
    }

    @k.e.a.d
    public final Pair<String, String> v0(@k.e.a.d String str) {
        if (f0.g(str, "FRAGMENT_CHECK")) {
            return new Pair<>("待查验", "未通过");
        }
        if (f0.g(str, "FRAGMENT_HOUSE")) {
            return new Pair<>("已上架", "待上架");
        }
        return new Pair<>("已售出", "交易中");
    }

    public final void x0(@e String str) {
        this.inType = str;
    }
}
