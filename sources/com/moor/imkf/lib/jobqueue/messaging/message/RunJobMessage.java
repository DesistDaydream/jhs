package com.moor.imkf.lib.jobqueue.messaging.message;

import com.moor.imkf.lib.jobqueue.base.JobHolder;
import com.moor.imkf.lib.jobqueue.messaging.Message;
import com.moor.imkf.lib.jobqueue.messaging.Type;

/* loaded from: classes2.dex */
public class RunJobMessage extends Message {
    private JobHolder jobHolder;

    public RunJobMessage() {
        super(Type.RUN_JOB);
    }

    public JobHolder getJobHolder() {
        return this.jobHolder;
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.Message
    public void onRecycled() {
        this.jobHolder = null;
    }

    public void setJobHolder(JobHolder jobHolder) {
        this.jobHolder = jobHolder;
    }
}
