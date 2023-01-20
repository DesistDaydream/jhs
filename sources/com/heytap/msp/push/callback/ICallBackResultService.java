package com.heytap.msp.push.callback;

/* loaded from: classes2.dex */
public interface ICallBackResultService {
    void onError(int i2, String str);

    void onGetNotificationStatus(int i2, int i3);

    void onGetPushStatus(int i2, int i3);

    void onRegister(int i2, String str);

    void onSetPushTime(int i2, String str);

    void onUnRegister(int i2);
}
