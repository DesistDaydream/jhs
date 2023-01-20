package com.qiniu.android.http.metrics;

import com.qiniu.android.utils.Utils;
import java.util.Date;

/* loaded from: classes3.dex */
public class UploadMetrics {
    public Date startDate = null;
    public Date endDate = null;

    public void end() {
        this.endDate = new Date();
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void start() {
        this.startDate = new Date();
    }

    public long totalElapsedTime() {
        Date date;
        Date date2 = this.startDate;
        if (date2 == null || (date = this.endDate) == null) {
            return 0L;
        }
        return Utils.dateDuration(date2, date);
    }
}
