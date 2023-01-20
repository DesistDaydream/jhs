package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.ApplyForItem;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.PendingProduct;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.model.WarehouseProductInfo;
import com.vector.ext.bind.BindViewKt;
import com.vector.network.image.NImageView;
import com.vector.util.Res;
import e.l.k.g6;
import e.l.q.a.k0.r;
import e.n.f;
import e.n.k;
import e.n.l;
import e.t.j.h.a;
import e.t.j.h.d;
import e.t.j.h.g;
import h.k2.u.p;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.u;
import h.m2.e;
import h.p2.n;
import h.t1;
import h.w;
import h.z;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public final class AddCardConsignmentDialog extends BaseDialog {
    public static final /* synthetic */ n<Object>[] R;
    @d
    private final w A;
    @d
    private final e B;
    @d
    private final e C;
    @d
    private final l D;
    @d
    private final k E;
    @d
    private final l F;
    @d
    private final f<PendingProduct> G;
    @d
    private final f<PendingProduct> H;
    @d
    private final f<PendingProduct> I;
    @d
    private final e.t.j.h.e J;
    @d
    private final g K;
    @d
    private final g L;
    @d
    private final a M;
    @d
    private final g N;
    @d
    private final g O;
    @d
    private final g P;
    @d
    private final g Q;
    @k.e.a.e
    private final CardProductNew t;
    @k.e.a.e
    private final ApplyForItem u;
    @k.e.a.e
    private final WarehouseProductInfo v;
    @k.e.a.e
    private final WantCard w;
    @k.e.a.e
    private Boolean x;
    private final boolean y;
    @k.e.a.e
    private final h.k2.u.l<f<PendingProduct>, t1> z;

    static {
        n<Object>[] nVarArr = new n[3];
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(AddCardConsignmentDialog.class), "priceEt", "getPriceEt()Landroid/widget/EditText;"));
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(AddCardConsignmentDialog.class), "numEt", "getNumEt()Landroid/widget/EditText;"));
        R = nVarArr;
    }

    public /* synthetic */ AddCardConsignmentDialog(Context context, CardProductNew cardProductNew, ApplyForItem applyForItem, WarehouseProductInfo warehouseProductInfo, WantCard wantCard, Boolean bool, boolean z, h.k2.u.a aVar, p pVar, h.k2.u.l lVar, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : cardProductNew, (i2 & 4) != 0 ? null : applyForItem, (i2 & 8) != 0 ? null : warehouseProductInfo, (i2 & 16) != 0 ? null : wantCard, (i2 & 32) != 0 ? null : bool, (i2 & 64) != 0 ? false : z, (i2 & 128) != 0 ? null : aVar, (i2 & 256) != 0 ? null : pVar, (i2 & 512) == 0 ? lVar : null);
    }

    @d
    public final g C(int i2) {
        return e.t.j.h.d.a.a(new AddCardConsignmentDialog$chooseLocation$1(this, i2));
    }

    @d
    public final g D(@d f<PendingProduct> fVar) {
        return e.t.j.h.d.a.a(new AddCardConsignmentDialog$clickChildDia$1(fVar, this));
    }

    @k.e.a.e
    public final Boolean E() {
        return this.x;
    }

    @d
    public final g F(@d NImageView nImageView) {
        return e.t.j.h.d.a.a(new AddCardConsignmentDialog$onClickImage$1(this, nImageView));
    }

    @d
    public final String G() {
        StringBuilder sb = new StringBuilder();
        WarehouseProductInfo warehouseProductInfo = this.v;
        sb.append(warehouseProductInfo == null ? null : Integer.valueOf(warehouseProductInfo.getQuantity()));
        sb.append((char) 24352);
        return sb.toString();
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        g6 e2 = g6.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @k.e.a.e
    public final ApplyForItem getApplyForItem() {
        return this.u;
    }

    @d
    public final String getButtonText() {
        if (this.u == null && this.v == null) {
            return Res.w(Res.a, R.string.shop_add_card, null, 2, null);
        }
        return Res.w(Res.a, R.string.common_confirm, null, 2, null);
    }

    @k.e.a.e
    public final CardProductNew getCardProduct() {
        return this.t;
    }

    @k.e.a.e
    public final h.k2.u.l<f<PendingProduct>, t1> getClickChild() {
        return this.z;
    }

    @d
    public final l getCount() {
        return this.D;
    }

    @k.e.a.e
    public final Game getGame() {
        return (Game) this.A.getValue();
    }

    public final boolean getHasRarity() {
        return this.y;
    }

    @d
    public final String getHintText() {
        CardProductNew cardProductNew = this.t;
        return (cardProductNew == null || cardProductNew.getPrice() <= 0.0f) ? "" : String.valueOf(this.t.getPrice());
    }

    @d
    public final l getLocationData() {
        return this.F;
    }

    @d
    public final EditText getNumEt() {
        return (EditText) this.C.a(this, R[2]);
    }

    @d
    public final g getOnAddClick() {
        return this.O;
    }

    @d
    public final a getOnAfterChanged() {
        return this.M;
    }

    @d
    public final e.t.j.h.e getOnCheckedChanged() {
        return this.J;
    }

    @d
    public final g getOnClickClose() {
        return this.K;
    }

    @d
    public final g getOnDeleteClick() {
        return this.P;
    }

    @d
    public final g getOnDescClick() {
        return this.L;
    }

    @d
    public final g getOnMinusClick() {
        return this.N;
    }

    @d
    public final g getOnSave() {
        return this.Q;
    }

    @d
    public final f<PendingProduct> getPendingCardAsia() {
        return this.I;
    }

    @d
    public final f<PendingProduct> getPendingCardDefault() {
        return this.G;
    }

    @d
    public final f<PendingProduct> getPendingCardJp() {
        return this.H;
    }

    @d
    public final k getPrice() {
        return this.E;
    }

    @d
    public final EditText getPriceEt() {
        return (EditText) this.B.a(this, R[1]);
    }

    @k.e.a.e
    public final WantCard getWantCard() {
        return this.w;
    }

    @k.e.a.e
    public final WarehouseProductInfo getWarehouseProductInfo() {
        return this.v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        List<PendingProduct> warehousePendingProducts;
        Object obj;
        PendingProduct pendingProduct;
        List<PendingProduct> warehousePendingProducts2;
        Object obj2;
        PendingProduct pendingProduct2;
        List<PendingProduct> warehousePendingProducts3;
        setGravity(80);
        f<PendingProduct> fVar = this.H;
        CardProductNew cardProductNew = this.t;
        PendingProduct pendingProduct3 = null;
        if (cardProductNew == null || (warehousePendingProducts = cardProductNew.getWarehousePendingProducts()) == null) {
            pendingProduct = null;
        } else {
            Iterator<T> it = warehousePendingProducts.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (f0.g("jp", ((PendingProduct) obj).getPublishLocation())) {
                    break;
                }
            }
            pendingProduct = (PendingProduct) obj;
        }
        fVar.r(pendingProduct);
        f<PendingProduct> fVar2 = this.I;
        CardProductNew cardProductNew2 = this.t;
        if (cardProductNew2 == null || (warehousePendingProducts2 = cardProductNew2.getWarehousePendingProducts()) == null) {
            pendingProduct2 = null;
        } else {
            Iterator<T> it2 = warehousePendingProducts2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it2.next();
                if (f0.g("asia", ((PendingProduct) obj2).getPublishLocation())) {
                    break;
                }
            }
            pendingProduct2 = (PendingProduct) obj2;
        }
        fVar2.r(pendingProduct2);
        f<PendingProduct> fVar3 = this.G;
        CardProductNew cardProductNew3 = this.t;
        if (cardProductNew3 != null && (warehousePendingProducts3 = cardProductNew3.getWarehousePendingProducts()) != null) {
            Iterator<T> it3 = warehousePendingProducts3.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next = it3.next();
                if (f0.g("default", ((PendingProduct) next).getPublishLocation())) {
                    pendingProduct3 = next;
                    break;
                }
            }
            pendingProduct3 = pendingProduct3;
        }
        fVar3.r(pendingProduct3);
        ApplyForItem applyForItem = this.u;
        if (applyForItem != null) {
            this.D.setValue(applyForItem.getQuantity());
        }
        WarehouseProductInfo warehouseProductInfo = this.v;
        if (warehouseProductInfo != null) {
            this.D.setValue(Integer.valueOf(warehouseProductInfo.getQuantity()));
        }
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public e.l.q.a.k0.k l(@d View view) {
        return new r(view);
    }

    public final void setSold(@k.e.a.e Boolean bool) {
        this.x = bool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AddCardConsignmentDialog(@d Context context, @k.e.a.e CardProductNew cardProductNew, @k.e.a.e ApplyForItem applyForItem, @k.e.a.e WarehouseProductInfo warehouseProductInfo, @k.e.a.e WantCard wantCard, @k.e.a.e Boolean bool, boolean z, @k.e.a.e h.k2.u.a<t1> aVar, @k.e.a.e p<? super WantCard, ? super Boolean, t1> pVar, @k.e.a.e h.k2.u.l<? super f<PendingProduct>, t1> lVar) {
        super(context);
        this.t = cardProductNew;
        this.u = applyForItem;
        this.v = warehouseProductInfo;
        this.w = wantCard;
        this.x = bool;
        this.y = z;
        this.z = lVar;
        this.A = z.c(new AddCardConsignmentDialog$game$2(this));
        this.B = BindViewKt.p(this, R.id.priceEt);
        this.C = BindViewKt.p(this, R.id.numEt);
        this.D = new l(Integer.valueOf(wantCard == null ? 1 : wantCard.getQuantity()));
        this.E = new k(null, 1, null);
        this.F = new l(1);
        this.G = new f<>(null);
        this.H = new f<>(null);
        this.I = new f<>(null);
        this.J = d.b.a.a(new AddCardConsignmentDialog$onCheckedChanged$1(this));
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.K = dVar.a(new AddCardConsignmentDialog$onClickClose$1(this));
        this.L = dVar.a(new AddCardConsignmentDialog$onDescClick$1(context));
        this.M = d.c.a.a(new AddCardConsignmentDialog$onAfterChanged$1(this));
        this.N = dVar.a(new AddCardConsignmentDialog$onMinusClick$1(this));
        this.O = dVar.a(new AddCardConsignmentDialog$onAddClick$1(this));
        this.P = dVar.a(new AddCardConsignmentDialog$onDeleteClick$1(this, aVar));
        this.Q = dVar.a(new AddCardConsignmentDialog$onSave$1(this, pVar));
    }
}
