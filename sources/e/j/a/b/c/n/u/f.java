package e.j.a.b.c.n.u;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class f implements e.j.a.b.c.n.m, e.j.a.b.c.n.p {
    @e.j.a.b.c.m.a
    public final Status a;
    @e.j.a.b.c.m.a
    public final DataHolder b;

    @e.j.a.b.c.m.a
    public f(DataHolder dataHolder) {
        this(dataHolder, new Status(dataHolder.getStatusCode()));
    }

    @Override // e.j.a.b.c.n.p
    @e.j.a.b.c.m.a
    public Status getStatus() {
        return this.a;
    }

    @Override // e.j.a.b.c.n.m
    @e.j.a.b.c.m.a
    public void release() {
        DataHolder dataHolder = this.b;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    @e.j.a.b.c.m.a
    public f(DataHolder dataHolder, Status status) {
        this.a = status;
        this.b = dataHolder;
    }
}
