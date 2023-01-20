package com.qq.e.mediation.interfaces;

import java.util.Map;

/* loaded from: classes3.dex */
public interface IBaseAd {
    int getECPM();

    Map<String, Object> getExtraInfo();

    String getReqId();

    void sendLossNotification(int i2, int i3, String str);

    void sendWinNotification(int i2);

    void setBidECPM(int i2);
}
