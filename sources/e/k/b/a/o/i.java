package e.k.b.a.o;

import android.app.Activity;
import e.k.b.a.k;
import e.k.b.a.m;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class i<TResult> extends k<TResult> {
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f11805c;

    /* renamed from: d  reason: collision with root package name */
    private TResult f11806d;

    /* renamed from: e  reason: collision with root package name */
    private Exception f11807e;
    private final Object a = new Object();

    /* renamed from: f  reason: collision with root package name */
    private List<e.k.b.a.e<TResult>> f11808f = new ArrayList();

    /* loaded from: classes2.dex */
    public class a implements e.k.b.a.i<TResult> {
        public final /* synthetic */ e.k.b.a.j a;
        public final /* synthetic */ i b;

        /* renamed from: e.k.b.a.o.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0384a implements e.k.b.a.g<TContinuationResult> {
            public C0384a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // e.k.b.a.g
            public final void onComplete(k<TContinuationResult> kVar) {
                if (kVar.v()) {
                    a.this.b.A(kVar.r());
                } else if (kVar.t()) {
                    a.this.b.B();
                } else {
                    a.this.b.z(kVar.q());
                }
            }
        }

        public a(e.k.b.a.j jVar, i iVar) {
            this.a = jVar;
            this.b = iVar;
        }

        @Override // e.k.b.a.i
        public final void onSuccess(TResult tresult) {
            try {
                k a = this.a.a(tresult);
                if (a == null) {
                    this.b.z(new NullPointerException("SuccessContinuation returned null"));
                } else {
                    a.e(new C0384a());
                }
            } catch (Exception e2) {
                this.b.z(e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements e.k.b.a.h {
        public final /* synthetic */ i a;

        public b(i iVar) {
            this.a = iVar;
        }

        @Override // e.k.b.a.h
        public final void onFailure(Exception exc) {
            this.a.z(exc);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements e.k.b.a.f {
        public final /* synthetic */ i a;

        public c(i iVar) {
            this.a = iVar;
        }

        @Override // e.k.b.a.f
        public final void a() {
            this.a.B();
        }
    }

    /* loaded from: classes2.dex */
    public class d implements e.k.b.a.g<TResult> {
        public final /* synthetic */ e.k.b.a.d a;
        public final /* synthetic */ i b;

        /* loaded from: classes2.dex */
        public class a implements e.k.b.a.g<TContinuationResult> {
            public a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // e.k.b.a.g
            public final void onComplete(k<TContinuationResult> kVar) {
                if (kVar.v()) {
                    d.this.b.A(kVar.r());
                } else if (kVar.t()) {
                    d.this.b.B();
                } else {
                    d.this.b.z(kVar.q());
                }
            }
        }

        public d(e.k.b.a.d dVar, i iVar) {
            this.a = dVar;
            this.b = iVar;
        }

        @Override // e.k.b.a.g
        public final void onComplete(k<TResult> kVar) {
            try {
                k kVar2 = (k) this.a.a(kVar);
                if (kVar2 == null) {
                    this.b.z(new NullPointerException("Continuation returned null"));
                } else {
                    kVar2.e(new a());
                }
            } catch (Exception e2) {
                this.b.z(e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements e.k.b.a.g<TResult> {
        public final /* synthetic */ i a;
        public final /* synthetic */ e.k.b.a.d b;

        public e(i iVar, e.k.b.a.d dVar) {
            this.a = iVar;
            this.b = dVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // e.k.b.a.g
        public final void onComplete(k<TResult> kVar) {
            if (kVar.t()) {
                this.a.B();
                return;
            }
            try {
                this.a.A(this.b.a(kVar));
            } catch (Exception e2) {
                this.a.z(e2);
            }
        }
    }

    private void C() {
        synchronized (this.a) {
            for (e.k.b.a.e<TResult> eVar : this.f11808f) {
                try {
                    eVar.onComplete(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f11808f = null;
        }
    }

    private k<TResult> y(e.k.b.a.e<TResult> eVar) {
        boolean u;
        synchronized (this.a) {
            u = u();
            if (!u) {
                this.f11808f.add(eVar);
            }
        }
        if (u) {
            eVar.onComplete(this);
        }
        return this;
    }

    public final void A(TResult tresult) {
        synchronized (this.a) {
            if (this.b) {
                return;
            }
            this.b = true;
            this.f11806d = tresult;
            this.a.notifyAll();
            C();
        }
    }

    public final boolean B() {
        synchronized (this.a) {
            if (this.b) {
                return false;
            }
            this.b = true;
            this.f11805c = true;
            this.a.notifyAll();
            C();
            return true;
        }
    }

    @Override // e.k.b.a.k
    public final k<TResult> a(Activity activity, e.k.b.a.f fVar) {
        e.k.b.a.o.b bVar = new e.k.b.a.o.b(m.c(), fVar);
        g.c(activity, bVar);
        return y(bVar);
    }

    @Override // e.k.b.a.k
    public final k<TResult> b(e.k.b.a.f fVar) {
        return c(m.c(), fVar);
    }

    @Override // e.k.b.a.k
    public final k<TResult> c(Executor executor, e.k.b.a.f fVar) {
        return y(new e.k.b.a.o.b(executor, fVar));
    }

    @Override // e.k.b.a.k
    public final k<TResult> d(Activity activity, e.k.b.a.g<TResult> gVar) {
        e.k.b.a.o.d dVar = new e.k.b.a.o.d(m.c(), gVar);
        g.c(activity, dVar);
        return y(dVar);
    }

    @Override // e.k.b.a.k
    public final k<TResult> e(e.k.b.a.g<TResult> gVar) {
        return f(m.c(), gVar);
    }

    @Override // e.k.b.a.k
    public final k<TResult> f(Executor executor, e.k.b.a.g<TResult> gVar) {
        return y(new e.k.b.a.o.d(executor, gVar));
    }

    @Override // e.k.b.a.k
    public final k<TResult> g(Activity activity, e.k.b.a.h hVar) {
        f fVar = new f(m.c(), hVar);
        g.c(activity, fVar);
        return y(fVar);
    }

    @Override // e.k.b.a.k
    public final k<TResult> h(e.k.b.a.h hVar) {
        return i(m.c(), hVar);
    }

    @Override // e.k.b.a.k
    public final k<TResult> i(Executor executor, e.k.b.a.h hVar) {
        return y(new f(executor, hVar));
    }

    @Override // e.k.b.a.k
    public final k<TResult> j(Activity activity, e.k.b.a.i<TResult> iVar) {
        h hVar = new h(m.c(), iVar);
        g.c(activity, hVar);
        return y(hVar);
    }

    @Override // e.k.b.a.k
    public final k<TResult> k(e.k.b.a.i<TResult> iVar) {
        return l(m.c(), iVar);
    }

    @Override // e.k.b.a.k
    public final k<TResult> l(Executor executor, e.k.b.a.i<TResult> iVar) {
        return y(new h(executor, iVar));
    }

    @Override // e.k.b.a.k
    public final <TContinuationResult> k<TContinuationResult> m(e.k.b.a.d<TResult, TContinuationResult> dVar) {
        return n(m.c(), dVar);
    }

    @Override // e.k.b.a.k
    public final <TContinuationResult> k<TContinuationResult> n(Executor executor, e.k.b.a.d<TResult, TContinuationResult> dVar) {
        i iVar = new i();
        f(executor, new e(iVar, dVar));
        return iVar;
    }

    @Override // e.k.b.a.k
    public final <TContinuationResult> k<TContinuationResult> o(e.k.b.a.d<TResult, k<TContinuationResult>> dVar) {
        return p(m.c(), dVar);
    }

    @Override // e.k.b.a.k
    public final <TContinuationResult> k<TContinuationResult> p(Executor executor, e.k.b.a.d<TResult, k<TContinuationResult>> dVar) {
        i iVar = new i();
        f(executor, new d(dVar, iVar));
        return iVar;
    }

    @Override // e.k.b.a.k
    public final Exception q() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f11807e;
        }
        return exc;
    }

    @Override // e.k.b.a.k
    public final TResult r() {
        TResult tresult;
        synchronized (this.a) {
            if (this.f11807e != null) {
                throw new RuntimeException(this.f11807e);
            }
            tresult = this.f11806d;
        }
        return tresult;
    }

    @Override // e.k.b.a.k
    public final <E extends Throwable> TResult s(Class<E> cls) throws Throwable {
        TResult tresult;
        synchronized (this.a) {
            if (cls != null) {
                if (cls.isInstance(this.f11807e)) {
                    throw cls.cast(this.f11807e);
                }
            }
            if (this.f11807e != null) {
                throw new RuntimeException(this.f11807e);
            }
            tresult = this.f11806d;
        }
        return tresult;
    }

    @Override // e.k.b.a.k
    public final boolean t() {
        return this.f11805c;
    }

    @Override // e.k.b.a.k
    public final boolean u() {
        boolean z;
        synchronized (this.a) {
            z = this.b;
        }
        return z;
    }

    @Override // e.k.b.a.k
    public final boolean v() {
        boolean z;
        synchronized (this.a) {
            z = this.b && !t() && this.f11807e == null;
        }
        return z;
    }

    @Override // e.k.b.a.k
    public final <TContinuationResult> k<TContinuationResult> w(e.k.b.a.j<TResult, TContinuationResult> jVar) {
        return x(m.c(), jVar);
    }

    @Override // e.k.b.a.k
    public final <TContinuationResult> k<TContinuationResult> x(Executor executor, e.k.b.a.j<TResult, TContinuationResult> jVar) {
        i iVar = new i();
        l(executor, new a(jVar, iVar));
        h(new b(iVar));
        b(new c(iVar));
        return iVar;
    }

    public final void z(Exception exc) {
        synchronized (this.a) {
            if (this.b) {
                return;
            }
            this.b = true;
            this.f11807e = exc;
            this.a.notifyAll();
            C();
        }
    }
}
