package com.tencent.imsdk.message;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class DownloadProgressInfo implements Serializable {
    private long currentSize;
    private long totalSize;

    public DownloadProgressInfo(long j2, long j3) {
        this.currentSize = j2;
        this.totalSize = j3;
    }

    public long getCurrentSize() {
        return this.currentSize;
    }

    public long getTotalSize() {
        return this.totalSize;
    }
}
