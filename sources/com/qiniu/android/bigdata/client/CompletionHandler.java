package com.qiniu.android.bigdata.client;

import com.qiniu.android.http.ResponseInfo;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public interface CompletionHandler {
    void complete(ResponseInfo responseInfo, JSONObject jSONObject);
}
