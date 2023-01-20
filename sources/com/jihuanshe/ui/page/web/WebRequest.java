package com.jihuanshe.ui.page.web;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.Map;
import k.e.a.d;
import k.e.a.e;

@Keep
/* loaded from: classes2.dex */
public final class WebRequest implements Serializable {
    @d
    private String action = "";
    @e
    private Map<String, ? extends Object> data;
    private int eventId;

    @d
    public final String getAction() {
        return this.action;
    }

    @e
    public final Map<String, Object> getData() {
        return this.data;
    }

    public final int getEventId() {
        return this.eventId;
    }

    public final void setAction(@d String str) {
        this.action = str;
    }

    public final void setData(@e Map<String, ? extends Object> map) {
        this.data = map;
    }

    public final void setEventId(int i2) {
        this.eventId = i2;
    }
}
