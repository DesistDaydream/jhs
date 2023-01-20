package com.huawei.hms.framework.common;

/* loaded from: classes2.dex */
public class RunnableEnhance implements Runnable {
    public static final String TRANCELOGO = " -->";
    private String parentName = Thread.currentThread().getName();
    private Runnable proxy;

    public RunnableEnhance(Runnable runnable) {
        this.proxy = runnable;
    }

    public String getParentName() {
        return this.parentName;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.proxy.run();
    }
}
