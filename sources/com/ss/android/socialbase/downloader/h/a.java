package com.ss.android.socialbase.downloader.h;

import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class a implements ThreadFactory {
    private final String a;
    private final AtomicInteger b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f5714c;

    public a(String str) {
        this(str, false);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        int incrementAndGet = this.b.incrementAndGet();
        Thread thread = new Thread(runnable, this.a + Constants.ACCEPT_TIME_SEPARATOR_SERVER + incrementAndGet);
        if (!this.f5714c) {
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
        }
        return thread;
    }

    public a(String str, boolean z) {
        this.b = new AtomicInteger();
        this.a = str;
        this.f5714c = z;
    }
}
