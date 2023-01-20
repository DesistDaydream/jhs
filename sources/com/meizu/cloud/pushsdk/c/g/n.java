package com.meizu.cloud.pushsdk.c.g;

import java.io.InterruptedIOException;

/* loaded from: classes2.dex */
public class n {
    public static final n a = new n() { // from class: com.meizu.cloud.pushsdk.c.g.n.1
        @Override // com.meizu.cloud.pushsdk.c.g.n
        public void a() {
        }
    };
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private long f4800c;

    public void a() {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.b && this.f4800c - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
