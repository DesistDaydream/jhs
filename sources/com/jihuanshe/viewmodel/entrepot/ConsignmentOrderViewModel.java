package com.jihuanshe.viewmodel.entrepot;

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
public final class ConsignmentOrderViewModel extends b {
    private final int b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f4426c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f4427d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final c f4428e;

    public ConsignmentOrderViewModel(int i2) {
        List<String> P;
        List<String> P2;
        this.b = i2;
        if (i2 == 1) {
            P = CollectionsKt__CollectionsKt.P("waiting_receive", "complete");
        } else {
            P = CollectionsKt__CollectionsKt.P(Constants.STATE_WAITING_PAY, Constants.STATE_PENDING, Constants.STATE_SENT);
        }
        this.f4426c = P;
        if (i2 == 1) {
            Res res = Res.a;
            P2 = CollectionsKt__CollectionsKt.P(Res.w(res, R.string.common_wait, null, 2, null), Res.w(res, R.string.order_state_complete, null, 2, null));
        } else {
            Res res2 = Res.a;
            P2 = CollectionsKt__CollectionsKt.P(Res.w(res2, R.string.order_state_pay, null, 2, null), Res.w(res2, R.string.common_wait_out, null, 2, null), Res.w(res2, R.string.common_out, null, 2, null));
        }
        this.f4427d = P2;
        ArrayList arrayList = new ArrayList(u.Y(P, 10));
        for (String str : P) {
            arrayList.add(new ConsignmentOrderViewModel$pagers$1$1(str, this));
        }
        this.f4428e = e.t.k.a.c.h.d.a(arrayList, this.f4427d);
    }

    @d
    public final c p0() {
        return this.f4428e;
    }

    public final int q0() {
        return this.b;
    }
}
