package com.moor.imkf.lib.jobqueue.messaging;

/* loaded from: classes2.dex */
public abstract class MessageQueueConsumer {
    public abstract void handleMessage(Message message);

    public abstract void onIdle();

    public void onStart() {
    }
}
