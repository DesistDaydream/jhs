package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.entrepot.ApplyForViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.g.d.a;
import e.l.h.j.b.f.b;
import e.l.k.o0;
import e.n.f;
import e.n.i;
import e.t.j.h.d;
import e.t.j.h.f0;
import e.t.j.h.l;
import e.t.j.h.p;
import e.t.v.j.g;
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
public final class ApplyForActivity extends BaseActivity<ApplyForViewModel> {
    public static final /* synthetic */ n<Object>[] A;
    @d
    private final e n = BindViewKt.n(this, R.id.card_listView);
    @d
    private final w o = z.c(new ApplyForActivity$adapter$2(this));
    @d
    private final w p = z.c(ApplyForActivity$layoutManager$2.INSTANCE);
    @d
    private final w q = z.c(ApplyForActivity$decoration$2.INSTANCE);
    @d
    private final w r = z.c(new ApplyForActivity$header$2(this));
    @d
    private i s = new i(Boolean.FALSE);
    @d
    private final e.t.j.h.e t = d.b.a.a(new ApplyForActivity$onCheck$1(this));
    @k.e.a.e
    private g<?> u;
    @k.e.a.d
    private final f0 v;
    @k.e.a.d
    private final p w;
    @k.e.a.d
    private final l x;
    @k.e.a.d
    private final e.t.j.h.g y;
    @k.e.a.d
    private final e.t.j.h.g z;

    static {
        n<Object>[] nVarArr = new n[5];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(ApplyForActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        A = nVarArr;
    }

    public ApplyForActivity() {
        d.g gVar = d.g.a;
        this.v = gVar.b(new ApplyForActivity$onSwipe$1(this));
        this.w = gVar.a(new ApplyForActivity$onLoadMore$1(this));
        this.x = d.e.a.a(new ApplyForActivity$onItemClick$1(this));
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.y = dVar.a(new ApplyForActivity$addCardClick$1(this));
        this.z = dVar.a(new ApplyForActivity$submitClick$1(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListView f0() {
        return (ListView) this.n.a(this, A[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(int i2) {
        BinderKt.p(BinderKt.e(a.j(ApplyForViewModel.v0((ApplyForViewModel) L(), Integer.valueOf(i2), null, 2, null), null, new ApplyForActivity$loadListData$1(this), 1, null), this, f0(), false, 4, null));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        a.o(((ApplyForViewModel) L()).w0(), null, new ApplyForActivity$onRetryClick$1(this), 1, null);
    }

    @k.e.a.d
    public final e.l.g.a Z() {
        return (e.l.g.a) this.o.getValue();
    }

    @k.e.a.d
    public final e.t.j.h.g a0() {
        return this.y;
    }

    @k.e.a.d
    public final i b0() {
        return this.s;
    }

    @k.e.a.d
    public final b c0() {
        return (b) this.q.getValue();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        f.g(((ApplyForViewModel) L()).s0(), null, new ApplyForActivity$flowOfSetup$1(this), 1, null);
        F();
        e.l.h.d.f fVar = e.l.h.d.f.b;
        fVar.e(this).g(e.l.j.a.p, new ApplyForActivity$flowOfSetup$2(this));
        fVar.e(this).g(e.l.j.a.q, new ApplyForActivity$flowOfSetup$3(this));
    }

    @k.e.a.d
    public final View d0() {
        return (View) this.r.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a e0() {
        return (LayoutManagers.a) this.p.getValue();
    }

    @k.e.a.d
    public final e.t.j.h.e g0() {
        return this.t;
    }

    @k.e.a.d
    public final l h0() {
        return this.x;
    }

    @k.e.a.d
    public final p i0() {
        return this.w;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(ApplyForActivity$flowOfAppBar$1.INSTANCE);
    }

    @k.e.a.d
    public final f0 j0() {
        return this.v;
    }

    @k.e.a.d
    public final e.t.j.h.g k0() {
        return this.z;
    }

    public final void m0(@k.e.a.d i iVar) {
        this.s = iVar;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        UserKV.f3913c.r();
        super.onDestroy();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        o0 e2 = o0.e(getLayoutInflater());
        e2.i(this);
        e2.j((ApplyForViewModel) L());
        return e2;
    }
}
