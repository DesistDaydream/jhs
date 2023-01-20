package e.j.a.b.c.n.u;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class r3 extends Fragment implements k {

    /* renamed from: d  reason: collision with root package name */
    private static WeakHashMap<Activity, WeakReference<r3>> f10320d = new WeakHashMap<>();
    private Map<String, LifecycleCallback> a = new ArrayMap();
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f10321c;

    public static r3 c(Activity activity) {
        r3 r3Var;
        WeakReference<r3> weakReference = f10320d.get(activity);
        if (weakReference == null || (r3Var = weakReference.get()) == null) {
            try {
                r3 r3Var2 = (r3) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                if (r3Var2 == null || r3Var2.isRemoving()) {
                    r3Var2 = new r3();
                    activity.getFragmentManager().beginTransaction().add(r3Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
                }
                f10320d.put(activity, new WeakReference<>(r3Var2));
                return r3Var2;
            } catch (ClassCastException e2) {
                throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e2);
            }
        }
        return r3Var;
    }

    @Override // e.j.a.b.c.n.u.k
    public final void a(String str, @NonNull LifecycleCallback lifecycleCallback) {
        if (!this.a.containsKey(str)) {
            this.a.put(str, lifecycleCallback);
            if (this.b > 0) {
                new e.j.a.b.f.b.e(Looper.getMainLooper()).post(new s3(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.a.values()) {
            lifecycleCallback.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // e.j.a.b.c.n.u.k
    public final <T extends LifecycleCallback> T e(String str, Class<T> cls) {
        return cls.cast(this.a.get(str));
    }

    @Override // e.j.a.b.c.n.u.k
    public final boolean i() {
        return this.b >= 2;
    }

    @Override // e.j.a.b.c.n.u.k
    public final boolean k() {
        return this.b > 0;
    }

    @Override // e.j.a.b.c.n.u.k
    public final Activity n() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        for (LifecycleCallback lifecycleCallback : this.a.values()) {
            lifecycleCallback.e(i2, i3, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = 1;
        this.f10321c = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.a.entrySet()) {
            entry.getValue().f(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.b = 5;
        for (LifecycleCallback lifecycleCallback : this.a.values()) {
            lifecycleCallback.g();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.b = 3;
        for (LifecycleCallback lifecycleCallback : this.a.values()) {
            lifecycleCallback.h();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.a.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().i(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.b = 2;
        for (LifecycleCallback lifecycleCallback : this.a.values()) {
            lifecycleCallback.j();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.b = 4;
        for (LifecycleCallback lifecycleCallback : this.a.values()) {
            lifecycleCallback.k();
        }
    }
}
