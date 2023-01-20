package com.jihuanshe.adapter;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.page.user.FansActivity;
import e.t.j.h.g;
import e.t.k.a.c.a;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class FansAdapter extends a<User> {
    @d

    /* renamed from: d  reason: collision with root package name */
    private final FansActivity f3751d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final e.t.r.a.a f3752e;

    public FansAdapter(@d FansActivity fansActivity) {
        super(null, 1, null);
        this.f3751d = fansActivity;
        this.f3752e = new e.t.r.a.a(0, 0, 3, null);
    }

    @d
    public final FansActivity getActivity() {
        return this.f3751d;
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_fans;
    }

    @d
    public final g v(@d User user) {
        return e.t.j.h.d.a.a(new FansAdapter$follow$1(this, user));
    }

    @d
    public final e.t.r.a.a w() {
        return this.f3752e;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: x */
    public void u(@d User user, @d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(10, this);
        viewDataBinding.setVariable(8, user);
    }
}
