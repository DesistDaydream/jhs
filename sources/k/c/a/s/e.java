package k.c.a.s;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;

/* loaded from: classes4.dex */
public class e {
    public static c<?> a = null;
    public static final String b = "de.greenrobot.eventbus.error_dialog";

    /* renamed from: c  reason: collision with root package name */
    public static final String f16312c = "de.greenrobot.eventbus.error_dialog_manager";

    /* renamed from: d  reason: collision with root package name */
    public static final String f16313d = "de.greenrobot.eventbus.errordialog.title";

    /* renamed from: e  reason: collision with root package name */
    public static final String f16314e = "de.greenrobot.eventbus.errordialog.message";

    /* renamed from: f  reason: collision with root package name */
    public static final String f16315f = "de.greenrobot.eventbus.errordialog.finish_after_dialog";

    /* renamed from: g  reason: collision with root package name */
    public static final String f16316g = "de.greenrobot.eventbus.errordialog.icon_id";

    /* renamed from: h  reason: collision with root package name */
    public static final String f16317h = "de.greenrobot.eventbus.errordialog.event_type_on_close";

    @TargetApi(11)
    /* loaded from: classes4.dex */
    public static class a extends Fragment {
        public boolean a;
        public Bundle b;

        /* renamed from: c  reason: collision with root package name */
        private k.c.a.c f16318c;

        /* renamed from: d  reason: collision with root package name */
        private Object f16319d;

        public static void a(Activity activity, Object obj, boolean z, Bundle bundle) {
            FragmentManager fragmentManager = activity.getFragmentManager();
            a aVar = (a) fragmentManager.findFragmentByTag(e.f16312c);
            if (aVar == null) {
                aVar = new a();
                fragmentManager.beginTransaction().add(aVar, e.f16312c).commit();
                fragmentManager.executePendingTransactions();
            }
            aVar.a = z;
            aVar.b = bundle;
            aVar.f16319d = obj;
        }

        public void b(h hVar) {
            if (e.g(this.f16319d, hVar)) {
                e.f(hVar);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                DialogFragment dialogFragment = (DialogFragment) fragmentManager.findFragmentByTag(e.b);
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                DialogFragment dialogFragment2 = (DialogFragment) e.a.d(hVar, this.a, this.b);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, e.b);
                }
            }
        }

        @Override // android.app.Fragment
        public void onPause() {
            this.f16318c.A(this);
            super.onPause();
        }

        @Override // android.app.Fragment
        public void onResume() {
            super.onResume();
            k.c.a.c c2 = e.a.a.c();
            this.f16318c = c2;
            c2.v(this);
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends androidx.fragment.app.Fragment {
        public boolean a;
        public Bundle b;

        /* renamed from: c  reason: collision with root package name */
        private k.c.a.c f16320c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f16321d;

        /* renamed from: e  reason: collision with root package name */
        private Object f16322e;

        public static void p(Activity activity, Object obj, boolean z, Bundle bundle) {
            androidx.fragment.app.FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
            b bVar = (b) supportFragmentManager.findFragmentByTag(e.f16312c);
            if (bVar == null) {
                bVar = new b();
                supportFragmentManager.beginTransaction().add(bVar, e.f16312c).commit();
                supportFragmentManager.executePendingTransactions();
            }
            bVar.a = z;
            bVar.b = bundle;
            bVar.f16322e = obj;
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            k.c.a.c c2 = e.a.a.c();
            this.f16320c = c2;
            c2.v(this);
            this.f16321d = true;
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            this.f16320c.A(this);
            super.onPause();
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            super.onResume();
            if (this.f16321d) {
                this.f16321d = false;
                return;
            }
            k.c.a.c c2 = e.a.a.c();
            this.f16320c = c2;
            c2.v(this);
        }

        public void q(h hVar) {
            if (e.g(this.f16322e, hVar)) {
                e.f(hVar);
                androidx.fragment.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                androidx.fragment.app.DialogFragment dialogFragment = (androidx.fragment.app.DialogFragment) fragmentManager.findFragmentByTag(e.b);
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                androidx.fragment.app.DialogFragment dialogFragment2 = (androidx.fragment.app.DialogFragment) e.a.d(hVar, this.a, this.b);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, e.b);
                }
            }
        }
    }

    public static void b(Activity activity) {
        e(activity, false, null);
    }

    public static void c(Activity activity, Object obj, boolean z, Bundle bundle) {
        if (a != null) {
            if (h(activity)) {
                b.p(activity, obj, z, bundle);
                return;
            } else {
                a.a(activity, obj, z, bundle);
                return;
            }
        }
        throw new RuntimeException("You must set the static factory field to configure error dialogs for your app.");
    }

    public static void d(Activity activity, boolean z) {
        e(activity, z, null);
    }

    public static void e(Activity activity, boolean z, Bundle bundle) {
        c(activity, activity.getClass(), z, bundle);
    }

    public static void f(h hVar) {
        k.c.a.s.b bVar = a.a;
        if (bVar.f16308f) {
            String str = bVar.f16309g;
            if (str == null) {
                str = k.c.a.c.s;
            }
            Log.i(str, "Error dialog manager received exception", hVar.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(Object obj, h hVar) {
        Object a2;
        return hVar == null || (a2 = hVar.a()) == null || a2.equals(obj);
    }

    private static boolean h(Activity activity) {
        String name;
        Class<?> cls = activity.getClass();
        do {
            cls = cls.getSuperclass();
            if (cls != null) {
                name = cls.getName();
                if (name.equals("androidx.fragment.app.FragmentActivity")) {
                    return true;
                }
                if (name.startsWith("com.actionbarsherlock.app") && (name.endsWith(".SherlockActivity") || name.endsWith(".SherlockListActivity") || name.endsWith(".SherlockPreferenceActivity"))) {
                    throw new RuntimeException("Please use SherlockFragmentActivity. Illegal activity: " + name);
                }
            } else {
                throw new RuntimeException("Illegal activity type: " + activity.getClass());
            }
        } while (!name.equals("android.app.Activity"));
        if (Build.VERSION.SDK_INT >= 11) {
            return false;
        }
        throw new RuntimeException("Illegal activity without fragment support. Either use Android 3.0+ or android.support.v4.app.FragmentActivity.");
    }
}
