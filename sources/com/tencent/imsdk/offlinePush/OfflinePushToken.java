package com.tencent.imsdk.offlinePush;

/* loaded from: classes3.dex */
public class OfflinePushToken {
    private int businessID;
    private int deviceBrand;
    private String deviceToken;
    private int isTPNSToken;

    public void setBusinessID(int i2) {
        this.businessID = i2;
    }

    public void setDeviceBrand(int i2) {
        this.deviceBrand = i2;
    }

    public void setDeviceToken(String str) {
        this.deviceToken = str;
    }

    public void setIsTPNSToken(boolean z) {
        this.isTPNSToken = z ? 1 : 0;
    }
}
