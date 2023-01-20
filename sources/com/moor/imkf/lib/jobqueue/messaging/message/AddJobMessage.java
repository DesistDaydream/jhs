package com.moor.imkf.lib.jobqueue.messaging.message;

import com.moor.imkf.lib.jobqueue.base.Job;
import com.moor.imkf.lib.jobqueue.messaging.Message;
import com.moor.imkf.lib.jobqueue.messaging.Type;

/* loaded from: classes2.dex */
public class AddJobMessage extends Message {
    private Job job;

    public AddJobMessage() {
        super(Type.ADD_JOB);
    }

    public Job getJob() {
        return this.job;
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.Message
    public void onRecycled() {
        this.job = null;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
