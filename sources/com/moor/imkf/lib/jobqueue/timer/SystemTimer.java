package com.moor.imkf.lib.jobqueue.timer;

import com.moor.imkf.lib.jobqueue.log.JqLog;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class SystemTimer implements Timer {
    public final long startNs;
    public final long startWallClock;

    public SystemTimer() {
        JqLog.d("creating system timer", new Object[0]);
        this.startWallClock = TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        this.startNs = System.nanoTime();
    }

    @Override // com.moor.imkf.lib.jobqueue.timer.Timer
    public long nanoTime() {
        return (System.nanoTime() - this.startNs) + this.startWallClock;
    }

    @Override // com.moor.imkf.lib.jobqueue.timer.Timer
    public void notifyObject(Object obj) {
        obj.notifyAll();
    }

    @Override // com.moor.imkf.lib.jobqueue.timer.Timer
    public void waitOnObject(Object obj) throws InterruptedException {
        obj.wait();
    }

    @Override // com.moor.imkf.lib.jobqueue.timer.Timer
    public void waitOnObjectUntilNs(Object obj, long j2) throws InterruptedException {
        long nanoTime = nanoTime();
        if (nanoTime > j2) {
            obj.wait(1L);
        } else {
            TimeUnit.NANOSECONDS.timedWait(obj, j2 - nanoTime);
        }
    }
}
