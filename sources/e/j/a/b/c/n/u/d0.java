package e.j.a.b.c.n.u;

import androidx.annotation.NonNull;
import java.util.Map;

/* loaded from: classes2.dex */
public final class d0 implements e.j.a.b.j.e<TResult> {
    private final /* synthetic */ e.j.a.b.j.l a;
    private final /* synthetic */ b0 b;

    public d0(b0 b0Var, e.j.a.b.j.l lVar) {
        this.b = b0Var;
        this.a = lVar;
    }

    @Override // e.j.a.b.j.e
    public final void onComplete(@NonNull e.j.a.b.j.k<TResult> kVar) {
        Map map;
        map = this.b.b;
        map.remove(this.a);
    }
}
