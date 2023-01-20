package com.jihuanshe.ui.page.user;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.user.WantBuyMatchViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.e0;
import e.l.h.j.b.f.b;
import e.l.k.a3;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.l;
import f.a.a.a;
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
public final class WantBuyMatchActivity extends BaseActivity<WantBuyMatchViewModel> {
    public static final /* synthetic */ n<Object>[] u;
    @d
    private final e n = BindViewKt.n(this, R.id.listView);
    @d
    private final w o = z.c(WantBuyMatchActivity$adapter$2.INSTANCE);
    @d
    private final w p = z.c(WantBuyMatchActivity$layoutManager$2.INSTANCE);
    @d
    private final w q = z.c(WantBuyMatchActivity$decoration$2.INSTANCE);
    @d
    private final w r = z.c(new WantBuyMatchActivity$header$2(this));
    @d
    private final e.t.j.h.e s = d.b.a.a(new WantBuyMatchActivity$onChecked$1(this));
    @k.e.a.d
    private final l t = d.e.a.a(new WantBuyMatchActivity$onItemClick$1(this));
    @a
    @k.e.a.e
    private Integer wid;

    static {
        n<Object>[] nVarArr = new n[5];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(WantBuyMatchActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        u = nVarArr;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        BinderKt.s(((WantBuyMatchViewModel) L()).p0(this.wid), this, false, false, 6, null);
    }

    @k.e.a.d
    public final e0 W() {
        return (e0) this.o.getValue();
    }

    @k.e.a.d
    public final b X() {
        return (b) this.q.getValue();
    }

    @k.e.a.d
    public final View Y() {
        return (View) this.r.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a Z() {
        return (LayoutManagers.a) this.p.getValue();
    }

    @k.e.a.d
    public final ListView a0() {
        return (ListView) this.n.a(this, u[0]);
    }

    @k.e.a.d
    public final e.t.j.h.e b0() {
        return this.s;
    }

    @k.e.a.d
    public final l c0() {
        return this.t;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        super.d();
        F();
        f.g(((WantBuyMatchViewModel) L()).r0(), null, new WantBuyMatchActivity$flowOfSetup$1(this), 1, null);
    }

    @k.e.a.e
    public final Integer d0() {
        return this.wid;
    }

    public final void e0(@k.e.a.e Integer num) {
        this.wid = num;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(WantBuyMatchActivity$flowOfAppBar$1.INSTANCE);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        a3 e2 = a3.e(getLayoutInflater());
        e2.i(this);
        e2.j((WantBuyMatchViewModel) L());
        return e2;
    }
}
