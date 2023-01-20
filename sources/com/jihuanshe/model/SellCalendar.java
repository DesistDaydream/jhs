package com.jihuanshe.model;

import h.k2.v.u;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class SellCalendar {
    @e
    private String id;
    @e
    private String time;

    public SellCalendar() {
        this(null, null, 3, null);
    }

    public SellCalendar(@e String str, @e String str2) {
        this.id = str;
        this.time = str2;
    }

    @e
    public final String getId() {
        return this.id;
    }

    @e
    public final String getTime() {
        return this.time;
    }

    public final void setId(@e String str) {
        this.id = str;
    }

    public final void setTime(@e String str) {
        this.time = str;
    }

    public /* synthetic */ SellCalendar(String str, String str2, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }
}
