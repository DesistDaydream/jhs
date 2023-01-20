package com.jihuanshe.ui.page.entrepot;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.viewmodel.entrepot.ConsignmentOrderChildViewModel;
import com.vector.design.ui.frag.SimpleFragEx;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.h.d.f;
import e.l.h.j.b.f.b;
import e.l.k.m6;
import e.t.j.h.d;
import e.t.j.h.f0;
import e.t.j.h.l;
import e.t.j.h.p;
import f.a.a.a;
import h.k2.v.n0;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class ConsignmentOrderFragment extends BaseFragment<ConsignmentOrderChildViewModel> {
    public static final /* synthetic */ n<Object>[] y;
    @a
    @e
    private String type;
    @a
    @e
    private Integer typeOrder;
    @d
    private final f0 w;
    @d
    private final p x;
    @d
    private final h.m2.e r = BindViewKt.s(this, R.id.listView);
    @d
    private final w s = z.c(ConsignmentOrderFragment$adapter$2.INSTANCE);
    @d
    private final l t = d.e.a.a(new ConsignmentOrderFragment$onItemClick$1(this));
    @k.e.a.d
    private final w u = z.c(ConsignmentOrderFragment$decoration$2.INSTANCE);
    @k.e.a.d
    private final w v = z.c(ConsignmentOrderFragment$layoutManager$2.INSTANCE);

    static {
        n<Object>[] nVarArr = new n[4];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(ConsignmentOrderFragment.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        y = nVarArr;
    }

    public ConsignmentOrderFragment() {
        d.g gVar = d.g.a;
        this.w = gVar.b(new ConsignmentOrderFragment$onSwipe$1(this));
        this.x = gVar.a(new ConsignmentOrderFragment$onLoadMore$1(this));
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public SimpleFragEx.LazyLoadMode F() {
        return SimpleFragEx.LazyLoadMode.RESUME;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        f.b.e(this).g(e.l.j.a.r, new ConsignmentOrderFragment$flowOfSetup$1(this));
        h0().h();
    }

    @k.e.a.d
    public final e.l.g.p e0() {
        return (e.l.g.p) this.s.getValue();
    }

    @k.e.a.d
    public final b f0() {
        return (b) this.u.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a g0() {
        return (LayoutManagers.a) this.v.getValue();
    }

    @e
    public final String getType() {
        return this.type;
    }

    @k.e.a.d
    public final ListView h0() {
        return (ListView) this.r.a(this, y[0]);
    }

    @k.e.a.d
    public final l i0() {
        return this.t;
    }

    @k.e.a.d
    public final p j0() {
        return this.x;
    }

    @k.e.a.d
    public final f0 k0() {
        return this.w;
    }

    @e
    public final Integer l0() {
        return this.typeOrder;
    }

    public final void m0(@e String str) {
        this.type = str;
    }

    public final void n0(@e Integer num) {
        this.typeOrder = num;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        m6 e2 = m6.e(getLayoutInflater());
        e2.i(this);
        e2.j((ConsignmentOrderChildViewModel) T());
        return e2;
    }
}
