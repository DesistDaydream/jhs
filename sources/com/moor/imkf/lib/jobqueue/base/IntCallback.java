package com.moor.imkf.lib.jobqueue.base;

/* loaded from: classes2.dex */
public interface IntCallback {

    /* loaded from: classes2.dex */
    public interface MessageWithCallback {
        void setCallback(IntCallback intCallback);
    }

    void onResult(int i2);
}
