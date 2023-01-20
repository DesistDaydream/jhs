package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import e.l.k.o4;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.t.j.h.g;
import h.k2.u.a;
import h.t1;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class DeleteDialog extends BaseDialog {
    @d
    private final a<t1> t;
    @d
    private final g u;
    @d
    private final g v;

    public DeleteDialog(@d a<t1> aVar, @d Context context) {
        super(context);
        this.t = aVar;
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.u = dVar.a(new DeleteDialog$onCancel$1(this));
        this.v = dVar.a(new DeleteDialog$onDelete$1(this));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        o4 e2 = o4.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @d
    public final a<t1> getDelete() {
        return this.t;
    }

    @d
    public final g getOnCancel() {
        return this.u;
    }

    @d
    public final g getOnDelete() {
        return this.v;
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
