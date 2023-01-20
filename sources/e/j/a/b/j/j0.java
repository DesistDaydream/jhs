package e.j.a.b.j;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class j0 implements Runnable {
    private final /* synthetic */ i0 a;
    private final /* synthetic */ Callable b;

    public j0(i0 i0Var, Callable callable) {
        this.a = i0Var;
        this.b = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.setResult(this.b.call());
        } catch (Exception e2) {
            this.a.y(e2);
        }
    }
}
