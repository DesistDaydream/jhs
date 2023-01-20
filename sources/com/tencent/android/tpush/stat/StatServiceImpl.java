package com.tencent.android.tpush.stat;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.event.Event;
import com.tencent.android.tpush.stat.event.MQTTEvent;
import com.tencent.android.tpush.stat.event.c;
import com.tencent.android.tpush.stat.event.h;
import com.tencent.android.tpush.stat.lifecycle.MtaActivityLifeCycle;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class StatServiceImpl {
    private static Map<String, Long> b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private static volatile Handler f6379c = null;

    /* renamed from: d  reason: collision with root package name */
    private static volatile int f6380d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static volatile String f6381e = "";

    /* renamed from: f  reason: collision with root package name */
    private static volatile String f6382f = "";

    /* renamed from: g  reason: collision with root package name */
    private static com.tencent.android.tpush.stat.b.c f6383g = com.tencent.android.tpush.stat.b.b.b();

    /* renamed from: h  reason: collision with root package name */
    private static volatile boolean f6384h = false;

    /* renamed from: i  reason: collision with root package name */
    private static volatile boolean f6385i = true;

    /* renamed from: j  reason: collision with root package name */
    private static Handler f6386j = null;

    /* renamed from: k  reason: collision with root package name */
    private static volatile Runnable f6387k = null;

    /* renamed from: l  reason: collision with root package name */
    private static long f6388l = 0;

    /* renamed from: m  reason: collision with root package name */
    private static List<c> f6389m = new CopyOnWriteArrayList();
    private static long n = 800;
    private static volatile long o = -1;
    private static Context p = null;
    public static volatile long a = 0;
    private static String q = null;
    private static volatile SharedPreferences r = null;
    private static volatile SharedPreferences s = null;
    private static volatile SharedPreferences t = null;
    public static volatile boolean storedList = true;
    private static AtomicInteger u = new AtomicInteger(0);
    private static final Integer v = 3;
    private static AtomicBoolean w = new AtomicBoolean(false);

    public static void checkAppLunch(Context context) {
        Application application;
        try {
            if (context instanceof Application) {
                application = (Application) context;
            } else if (context instanceof Activity) {
                application = ((Activity) context).getApplication();
            } else {
                application = (Application) context;
            }
            boolean isMainProcess = Util.isMainProcess(application);
            if (application == null || !isMainProcess || w.get()) {
                return;
            }
            MtaActivityLifeCycle.registerActivityLifecycleCallbacks(application, new com.tencent.android.tpush.stat.lifecycle.a() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.8
                @Override // com.tencent.android.tpush.stat.lifecycle.a
                public void a(Activity activity) {
                }

                @Override // com.tencent.android.tpush.stat.lifecycle.a
                public void a(Activity activity, Bundle bundle) {
                }

                @Override // com.tencent.android.tpush.stat.lifecycle.a
                public void b(Activity activity, Bundle bundle) {
                    com.tencent.android.tpush.stat.a.a.b(activity, "onActivityCreated");
                }

                @Override // com.tencent.android.tpush.stat.lifecycle.a
                public void c(Activity activity) {
                }

                @Override // com.tencent.android.tpush.stat.lifecycle.a
                public void d(Activity activity) {
                    com.tencent.android.tpush.stat.a.a.a(activity, "onActivityPaused");
                }

                @Override // com.tencent.android.tpush.stat.lifecycle.a
                public void e(Activity activity) {
                    com.tencent.android.tpush.stat.a.a.a(activity, "onActivityDestroyed");
                }

                @Override // com.tencent.android.tpush.stat.lifecycle.a
                public void b(Activity activity) {
                    com.tencent.android.tpush.stat.a.a.b(activity, "onActivityStarted");
                }
            });
            w.set(true);
        } catch (Throwable unused) {
            TLogger.d("stat", "unexpected for checkAppLunch");
        }
    }

    public static boolean commitEvents(Context context, int i2) {
        if (d.c()) {
            if (d.b()) {
                com.tencent.android.tpush.stat.b.c cVar = f6383g;
                cVar.b("commitEvents, maxNumber=" + i2);
            }
            Context context2 = getContext(context);
            if (context2 == null) {
                f6383g.e("The Context of StatService.commitEvents() can not be null!");
                return false;
            } else if (i2 >= -1 && i2 != 0) {
                if (b.a(context2).c() && getHandler(context2) != null) {
                    f6379c.post(new Runnable() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.13
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                StatServiceImpl.b();
                            } catch (Throwable th) {
                                StatServiceImpl.f6383g.b(th);
                            }
                        }
                    });
                    return true;
                }
                return false;
            } else {
                f6383g.e("The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
                return false;
            }
        }
        return false;
    }

    public static Context getContext(Context context) {
        return context != null ? context : p;
    }

    public static Handler getHandler(Context context) {
        if (f6379c == null) {
            synchronized (StatServiceImpl.class) {
                if (f6379c == null) {
                    init(context);
                }
            }
        }
        return f6379c;
    }

    public static void inerTrackBeginPage(final Context context, String str, final long j2) {
        if (str == null) {
            return;
        }
        final String str2 = new String(str);
        if (getHandler(context) != null) {
            f6379c.post(new Runnable() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        synchronized (StatServiceImpl.b) {
                            if (StatServiceImpl.b.size() >= d.f()) {
                                com.tencent.android.tpush.stat.b.c cVar = StatServiceImpl.f6383g;
                                cVar.e("The number of page events exceeds the maximum value " + Integer.toString(d.f()));
                                return;
                            }
                            String unused = StatServiceImpl.f6381e = str2;
                            if (!StatServiceImpl.b.containsKey(StatServiceImpl.f6381e)) {
                                StatServiceImpl.b.put(StatServiceImpl.f6381e, Long.valueOf(System.currentTimeMillis()));
                                StatServiceImpl.b(context, j2);
                                return;
                            }
                            com.tencent.android.tpush.stat.b.c cVar2 = StatServiceImpl.f6383g;
                            cVar2.f("Duplicate PageID : " + StatServiceImpl.f6381e + ", onResume() repeated?");
                        }
                    } catch (Throwable th) {
                        StatServiceImpl.f6383g.b(th);
                    }
                }
            });
        }
    }

    public static synchronized void init(Context context) {
        synchronized (StatServiceImpl.class) {
            if (context == null) {
                return;
            }
            checkAppLunch(context);
            if (f6379c == null) {
                if (!a(context)) {
                    return;
                }
                final Context applicationContext = context.getApplicationContext();
                p = applicationContext;
                HandlerThread handlerThread = new HandlerThread("XgStat");
                handlerThread.start();
                f6379c = new Handler(handlerThread.getLooper());
                f6379c.post(new TTask() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.1
                    @Override // com.tencent.tpns.baseapi.base.util.TTask
                    public void TRun() {
                        try {
                            b.a(StatServiceImpl.p).e();
                            com.tencent.android.tpush.stat.b.b.a(applicationContext, true);
                            f.b(applicationContext);
                            if (d.a() == StatReportStrategy.APP_LAUNCH) {
                                StatServiceImpl.commitEvents(applicationContext, -1);
                            }
                            if (d.b()) {
                                StatServiceImpl.f6383g.h("Init MTA StatService success.");
                            }
                            String d2 = com.tencent.android.tpush.stat.b.b.d(StatServiceImpl.p);
                            String str = ((d2 == null || d2.trim().length() == 0) ? "default" : "default") + ".xg.stat.";
                            SharedPreferences unused = StatServiceImpl.r = applicationContext.getSharedPreferences("." + str, 0);
                            SharedPreferences unused2 = StatServiceImpl.s = applicationContext.getSharedPreferences("." + str + ".err.", 0);
                            SharedPreferences unused3 = StatServiceImpl.t = applicationContext.getSharedPreferences("." + str + ".custom.", 0);
                        } catch (Throwable th) {
                            StatServiceImpl.f6383g.f("stat init error:");
                            StatServiceImpl.f6383g.b(th);
                        }
                    }
                });
            }
        }
    }

    public static void initAutoStats(Context context, long j2) {
        Application application;
        try {
            if (context instanceof Application) {
                application = (Application) context;
            } else if (context instanceof Activity) {
                application = ((Activity) context).getApplication();
            } else {
                application = (Application) context;
            }
            if (application != null) {
                a(application, j2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void reportEvent(Context context, final Event event) {
        if (d.c()) {
            if (p == null) {
                init(context);
            }
            if (getHandler(getContext(context)) != null) {
                f6379c.post(new Runnable() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.9
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            StatServiceImpl.a(Event.this);
                        } catch (Throwable th) {
                            StatServiceImpl.f6383g.b(th);
                        }
                    }
                });
            }
        }
    }

    public static void reportXGEvent(Context context, final Event event) {
        if (!d.c()) {
            TLogger.w("stat", "disable stat service");
            return;
        }
        Context context2 = getContext(context);
        if (context2 == null) {
            f6383g.e("The Context of StatService.trackCustomEvent() can not be null!");
        } else if (getHandler(context2) != null) {
            f6379c.post(new Runnable() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.10
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        StatServiceImpl.a(Event.this);
                    } catch (Throwable th) {
                        StatServiceImpl.f6383g.b(th);
                    }
                }
            });
        }
    }

    public static void send3rdCaughtException(Context context, String str, Throwable th) {
        a(context, 30, str, th);
    }

    public static boolean sendLocalMsg(Context context, int i2) {
        if (d.c()) {
            if (d.b()) {
                com.tencent.android.tpush.stat.b.c cVar = f6383g;
                cVar.b("commitEvents, maxNumber=" + i2);
            }
            Context context2 = getContext(context);
            if (context2 == null) {
                f6383g.e("The Context of StatService.commitEvents() can not be null!");
                return false;
            } else if (i2 >= -1 && i2 != 0) {
                if (b.a(context2).c()) {
                    com.tencent.android.tpush.stat.b.c cVar2 = f6383g;
                    cVar2.b("sendLocalMsg, maxNumber=" + i2);
                    if (getHandler(context2) != null) {
                        f6379c.post(new Runnable() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.14
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    StatServiceImpl.b();
                                } catch (Throwable th) {
                                    StatServiceImpl.f6383g.b(th);
                                }
                            }
                        });
                        return true;
                    }
                    return false;
                }
                return false;
            } else {
                f6383g.e("The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
                return false;
            }
        }
        return false;
    }

    public static void sendTryCatchException(Context context, String str, Throwable th) {
        a(context, 1, str, th);
    }

    public static void setContext(Context context) {
        if (context != null) {
            p = context.getApplicationContext();
        }
    }

    public static void setCrashMatchString(String str) {
        q = str;
    }

    public static void setupExceptionHandler(Context context) {
        try {
            a.a(context).a();
        } catch (Throwable th) {
            f6383g.b(th);
        }
    }

    public static void trackBeginPage(Context context, String str, long j2) {
        if (d.c()) {
            Context context2 = getContext(context);
            if (context2 != null && str != null && str.length() != 0) {
                inerTrackBeginPage(context2, str, j2);
            } else {
                f6383g.e("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
            }
        }
    }

    public static void trackCustomKVEvent(Context context, final String str, Properties properties) {
        if (d.c()) {
            final Context context2 = getContext(context);
            if (context2 == null) {
                f6383g.e("The Context of StatService.trackCustomEvent() can not be null!");
            } else if (a(str)) {
                f6383g.e("The event_id of StatService.trackCustomEvent() can not be null or empty.");
            } else {
                final c.a aVar = new c.a(str, null, properties);
                if (getHandler(context2) != null) {
                    f6379c.post(new Runnable() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.12
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                com.tencent.android.tpush.stat.event.c cVar = new com.tencent.android.tpush.stat.event.c(context2, 0, str, XGApiConfig.getAccessId(context2), System.currentTimeMillis());
                                cVar.a().f6461c = aVar.f6461c;
                                StatServiceImpl.a(cVar);
                            } catch (Throwable th) {
                                StatServiceImpl.f6383g.b(th);
                            }
                        }
                    });
                }
            }
        }
    }

    public static void trackEndPage(Context context, String str, long j2) {
        if (d.c()) {
            Context context2 = getContext(context);
            if (context2 != null && str != null && str.length() != 0) {
                b(context2, str, j2, 0L, 0L);
            } else {
                f6383g.e("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
            }
        }
    }

    public static void trackLaunchEvent(Context context, final int i2, final int i3, final long j2) {
        if (d.c()) {
            final Context context2 = getContext(context);
            if (context2 == null) {
                f6383g.e("The Context of StatService.trackCustomEvent() can not be null!");
            } else if (getHandler(context2) != null) {
                f6379c.post(new Runnable() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.11
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            StatServiceImpl.a(new com.tencent.android.tpush.stat.event.e(context2, i2, i3, j2));
                        } catch (Throwable th) {
                            StatServiceImpl.f6383g.b(th);
                        }
                    }
                });
            }
        }
    }

    private static int e(List<?> list) {
        if (list != null && !list.isEmpty()) {
            try {
                Object obj = list.get(0);
                if (obj instanceof Event) {
                    if (obj instanceof MQTTEvent) {
                        f6383g.d("a stat instance MQTTEvent event");
                        return 1;
                    } else if (obj instanceof com.tencent.android.tpush.stat.event.c) {
                        f6383g.d("a stat instance custom event");
                        return 2;
                    } else {
                        f6383g.d("other instance ErrorEvent or other");
                        return 0;
                    }
                }
                JSONObject jSONObject = new JSONObject((String) obj);
                String optString = jSONObject.optString("msgId", "");
                if (optString != null && optString.length() > 0) {
                    com.tencent.android.tpush.stat.b.c cVar = f6383g;
                    cVar.d("a stat string event msgId: " + optString);
                    return 1;
                } else if (jSONObject.has("customEvent")) {
                    f6383g.d(" string customEvent");
                    return 2;
                } else {
                    f6383g.d("other string ");
                    return 0;
                }
            } catch (Throwable th) {
                com.tencent.android.tpush.stat.b.c cVar2 = f6383g;
                cVar2.d("distinguish event error" + th.toString());
            }
        }
        return 0;
    }

    public static synchronized void d(List<?> list) {
        synchronized (StatServiceImpl.class) {
            if (list != null) {
                try {
                    if (r != null && s != null && t != null) {
                        com.tencent.android.tpush.stat.b.c cVar = f6383g;
                        cVar.h("update event size:" + list.size());
                        int e2 = e(list);
                        if (e2 == 1) {
                            a(r, list);
                        } else if (e2 != 2) {
                            a(s, list);
                        } else {
                            a(t, list);
                        }
                    }
                } finally {
                }
            }
        }
    }

    public static synchronized void c(List<?> list) {
        synchronized (StatServiceImpl.class) {
            if (list != null) {
                try {
                    if (r != null && s != null && t != null) {
                        com.tencent.android.tpush.stat.b.c cVar = f6383g;
                        cVar.h("delete event size:" + list.size());
                        int e2 = e(list);
                        if (e2 == 1) {
                            b(list, r);
                        } else if (e2 != 2) {
                            b(list, s);
                        } else {
                            b(list, t);
                        }
                    }
                } finally {
                }
            }
        }
    }

    public static boolean a(Context context) {
        boolean z;
        long a2 = com.tencent.android.tpush.stat.b.d.a(context, d.f6437c, 0L);
        long b2 = com.tencent.android.tpush.stat.b.b.b("2.0.6");
        if (b2 <= a2) {
            com.tencent.android.tpush.stat.b.c cVar = f6383g;
            cVar.e("MTA is disable for current version:" + b2 + ",wakeup version:" + a2);
            z = false;
        } else {
            z = true;
        }
        d.b(z);
        return z;
    }

    public static int b(Context context, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (a == 0) {
            a = com.tencent.android.tpush.stat.b.d.a(p, "_INTER_MTA_NEXT_DAY", 0L);
        }
        if (f6380d == 0 || currentTimeMillis >= a) {
            f6380d = com.tencent.android.tpush.stat.b.b.a();
            a = com.tencent.android.tpush.stat.b.b.c();
            com.tencent.android.tpush.stat.b.d.b(p, "_INTER_MTA_NEXT_DAY", a);
            a(context, j2);
        }
        return f6380d;
    }

    public static void trackEndPage(Context context, String str, long j2, long j3, long j4) {
        if (d.c()) {
            Context context2 = getContext(context);
            if (context2 != null && str != null && str.length() != 0) {
                b(context2, str, j2, j3, j4);
            } else {
                f6383g.e("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
            }
        }
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            int i2 = d.b.f6449d;
            if (i2 != 0) {
                jSONObject2.put("v", i2);
            }
            jSONObject.put(Integer.toString(d.b.a), jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            int i3 = d.a.f6449d;
            if (i3 != 0) {
                jSONObject3.put("v", i3);
            }
            jSONObject.put(Integer.toString(d.a.a), jSONObject3);
        } catch (JSONException e2) {
            f6383g.b((Throwable) e2);
        }
        return jSONObject;
    }

    public static void b(final Event event) {
        f.b(p).a(event, new e() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.16
            @Override // com.tencent.android.tpush.stat.e
            public void a() {
                StatServiceImpl.u.set(0);
            }

            @Override // com.tencent.android.tpush.stat.e
            public void b() {
                if (StatServiceImpl.u.getAndIncrement() >= StatServiceImpl.v.intValue()) {
                    StatServiceImpl.u.set(0);
                    StatServiceImpl.b(Arrays.asList(Event.this));
                    return;
                }
                CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.16.1
                    @Override // com.tencent.tpns.baseapi.base.util.TTask
                    public void TRun() {
                        StatServiceImpl.b(Event.this);
                    }
                }, StatServiceImpl.u.get() * 1000);
            }
        });
    }

    private static void b(List<?> list, SharedPreferences sharedPreferences) {
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                edit.remove(it.next().toString());
            }
            edit.commit();
        } catch (Throwable th) {
            f6383g.b(th);
        }
    }

    public static void a(Context context, long j2) {
        a(new h(context, f6380d, a(), j2));
    }

    public static synchronized void b(List<?> list) {
        synchronized (StatServiceImpl.class) {
            if (list != null) {
                try {
                    if (r != null && s != null && t != null) {
                        storedList = true;
                        com.tencent.android.tpush.stat.b.c cVar = f6383g;
                        cVar.h("store event size:" + list.size());
                        int e2 = e(list);
                        if (e2 == 1) {
                            a(list, r);
                        } else if (e2 != 2) {
                            a(list, s);
                        } else {
                            a(list, t);
                        }
                    }
                } finally {
                }
            }
        }
    }

    public static void a(final List<Event> list) {
        if (b.a(p).c()) {
            f.b(p).b(list, new e() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.15
                @Override // com.tencent.android.tpush.stat.e
                public void a() {
                }

                @Override // com.tencent.android.tpush.stat.e
                public void b() {
                    com.tencent.android.tpush.stat.b.c cVar = StatServiceImpl.f6383g;
                    cVar.f("onDispatchFailure sentEventList size:" + list.size());
                    StatServiceImpl.b(list);
                }
            });
        } else {
            b(list);
        }
    }

    public static void a(Event event) {
        if (b.a(p).c()) {
            if (storedList) {
                storedList = !sendLocalMsg(p, 100);
            }
            b(event);
            return;
        }
        b(Arrays.asList(event));
    }

    private static void a(List<?> list, SharedPreferences sharedPreferences) {
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                edit.putInt(it.next().toString(), 1);
            }
            edit.commit();
        } catch (Throwable th) {
            f6383g.b(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Context context, String str, final long j2, final long j3, final long j4) {
        if (str == null) {
            return;
        }
        final String str2 = new String(str);
        if (getHandler(context) != null) {
            f6379c.post(new Runnable() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    Long l2;
                    try {
                        synchronized (StatServiceImpl.b) {
                            l2 = (Long) StatServiceImpl.b.remove(str2);
                        }
                        if (l2 == null) {
                            com.tencent.android.tpush.stat.b.c cVar = StatServiceImpl.f6383g;
                            cVar.f("Starttime for PageID:" + str2 + " not found, lost onResume()?");
                            return;
                        }
                        Long valueOf = Long.valueOf((System.currentTimeMillis() - l2.longValue()) / 1000);
                        if (valueOf.longValue() <= 0) {
                            valueOf = 1L;
                        }
                        String str3 = StatServiceImpl.f6382f;
                        if (str3 != null && str3.equals(str2)) {
                            str3 = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
                        }
                        Context context2 = context;
                        com.tencent.android.tpush.stat.event.f fVar = new com.tencent.android.tpush.stat.event.f(context2, str3, str2, StatServiceImpl.b(context2, j2), valueOf.longValue(), j2);
                        long j5 = j3;
                        if (j5 > 0) {
                            fVar.a = j5;
                        }
                        long j6 = j4;
                        if (j6 > 0) {
                            fVar.a = j6;
                        }
                        if (!str2.equals(StatServiceImpl.f6381e)) {
                            StatServiceImpl.f6383g.c("Invalid invocation since previous onResume on diff page.");
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(fVar);
                        StatServiceImpl.a(arrayList);
                        String unused = StatServiceImpl.f6382f = str2;
                    } catch (Throwable th) {
                        StatServiceImpl.f6383g.b(th);
                    }
                }
            });
        }
    }

    public static synchronized void b() {
        synchronized (StatServiceImpl.class) {
            if (r != null) {
                a(r);
            }
            if (s != null) {
                a(s);
            }
            if (t != null) {
                a(t);
            }
        }
    }

    private static void a(SharedPreferences sharedPreferences, List<?> list) {
        if (sharedPreferences == null) {
            return;
        }
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                String obj = it.next().toString();
                int i2 = sharedPreferences.getInt(obj, 1);
                if (i2 > 0 && i2 <= d.e()) {
                    edit.putInt(obj, i2 + 1);
                } else {
                    edit.remove(obj);
                }
            }
            edit.commit();
        } catch (Throwable th) {
            f6383g.b(th);
        }
    }

    public static void a(final List<String> list, List<String> list2) {
        if (list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            return;
        }
        f.b(p).b(list2, new e() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.2
            @Override // com.tencent.android.tpush.stat.e
            public void a() {
                StatServiceImpl.c(list);
            }

            @Override // com.tencent.android.tpush.stat.e
            public void b() {
                StatServiceImpl.d(list);
            }
        });
    }

    public static void a(Context context, long j2, boolean z) {
        try {
            com.tencent.android.tpush.stat.b.c cVar = f6383g;
            cVar.h("trackBackground lastForegroundTs:" + o);
            if (o > 0) {
                double currentTimeMillis = ((System.currentTimeMillis() - o) - n) / 1000.0d;
                if (currentTimeMillis <= 0.0d) {
                    currentTimeMillis = 0.1d;
                }
                a(p, currentTimeMillis, j2, z);
            }
        } catch (Throwable th) {
            f6383g.b(th);
        }
        o = -1L;
    }

    private static void a(Context context, final double d2, final long j2, boolean z) {
        if (d.c()) {
            final Context context2 = getContext(context);
            if (context2 == null) {
                f6383g.e("The Context of StatService.trackBackground() can not be null!");
            } else if (getHandler(context2) != null) {
                f6379c.post(new Runnable() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            com.tencent.android.tpush.stat.b.c cVar = StatServiceImpl.f6383g;
                            cVar.b("trackBackground duration:" + d2);
                            double d3 = d2;
                            if (d3 <= 0.0d) {
                                d3 = 0.1d;
                            }
                            com.tencent.android.tpush.stat.event.a aVar = new com.tencent.android.tpush.stat.event.a(StatServiceImpl.getContext(context2), StatServiceImpl.b(context2, j2), d3, j2);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(aVar);
                            StatServiceImpl.a(arrayList);
                        } catch (Throwable th) {
                            StatServiceImpl.f6383g.b(th);
                        }
                    }
                });
            }
        }
    }

    public static void a(SharedPreferences sharedPreferences) {
        try {
            Map<String, ?> all = sharedPreferences.getAll();
            if (all != null) {
                com.tencent.android.tpush.stat.b.c cVar = f6383g;
                cVar.a("sendLocalEvent " + all.size());
            }
            if (all == null || all.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(10);
            ArrayList arrayList2 = new ArrayList(10);
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                JSONObject jSONObject = new JSONObject(entry.getKey());
                jSONObject.put("rtTms", entry.getValue());
                arrayList2.add(jSONObject.toString());
                arrayList.add(entry.getKey());
                if (arrayList.size() == 10) {
                    a(arrayList, arrayList2);
                    arrayList.clear();
                }
            }
            a(arrayList, arrayList2);
            arrayList.clear();
        } catch (Throwable th) {
            com.tencent.android.tpush.stat.b.c cVar2 = f6383g;
            cVar2.f("sendLocalEvent error: " + th.toString());
        }
    }

    public static void a(Context context, Throwable th) {
        a(context, 2, (String) null, th);
    }

    private static void a(Context context, int i2, String str, Throwable th) {
        a(context, i2, str, com.tencent.android.tpush.stat.b.b.a(th));
    }

    private static void a(Context context, int i2, String str, JSONArray jSONArray) {
        if (d.c()) {
            Context context2 = getContext(context);
            if (context2 == null) {
                f6383g.e("The Context of StatService.sendCrashEvent() can not be null!");
                return;
            }
            try {
                com.tencent.android.tpush.stat.event.d dVar = new com.tencent.android.tpush.stat.event.d(context2, 0, i2, jSONArray, XGPushConfig.getAccessId(context));
                dVar.a(str);
                if (!dVar.a()) {
                    f6383g.c("not contains sdk info.");
                    f6383g.c(jSONArray);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(dVar);
                b(arrayList);
            } catch (Throwable th) {
                f6383g.b(th);
            }
        }
    }

    private static void a(c cVar) {
        f6389m.add(cVar);
    }

    private static void a(Application application, final long j2) {
        if (application == null || Build.VERSION.SDK_INT < 14) {
            return;
        }
        Context b2 = com.tencent.android.tpush.stat.b.e.b(application);
        p = b2;
        getHandler(b2);
        if (f6386j == null) {
            f6386j = new Handler();
        }
        synchronized (StatServiceImpl.class) {
            com.tencent.android.tpush.stat.lifecycle.a aVar = new com.tencent.android.tpush.stat.lifecycle.a() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.6
                @Override // com.tencent.android.tpush.stat.lifecycle.a
                public void a(Activity activity) {
                }

                @Override // com.tencent.android.tpush.stat.lifecycle.a
                public void a(Activity activity, Bundle bundle) {
                }

                @Override // com.tencent.android.tpush.stat.lifecycle.a
                public void b(Activity activity) {
                }

                @Override // com.tencent.android.tpush.stat.lifecycle.a
                public void b(Activity activity, Bundle bundle) {
                }

                @Override // com.tencent.android.tpush.stat.lifecycle.a
                public void c(Activity activity) {
                    if (d.c()) {
                        StatServiceImpl.inerTrackBeginPage(activity, com.tencent.android.tpush.stat.b.b.h(activity), j2);
                        boolean unused = StatServiceImpl.f6385i = false;
                        boolean z = !StatServiceImpl.f6384h;
                        boolean unused2 = StatServiceImpl.f6384h = true;
                        if (StatServiceImpl.f6387k != null) {
                            StatServiceImpl.f6386j.removeCallbacks(StatServiceImpl.f6387k);
                        }
                        if (z) {
                            StatServiceImpl.f6383g.b("went foreground");
                            long unused3 = StatServiceImpl.f6388l = System.currentTimeMillis();
                            for (c cVar : StatServiceImpl.f6389m) {
                                try {
                                    cVar.a();
                                } catch (Throwable th) {
                                    th.printStackTrace();
                                }
                            }
                            return;
                        }
                        StatServiceImpl.f6383g.b("still foreground");
                    }
                }

                @Override // com.tencent.android.tpush.stat.lifecycle.a
                public void d(Activity activity) {
                    if (d.c()) {
                        StatServiceImpl.b(activity, com.tencent.android.tpush.stat.b.b.h(activity), j2, 0L, 0L);
                        boolean unused = StatServiceImpl.f6385i = true;
                        if (StatServiceImpl.f6387k != null) {
                            StatServiceImpl.f6386j.removeCallbacks(StatServiceImpl.f6387k);
                        }
                        StatServiceImpl.f6386j.postDelayed(StatServiceImpl.f6387k = new Runnable() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    if (!StatServiceImpl.f6384h || !StatServiceImpl.f6385i) {
                                        StatServiceImpl.f6383g.b("still foreground");
                                        return;
                                    }
                                    StatServiceImpl.f6383g.b("went background");
                                    for (c cVar : StatServiceImpl.f6389m) {
                                        cVar.b();
                                    }
                                    boolean unused2 = StatServiceImpl.f6384h = false;
                                } catch (Throwable th) {
                                    StatServiceImpl.f6383g.b(th);
                                }
                            }
                        }, StatServiceImpl.n);
                    }
                }

                @Override // com.tencent.android.tpush.stat.lifecycle.a
                public void e(Activity activity) {
                }
            };
            a(new c() { // from class: com.tencent.android.tpush.stat.StatServiceImpl.7
                @Override // com.tencent.android.tpush.stat.c
                public void a() {
                    long unused = StatServiceImpl.o = System.currentTimeMillis();
                }

                @Override // com.tencent.android.tpush.stat.c
                public void b() {
                    StatServiceImpl.a(StatServiceImpl.p, j2, com.tencent.android.tpush.common.d.a());
                }
            });
            MtaActivityLifeCycle.registerActivityLifecycleCallbacks(application, aVar);
        }
    }
}
