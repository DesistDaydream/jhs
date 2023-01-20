package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.vector.util.UIUtil;
import e.l.k.g3;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.t.j.h.g;
import e.t.o.d;
import h.k2.u.q;
import h.t1;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class AddressDialog2 extends BaseDialog {
    @e
    private g3 t;
    @e
    private q<? super String, ? super String, ? super String, t1> u;
    private final int v;
    @d
    private final g w;

    public AddressDialog2(@d Context context) {
        super(context);
        this.v = UIUtil.c() + d.a.c(e.t.o.d.a, null, 1, null).d(58);
        this.w = e.t.j.h.d.a.a(new AddressDialog2$onClose$1(this));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @k.e.a.d
    public ViewDataBinding d() {
        g3 e2 = g3.e(getLayoutInflater(), this, false);
        this.t = e2;
        e2.a.setOnSelectCompletedListener(new AddressDialog2$createBinding$1(this));
        this.t.h(this);
        return this.t;
    }

    @e
    public final g3 getBinding() {
        return this.t;
    }

    public final int getH() {
        return this.v;
    }

    @e
    public final q<String, String, String, t1> getListener() {
        return this.u;
    }

    @k.e.a.d
    public final g getOnClose() {
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

    public final void setBinding(@e g3 g3Var) {
        this.t = g3Var;
    }

    public final void setListener(@e q<? super String, ? super String, ? super String, t1> qVar) {
        this.u = qVar;
    }
}
