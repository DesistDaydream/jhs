package e.b.a.t;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;

/* loaded from: classes.dex */
public class j implements RequestCoordinator, e {
    @Nullable
    private final RequestCoordinator a;
    private final Object b;

    /* renamed from: c  reason: collision with root package name */
    private volatile e f9893c;

    /* renamed from: d  reason: collision with root package name */
    private volatile e f9894d;
    @GuardedBy("requestLock")

    /* renamed from: e  reason: collision with root package name */
    private RequestCoordinator.RequestState f9895e;
    @GuardedBy("requestLock")

    /* renamed from: f  reason: collision with root package name */
    private RequestCoordinator.RequestState f9896f;
    @GuardedBy("requestLock")

    /* renamed from: g  reason: collision with root package name */
    private boolean f9897g;

    public j(Object obj, @Nullable RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f9895e = requestState;
        this.f9896f = requestState;
        this.b = obj;
        this.a = requestCoordinator;
    }

    @GuardedBy("requestLock")
    private boolean j() {
        RequestCoordinator requestCoordinator = this.a;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    @GuardedBy("requestLock")
    private boolean k() {
        RequestCoordinator requestCoordinator = this.a;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    @GuardedBy("requestLock")
    private boolean l() {
        RequestCoordinator requestCoordinator = this.a;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, e.b.a.t.e
    public boolean a() {
        boolean z;
        synchronized (this.b) {
            z = this.f9894d.a() || this.f9893c.a();
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean b(e eVar) {
        boolean z;
        synchronized (this.b) {
            z = k() && eVar.equals(this.f9893c) && !a();
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(e eVar) {
        boolean z;
        synchronized (this.b) {
            z = l() && (eVar.equals(this.f9893c) || this.f9895e != RequestCoordinator.RequestState.SUCCESS);
        }
        return z;
    }

    @Override // e.b.a.t.e
    public void clear() {
        synchronized (this.b) {
            this.f9897g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f9895e = requestState;
            this.f9896f = requestState;
            this.f9894d.clear();
            this.f9893c.clear();
        }
    }

    @Override // e.b.a.t.e
    public void d() {
        synchronized (this.b) {
            this.f9897g = true;
            if (this.f9895e != RequestCoordinator.RequestState.SUCCESS) {
                RequestCoordinator.RequestState requestState = this.f9896f;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.f9896f = requestState2;
                    this.f9894d.d();
                }
            }
            if (this.f9897g) {
                RequestCoordinator.RequestState requestState3 = this.f9895e;
                RequestCoordinator.RequestState requestState4 = RequestCoordinator.RequestState.RUNNING;
                if (requestState3 != requestState4) {
                    this.f9895e = requestState4;
                    this.f9893c.d();
                }
            }
            this.f9897g = false;
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void e(e eVar) {
        synchronized (this.b) {
            if (!eVar.equals(this.f9893c)) {
                this.f9896f = RequestCoordinator.RequestState.FAILED;
                return;
            }
            this.f9895e = RequestCoordinator.RequestState.FAILED;
            RequestCoordinator requestCoordinator = this.a;
            if (requestCoordinator != null) {
                requestCoordinator.e(this);
            }
        }
    }

    @Override // e.b.a.t.e
    public boolean f() {
        boolean z;
        synchronized (this.b) {
            z = this.f9895e == RequestCoordinator.RequestState.CLEARED;
        }
        return z;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void g(e eVar) {
        synchronized (this.b) {
            if (eVar.equals(this.f9894d)) {
                this.f9896f = RequestCoordinator.RequestState.SUCCESS;
                return;
            }
            this.f9895e = RequestCoordinator.RequestState.SUCCESS;
            RequestCoordinator requestCoordinator = this.a;
            if (requestCoordinator != null) {
                requestCoordinator.g(this);
            }
            if (!this.f9896f.isComplete()) {
                this.f9894d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator root;
        synchronized (this.b) {
            RequestCoordinator requestCoordinator = this.a;
            root = requestCoordinator != null ? requestCoordinator.getRoot() : this;
        }
        return root;
    }

    @Override // e.b.a.t.e
    public boolean h(e eVar) {
        if (eVar instanceof j) {
            j jVar = (j) eVar;
            if (this.f9893c == null) {
                if (jVar.f9893c != null) {
                    return false;
                }
            } else if (!this.f9893c.h(jVar.f9893c)) {
                return false;
            }
            if (this.f9894d == null) {
                if (jVar.f9894d != null) {
                    return false;
                }
            } else if (!this.f9894d.h(jVar.f9894d)) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean i(e eVar) {
        boolean z;
        synchronized (this.b) {
            z = j() && eVar.equals(this.f9893c) && this.f9895e != RequestCoordinator.RequestState.PAUSED;
        }
        return z;
    }

    @Override // e.b.a.t.e
    public boolean isComplete() {
        boolean z;
        synchronized (this.b) {
            z = this.f9895e == RequestCoordinator.RequestState.SUCCESS;
        }
        return z;
    }

    @Override // e.b.a.t.e
    public boolean isRunning() {
        boolean z;
        synchronized (this.b) {
            z = this.f9895e == RequestCoordinator.RequestState.RUNNING;
        }
        return z;
    }

    public void m(e eVar, e eVar2) {
        this.f9893c = eVar;
        this.f9894d = eVar2;
    }

    @Override // e.b.a.t.e
    public void pause() {
        synchronized (this.b) {
            if (!this.f9896f.isComplete()) {
                this.f9896f = RequestCoordinator.RequestState.PAUSED;
                this.f9894d.pause();
            }
            if (!this.f9895e.isComplete()) {
                this.f9895e = RequestCoordinator.RequestState.PAUSED;
                this.f9893c.pause();
            }
        }
    }
}
