package e.j.a.b.j;

import com.google.android.gms.tasks.RuntimeExecutionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class d0 implements Runnable {
    private final /* synthetic */ k a;
    private final /* synthetic */ c0 b;

    public d0(c0 c0Var, k kVar) {
        this.b = c0Var;
        this.a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j jVar;
        try {
            jVar = this.b.b;
            k a = jVar.a(this.a.r());
            if (a == null) {
                this.b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = m.b;
            a.l(executor, this.b);
            a.i(executor, this.b);
            a.c(executor, this.b);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                this.b.onFailure((Exception) e2.getCause());
            } else {
                this.b.onFailure(e2);
            }
        } catch (CancellationException unused) {
            this.b.a();
        } catch (Exception e3) {
            this.b.onFailure(e3);
        }
    }
}
