package com.moor.imkf.lib.jobqueue.messaging.message;

import com.moor.imkf.lib.jobqueue.messaging.Message;
import com.moor.imkf.lib.jobqueue.messaging.Type;

/* loaded from: classes2.dex */
public class CommandMessage extends Message {
    public static final int POKE = 2;
    public static final int QUIT = 1;
    public static final int RUNNABLE = 3;
    private Runnable runnable;
    private int what;

    public CommandMessage() {
        super(Type.COMMAND);
    }

    public Runnable getRunnable() {
        return this.runnable;
    }

    public int getWhat() {
        return this.what;
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.Message
    public void onRecycled() {
        this.what = -1;
        this.runnable = null;
    }

    public void set(int i2) {
        this.what = i2;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    public String toString() {
        return "Command[" + this.what + "]";
    }
}
