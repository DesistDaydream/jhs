package com.moor.imkf.lib.jobqueue.messaging;

import com.moor.imkf.lib.jobqueue.log.JqLog;
import com.moor.imkf.lib.jobqueue.timer.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class PriorityMessageQueue implements MessageQueue {
    private static final String LOG_TAG = "priority_mq";
    private final DelayedMessageBag delayedBag;
    private final MessageFactory factory;
    private final Timer timer;
    private final Object LOCK = new Object();
    private final AtomicBoolean running = new AtomicBoolean(false);
    private boolean postJobTick = false;
    private final UnsafeMessageQueue[] queues = new UnsafeMessageQueue[Type.MAX_PRIORITY + 1];

    public PriorityMessageQueue(Timer timer, MessageFactory messageFactory) {
        this.delayedBag = new DelayedMessageBag(messageFactory);
        this.factory = messageFactory;
        this.timer = timer;
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.MessageQueue
    public void cancelMessages(MessagePredicate messagePredicate) {
        synchronized (this.LOCK) {
            for (int i2 = 0; i2 <= Type.MAX_PRIORITY; i2++) {
                UnsafeMessageQueue unsafeMessageQueue = this.queues[i2];
                if (unsafeMessageQueue != null) {
                    unsafeMessageQueue.removeMessages(messagePredicate);
                }
            }
            this.delayedBag.removeMessages(messagePredicate);
        }
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.MessageQueue
    public void clear() {
        synchronized (this.LOCK) {
            for (int i2 = Type.MAX_PRIORITY; i2 >= 0; i2--) {
                UnsafeMessageQueue unsafeMessageQueue = this.queues[i2];
                if (unsafeMessageQueue != null) {
                    unsafeMessageQueue.clear();
                }
            }
        }
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.MessageQueue
    public void consume(MessageQueueConsumer messageQueueConsumer) {
        if (!this.running.getAndSet(true)) {
            while (this.running.get()) {
                Message next = next(messageQueueConsumer);
                if (next != null) {
                    JqLog.d("[%s] consuming message of type %s", LOG_TAG, next.type);
                    messageQueueConsumer.handleMessage(next);
                    this.factory.release(next);
                }
            }
            return;
        }
        throw new IllegalStateException("only 1 consumer per MQ");
    }

    public Message next(MessageQueueConsumer messageQueueConsumer) {
        long nanoTime;
        Long flushReadyMessages;
        Message next;
        boolean z = false;
        while (this.running.get()) {
            synchronized (this.LOCK) {
                nanoTime = this.timer.nanoTime();
                JqLog.d("[%s] looking for next message at time %s", LOG_TAG, Long.valueOf(nanoTime));
                flushReadyMessages = this.delayedBag.flushReadyMessages(nanoTime, this);
                JqLog.d("[%s] next delayed job %s", LOG_TAG, flushReadyMessages);
                for (int i2 = Type.MAX_PRIORITY; i2 >= 0; i2--) {
                    UnsafeMessageQueue unsafeMessageQueue = this.queues[i2];
                    if (unsafeMessageQueue != null && (next = unsafeMessageQueue.next()) != null) {
                        return next;
                    }
                }
                this.postJobTick = false;
            }
            if (!z) {
                messageQueueConsumer.onIdle();
                z = true;
            }
            synchronized (this.LOCK) {
                JqLog.d("[%s] did on idle post a message? %s", LOG_TAG, Boolean.valueOf(this.postJobTick));
                if (!this.postJobTick) {
                    if (flushReadyMessages == null || flushReadyMessages.longValue() > nanoTime) {
                        if (this.running.get()) {
                            if (flushReadyMessages == null) {
                                try {
                                    this.timer.waitOnObject(this.LOCK);
                                } catch (InterruptedException unused) {
                                }
                            } else {
                                this.timer.waitOnObjectUntilNs(this.LOCK, flushReadyMessages.longValue());
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.MessageQueue
    public void post(Message message) {
        synchronized (this.LOCK) {
            this.postJobTick = true;
            int i2 = message.type.priority;
            UnsafeMessageQueue[] unsafeMessageQueueArr = this.queues;
            if (unsafeMessageQueueArr[i2] == null) {
                MessageFactory messageFactory = this.factory;
                unsafeMessageQueueArr[i2] = new UnsafeMessageQueue(messageFactory, "queue_" + message.type.name());
            }
            this.queues[i2].post(message);
            this.timer.notifyObject(this.LOCK);
        }
    }

    @Override // com.moor.imkf.lib.jobqueue.messaging.MessageQueue
    public void postAt(Message message, long j2) {
        synchronized (this.LOCK) {
            this.postJobTick = true;
            this.delayedBag.add(message, j2);
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
