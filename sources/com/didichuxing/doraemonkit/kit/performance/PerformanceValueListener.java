package com.didichuxing.doraemonkit.kit.performance;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/didichuxing/doraemonkit/kit/performance/PerformanceValueListener;", "", "", "value", "Lh/t1;", "onGetMemory", "(F)V", "onGetCPU", "onGetFPS", "dokit-no-op_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface PerformanceValueListener {
    void onGetCPU(float f2);

    void onGetFPS(float f2);

    void onGetMemory(float f2);
}
