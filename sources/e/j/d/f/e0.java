package e.j.d.f;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public final /* synthetic */ class e0 implements ThreadFactory {
    public static final ThreadFactory a = new e0();

    private e0() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return f0.a(runnable);
    }
}
