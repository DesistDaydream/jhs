package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.model.ChooseItem;
import com.vector.util.LayoutManagers;
import e.l.g.n;
import e.l.k.c4;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.g;
import h.k2.u.l;
import h.t1;
import h.w;
import h.z;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class ChooseDialogNew extends BaseDialog {
    @d
    private final g A;
    @d
    private final g B;
    @d
    private final List<String> t;
    @d
    private final l<String, t1> u;
    @d
    private e.n.l v;
    @d
    private final f<List<ChooseItem>> w;
    @d
    private final w x;
    @d
    private final w y;
    @d
    private final e.t.j.h.l z;

    /* JADX WARN: Multi-variable type inference failed */
    public ChooseDialogNew(@d Context context, @d List<String> list, @d l<? super String, t1> lVar) {
        super(context);
        this.t = list;
        this.u = lVar;
        this.v = new e.n.l(-1);
        this.w = new f<>(null, 1, null);
        this.x = z.c(new ChooseDialogNew$adapter$2(this));
        this.y = z.c(ChooseDialogNew$layoutManager$2.INSTANCE);
        this.z = d.e.a.a(new ChooseDialogNew$onItemClick$1(this));
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.A = dVar.a(new ChooseDialogNew$onClickCancel$1(this));
        this.B = dVar.a(new ChooseDialogNew$onClickConfirm$1(this));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @k.e.a.d
    public ViewDataBinding d() {
        c4 e2 = c4.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @k.e.a.d
    public final n getAdapter() {
        return (n) this.x.getValue();
    }

    @k.e.a.d
    public final List<String> getData() {
        return this.t;
    }

    @k.e.a.d
    public final f<List<ChooseItem>> getDataList() {
        return this.w;
    }

    @k.e.a.d
    public final LayoutManagers.a getLayoutManager() {
        return (LayoutManagers.a) this.y.getValue();
    }

    @k.e.a.d
    public final l<String, t1> getListener() {
        return this.u;
    }

    @k.e.a.d
    public final e.n.l getOldIndex() {
        return this.v;
    }

    @k.e.a.d
    public final g getOnClickCancel() {
        return this.A;
    }

    @k.e.a.d
    public final g getOnClickConfirm() {
        return this.B;
    }

    @k.e.a.d
    public final e.t.j.h.l getOnItemClick() {
        return this.z;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setGravity(80);
        ArrayList arrayList = new ArrayList();
        for (String str : this.t) {
            arrayList.add(new ChooseItem(str, 0));
        }
        this.w.setValue(arrayList);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @k.e.a.d
    public k l(@k.e.a.d View view) {
        return new r(view);
    }

    public final void setOldIndex(@k.e.a.d e.n.l lVar) {
        this.v = lVar;
    }
}
