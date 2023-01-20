package e.j.a.b.c.n.u;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.u.g;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public final class p1 implements Runnable {
    private final /* synthetic */ ConnectionResult a;
    private final /* synthetic */ g.c b;

    public p1(g.c cVar, ConnectionResult connectionResult) {
        this.b = cVar;
        this.a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z2 z2Var;
        a.f fVar;
        z2 z2Var2;
        a.f fVar2;
        if (this.a.isSuccess()) {
            this.b.f10254e = true;
            fVar = this.b.a;
            if (fVar.j()) {
                this.b.g();
                return;
            }
            try {
                fVar2 = this.b.a;
                fVar2.m(null, Collections.emptySet());
                return;
            } catch (SecurityException e2) {
                Log.e("GoogleApiManager", "Failed to get service from broker. ", e2);
                Map map = g.this.f10236i;
                z2Var2 = this.b.b;
                ((g.a) map.get(z2Var2)).c(new ConnectionResult(10));
                return;
            }
        }
        Map map2 = g.this.f10236i;
        z2Var = this.b.b;
        ((g.a) map2.get(z2Var)).c(this.a);
    }
}
