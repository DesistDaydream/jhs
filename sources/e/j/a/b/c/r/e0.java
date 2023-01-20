package e.j.a.b.c.r;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.i;

/* loaded from: classes2.dex */
public class e0<T extends IInterface> extends k<T> {
    private final a.h<T> L;

    public e0(Context context, Looper looper, int i2, i.b bVar, i.c cVar, f fVar, a.h<T> hVar) {
        super(context, looper, i2, fVar, bVar, cVar);
        this.L = hVar;
    }

    @Override // e.j.a.b.c.r.e
    public void L(int i2, T t) {
        this.L.o(i2, t);
    }

    @Override // e.j.a.b.c.r.e
    public String c() {
        return this.L.c();
    }

    public a.h<T> o0() {
        return this.L;
    }

    @Override // e.j.a.b.c.r.e
    public String q() {
        return this.L.q();
    }

    @Override // e.j.a.b.c.r.e
    public T r(IBinder iBinder) {
        return this.L.r(iBinder);
    }

    @Override // e.j.a.b.c.r.k, e.j.a.b.c.r.e, e.j.a.b.c.n.a.f
    public int s() {
        return super.s();
    }
}
