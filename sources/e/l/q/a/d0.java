package e.l.q.a;

import android.os.Handler;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;

/* loaded from: classes2.dex */
public final class d0 {
    @k.e.a.d
    private final LifecycleRegistry a;
    @k.e.a.d
    private final Handler b = new Handler();
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    private a f14124c;

    /* loaded from: classes2.dex */
    public static final class a implements Runnable {
        @k.e.a.d
        private final LifecycleRegistry a;
        @k.e.a.d
        private final Lifecycle.Event b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f14125c;

        public a(@k.e.a.d LifecycleRegistry lifecycleRegistry, @k.e.a.d Lifecycle.Event event) {
            this.a = lifecycleRegistry;
            this.b = event;
        }

        @k.e.a.d
        public final Lifecycle.Event a() {
            return this.b;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f14125c) {
                    return;
                }
                this.a.handleLifecycleEvent(this.b);
                this.f14125c = true;
            } catch (Exception e2) {
                Log.e("BaseDialog", h.k2.v.f0.C("DispatchRunnable error: ", e2.getMessage()));
            }
        }
    }

    public d0(@k.e.a.d LifecycleOwner lifecycleOwner) {
        this.a = new LifecycleRegistry(lifecycleOwner);
    }

    private final void c(Lifecycle.Event event) {
        a aVar = this.f14124c;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.a, event);
        this.f14124c = aVar2;
        if (aVar2 == null) {
            return;
        }
        this.b.postAtFrontOfQueue(aVar2);
    }

    public final void a(@k.e.a.d LifecycleObserver lifecycleObserver) {
        this.a.addObserver(lifecycleObserver);
    }

    @k.e.a.d
    public final Lifecycle b() {
        return this.a;
    }

    public final void d() {
        c(Lifecycle.Event.ON_CREATE);
    }

    public final void e() {
        c(Lifecycle.Event.ON_STOP);
        c(Lifecycle.Event.ON_DESTROY);
    }

    public final void f() {
        c(Lifecycle.Event.ON_START);
    }

    public final void g() {
        c(Lifecycle.Event.ON_STOP);
    }

    public final void h(@k.e.a.d LifecycleObserver lifecycleObserver) {
        this.a.removeObserver(lifecycleObserver);
    }
}
