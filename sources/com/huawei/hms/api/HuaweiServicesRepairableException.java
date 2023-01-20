package com.huawei.hms.api;

import android.content.Intent;

/* loaded from: classes2.dex */
public class HuaweiServicesRepairableException extends UserRecoverableException {
    private final int statusCode;

    public HuaweiServicesRepairableException(int i2, String str, Intent intent) {
        super(str, intent);
        this.statusCode = i2;
    }

    public int getConnectionStatusCode() {
        return this.statusCode;
    }
}
