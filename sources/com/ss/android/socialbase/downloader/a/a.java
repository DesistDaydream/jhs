package com.ss.android.socialbase.downloader.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.ss.android.socialbase.downloader.i.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class a {
    private Application a;
    private c b;

    /* renamed from: c  reason: collision with root package name */
    private final List<InterfaceC0188a> f5519c;

    /* renamed from: d  reason: collision with root package name */
    private int f5520d;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<Activity> f5521e;

    /* renamed from: f  reason: collision with root package name */
    private volatile int f5522f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f5523g;

    /* renamed from: h  reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f5524h;

    /* renamed from: com.ss.android.socialbase.downloader.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0188a {
        @MainThread
        void b();

        @MainThread
        void c();
    }

    /* loaded from: classes3.dex */
    public static class b {
        private static final a a = new a();
    }

    /* loaded from: classes3.dex */
    public interface c {
    }

    private Object[] d() {
        Object[] array;
        synchronized (this.f5519c) {
            array = this.f5519c.size() > 0 ? this.f5519c.toArray() : null;
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.f5522f = 1;
        Object[] d2 = d();
        if (d2 != null) {
            for (Object obj : d2) {
                ((InterfaceC0188a) obj).b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f5522f = 0;
        Object[] d2 = d();
        if (d2 != null) {
            for (Object obj : d2) {
                ((InterfaceC0188a) obj).c();
            }
        }
    }

    private boolean g() {
        try {
            Application application = this.a;
            if (application == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) application.getSystemService("activity");
            return TextUtils.equals(application.getPackageName(), f.d(application));
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private a() {
        this.f5519c = new ArrayList();
        this.f5522f = -1;
        this.f5523g = false;
        this.f5524h = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.a.a.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                a.this.f5523g = true;
                if (a.this.f5520d != 0 || activity == null) {
                    return;
                }
                a.this.f5520d = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i2 = a.this.f5520d;
                a.this.f5523g = false;
                a.this.f5520d = activity != null ? activity.hashCode() : i2;
                if (i2 == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                a.this.f5521e = new WeakReference(activity);
                int i2 = a.this.f5520d;
                a.this.f5520d = activity != null ? activity.hashCode() : i2;
                a.this.f5523g = false;
                if (i2 == 0) {
                    a.this.e();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == a.this.f5520d) {
                    a.this.f5520d = 0;
                    a.this.f();
                }
                a.this.f5523g = false;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    public boolean b() {
        int i2 = this.f5522f;
        int i3 = i2;
        if (i2 == -1) {
            ?? g2 = g();
            this.f5522f = g2;
            i3 = g2;
        }
        return i3 == 1;
    }

    public boolean c() {
        return b() && !this.f5523g;
    }

    public static a a() {
        return b.a;
    }

    public void b(InterfaceC0188a interfaceC0188a) {
        synchronized (this.f5519c) {
            this.f5519c.remove(interfaceC0188a);
        }
    }

    public void a(Context context) {
        if (this.a == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.a == null) {
                    Application application = (Application) context;
                    this.a = application;
                    application.registerActivityLifecycleCallbacks(this.f5524h);
                }
            }
        }
    }

    public void a(c cVar) {
        this.b = cVar;
    }

    public void a(InterfaceC0188a interfaceC0188a) {
        if (interfaceC0188a == null) {
            return;
        }
        synchronized (this.f5519c) {
            if (!this.f5519c.contains(interfaceC0188a)) {
                this.f5519c.add(interfaceC0188a);
            }
        }
    }
}
