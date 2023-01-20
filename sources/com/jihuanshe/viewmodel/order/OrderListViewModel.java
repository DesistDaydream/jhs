package com.jihuanshe.viewmodel.order;

import com.jihuanshe.R;
import com.jihuanshe.model.Constants;
import com.vector.util.Res;
import e.l.h.l.b;
import e.t.k.a.c.h.c;
import h.a2.u;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public final class OrderListViewModel extends b {
    private final boolean b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f4493c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f4494d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final c f4495e;

    public OrderListViewModel(boolean z) {
        c a;
        this.b = z;
        List<String> P = CollectionsKt__CollectionsKt.P(null, "waiting_to_confirm", Constants.STATE_WAITING_PAY, "waiting_to_send", "waiting_to_receive", "waiting_to_refund,waiting_to_return_goods");
        this.f4493c = P;
        Res res = Res.a;
        this.f4494d = CollectionsKt__CollectionsKt.P(Res.w(res, R.string.order_state_all, null, 2, null), Res.w(res, R.string.order_state_confirm, null, 2, null), Res.w(res, R.string.order_state_pay, null, 2, null), Res.w(res, R.string.order_state_send, null, 2, null), Res.w(res, R.string.order_state_receive, null, 2, null), Res.w(res, R.string.order_state_refund, null, 2, null));
        if (!z) {
            ArrayList arrayList = new ArrayList(u.Y(P, 10));
            for (String str : P) {
                arrayList.add(new OrderListViewModel$pagers$1$1(str));
            }
            a = e.t.k.a.c.h.d.a(arrayList, this.f4494d);
        } else {
            ArrayList arrayList2 = new ArrayList(u.Y(P, 10));
            for (String str2 : P) {
                arrayList2.add(new OrderListViewModel$pagers$2$1(str2));
            }
            a = e.t.k.a.c.h.d.a(arrayList2, this.f4494d);
        }
        this.f4495e = a;
    }

    @d
    public final c p0() {
        return this.f4495e;
    }

    public final boolean q0() {
        return this.b;
    }
}
