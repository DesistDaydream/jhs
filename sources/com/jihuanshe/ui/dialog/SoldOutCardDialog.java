package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.WantCard;
import com.vector.ext.bind.BindViewKt;
import com.vector.network.image.NImageView;
import e.l.k.w5;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.n.l;
import e.t.j.h.a;
import e.t.j.h.d;
import e.t.j.h.e;
import e.t.j.h.g;
import h.k2.u.p;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public final class SoldOutCardDialog extends BaseDialog {
    public static final /* synthetic */ n<Object>[] H = {n0.r(new PropertyReference1Impl(n0.d(SoldOutCardDialog.class), "priceEt", "getPriceEt()Landroid/widget/EditText;")), n0.r(new PropertyReference1Impl(n0.d(SoldOutCardDialog.class), "numEt", "getNumEt()Landroid/widget/EditText;")), n0.r(new PropertyReference1Impl(n0.d(SoldOutCardDialog.class), "remarkEt", "getRemarkEt()Landroid/widget/EditText;"))};
    @d
    private final e A;
    @d
    private final a B;
    @d
    private final g C;
    @d
    private final g D;
    @d
    private final g E;
    @d
    private final g F;
    @d
    private final g G;
    @k.e.a.e
    private final GameCard t;
    private boolean u;
    @d
    private final h.m2.e v;
    @d
    private final h.m2.e w;
    @d
    private final h.m2.e x;
    @d
    private final l y;
    @d
    private final l z;

    public /* synthetic */ SoldOutCardDialog(Context context, GameCard gameCard, boolean z, h.k2.u.a aVar, p pVar, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : gameCard, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? null : aVar, (i2 & 16) != 0 ? null : pVar);
    }

    @d
    public final g C(int i2) {
        return e.t.j.h.d.a.a(new SoldOutCardDialog$chooseRarity$1(this, i2));
    }

    @d
    public final g D(@d NImageView nImageView) {
        return e.t.j.h.d.a.a(new SoldOutCardDialog$onClickImage$1(this, nImageView));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        w5 e2 = w5.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @d
    public final l getCount() {
        return this.y;
    }

    @k.e.a.e
    public final GameCard getGameCard() {
        return this.t;
    }

    @d
    public final l getMCondition() {
        return this.z;
    }

    @d
    public final EditText getNumEt() {
        return (EditText) this.w.a(this, H[1]);
    }

    public final boolean getOn() {
        return this.u;
    }

    @d
    public final g getOnAddClick() {
        return this.C;
    }

    @d
    public final a getOnAfterChanged() {
        return this.B;
    }

    @d
    public final e getOnCheckedChanged() {
        return this.A;
    }

    @d
    public final g getOnClickClose() {
        return this.G;
    }

    @d
    public final g getOnDeleteClick() {
        return this.E;
    }

    @d
    public final g getOnMinusClick() {
        return this.D;
    }

    @d
    public final g getOnSave() {
        return this.F;
    }

    @d
    public final EditText getPriceEt() {
        return (EditText) this.v.a(this, H[0]);
    }

    @d
    public final EditText getRemarkEt() {
        return (EditText) this.x.a(this, H[2]);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setMoveWithKeyboard(true);
        setGravity(80);
        l lVar = this.z;
        GameCard gameCard = this.t;
        lVar.setValue(gameCard == null ? null : gameCard.getCondition());
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public k l(@d View view) {
        return new r(view);
    }

    public final void setOn(boolean z) {
        this.u = z;
    }

    public SoldOutCardDialog(@d Context context, @k.e.a.e GameCard gameCard, boolean z, @k.e.a.e h.k2.u.a<t1> aVar, @k.e.a.e p<? super WantCard, ? super Boolean, t1> pVar) {
        super(context);
        this.t = gameCard;
        this.u = z;
        this.v = BindViewKt.p(this, R.id.priceEt);
        this.w = BindViewKt.p(this, R.id.numEt);
        this.x = BindViewKt.p(this, R.id.remarkEt);
        this.y = new l(Integer.valueOf(gameCard == null ? 1 : gameCard.getQuantity()));
        this.z = new l(1);
        this.A = d.b.a.a(new SoldOutCardDialog$onCheckedChanged$1(this));
        this.B = d.c.a.a(new SoldOutCardDialog$onAfterChanged$1(this));
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.C = dVar.a(new SoldOutCardDialog$onAddClick$1(this));
        this.D = dVar.a(new SoldOutCardDialog$onMinusClick$1(this));
        this.E = dVar.a(new SoldOutCardDialog$onDeleteClick$1(context, this, aVar));
        this.F = dVar.a(new SoldOutCardDialog$onSave$1(this, pVar));
        this.G = dVar.a(new SoldOutCardDialog$onClickClose$1(this));
    }
}
