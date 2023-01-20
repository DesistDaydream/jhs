package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;

/* loaded from: classes2.dex */
public class ResponseHeader implements IMessageEntity {
    @Packed
    public int statusCode;

    public ResponseHeader() {
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public ResponseHeader(int i2) {
        this.statusCode = i2;
    }
}
