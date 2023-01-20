package com.tencent.imsdk.manager;

import com.tencent.imsdk.relationship.UserInfo;

/* loaded from: classes3.dex */
public interface SDKListener {
    void onConnectFailed(int i2, String str);

    void onConnectSuccess();

    void onConnecting();

    void onKickedOffline();

    void onLog(int i2, String str);

    void onSelfInfoUpdated(UserInfo userInfo);

    void onUserSigExpired();
}
