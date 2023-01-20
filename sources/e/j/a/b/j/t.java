package e.j.a.b.j;

import com.google.android.gms.tasks.RuntimeExecutionException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class t implements Runnable {
    private final /* synthetic */ k a;
    private final /* synthetic */ s b;

    public t(s sVar, k kVar) {
        this.b = sVar;
        this.a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i0 i0Var;
        i0 i0Var2;
        i0 i0Var3;
        c cVar;
        try {
            cVar = this.b.b;
            k kVar = (k) cVar.a(this.a);
            if (kVar == null) {
                this.b.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = m.b;
            kVar.l(executor, this.b);
            kVar.i(executor, this.b);
            kVar.c(executor, this.b);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                i0Var3 = this.b.f10547c;
                i0Var3.y((Exception) e2.getCause());
                return;
            }
            i0Var2 = this.b.f10547c;
            i0Var2.y(e2);
        } catch (Exception e3) {
            i0Var = this.b.f10547c;
            i0Var.y(e3);
        }
    }
}
