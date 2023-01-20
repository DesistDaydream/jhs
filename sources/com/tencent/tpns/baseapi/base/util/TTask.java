package com.tencent.tpns.baseapi.base.util;

/* loaded from: classes3.dex */
public abstract class TTask implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public String f6872f;

    public TTask() {
        this("undefined");
    }

    public abstract void TRun();

    @Override // java.lang.Runnable
    public void run() {
        try {
            TRun();
        } catch (Throwable unused) {
        }
    }

    public TTask(String str) {
        this.f6872f = str;
    }
}
