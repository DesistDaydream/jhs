package com.jihuanshe.ui.page.exam;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.exam.EtiquetteExamViewModel;
import e.l.k.s0;
import e.t.j.h.g;
import h.k2.u.l;
import h.t1;
import inject.annotation.creator.Creator;
import k.e.a.d;

@Creator
/* loaded from: classes2.dex */
public final class EtiquetteExamActivity extends BaseActivity<EtiquetteExamViewModel> {
    @d
    private final g n;
    @d
    private final g o;
    @d
    private final l<Integer, t1> p;

    public EtiquetteExamActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.n = dVar.a(new EtiquetteExamActivity$onClickStart$1(this));
        this.o = dVar.a(new EtiquetteExamActivity$onClickOp$1(this));
        this.p = new EtiquetteExamActivity$onChoose$1(this);
    }

    @d
    public final l<Integer, t1> W() {
        return this.p;
    }

    @d
    public final g X() {
        return this.o;
    }

    @d
    public final g Y() {
        return this.n;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        m(R.color.white);
        ((EtiquetteExamViewModel) L()).A0().f(this, new EtiquetteExamActivity$flowOfSetup$1(this));
        ((EtiquetteExamViewModel) L()).v0().f(this, new EtiquetteExamActivity$flowOfSetup$2(this));
        BinderKt.p(BinderKt.s(((EtiquetteExamViewModel) L()).q0(), this, false, false, 6, null));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        s0 e2 = s0.e(getLayoutInflater());
        e2.i(this);
        e2.j((EtiquetteExamViewModel) L());
        return e2;
    }
}
