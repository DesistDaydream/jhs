package e.j.a.b.c.n.u;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import e.j.a.b.c.n.k;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c0 implements k.a {
    private final /* synthetic */ BasePendingResult a;
    private final /* synthetic */ b0 b;

    public c0(b0 b0Var, BasePendingResult basePendingResult) {
        this.b = b0Var;
        this.a = basePendingResult;
    }

    @Override // e.j.a.b.c.n.k.a
    public final void a(Status status) {
        Map map;
        map = this.b.a;
        map.remove(this.a);
    }
}
