package e.j.a.b.j;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.tasks.RuntimeExecutionException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class i0<TResult> extends k<TResult> {
    private final Object a = new Object();
    private final f0<TResult> b = new f0<>();
    @GuardedBy("mLock")

    /* renamed from: c  reason: collision with root package name */
    private boolean f10536c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f10537d;
    @GuardedBy("mLock")

    /* renamed from: e  reason: collision with root package name */
    private TResult f10538e;
    @GuardedBy("mLock")

    /* renamed from: f  reason: collision with root package name */
    private Exception f10539f;

    /* loaded from: classes2.dex */
    public static class a extends LifecycleCallback {
        private final List<WeakReference<e0<?>>> b;

        private a(e.j.a.b.c.n.u.k kVar) {
            super(kVar);
            this.b = new ArrayList();
            this.a.a("TaskOnStopCallback", this);
        }

        public static a l(Activity activity) {
            e.j.a.b.c.n.u.k b = LifecycleCallback.b(activity);
            a aVar = (a) b.e("TaskOnStopCallback", a.class);
            return aVar == null ? new a(b) : aVar;
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        @MainThread
        public void k() {
            synchronized (this.b) {
                for (WeakReference<e0<?>> weakReference : this.b) {
                    e0<?> e0Var = weakReference.get();
                    if (e0Var != null) {
                        e0Var.cancel();
                    }
                }
                this.b.clear();
            }
        }

        public final <T> void m(e0<T> e0Var) {
            synchronized (this.b) {
                this.b.add(new WeakReference<>(e0Var));
            }
        }
    }

    @GuardedBy("mLock")
    private final void C() {
        e.j.a.b.c.r.a0.r(this.f10536c, "Task is not yet complete");
    }

    @GuardedBy("mLock")
    private final void D() {
        e.j.a.b.c.r.a0.r(!this.f10536c, "Task is already complete");
    }

    @GuardedBy("mLock")
    private final void E() {
        if (this.f10537d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void F() {
        synchronized (this.a) {
            if (this.f10536c) {
                this.b.a(this);
            }
        }
    }

    public final boolean A(TResult tresult) {
        synchronized (this.a) {
            if (this.f10536c) {
                return false;
            }
            this.f10536c = true;
            this.f10538e = tresult;
            this.b.a(this);
            return true;
        }
    }

    public final boolean B() {
        synchronized (this.a) {
            if (this.f10536c) {
                return false;
            }
            this.f10536c = true;
            this.f10537d = true;
            this.b.a(this);
            return true;
        }
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final k<TResult> a(@NonNull Activity activity, @NonNull d dVar) {
        u uVar = new u(m.a, dVar);
        this.b.b(uVar);
        a.l(activity).m(uVar);
        F();
        return this;
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final k<TResult> b(@NonNull d dVar) {
        return c(m.a, dVar);
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final k<TResult> c(@NonNull Executor executor, @NonNull d dVar) {
        this.b.b(new u(executor, dVar));
        F();
        return this;
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final k<TResult> d(@NonNull Activity activity, @NonNull e<TResult> eVar) {
        w wVar = new w(m.a, eVar);
        this.b.b(wVar);
        a.l(activity).m(wVar);
        F();
        return this;
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final k<TResult> e(@NonNull e<TResult> eVar) {
        return f(m.a, eVar);
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final k<TResult> f(@NonNull Executor executor, @NonNull e<TResult> eVar) {
        this.b.b(new w(executor, eVar));
        F();
        return this;
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final k<TResult> g(@NonNull Activity activity, @NonNull f fVar) {
        y yVar = new y(m.a, fVar);
        this.b.b(yVar);
        a.l(activity).m(yVar);
        F();
        return this;
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final k<TResult> h(@NonNull f fVar) {
        return i(m.a, fVar);
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final k<TResult> i(@NonNull Executor executor, @NonNull f fVar) {
        this.b.b(new y(executor, fVar));
        F();
        return this;
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final k<TResult> j(@NonNull Activity activity, @NonNull g<? super TResult> gVar) {
        a0 a0Var = new a0(m.a, gVar);
        this.b.b(a0Var);
        a.l(activity).m(a0Var);
        F();
        return this;
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final k<TResult> k(@NonNull g<? super TResult> gVar) {
        return l(m.a, gVar);
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final k<TResult> l(@NonNull Executor executor, @NonNull g<? super TResult> gVar) {
        this.b.b(new a0(executor, gVar));
        F();
        return this;
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final <TContinuationResult> k<TContinuationResult> m(@NonNull c<TResult, TContinuationResult> cVar) {
        return n(m.a, cVar);
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final <TContinuationResult> k<TContinuationResult> n(@NonNull Executor executor, @NonNull c<TResult, TContinuationResult> cVar) {
        i0 i0Var = new i0();
        this.b.b(new q(executor, cVar, i0Var));
        F();
        return i0Var;
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final <TContinuationResult> k<TContinuationResult> o(@NonNull c<TResult, k<TContinuationResult>> cVar) {
        return p(m.a, cVar);
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final <TContinuationResult> k<TContinuationResult> p(@NonNull Executor executor, @NonNull c<TResult, k<TContinuationResult>> cVar) {
        i0 i0Var = new i0();
        this.b.b(new s(executor, cVar, i0Var));
        F();
        return i0Var;
    }

    @Override // e.j.a.b.j.k
    @Nullable
    public final Exception q() {
        Exception exc;
        synchronized (this.a) {
            exc = this.f10539f;
        }
        return exc;
    }

    @Override // e.j.a.b.j.k
    public final TResult r() {
        TResult tresult;
        synchronized (this.a) {
            C();
            E();
            if (this.f10539f == null) {
                tresult = this.f10538e;
            } else {
                throw new RuntimeExecutionException(this.f10539f);
            }
        }
        return tresult;
    }

    @Override // e.j.a.b.j.k
    public final <X extends Throwable> TResult s(@NonNull Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.a) {
            C();
            E();
            if (!cls.isInstance(this.f10539f)) {
                if (this.f10539f == null) {
                    tresult = this.f10538e;
                } else {
                    throw new RuntimeExecutionException(this.f10539f);
                }
            } else {
                throw cls.cast(this.f10539f);
            }
        }
        return tresult;
    }

    public final void setResult(TResult tresult) {
        synchronized (this.a) {
            D();
            this.f10536c = true;
            this.f10538e = tresult;
        }
        this.b.a(this);
    }

    @Override // e.j.a.b.j.k
    public final boolean t() {
        return this.f10537d;
    }

    @Override // e.j.a.b.j.k
    public final boolean u() {
        boolean z;
        synchronized (this.a) {
            z = this.f10536c;
        }
        return z;
    }

    @Override // e.j.a.b.j.k
    public final boolean v() {
        boolean z;
        synchronized (this.a) {
            z = this.f10536c && !this.f10537d && this.f10539f == null;
        }
        return z;
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final <TContinuationResult> k<TContinuationResult> w(@NonNull j<TResult, TContinuationResult> jVar) {
        return x(m.a, jVar);
    }

    @Override // e.j.a.b.j.k
    @NonNull
    public final <TContinuationResult> k<TContinuationResult> x(Executor executor, j<TResult, TContinuationResult> jVar) {
        i0 i0Var = new i0();
        this.b.b(new c0(executor, jVar, i0Var));
        F();
        return i0Var;
    }

    public final void y(@NonNull Exception exc) {
        e.j.a.b.c.r.a0.l(exc, "Exception must not be null");
        synchronized (this.a) {
            D();
            this.f10536c = true;
            this.f10539f = exc;
        }
        this.b.a(this);
    }

    public final boolean z(@NonNull Exception exc) {
        e.j.a.b.c.r.a0.l(exc, "Exception must not be null");
        synchronized (this.a) {
            if (this.f10536c) {
                return false;
            }
            this.f10536c = true;
            this.f10539f = exc;
            this.b.a(this);
            return true;
        }
    }
}
