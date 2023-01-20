package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes.dex */
public class j {
    private b a;
    private final Application.ActivityLifecycleCallbacks b = new a();

    /* loaded from: classes.dex */
    public class a implements Application.ActivityLifecycleCallbacks {
        private int a = 0;

        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            int i2 = this.a + 1;
            this.a = i2;
            if (i2 != 1 || j.this.a == null) {
                return;
            }
            j.this.a.a();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            int i2 = this.a - 1;
            this.a = i2;
            if (i2 != 0 || j.this.a == null) {
                return;
            }
            j.this.a.b();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b();
    }

    public void a(Application application) {
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this.b);
        }
    }

    public void a(Application application, b bVar) {
        if (application != null) {
            this.a = bVar;
            application.registerActivityLifecycleCallbacks(this.b);
        }
    }
}
