package com.moor.imkf.lib.jobqueue.messaging.message;

import com.moor.imkf.lib.jobqueue.messaging.Message;
import com.moor.imkf.lib.jobqueue.messaging.Type;

/* loaded from: classes2.dex */
public class ConstraintChangeMessage extends Message {
    private boolean forNextJob;

    public ConstraintChangeMessage() {
        super(Type.CONSTRAINT_CHANGE);
    }

    public boolean isForNextJob() {
        return this.forNextJob;
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.Message
    public void onRecycled() {
        this.forNextJob = false;
    }

    public void setForNextJob(boolean z) {
        this.forNextJob = z;
    }
}
