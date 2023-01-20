package com.moor.imkf.lib.jobqueue.timer;

/* loaded from: classes2.dex */
public interface Timer {
    long nanoTime();

    void notifyObject(Object obj);

    void waitOnObject(Object obj) throws InterruptedException;

    void waitOnObjectUntilNs(Object obj, long j2) throws InterruptedException;
}
