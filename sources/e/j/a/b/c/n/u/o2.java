package e.j.a.b.c.n.u;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class o2 implements Runnable {
    private final /* synthetic */ e.j.a.b.c.n.p a;
    private final /* synthetic */ n2 b;

    public o2(n2 n2Var, e.j.a.b.c.n.p pVar) {
        this.b = n2Var;
        this.a = pVar;
    }

    @Override // java.lang.Runnable
    @WorkerThread
    public final void run() {
        p2 p2Var;
        p2 p2Var2;
        WeakReference weakReference;
        WeakReference weakReference2;
        e.j.a.b.c.n.s sVar;
        p2 p2Var3;
        p2 p2Var4;
        WeakReference weakReference3;
        Boolean bool = Boolean.FALSE;
        try {
            try {
                ThreadLocal<Boolean> threadLocal = BasePendingResult.p;
                threadLocal.set(Boolean.TRUE);
                sVar = this.b.a;
                e.j.a.b.c.n.k c2 = sVar.c(this.a);
                p2Var3 = this.b.f10293h;
                p2Var4 = this.b.f10293h;
                p2Var3.sendMessage(p2Var4.obtainMessage(0, c2));
                threadLocal.set(bool);
                n2 n2Var = this.b;
                n2.g(this.a);
                weakReference3 = this.b.f10292g;
                e.j.a.b.c.n.i iVar = (e.j.a.b.c.n.i) weakReference3.get();
                if (iVar != null) {
                    iVar.H(this.b);
                }
            } catch (RuntimeException e2) {
                p2Var = this.b.f10293h;
                p2Var2 = this.b.f10293h;
                p2Var.sendMessage(p2Var2.obtainMessage(1, e2));
                BasePendingResult.p.set(bool);
                n2 n2Var2 = this.b;
                n2.g(this.a);
                weakReference = this.b.f10292g;
                e.j.a.b.c.n.i iVar2 = (e.j.a.b.c.n.i) weakReference.get();
                if (iVar2 != null) {
                    iVar2.H(this.b);
                }
            }
        } catch (Throwable th) {
            BasePendingResult.p.set(bool);
            n2 n2Var3 = this.b;
            n2.g(this.a);
            weakReference2 = this.b.f10292g;
            e.j.a.b.c.n.i iVar3 = (e.j.a.b.c.n.i) weakReference2.get();
            if (iVar3 != null) {
                iVar3.H(this.b);
            }
            throw th;
        }
    }
}
