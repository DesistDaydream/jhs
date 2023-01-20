package com.jihuanshe.ui.page.shop;

import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.ApplyForItem;
import com.jihuanshe.model.CardPackage;
import com.jihuanshe.model.PendingProduct;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.dialog.AddCardConsignmentDialog;
import com.jihuanshe.ui.dialog.EditProductDialog;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.entrepot.ApplyForViewModel;
import com.jihuanshe.viewmodel.shop.ChooseCardViewModel;
import com.jihuanshe.viewmodel.user.selling.SellingChildViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.g.j;
import e.l.h.j.b.f.b;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.h;
import e.t.j.h.p;
import f.a.a.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.n0;
import h.p2.n;
import h.t1;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class ChooseCardActivity extends BaseActivity<ChooseCardViewModel> {
    public static final /* synthetic */ n<Object>[] C;
    @e
    private EditProductDialog B;
    @a
    @e
    private CardPackage cardPackage;
    @a(true)
    @e
    private String keyWord;
    @a
    @e
    private Integer type;
    @a
    @e
    private Integer wantSellCardId;
    @a
    @e
    private Integer wid;
    @e
    private f<PendingProduct> y;
    @e
    private Integer z;
    @d
    private final h.m2.e n = BindViewKt.n(this, R.id.searchEt);
    @d
    private final h.m2.e o = BindViewKt.n(this, R.id.listView);
    @d
    private final w p = z.c(new ChooseCardActivity$applyForViewModel$2(this));
    @d
    private final w q = z.c(new ChooseCardActivity$sellingViewModel$2(this));
    @d
    private final w r = z.c(ChooseCardActivity$adapter$2.INSTANCE);
    @d
    private final w s = z.c(ChooseCardActivity$layoutManager$2.INSTANCE);
    @d
    private final w t = z.c(ChooseCardActivity$decoration$2.INSTANCE);
    @d
    private final g u = e.t.j.h.d.a.a(new ChooseCardActivity$onClickSearch$1(this));
    @d
    private final l<List<Rarity>, t1> v = new ChooseCardActivity$onFilterRarity$1(this);
    @d
    private final h w = d.c.a.c(new ChooseCardActivity$onEditorAction$1(this));
    @k.e.a.d
    private final p x = d.g.a.a(new ChooseCardActivity$onLoadMore$1(this));
    @k.e.a.d
    private final e.t.j.h.l A = d.e.a.a(new ChooseCardActivity$onItemClick$1(this));

    static {
        n<Object>[] nVarArr = new n[7];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(ChooseCardActivity.class), "et", "getEt()Landroid/widget/EditText;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(ChooseCardActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        C = nVarArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0() {
        e.g.d.a e2;
        this.keyWord = c0().getText().toString();
        e.g.d.a F0 = ChooseCardViewModel.F0((ChooseCardViewModel) L(), GameBar.b.a().getValue(), this.cardPackage, this.keyWord, null, null, 16, null);
        if (F0 == null || (e2 = BinderKt.e(F0, this, f0(), false, 4, null)) == null) {
            return;
        }
        BinderKt.k(e2, this, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(List<ApplyForItem> list) {
        if (this.y == null) {
            return;
        }
        for (ApplyForItem applyForItem : list) {
            Integer warehouseOrderProductId = applyForItem.getWarehouseOrderProductId();
            PendingProduct value = this.y.getValue();
            if (f0.g(warehouseOrderProductId, value == null ? null : Integer.valueOf(value.getWarehouseOrderProductId()))) {
                new AddCardConsignmentDialog(this, Z().t0(applyForItem), applyForItem, null, null, null, true, new ChooseCardActivity$showAmendDialog$1(applyForItem, this), new ChooseCardActivity$showAmendDialog$2(this, applyForItem), null, 568, null).y();
            }
        }
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        e.g.d.a e2;
        e.g.d.a e3;
        if (this.wantSellCardId != null) {
            e.g.d.a F0 = ChooseCardViewModel.F0((ChooseCardViewModel) L(), GameBar.b.a().getValue(), this.cardPackage, null, this.wantSellCardId, null, 16, null);
            if (F0 == null || (e3 = BinderKt.e(F0, this, f0(), false, 4, null)) == null) {
                return;
            }
            BinderKt.s(e3, this, false, false, 6, null);
            return;
        }
        e.g.d.a F02 = ChooseCardViewModel.F0((ChooseCardViewModel) L(), GameBar.b.a().getValue(), this.cardPackage, this.keyWord, null, null, 16, null);
        if (F02 == null || (e2 = BinderKt.e(F02, this, f0(), false, 4, null)) == null) {
            return;
        }
        BinderKt.s(e2, this, false, false, 6, null);
    }

    @k.e.a.d
    public final j Y() {
        return (j) this.r.getValue();
    }

    @k.e.a.d
    public final ApplyForViewModel Z() {
        return (ApplyForViewModel) this.p.getValue();
    }

    @e
    public final CardPackage a0() {
        return this.cardPackage;
    }

    @k.e.a.d
    public final b b0() {
        return (b) this.t.getValue();
    }

    @k.e.a.d
    public final EditText c0() {
        return (EditText) this.n.a(this, C[0]);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        ((ChooseCardViewModel) L()).M0().setValue(this.type);
        EditText c0 = c0();
        String str = this.keyWord;
        if (str == null) {
            str = "";
        }
        c0.setText(str);
        F();
        f.g(((ChooseCardViewModel) L()).N(), null, new ChooseCardActivity$flowOfSetup$1(this), 1, null);
        f.g(Z().s0(), null, new ChooseCardActivity$flowOfSetup$2(this), 1, null);
        f.g(Z().r0(), null, new ChooseCardActivity$flowOfSetup$3(this), 1, null);
    }

    @e
    public final String d0() {
        return this.keyWord;
    }

    @k.e.a.d
    public final LayoutManagers.a e0() {
        return (LayoutManagers.a) this.s.getValue();
    }

    @k.e.a.d
    public final ListView f0() {
        return (ListView) this.o.a(this, C[1]);
    }

    @k.e.a.d
    public final g g0() {
        return this.u;
    }

    @e
    public final Integer getType() {
        return this.type;
    }

    @k.e.a.d
    public final h h0() {
        return this.w;
    }

    @k.e.a.d
    public final l<List<Rarity>, t1> i0() {
        return this.v;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(ChooseCardActivity$flowOfAppBar$1.INSTANCE);
    }

    @k.e.a.d
    public final e.t.j.h.l j0() {
        return this.A;
    }

    @k.e.a.d
    public final p k0() {
        return this.x;
    }

    @e
    public final Integer l0() {
        return this.z;
    }

    @e
    public final f<PendingProduct> m0() {
        return this.y;
    }

    @k.e.a.d
    public final SellingChildViewModel n0() {
        return (SellingChildViewModel) this.q.getValue();
    }

    @e
    public final Integer o0() {
        return this.wantSellCardId;
    }

    @e
    public final Integer p0() {
        return this.wid;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        e.l.k.w e2 = e.l.k.w.e(getLayoutInflater());
        e2.i(this);
        e2.j((ChooseCardViewModel) L());
        return e2;
    }

    public final void r0(@e CardPackage cardPackage) {
        this.cardPackage = cardPackage;
    }

    public final void s0(@e String str) {
        this.keyWord = str;
    }

    public final void t0(@e Integer num) {
        this.z = num;
    }

    public final void u0(@e f<PendingProduct> fVar) {
        this.y = fVar;
    }

    public final void v0(@e Integer num) {
        this.type = num;
    }

    public final void w0(@e Integer num) {
        this.wantSellCardId = num;
    }

    public final void x0(@e Integer num) {
        this.wid = num;
    }
}
