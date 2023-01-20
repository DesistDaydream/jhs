package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import e.l.k.k4;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.t.j.h.a;
import e.t.j.h.d;
import e.t.j.h.g;
import h.k2.u.p;
import h.k2.v.u;
import h.t1;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class CreateListDialog extends BaseDialog {
    @e
    private final Boolean t;
    @d
    private final p<String, Boolean, t1> u;
    @e
    private String v;
    @d
    private final g w;
    @d
    private final g x;
    @d
    private final g y;
    @d
    private final a z;

    public /* synthetic */ CreateListDialog(Context context, Boolean bool, p pVar, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? Boolean.TRUE : bool, pVar);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        k4 e2 = k4.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @e
    public final Boolean getDelShow() {
        return this.t;
    }

    @d
    public final p<String, Boolean, t1> getListener() {
        return this.u;
    }

    @d
    public final g getOnClick() {
        return this.x;
    }

    @d
    public final g getOnClickClose() {
        return this.y;
    }

    @d
    public final g getOnClickDel() {
        return this.w;
    }

    @d
    public final a getOnTextChanged() {
        return this.z;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setMoveWithKeyboard(true);
        setGravity(80);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public k l(@d View view) {
        return new r(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CreateListDialog(@d Context context, @e Boolean bool, @d p<? super String, ? super Boolean, t1> pVar) {
        super(context);
        this.t = bool;
        this.u = pVar;
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.w = dVar.a(new CreateListDialog$onClickDel$1(this));
        this.x = dVar.a(new CreateListDialog$onClick$1(this));
        this.y = dVar.a(new CreateListDialog$onClickClose$1(this));
        this.z = d.c.a.a(new CreateListDialog$onTextChanged$1(this));
    }
}
