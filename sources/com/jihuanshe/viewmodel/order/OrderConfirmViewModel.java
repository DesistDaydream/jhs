package com.jihuanshe.viewmodel.order;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.model.OrderConfirmResult;
import com.jihuanshe.model.UserAddress;
import e.g.d.a;
import e.l.h.l.b;
import e.l.n.c.k;
import e.l.n.c.l;
import e.l.n.c.n;
import e.n.f;
import i.b.v3.h;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class OrderConfirmViewModel extends b {
    @d
    private final f<n> b = new f<>(null, 1, null);
    @d

    /* renamed from: c  reason: collision with root package name */
    private final NLive<UserAddress> f4485c = new NLive<>(null, 1, null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private final NLive<OrderConfirmResult> f4486d = new NLive<>(null, 1, null);

    @d
    public final a<OrderConfirmResult> p0(@e Integer num, @e String str) {
        l lVar = (l) e.l.n.a.d(l.class, true, false, false, 60L, true);
        n value = this.b.getValue();
        Integer valueOf = value == null ? null : Integer.valueOf(value.a());
        UserAddress value2 = this.f4485c.getValue();
        return a.h(a.j(FlowKt.c(lVar.e(valueOf, num, value2 == null ? null : Integer.valueOf(value2.getId()), str)), null, new OrderConfirmViewModel$confirm$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final NLive<UserAddress> q0() {
        return this.f4485c;
    }

    @d
    public final f<n> r0() {
        return this.b;
    }

    @d
    public final NLive<OrderConfirmResult> s0() {
        return this.f4486d;
    }

    @d
    public final a<?> t0(int i2) {
        return a.h(a.j(FlowKt.c(h.q2(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).R(1), ((l) e.l.n.a.d(l.class, true, false, false, 60L, true)).f(i2), new OrderConfirmViewModel$initData$1(null))), null, new OrderConfirmViewModel$initData$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
