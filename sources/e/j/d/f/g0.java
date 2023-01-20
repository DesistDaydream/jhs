package e.j.d.f;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final /* synthetic */ class g0 implements Executor {
    public static final Executor a = new g0();

    private g0() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
