package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.ExpressData;
import com.jihuanshe.model.OrderDetailInfo;
import com.vector.util.LayoutManagers;
import e.l.g.s;
import e.l.h.j.b.f.b;
import e.l.k.w4;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.t.j.h.g;
import h.w;
import h.z;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class ExpressDetailsDialog extends BaseDialog {
    @d
    private final g A;
    @d
    private final OrderDetailInfo t;
    @d
    private final List<ExpressData> u;
    @d
    private final w v;
    @d
    private final w w;
    @d
    private final w x;
    @d
    private final w y;
    @d
    private final g z;

    public ExpressDetailsDialog(@d Context context, @d OrderDetailInfo orderDetailInfo, @d List<ExpressData> list) {
        super(context);
        this.t = orderDetailInfo;
        this.u = list;
        this.v = z.c(new ExpressDetailsDialog$footEmpty$2(context));
        this.w = z.c(ExpressDetailsDialog$layoutManager$2.INSTANCE);
        this.x = z.c(ExpressDetailsDialog$decoration$2.INSTANCE);
        this.y = z.c(ExpressDetailsDialog$adapterExpress$2.INSTANCE);
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.z = dVar.a(new ExpressDetailsDialog$onClickCopy$1(this));
        this.A = dVar.a(new ExpressDetailsDialog$onClickClose$1(this));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        w4 e2 = w4.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @d
    public final s getAdapterExpress() {
        return (s) this.y.getValue();
    }

    @d
    public final b getDecoration() {
        return (b) this.x.getValue();
    }

    @d
    public final List<ExpressData> getExpressList() {
        return this.u;
    }

    @d
    public final TextView getFootEmpty() {
        return (TextView) this.v.getValue();
    }

    @d
    public final OrderDetailInfo getInfo() {
        return this.t;
    }

    @d
    public final LayoutManagers.a getLayoutManager() {
        return (LayoutManagers.a) this.w.getValue();
    }

    @d
    public final g getOnClickClose() {
        return this.A;
    }

    @d
    public final g getOnClickCopy() {
        return this.z;
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
