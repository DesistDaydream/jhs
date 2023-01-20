package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.Res;
import e.l.k.s4;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.n.p;
import e.t.j.h.a;
import e.t.j.h.d;
import e.t.j.h.g;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public final class EditUserDialog extends BaseDialog {
    public static final /* synthetic */ n<Object>[] D = {n0.r(new PropertyReference1Impl(n0.d(EditUserDialog.class), "et", "getEt()Landroid/widget/EditText;"))};
    @d
    private final a A;
    @d
    private final g B;
    @d
    private final g C;
    @d
    private final String t;
    private final boolean u;
    private final int v;
    @e
    private final String w;
    @d
    private final l<String, t1> x;
    @d
    private final p y;
    @d
    private final h.m2.e z;

    public /* synthetic */ EditUserDialog(Context context, String str, boolean z, int i2, String str2, l lVar, int i3, u uVar) {
        this(context, str, z, i2, (i3 & 16) != 0 ? "" : str2, lVar);
    }

    public final boolean C() {
        return this.u;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        s4 e2 = s4.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @d
    public final a getAfterTC() {
        return this.A;
    }

    @d
    public final EditText getEt() {
        return (EditText) this.z.a(this, D[0]);
    }

    @d
    public final p getHintStr() {
        return this.y;
    }

    @d
    public final l<String, t1> getListener() {
        return this.x;
    }

    public final int getMax() {
        return this.v;
    }

    @e
    public final String getOldText() {
        return this.w;
    }

    @d
    public final g getOnClose() {
        return this.C;
    }

    @d
    public final g getOnConfirm() {
        return this.B;
    }

    @d
    public final String getTips() {
        return this.t;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setMoveWithKeyboard(true);
        setGravity(80);
        String str = this.t;
        Res res = Res.a;
        if (f0.g(str, Res.w(res, R.string.shipping_tip, null, 2, null))) {
            this.y.setValue(Res.w(res, R.string.free_shipping_tip, null, 2, null));
        }
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public k l(@d View view) {
        return new r(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EditUserDialog(@d Context context, @d String str, boolean z, int i2, @e String str2, @d l<? super String, t1> lVar) {
        super(context);
        this.t = str;
        this.u = z;
        this.v = i2;
        this.w = str2;
        this.x = lVar;
        this.y = new p(null, 1, null);
        this.z = BindViewKt.p(this, R.id.et);
        this.A = d.c.a.a(new EditUserDialog$afterTC$1(this));
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.B = dVar.a(new EditUserDialog$onConfirm$1(this));
        this.C = dVar.a(new EditUserDialog$onClose$1(this));
    }
}
