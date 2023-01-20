package com.jihuanshe.ui.page.web;

import java.io.Serializable;
import java.util.List;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class WebPermission implements Serializable {
    @e
    private List<String> permissions;
    private int requestCode;

    @e
    public final List<String> getPermissions() {
        return this.permissions;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final void setPermissions(@e List<String> list) {
        this.permissions = list;
    }

    public final void setRequestCode(int i2) {
        this.requestCode = i2;
    }
}
