package com.jihuanshe.ui.dialog;

import android.content.Context;
import androidx.databinding.ViewDataBinding;
import e.l.k.y5;
import e.t.j.h.g;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class TipDialog extends BaseDialog {
    @d
    private final String t;
    @d
    private final g u;

    public TipDialog(@d Context context, @d String str) {
        super(context);
        this.t = str;
        this.u = e.t.j.h.d.a.a(new TipDialog$onClickCancel$1(this));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        y5 e2 = y5.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @d
    public final String getContent() {
        return this.t;
    }

    @d
    public final g getOnClickCancel() {
        return this.u;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setGravity(17);
        setCancelable(false);
        setDismissOnTouchOutside(false);
    }
}
