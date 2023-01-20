package com.jihuanshe.ui.page.user;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.user.CoinViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.o;
import e.l.h.j.b.f.b;
import e.l.k.c0;
import e.n.l;
import e.t.j.h.d;
import e.t.j.h.f0;
import e.t.j.h.g;
import e.t.j.h.p;
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
public final class CoinActivity extends BaseActivity<CoinViewModel> {
    public static final /* synthetic */ n<Object>[] A;
    @d
    private l n = new l(0);
    @d
    private final e o = BindViewKt.n(this, R.id.listView);
    @d
    private final w p = z.c(CoinActivity$adapter$2.INSTANCE);
    @d
    private final w q = z.c(CoinActivity$layoutManager$2.INSTANCE);
    @d
    private final g r;
    @d
    private final g s;
    @d
    private final w t;
    @k.e.a.e
    private TextView u;
    @d
    private final w v;
    @d
    private final f0 w;
    @d
    private final p x;
    @k.e.a.e
    private View y;
    @k.e.a.e
    private TextView z;

    static {
        n<Object>[] nVarArr = new n[5];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(CoinActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        A = nVarArr;
    }

    public CoinActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.r = dVar.a(new CoinActivity$onClickQA$1(this));
        this.s = dVar.a(new CoinActivity$onClickWithDraw$1(this));
        this.t = z.c(CoinActivity$decoration$2.INSTANCE);
        this.v = z.c(new CoinActivity$header$2(this));
        d.g gVar = d.g.a;
        this.w = gVar.b(new CoinActivity$onSwipe$1(this));
        this.x = gVar.a(new CoinActivity$onLoadMore$1(this));
    }

    @k.e.a.d
    public final o Y() {
        return (o) this.p.getValue();
    }

    @k.e.a.d
    public final b Z() {
        return (b) this.t.getValue();
    }

    @k.e.a.d
    public final View a0() {
        return (View) this.v.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a b0() {
        return (LayoutManagers.a) this.q.getValue();
    }

    @k.e.a.d
    public final ListView c0() {
        return (ListView) this.o.a(this, A[0]);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        this.n.f(this, new CoinActivity$flowOfSetup$1(this));
    }

    @k.e.a.d
    public final l d0() {
        return this.n;
    }

    @k.e.a.e
    public final TextView e0() {
        return this.u;
    }

    @k.e.a.d
    public final g f0() {
        return this.r;
    }

    @k.e.a.d
    public final g g0() {
        return this.s;
    }

    @k.e.a.d
    public final p h0() {
        return this.x;
    }

    @k.e.a.d
    public final f0 i0() {
        return this.w;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        this.z = w().getMid().g(CoinActivity$flowOfAppBar$1.INSTANCE);
        Integer value = this.n.getValue();
        if (value != null && value.intValue() == 0) {
            this.y = w().getEnd().d(new CoinActivity$flowOfAppBar$2(this));
        }
    }

    public final void j0(@k.e.a.d l lVar) {
        this.n = lVar;
    }

    public final void k0(@k.e.a.e TextView textView) {
        this.u = textView;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        c0 e2 = c0.e(getLayoutInflater());
        e2.i(this);
        e2.j((CoinViewModel) L());
        return e2;
    }
}
