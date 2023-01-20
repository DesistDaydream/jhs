package com.jihuanshe.viewmodel.user;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.ui.widget.GameBar;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.k;
import h.t1;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class WantBuyViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c */
    private final NLive<List<WantBuyList>> f4583c = new NLive<>(null, 1, null);

    public static /* synthetic */ a t0(WantBuyViewModel wantBuyViewModel, LoadMore.State state, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            state = null;
        }
        return wantBuyViewModel.s0(state);
    }

    @d
    public final a<t1> delete(int i2) {
        return a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).i0(Integer.valueOf(i2))), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<WantBuyList> q0(@d String str) {
        k kVar = (k) e.l.n.a.d(k.class, true, false, false, 60L, true);
        GameBar.a aVar = GameBar.b;
        Game value = aVar.a().getValue();
        String gameKey = value == null ? null : value.getGameKey();
        Game value2 = aVar.a().getValue();
        return a.h(FlowKt.c(kVar.Q(str, gameKey, value2 == null ? null : value2.getGameSubKey())), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<WantBuyList>> r0() {
        return this.f4583c;
    }

    @d
    public final a<e<WantBuyList>> s0(@k.e.a.e LoadMore.State state) {
        k kVar = (k) e.l.n.a.d(k.class, true, false, false, 60L, true);
        GameBar.a aVar = GameBar.b;
        Game value = aVar.a().getValue();
        String gameKey = value == null ? null : value.getGameKey();
        Game value2 = aVar.a().getValue();
        return a.h(a.o(BinderKt.b(FlowKt.c(kVar.e0(gameKey, value2 == null ? null : value2.getGameSubKey(), this.b.a(state).d())), this.f4583c, this.b.f()), null, new WantBuyViewModel$getWantBuyList$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> u0(int i2) {
        k kVar = (k) e.l.n.a.d(k.class, true, false, false, 60L, true);
        GameBar.a aVar = GameBar.b;
        Game value = aVar.a().getValue();
        String gameKey = value == null ? null : value.getGameKey();
        Game value2 = aVar.a().getValue();
        return a.h(FlowKt.c(kVar.v(gameKey, value2 == null ? null : value2.getGameSubKey(), i2)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> v0(int i2, @k.e.a.e String str) {
        return a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).S(Integer.valueOf(i2), str)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
