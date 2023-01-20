package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import com.jihuanshe.repo.ReportRepo;
import com.vector.util.LayoutManagers;
import e.l.g.q0;
import e.l.k.o5;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.g;
import h.k2.u.l;
import h.t1;
import h.w;
import h.z;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class ReportDialog extends BaseDialog {
    @d
    private final l<String, t1> t;
    @d
    private final g u;
    @d
    private final g v;
    @d
    private final f<List<String>> w;
    @d
    private final w x;
    @d
    private final w y;
    @d
    private final e.t.j.h.l z;

    /* JADX WARN: Multi-variable type inference failed */
    public ReportDialog(@d Context context, @d l<? super String, t1> lVar) {
        super(context);
        this.t = lVar;
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.u = dVar.a(new ReportDialog$onClickCancel$1(this));
        this.v = dVar.a(new ReportDialog$onClickConfirm$1(this));
        this.w = ReportRepo.a.e();
        this.x = z.c(ReportDialog$adapter$2.INSTANCE);
        this.y = z.c(ReportDialog$layoutManager$2.INSTANCE);
        this.z = d.e.a.a(new ReportDialog$onItemClick$1(this));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @k.e.a.d
    public ViewDataBinding d() {
        o5 e2 = o5.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @k.e.a.d
    public final q0 getAdapter() {
        return (q0) this.x.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a getLayoutManager() {
        return (LayoutManagers.a) this.y.getValue();
    }

    @k.e.a.d
    public final l<String, t1> getListener() {
        return this.t;
    }

    @k.e.a.d
    public final g getOnClickCancel() {
        return this.u;
    }

    @k.e.a.d
    public final g getOnClickConfirm() {
        return this.v;
    }

    @k.e.a.d
    public final e.t.j.h.l getOnItemClick() {
        return this.z;
    }

    @k.e.a.d
    public final f<List<String>> getReason() {
        return this.w;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setGravity(80);
        ReportRepo reportRepo = ReportRepo.a;
        reportRepo.e().f(this, new ReportDialog$flowOfSetup$1(this));
        reportRepo.b(LifecycleOwnerKt.getLifecycleScope(this));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @k.e.a.d
    public k l(@k.e.a.d View view) {
        return new r(view);
    }
}
