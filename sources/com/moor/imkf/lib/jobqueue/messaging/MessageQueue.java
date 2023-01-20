package com.moor.imkf.lib.jobqueue.messaging;

/* loaded from: classes2.dex */
public interface MessageQueue {
    void cancelMessages(MessagePredicate messagePredicate);

    void clear();

    void consume(MessageQueueConsumer messageQueueConsumer);

    void post(Message message);

    void postAt(Message message, long j2);

    void stop();
}
