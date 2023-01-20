package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.bykvm_19do;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {
    private static bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.d s;
    private Application a;
    private Context b;

    /* renamed from: g  reason: collision with root package name */
    private String f1192g;

    /* renamed from: h  reason: collision with root package name */
    private long f1193h;

    /* renamed from: i  reason: collision with root package name */
    private String f1194i;

    /* renamed from: j  reason: collision with root package name */
    private long f1195j;

    /* renamed from: k  reason: collision with root package name */
    private String f1196k;

    /* renamed from: l  reason: collision with root package name */
    private long f1197l;

    /* renamed from: m  reason: collision with root package name */
    private String f1198m;
    private long n;
    private String o;
    private long p;
    private int q;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f1188c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private List<Long> f1189d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<String> f1190e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private List<Long> f1191f = new ArrayList();
    private final Application.ActivityLifecycleCallbacks r = new a();

    /* loaded from: classes.dex */
    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            b.this.f1192g = b.s == null ? activity.getClass().getName() : b.s.a(activity);
            b.this.f1193h = System.currentTimeMillis();
            b.this.f1188c.add(b.this.f1192g);
            b.this.f1189d.add(Long.valueOf(b.this.f1193h));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String name = b.s == null ? activity.getClass().getName() : b.s.a(activity);
            int indexOf = b.this.f1188c.indexOf(name);
            if (indexOf > -1 && indexOf < b.this.f1188c.size()) {
                b.this.f1188c.remove(indexOf);
                b.this.f1189d.remove(indexOf);
            }
            b.this.f1190e.add(name);
            b.this.f1191f.add(Long.valueOf(System.currentTimeMillis()));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            b.this.f1198m = b.s == null ? activity.getClass().getName() : b.s.a(activity);
            b.this.n = System.currentTimeMillis();
            b.h(b.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            b.this.f1196k = b.s == null ? activity.getClass().getName() : b.s.a(activity);
            b.this.f1197l = System.currentTimeMillis();
            b.g(b.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            b.this.f1194i = b.s == null ? activity.getClass().getName() : b.s.a(activity);
            b.this.f1195j = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            b.this.o = b.s == null ? activity.getClass().getName() : b.s.a(activity);
            b.this.p = System.currentTimeMillis();
        }
    }

    public b(@NonNull Context context) {
        this.b = context;
        if (context instanceof Application) {
            this.a = (Application) context;
        }
        f();
    }

    private JSONObject a(String str, long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("time", j2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private JSONArray d() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f1188c;
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < this.f1188c.size(); i2++) {
                try {
                    jSONArray.put(a(this.f1188c.get(i2), this.f1189d.get(i2).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f1190e;
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < this.f1190e.size(); i2++) {
                try {
                    jSONArray.put(a(this.f1190e.get(i2), this.f1191f.get(i2).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    private void f() {
        Application application;
        if (Build.VERSION.SDK_INT < 14 || (application = this.a) == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this.r);
    }

    public static /* synthetic */ int g(b bVar) {
        int i2 = bVar.q;
        bVar.q = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int h(b bVar) {
        int i2 = bVar.q;
        bVar.q = i2 - 1;
        return i2;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", a(this.f1192g, this.f1193h));
            jSONObject.put("last_start_activity", a(this.f1194i, this.f1195j));
            jSONObject.put("last_resume_activity", a(this.f1196k, this.f1197l));
            jSONObject.put("last_pause_activity", a(this.f1198m, this.n));
            jSONObject.put("last_stop_activity", a(this.o, this.p));
            jSONObject.put("alive_activities", d());
            jSONObject.put("finish_activities", e());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONArray b() {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        JSONArray jSONArray = new JSONArray();
        try {
            ActivityManager activityManager = (ActivityManager) this.b.getSystemService("activity");
            if (activityManager != null && (runningTasks = activityManager.getRunningTasks(5)) != null) {
                for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                    if (runningTaskInfo != null && runningTaskInfo.baseActivity != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("id", runningTaskInfo.id);
                            jSONObject.put("package_name", runningTaskInfo.baseActivity.getPackageName());
                            jSONObject.put(com.heytap.mcssdk.constant.b.f3341i, runningTaskInfo.description);
                            jSONObject.put("number_of_activities", runningTaskInfo.numActivities);
                            jSONObject.put("number_of_running_activities", runningTaskInfo.numRunning);
                            jSONObject.put("topActivity", runningTaskInfo.topActivity.toString());
                            jSONObject.put("baseActivity", runningTaskInfo.baseActivity.toString());
                            jSONArray.put(jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return jSONArray;
    }
}
