package com.huawei.hms.support.api.client;

import android.os.Bundle;

/* loaded from: classes2.dex */
public class BundleResult {
    private int a;
    private Bundle b;

    public BundleResult(int i2, Bundle bundle) {
        this.a = i2;
        this.b = bundle;
    }

    public int getResultCode() {
        return this.a;
    }

    public Bundle getRspBody() {
        return this.b;
    }

    public void setResultCode(int i2) {
        this.a = i2;
    }

    public void setRspBody(Bundle bundle) {
        this.b = bundle;
    }
}
