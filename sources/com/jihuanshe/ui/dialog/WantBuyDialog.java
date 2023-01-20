package com.jihuanshe.ui.dialog;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.ui.page.user.WantBuyActivity;
import e.l.k.c6;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.t.j.h.g;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class WantBuyDialog extends BaseDialog {
    @d
    private final WantBuyActivity t;
    @d
    private final WantBuyList u;
    @d
    private final g v;

    public WantBuyDialog(@d WantBuyActivity wantBuyActivity, @d WantBuyList wantBuyList) {
        super(wantBuyActivity);
        this.t = wantBuyActivity;
        this.u = wantBuyList;
        this.v = e.t.j.h.d.a.a(new WantBuyDialog$onClickCancel$1(this));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        c6 e2 = c6.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public final WantBuyActivity getActivity() {
        return this.t;
    }

    @d
    public final WantBuyList getItem() {
        return this.u;
    }

    @d
    public final g getOnClickCancel() {
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
