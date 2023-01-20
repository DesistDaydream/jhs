package com.jihuanshe.ui.dialog;

import android.content.Context;
import androidx.annotation.StringRes;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.vector.util.Res;
import e.l.k.g4;
import e.n.i;
import e.n.p;
import e.t.j.h.g;
import h.k2.u.a;
import h.t1;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public class UseDialog extends BaseDialog {
    @d
    private final i A;
    @e
    private a<t1> B;
    @e
    private a<t1> C;
    @d
    private final g D;
    @d
    private final g E;
    @d
    private final g F;
    @d
    private final p t;
    @d
    private final i u;
    @d
    private final p v;
    @d
    private final i w;
    @d
    private final p x;
    @d
    private final p y;
    @d
    private final i z;

    public UseDialog(@d Context context) {
        super(context);
        Res res = Res.a;
        this.t = new p(Res.w(res, R.string.common_confirm_please, null, 2, null));
        this.u = new i(Boolean.FALSE);
        this.v = new p(null, 1, null);
        this.w = new i(null, 1, null);
        this.x = new p(Res.w(res, R.string.common_confirm, null, 2, null));
        this.y = new p(Res.w(res, R.string.common_cancel, null, 2, null));
        Boolean bool = Boolean.TRUE;
        this.z = new i(bool);
        this.A = new i(bool);
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.D = dVar.a(new UseDialog$cancelClick$1(this));
        this.E = dVar.a(new UseDialog$rightClick$1(this));
        this.F = dVar.a(new UseDialog$leftClick$1(this));
    }

    public final void C() {
        this.z.setValue(Boolean.FALSE);
    }

    public final void D() {
        this.A.setValue(Boolean.FALSE);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        g4 e2 = g4.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @d
    public final g getCancelClick() {
        return this.D;
    }

    @d
    public final p getContent() {
        return this.v;
    }

    @d
    public final i getContentVisible() {
        return this.w;
    }

    @d
    public final p getLeftButtonText() {
        return this.y;
    }

    @d
    public final i getLeftButtonVisible() {
        return this.z;
    }

    @d
    public final g getLeftClick() {
        return this.F;
    }

    @e
    public final a<t1> getOnClickLeftButton() {
        return this.C;
    }

    @e
    public final a<t1> getOnClickRightButton() {
        return this.B;
    }

    @d
    public final p getRightButtonText() {
        return this.x;
    }

    @d
    public final i getRightButtonVisible() {
        return this.A;
    }

    @d
    public final g getRightClick() {
        return this.E;
    }

    @d
    public final p getTitle() {
        return this.t;
    }

    @d
    public final i getTitleVisible() {
        return this.u;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setGravity(17);
    }

    public final void setContent(@d String str) {
        this.v.setValue(str);
        this.w.setValue(Boolean.TRUE);
    }

    public final void setLeftButtonText(@d String str) {
        this.y.setValue(str);
    }

    public final void setOnClickLeftButton(@e a<t1> aVar) {
        this.C = aVar;
    }

    public final void setOnClickRightButton(@e a<t1> aVar) {
        this.B = aVar;
    }

    public final void setRightButtonText(@d String str) {
        this.x.setValue(str);
    }

    public final void setTitle(@d String str) {
        this.t.setValue(str);
        this.u.setValue(Boolean.TRUE);
    }

    public final void setLeftButtonText(@StringRes int i2) {
        this.y.setValue(Res.w(Res.a, i2, null, 2, null));
    }

    public final void setRightButtonText(@StringRes int i2) {
        this.x.setValue(Res.w(Res.a, i2, null, 2, null));
    }

    public final void setContent(@StringRes int i2) {
        this.v.setValue(Res.w(Res.a, i2, null, 2, null));
        this.w.setValue(Boolean.TRUE);
    }
}
