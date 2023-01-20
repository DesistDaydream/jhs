package e.k.b.a.o;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class g extends Fragment {
    private static final WeakHashMap<Activity, WeakReference<g>> b = new WeakHashMap<>();
    private final List<WeakReference<e.k.b.a.e<?>>> a = new ArrayList();

    private static g a(Activity activity) {
        g gVar;
        WeakHashMap<Activity, WeakReference<g>> weakHashMap = b;
        WeakReference<g> weakReference = weakHashMap.get(activity);
        if (weakReference == null || weakReference.get() == null) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            try {
                g gVar2 = (g) fragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
                if (gVar2 == null) {
                    try {
                        gVar = b(fragmentManager);
                    } catch (ClassCastException e2) {
                        e = e2;
                        gVar = gVar2;
                        Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e.getMessage());
                        return gVar;
                    }
                } else {
                    gVar = gVar2;
                }
            } catch (ClassCastException e3) {
                e = e3;
                gVar = null;
            }
            try {
                weakHashMap.put(activity, new WeakReference<>(gVar));
            } catch (ClassCastException e4) {
                e = e4;
                Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e.getMessage());
                return gVar;
            }
            return gVar;
        }
        return weakReference.get();
    }

    private static g b(FragmentManager fragmentManager) {
        g gVar = null;
        try {
            g gVar2 = new g();
            try {
                fragmentManager.beginTransaction().add(gVar2, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
                return gVar2;
            } catch (Exception e2) {
                e = e2;
                gVar = gVar2;
                Log.e("LifecycleCallbackFrg", "create fragment failed." + e.getMessage());
                return gVar;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public static void c(Activity activity, e.k.b.a.e eVar) {
        g a = a(activity);
        if (a != null) {
            synchronized (a.a) {
                a.a.add(new WeakReference<>(eVar));
            }
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        synchronized (this.a) {
            for (WeakReference<e.k.b.a.e<?>> weakReference : this.a) {
                e.k.b.a.e<?> eVar = weakReference.get();
                if (eVar != null) {
                    eVar.cancel();
                }
            }
            this.a.clear();
        }
    }
}
