package com.moor.imkf.lib.jobqueue.messaging.message;

import com.moor.imkf.lib.jobqueue.base.JobHolder;
import com.moor.imkf.lib.jobqueue.messaging.Message;
import com.moor.imkf.lib.jobqueue.messaging.Type;

/* loaded from: classes2.dex */
public class RunJobResultMessage extends Message {
    private JobHolder jobHolder;
    private int result;
    private Object worker;

    public RunJobResultMessage() {
        super(Type.RUN_JOB_RESULT);
    }

    public JobHolder getJobHolder() {
        return this.jobHolder;
    }

    public int getResult() {
        return this.result;
    }

    public Object getWorker() {
        return this.worker;
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.Message
    public void onRecycled() {
        this.jobHolder = null;
    }

    public void setJobHolder(JobHolder jobHolder) {
        this.jobHolder = jobHolder;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public void setWorker(Object obj) {
        this.worker = obj;
    }
}
