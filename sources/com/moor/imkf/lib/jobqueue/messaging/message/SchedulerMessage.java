package com.moor.imkf.lib.jobqueue.messaging.message;

import androidx.annotation.NonNull;
import com.moor.imkf.lib.jobqueue.messaging.Message;
import com.moor.imkf.lib.jobqueue.messaging.Type;
import com.moor.imkf.lib.jobqueue.scheduling.SchedulerConstraint;

/* loaded from: classes2.dex */
public class SchedulerMessage extends Message {
    public static final int START = 1;
    public static final int STOP = 2;
    @NonNull
    private SchedulerConstraint constraint;
    private int what;

    public SchedulerMessage() {
        super(Type.SCHEDULER);
    }

    @NonNull
    public SchedulerConstraint getConstraint() {
        return this.constraint;
    }

    public int getWhat() {
        return this.what;
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.Message
    public void onRecycled() {
        this.constraint = null;
    }

    public void set(int i2, @NonNull SchedulerConstraint schedulerConstraint) {
        this.what = i2;
        this.constraint = schedulerConstraint;
    }
}
