package com.qiniu.android.http.metrics;

import com.qiniu.android.http.request.IUploadRegion;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class UploadTaskMetrics extends UploadMetrics {
    public ArrayList<IUploadRegion> regions;
    private UploadRegionRequestMetrics ucQueryMetrics;
    private String upType;
    private List<String> metricsKeys = new CopyOnWriteArrayList();
    private Map<String, UploadRegionRequestMetrics> metricsInfo = new ConcurrentHashMap();

    public UploadTaskMetrics(String str) {
        this.upType = str;
    }

    public void addMetrics(UploadRegionRequestMetrics uploadRegionRequestMetrics) {
        IUploadRegion iUploadRegion;
        if (uploadRegionRequestMetrics == null || (iUploadRegion = uploadRegionRequestMetrics.region) == null || iUploadRegion.getZoneInfo() == null || uploadRegionRequestMetrics.region.getZoneInfo().regionId == null) {
            return;
        }
        String str = uploadRegionRequestMetrics.region.getZoneInfo().regionId;
        UploadRegionRequestMetrics uploadRegionRequestMetrics2 = this.metricsInfo.get(str);
        if (uploadRegionRequestMetrics2 != null) {
            uploadRegionRequestMetrics2.addMetrics(uploadRegionRequestMetrics);
            return;
        }
        this.metricsKeys.add(str);
        this.metricsInfo.put(str, uploadRegionRequestMetrics);
    }

    public Long bytesSend() {
        long j2 = 0;
        for (String str : this.metricsInfo.keySet()) {
            UploadRegionRequestMetrics uploadRegionRequestMetrics = this.metricsInfo.get(str);
            if (uploadRegionRequestMetrics != null) {
                j2 += uploadRegionRequestMetrics.bytesSend().longValue();
            }
        }
        return Long.valueOf(j2);
    }

    public UploadRegionRequestMetrics getUcQueryMetrics() {
        return this.ucQueryMetrics;
    }

    public String getUpType() {
        return this.upType;
    }

    public UploadRegionRequestMetrics lastMetrics() {
        int size = this.metricsKeys.size();
        if (size < 1) {
            return null;
        }
        return this.metricsInfo.get(this.metricsKeys.get(size - 1));
    }

    public Long regionCount() {
        IUploadRegion iUploadRegion;
        long j2 = 0;
        for (String str : this.metricsInfo.keySet()) {
            UploadRegionRequestMetrics uploadRegionRequestMetrics = this.metricsInfo.get(str);
            if (uploadRegionRequestMetrics != null && (iUploadRegion = uploadRegionRequestMetrics.region) != null && iUploadRegion.getZoneInfo() != null && !uploadRegionRequestMetrics.region.getZoneInfo().regionId.equals("unknown")) {
                j2++;
            }
        }
        return Long.valueOf(j2);
    }

    public Long requestCount() {
        long j2 = 0;
        for (String str : this.metricsInfo.keySet()) {
            UploadRegionRequestMetrics uploadRegionRequestMetrics = this.metricsInfo.get(str);
            if (uploadRegionRequestMetrics != null) {
                j2 += uploadRegionRequestMetrics.requestCount().intValue();
            }
        }
        return Long.valueOf(j2);
    }

    public void setUcQueryMetrics(UploadRegionRequestMetrics uploadRegionRequestMetrics) {
        this.ucQueryMetrics = uploadRegionRequestMetrics;
        addMetrics(uploadRegionRequestMetrics);
    }
}
