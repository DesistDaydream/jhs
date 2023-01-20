package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.OrderDetailInfo;
import e.l.k.m3;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.t.j.h.c0;
import e.t.j.h.d;
import e.t.j.h.g;
import h.k2.u.q;
import h.t1;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class BackProductDialog extends BaseDialog {
    @d
    private final g A;
    @d
    private final g B;
    @d
    private final g C;
    @d
    private final OrderDetailInfo t;
    @d
    private final q<Integer, Integer, String, t1> u;
    @e
    private m3 v;
    private int w;
    private int x;
    @d
    private final c0 y;
    @d
    private final c0 z;

    /* JADX WARN: Multi-variable type inference failed */
    public BackProductDialog(@d Context context, @d OrderDetailInfo orderDetailInfo, @d q<? super Integer, ? super Integer, ? super String, t1> qVar) {
        super(context);
        this.t = orderDetailInfo;
        this.u = qVar;
        this.w = 1;
        this.x = 1;
        d.f fVar = d.f.a;
        this.y = fVar.a(new BackProductDialog$onCheckedChanged$1(this));
        this.z = fVar.a(new BackProductDialog$onCheckedChanged2$1(this));
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.A = dVar.a(new BackProductDialog$onChooseReason$1(context, this));
        this.B = dVar.a(new BackProductDialog$onClickCancel$1(this));
        this.C = dVar.a(new BackProductDialog$onSave$1(this));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @k.e.a.d
    public ViewDataBinding d() {
        m3 e2 = m3.e(getLayoutInflater(), this, false);
        this.v = e2;
        e2.h(this);
        return this.v;
    }

    @e
    public final m3 getBinding() {
        return this.v;
    }

    public final int getGoodsType() {
        return this.x;
    }

    @k.e.a.d
    public final OrderDetailInfo getInfo() {
        return this.t;
    }

    @k.e.a.d
    public final q<Integer, Integer, String, t1> getListener() {
        return this.u;
    }

    @k.e.a.d
    public final c0 getOnCheckedChanged() {
        return this.y;
    }

    @k.e.a.d
    public final c0 getOnCheckedChanged2() {
        return this.z;
    }

    @k.e.a.d
    public final g getOnChooseReason() {
        return this.A;
    }

    @k.e.a.d
    public final g getOnClickCancel() {
        return this.B;
    }

    @k.e.a.d
    public final g getOnSave() {
        return this.C;
    }

    public final int getReturnType() {
        return this.w;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setGravity(80);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @k.e.a.d
    public k l(@k.e.a.d View view) {
        return new r(view);
    }

    public final void setBinding(@e m3 m3Var) {
        this.v = m3Var;
    }

    public final void setGoodsType(int i2) {
        this.x = i2;
    }

    public final void setReturnType(int i2) {
        this.w = i2;
    }
}
