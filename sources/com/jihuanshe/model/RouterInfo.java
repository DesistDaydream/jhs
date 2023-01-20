package com.jihuanshe.model;

import java.io.Serializable;
import java.util.Map;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class RouterInfo implements Serializable {
    @d
    private String hostPath = "";
    @e
    private Map<String, String> map;

    @d
    public final String getHostPath() {
        return this.hostPath;
    }

    @e
    public final Map<String, String> getMap() {
        return this.map;
    }

    public final void setHostPath(@d String str) {
        this.hostPath = str;
    }

    public final void setMap(@e Map<String, String> map) {
        this.map = map;
    }
}
