package com.jihuanshe.ui.page.user;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.ui.BaseActivity;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.a0;
import e.l.h.j.b.f.b;
import e.l.k.a1;
import e.l.s.o.a;
import e.t.j.h.d;
import e.t.j.h.f0;
import e.t.j.h.g;
import h.k2.v.n0;
import h.m2.e;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class IllegalListActivity extends BaseActivity<a> {
    public static final /* synthetic */ n<Object>[] t;
    @d
    private final e n = BindViewKt.n(this, R.id.listView);
    @d
    private final w o = z.c(IllegalListActivity$adapter$2.INSTANCE);
    @d
    private final w p = z.c(IllegalListActivity$layoutManager$2.INSTANCE);
    @d
    private final w q = z.c(IllegalListActivity$decoration$2.INSTANCE);
    @d
    private final f0 r = d.g.a.b(new IllegalListActivity$onSwipe$1(this));
    @k.e.a.d
    private final g s = e.t.j.h.d.a.a(new IllegalListActivity$onClickKefu$1(this));

    static {
        n<Object>[] nVarArr = new n[4];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(IllegalListActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        t = nVarArr;
    }

    private final ListView Z() {
        return (ListView) this.n.a(this, t[0]);
    }

    @k.e.a.d
    public final a0 W() {
        return (a0) this.o.getValue();
    }

    @k.e.a.d
    public final b X() {
        return (b) this.q.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a Y() {
        return (LayoutManagers.a) this.p.getValue();
    }

    @k.e.a.d
    public final g a0() {
        return this.s;
    }

    @k.e.a.d
    public final f0 b0() {
        return this.r;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        Z().h();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(IllegalListActivity$flowOfAppBar$1.INSTANCE);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        a1 e2 = a1.e(getLayoutInflater());
        e2.i(this);
        e2.j((a) L());
        return e2;
    }
}
