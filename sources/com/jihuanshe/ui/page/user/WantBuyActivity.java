package com.jihuanshe.ui.page.user;

import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.dialog.CreateListDialog;
import com.jihuanshe.ui.dialog.WantBuyDialog;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.ui.widget.WantBuyPopupWindow;
import com.jihuanshe.viewmodel.user.WantBuyViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.g.d.a;
import e.l.g.z0;
import e.l.h.d.f;
import e.l.h.j.b.f.b;
import e.l.k.y2;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.l;
import e.t.j.h.m;
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
public final class WantBuyActivity extends BaseActivity<WantBuyViewModel> {
    public static final /* synthetic */ n<Object>[] y;
    @d
    private final e n = BindViewKt.n(this, R.id.listView);
    @d
    private final w o = z.c(new WantBuyActivity$adapter$2(this));
    @d
    private final w p = z.c(WantBuyActivity$layoutManager$2.INSTANCE);
    @d
    private final w q = z.c(WantBuyActivity$decoration$2.INSTANCE);
    @d
    private final p r = d.g.a.a(new WantBuyActivity$onLoadMore$1(this));
    @k.e.a.d
    private final l s;
    @k.e.a.e
    private WantBuyDialog t;
    @k.e.a.d
    private final m u;
    @k.e.a.e
    private WantBuyPopupWindow v;
    @k.e.a.d
    private final g w;
    private boolean x;

    static {
        n<Object>[] nVarArr = new n[4];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(WantBuyActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        y = nVarArr;
    }

    public WantBuyActivity() {
        d.e eVar = d.e.a;
        this.s = eVar.a(new WantBuyActivity$onItemClick$1(this));
        this.u = eVar.b(new WantBuyActivity$onItemLongClick$1(this));
        this.w = e.t.j.h.d.a.a(new WantBuyActivity$onClickCreate$1(this));
        this.x = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListView h0() {
        return (ListView) this.n.a(this, y[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(WantBuyList wantBuyList) {
        WantBuyPopupWindow wantBuyPopupWindow = this.v;
        if (wantBuyPopupWindow != null) {
            wantBuyPopupWindow.dismiss();
        }
        new CreateListDialog(this, null, new WantBuyActivity$reSetName$1(this, wantBuyList), 2, null).y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(WantBuyList wantBuyList) {
        WantBuyPopupWindow wantBuyPopupWindow = this.v;
        if (wantBuyPopupWindow != null) {
            wantBuyPopupWindow.dismiss();
        }
        BinderKt.p(BinderKt.k(a.j(((WantBuyViewModel) L()).u0(wantBuyList.getId()), null, new WantBuyActivity$setDefaultList$1(this, wantBuyList), 1, null), this, false, 2, null));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        BinderKt.s(BinderKt.e(WantBuyViewModel.t0((WantBuyViewModel) L(), null, 1, null), this, h0(), false, 4, null), this, false, false, 6, null);
    }

    public final void b0(@k.e.a.d WantBuyList wantBuyList) {
        BinderKt.p(BinderKt.k(a.j(((WantBuyViewModel) L()).delete(wantBuyList.getId()), null, new WantBuyActivity$deleteList$1(this, wantBuyList), 1, null), this, false, 2, null));
    }

    @k.e.a.d
    public final g c0(@k.e.a.d WantBuyList wantBuyList, @k.e.a.d ImageView imageView) {
        return e.t.j.h.d.a.a(new WantBuyActivity$edit$1(this, imageView, wantBuyList));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        F();
        GameBar.b.a().f(this, new WantBuyActivity$flowOfSetup$1(this));
        f fVar = f.b;
        fVar.e(this).g(e.l.j.a.n, new WantBuyActivity$flowOfSetup$2(this));
        fVar.e(this).g(e.l.j.a.o, new WantBuyActivity$flowOfSetup$3(this));
    }

    @k.e.a.d
    public final z0 d0() {
        return (z0) this.o.getValue();
    }

    @k.e.a.d
    public final g delete(@k.e.a.d WantBuyList wantBuyList) {
        return e.t.j.h.d.a.a(new WantBuyActivity$delete$1(this, wantBuyList));
    }

    @k.e.a.d
    public final b e0() {
        return (b) this.q.getValue();
    }

    @k.e.a.e
    public final WantBuyDialog f0() {
        return this.t;
    }

    @k.e.a.d
    public final LayoutManagers.a g0() {
        return (LayoutManagers.a) this.p.getValue();
    }

    @k.e.a.d
    public final g i0() {
        return this.w;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().b(new WantBuyActivity$flowOfAppBar$1(this));
    }

    @k.e.a.d
    public final l j0() {
        return this.s;
    }

    @k.e.a.d
    public final m k0() {
        return this.u;
    }

    @k.e.a.d
    public final p l0() {
        return this.r;
    }

    @k.e.a.e
    public final WantBuyPopupWindow m0() {
        return this.v;
    }

    @k.e.a.d
    public final g o0(@k.e.a.d WantBuyList wantBuyList) {
        return e.t.j.h.d.a.a(new WantBuyActivity$setDefault$1(this, wantBuyList));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        y2 e2 = y2.e(getLayoutInflater());
        e2.i(this);
        e2.j((WantBuyViewModel) L());
        return e2;
    }

    public final void q0(@k.e.a.e WantBuyDialog wantBuyDialog) {
        this.t = wantBuyDialog;
    }

    public final void r0(@k.e.a.e WantBuyPopupWindow wantBuyPopupWindow) {
        this.v = wantBuyPopupWindow;
    }

    @k.e.a.d
    public final g s0(@k.e.a.d WantBuyList wantBuyList) {
        return e.t.j.h.d.a.a(new WantBuyActivity$updateName$1(this, wantBuyList));
    }
}
