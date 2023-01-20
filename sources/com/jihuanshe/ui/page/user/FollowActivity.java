package com.jihuanshe.ui.page.user;

import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ext.AppbarKt;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.user.FollowViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.h.j.b.f.b;
import e.l.k.w0;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.h;
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
public class FollowActivity extends BaseActivity<FollowViewModel> {
    public static final /* synthetic */ n<Object>[] x;
    @e
    private String p;
    @a
    @e
    private Integer uid;
    @d
    private final h.m2.e n = BindViewKt.n(this, R.id.listView);
    @d
    private final h.m2.e o = BindViewKt.n(this, R.id.searchEt);
    @d
    private final w q = z.c(FollowActivity$adapter$2.INSTANCE);
    @d
    private final w r = z.c(FollowActivity$layoutManager$2.INSTANCE);
    @d
    private final w s = z.c(FollowActivity$decoration$2.INSTANCE);
    @d
    private final p t = d.g.a.a(new FollowActivity$onLoadMore$1(this));
    @k.e.a.d
    private final g u = e.t.j.h.d.a.a(new FollowActivity$onClickSearch$1(this));
    @k.e.a.d
    private final l v = d.e.a.a(new FollowActivity$onItemClick$1(this));
    @k.e.a.d
    private final h w = d.c.a.c(new FollowActivity$onEditAction$1(this));

    static {
        n<Object>[] nVarArr = new n[5];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(FollowActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(FollowActivity.class), "editText", "getEditText()Landroid/widget/EditText;"));
        x = nVarArr;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        FollowViewModel followViewModel = (FollowViewModel) L();
        Integer num = this.uid;
        BinderKt.s(BinderKt.e(FollowViewModel.s0(followViewModel, num == null ? 0 : num.intValue(), null, null, 6, null), this, b0(), false, 4, null), this, false, false, 6, null);
    }

    @k.e.a.d
    public final e.l.g.w W() {
        return (e.l.g.w) this.q.getValue();
    }

    @k.e.a.d
    public final b X() {
        return (b) this.s.getValue();
    }

    @k.e.a.d
    public final EditText Y() {
        return (EditText) this.o.a(this, x[1]);
    }

    @e
    public final String Z() {
        return this.p;
    }

    @k.e.a.d
    public final LayoutManagers.a a0() {
        return (LayoutManagers.a) this.r.getValue();
    }

    @k.e.a.d
    public final ListView b0() {
        return (ListView) this.n.a(this, x[0]);
    }

    @k.e.a.d
    public final g c0() {
        return this.u;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        F();
    }

    @k.e.a.d
    public final h d0() {
        return this.w;
    }

    @k.e.a.d
    public final l e0() {
        return this.v;
    }

    @k.e.a.d
    public final p f0() {
        return this.t;
    }

    @e
    public final Integer g0() {
        return this.uid;
    }

    public void h0(@k.e.a.d User user) {
        SellerDetailActivityCreator.create(Integer.valueOf(user.getId()), null).start(this);
    }

    public final void i0(@e String str) {
        this.p = str;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(FollowActivity$flowOfAppBar$1.INSTANCE);
        AppbarKt.d(w(), 0, new FollowActivity$flowOfAppBar$2(this), 1, null);
    }

    public final void j0(@e Integer num) {
        this.uid = num;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        w0 e2 = w0.e(getLayoutInflater());
        e2.i(this);
        e2.j((FollowViewModel) L());
        return e2;
    }
}
