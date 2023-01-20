package com.jihuanshe.viewmodel.entrepot;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.FailProductInfo;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.k;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class SearchChildNoPassViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<List<FailProductInfo>> f4437c = new NLive<>(null, 1, null);

    public static /* synthetic */ a s0(SearchChildNoPassViewModel searchChildNoPassViewModel, String str, LoadMore.State state, Integer num, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            state = null;
        }
        if ((i2 & 4) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        return searchChildNoPassViewModel.q0(str, state, num, str2);
    }

    @d
    public final a<e<FailProductInfo>> q0(@k.e.a.e String str, @k.e.a.e LoadMore.State state, @k.e.a.e Integer num, @k.e.a.e String str2) {
        return a.h(a.o(BinderKt.b(FlowKt.c(k.a.e((k) e.l.n.a.d(k.class, true, false, false, 60L, true), str2, str, num, this.b.a(state).d(), null, null, 48, null)), this.f4437c, this.b.f()), null, new SearchChildNoPassViewModel$getFailProducts$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<List<FailProductInfo>> r0() {
        return this.f4437c;
    }
}
