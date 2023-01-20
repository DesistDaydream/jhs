package e.b.a.t;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

/* loaded from: classes.dex */
public final class b implements RequestCoordinator, e {
    private final Object a;
    @Nullable
    private final RequestCoordinator b;

    /* renamed from: c  reason: collision with root package name */
    private volatile e f9880c;

    /* renamed from: d  reason: collision with root package name */
    private volatile e f9881d;
    @GuardedBy("requestLock")

    /* renamed from: e  reason: collision with root package name */
    private RequestCoordinator.RequestState f9882e;
    @GuardedBy("requestLock")

    /* renamed from: f  reason: collision with root package name */
    private RequestCoordinator.RequestState f9883f;

    public b(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f9882e = requestState;
        this.f9883f = requestState;
        this.a = obj;
        this.b = requestCoordinator;
    }

    @GuardedBy("requestLock")
    private boolean j(e eVar) {
        return eVar.equals(this.f9880c) || (this.f9882e == RequestCoordinator.RequestState.FAILED && eVar.equals(this.f9881d));
    }

    @GuardedBy("requestLock")
    private boolean k() {
        RequestCoordinator requestCoordinator = this.b;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    @GuardedBy("requestLock")
    private boolean l() {
        RequestCoordinator requestCoordinator = this.b;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    @GuardedBy("requestLock")
    private boolean m() {
        RequestCoordinator requestCoordinator = this.b;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, e.b.a.t.e
    public boolean a() {
        boolean z;
        synchronized (this.a) {
            z = this.f9880c.a() || this.f9881d.a();
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean b(e eVar) {
        boolean z;
        synchronized (this.a) {
            z = l() && j(eVar);
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(e eVar) {
        boolean z;
        synchronized (this.a) {
            z = m() && j(eVar);
        }
        return z;
    }

    @Override // e.b.a.t.e
    public void clear() {
        synchronized (this.a) {
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f9882e = requestState;
            this.f9880c.clear();
            if (this.f9883f != requestState) {
                this.f9883f = requestState;
                this.f9881d.clear();
            }
        }
    }

    @Override // e.b.a.t.e
    public void d() {
        synchronized (this.a) {
            RequestCoordinator.RequestState requestState = this.f9882e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                this.f9882e = requestState2;
                this.f9880c.d();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void e(e eVar) {
        synchronized (this.a) {
            if (!eVar.equals(this.f9881d)) {
                this.f9882e = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator.RequestState requestState = this.f9883f;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.f9883f = requestState2;
                    this.f9881d.d();
                }
                return;
            }
            this.f9883f = RequestCoordinator.RequestState.FAILED;
            RequestCoordinator requestCoordinator = this.b;
            if (requestCoordinator != null) {
                requestCoordinator.e(this);
            }
        }
    }

    @Override // e.b.a.t.e
    public boolean f() {
        boolean z;
        synchronized (this.a) {
            RequestCoordinator.RequestState requestState = this.f9882e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
            z = requestState == requestState2 && this.f9883f == requestState2;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void g(e eVar) {
        synchronized (this.a) {
            if (eVar.equals(this.f9880c)) {
                this.f9882e = RequestCoordinator.RequestState.SUCCESS;
            } else if (eVar.equals(this.f9881d)) {
                this.f9883f = RequestCoordinator.RequestState.SUCCESS;
            }
            RequestCoordinator requestCoordinator = this.b;
            if (requestCoordinator != null) {
                requestCoordinator.g(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.a) {
            RequestCoordinator requestCoordinator = this.b;
            root = requestCoordinator != null ? requestCoordinator.getRoot() : this;
        }
        return root;
    }

    @Override // e.b.a.t.e
    public boolean h(e eVar) {
        if (eVar instanceof b) {
            b bVar = (b) eVar;
            return this.f9880c.h(bVar.f9880c) && this.f9881d.h(bVar.f9881d);
        }
        return false;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean i(e eVar) {
        boolean z;
        synchronized (this.a) {
            z = k() && j(eVar);
        }
        return z;
    }

    @Override // e.b.a.t.e
    public boolean isComplete() {
        boolean z;
        synchronized (this.a) {
            RequestCoordinator.RequestState requestState = this.f9882e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
            z = requestState == requestState2 || this.f9883f == requestState2;
        }
        return z;
    }

    @Override // e.b.a.t.e
    public boolean isRunning() {
        boolean z;
        synchronized (this.a) {
            RequestCoordinator.RequestState requestState = this.f9882e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            z = requestState == requestState2 || this.f9883f == requestState2;
        }
        return z;
    }

    public void n(e eVar, e eVar2) {
        this.f9880c = eVar;
        this.f9881d = eVar2;
    }

    @Override // e.b.a.t.e
    public void pause() {
        synchronized (this.a) {
            RequestCoordinator.RequestState requestState = this.f9882e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState == requestState2) {
                this.f9882e = RequestCoordinator.RequestState.PAUSED;
                this.f9880c.pause();
            }
            if (this.f9883f == requestState2) {
                this.f9883f = RequestCoordinator.RequestState.PAUSED;
                this.f9881d.pause();
            }
        }
    }
}
