package com.moor.imkf.lib.jobqueue.messaging.message;

import com.moor.imkf.lib.jobqueue.messaging.Message;
import com.moor.imkf.lib.jobqueue.messaging.Type;

/* loaded from: classes2.dex */
public class JobConsumerIdleMessage extends Message {
    private long lastJobCompleted;
    private Object worker;

    public JobConsumerIdleMessage() {
        super(Type.JOB_CONSUMER_IDLE);
    }

    public long getLastJobCompleted() {
        return this.lastJobCompleted;
    }

    public Object getWorker() {
        return this.worker;
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.Message
    public void onRecycled() {
        this.worker = null;
    }

    public void setLastJobCompleted(long j2) {
        this.lastJobCompleted = j2;
    }

    public void setWorker(Object obj) {
        this.worker = obj;
    }
}
