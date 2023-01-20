package e.j.a.b.c.n.u;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class z extends e.j.a.b.c.n.u.a {
    private final WeakReference<a> a;

    @VisibleForTesting(otherwise = 2)
    /* loaded from: classes2.dex */
    public static class a extends LifecycleCallback {
        private List<Runnable> b;

        private a(k kVar) {
            super(kVar);
            this.b = new ArrayList();
            this.a.a("LifecycleObserverOnStop", this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static a l(Activity activity) {
            a aVar;
            synchronized (activity) {
                k b = LifecycleCallback.b(activity);
                aVar = (a) b.e("LifecycleObserverOnStop", a.class);
                if (aVar == null) {
                    aVar = new a(b);
                }
            }
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized void n(Runnable runnable) {
            this.b.add(runnable);
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        @MainThread
        public void k() {
            List<Runnable> list;
            synchronized (this) {
                list = this.b;
                this.b = new ArrayList();
            }
            for (Runnable runnable : list) {
                runnable.run();
            }
        }
    }

    public z(Activity activity) {
        this(a.l(activity));
    }

    @Override // e.j.a.b.c.n.u.a
    public final e.j.a.b.c.n.u.a b(Runnable runnable) {
        a aVar = this.a.get();
        if (aVar != null) {
            aVar.n(runnable);
            return this;
        }
        throw new IllegalStateException("The target activity has already been GC'd");
    }

    @VisibleForTesting(otherwise = 2)
    private z(a aVar) {
        this.a = new WeakReference<>(aVar);
    }
}
