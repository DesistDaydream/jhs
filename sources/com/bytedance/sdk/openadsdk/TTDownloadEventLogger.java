package com.bytedance.sdk.openadsdk;

import org.json.JSONObject;

/* loaded from: classes.dex */
public interface TTDownloadEventLogger {
    void onDownloadConfigReady();

    void onEvent(JSONObject jSONObject);

    void onV3Event(JSONObject jSONObject);

    boolean shouldFilterOpenSdkLog();
}
