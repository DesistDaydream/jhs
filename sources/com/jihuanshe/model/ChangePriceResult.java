package com.jihuanshe.model;

import e.j.e.r.c;
import h.k2.v.u;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class ChangePriceResult {
    @c("actual_total_price")
    @e
    private final Float actualPrice;
    @c("handling_fee")
    @e
    private final Float fee;

    public ChangePriceResult() {
        this(null, null, 3, null);
    }

    public ChangePriceResult(@e Float f2, @e Float f3) {
        this.fee = f2;
        this.actualPrice = f3;
    }

    @e
    public final Float getActualPrice() {
        return this.actualPrice;
    }

    @e
    public final Float getFee() {
        return this.fee;
    }

    public /* synthetic */ ChangePriceResult(Float f2, Float f3, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : f2, (i2 & 2) != 0 ? null : f3);
    }
}
