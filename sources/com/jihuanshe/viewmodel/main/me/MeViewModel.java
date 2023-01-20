package com.jihuanshe.viewmodel.main.me;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.User;
import com.jihuanshe.model.UserNumber;
import e.g.d.a;
import e.l.h.l.b;
import e.l.n.c.i;
import e.n.f;
import e.n.l;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class MeViewModel extends b {
    @d
    private final f<User> b = new f<>(UserKV.f3913c.w());
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<UserNumber> f4472c = new NLive<>(null, 1, null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private final l f4473d = new l(0);

    @d
    public final a<UserNumber> p0() {
        return a.h(FlowKt.a(((i) e.l.n.a.d(i.class, true, false, false, 60L, true)).g(), this.f4472c), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<UserNumber> q0() {
        return this.f4472c;
    }

    @d
    public final l r0() {
        return this.f4473d;
    }

    @d
    public final f<User> s0() {
        return this.b;
    }

    @d
    public final a<User> t0() {
        return a.j(UserKV.f3913c.y(ViewModelKt.getViewModelScope(this)), null, new MeViewModel$refreshUser$1(this), 1, null);
    }
}
