package com.qiniu.android.http.metrics;

import com.qiniu.android.http.request.IUploadRegion;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class UploadRegionRequestMetrics extends UploadMetrics {
    private List<UploadSingleRequestMetrics> metricsList = new CopyOnWriteArrayList();
    public final IUploadRegion region;

    public UploadRegionRequestMetrics(IUploadRegion iUploadRegion) {
        this.region = iUploadRegion;
    }

    public void addMetrics(UploadRegionRequestMetrics uploadRegionRequestMetrics) {
        IUploadRegion iUploadRegion;
        IUploadRegion iUploadRegion2;
        List<UploadSingleRequestMetrics> list;
        if (uploadRegionRequestMetrics == null || (iUploadRegion = uploadRegionRequestMetrics.region) == null || iUploadRegion.getZoneInfo() == null || uploadRegionRequestMetrics.region.getZoneInfo().regionId == null || (iUploadRegion2 = this.region) == null || iUploadRegion2.getZoneInfo() == null || this.region.getZoneInfo().regionId == null || (list = uploadRegionRequestMetrics.metricsList) == null || list.size() == 0 || !uploadRegionRequestMetrics.region.getZoneInfo().getRegionId().equals(uploadRegionRequestMetrics.region.getZoneInfo().getRegionId())) {
            return;
        }
        Date date = this.startDate;
        if (date != null && uploadRegionRequestMetrics.startDate != null && date.getTime() > uploadRegionRequestMetrics.startDate.getTime()) {
            this.startDate = uploadRegionRequestMetrics.startDate;
        }
        Date date2 = this.endDate;
        if (date2 != null && uploadRegionRequestMetrics.endDate != null && date2.getTime() < uploadRegionRequestMetrics.endDate.getTime()) {
            this.endDate = uploadRegionRequestMetrics.endDate;
        }
        addMetricsList(uploadRegionRequestMetrics.metricsList);
    }

    public void addMetricsList(List<UploadSingleRequestMetrics> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (UploadSingleRequestMetrics uploadSingleRequestMetrics : list) {
            if (uploadSingleRequestMetrics != null) {
                this.metricsList.add(uploadSingleRequestMetrics);
            }
        }
    }

    public Long bytesSend() {
        long j2 = 0;
        if (this.metricsList.size() == 0) {
            return 0L;
        }
        for (UploadSingleRequestMetrics uploadSingleRequestMetrics : this.metricsList) {
            if (uploadSingleRequestMetrics != null) {
                j2 += uploadSingleRequestMetrics.bytesSend().longValue();
            }
        }
        return Long.valueOf(j2);
    }

    public UploadSingleRequestMetrics lastMetrics() {
        int size = this.metricsList.size();
        if (size < 1) {
            return null;
        }
        return this.metricsList.get(size - 1);
    }

    public Integer requestCount() {
        return Integer.valueOf(this.metricsList.size());
    }
}
