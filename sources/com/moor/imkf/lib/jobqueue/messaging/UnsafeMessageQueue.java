package com.moor.imkf.lib.jobqueue.messaging;

import com.moor.imkf.lib.jobqueue.log.JqLog;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class UnsafeMessageQueue {
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    private final MessageFactory factory;
    public final String logTag;
    private Message queue = null;
    private Message tail = null;

    public UnsafeMessageQueue(MessageFactory messageFactory, String str) {
        this.factory = messageFactory;
        this.logTag = str + "_" + idCounter.incrementAndGet();
    }

    private void remove(Message message, Message message2) {
        if (this.tail == message2) {
            this.tail = message;
        }
        if (message == null) {
            this.queue = message2.next;
        } else {
            message.next = message2.next;
        }
        this.factory.release(message2);
    }

    public void clear() {
        while (true) {
            Message message = this.queue;
            if (message != null) {
                this.queue = message.next;
                this.factory.release(message);
            } else {
                this.tail = null;
                return;
            }
        }
    }

    public Message next() {
        Message message = this.queue;
        JqLog.d("[%s] remove message %s", this.logTag, message);
        if (message != null) {
            this.queue = message.next;
            if (this.tail == message) {
                this.tail = null;
            }
        }
        return message;
    }

    public void post(Message message) {
        JqLog.d("[%s] post message %s", this.logTag, message);
        Message message2 = this.tail;
        if (message2 == null) {
            this.queue = message;
            this.tail = message;
            return;
        }
        message2.next = message;
        this.tail = message;
    }

    public void postAtFront(Message message) {
        message.next = this.queue;
        if (this.tail == null) {
            this.tail = message;
        }
        this.queue = message;
    }

    public void removeMessages(MessagePredicate messagePredicate) {
        Message message = this.queue;
        Message message2 = null;
        while (message != null) {
            if (messagePredicate.onMessage(message)) {
                Message message3 = message.next;
                remove(message2, message);
                message = message3;
            } else {
                message2 = message;
                message = message.next;
            }
        }
    }
}
