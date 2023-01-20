package com.tencent.tpns.baseapi.core.net;

/* loaded from: classes3.dex */
public interface HttpRequestCallback {
    void onFailure(int i2, String str);

    void onSuccess(String str);
}
