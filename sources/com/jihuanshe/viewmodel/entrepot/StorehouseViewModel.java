package com.jihuanshe.viewmodel.entrepot;

import com.jihuanshe.R;
import com.vector.util.Res;
import e.l.h.l.b;
import e.t.k.a.c.h.c;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public final class StorehouseViewModel extends b {
    private final int b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f4440c = CollectionsKt__CollectionsKt.P("FRAGMENT_CHECK", "FRAGMENT_HOUSE", "FRAGMENT_OUT");
    @d

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f4441d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final c f4442e;

    public StorehouseViewModel(int i2) {
        this.b = i2;
        Res res = Res.a;
        List<String> P = CollectionsKt__CollectionsKt.P(Res.w(res, R.string.common_check, null, 2, null), Res.w(res, R.string.common_house, null, 2, null), Res.w(res, R.string.common_out_house, null, 2, null));
        this.f4441d = P;
        this.f4442e = e.t.k.a.c.h.d.h(3, P, Integer.valueOf(i2), new StorehouseViewModel$pagers$1(this));
    }

    public final int q0() {
        return this.b;
    }

    @d
    public final c r0() {
        return this.f4442e;
    }
}
