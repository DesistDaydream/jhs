package com.qiniu.android.common;

import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.http.metrics.UploadRegionRequestMetrics;
import com.qiniu.android.storage.UpToken;

/* loaded from: classes3.dex */
public abstract class Zone {

    /* loaded from: classes3.dex */
    public interface QueryHandler {
        void complete(int i2, ResponseInfo responseInfo, UploadRegionRequestMetrics uploadRegionRequestMetrics);
    }

    public abstract ZonesInfo getZonesInfo(UpToken upToken);

    public abstract void preQuery(UpToken upToken, QueryHandler queryHandler);
}
