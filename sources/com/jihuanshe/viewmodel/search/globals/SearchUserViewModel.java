package com.jihuanshe.viewmodel.search.globals;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.SearchUser;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.s;
import e.l.n.c.w;
import h.t1;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class SearchUserViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final e.n.f<List<SearchUser>> f4530c = new e.n.f<>(null, 1, null);

    public static /* synthetic */ a t0(SearchUserViewModel searchUserViewModel, String str, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            state = null;
        }
        return searchUserViewModel.s0(str, state);
    }

    @d
    public final e.n.f<List<SearchUser>> q0() {
        return this.f4530c;
    }

    @d
    public final a<t1> r0(@d SearchUser searchUser) {
        a j2;
        if (!searchUser.getFollowed()) {
            w wVar = (w) e.l.n.a.d(w.class, false, false, false, 60L, true);
            Integer id = searchUser.getId();
            j2 = a.j(FlowKt.c(wVar.b(id != null ? id.intValue() : 0)), null, new SearchUserViewModel$handleFollow$1(searchUser), 1, null);
        } else {
            w wVar2 = (w) e.l.n.a.d(w.class, false, false, false, 60L, true);
            Integer id2 = searchUser.getId();
            j2 = a.j(FlowKt.c(wVar2.c(id2 != null ? id2.intValue() : 0)), null, new SearchUserViewModel$handleFollow$2(searchUser), 1, null);
        }
        return a.h(j2, ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<e<SearchUser>> s0(@d String str, @k.e.a.e LoadMore.State state) {
        return a.h(a.o(BinderKt.b(FlowKt.c(((s) e.l.n.a.d(s.class, true, false, false, 60L, true)).b(str, this.b.a(state).d())), this.f4530c, this.b.f()), null, new SearchUserViewModel$search$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
