package com.jihuanshe.ui.page.entrepot;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.l0;
import e.l.g.q;
import e.l.g.s;
import e.l.h.j.b.f.b;
import e.l.k.g0;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.p;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class ConOrderDetailsActivity extends BaseActivity<ConOrderDetailsViewModel> {
    public static final int A = 2;
    @d
    public static final a x;
    public static final /* synthetic */ n<Object>[] y;
    public static final int z = 1;
    @f.a.a.a
    @e
    private Integer orderId;
    @f.a.a.a
    @e
    private Integer typeOrder;
    @d
    private final g u;
    @d
    private final g v;
    @d
    private final p w;
    @d
    private final h.m2.e n = BindViewKt.n(this, R.id.card_listView);
    @d
    private final h.m2.e o = BindViewKt.n(this, R.id.card_listView_return);
    @d
    private final w p = z.c(new ConOrderDetailsActivity$adapter$2(this));
    @d
    private final w q = z.c(ConOrderDetailsActivity$adapterReturn$2.INSTANCE);
    @d
    private final w r = z.c(ConOrderDetailsActivity$adapterExpress$2.INSTANCE);
    @d
    private final w s = z.c(ConOrderDetailsActivity$layoutManager$2.INSTANCE);
    @d
    private final w t = z.c(ConOrderDetailsActivity$decoration$2.INSTANCE);

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    static {
        n<Object>[] nVarArr = new n[7];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(ConOrderDetailsActivity.class), "cardListView", "getCardListView()Lcom/vector/view/scrollable/ListView;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(ConOrderDetailsActivity.class), "cardListViewReturn", "getCardListViewReturn()Lcom/vector/view/scrollable/ListView;"));
        y = nVarArr;
        x = new a(null);
    }

    public ConOrderDetailsActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.u = dVar.a(new ConOrderDetailsActivity$onClickCopy$1(this));
        this.v = dVar.a(new ConOrderDetailsActivity$onClickFold$1(this));
        this.w = d.g.a.a(new ConOrderDetailsActivity$onLoadMore$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListView b0() {
        return (ListView) this.n.a(this, y[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListView c0() {
        return (ListView) this.o.a(this, y[1]);
    }

    @k.e.a.d
    public final q Y() {
        return (q) this.p.getValue();
    }

    @k.e.a.d
    public final s Z() {
        return (s) this.r.getValue();
    }

    @k.e.a.d
    public final l0 a0() {
        return (l0) this.q.getValue();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        Integer num;
        if (this.orderId == null || (num = this.typeOrder) == null) {
            return;
        }
        if (num != null && num.intValue() == 1) {
            BinderKt.n(e.g.d.a.j(((ConOrderDetailsViewModel) L()).B0(this.orderId.intValue()), null, new ConOrderDetailsActivity$flowOfSetup$1(this), 1, null), this);
            ((ConOrderDetailsViewModel) L()).u0(this.orderId.intValue(), "warehouse_order");
            return;
        }
        BinderKt.n(e.g.d.a.j(((ConOrderDetailsViewModel) L()).A0(this.orderId.intValue()), null, new ConOrderDetailsActivity$flowOfSetup$2(this), 1, null), this);
        ((ConOrderDetailsViewModel) L()).u0(this.orderId.intValue(), "warehouse_return_order");
    }

    @k.e.a.d
    public final b d0() {
        return (b) this.t.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a e0() {
        return (LayoutManagers.a) this.s.getValue();
    }

    @k.e.a.d
    public final g f0() {
        return this.u;
    }

    @k.e.a.d
    public final g g0() {
        return this.v;
    }

    @k.e.a.d
    public final p h0() {
        return this.w;
    }

    @e
    public final Integer i0() {
        return this.orderId;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(ConOrderDetailsActivity$flowOfAppBar$1.INSTANCE);
    }

    @e
    public final Integer j0() {
        return this.typeOrder;
    }

    public final void k0(@e Integer num) {
        this.orderId = num;
    }

    public final void l0(@e Integer num) {
        this.typeOrder = num;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        g0 e2 = g0.e(getLayoutInflater());
        e2.i(this);
        e2.j((ConOrderDetailsViewModel) L());
        return e2;
    }
}
