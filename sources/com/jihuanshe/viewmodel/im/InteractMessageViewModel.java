package com.jihuanshe.viewmodel.im;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.model.InteractNewCount;
import e.g.d.a;
import e.l.h.l.b;
import e.l.n.c.h;
import h.t1;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class InteractMessageViewModel extends b {
    @d
    private final NLive<InteractNewCount> b = new NLive<>(null, 1, null);

    @d
    public final a<InteractNewCount> p0() {
        return a.h(FlowKt.a(((h) e.l.n.a.d(h.class, true, false, false, 60L, true)).a(), this.b), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<InteractNewCount> q0() {
        return this.b;
    }

    @d
    public final a<t1> r0() {
        return a.h(a.j(FlowKt.c(h.a.a((h) e.l.n.a.d(h.class, true, false, false, 60L, true), null, 1, null)), null, InteractMessageViewModel$readAll$1.INSTANCE, 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
