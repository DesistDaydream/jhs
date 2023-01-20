package com.jihuanshe.viewmodel.user;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.User;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.k;
import e.l.n.c.v;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class FollowViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<List<User>> f4568c = new NLive<>(null, 1, null);

    public static /* synthetic */ a s0(FollowViewModel followViewModel, int i2, String str, LoadMore.State state, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            state = null;
        }
        return followViewModel.r0(i2, str, state);
    }

    @d
    public final NLive<List<User>> q0() {
        return this.f4568c;
    }

    @d
    public final a<e<User>> r0(int i2, @k.e.a.e String str, @k.e.a.e LoadMore.State state) {
        if (str == null || str.length() == 0) {
            return a.h(a.o(BinderKt.b(FlowKt.c(((v) e.l.n.a.d(v.class, true, false, false, 60L, true)).a(i2, this.b.a(state).d())), this.f4568c, this.b.f()), null, new FollowViewModel$getUser$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
        }
        return a.h(a.o(BinderKt.b(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).b(str, this.b.a(state).d())), this.f4568c, this.b.f()), null, new FollowViewModel$getUser$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
