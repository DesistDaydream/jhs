package com.moor.imkf.lib.jobqueue.messaging;

/* loaded from: classes2.dex */
public abstract class Message {
    public Message next;
    public long readyNs = Long.MIN_VALUE;
    public final Type type;

    public Message(Type type) {
        this.type = type;
    }

    public abstract void onRecycled();

    public final void recycle() {
        this.next = null;
        this.readyNs = Long.MIN_VALUE;
        onRecycled();
    }
}
