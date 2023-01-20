package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.CardVersionInfo;
import com.vector.util.LayoutManagers;
import e.l.g.k;
import e.l.k.y3;
import e.l.q.a.k0.r;
import e.t.j.h.d;
import e.t.j.h.g;
import h.k2.u.l;
import h.t1;
import h.w;
import h.z;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class CardPackListDialog extends BaseDialog {
    @d
    private final List<CardVersionInfo> t;
    private final int u;
    @d
    private final l<CardVersionInfo, t1> v;
    @d
    private final w w;
    @d
    private final w x;
    @d
    private final e.t.j.h.l y;
    @d
    private final g z;

    /* JADX WARN: Multi-variable type inference failed */
    public CardPackListDialog(@d Context context, @d List<CardVersionInfo> list, int i2, @d l<? super CardVersionInfo, t1> lVar) {
        super(context);
        this.t = list;
        this.u = i2;
        this.v = lVar;
        this.w = z.c(CardPackListDialog$layoutManager$2.INSTANCE);
        this.x = z.c(new CardPackListDialog$adapter$2(this));
        this.y = d.e.a.a(new CardPackListDialog$onItemClick$1(this));
        this.z = e.t.j.h.d.a.a(new CardPackListDialog$onClickClose$1(this));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @k.e.a.d
    public ViewDataBinding d() {
        y3 e2 = y3.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @k.e.a.d
    public final k getAdapter() {
        return (k) this.x.getValue();
    }

    @k.e.a.d
    public final l<CardVersionInfo, t1> getConfirm() {
        return this.v;
    }

    public final int getCurrentId() {
        return this.u;
    }

    @k.e.a.d
    public final List<CardVersionInfo> getData() {
        return this.t;
    }

    @k.e.a.d
    public final LayoutManagers.a getLayoutManager() {
        return (LayoutManagers.a) this.w.getValue();
    }

    @k.e.a.d
    public final g getOnClickClose() {
        return this.z;
    }

    @k.e.a.d
    public final e.t.j.h.l getOnItemClick() {
        return this.y;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setGravity(80);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @k.e.a.d
    public e.l.q.a.k0.k l(@k.e.a.d View view) {
        return new r(view);
    }
}
