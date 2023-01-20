package e.j.a.b.c.n.u;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.p;
import java.lang.ref.WeakReference;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class n2<R extends e.j.a.b.c.n.p> extends e.j.a.b.c.n.t<R> implements e.j.a.b.c.n.q<R> {

    /* renamed from: g */
    private final WeakReference<e.j.a.b.c.n.i> f10292g;

    /* renamed from: h */
    private final p2 f10293h;
    private e.j.a.b.c.n.s<? super R, ? extends e.j.a.b.c.n.p> a = null;
    private n2<? extends e.j.a.b.c.n.p> b = null;

    /* renamed from: c */
    private volatile e.j.a.b.c.n.r<? super R> f10288c = null;

    /* renamed from: d */
    private e.j.a.b.c.n.k<R> f10289d = null;

    /* renamed from: e */
    private final Object f10290e = new Object();

    /* renamed from: f */
    private Status f10291f = null;

    /* renamed from: i */
    private boolean f10294i = false;

    public n2(WeakReference<e.j.a.b.c.n.i> weakReference) {
        e.j.a.b.c.r.a0.l(weakReference, "GoogleApiClient reference must not be null");
        this.f10292g = weakReference;
        e.j.a.b.c.n.i iVar = weakReference.get();
        this.f10293h = new p2(this, iVar != null ? iVar.q() : Looper.getMainLooper());
    }

    public static void g(e.j.a.b.c.n.p pVar) {
        if (pVar instanceof e.j.a.b.c.n.m) {
            try {
                ((e.j.a.b.c.n.m) pVar).release();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(pVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("TransformedResultImpl", sb.toString(), e2);
            }
        }
    }

    @GuardedBy("mSyncToken")
    private final void h() {
        if (this.a == null && this.f10288c == null) {
            return;
        }
        e.j.a.b.c.n.i iVar = this.f10292g.get();
        if (!this.f10294i && this.a != null && iVar != null) {
            iVar.G(this);
            this.f10294i = true;
        }
        Status status = this.f10291f;
        if (status != null) {
            o(status);
            return;
        }
        e.j.a.b.c.n.k<R> kVar = this.f10289d;
        if (kVar != null) {
            kVar.g(this);
        }
    }

    @GuardedBy("mSyncToken")
    private final boolean j() {
        return (this.f10288c == null || this.f10292g.get() == null) ? false : true;
    }

    public final void m(Status status) {
        synchronized (this.f10290e) {
            this.f10291f = status;
            o(status);
        }
    }

    private final void o(Status status) {
        synchronized (this.f10290e) {
            e.j.a.b.c.n.s<? super R, ? extends e.j.a.b.c.n.p> sVar = this.a;
            if (sVar != null) {
                Status b = sVar.b(status);
                e.j.a.b.c.r.a0.l(b, "onFailure must not return null");
                this.b.m(b);
            } else if (j()) {
                this.f10288c.b(status);
            }
        }
    }

    @Override // e.j.a.b.c.n.q
    public final void a(R r) {
        synchronized (this.f10290e) {
            if (r.getStatus().isSuccess()) {
                if (this.a != null) {
                    d2.a().submit(new o2(this, r));
                } else if (j()) {
                    this.f10288c.c(r);
                }
            } else {
                m(r.getStatus());
                g(r);
            }
        }
    }

    @Override // e.j.a.b.c.n.t
    public final void b(@NonNull e.j.a.b.c.n.r<? super R> rVar) {
        synchronized (this.f10290e) {
            boolean z = true;
            e.j.a.b.c.r.a0.r(this.f10288c == null, "Cannot call andFinally() twice.");
            if (this.a != null) {
                z = false;
            }
            e.j.a.b.c.r.a0.r(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f10288c = rVar;
            h();
        }
    }

    @Override // e.j.a.b.c.n.t
    @NonNull
    public final <S extends e.j.a.b.c.n.p> e.j.a.b.c.n.t<S> c(@NonNull e.j.a.b.c.n.s<? super R, ? extends S> sVar) {
        n2<? extends e.j.a.b.c.n.p> n2Var;
        synchronized (this.f10290e) {
            boolean z = true;
            e.j.a.b.c.r.a0.r(this.a == null, "Cannot call then() twice.");
            if (this.f10288c != null) {
                z = false;
            }
            e.j.a.b.c.r.a0.r(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.a = sVar;
            n2Var = new n2<>(this.f10292g);
            this.b = n2Var;
            h();
        }
        return n2Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(e.j.a.b.c.n.k<?> kVar) {
        synchronized (this.f10290e) {
            this.f10289d = kVar;
            h();
        }
    }

    public final void i() {
        this.f10288c = null;
    }
}
