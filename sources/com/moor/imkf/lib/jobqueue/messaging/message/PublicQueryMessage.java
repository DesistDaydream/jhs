package com.moor.imkf.lib.jobqueue.messaging.message;

import com.moor.imkf.lib.jobqueue.base.IntCallback;
import com.moor.imkf.lib.jobqueue.messaging.Message;
import com.moor.imkf.lib.jobqueue.messaging.Type;

/* loaded from: classes2.dex */
public class PublicQueryMessage extends Message implements IntCallback.MessageWithCallback {
    public static final int ACTIVE_CONSUMER_COUNT = 6;
    public static final int CLEAR = 5;
    public static final int COUNT = 0;
    public static final int COUNT_READY = 1;
    public static final int INTERNAL_RUNNABLE = 101;
    public static final int JOB_STATUS = 4;
    public static final int SCHEDULER_START = 7;
    public static final int START = 2;
    public static final int STOP = 3;
    private IntCallback callback;
    private String stringArg;
    private int what;

    public PublicQueryMessage() {
        super(Type.PUBLIC_QUERY);
        this.what = -1;
    }

    public IntCallback getCallback() {
        return this.callback;
    }

    public String getStringArg() {
        return this.stringArg;
    }

    public int getWhat() {
        return this.what;
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.Message
    public void onRecycled() {
        this.callback = null;
        this.what = -1;
    }

    public void set(int i2, IntCallback intCallback) {
        this.callback = intCallback;
        this.what = i2;
    }

    @Override // com.moor.imkf.lib.jobqueue.base.IntCallback.MessageWithCallback
    public void setCallback(IntCallback intCallback) {
        this.callback = intCallback;
    }

    public String toString() {
        return "PublicQuery[" + this.what + "]";
    }

    public void set(int i2, String str, IntCallback intCallback) {
        this.what = i2;
        this.stringArg = str;
        this.callback = intCallback;
    }
}
