package e.j.a.b.c.n.u;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: e  reason: collision with root package name */
    private static final c f10204e = new c();
    private final AtomicBoolean a = new AtomicBoolean();
    private final AtomicBoolean b = new AtomicBoolean();
    @GuardedBy("sInstance")

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<a> f10205c = new ArrayList<>();
    @GuardedBy("sInstance")

    /* renamed from: d  reason: collision with root package name */
    private boolean f10206d = false;

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public interface a {
        @e.j.a.b.c.m.a
        void onBackgroundStateChanged(boolean z);
    }

    @e.j.a.b.c.m.a
    private c() {
    }

    @e.j.a.b.c.m.a
    public static c b() {
        return f10204e;
    }

    @e.j.a.b.c.m.a
    public static void c(Application application) {
        c cVar = f10204e;
        synchronized (cVar) {
            if (!cVar.f10206d) {
                application.registerActivityLifecycleCallbacks(cVar);
                application.registerComponentCallbacks(cVar);
                cVar.f10206d = true;
            }
        }
    }

    private final void e(boolean z) {
        synchronized (f10204e) {
            ArrayList<a> arrayList = this.f10205c;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                a aVar = arrayList.get(i2);
                i2++;
                aVar.onBackgroundStateChanged(z);
            }
        }
    }

    @e.j.a.b.c.m.a
    public final void a(a aVar) {
        synchronized (f10204e) {
            this.f10205c.add(aVar);
        }
    }

    @e.j.a.b.c.m.a
    public final boolean d() {
        return this.a.get();
    }

    @e.j.a.b.c.m.a
    @TargetApi(16)
    public final boolean f(boolean z) {
        if (!this.b.get()) {
            if (!e.j.a.b.c.x.v.e()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.a.set(true);
            }
        }
        return d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.a.compareAndSet(true, false);
        this.b.set(true);
        if (compareAndSet) {
            e(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.a.compareAndSet(true, false);
        this.b.set(true);
        if (compareAndSet) {
            e(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        if (i2 == 20 && this.a.compareAndSet(false, true)) {
            this.b.set(true);
            e(true);
        }
    }
}
