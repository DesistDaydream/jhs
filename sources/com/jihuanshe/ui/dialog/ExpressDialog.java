package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.CardConsignmentInfo;
import com.jihuanshe.model.ExpressData;
import com.jihuanshe.model.OrderReturnDetail;
import com.vector.util.LayoutManagers;
import e.l.g.t;
import e.l.h.j.b.f.b;
import e.l.k.u4;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.t.j.h.g;
import h.k2.v.u;
import h.w;
import h.z;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class ExpressDialog extends BaseDialog {
    @e
    private final CardConsignmentInfo t;
    @e
    private final OrderReturnDetail u;
    @e
    private final List<ExpressData> v;
    @d
    private final w w;
    @d
    private final w x;
    @d
    private final w y;
    @d
    private final g z;

    public /* synthetic */ ExpressDialog(Context context, CardConsignmentInfo cardConsignmentInfo, OrderReturnDetail orderReturnDetail, List list, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : cardConsignmentInfo, (i2 & 4) != 0 ? null : orderReturnDetail, (i2 & 8) != 0 ? null : list);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        u4 e2 = u4.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @d
    public final t getAdapterExpress() {
        return (t) this.y.getValue();
    }

    @e
    public final CardConsignmentInfo getDataInfo() {
        return this.t;
    }

    @e
    public final OrderReturnDetail getDataReturnInfo() {
        return this.u;
    }

    @d
    public final b getDecoration() {
        return (b) this.x.getValue();
    }

    @e
    public final List<ExpressData> getExpressList() {
        return this.v;
    }

    @d
    public final LayoutManagers.a getLayoutManager() {
        return (LayoutManagers.a) this.w.getValue();
    }

    @d
    public final g getOnClickClose() {
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

    public ExpressDialog(@d Context context, @e CardConsignmentInfo cardConsignmentInfo, @e OrderReturnDetail orderReturnDetail, @e List<ExpressData> list) {
        super(context);
        this.t = cardConsignmentInfo;
        this.u = orderReturnDetail;
        this.v = list;
        this.w = z.c(ExpressDialog$layoutManager$2.INSTANCE);
        this.x = z.c(ExpressDialog$decoration$2.INSTANCE);
        this.y = z.c(ExpressDialog$adapterExpress$2.INSTANCE);
        this.z = e.t.j.h.d.a.a(new ExpressDialog$onClickClose$1(this));
    }
}
