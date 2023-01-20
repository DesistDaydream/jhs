package com.moor.imkf.lib.jobqueue.messaging.message;

import androidx.annotation.Nullable;
import com.moor.imkf.lib.jobqueue.base.Job;
import com.moor.imkf.lib.jobqueue.messaging.Message;
import com.moor.imkf.lib.jobqueue.messaging.Type;

/* loaded from: classes2.dex */
public class CallbackMessage extends Message {
    public static final int ON_ADDED = 1;
    public static final int ON_AFTER_RUN = 5;
    public static final int ON_CANCEL = 3;
    public static final int ON_DONE = 4;
    public static final int ON_RUN = 2;
    private boolean byUserRequest;
    private Job job;
    private int resultCode;
    @Nullable
    private Throwable throwable;
    private int what;

    public CallbackMessage() {
        super(Type.CALLBACK);
    }

    public Job getJob() {
        return this.job;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    @Nullable
    public Throwable getThrowable() {
        return this.throwable;
    }

    public int getWhat() {
        return this.what;
    }

    public boolean isByUserRequest() {
        return this.byUserRequest;
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.Message
    public void onRecycled() {
        this.job = null;
        this.throwable = null;
    }

    public void set(Job job, int i2) {
        this.what = i2;
        this.job = job;
    }

    public void set(Job job, int i2, int i3) {
        this.what = i2;
        this.resultCode = i3;
        this.job = job;
    }

    public void set(Job job, int i2, boolean z, @Nullable Throwable th) {
        this.what = i2;
        this.byUserRequest = z;
        this.job = job;
        this.throwable = th;
    }
}
