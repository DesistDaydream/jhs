package com.jihuanshe.viewmodel.user.edit;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.viewmodel.login.LoginViewModel;
import e.g.d.a;
import e.l.n.c.i;
import e.n.p;
import h.t1;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class EditPhoneNumberViewModel extends LoginViewModel {
    @d

    /* renamed from: m  reason: collision with root package name */
    private final p f4586m = new p(null, 1, null);
    @d
    private final p n = new p(null, 1, null);
    @d
    private String o = "";
    @d
    private String p = "";

    @d
    public final a<t1> S0(@d String str, @d String str2) {
        return a.h(a.j(FlowKt.c(((i) e.l.n.a.d(i.class, true, false, false, 60L, true)).b(this.o, this.p, str, str2)), null, new EditPhoneNumberViewModel$bindNewPhone$1(str), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> T0(@d String str, @d String str2) {
        return a.h(a.j(FlowKt.c(((i) e.l.n.a.d(i.class, true, false, false, 60L, true)).d(str, str2)), null, new EditPhoneNumberViewModel$checkBindPhone$1(this, str, str2), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final String U0() {
        return this.p;
    }

    @d
    public final String V0() {
        return this.o;
    }

    @d
    public final p W0() {
        return this.n;
    }

    @d
    public final p X0() {
        return this.f4586m;
    }

    public final void Y0(@d String str) {
        this.p = str;
    }

    public final void Z0(@d String str) {
        this.o = str;
    }
}
