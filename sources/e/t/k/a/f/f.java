package e.t.k.a.f;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import h.r0;
import h.t1;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u0010J\u0006\u0010\u0017\u001a\u00020\u0010J\u0006\u0010\u0018\u001a\u00020\u0010J\u0006\u0010\u0019\u001a\u00020\u0010J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/vector/design/ui/dialog/DialogLifecycleDispatcher;", "", com.umeng.analytics.pro.d.M, "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;)V", "handler", "Landroid/os/Handler;", "lastDispatchRunnable", "Lcom/vector/design/ui/dialog/DialogLifecycleDispatcher$DispatchRunnable;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "registry", "Landroidx/lifecycle/LifecycleRegistry;", "addObserver", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "postDispatchRunnable", "event", "Landroidx/lifecycle/Lifecycle$Event;", "postOnCreate", "postOnDestroy", "postOnStart", "postOnStop", "removeObserver", "DispatchRunnable", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class f {
    @k.e.a.d
    private final LifecycleRegistry a;
    @k.e.a.d
    private final Handler b = new Handler();
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    private a f14565c;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/vector/design/ui/dialog/DialogLifecycleDispatcher$DispatchRunnable;", "Ljava/lang/Runnable;", "r", "Landroidx/lifecycle/LifecycleRegistry;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "(Landroidx/lifecycle/LifecycleRegistry;Landroidx/lifecycle/Lifecycle$Event;)V", "getEvent", "()Landroidx/lifecycle/Lifecycle$Event;", "wasExecuted", "", "run", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a implements Runnable {
        @k.e.a.d
        private final LifecycleRegistry a;
        @k.e.a.d
        private final Lifecycle.Event b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f14566c;

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
            if (this.f14566c) {
                return;
            }
            try {
                Result.a aVar = Result.Companion;
                this.a.handleLifecycleEvent(a());
                Result.m106constructorimpl(t1.a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                Result.m106constructorimpl(r0.a(th));
            }
            this.f14566c = true;
        }
    }

    public f(@k.e.a.d LifecycleOwner lifecycleOwner) {
        this.a = new LifecycleRegistry(lifecycleOwner);
    }

    private final void c(Lifecycle.Event event) {
        a aVar = this.f14565c;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.a, event);
        this.f14565c = aVar2;
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
