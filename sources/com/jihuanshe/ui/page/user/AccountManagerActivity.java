package com.jihuanshe.ui.page.user;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.ui.BaseActivity;
import e.l.h.l.b;
import e.l.k.c;
import e.t.j.h.g;
import inject.annotation.creator.Creator;
import k.e.a.d;

@Creator
/* loaded from: classes2.dex */
public final class AccountManagerActivity extends BaseActivity<b> {
    @d
    private final g n = e.t.j.h.d.a.a(new AccountManagerActivity$onClickClose$1(this));

    @d
    public final g W() {
        return this.n;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(AccountManagerActivity$flowOfAppBar$1.INSTANCE);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        c d2 = c.d(getLayoutInflater());
        d2.h(this);
        return d2;
    }
}
