package e.j.a.b.c.r;

import android.content.Context;
import android.os.IInterface;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import e.j.a.b.c.n.i;

@Deprecated
/* loaded from: classes2.dex */
public abstract class w<T extends IInterface> extends k<T> {
    private final l L;

    public w(Context context, int i2, f fVar, i.b bVar, i.c cVar) {
        super(context, context.getMainLooper(), i2, fVar);
        l lVar = new l(context.getMainLooper(), this);
        this.L = lVar;
        lVar.j(bVar);
        lVar.k(cVar);
    }

    @Override // e.j.a.b.c.r.e
    public void H(@NonNull T t) {
        super.H(t);
        this.L.h(l());
    }

    @Override // e.j.a.b.c.r.e
    public void I(ConnectionResult connectionResult) {
        super.I(connectionResult);
        this.L.f(connectionResult);
    }

    @Override // e.j.a.b.c.r.e
    public void J(int i2) {
        super.J(i2);
        this.L.i(i2);
    }

    @Override // e.j.a.b.c.r.e, e.j.a.b.c.n.a.f
    public void disconnect() {
        this.L.b();
        super.disconnect();
    }

    public boolean o0(i.b bVar) {
        return this.L.d(bVar);
    }

    public boolean p0(i.c cVar) {
        return this.L.e(cVar);
    }

    public void q0(i.b bVar) {
        this.L.j(bVar);
    }

    public void r0(i.c cVar) {
        this.L.k(cVar);
    }

    @Override // e.j.a.b.c.r.k, e.j.a.b.c.r.e, e.j.a.b.c.n.a.f
    public int s() {
        return super.s();
    }

    public void s0(i.b bVar) {
        this.L.l(bVar);
    }

    public void t0(i.c cVar) {
        this.L.m(cVar);
    }

    @Override // e.j.a.b.c.r.e
    public void w() {
        this.L.c();
        super.w();
    }
}
