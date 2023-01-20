package e.j.a.b.c.n.u;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.a.d;
import e.j.a.b.c.n.u.g;

/* loaded from: classes2.dex */
public final class n3<O extends a.d> extends e.j.a.b.c.n.h<O> {

    /* renamed from: j  reason: collision with root package name */
    private final a.f f10295j;

    /* renamed from: k  reason: collision with root package name */
    private final h3 f10296k;

    /* renamed from: l  reason: collision with root package name */
    private final e.j.a.b.c.r.f f10297l;

    /* renamed from: m  reason: collision with root package name */
    private final a.AbstractC0333a<? extends e.j.a.b.h.f, e.j.a.b.h.a> f10298m;

    public n3(@NonNull Context context, e.j.a.b.c.n.a<O> aVar, Looper looper, @NonNull a.f fVar, @NonNull h3 h3Var, e.j.a.b.c.r.f fVar2, a.AbstractC0333a<? extends e.j.a.b.h.f, e.j.a.b.h.a> abstractC0333a) {
        super(context, aVar, looper);
        this.f10295j = fVar;
        this.f10296k = h3Var;
        this.f10297l = fVar2;
        this.f10298m = abstractC0333a;
        this.f10180i.i(this);
    }

    @Override // e.j.a.b.c.n.h
    public final a.f s(Looper looper, g.a<O> aVar) {
        this.f10296k.d(aVar);
        return this.f10295j;
    }

    @Override // e.j.a.b.c.n.h
    public final f2 u(Context context, Handler handler) {
        return new f2(context, handler, this.f10297l, this.f10298m);
    }

    public final a.f x() {
        return this.f10295j;
    }
}
