package com.jihuanshe.model;

import e.j.e.r.c;
import h.k2.v.u;
import java.util.List;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class Trace {
    @c("traces")
    @e
    private final List<ExpressData> data;

    public Trace() {
        this(null, 1, null);
    }

    public Trace(@e List<ExpressData> list) {
        this.data = list;
    }

    @e
    public final List<ExpressData> getData() {
        return this.data;
    }

    public /* synthetic */ Trace(List list, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : list);
    }
}
