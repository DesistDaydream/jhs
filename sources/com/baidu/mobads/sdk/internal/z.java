package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public class z implements Runnable {
    public final /* synthetic */ y a;

    public z(y yVar) {
        this.a = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a("加载dex超过5秒");
    }
}
