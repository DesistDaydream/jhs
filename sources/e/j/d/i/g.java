package e.j.d.i;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final /* synthetic */ class g implements Executor {
    public static final Executor a = new g();

    private g() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
