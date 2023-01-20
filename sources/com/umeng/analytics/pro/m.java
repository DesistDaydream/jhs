package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class m implements Application.ActivityLifecycleCallbacks {
    private static m a = new m();
    private final int b = 3000;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7226c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7227d = true;

    /* renamed from: e  reason: collision with root package name */
    private Handler f7228e = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<n> f7229f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private a f7230g = new a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m.this.f7226c && m.this.f7227d) {
                m.this.f7226c = false;
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> went background.");
                for (int i2 = 0; i2 < m.this.f7229f.size(); i2++) {
                    ((n) m.this.f7229f.get(i2)).n();
                }
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> still foreground.");
        }
    }

    private m() {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.f7227d = true;
        a aVar = this.f7230g;
        if (aVar != null) {
            this.f7228e.removeCallbacks(aVar);
            this.f7228e.postDelayed(this.f7230g, 3000L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.f7227d = false;
        this.f7226c = true;
        a aVar = this.f7230g;
        if (aVar != null) {
            this.f7228e.removeCallbacks(aVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public synchronized void b(n nVar) {
        if (nVar != null) {
            for (int i2 = 0; i2 < this.f7229f.size(); i2++) {
                if (this.f7229f.get(i2) == nVar) {
                    this.f7229f.remove(i2);
                }
            }
        }
    }

    public static void a(Context context) {
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(a);
        }
    }

    public static m a() {
        return a;
    }

    public synchronized void a(n nVar) {
        if (nVar != null) {
            this.f7229f.add(nVar);
        }
    }
}
