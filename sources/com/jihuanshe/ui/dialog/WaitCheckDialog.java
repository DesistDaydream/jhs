package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.PendingProduct;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.model.WarehouseProductInfo;
import com.vector.ext.bind.BindViewKt;
import com.vector.network.image.NImageView;
import e.l.k.a6;
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
import h.p2.n;
import h.t1;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public final class WaitCheckDialog extends BaseDialog {
    public static final /* synthetic */ n<Object>[] I = {n0.r(new PropertyReference1Impl(n0.d(WaitCheckDialog.class), "priceEt", "getPriceEt()Landroid/widget/EditText;"))};
    @d
    private final f<PendingProduct> A;
    @d
    private final f<PendingProduct> B;
    @d
    private final f<PendingProduct> C;
    @d
    private final g D;
    @d
    private final g E;
    @d
    private final a F;
    @d
    private final g G;
    @d
    private final g H;
    @e
    private final CardProductNew t;
    @e
    private final WarehouseProductInfo u;
    @e
    private final WantCard v;
    @d
    private final h.m2.e w;
    @d
    private final l x;
    @d
    private final k y;
    @d
    private final l z;

    public /* synthetic */ WaitCheckDialog(Context context, CardProductNew cardProductNew, WarehouseProductInfo warehouseProductInfo, WantCard wantCard, p pVar, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : cardProductNew, (i2 & 4) != 0 ? null : warehouseProductInfo, (i2 & 8) != 0 ? null : wantCard, (i2 & 16) != 0 ? null : pVar);
    }

    @d
    public final g C(@d NImageView nImageView) {
        return e.t.j.h.d.a.a(new WaitCheckDialog$onClickImage$1(this, nImageView));
    }

    @d
    public final String D() {
        StringBuilder sb = new StringBuilder();
        WarehouseProductInfo warehouseProductInfo = this.u;
        sb.append(warehouseProductInfo == null ? null : Integer.valueOf(warehouseProductInfo.getQuantity()));
        sb.append((char) 24352);
        return sb.toString();
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        a6 e2 = a6.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @e
    public final CardProductNew getCardProduct() {
        return this.t;
    }

    @d
    public final l getCount() {
        return this.x;
    }

    @d
    public final String getHintText() {
        WarehouseProductInfo warehouseProductInfo = this.u;
        return (warehouseProductInfo == null || warehouseProductInfo.getPrice() <= 0.0f) ? "" : String.valueOf(this.u.getPrice());
    }

    @d
    public final l getLocationData() {
        return this.z;
    }

    @d
    public final a getOnAfterChanged() {
        return this.F;
    }

    @d
    public final g getOnClickClose() {
        return this.D;
    }

    @d
    public final g getOnDescClick() {
        return this.E;
    }

    @d
    public final g getOnMinusClick() {
        return this.G;
    }

    @d
    public final g getOnSave() {
        return this.H;
    }

    @d
    public final f<PendingProduct> getPendingCardAsia() {
        return this.C;
    }

    @d
    public final f<PendingProduct> getPendingCardDefault() {
        return this.A;
    }

    @d
    public final f<PendingProduct> getPendingCardJp() {
        return this.B;
    }

    @d
    public final k getPrice() {
        return this.y;
    }

    @d
    public final EditText getPriceEt() {
        return (EditText) this.w.a(this, I[0]);
    }

    @e
    public final WantCard getWantCard() {
        return this.v;
    }

    @e
    public final WarehouseProductInfo getWarehouseProductInfo() {
        return this.u;
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
        setMoveWithKeyboard(true);
        f<PendingProduct> fVar = this.B;
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
        f<PendingProduct> fVar2 = this.C;
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
        f<PendingProduct> fVar3 = this.A;
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
        WarehouseProductInfo warehouseProductInfo = this.u;
        if (warehouseProductInfo != null) {
            this.x.setValue(Integer.valueOf(warehouseProductInfo.getQuantity()));
        }
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public e.l.q.a.k0.k l(@d View view) {
        return new r(view);
    }

    public WaitCheckDialog(@d Context context, @e CardProductNew cardProductNew, @e WarehouseProductInfo warehouseProductInfo, @e WantCard wantCard, @e p<? super WantCard, ? super Boolean, t1> pVar) {
        super(context);
        this.t = cardProductNew;
        this.u = warehouseProductInfo;
        this.v = wantCard;
        this.w = BindViewKt.p(this, R.id.priceEt);
        this.x = new l(Integer.valueOf(wantCard == null ? 1 : wantCard.getQuantity()));
        this.y = new k(null, 1, null);
        this.z = new l(1);
        this.A = new f<>(null);
        this.B = new f<>(null);
        this.C = new f<>(null);
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.D = dVar.a(new WaitCheckDialog$onClickClose$1(this));
        this.E = dVar.a(new WaitCheckDialog$onDescClick$1(context));
        this.F = d.c.a.a(new WaitCheckDialog$onAfterChanged$1(this));
        this.G = dVar.a(new WaitCheckDialog$onMinusClick$1(this));
        this.H = dVar.a(new WaitCheckDialog$onSave$1(this, pVar));
    }
}
