package d.a.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import cn.thinkingdata.android.ScreenAutoTracker;
import cn.thinkingdata.android.TDPresetProperties;
import cn.thinkingdata.android.ThinkingAnalyticsSDK;
import cn.thinkingdata.android.ThinkingDataAutoTrackAppViewScreenUrl;
import cn.thinkingdata.android.utils.TDLog;
import d.a.a.o.e;
import d.a.a.o.n;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class m implements Application.ActivityLifecycleCallbacks {

    /* renamed from: c  reason: collision with root package name */
    private final ThinkingAnalyticsSDK f9294c;

    /* renamed from: e  reason: collision with root package name */
    private c f9296e;

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<Activity> f9297f;
    private boolean a = false;
    private final Object b = new Object();

    /* renamed from: d  reason: collision with root package name */
    private volatile Boolean f9295d = Boolean.TRUE;

    /* renamed from: g  reason: collision with root package name */
    private final List<WeakReference<Activity>> f9298g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private boolean f9299h = false;

    /* loaded from: classes.dex */
    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (m.this.f9295d.booleanValue()) {
                m.this.f9295d = Boolean.FALSE;
                JSONObject jSONObject = new JSONObject();
                try {
                    List<String> list = TDPresetProperties.disableList;
                    if (!list.contains("#resume_from_background")) {
                        jSONObject.put("#resume_from_background", m.this.a);
                    }
                    if (!list.contains("#start_reason")) {
                        String c2 = m.this.c();
                        if (!c2.equals(new JSONObject().toString())) {
                            jSONObject.put("#start_reason", c2);
                        }
                    }
                } catch (JSONException unused) {
                } catch (Throwable th) {
                    m.this.f9294c.autoTrack("ta_app_start", jSONObject);
                    m.this.f9294c.flush();
                    m.this.f9299h = true;
                    throw th;
                }
                m.this.f9294c.autoTrack("ta_app_start", jSONObject);
                m.this.f9294c.flush();
                m.this.f9299h = true;
            }
        }
    }

    public m(ThinkingAnalyticsSDK thinkingAnalyticsSDK, String str) {
        this.f9294c = thinkingAnalyticsSDK;
    }

    public static JSONArray d(Object obj) {
        JSONArray jSONArray = new JSONArray();
        if (!obj.getClass().isArray()) {
            throw new JSONException("Not a primitive array: " + obj.getClass());
        }
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            jSONArray.put(j(Array.get(obj, i2)));
        }
        return jSONArray;
    }

    private void e(Activity activity, e eVar) {
        if (this.f9295d.booleanValue() || this.a) {
            if (this.f9294c.isAutoTrackEnabled()) {
                try {
                    if (!this.f9294c.isAutoTrackEventTypeIgnored(ThinkingAnalyticsSDK.AutoTrackEventType.APP_START)) {
                        this.f9295d = Boolean.FALSE;
                        JSONObject jSONObject = new JSONObject();
                        List<String> list = TDPresetProperties.disableList;
                        if (!list.contains("#resume_from_background")) {
                            jSONObject.put("#resume_from_background", this.a);
                        }
                        if (!list.contains("#start_reason")) {
                            String c2 = c();
                            if (!c2.equals(new JSONObject().toString())) {
                                jSONObject.put("#start_reason", c2);
                            }
                        }
                        n.u(jSONObject, activity);
                        c cVar = this.f9296e;
                        if (cVar != null) {
                            double parseDouble = Double.parseDouble(cVar.c());
                            if (parseDouble > 0.0d && !list.contains("#background_duration")) {
                                jSONObject.put("#background_duration", parseDouble);
                            }
                        }
                        if (eVar == null) {
                            this.f9294c.autoTrack("ta_app_start", jSONObject);
                        } else if (!this.f9294c.hasDisabled()) {
                            JSONObject autoTrackStartProperties = this.f9294c.getAutoTrackStartProperties();
                            n.v(jSONObject, autoTrackStartProperties, this.f9294c.mConfig.getDefaultTimeZone());
                            d.a.a.a aVar = new d.a.a.a(this.f9294c, cn.thinkingdata.android.utils.l.TRACK, autoTrackStartProperties, eVar);
                            aVar.a = "ta_app_start";
                            this.f9294c.trackInternal(aVar);
                        }
                    }
                    if (eVar == null && !this.f9294c.isAutoTrackEventTypeIgnored(ThinkingAnalyticsSDK.AutoTrackEventType.APP_END)) {
                        this.f9294c.timeEvent("ta_app_end");
                        this.f9299h = true;
                    }
                } catch (Exception e2) {
                    TDLog.i("ThinkingAnalytics.ThinkingDataActivityLifecycleCallbacks", e2);
                }
            }
            try {
                this.f9294c.appBecomeActive();
                this.f9296e = null;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    private boolean g(Activity activity, boolean z) {
        synchronized (this.b) {
            Iterator<WeakReference<Activity>> it = this.f9298g.iterator();
            while (it.hasNext()) {
                if (it.next().get() == activity) {
                    if (z) {
                        it.remove();
                    }
                    return false;
                }
            }
            return true;
        }
    }

    public static Object j(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(JSONObject.NULL)) {
            return obj;
        }
        if (obj instanceof Collection) {
            return new JSONArray((Collection) obj);
        }
        if (obj.getClass().isArray()) {
            return d(obj);
        }
        if (obj instanceof Map) {
            return new JSONObject((Map) obj);
        }
        if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof String)) {
            if (obj.getClass().getPackage().getName().startsWith("java.")) {
                return obj.toString();
            }
            return null;
        }
        return obj;
    }

    public String c() {
        Intent intent;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<Activity> weakReference = this.f9297f;
        if (weakReference != null && (intent = weakReference.get().getIntent()) != null) {
            String dataString = intent.getDataString();
            try {
                if (!TextUtils.isEmpty(dataString)) {
                    jSONObject.put("url", dataString);
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    for (String str : extras.keySet()) {
                        Object obj = extras.get(str);
                        Object j2 = j(obj);
                        if (j2 != null && j2 != JSONObject.NULL) {
                            jSONObject2.put(str, j(obj));
                        }
                    }
                    jSONObject.put("data", jSONObject2);
                }
            } catch (Exception unused) {
                return jSONObject.toString();
            }
        }
        return jSONObject.toString();
    }

    public void f(JSONObject jSONObject) {
        this.f9294c.autoTrack("ta_app_crash", jSONObject);
        this.f9294c.autoTrack("ta_app_end", new JSONObject());
        this.f9299h = false;
        this.f9294c.flush();
    }

    public boolean h(Context context) {
        try {
            Resources resources = context.getResources();
            return resources.getBoolean(resources.getIdentifier("TAEnableBackgroundStartEvent", "bool", context.getPackageName()));
        } catch (Exception unused) {
            return false;
        }
    }

    public void k() {
        synchronized (this.b) {
            if (this.f9295d.booleanValue() && this.f9294c.isAutoTrackEnabled()) {
                try {
                    if (!this.f9294c.isAutoTrackEventTypeIgnored(ThinkingAnalyticsSDK.AutoTrackEventType.APP_START) && (n.F(this.f9294c.mConfig.mContext) || h(this.f9294c.mConfig.mContext))) {
                        new Timer().schedule(new a(), 100L);
                    }
                } catch (Exception e2) {
                    TDLog.i("ThinkingAnalytics.ThinkingDataActivityLifecycleCallbacks", e2);
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        TDLog.i("ThinkingAnalytics.ThinkingDataActivityLifecycleCallbacks", "onActivityCreated");
        this.f9297f = new WeakReference<>(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        synchronized (this.b) {
            if (g(activity, false)) {
                TDLog.i("ThinkingAnalytics.ThinkingDataActivityLifecycleCallbacks", "onActivityPaused: the SDK was initialized after the onActivityStart of " + activity);
                this.f9298g.add(new WeakReference<>(activity));
                if (this.f9298g.size() == 1) {
                    e(activity, this.f9294c.getAutoTrackStartTime());
                    this.f9294c.flush();
                    this.f9295d = Boolean.FALSE;
                }
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        String url;
        ThinkingAnalyticsSDK thinkingAnalyticsSDK;
        synchronized (this.b) {
            if (g(activity, false)) {
                TDLog.i("ThinkingAnalytics.ThinkingDataActivityLifecycleCallbacks", "onActivityResumed: the SDK was initialized after the onActivityStart of " + activity);
                this.f9298g.add(new WeakReference<>(activity));
                if (this.f9298g.size() == 1) {
                    e(activity, this.f9294c.getAutoTrackStartTime());
                    this.f9294c.flush();
                    this.f9295d = Boolean.FALSE;
                }
            }
        }
        try {
            boolean z = !this.f9294c.isActivityAutoTrackAppViewScreenIgnored(activity.getClass());
            if (this.f9294c.isAutoTrackEnabled() && z && !this.f9294c.isAutoTrackEventTypeIgnored(ThinkingAnalyticsSDK.AutoTrackEventType.APP_VIEW_SCREEN)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (!TDPresetProperties.disableList.contains("#screen_name")) {
                        jSONObject.put("#screen_name", activity.getClass().getCanonicalName());
                    }
                    n.u(jSONObject, activity);
                    if (activity instanceof ScreenAutoTracker) {
                        ScreenAutoTracker screenAutoTracker = (ScreenAutoTracker) activity;
                        url = screenAutoTracker.getScreenUrl();
                        JSONObject trackProperties = screenAutoTracker.getTrackProperties();
                        if (trackProperties == null || !cn.thinkingdata.android.utils.g.b(trackProperties)) {
                            TDLog.d("ThinkingAnalytics.ThinkingDataActivityLifecycleCallbacks", "invalid properties: " + trackProperties);
                        } else {
                            n.v(trackProperties, jSONObject, this.f9294c.mConfig.getDefaultTimeZone());
                        }
                        thinkingAnalyticsSDK = this.f9294c;
                    } else {
                        ThinkingDataAutoTrackAppViewScreenUrl thinkingDataAutoTrackAppViewScreenUrl = (ThinkingDataAutoTrackAppViewScreenUrl) activity.getClass().getAnnotation(ThinkingDataAutoTrackAppViewScreenUrl.class);
                        if (thinkingDataAutoTrackAppViewScreenUrl == null || !(TextUtils.isEmpty(thinkingDataAutoTrackAppViewScreenUrl.appId()) || this.f9294c.getToken().equals(thinkingDataAutoTrackAppViewScreenUrl.appId()))) {
                            this.f9294c.autoTrack("ta_app_view", jSONObject);
                            return;
                        }
                        url = thinkingDataAutoTrackAppViewScreenUrl.url();
                        if (TextUtils.isEmpty(url)) {
                            url = activity.getClass().getCanonicalName();
                        }
                        thinkingAnalyticsSDK = this.f9294c;
                    }
                    thinkingAnalyticsSDK.trackViewScreenInternal(url, jSONObject);
                } catch (Exception e2) {
                    TDLog.i("ThinkingAnalytics.ThinkingDataActivityLifecycleCallbacks", e2);
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        TDLog.i("ThinkingAnalytics.ThinkingDataActivityLifecycleCallbacks", "onActivityStarted");
        this.f9297f = new WeakReference<>(activity);
        try {
            synchronized (this.b) {
                if (this.f9298g.size() == 0) {
                    e(activity, null);
                }
                if (g(activity, false)) {
                    this.f9298g.add(new WeakReference<>(activity));
                } else {
                    TDLog.w("ThinkingAnalytics.ThinkingDataActivityLifecycleCallbacks", "Unexpected state. The activity might not be stopped correctly: " + activity);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        ThinkingAnalyticsSDK thinkingAnalyticsSDK;
        String str;
        TDLog.i("ThinkingAnalytics.ThinkingDataActivityLifecycleCallbacks", "onActivityStopped");
        try {
            synchronized (this.b) {
                if (g(activity, true)) {
                    TDLog.i("ThinkingAnalytics.ThinkingDataActivityLifecycleCallbacks", "onActivityStopped: the SDK might be initialized after the onActivityStart of " + activity);
                    return;
                }
                if (this.f9298g.size() == 0) {
                    this.f9297f = null;
                    if (this.f9299h) {
                        try {
                            this.f9294c.appEnterBackground();
                            this.a = true;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (this.f9294c.isAutoTrackEnabled()) {
                            JSONObject jSONObject = new JSONObject();
                            if (!this.f9294c.isAutoTrackEventTypeIgnored(ThinkingAnalyticsSDK.AutoTrackEventType.APP_END)) {
                                try {
                                    n.u(jSONObject, activity);
                                    thinkingAnalyticsSDK = this.f9294c;
                                    str = "ta_app_end";
                                } catch (Exception e3) {
                                    TDLog.i("ThinkingAnalytics.ThinkingDataActivityLifecycleCallbacks", e3);
                                    thinkingAnalyticsSDK = this.f9294c;
                                    str = "ta_app_end";
                                }
                                thinkingAnalyticsSDK.autoTrack(str, jSONObject);
                                this.f9299h = false;
                            }
                        }
                        try {
                            this.f9296e = new c(TimeUnit.SECONDS);
                            this.f9294c.flush();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
