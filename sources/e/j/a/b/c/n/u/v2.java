package e.j.a.b.c.n.u;

import android.os.DeadObjectException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.u.d;
import e.j.a.b.c.n.u.d.a;
import e.j.a.b.c.n.u.g;

/* loaded from: classes2.dex */
public final class v2<A extends d.a<? extends e.j.a.b.c.n.p, a.b>> extends a1 {
    private final A b;

    public v2(int i2, A a) {
        super(i2);
        this.b = a;
    }

    @Override // e.j.a.b.c.n.u.a1
    public final void b(@NonNull Status status) {
        this.b.a(status);
    }

    @Override // e.j.a.b.c.n.u.a1
    public final void c(g.a<?> aVar) throws DeadObjectException {
        try {
            this.b.z(aVar.o());
        } catch (RuntimeException e2) {
            e(e2);
        }
    }

    @Override // e.j.a.b.c.n.u.a1
    public final void d(@NonNull b0 b0Var, boolean z) {
        b0Var.b(this.b, z);
    }

    @Override // e.j.a.b.c.n.u.a1
    public final void e(@NonNull RuntimeException runtimeException) {
        String simpleName = runtimeException.getClass().getSimpleName();
        String localizedMessage = runtimeException.getLocalizedMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 2 + String.valueOf(localizedMessage).length());
        sb.append(simpleName);
        sb.append(": ");
        sb.append(localizedMessage);
        this.b.a(new Status(10, sb.toString()));
    }
}
