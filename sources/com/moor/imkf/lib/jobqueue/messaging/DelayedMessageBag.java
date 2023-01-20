package com.moor.imkf.lib.jobqueue.messaging;

import com.moor.imkf.lib.jobqueue.log.JqLog;

/* loaded from: classes2.dex */
public class DelayedMessageBag {
    public final MessageFactory factory;
    public Message queue = null;

    public DelayedMessageBag(MessageFactory messageFactory) {
        this.factory = messageFactory;
    }

    public void add(Message message, long j2) {
        JqLog.d("add delayed message %s at time %s", message, Long.valueOf(j2));
        message.readyNs = j2;
        Message message2 = this.queue;
        if (message2 == null) {
            this.queue = message;
            return;
        }
        Message message3 = null;
        while (message2 != null && message2.readyNs <= j2) {
            message3 = message2;
            message2 = message2.next;
        }
        if (message3 == null) {
            message.next = this.queue;
            this.queue = message;
            return;
        }
        message3.next = message;
        message.next = message2;
    }

    public void clear() {
        while (true) {
            Message message = this.queue;
            if (message != null) {
                this.queue = message.next;
                this.factory.release(message);
            } else {
                this.queue = null;
                return;
            }
        }
    }

    public Long flushReadyMessages(long j2, MessageQueue messageQueue) {
        Message message;
        JqLog.d("flushing messages at time %s", Long.valueOf(j2));
        while (true) {
            message = this.queue;
            if (message == null || message.readyNs > j2) {
                break;
            }
            this.queue = message.next;
            message.next = null;
            messageQueue.post(message);
        }
        if (message != null) {
            JqLog.d("returning next ready at %d ns", Long.valueOf(message.readyNs - j2));
            return Long.valueOf(this.queue.readyNs);
        }
        return null;
    }

    public void removeMessages(MessagePredicate messagePredicate) {
        Message message = this.queue;
        Message message2 = null;
        while (message != null) {
            boolean onMessage = messagePredicate.onMessage(message);
            Message message3 = message.next;
            if (onMessage) {
                if (message2 == null) {
                    this.queue = message3;
                } else {
                    message2.next = message3;
                }
                this.factory.release(message);
            } else {
                message2 = message;
            }
            message = message3;
        }
    }
}
