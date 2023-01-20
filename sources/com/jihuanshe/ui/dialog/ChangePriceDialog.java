package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.OrderDetailInfo;
import com.vector.ext.bind.BindViewKt;
import e.l.k.a4;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.t.j.h.g;
import h.k2.u.p;
import h.k2.v.n0;
import h.p2.n;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public final class ChangePriceDialog extends BaseDialog {
    public static final /* synthetic */ n<Object>[] A = {n0.r(new PropertyReference1Impl(n0.d(ChangePriceDialog.class), "priceEt", "getPriceEt()Landroid/widget/EditText;")), n0.r(new PropertyReference1Impl(n0.d(ChangePriceDialog.class), "shippingEt", "getShippingEt()Landroid/widget/EditText;"))};
    @e
    private final OrderDetailInfo t;
    @e
    private final p<Float, Float, t1> u;
    @d
    private final h.m2.e v;
    @d
    private final h.m2.e w;
    @d
    private final g x;
    @d
    private final g y;
    @d
    private final g z;

    /* JADX WARN: Multi-variable type inference failed */
    public ChangePriceDialog(@d Context context, @e OrderDetailInfo orderDetailInfo, @e p<? super Float, ? super Float, t1> pVar) {
        super(context);
        this.t = orderDetailInfo;
        this.u = pVar;
        this.v = BindViewKt.p(this, R.id.priceEt);
        this.w = BindViewKt.p(this, R.id.shippingEt);
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.x = dVar.a(new ChangePriceDialog$onClickClose$1(this));
        this.y = dVar.a(new ChangePriceDialog$onClickTip$1(context));
        this.z = dVar.a(new ChangePriceDialog$onClickSave$1(this));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        a4 e2 = a4.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @e
    public final p<Float, Float, t1> getListener() {
        return this.u;
    }

    @d
    public final g getOnClickClose() {
        return this.x;
    }

    @d
    public final g getOnClickSave() {
        return this.z;
    }

    @d
    public final g getOnClickTip() {
        return this.y;
    }

    @e
    public final OrderDetailInfo getOrder() {
        return this.t;
    }

    @d
    public final EditText getPriceEt() {
        return (EditText) this.v.a(this, A[0]);
    }

    @d
    public final String getPriceEtTextStr() {
        if (this.t.getProductPrice() - ((float) ((int) this.t.getProductPrice())) == 0.0f) {
            return String.valueOf((int) this.t.getProductPrice());
        }
        return String.valueOf(this.t.getProductPrice());
    }

    @d
    public final EditText getShippingEt() {
        return (EditText) this.w.a(this, A[1]);
    }

    @d
    public final String getShippingEtTextStr() {
        if (this.t.getShippingPrice() - ((float) ((int) this.t.getShippingPrice())) == 0.0f) {
            return String.valueOf((int) this.t.getShippingPrice());
        }
        return String.valueOf(this.t.getShippingPrice());
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        String valueOf;
        String valueOf2;
        if (this.t == null) {
            return;
        }
        setMoveWithKeyboard(true);
        setGravity(80);
        EditText priceEt = getPriceEt();
        if (this.t.getProductPrice() - ((float) ((int) this.t.getProductPrice())) == 0.0f) {
            valueOf = String.valueOf((int) this.t.getProductPrice());
        } else {
            valueOf = String.valueOf(this.t.getProductPrice());
        }
        priceEt.setText(valueOf);
        EditText shippingEt = getShippingEt();
        if (this.t.getShippingPrice() - ((float) ((int) this.t.getShippingPrice())) == 0.0f) {
            valueOf2 = String.valueOf((int) this.t.getShippingPrice());
        } else {
            valueOf2 = String.valueOf(this.t.getShippingPrice());
        }
        shippingEt.setText(valueOf2);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public k l(@d View view) {
        return new r(view);
    }
}
