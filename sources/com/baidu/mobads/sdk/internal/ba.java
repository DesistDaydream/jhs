package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public final class ba implements Runnable {
    public final /* synthetic */ Runnable a;

    public ba(Runnable runnable) {
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.run();
    }
}
