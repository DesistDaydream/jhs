package e.j.a.b.c.n.u;

import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.u.d;
import e.j.a.b.c.n.u.i;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class t extends i.a {
    @e.j.a.b.c.m.a
    private final d.b<Status> b;

    @e.j.a.b.c.m.a
    public t(d.b<Status> bVar) {
        this.b = bVar;
    }

    @Override // e.j.a.b.c.n.u.i
    @e.j.a.b.c.m.a
    public void n(Status status) {
        this.b.setResult(status);
    }
}
