package e.j.a.b.c.n.u;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.u.w;

/* loaded from: classes2.dex */
public final class l2 extends w<A, ResultT> {

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ w.a f10285c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l2(w.a aVar, Feature[] featureArr, boolean z) {
        super(featureArr, z);
        this.f10285c = aVar;
    }

    /* JADX WARN: Incorrect types in method signature: (TA;Le/j/a/b/j/l<TResultT;>;)V */
    @Override // e.j.a.b.c.n.u.w
    public final void b(a.b bVar, e.j.a.b.j.l lVar) throws RemoteException {
        r rVar;
        rVar = this.f10285c.a;
        rVar.a(bVar, lVar);
    }
}
