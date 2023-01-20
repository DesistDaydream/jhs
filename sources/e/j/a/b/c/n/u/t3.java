package e.j.a.b.c.n.u;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class t3 extends Fragment implements k {

    /* renamed from: d  reason: collision with root package name */
    private static WeakHashMap<FragmentActivity, WeakReference<t3>> f10325d = new WeakHashMap<>();
    private Map<String, LifecycleCallback> a = new ArrayMap();
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f10326c;

    public static t3 q(FragmentActivity fragmentActivity) {
        t3 t3Var;
        WeakReference<t3> weakReference = f10325d.get(fragmentActivity);
        if (weakReference == null || (t3Var = weakReference.get()) == null) {
            try {
                t3 t3Var2 = (t3) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
                if (t3Var2 == null || t3Var2.isRemoving()) {
                    t3Var2 = new t3();
                    fragmentActivity.getSupportFragmentManager().beginTransaction().add(t3Var2, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
                }
                f10325d.put(fragmentActivity, new WeakReference<>(t3Var2));
                return t3Var2;
            } catch (ClassCastException e2) {
                throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e2);
            }
        }
        return t3Var;
    }

    @Override // e.j.a.b.c.n.u.k
    public final void a(String str, @NonNull LifecycleCallback lifecycleCallback) {
        if (!this.a.containsKey(str)) {
            this.a.put(str, lifecycleCallback);
            if (this.b > 0) {
                new e.j.a.b.f.b.e(Looper.getMainLooper()).post(new u3(this, lifecycleCallback, str));
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

    @Override // androidx.fragment.app.Fragment
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
    public final /* synthetic */ Activity n() {
        return getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        for (LifecycleCallback lifecycleCallback : this.a.values()) {
            lifecycleCallback.e(i2, i3, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = 1;
        this.f10326c = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.a.entrySet()) {
            entry.getValue().f(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.b = 5;
        for (LifecycleCallback lifecycleCallback : this.a.values()) {
            lifecycleCallback.g();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.b = 3;
        for (LifecycleCallback lifecycleCallback : this.a.values()) {
            lifecycleCallback.h();
        }
    }

    @Override // androidx.fragment.app.Fragment
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

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.b = 2;
        for (LifecycleCallback lifecycleCallback : this.a.values()) {
            lifecycleCallback.j();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.b = 4;
        for (LifecycleCallback lifecycleCallback : this.a.values()) {
            lifecycleCallback.k();
        }
    }
}
