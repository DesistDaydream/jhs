package e.j.a.b.c.n;

import com.google.android.gms.common.api.Status;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.r.d0;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class e implements p {
    private final Status a;
    private final boolean b;

    @e.j.a.b.c.m.a
    @d0
    public e(Status status, boolean z) {
        this.a = (Status) a0.l(status, "Status must not be null");
        this.b = z;
    }

    @e.j.a.b.c.m.a
    public boolean a() {
        return this.b;
    }

    @e.j.a.b.c.m.a
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.a.equals(eVar.a) && this.b == eVar.b;
        }
        return false;
    }

    @Override // e.j.a.b.c.n.p
    @e.j.a.b.c.m.a
    public Status getStatus() {
        return this.a;
    }

    @e.j.a.b.c.m.a
    public final int hashCode() {
        return ((this.a.hashCode() + 527) * 31) + (this.b ? 1 : 0);
    }
}
