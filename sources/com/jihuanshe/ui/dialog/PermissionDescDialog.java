package com.jihuanshe.ui.dialog;

import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.databinding.ViewDataBinding;
import com.vector.util.Res;
import e.l.k.i5;
import e.n.l;
import e.n.p;
import e.t.j.h.g;
import h.k2.u.a;
import h.t1;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class PermissionDescDialog extends BaseDialog {
    @d
    private final p t;
    @d
    private final p u;
    @d
    private final p v;
    @d
    private final p w;
    @d
    private final l x;
    @e
    private a<t1> y;
    @d
    private final g z;

    public PermissionDescDialog(@d Context context) {
        super(context);
        this.t = new p(null, 1, null);
        this.u = new p(null, 1, null);
        this.v = new p(null, 1, null);
        this.w = new p(null, 1, null);
        this.x = new l(null, 1, null);
        this.z = e.t.j.h.d.a.a(new PermissionDescDialog$confirmClick$1(this));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        i5 e2 = i5.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @d
    public final p getConfirm() {
        return this.w;
    }

    @d
    public final g getConfirmClick() {
        return this.z;
    }

    @d
    public final p getDesc() {
        return this.v;
    }

    @d
    public final l getIcConRes() {
        return this.x;
    }

    @e
    public final a<t1> getOnConfirmClick() {
        return this.y;
    }

    @d
    public final p getPermission() {
        return this.u;
    }

    @d
    public final p getTitle() {
        return this.t;
    }

    public final void setConfirmRes(@StringRes int i2) {
        this.w.r(Res.w(Res.a, i2, null, 2, null));
    }

    public final void setConfirmText(@d String str) {
        this.w.r(str);
    }

    public final void setDescResId(@StringRes int i2) {
        this.v.r(Res.w(Res.a, i2, null, 2, null));
    }

    public final void setDescText(@d String str) {
        this.v.r(str);
    }

    public final void setDrawableId(@DrawableRes int i2) {
        this.x.r(Integer.valueOf(i2));
    }

    public final void setOnConfirmClick(@e a<t1> aVar) {
        this.y = aVar;
    }

    public final void setPermissionRes(@StringRes int i2) {
        this.u.r(Res.w(Res.a, i2, null, 2, null));
    }

    public final void setPermissionText(@d String str) {
        this.u.r(str);
    }

    public final void setTitleRes(@StringRes int i2) {
        this.t.r(Res.w(Res.a, i2, null, 2, null));
    }

    public final void setTitleText(@d String str) {
        this.t.r(str);
    }
}
