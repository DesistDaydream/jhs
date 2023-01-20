package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import e.l.k.q5;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.t.j.h.g;
import h.k2.u.l;
import h.t1;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class SellerCancelReasonDialog extends BaseDialog {
    @d
    private final l<String, t1> t;
    @d
    private final g u;

    /* JADX WARN: Multi-variable type inference failed */
    public SellerCancelReasonDialog(@d Context context, @d l<? super String, t1> lVar) {
        super(context);
        this.t = lVar;
        this.u = e.t.j.h.d.a.a(new SellerCancelReasonDialog$onChoose$1(this));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        q5 e2 = q5.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @d
    public final l<String, t1> getListener() {
        return this.t;
    }

    @d
    public final g getOnChoose() {
        return this.u;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setGravity(80);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public k l(@d View view) {
        return new r(view);
    }
}
