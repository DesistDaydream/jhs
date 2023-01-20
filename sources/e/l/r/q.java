package e.l.r;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.jihuanshe.ui.page.SplashActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes2.dex */
public final class q {
    @k.e.a.d
    public static final q a = new q();
    @k.e.a.d
    private static List<Activity> b = new ArrayList();

    /* loaded from: classes2.dex */
    public static final class a implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@k.e.a.d Activity activity, @k.e.a.e Bundle bundle) {
            q.b.add(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@k.e.a.d Activity activity) {
            q.b.remove(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@k.e.a.d Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@k.e.a.d Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@k.e.a.d Activity activity, @k.e.a.d Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@k.e.a.d Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@k.e.a.d Activity activity) {
        }
    }

    private q() {
    }

    public final void b(@k.e.a.d Application application) {
        application.registerActivityLifecycleCallbacks(new a());
    }

    public final boolean c() {
        List<Activity> list = b;
        return CollectionsKt___CollectionsKt.J2(list, list.size() - 1) instanceof SplashActivity;
    }

    public final boolean d() {
        return b.isEmpty();
    }
}
