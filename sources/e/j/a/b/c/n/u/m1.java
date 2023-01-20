package e.j.a.b.c.n.u;

import com.google.android.gms.common.ConnectionResult;
import e.j.a.b.c.n.u.g;

/* loaded from: classes2.dex */
public final class m1 implements Runnable {
    private final /* synthetic */ ConnectionResult a;
    private final /* synthetic */ g.a b;

    public m1(g.a aVar, ConnectionResult connectionResult) {
        this.b = aVar;
        this.a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.c(this.a);
    }
}
