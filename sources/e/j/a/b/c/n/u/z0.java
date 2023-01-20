package e.j.a.b.c.n.u;

import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.i;

/* loaded from: classes2.dex */
public final class z0 implements i.c {
    private final /* synthetic */ v a;

    public z0(w0 w0Var, v vVar) {
        this.a = vVar;
    }

    @Override // e.j.a.b.c.n.i.c
    public final void c(@NonNull ConnectionResult connectionResult) {
        this.a.setResult(new Status(8));
    }
}
