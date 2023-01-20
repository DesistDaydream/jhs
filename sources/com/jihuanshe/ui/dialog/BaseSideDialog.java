package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.dialog.BaseSideDialog;
import com.jihuanshe.ui.widget.LabelsViewNew;
import com.vector.util.UIUtil;
import e.l.k.u5;
import e.l.q.a.k0.k;
import e.l.q.a.k0.p;
import e.t.j.h.g;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public abstract class BaseSideDialog extends BaseDialog {
    @d
    private final LabelsViewNew.e A;
    private final int t;
    @d
    private final List<Integer> u;
    private final boolean v;
    private final boolean w;
    private final int x;
    @d
    private final g y;
    @d
    private final g z;

    public BaseSideDialog(@d Context context) {
        super(context);
        this.t = UIUtil.c();
        this.u = CollectionsKt__CollectionsKt.P(0);
        this.v = true;
        this.x = 1;
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.y = dVar.a(new BaseSideDialog$onClickConfirm$1(this));
        this.z = dVar.a(new BaseSideDialog$onClickReset$1(this));
        this.A = new LabelsViewNew.e() { // from class: e.l.q.a.g
            @Override // com.jihuanshe.ui.widget.LabelsViewNew.e
            public final void a(TextView textView, Object obj, boolean z, int i2) {
                BaseSideDialog.D(BaseSideDialog.this, textView, obj, z, i2);
            }
        };
    }

    public static /* synthetic */ void D(BaseSideDialog baseSideDialog, TextView textView, Object obj, boolean z, int i2) {
        G(baseSideDialog, textView, obj, z, i2);
    }

    public static final void G(BaseSideDialog baseSideDialog, TextView textView, Object obj, boolean z, int i2) {
        textView.setSelected(z);
        if (z) {
            baseSideDialog.F(i2);
        } else {
            baseSideDialog.E(i2);
        }
    }

    public abstract void C();

    public abstract void E(int i2);

    public abstract void F(int i2);

    public void H() {
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        u5 e2 = u5.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    public boolean getFirstMatch() {
        return this.w;
    }

    @d
    public List<Integer> getInitIndexs() {
        return this.u;
    }

    @d
    public abstract List<String> getLocalData();

    public boolean getNeedResetButton() {
        return this.v;
    }

    @d
    public final g getOnClickConfirm() {
        return this.y;
    }

    @d
    public final g getOnClickReset() {
        return this.z;
    }

    @d
    public final LabelsViewNew.e getOnStateChanged() {
        return this.A;
    }

    public int getSelectType() {
        return this.x;
    }

    public final int getStatusBarHeight() {
        return this.t;
    }

    @d
    public abstract String getSubTitleText();

    @d
    public abstract String getTitleText();

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        super.k();
        setGravity(GravityCompat.END);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public k l(@d View view) {
        return new p(view);
    }
}
