package e.j.a.b.c.n.u;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.u.d;

/* loaded from: classes2.dex */
public interface e1 {
    void a(Bundle bundle);

    void b(ConnectionResult connectionResult, e.j.a.b.c.n.a<?> aVar, boolean z);

    <A extends a.b, T extends d.a<? extends e.j.a.b.c.n.p, A>> T c(T t);

    void connect();

    void d();

    boolean disconnect();

    <A extends a.b, R extends e.j.a.b.c.n.p, T extends d.a<R, A>> T e(T t);

    void onConnectionSuspended(int i2);
}
