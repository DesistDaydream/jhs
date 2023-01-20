package e.j.a.b.j;

import com.google.android.gms.tasks.RuntimeExecutionException;

/* loaded from: classes2.dex */
public final class r implements Runnable {
    private final /* synthetic */ k a;
    private final /* synthetic */ q b;

    public r(q qVar, k kVar) {
        this.b = qVar;
        this.a = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i0 i0Var;
        i0 i0Var2;
        i0 i0Var3;
        c cVar;
        i0 i0Var4;
        i0 i0Var5;
        if (this.a.t()) {
            i0Var5 = this.b.f10546c;
            i0Var5.B();
            return;
        }
        try {
            cVar = this.b.b;
            Object a = cVar.a(this.a);
            i0Var4 = this.b.f10546c;
            i0Var4.setResult(a);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                i0Var3 = this.b.f10546c;
                i0Var3.y((Exception) e2.getCause());
                return;
            }
            i0Var2 = this.b.f10546c;
            i0Var2.y(e2);
        } catch (Exception e3) {
            i0Var = this.b.f10546c;
            i0Var.y(e3);
        }
    }
}
