package com.moor.imkf.lib.jobqueue.messaging;

import com.moor.imkf.lib.jobqueue.log.JqLog;
import com.moor.imkf.lib.jobqueue.timer.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class SafeMessageQueue extends UnsafeMessageQueue implements MessageQueue {
    private final Object LOCK;
    private final DelayedMessageBag delayedBag;
    private final MessageFactory factory;
    private boolean postMessageTick;
    private final AtomicBoolean running;
    private final Timer timer;

    public SafeMessageQueue(Timer timer, MessageFactory messageFactory, String str) {
        super(messageFactory, str);
        this.LOCK = new Object();
        this.running = new AtomicBoolean(false);
        this.postMessageTick = false;
        this.factory = messageFactory;
        this.timer = timer;
        this.delayedBag = new DelayedMessageBag(messageFactory);
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.MessageQueue
    public void cancelMessages(MessagePredicate messagePredicate) {
        synchronized (this.LOCK) {
            super.removeMessages(messagePredicate);
            this.delayedBag.removeMessages(messagePredicate);
        }
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.UnsafeMessageQueue, com.moor.imkf.lib.jobqueue.messaging.MessageQueue
    public void clear() {
        synchronized (this.LOCK) {
            super.clear();
        }
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.MessageQueue
    public void consume(MessageQueueConsumer messageQueueConsumer) {
        if (!this.running.getAndSet(true)) {
            messageQueueConsumer.onStart();
            while (this.running.get()) {
                Message next = next(messageQueueConsumer);
                if (next != null) {
                    messageQueueConsumer.handleMessage(next);
                    this.factory.release(next);
                }
            }
            JqLog.d("[%s] finished queue", this.logTag);
            return;
        }
        throw new IllegalStateException("only 1 consumer per MQ");
    }

    public boolean isRunning() {
        return this.running.get();
    }

    public Message next(MessageQueueConsumer messageQueueConsumer) {
        long nanoTime;
        Long flushReadyMessages;
        boolean z = false;
        while (this.running.get()) {
            synchronized (this.LOCK) {
                nanoTime = this.timer.nanoTime();
                flushReadyMessages = this.delayedBag.flushReadyMessages(nanoTime, this);
                Message next = super.next();
                if (next != null) {
                    return next;
                }
                this.postMessageTick = false;
            }
            if (!z) {
                messageQueueConsumer.onIdle();
                z = true;
            }
            synchronized (this.LOCK) {
                if (!this.postMessageTick) {
                    if (flushReadyMessages != null && flushReadyMessages.longValue() <= nanoTime) {
                        JqLog.d("[%s] next message is ready, requery", this.logTag);
                    } else if (this.running.get()) {
                        if (flushReadyMessages == null) {
                            try {
                                JqLog.d("[%s] will wait on the lock forever", this.logTag);
                                this.timer.waitOnObject(this.LOCK);
                            } catch (InterruptedException unused) {
                            }
                        } else {
                            JqLog.d("[%s] will wait on the lock until %d", this.logTag, flushReadyMessages);
                            this.timer.waitOnObjectUntilNs(this.LOCK, flushReadyMessages.longValue());
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.UnsafeMessageQueue, com.moor.imkf.lib.jobqueue.messaging.MessageQueue
    public void post(Message message) {
        synchronized (this.LOCK) {
            this.postMessageTick = true;
            super.post(message);
            this.timer.notifyObject(this.LOCK);
        }
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.MessageQueue
    public void postAt(Message message, long j2) {
        synchronized (this.LOCK) {
            this.postMessageTick = true;
            this.delayedBag.add(message, j2);
            this.timer.notifyObject(this.LOCK);
        }
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.UnsafeMessageQueue
    public void postAtFront(Message message) {
        synchronized (this.LOCK) {
            this.postMessageTick = true;
            super.postAtFront(message);
            this.timer.notifyObject(this.LOCK);
        }
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.MessageQueue
    public void stop() {
        this.running.set(false);
        synchronized (this.LOCK) {
            this.timer.notifyObject(this.LOCK);
        }
    }
}
