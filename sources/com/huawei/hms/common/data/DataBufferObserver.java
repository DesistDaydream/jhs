package com.huawei.hms.common.data;

/* loaded from: classes2.dex */
public interface DataBufferObserver {
    void onDataChanged();

    void onDataRangeChanged(int i2, int i3);

    void onDataRangeInserted(int i2, int i3);

    void onDataRangeMoved(int i2, int i3, int i4);

    void onDataRangeRemoved(int i2, int i3);
}
