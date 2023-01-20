package com.moor.imkf.lib.jobqueue.scheduling;

import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class SchedulerConstraint {
    private Object data;
    private long delayInMs;
    private int networkStatus;
    private Long overrideDeadlineInMs;
    private String uuid;

    public SchedulerConstraint(String str) {
        this.uuid = str;
    }

    public Object getData() {
        return this.data;
    }

    public long getDelayInMs() {
        return this.delayInMs;
    }

    public int getNetworkStatus() {
        return this.networkStatus;
    }

    @Nullable
    public Long getOverrideDeadlineInMs() {
        return this.overrideDeadlineInMs;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setDelayInMs(long j2) {
        this.delayInMs = j2;
    }

    public void setNetworkStatus(int i2) {
        this.networkStatus = i2;
    }

    public void setOverrideDeadlineInMs(Long l2) {
        this.overrideDeadlineInMs = l2;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public String toString() {
        return "SchedulerConstraint{uuid='" + this.uuid + "', delayInMs=" + this.delayInMs + ", networkStatus=" + this.networkStatus + ", overrideDeadlineInMs=" + this.overrideDeadlineInMs + ", data=" + this.data + '}';
    }
}
