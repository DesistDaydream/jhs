package com.tencent.imsdk.v2;

import com.tencent.imsdk.offlinePush.OfflinePushToken;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class V2TIMOfflinePushConfig implements Serializable {
    private OfflinePushToken offlinePushToken;

    public V2TIMOfflinePushConfig(long j2, String str, boolean z) {
        OfflinePushToken offlinePushToken = new OfflinePushToken();
        this.offlinePushToken = offlinePushToken;
        offlinePushToken.setBusinessID((int) j2);
        this.offlinePushToken.setDeviceToken(str);
        this.offlinePushToken.setIsTPNSToken(z);
    }

    public OfflinePushToken getOfflinePushToken() {
        return this.offlinePushToken;
    }

    @Deprecated
    public V2TIMOfflinePushConfig(long j2, String str) {
        OfflinePushToken offlinePushToken = new OfflinePushToken();
        this.offlinePushToken = offlinePushToken;
        offlinePushToken.setBusinessID((int) j2);
        this.offlinePushToken.setDeviceToken(str);
        this.offlinePushToken.setIsTPNSToken(false);
    }
}
