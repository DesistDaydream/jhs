package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.vector.util.LayoutManagers;
import e.l.g.d0;
import e.l.g.z;
import e.l.k.e5;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.l;
import h.t1;
import h.w;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class ListDialog extends BaseDialog {
    @d
    private final List<z> t;
    private final int u;
    @d
    private final g v;
    @d
    private final g w;
    @d
    private final l x;
    @d
    private final w y;
    @d
    private final w z;

    /* JADX WARN: Multi-variable type inference failed */
    public ListDialog(@d Context context, @d List<? extends z> list, int i2, @d h.k2.u.l<? super Integer, t1> lVar) {
        super(context);
        this.t = list;
        this.u = i2;
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.v = dVar.a(new ListDialog$onClickCancel$1(this));
        this.w = dVar.a(new ListDialog$onClickConfirm$1(this, lVar));
        this.x = d.e.a.a(new ListDialog$onItemClick$1(this));
        this.y = h.z.c(new ListDialog$adapter$2(this));
        this.z = h.z.c(ListDialog$layoutManager$2.INSTANCE);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @k.e.a.d
    public ViewDataBinding d() {
        e5 e2 = e5.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @k.e.a.d
    public final d0 getAdapter() {
        return (d0) this.y.getValue();
    }

    public final int getChoose() {
        return this.u;
    }

    @k.e.a.d
    public final List<z> getData() {
        return this.t;
    }

    @k.e.a.d
    public final LayoutManagers.a getLayoutManager() {
        return (LayoutManagers.a) this.z.getValue();
    }

    @k.e.a.d
    public final g getOnClickCancel() {
        return this.v;
    }

    @k.e.a.d
    public final g getOnClickConfirm() {
        return this.w;
    }

    @k.e.a.d
    public final l getOnItemClick() {
        return this.x;
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
}
