package e.j.a.b.c.n.u;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import e.j.a.b.c.n.a;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class n0 extends u0 {
    private final Map<a.f, m0> b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k0 f10287c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(k0 k0Var, Map<a.f, m0> map) {
        super(k0Var, null);
        this.f10287c = k0Var;
        this.b = map;
    }

    @Override // e.j.a.b.c.n.u.u0
    @GuardedBy("mLock")
    @WorkerThread
    public final void a() {
        e.j.a.b.c.f fVar;
        Context context;
        boolean z;
        Context context2;
        f1 f1Var;
        e.j.a.b.h.f fVar2;
        e.j.a.b.h.f fVar3;
        f1 f1Var2;
        Context context3;
        boolean z2;
        fVar = this.f10287c.f10274d;
        e.j.a.b.c.r.o oVar = new e.j.a.b.c.r.o(fVar);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (a.f fVar4 : this.b.keySet()) {
            if (fVar4.i()) {
                z2 = this.b.get(fVar4).f10286c;
                if (!z2) {
                    arrayList.add(fVar4);
                }
            }
            arrayList2.add(fVar4);
        }
        int i2 = -1;
        int i3 = 0;
        if (arrayList.isEmpty()) {
            int size = arrayList2.size();
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                context3 = this.f10287c.f10273c;
                i2 = oVar.b(context3, (a.f) obj);
                if (i2 == 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList.size();
            while (i3 < size2) {
                Object obj2 = arrayList.get(i3);
                i3++;
                context = this.f10287c.f10273c;
                i2 = oVar.b(context, (a.f) obj2);
                if (i2 != 0) {
                    break;
                }
            }
        }
        if (i2 == 0) {
            z = this.f10287c.f10283m;
            if (z) {
                fVar2 = this.f10287c.f10281k;
                if (fVar2 != null) {
                    fVar3 = this.f10287c.f10281k;
                    fVar3.connect();
                }
            }
            for (a.f fVar5 : this.b.keySet()) {
                m0 m0Var = this.b.get(fVar5);
                if (fVar5.i()) {
                    context2 = this.f10287c.f10273c;
                    if (oVar.b(context2, fVar5) != 0) {
                        f1Var = this.f10287c.a;
                        f1Var.m(new p0(this, this.f10287c, m0Var));
                    }
                }
                fVar5.h(m0Var);
            }
            return;
        }
        ConnectionResult connectionResult = new ConnectionResult(i2, null);
        f1Var2 = this.f10287c.a;
        f1Var2.m(new o0(this, this.f10287c, connectionResult));
    }
}
