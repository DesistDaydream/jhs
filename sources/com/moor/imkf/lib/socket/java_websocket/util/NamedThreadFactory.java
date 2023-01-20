package com.moor.imkf.lib.socket.java_websocket.util;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class NamedThreadFactory implements ThreadFactory {
    private final ThreadFactory defaultThreadFactory = Executors.defaultThreadFactory();
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String threadPrefix;

    public NamedThreadFactory(String str) {
        this.threadPrefix = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.defaultThreadFactory.newThread(runnable);
        newThread.setName(this.threadPrefix + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.threadNumber);
        return newThread;
    }
}
