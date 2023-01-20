package e.j.a.b.c.n.u;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.a.b;
import e.j.a.b.c.n.u.l;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public abstract class p<A extends a.b, L> {
    private final l<L> a;
    private final Feature[] b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f10311c;

    @e.j.a.b.c.m.a
    public p(l<L> lVar) {
        this.a = lVar;
        this.b = null;
        this.f10311c = false;
    }

    @e.j.a.b.c.m.a
    public void a() {
        this.a.a();
    }

    @e.j.a.b.c.m.a
    public l.a<L> b() {
        return this.a.b();
    }

    @Nullable
    @e.j.a.b.c.m.a
    public Feature[] c() {
        return this.b;
    }

    @e.j.a.b.c.m.a
    public abstract void d(A a, e.j.a.b.j.l<Void> lVar) throws RemoteException;

    public final boolean e() {
        return this.f10311c;
    }

    @e.j.a.b.c.m.a
    public p(l<L> lVar, Feature[] featureArr, boolean z) {
        this.a = lVar;
        this.b = featureArr;
        this.f10311c = z;
    }
}
