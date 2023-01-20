package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.vector.util.Res;
import e.l.k.o3;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.t.j.h.g;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public final class BuyerCancelReasonDialog extends BaseDialog {
    @d
    private final l<String, t1> t;
    @d
    private final List<String> u;
    @d
    private e.n.l v;
    @d
    private final g w;
    @d
    private final g x;

    /* JADX WARN: Multi-variable type inference failed */
    public BuyerCancelReasonDialog(@d Context context, @d l<? super String, t1> lVar) {
        super(context);
        this.t = lVar;
        Res res = Res.a;
        this.u = CollectionsKt__CollectionsKt.P(Res.w(res, R.string.reason_buyer_cancel_1, null, 2, null), Res.w(res, R.string.reason_buyer_cancel_2, null, 2, null), Res.w(res, R.string.reason_buyer_cancel_3, null, 2, null), Res.w(res, R.string.reason_buyer_cancel_4, null, 2, null), Res.w(res, R.string.reason_buyer_cancel_5, null, 2, null));
        this.v = new e.n.l(null, 1, null);
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.w = dVar.a(new BuyerCancelReasonDialog$onClickCancel$1(this));
        this.x = dVar.a(new BuyerCancelReasonDialog$onChoose$2(this));
    }

    @d
    public final g C(int i2) {
        return e.t.j.h.d.a.a(new BuyerCancelReasonDialog$onChoose$1(this, i2));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        o3 e2 = o3.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @d
    public final l<String, t1> getListener() {
        return this.t;
    }

    @d
    public final g getOnChoose() {
        return this.x;
    }

    @d
    public final g getOnClickCancel() {
        return this.w;
    }

    @d
    public final List<String> getReasonList() {
        return this.u;
    }

    @d
    public final e.n.l getReasonStr() {
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

    public final void setReasonStr(@d e.n.l lVar) {
        this.v = lVar;
    }
}
