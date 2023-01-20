package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.msdk.api.reward.RewardItem;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.e;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class l {
    public static String a;
    public boolean b;

    /* renamed from: c */
    public boolean f7220c;

    /* renamed from: f */
    public com.umeng.analytics.vshelper.a f7221f;

    /* renamed from: g */
    public Application.ActivityLifecycleCallbacks f7222g;

    /* renamed from: h */
    private final Map<String, Long> f7223h;

    /* renamed from: l */
    private boolean f7224l;

    /* renamed from: m */
    private int f7225m;
    private int n;

    /* renamed from: i */
    private static JSONArray f7217i = new JSONArray();

    /* renamed from: j */
    private static Object f7218j = new Object();

    /* renamed from: k */
    private static Application f7219k = null;

    /* renamed from: d */
    public static String f7215d = null;

    /* renamed from: e */
    public static int f7216e = -1;
    private static boolean o = true;
    private static Object p = new Object();
    private static ar q = new com.umeng.analytics.vshelper.b();

    /* loaded from: classes3.dex */
    public static class a {
        private static final l a = new l();

        private a() {
        }
    }

    public static /* synthetic */ int a(l lVar) {
        int i2 = lVar.n;
        lVar.n = i2 - 1;
        return i2;
    }

    public static /* synthetic */ int b(l lVar) {
        int i2 = lVar.f7225m;
        lVar.f7225m = i2 - 1;
        return i2;
    }

    public static /* synthetic */ int e(l lVar) {
        int i2 = lVar.n;
        lVar.n = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int f(l lVar) {
        int i2 = lVar.f7225m;
        lVar.f7225m = i2 + 1;
        return i2;
    }

    private void g() {
        if (this.f7224l) {
            return;
        }
        this.f7224l = true;
        if (f7219k == null || Build.VERSION.SDK_INT < 14) {
            return;
        }
        f7219k.registerActivityLifecycleCallbacks(this.f7222g);
    }

    private l() {
        this.f7223h = new HashMap();
        this.f7224l = false;
        this.b = false;
        this.f7220c = false;
        this.f7225m = 0;
        this.n = 0;
        this.f7221f = PageNameMonitor.getInstance();
        this.f7222g = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.l.1
            {
                l.this = this;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                l.q.a(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                    synchronized (l.p) {
                        if (l.o) {
                            return;
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger disabled.");
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.this.c(activity);
                    com.umeng.analytics.b.a().i();
                    l.this.b = false;
                    l.q.d(activity);
                } else if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                    com.umeng.analytics.b.a().i();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                    synchronized (l.p) {
                        if (l.o) {
                            boolean unused = l.o = false;
                        }
                    }
                    l.this.a(activity);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                    l.this.a(activity);
                }
                l.q.c(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (activity != null) {
                    if (l.this.f7225m <= 0) {
                        if (l.f7215d == null) {
                            l.f7215d = UUID.randomUUID().toString();
                        }
                        if (l.f7216e == -1) {
                            l.f7216e = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (l.f7216e == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("activityName", activity.toString());
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            com.umeng.analytics.b a2 = com.umeng.analytics.b.a();
                            if (a2 != null) {
                                a2.a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) hashMap);
                            }
                            l.f7216e = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, j.ar);
                            }
                        } else if (l.f7216e == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("pairUUID", l.f7215d);
                            hashMap2.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap2.put("activityName", activity.toString());
                            if (com.umeng.analytics.b.a() != null) {
                                com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) hashMap2);
                            }
                        }
                    }
                    if (l.this.n < 0) {
                        l.e(l.this);
                    } else {
                        l.f(l.this);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                MobclickAgent.PageMode pageMode = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION;
                MobclickAgent.PageMode pageMode2 = MobclickAgent.PageMode.AUTO;
                if (activity != null) {
                    if (activity.isChangingConfigurations()) {
                        l.a(l.this);
                        return;
                    }
                    l.b(l.this);
                    if (l.this.f7225m <= 0) {
                        if (l.f7216e == 0 && UMUtils.isMainProgress(activity)) {
                            return;
                        }
                        int i2 = l.f7216e;
                        if ((i2 == 1 || (i2 == 0 && !UMUtils.isMainProgress(activity))) && activity != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("pairUUID", l.f7215d);
                            hashMap.put(RewardItem.KEY_REASON, "Normal");
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap.put("activityName", activity.toString());
                            com.umeng.analytics.b a2 = com.umeng.analytics.b.a();
                            if (a2 != null) {
                                a2.a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
                            }
                            if (l.f7215d != null) {
                                l.f7215d = null;
                            }
                        }
                    }
                }
            }
        };
        synchronized (this) {
            if (f7219k != null) {
                g();
            }
        }
    }

    public void c() {
        c((Activity) null);
        b();
    }

    public void b(Context context) {
        synchronized (p) {
            if (o) {
                o = false;
                Activity globleActivity = DeviceConfig.getGlobleActivity(context);
                if (globleActivity == null) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 无前台Activity，直接退出。");
                    return;
                }
                String localClassName = globleActivity.getLocalClassName();
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 补救成功，前台Activity名：" + localClassName);
                a(globleActivity);
                return;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: firstResumeCall = false，直接返回。");
        }
    }

    public static void c(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f7218j) {
                    jSONArray = f7217i.toString();
                    f7217i = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put(e.d.a.f7167c, new JSONArray(jSONArray));
                    i.a(context).a(u.a().c(), jSONObject, i.a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean a() {
        return this.f7224l;
    }

    public static synchronized l a(Context context) {
        l lVar;
        synchronized (l.class) {
            if (f7219k == null && context != null) {
                if (context instanceof Activity) {
                    f7219k = ((Activity) context).getApplication();
                } else if (context instanceof Application) {
                    f7219k = (Application) context;
                }
            }
            lVar = a.a;
        }
        return lVar;
    }

    public static void a(Context context, String str) {
        if (f7216e == 1 && UMUtils.isMainProgress(context)) {
            HashMap hashMap = new HashMap();
            hashMap.put("pairUUID", f7215d);
            hashMap.put(RewardItem.KEY_REASON, str);
            if (f7215d != null) {
                f7215d = null;
            }
            if (context != null) {
                hashMap.put("pid", Integer.valueOf(Process.myPid()));
                hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
                hashMap.put("Context", context.toString());
                com.umeng.analytics.b.a().a(context, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
            }
        }
    }

    public void b() {
        this.f7224l = false;
        if (f7219k != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                f7219k.unregisterActivityLifecycleCallbacks(this.f7222g);
            }
            f7219k = null;
        }
    }

    public void c(Activity activity) {
        long j2;
        long j3;
        try {
            synchronized (this.f7223h) {
                if (a == null && activity != null) {
                    a = activity.getPackageName() + "." + activity.getLocalClassName();
                }
                j2 = 0;
                if (TextUtils.isEmpty(a) || !this.f7223h.containsKey(a)) {
                    j3 = 0;
                } else {
                    long longValue = this.f7223h.get(a).longValue();
                    this.f7223h.remove(a);
                    j2 = System.currentTimeMillis() - longValue;
                    j3 = longValue;
                }
            }
            synchronized (f7218j) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(d.v, a);
                    jSONObject.put("duration", j2);
                    jSONObject.put(d.x, j3);
                    jSONObject.put("type", 0);
                    f7217i.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private void b(Activity activity) {
        a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.f7223h) {
            this.f7223h.put(a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public void a(Activity activity) {
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                synchronized (p) {
                    com.umeng.analytics.b.a().h();
                }
            }
        } else if (activity != null) {
            String str = activity.getPackageName() + "." + activity.getLocalClassName();
            this.f7221f.activityResume(str);
            if (this.b) {
                this.b = false;
                if (!TextUtils.isEmpty(a)) {
                    if (a.equals(str)) {
                        return;
                    }
                    b(activity);
                    synchronized (p) {
                        com.umeng.analytics.b.a().h();
                    }
                    return;
                }
                a = str;
                return;
            }
            b(activity);
            synchronized (p) {
                com.umeng.analytics.b.a().h();
            }
        }
    }
}
