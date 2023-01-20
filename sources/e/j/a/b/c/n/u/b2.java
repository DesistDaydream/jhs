package e.j.a.b.c.n.u;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.u.q;

/* loaded from: classes2.dex */
public final class b2 extends p<A, L> {

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ q.a f10200d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b2(q.a aVar, l lVar, Feature[] featureArr, boolean z) {
        super(lVar, featureArr, z);
        this.f10200d = aVar;
    }

    /* JADX WARN: Incorrect types in method signature: (TA;Le/j/a/b/j/l<Ljava/lang/Void;>;)V */
    @Override // e.j.a.b.c.n.u.p
    public final void d(a.b bVar, e.j.a.b.j.l lVar) throws RemoteException {
        r rVar;
        rVar = this.f10200d.a;
        rVar.a(bVar, lVar);
    }
}
