package com.jihuanshe.ui.page.user;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.ui.BaseActivity;
import e.l.h.l.b;
import e.l.k.a;
import e.t.j.h.g;
import inject.annotation.creator.Creator;
import k.e.a.d;

@Creator
/* loaded from: classes2.dex */
public final class AboutActivity extends BaseActivity<b> {
    @d
    private final g n;
    @d
    private final g o;
    @d
    private final g p;
    @d
    private final g q;
    @d
    private final g r;
    @d
    private final g s;

    public AboutActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.n = dVar.a(new AboutActivity$onClickUserAgreement$1(this));
        this.o = dVar.a(new AboutActivity$onClickCompanyInfo$1(this));
        this.p = dVar.a(new AboutActivity$onClickChildNotice$1(this));
        this.q = dVar.a(new AboutActivity$onClickPrivacyPolicy$1(this));
        this.r = dVar.a(new AboutActivity$onClickInfoList$1(this));
        this.s = dVar.a(new AboutActivity$onClickCooperationSharing$1(this));
    }

    @d
    public final g W() {
        return this.p;
    }

    @d
    public final g X() {
        return this.o;
    }

    @d
    public final g Y() {
        return this.s;
    }

    @d
    public final g Z() {
        return this.r;
    }

    @d
    public final g a0() {
        return this.q;
    }

    @d
    public final g b0() {
        return this.n;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(AboutActivity$flowOfAppBar$1.INSTANCE);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        a d2 = a.d(getLayoutInflater());
        d2.h(this);
        return d2;
    }
}
