package com.jihuanshe.model;

import e.j.e.r.c;
import h.k2.v.u;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class ExpressData {
    @c("AcceptStation")
    @e
    private final String section;
    @c("AcceptTime")
    @e
    private final String time;

    public ExpressData() {
        this(null, null, 3, null);
    }

    public ExpressData(@e String str, @e String str2) {
        this.time = str;
        this.section = str2;
    }

    @e
    public final String getSection() {
        return this.section;
    }

    @e
    public final String getTime() {
        return this.time;
    }

    public /* synthetic */ ExpressData(String str, String str2, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }
}
