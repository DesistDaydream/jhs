package com.qiniu.android.http.request;

import com.qiniu.android.http.ProxyConfiguration;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadSingleRequestMetrics;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class IRequestClient {

    /* loaded from: classes3.dex */
    public interface CompleteHandler {
        void complete(ResponseInfo responseInfo, UploadSingleRequestMetrics uploadSingleRequestMetrics, JSONObject jSONObject);
    }

    /* loaded from: classes3.dex */
    public interface Progress {
        void progress(long j2, long j3);
    }

    public abstract void cancel();

    public abstract void request(Request request, boolean z, ProxyConfiguration proxyConfiguration, Progress progress, CompleteHandler completeHandler);
}
