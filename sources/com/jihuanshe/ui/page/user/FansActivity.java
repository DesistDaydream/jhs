package com.jihuanshe.ui.page.user;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.user.FansViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.h.j.b.f.b;
import e.l.k.u0;
import e.t.j.h.d;
import e.t.j.h.l;
import e.t.j.h.p;
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
public final class FansActivity extends BaseActivity<FansViewModel> {
    public static final /* synthetic */ n<Object>[] t;
    @d
    private final e n = BindViewKt.n(this, R.id.listView);
    @d
    private final w o = z.c(FansActivity$adapter$2.INSTANCE);
    @d
    private final w p = z.c(FansActivity$layoutManager$2.INSTANCE);
    @d
    private final w q = z.c(FansActivity$decoration$2.INSTANCE);
    @d
    private final p r = d.g.a.a(new FansActivity$onLoadMore$1(this));
    @k.e.a.d
    private final l s = d.e.a.a(new FansActivity$onItemClick$1(this));
    @a
    @k.e.a.e
    private Integer uid;

    static {
        n<Object>[] nVarArr = new n[4];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(FansActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        t = nVarArr;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        FansViewModel fansViewModel = (FansViewModel) L();
        Integer num = this.uid;
        BinderKt.s(BinderKt.e(FansViewModel.t0(fansViewModel, num == null ? 0 : num.intValue(), null, 2, null), this, a0(), false, 4, null), this, false, false, 6, null);
    }

    public final void W(@k.e.a.d User user) {
        BinderKt.p(BinderKt.k(e.g.d.a.j(((FansViewModel) L()).q0(user.getId()), null, new FansActivity$follow$1(user, this), 1, null), this, false, 2, null));
    }

    @k.e.a.d
    public final e.l.g.w X() {
        return (e.l.g.w) this.o.getValue();
    }

    @k.e.a.d
    public final b Y() {
        return (b) this.q.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a Z() {
        return (LayoutManagers.a) this.p.getValue();
    }

    @k.e.a.d
    public final ListView a0() {
        return (ListView) this.n.a(this, t[0]);
    }

    @k.e.a.d
    public final l b0() {
        return this.s;
    }

    @k.e.a.d
    public final p c0() {
        return this.r;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        F();
    }

    @k.e.a.e
    public final Integer d0() {
        return this.uid;
    }

    public final void e0(@k.e.a.e Integer num) {
        this.uid = num;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(FansActivity$flowOfAppBar$1.INSTANCE);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        u0 e2 = u0.e(getLayoutInflater());
        e2.i(this);
        e2.j((FansViewModel) L());
        return e2;
    }
}
