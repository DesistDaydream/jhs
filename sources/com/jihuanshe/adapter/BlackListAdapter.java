package com.jihuanshe.adapter;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.BanUser;
import com.jihuanshe.ui.page.user.BlackListActivity;
import e.t.j.h.g;
import e.t.k.a.c.a;
import e.t.o.d;
import e.t.r.a.b;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class BlackListAdapter extends a<BanUser> {
    @d

    /* renamed from: d  reason: collision with root package name */
    private final BlackListActivity f3746d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final b f3747e;

    public BlackListAdapter(@d BlackListActivity blackListActivity) {
        super(null, 1, null);
        this.f3746d = blackListActivity;
        this.f3747e = new b(d.a.c(e.t.o.d.a, null, 1, null).d(6));
    }

    @k.e.a.d
    public final BlackListActivity getActivity() {
        return this.f3746d;
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_black_list;
    }

    @k.e.a.d
    public final b v() {
        return this.f3747e;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d BanUser banUser, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(10, this);
        viewDataBinding.setVariable(8, banUser);
    }

    @k.e.a.d
    public final g x(@k.e.a.d BanUser banUser) {
        return e.t.j.h.d.a.a(new BlackListAdapter$remove$1(this, banUser));
    }
}
