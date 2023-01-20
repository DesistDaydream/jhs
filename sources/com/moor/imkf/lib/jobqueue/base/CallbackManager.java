package com.moor.imkf.lib.jobqueue.base;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.moor.imkf.lib.jobqueue.base.CancelResult;
import com.moor.imkf.lib.jobqueue.callback.JobManagerCallback;
import com.moor.imkf.lib.jobqueue.log.JqLog;
import com.moor.imkf.lib.jobqueue.messaging.Message;
import com.moor.imkf.lib.jobqueue.messaging.MessageFactory;
import com.moor.imkf.lib.jobqueue.messaging.MessageQueueConsumer;
import com.moor.imkf.lib.jobqueue.messaging.SafeMessageQueue;
import com.moor.imkf.lib.jobqueue.messaging.Type;
import com.moor.imkf.lib.jobqueue.messaging.message.CallbackMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.CancelResultMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.CommandMessage;
import com.moor.imkf.lib.jobqueue.messaging.message.PublicQueryMessage;
import com.moor.imkf.lib.jobqueue.timer.Timer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class CallbackManager {
    private final MessageFactory factory;
    public final SafeMessageQueue messageQueue;
    private final Timer timer;
    private final AtomicInteger callbacksSize = new AtomicInteger(0);
    private final AtomicBoolean started = new AtomicBoolean(false);
    private final CopyOnWriteArrayList<JobManagerCallback> callbacks = new CopyOnWriteArrayList<>();

    public CallbackManager(MessageFactory messageFactory, Timer timer) {
        this.timer = timer;
        this.messageQueue = new SafeMessageQueue(timer, messageFactory, "jq_callback");
        this.factory = messageFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deliverCancelResult(@NonNull CancelResultMessage cancelResultMessage) {
        cancelResultMessage.getCallback().onCancelled(cancelResultMessage.getResult());
        startIfNeeded();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deliverMessage(@NonNull CallbackMessage callbackMessage) {
        int what = callbackMessage.getWhat();
        if (what == 1) {
            notifyOnAddedListeners(callbackMessage.getJob());
        } else if (what == 2) {
            notifyOnRunListeners(callbackMessage.getJob(), callbackMessage.getResultCode());
        } else if (what == 3) {
            notifyOnCancelListeners(callbackMessage.getJob(), callbackMessage.isByUserRequest(), callbackMessage.getThrowable());
        } else if (what == 4) {
            notifyOnDoneListeners(callbackMessage.getJob());
        } else if (what != 5) {
        } else {
            notifyAfterRunListeners(callbackMessage.getJob(), callbackMessage.getResultCode());
        }
    }

    private boolean hasAnyCallbacks() {
        return this.callbacksSize.get() > 0;
    }

    private void notifyAfterRunListeners(@NonNull Job job, int i2) {
        Iterator<JobManagerCallback> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().onAfterJobRun(job, i2);
        }
    }

    private void notifyOnAddedListeners(@NonNull Job job) {
        Iterator<JobManagerCallback> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().onJobAdded(job);
        }
    }

    private void notifyOnCancelListeners(@NonNull Job job, boolean z, @Nullable Throwable th) {
        Iterator<JobManagerCallback> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().onJobCancelled(job, z, th);
        }
    }

    private void notifyOnDoneListeners(@NonNull Job job) {
        Iterator<JobManagerCallback> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().onDone(job);
        }
    }

    private void notifyOnRunListeners(@NonNull Job job, int i2) {
        Iterator<JobManagerCallback> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().onJobRun(job, i2);
        }
    }

    private void start() {
        try {
            new Thread(new Runnable() { // from class: com.moor.imkf.lib.jobqueue.base.CallbackManager.2
                @Override // java.lang.Runnable
                public void run() {
                    CallbackManager.this.messageQueue.consume(new MessageQueueConsumer() { // from class: com.moor.imkf.lib.jobqueue.base.CallbackManager.2.1
                        public long lastDelivery = Long.MIN_VALUE;

                        @Override // com.moor.imkf.lib.jobqueue.messaging.MessageQueueConsumer
                        public void handleMessage(Message message) {
                            Type type = message.type;
                            if (type == Type.CALLBACK) {
                                CallbackManager.this.deliverMessage((CallbackMessage) message);
                                this.lastDelivery = CallbackManager.this.timer.nanoTime();
                            } else if (type == Type.CANCEL_RESULT_CALLBACK) {
                                CallbackManager.this.deliverCancelResult((CancelResultMessage) message);
                                this.lastDelivery = CallbackManager.this.timer.nanoTime();
                            } else if (type == Type.COMMAND) {
                                CommandMessage commandMessage = (CommandMessage) message;
                                int what = commandMessage.getWhat();
                                if (what == 1) {
                                    CallbackManager.this.messageQueue.stop();
                                    CallbackManager.this.started.set(false);
                                } else if (what == 3) {
                                    commandMessage.getRunnable().run();
                                }
                            } else if (type == Type.PUBLIC_QUERY) {
                                ((PublicQueryMessage) message).getCallback().onResult(0);
                            }
                        }

                        @Override // com.moor.imkf.lib.jobqueue.messaging.MessageQueueConsumer
                        public void onIdle() {
                        }

                        @Override // com.moor.imkf.lib.jobqueue.messaging.MessageQueueConsumer
                        public void onStart() {
                        }
                    });
                }
            }, "job-manager-callbacks").start();
        } catch (InternalError e2) {
            JqLog.e(e2, "Cannot start a thread. Looks like app is shutting down.See issue #294 for details.", new Object[0]);
        }
    }

    private void startIfNeeded() {
        if (this.started.getAndSet(true)) {
            return;
        }
        start();
    }

    public void addCallback(@NonNull JobManagerCallback jobManagerCallback) {
        this.callbacks.add(jobManagerCallback);
        this.callbacksSize.incrementAndGet();
        startIfNeeded();
    }

    public void destroy() {
        if (this.started.get()) {
            CommandMessage commandMessage = (CommandMessage) this.factory.obtain(CommandMessage.class);
            commandMessage.set(1);
            this.messageQueue.post(commandMessage);
        }
    }

    public void notifyAfterRun(@NonNull Job job, int i2) {
        if (hasAnyCallbacks()) {
            CallbackMessage callbackMessage = (CallbackMessage) this.factory.obtain(CallbackMessage.class);
            callbackMessage.set(job, 5, i2);
            this.messageQueue.post(callbackMessage);
        }
    }

    public void notifyCancelResult(@NonNull CancelResult cancelResult, @NonNull CancelResult.AsyncCancelCallback asyncCancelCallback) {
        CancelResultMessage cancelResultMessage = (CancelResultMessage) this.factory.obtain(CancelResultMessage.class);
        cancelResultMessage.set(asyncCancelCallback, cancelResult);
        this.messageQueue.post(cancelResultMessage);
        startIfNeeded();
    }

    public void notifyOnAdded(@NonNull Job job) {
        if (hasAnyCallbacks()) {
            CallbackMessage callbackMessage = (CallbackMessage) this.factory.obtain(CallbackMessage.class);
            callbackMessage.set(job, 1);
            this.messageQueue.post(callbackMessage);
        }
    }

    public void notifyOnCancel(@NonNull Job job, boolean z, @Nullable Throwable th) {
        if (hasAnyCallbacks()) {
            CallbackMessage callbackMessage = (CallbackMessage) this.factory.obtain(CallbackMessage.class);
            callbackMessage.set(job, 3, z, th);
            this.messageQueue.post(callbackMessage);
        }
    }

    public void notifyOnDone(@NonNull Job job) {
        if (hasAnyCallbacks()) {
            CallbackMessage callbackMessage = (CallbackMessage) this.factory.obtain(CallbackMessage.class);
            callbackMessage.set(job, 4);
            this.messageQueue.post(callbackMessage);
        }
    }

    public void notifyOnRun(@NonNull Job job, int i2) {
        if (hasAnyCallbacks()) {
            CallbackMessage callbackMessage = (CallbackMessage) this.factory.obtain(CallbackMessage.class);
            callbackMessage.set(job, 2, i2);
            this.messageQueue.post(callbackMessage);
        }
    }

    public boolean removeCallback(@NonNull JobManagerCallback jobManagerCallback) {
        boolean remove = this.callbacks.remove(jobManagerCallback);
        if (remove) {
            this.callbacksSize.decrementAndGet();
        }
        return remove;
    }

    @VisibleForTesting
    public boolean waitUntilAllMessagesAreConsumed(int i2) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CommandMessage commandMessage = (CommandMessage) this.factory.obtain(CommandMessage.class);
        commandMessage.set(3);
        commandMessage.setRunnable(new Runnable() { // from class: com.moor.imkf.lib.jobqueue.base.CallbackManager.1
            @Override // java.lang.Runnable
            public void run() {
                countDownLatch.countDown();
            }
        });
        this.messageQueue.post(commandMessage);
        try {
            return countDownLatch.await(i2, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            return false;
        }
    }
}
