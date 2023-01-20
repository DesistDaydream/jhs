package e.j.a.b.c.r;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.i;
import e.j.a.b.c.r.e;
import e.j.a.b.c.r.l;
import java.util.Set;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public abstract class k<T extends IInterface> extends e<T> implements a.f, l.a {
    private final f I;
    private final Set<Scope> J;
    private final Account K;

    @e.j.a.b.c.m.a
    @e.j.a.b.c.x.d0
    public k(Context context, Handler handler, int i2, f fVar) {
        this(context, handler, m.a(context), e.j.a.b.c.e.v(), i2, fVar, (i.b) null, (i.c) null);
    }

    @Nullable
    private static e.a l0(i.b bVar) {
        if (bVar == null) {
            return null;
        }
        return new p0(bVar);
    }

    @Nullable
    private static e.b m0(i.c cVar) {
        if (cVar == null) {
            return null;
        }
        return new q0(cVar);
    }

    private final Set<Scope> n0(@NonNull Set<Scope> set) {
        Set<Scope> k0 = k0(set);
        for (Scope scope : k0) {
            if (!set.contains(scope)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return k0;
    }

    @Override // e.j.a.b.c.r.e
    public final Set<Scope> E() {
        return this.J;
    }

    @Override // e.j.a.b.c.n.a.f
    @e.j.a.b.c.m.a
    public Feature[] a() {
        return new Feature[0];
    }

    @e.j.a.b.c.m.a
    public final f j0() {
        return this.I;
    }

    @NonNull
    @e.j.a.b.c.m.a
    public Set<Scope> k0(@NonNull Set<Scope> set) {
        return set;
    }

    @Override // e.j.a.b.c.r.e, e.j.a.b.c.n.a.f
    public int s() {
        return super.s();
    }

    @Override // e.j.a.b.c.r.e
    public final Account z() {
        return this.K;
    }

    @e.j.a.b.c.m.a
    public k(Context context, Looper looper, int i2, f fVar, i.b bVar, i.c cVar) {
        this(context, looper, m.a(context), e.j.a.b.c.e.v(), i2, fVar, (i.b) a0.k(bVar), (i.c) a0.k(cVar));
    }

    @e.j.a.b.c.m.a
    public k(Context context, Looper looper, int i2, f fVar) {
        this(context, looper, m.a(context), e.j.a.b.c.e.v(), i2, fVar, (i.b) null, (i.c) null);
    }

    @e.j.a.b.c.x.d0
    public k(Context context, Looper looper, m mVar, e.j.a.b.c.e eVar, int i2, f fVar, i.b bVar, i.c cVar) {
        super(context, looper, mVar, eVar, i2, l0(bVar), m0(cVar), fVar.j());
        this.I = fVar;
        this.K = fVar.b();
        this.J = n0(fVar.e());
    }

    @e.j.a.b.c.x.d0
    public k(Context context, Handler handler, m mVar, e.j.a.b.c.e eVar, int i2, f fVar, i.b bVar, i.c cVar) {
        super(context, handler, mVar, eVar, i2, l0(bVar), m0(cVar));
        this.I = (f) a0.k(fVar);
        this.K = fVar.b();
        this.J = n0(fVar.e());
    }
}
