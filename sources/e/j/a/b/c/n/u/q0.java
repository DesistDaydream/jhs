package e.j.a.b.c.n.u;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Scope;
import e.j.a.b.c.n.a;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes2.dex */
public final class q0 extends u0 {
    private final ArrayList<a.f> b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ k0 f10315c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(k0 k0Var, ArrayList<a.f> arrayList) {
        super(k0Var, null);
        this.f10315c = k0Var;
        this.b = arrayList;
    }

    @Override // e.j.a.b.c.n.u.u0
    @WorkerThread
    public final void a() {
        f1 f1Var;
        Set<Scope> q;
        e.j.a.b.c.r.q qVar;
        f1 f1Var2;
        f1Var = this.f10315c.a;
        w0 w0Var = f1Var.n;
        q = this.f10315c.q();
        w0Var.t = q;
        ArrayList<a.f> arrayList = this.b;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            a.f fVar = arrayList.get(i2);
            i2++;
            qVar = this.f10315c.o;
            f1Var2 = this.f10315c.a;
            fVar.m(qVar, f1Var2.n.t);
        }
    }
}
