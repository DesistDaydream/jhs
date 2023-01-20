package cn.thinkingdata.android;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import cn.thinkingdata.android.utils.TDLog;
import d.a.a.d;
import d.a.a.n.f;
import d.a.a.n.g;
import d.a.a.n.h;
import d.a.a.n.k;
import d.a.a.o.e;
import d.a.a.o.i;
import d.a.a.o.l;
import d.a.a.o.n;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ThinkingAnalyticsSDK implements d {
    private static final int APP_CRASH = 16;
    private static final int APP_END = 2;
    private static final int APP_INSTALL = 32;
    private static final int APP_START = 1;
    private static final String PREFERENCE_NAME = "com.thinkingdata.analyse";
    public static final String TAG = "ThinkingAnalyticsSDK";
    private static d.a.a.o.d sCalibratedTime;
    private static f sOldLoginId;
    private static d.a.a.n.j sRandomID;
    private static Future<SharedPreferences> sStoredSharedPrefs;
    private DynamicSuperPropertiesTrackerListener dynamicSuperPropertiesTrackerListener;
    private boolean mAutoTrack;
    private AutoTrackEventListener mAutoTrackEventListener;
    private AutoTrackEventTrackerListener mAutoTrackEventTrackerListener;
    private List<AutoTrackEventType> mAutoTrackEventTypeList;
    private List<Integer> mAutoTrackIgnoredActivities;
    private JSONObject mAutoTrackStartProperties;
    private e mAutoTrackStartTime;
    public TDConfig mConfig;
    private DynamicSuperPropertiesTracker mDynamicSuperPropertiesTracker;
    private final d.a.a.n.b mEnableFlag;
    private final boolean mEnableTrackOldData;
    private final d.a.a.n.e mIdentifyId;
    private String mLastScreenUrl;
    private d.a.a.m mLifecycleCallbacks;
    private final f mLoginId;
    public final d.a.a.b mMessages;
    private final g mOptOutFlag;
    public final h mPausePostFlag;
    private final k mSuperProperties;
    private final j mSystemInformation;
    private boolean mTrackCrash;
    private boolean mTrackFragmentAppViewScreen;
    public final Map<String, d.a.a.c> mTrackTimer;
    private static final d.a.a.h sPrefsLoader = new d.a.a.h();
    private static final Object sOldLoginIdLock = new Object();
    private static final Object sRandomIDLock = new Object();
    private static final Map<Context, Map<String, ThinkingAnalyticsSDK>> sInstanceMap = new HashMap();
    private static final Map<Context, List<String>> sAppFirstInstallationMap = new HashMap();
    private static final ReentrantReadWriteLock sCalibratedTimeLock = new ReentrantReadWriteLock();
    private boolean isFromSubProcess = false;
    private List<Class> mIgnoredViewTypeList = new ArrayList();
    private final JSONObject mAutoTrackEventProperties = new JSONObject();

    /* loaded from: classes.dex */
    public interface AutoTrackEventListener {
        JSONObject eventCallback(AutoTrackEventType autoTrackEventType, JSONObject jSONObject);
    }

    /* loaded from: classes.dex */
    public interface AutoTrackEventTrackerListener {
        String eventCallback(int i2, String str);
    }

    /* loaded from: classes.dex */
    public enum AutoTrackEventType {
        APP_START("ta_app_start"),
        APP_END("ta_app_end"),
        APP_CLICK("ta_app_click"),
        APP_VIEW_SCREEN("ta_app_view"),
        APP_CRASH("ta_app_crash"),
        APP_INSTALL("ta_app_install");
        
        private final String eventName;

        AutoTrackEventType(String str) {
            this.eventName = str;
        }

        public static AutoTrackEventType autoTrackEventTypeFromEventName(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1123498325:
                    if (str.equals("ta_app_install")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -78288232:
                    if (str.equals("ta_app_click")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -78116681:
                    if (str.equals("ta_app_crash")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -63280782:
                    if (str.equals("ta_app_start")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1014444523:
                    if (str.equals("ta_app_end")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1383510933:
                    if (str.equals("ta_app_view")) {
                        c2 = 5;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return APP_INSTALL;
                case 1:
                    return APP_CLICK;
                case 2:
                    return APP_CRASH;
                case 3:
                    return APP_START;
                case 4:
                    return APP_END;
                case 5:
                    return APP_VIEW_SCREEN;
                default:
                    return null;
            }
        }

        public String getEventName() {
            return this.eventName;
        }
    }

    /* loaded from: classes.dex */
    public interface DynamicSuperPropertiesTracker {
        JSONObject getDynamicSuperProperties();
    }

    /* loaded from: classes.dex */
    public interface DynamicSuperPropertiesTrackerListener {
        String getDynamicSuperPropertiesString();
    }

    /* loaded from: classes.dex */
    public enum TATrackStatus {
        PAUSE,
        STOP,
        SAVE_ONLY,
        NORMAL
    }

    /* loaded from: classes.dex */
    public enum ThinkingdataNetworkType {
        NETWORKTYPE_DEFAULT,
        NETWORKTYPE_WIFI,
        NETWORKTYPE_ALL
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TATrackStatus.values().length];
            a = iArr;
            try {
                iArr[TATrackStatus.PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TATrackStatus.STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TATrackStatus.SAVE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[TATrackStatus.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(ThinkingAnalyticsSDK thinkingAnalyticsSDK);
    }

    public ThinkingAnalyticsSDK(TDConfig tDConfig, boolean... zArr) {
        this.mConfig = tDConfig;
        if (!TDPresetProperties.disableList.contains("#fps")) {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            n.E();
        }
        if (zArr.length > 0 && zArr[0]) {
            this.mLoginId = null;
            this.mIdentifyId = null;
            this.mSuperProperties = null;
            this.mOptOutFlag = null;
            this.mEnableFlag = null;
            this.mPausePostFlag = null;
            this.mEnableTrackOldData = false;
            this.mTrackTimer = new HashMap();
            this.mSystemInformation = j.b(tDConfig.mContext, tDConfig.getDefaultTimeZone());
            this.mMessages = getDataHandleInstance(tDConfig.mContext);
            return;
        }
        if (sStoredSharedPrefs == null) {
            Future<SharedPreferences> a2 = sPrefsLoader.a(tDConfig.mContext, PREFERENCE_NAME);
            sStoredSharedPrefs = a2;
            sRandomID = new d.a.a.n.j(a2);
            sOldLoginId = new f(sStoredSharedPrefs);
        }
        boolean z = tDConfig.trackOldData() && !isOldDataTracked();
        this.mEnableTrackOldData = z;
        d.a.a.h hVar = sPrefsLoader;
        Context context = tDConfig.mContext;
        Future<SharedPreferences> a3 = hVar.a(context, "com.thinkingdata.analyse_" + tDConfig.getName());
        this.mLoginId = new f(a3);
        this.mIdentifyId = new d.a.a.n.e(a3);
        this.mSuperProperties = new k(a3);
        this.mOptOutFlag = new g(a3);
        this.mEnableFlag = new d.a.a.n.b(a3);
        h hVar2 = new h(a3);
        this.mPausePostFlag = hVar2;
        this.mSystemInformation = j.b(tDConfig.mContext, tDConfig.getDefaultTimeZone());
        d.a.a.b dataHandleInstance = getDataHandleInstance(tDConfig.mContext);
        this.mMessages = dataHandleInstance;
        dataHandleInstance.f(getToken(), hVar2.e().booleanValue());
        if (tDConfig.mEnableEncrypt) {
            d.a.a.e.e.c(tDConfig.getName(), tDConfig);
        }
        if (z) {
            dataHandleInstance.m(tDConfig.getName());
        }
        this.mTrackTimer = new HashMap();
        this.mAutoTrackIgnoredActivities = new ArrayList();
        this.mAutoTrackEventTypeList = new ArrayList();
        this.mLifecycleCallbacks = new d.a.a.m(this, this.mConfig.getMainProcessName());
        if (Build.VERSION.SDK_INT >= 14) {
            ((Application) tDConfig.mContext.getApplicationContext()).registerActivityLifecycleCallbacks(this.mLifecycleCallbacks);
        }
        if (!tDConfig.isNormal() || isLogControlFileExist()) {
            enableTrackLog(true);
        }
        if (tDConfig.isEnableMutiprocess() && n.G(tDConfig.mContext)) {
            TDReceiver.b(tDConfig.mContext);
        }
        TDLog.i(TAG, String.format("Thinking Analytics SDK %s instance initialized successfully with mode: %s, APP ID ends with: %s, server url: %s, device ID: %s", TDConfig.VERSION, tDConfig.getMode().name(), n.m(tDConfig.mToken, 4), tDConfig.getServerUrl(), getDeviceId()));
    }

    public static void addInstance(ThinkingAnalyticsSDK thinkingAnalyticsSDK, Context context, String str) {
        Map<Context, Map<String, ThinkingAnalyticsSDK>> map = sInstanceMap;
        synchronized (map) {
            Map<String, ThinkingAnalyticsSDK> map2 = map.get(context);
            if (map2 == null) {
                map2 = new HashMap<>();
                map.put(context, map2);
            }
            map2.put(str, thinkingAnalyticsSDK);
        }
    }

    public static void allInstances(b bVar) {
        Map<Context, Map<String, ThinkingAnalyticsSDK>> map = sInstanceMap;
        synchronized (map) {
            for (Map<String, ThinkingAnalyticsSDK> map2 : map.values()) {
                for (ThinkingAnalyticsSDK thinkingAnalyticsSDK : map2.values()) {
                    bVar.a(thinkingAnalyticsSDK);
                }
            }
        }
    }

    public static void calibrateTime(long j2) {
        setCalibratedTime(new d.a.a.o.h(j2));
    }

    public static void calibrateTimeWithNtp(String... strArr) {
        if (strArr == null) {
            return;
        }
        setCalibratedTime(new i(strArr));
    }

    public static void calibrateTimeWithNtpForUnity(String str) {
        calibrateTimeWithNtp(str);
    }

    public static void enableTrackLog(boolean z) {
        TDLog.setEnableLog(z);
    }

    public static d.a.a.o.d getCalibratedTime() {
        return sCalibratedTime;
    }

    private String getIdentifyID() {
        String e2;
        synchronized (this.mIdentifyId) {
            e2 = this.mIdentifyId.e();
        }
        return e2;
    }

    public static Map<String, ThinkingAnalyticsSDK> getInstanceMap(Context context) {
        return sInstanceMap.get(context);
    }

    public static String getLocalRegion() {
        return Locale.getDefault().getCountry();
    }

    private e getTime() {
        ReentrantReadWriteLock reentrantReadWriteLock = sCalibratedTimeLock;
        reentrantReadWriteLock.readLock().lock();
        d.a.a.o.d dVar = sCalibratedTime;
        e lVar = dVar != null ? new l(dVar, this.mConfig.getDefaultTimeZone()) : new d.a.a.o.k(new Date(), this.mConfig.getDefaultTimeZone());
        reentrantReadWriteLock.readLock().unlock();
        return lVar;
    }

    private e getTime(String str, Double d2) {
        return new d.a.a.o.m(str, d2);
    }

    private e getTime(Date date, TimeZone timeZone) {
        if (timeZone == null) {
            d.a.a.o.k kVar = new d.a.a.o.k(date, this.mConfig.getDefaultTimeZone());
            kVar.c();
            return kVar;
        }
        return new d.a.a.o.k(date, timeZone);
    }

    private static boolean isLogControlFileExist() {
        return new File("/storage/emulated/0/Download/ta_log_controller").exists();
    }

    private static boolean isOldDataTracked() {
        Map<Context, Map<String, ThinkingAnalyticsSDK>> map = sInstanceMap;
        synchronized (map) {
            if (map.size() > 0) {
                for (Map<String, ThinkingAnalyticsSDK> map2 : map.values()) {
                    for (ThinkingAnalyticsSDK thinkingAnalyticsSDK : map2.values()) {
                        if (thinkingAnalyticsSDK.mEnableTrackOldData) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    private JSONObject obtainDefaultEventProperties(String str) {
        d.a.a.c cVar;
        JSONObject dynamicSuperProperties;
        JSONObject optJSONObject;
        JSONObject jSONObject = new JSONObject();
        try {
            n.v(new JSONObject(this.mSystemInformation.n()), jSONObject, this.mConfig.getDefaultTimeZone());
            if (!TextUtils.isEmpty(this.mSystemInformation.j())) {
                jSONObject.put("#app_version", this.mSystemInformation.j());
            }
            if (!TDPresetProperties.disableList.contains("#fps")) {
                jSONObject.put("#fps", n.c());
            }
            n.v(getSuperProperties(), jSONObject, this.mConfig.getDefaultTimeZone());
            if (!this.isFromSubProcess && (optJSONObject = getAutoTrackProperties().optJSONObject(str)) != null) {
                n.v(optJSONObject, jSONObject, this.mConfig.getDefaultTimeZone());
            }
            try {
                DynamicSuperPropertiesTracker dynamicSuperPropertiesTracker = this.mDynamicSuperPropertiesTracker;
                if (dynamicSuperPropertiesTracker != null && (dynamicSuperProperties = dynamicSuperPropertiesTracker.getDynamicSuperProperties()) != null && cn.thinkingdata.android.utils.g.b(dynamicSuperProperties)) {
                    n.v(dynamicSuperProperties, jSONObject, this.mConfig.getDefaultTimeZone());
                }
                if (this.dynamicSuperPropertiesTrackerListener != null) {
                    JSONObject jSONObject2 = new JSONObject(this.dynamicSuperPropertiesTrackerListener.getDynamicSuperPropertiesString());
                    if (cn.thinkingdata.android.utils.g.b(jSONObject2)) {
                        n.v(jSONObject2, jSONObject, this.mConfig.getDefaultTimeZone());
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (!this.isFromSubProcess) {
                synchronized (this.mTrackTimer) {
                    cVar = this.mTrackTimer.get(str);
                    this.mTrackTimer.remove(str);
                }
                if (cVar != null) {
                    try {
                        Double valueOf = Double.valueOf(cVar.c());
                        if (valueOf.doubleValue() > 0.0d && !TDPresetProperties.disableList.contains("#duration")) {
                            jSONObject.put("#duration", valueOf);
                        }
                        Double valueOf2 = Double.valueOf(cVar.a());
                        if (valueOf2.doubleValue() > 0.0d && !str.equals("ta_app_end") && !TDPresetProperties.disableList.contains("#background_duration")) {
                            jSONObject.put("#background_duration", valueOf2);
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
            }
            List<String> list = TDPresetProperties.disableList;
            if (!list.contains("#network_type")) {
                jSONObject.put("#network_type", this.mSystemInformation.o());
            }
            if (!list.contains("#ram")) {
                jSONObject.put("#ram", this.mSystemInformation.k(this.mConfig.mContext));
            }
            if (!list.contains("#disk")) {
                jSONObject.put("#disk", this.mSystemInformation.e(this.mConfig.mContext, false));
            }
            if (!list.contains("#device_type")) {
                jSONObject.put("#device_type", n.B(this.mConfig.mContext));
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void setCalibratedTime(d.a.a.o.d dVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = sCalibratedTimeLock;
        reentrantReadWriteLock.writeLock().lock();
        sCalibratedTime = dVar;
        reentrantReadWriteLock.writeLock().unlock();
    }

    public static void setCustomerLibInfo(String str, String str2) {
        j.g(str, str2);
    }

    public static ThinkingAnalyticsSDK sharedInstance(Context context, String str) {
        return sharedInstance(context, str, null, false);
    }

    public static ThinkingAnalyticsSDK sharedInstance(Context context, String str, String str2) {
        return sharedInstance(context, str, str2, true);
    }

    public static ThinkingAnalyticsSDK sharedInstance(Context context, String str, String str2, boolean z) {
        String str3;
        if (context == null) {
            str3 = "App context is required to get SDK instance.";
        } else if (TextUtils.isEmpty(str)) {
            str3 = "APP ID is required to get SDK instance.";
        } else {
            try {
                TDConfig tDConfig = TDConfig.getInstance(context, str, str2);
                tDConfig.setTrackOldData(z);
                return sharedInstance(tDConfig);
            } catch (IllegalArgumentException unused) {
                str3 = "Cannot get valid TDConfig instance. Returning null";
            }
        }
        TDLog.w(TAG, str3);
        return null;
    }

    public static ThinkingAnalyticsSDK sharedInstance(TDConfig tDConfig) {
        ThinkingAnalyticsSDK thinkingAnalyticsSDK;
        if (tDConfig == null) {
            TDLog.w(TAG, "Cannot initial SDK instance with null config instance.");
            return null;
        }
        Map<Context, Map<String, ThinkingAnalyticsSDK>> map = sInstanceMap;
        synchronized (map) {
            Map<String, ThinkingAnalyticsSDK> map2 = map.get(tDConfig.mContext);
            if (map2 == null) {
                map2 = new HashMap<>();
                map.put(tDConfig.mContext, map2);
                if (c.f(tDConfig.mContext) && j.b(tDConfig.mContext, tDConfig.getDefaultTimeZone()).r()) {
                    sAppFirstInstallationMap.put(tDConfig.mContext, new LinkedList());
                }
            }
            thinkingAnalyticsSDK = map2.get(tDConfig.getName());
            if (thinkingAnalyticsSDK == null) {
                if (n.G(tDConfig.mContext)) {
                    thinkingAnalyticsSDK = new ThinkingAnalyticsSDK(tDConfig, new boolean[0]);
                    Map<Context, List<String>> map3 = sAppFirstInstallationMap;
                    if (map3.containsKey(tDConfig.mContext)) {
                        map3.get(tDConfig.mContext).add(tDConfig.getName());
                    }
                } else {
                    thinkingAnalyticsSDK = new d.a.a.i(tDConfig);
                }
                map2.put(tDConfig.getName(), thinkingAnalyticsSDK);
            }
        }
        return thinkingAnalyticsSDK;
    }

    private void track(String str, JSONObject jSONObject, e eVar) {
        track(str, jSONObject, eVar, true);
    }

    private void track(String str, JSONObject jSONObject, e eVar, boolean z) {
        track(str, jSONObject, eVar, z, null, null);
    }

    private void track(String str, JSONObject jSONObject, e eVar, boolean z, Map<String, String> map, cn.thinkingdata.android.utils.l lVar) {
        AutoTrackEventType autoTrackEventTypeFromEventName;
        if (this.mConfig.isDisabledEvent(str)) {
            TDLog.d(TAG, "Ignoring disabled event [" + str + "]");
            return;
        }
        if (z) {
            try {
                if (cn.thinkingdata.android.utils.g.a(str)) {
                    TDLog.w(TAG, "Event name[" + str + "] is invalid. Event name must be string that starts with English letter, and contains letter, number, and '_'. The max length of the event name is 50.");
                    if (this.mConfig.shouldThrowException()) {
                        throw new m("Invalid event name: " + str);
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (z && !cn.thinkingdata.android.utils.g.b(jSONObject)) {
            TDLog.w(TAG, "The data contains invalid key or value: " + jSONObject.toString());
            if (this.mConfig.shouldThrowException()) {
                throw new m("Invalid properties. Please refer to SDK debug log for detail reasons.");
            }
        }
        JSONObject obtainDefaultEventProperties = obtainDefaultEventProperties(str);
        if (jSONObject != null) {
            n.v(jSONObject, obtainDefaultEventProperties, this.mConfig.getDefaultTimeZone());
        }
        if (!this.isFromSubProcess && (autoTrackEventTypeFromEventName = AutoTrackEventType.autoTrackEventTypeFromEventName(str)) != null) {
            AutoTrackEventListener autoTrackEventListener = this.mAutoTrackEventListener;
            if (autoTrackEventListener != null) {
                JSONObject eventCallback = autoTrackEventListener.eventCallback(autoTrackEventTypeFromEventName, obtainDefaultEventProperties);
                if (eventCallback != null) {
                    n.v(eventCallback, obtainDefaultEventProperties, this.mConfig.getDefaultTimeZone());
                }
            } else {
                TDLog.i(TAG, "No mAutoTrackEventListener");
            }
            if (this.mAutoTrackEventTrackerListener != null) {
                n.v(new JSONObject(this.mAutoTrackEventTrackerListener.eventCallback(autoTrackEventTypeFromEventName == AutoTrackEventType.APP_START ? 1 : autoTrackEventTypeFromEventName == AutoTrackEventType.APP_INSTALL ? 32 : autoTrackEventTypeFromEventName == AutoTrackEventType.APP_END ? 2 : autoTrackEventTypeFromEventName == AutoTrackEventType.APP_CRASH ? 16 : 0, obtainDefaultEventProperties.toString())), obtainDefaultEventProperties, this.mConfig.getDefaultTimeZone());
            } else {
                TDLog.i(TAG, "No mAutoTrackEventTrackerListener");
            }
        }
        if (lVar == null) {
            lVar = cn.thinkingdata.android.utils.l.TRACK;
        }
        d.a.a.a aVar = new d.a.a.a(this, lVar, obtainDefaultEventProperties, eVar);
        aVar.a = str;
        if (map != null) {
            aVar.b(map);
        }
        setFromSubProcess(false);
        trackInternal(aVar);
    }

    public void appBecomeActive() {
        d.a.a.c value;
        synchronized (this.mTrackTimer) {
            try {
                for (Map.Entry<String, d.a.a.c> entry : this.mTrackTimer.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null) {
                        long e2 = (value.e() + SystemClock.elapsedRealtime()) - value.i();
                        value.h(SystemClock.elapsedRealtime());
                        value.d(e2);
                    }
                }
            } catch (Exception e3) {
                TDLog.i(TAG, "appBecomeActive error:" + e3.getMessage());
            }
            flush();
        }
    }

    public void appEnterBackground() {
        d.a.a.c value;
        synchronized (this.mTrackTimer) {
            try {
                for (Map.Entry<String, d.a.a.c> entry : this.mTrackTimer.entrySet()) {
                    if (entry != null && !"ta_app_end".equals(entry.getKey().toString()) && (value = entry.getValue()) != null) {
                        value.f((value.g() + SystemClock.elapsedRealtime()) - value.i());
                        value.h(SystemClock.elapsedRealtime());
                    }
                }
            } catch (Exception e2) {
                TDLog.i(TAG, "appEnterBackground error:" + e2.getMessage());
            }
        }
    }

    public void autoTrack(String str, JSONObject jSONObject) {
        if (hasDisabled()) {
            return;
        }
        track(str, jSONObject, getTime(), false);
    }

    public void clearSuperProperties() {
        if (hasDisabled()) {
            return;
        }
        synchronized (this.mSuperProperties) {
            this.mSuperProperties.d(new JSONObject());
        }
    }

    /* renamed from: createLightInstance */
    public ThinkingAnalyticsSDK m12createLightInstance() {
        return new d.a.a.f(this.mConfig);
    }

    public void enableAutoTrack(int i2) {
        ArrayList arrayList = new ArrayList();
        if ((i2 & 1) > 0) {
            arrayList.add(AutoTrackEventType.APP_START);
        }
        if ((i2 & 2) > 0) {
            arrayList.add(AutoTrackEventType.APP_END);
        }
        if ((i2 & 32) > 0) {
            arrayList.add(AutoTrackEventType.APP_INSTALL);
        }
        if ((i2 & 16) > 0) {
            arrayList.add(AutoTrackEventType.APP_CRASH);
        }
        if (arrayList.size() > 0) {
            enableAutoTrack(arrayList);
        }
    }

    public void enableAutoTrack(int i2, AutoTrackEventTrackerListener autoTrackEventTrackerListener) {
        this.mAutoTrackEventTrackerListener = autoTrackEventTrackerListener;
        enableAutoTrack(i2);
    }

    public void enableAutoTrack(int i2, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if ((i2 & 1) > 0) {
            arrayList.add(AutoTrackEventType.APP_START);
        }
        if ((i2 & 2) > 0) {
            arrayList.add(AutoTrackEventType.APP_END);
        }
        if ((i2 & 32) > 0) {
            arrayList.add(AutoTrackEventType.APP_INSTALL);
        }
        if ((i2 & 16) > 0) {
            arrayList.add(AutoTrackEventType.APP_CRASH);
        }
        if (arrayList.size() > 0) {
            setAutoTrackProperties(arrayList, jSONObject);
            enableAutoTrack(arrayList);
        }
    }

    public void enableAutoTrack(List<AutoTrackEventType> list) {
        if (hasDisabled()) {
            return;
        }
        this.mAutoTrack = true;
        if (list == null || list.size() == 0) {
            return;
        }
        if (list.contains(AutoTrackEventType.APP_INSTALL)) {
            synchronized (sInstanceMap) {
                Map<Context, List<String>> map = sAppFirstInstallationMap;
                if (map.containsKey(this.mConfig.mContext) && map.get(this.mConfig.mContext).contains(getToken())) {
                    track("ta_app_install");
                    flush();
                    map.get(this.mConfig.mContext).remove(getToken());
                }
            }
        }
        if (list.contains(AutoTrackEventType.APP_CRASH)) {
            this.mTrackCrash = true;
            d.a.a.j f2 = d.a.a.j.f(this.mConfig.mContext);
            if (f2 != null) {
                f2.c();
            }
        }
        List<AutoTrackEventType> list2 = this.mAutoTrackEventTypeList;
        AutoTrackEventType autoTrackEventType = AutoTrackEventType.APP_END;
        if (!list2.contains(autoTrackEventType) && list.contains(autoTrackEventType)) {
            timeEvent("ta_app_end");
        }
        synchronized (this) {
            this.mAutoTrackStartTime = getTime();
            this.mAutoTrackStartProperties = obtainDefaultEventProperties("ta_app_start");
        }
        this.mAutoTrackEventTypeList.clear();
        this.mAutoTrackEventTypeList.addAll(list);
        if (this.mAutoTrackEventTypeList.contains(AutoTrackEventType.APP_START)) {
            this.mLifecycleCallbacks.k();
        }
    }

    public void enableAutoTrack(List<AutoTrackEventType> list, AutoTrackEventListener autoTrackEventListener) {
        this.mAutoTrackEventListener = autoTrackEventListener;
        enableAutoTrack(list);
    }

    public void enableAutoTrack(List<AutoTrackEventType> list, JSONObject jSONObject) {
        setAutoTrackProperties(list, jSONObject);
        enableAutoTrack(list);
    }

    public void enableThirdPartySharing(int i2) {
        try {
            d.a.a.o.g.d("cn.thinkingdata.thirdparty.TAThirdPartyManager", "enableThirdPartySharing", new Object[]{Integer.valueOf(i2), this, getLoginId()}, Integer.TYPE, ThinkingAnalyticsSDK.class, String.class);
        } catch (Exception unused) {
            TDLog.e(TAG, "请引入三方数据同步插件");
        }
    }

    public synchronized void enableThirdPartySharing(int i2, Map<String, Object> map) {
        try {
            d.a.a.o.g.d("cn.thinkingdata.thirdparty.TAThirdPartyManager", "enableThirdPartySharing", new Object[]{Integer.valueOf(i2), this, getLoginId(), map}, Integer.TYPE, ThinkingAnalyticsSDK.class, String.class, Map.class);
        } catch (Exception unused) {
            TDLog.e(TAG, "请引入三方数据同步插件");
        }
    }

    @Deprecated
    public void enableTracking(boolean z) {
        TDLog.d(TAG, "enableTracking: " + z);
        if (isEnabled() && !z) {
            flush();
        }
        this.mEnableFlag.d(Boolean.valueOf(z));
    }

    public void flush() {
        if (hasDisabled()) {
            return;
        }
        this.mMessages.j(getToken());
    }

    public List<AutoTrackEventType> getAutoTrackEventTypeList() {
        return this.mAutoTrackEventTypeList;
    }

    public JSONObject getAutoTrackProperties() {
        return this.mAutoTrackEventProperties;
    }

    public synchronized JSONObject getAutoTrackStartProperties() {
        JSONObject jSONObject;
        jSONObject = this.mAutoTrackStartProperties;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return jSONObject;
    }

    public synchronized e getAutoTrackStartTime() {
        return this.mAutoTrackStartTime;
    }

    public d.a.a.b getDataHandleInstance(Context context) {
        return d.a.a.b.g(context);
    }

    public String getDeviceId() {
        if (this.mSystemInformation.n().containsKey("#device_id")) {
            return (String) this.mSystemInformation.n().get("#device_id");
        }
        return null;
    }

    public String getDistinctId() {
        String identifyID = getIdentifyID();
        return identifyID == null ? getRandomID() : identifyID;
    }

    public DynamicSuperPropertiesTracker getDynamicSuperPropertiesTracker() {
        return this.mDynamicSuperPropertiesTracker;
    }

    public DynamicSuperPropertiesTrackerListener getDynamicSuperPropertiesTrackerListener() {
        return this.dynamicSuperPropertiesTrackerListener;
    }

    public List<Class> getIgnoredViewTypeList() {
        if (this.mIgnoredViewTypeList == null) {
            this.mIgnoredViewTypeList = new ArrayList();
        }
        return this.mIgnoredViewTypeList;
    }

    public String getLoginId() {
        String e2;
        String e3;
        synchronized (this.mLoginId) {
            e2 = this.mLoginId.e();
            if (TextUtils.isEmpty(e2) && this.mEnableTrackOldData) {
                synchronized (sOldLoginIdLock) {
                    e3 = sOldLoginId.e();
                    if (!TextUtils.isEmpty(e3)) {
                        this.mLoginId.d(e3);
                        sOldLoginId.d(null);
                    }
                }
                e2 = e3;
            }
        }
        return e2;
    }

    public TDPresetProperties getPresetProperties() {
        JSONObject f2 = j.q(this.mConfig.mContext).f();
        String o = j.q(this.mConfig.mContext).o();
        double doubleValue = getTime().a().doubleValue();
        try {
            List<String> list = TDPresetProperties.disableList;
            if (!list.contains("#network_type")) {
                f2.put("#network_type", o);
            }
            if (!list.contains("#zone_offset")) {
                f2.put("#zone_offset", doubleValue);
            }
            if (!list.contains("#ram")) {
                f2.put("#ram", this.mSystemInformation.k(this.mConfig.mContext));
            }
            if (!list.contains("#disk")) {
                f2.put("#disk", this.mSystemInformation.e(this.mConfig.mContext, false));
            }
            if (!list.contains("#fps")) {
                f2.put("#fps", n.c());
            }
            if (!list.contains("#device_type")) {
                f2.put("#device_type", n.B(this.mConfig.mContext));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new TDPresetProperties(f2);
    }

    public String getRandomID() {
        String e2;
        synchronized (sRandomIDLock) {
            e2 = sRandomID.e();
        }
        return e2;
    }

    public JSONObject getSuperProperties() {
        JSONObject e2;
        synchronized (this.mSuperProperties) {
            e2 = this.mSuperProperties.e();
        }
        return e2;
    }

    public String getTimeString(Date date) {
        return getTime(date, this.mConfig.getDefaultTimeZone()).b();
    }

    public String getToken() {
        return this.mConfig.getName();
    }

    public boolean hasDisabled() {
        return !isEnabled() || hasOptOut();
    }

    public boolean hasOptOut() {
        return this.mOptOutFlag.e().booleanValue();
    }

    public void identify(String str) {
        if (hasDisabled()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            TDLog.w(TAG, "The identity cannot be empty.");
            if (this.mConfig.shouldThrowException()) {
                throw new m("distinct id cannot be empty");
            }
            return;
        }
        synchronized (this.mIdentifyId) {
            this.mIdentifyId.d(str);
        }
    }

    public void ignoreAutoTrackActivities(List<Class<?>> list) {
        if (hasDisabled() || list == null || list.size() == 0) {
            return;
        }
        if (this.mAutoTrackIgnoredActivities == null) {
            this.mAutoTrackIgnoredActivities = new ArrayList();
        }
        for (Class<?> cls : list) {
            if (cls != null && !this.mAutoTrackIgnoredActivities.contains(Integer.valueOf(cls.hashCode()))) {
                this.mAutoTrackIgnoredActivities.add(Integer.valueOf(cls.hashCode()));
            }
        }
    }

    public void ignoreAutoTrackActivity(Class<?> cls) {
        if (hasDisabled() || cls == null) {
            return;
        }
        if (this.mAutoTrackIgnoredActivities == null) {
            this.mAutoTrackIgnoredActivities = new ArrayList();
        }
        if (this.mAutoTrackIgnoredActivities.contains(Integer.valueOf(cls.hashCode()))) {
            return;
        }
        this.mAutoTrackIgnoredActivities.add(Integer.valueOf(cls.hashCode()));
    }

    public void ignoreView(View view) {
        if (hasDisabled() || view == null) {
            return;
        }
        n.t(getToken(), view, R.id.thinking_analytics_tag_view_ignored, "1");
    }

    public void ignoreViewType(Class cls) {
        if (hasDisabled() || cls == null) {
            return;
        }
        if (this.mIgnoredViewTypeList == null) {
            this.mIgnoredViewTypeList = new ArrayList();
        }
        if (this.mIgnoredViewTypeList.contains(cls)) {
            return;
        }
        this.mIgnoredViewTypeList.add(cls);
    }

    public boolean isActivityAutoTrackAppClickIgnored(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        List<Integer> list = this.mAutoTrackIgnoredActivities;
        if (list == null || !list.contains(Integer.valueOf(cls.hashCode()))) {
            ThinkingDataIgnoreTrackAppViewScreenAndAppClick thinkingDataIgnoreTrackAppViewScreenAndAppClick = (ThinkingDataIgnoreTrackAppViewScreenAndAppClick) cls.getAnnotation(ThinkingDataIgnoreTrackAppViewScreenAndAppClick.class);
            if (thinkingDataIgnoreTrackAppViewScreenAndAppClick == null || !(TextUtils.isEmpty(thinkingDataIgnoreTrackAppViewScreenAndAppClick.appId()) || getToken().equals(thinkingDataIgnoreTrackAppViewScreenAndAppClick.appId()))) {
                ThinkingDataIgnoreTrackAppClick thinkingDataIgnoreTrackAppClick = (ThinkingDataIgnoreTrackAppClick) cls.getAnnotation(ThinkingDataIgnoreTrackAppClick.class);
                if (thinkingDataIgnoreTrackAppClick != null) {
                    return TextUtils.isEmpty(thinkingDataIgnoreTrackAppClick.appId()) || getToken().equals(thinkingDataIgnoreTrackAppClick.appId());
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean isActivityAutoTrackAppViewScreenIgnored(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        List<Integer> list = this.mAutoTrackIgnoredActivities;
        if (list == null || !list.contains(Integer.valueOf(cls.hashCode()))) {
            ThinkingDataIgnoreTrackAppViewScreenAndAppClick thinkingDataIgnoreTrackAppViewScreenAndAppClick = (ThinkingDataIgnoreTrackAppViewScreenAndAppClick) cls.getAnnotation(ThinkingDataIgnoreTrackAppViewScreenAndAppClick.class);
            if (thinkingDataIgnoreTrackAppViewScreenAndAppClick == null || !(TextUtils.isEmpty(thinkingDataIgnoreTrackAppViewScreenAndAppClick.appId()) || getToken().equals(thinkingDataIgnoreTrackAppViewScreenAndAppClick.appId()))) {
                ThinkingDataIgnoreTrackAppViewScreen thinkingDataIgnoreTrackAppViewScreen = (ThinkingDataIgnoreTrackAppViewScreen) cls.getAnnotation(ThinkingDataIgnoreTrackAppViewScreen.class);
                return thinkingDataIgnoreTrackAppViewScreen != null && (TextUtils.isEmpty(thinkingDataIgnoreTrackAppViewScreen.appId()) || getToken().equals(thinkingDataIgnoreTrackAppViewScreen.appId()));
            }
            return true;
        }
        return true;
    }

    public boolean isAutoTrackEnabled() {
        if (hasDisabled()) {
            return false;
        }
        return this.mAutoTrack;
    }

    public boolean isAutoTrackEventTypeIgnored(AutoTrackEventType autoTrackEventType) {
        return (autoTrackEventType == null || this.mAutoTrackEventTypeList.contains(autoTrackEventType)) ? false : true;
    }

    public boolean isEnabled() {
        return this.mEnableFlag.e().booleanValue();
    }

    public boolean isTrackFragmentAppViewScreenEnabled() {
        return this.mTrackFragmentAppViewScreen;
    }

    public void login(String str) {
        if (hasDisabled()) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                TDLog.d(TAG, "The account id cannot be empty.");
                if (this.mConfig.shouldThrowException()) {
                    throw new m("account id cannot be empty");
                }
                return;
            }
            synchronized (this.mLoginId) {
                if (!str.equals(this.mLoginId.e())) {
                    this.mLoginId.d(str);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void logout() {
        if (hasDisabled()) {
            return;
        }
        try {
            synchronized (this.mLoginId) {
                this.mLoginId.d(null);
                if (this.mEnableTrackOldData) {
                    synchronized (sOldLoginIdLock) {
                        if (!TextUtils.isEmpty(sOldLoginId.e())) {
                            sOldLoginId.d(null);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Deprecated
    public void optInTracking() {
        TDLog.d(TAG, "optInTracking...");
        this.mOptOutFlag.d(Boolean.FALSE);
        this.mMessages.j(getToken());
    }

    @Deprecated
    public void optOutTracking() {
        TDLog.d(TAG, "optOutTracking...");
        this.mOptOutFlag.d(Boolean.TRUE);
        this.mMessages.e(getToken());
        synchronized (this.mTrackTimer) {
            this.mTrackTimer.clear();
        }
        this.mIdentifyId.d(null);
        this.mLoginId.d(null);
        synchronized (this.mSuperProperties) {
            this.mSuperProperties.d(new JSONObject());
        }
    }

    @Deprecated
    public void optOutTrackingAndDeleteUser() {
        d.a.a.a aVar = new d.a.a.a(this, cn.thinkingdata.android.utils.l.USER_DEL, null, getTime());
        aVar.c();
        trackInternal(aVar);
        optOutTracking();
    }

    public void setAutoTrackProperties(int i2, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if ((i2 & 1) > 0) {
            arrayList.add(AutoTrackEventType.APP_START);
        }
        if ((i2 & 2) > 0) {
            arrayList.add(AutoTrackEventType.APP_END);
        }
        if ((i2 & 32) > 0) {
            arrayList.add(AutoTrackEventType.APP_INSTALL);
        }
        if ((i2 & 16) > 0) {
            arrayList.add(AutoTrackEventType.APP_CRASH);
        }
        if (arrayList.size() > 0) {
            setAutoTrackProperties(arrayList, jSONObject);
        }
    }

    public void setAutoTrackProperties(List<AutoTrackEventType> list, JSONObject jSONObject) {
        if (hasDisabled()) {
            return;
        }
        if (jSONObject != null) {
            try {
                if (cn.thinkingdata.android.utils.g.b(jSONObject)) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (AutoTrackEventType autoTrackEventType : list) {
                        JSONObject jSONObject3 = new JSONObject();
                        n.v(jSONObject, jSONObject3, this.mConfig.getDefaultTimeZone());
                        jSONObject2.put(autoTrackEventType.getEventName(), jSONObject3);
                    }
                    synchronized (this.mAutoTrackEventProperties) {
                        n.A(jSONObject2, this.mAutoTrackEventProperties, this.mConfig.getDefaultTimeZone());
                    }
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (this.mConfig.shouldThrowException()) {
            throw new m("Set autoTrackEvent properties failed. Please refer to the SDK debug log for details.");
        }
    }

    public void setDynamicSuperPropertiesTracker(DynamicSuperPropertiesTracker dynamicSuperPropertiesTracker) {
        if (hasDisabled()) {
            return;
        }
        this.mDynamicSuperPropertiesTracker = dynamicSuperPropertiesTracker;
    }

    public void setDynamicSuperPropertiesTrackerListener(DynamicSuperPropertiesTrackerListener dynamicSuperPropertiesTrackerListener) {
        if (hasDisabled()) {
            return;
        }
        this.dynamicSuperPropertiesTrackerListener = dynamicSuperPropertiesTrackerListener;
    }

    public void setFromSubProcess(boolean z) {
        this.isFromSubProcess = z;
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void setJsBridge(WebView webView) {
        if (webView != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            webView.addJavascriptInterface(new TDWebAppInterface(this), "ThinkingData_APP_JS_Bridge");
            return;
        }
        TDLog.d(TAG, "SetJsBridge failed due to parameter webView is null");
        if (this.mConfig.shouldThrowException()) {
            throw new m("webView cannot be null for setJsBridge");
        }
    }

    public void setJsBridgeForX5WebView(Object obj) {
        if (obj == null) {
            TDLog.d(TAG, "SetJsBridge failed due to parameter webView is null");
            return;
        }
        try {
            obj.getClass().getMethod("addJavascriptInterface", Object.class, String.class).invoke(obj, new TDWebAppInterface(this), "ThinkingData_APP_JS_Bridge");
        } catch (Exception e2) {
            TDLog.w(TAG, "setJsBridgeForX5WebView failed: " + e2.toString());
        }
    }

    public void setNetworkType(int i2) {
        ThinkingdataNetworkType thinkingdataNetworkType;
        if (i2 == 0) {
            thinkingdataNetworkType = ThinkingdataNetworkType.NETWORKTYPE_DEFAULT;
        } else if (i2 == 1) {
            thinkingdataNetworkType = ThinkingdataNetworkType.NETWORKTYPE_WIFI;
        } else if (i2 != 2) {
            return;
        } else {
            thinkingdataNetworkType = ThinkingdataNetworkType.NETWORKTYPE_ALL;
        }
        setNetworkType(thinkingdataNetworkType);
    }

    public void setNetworkType(ThinkingdataNetworkType thinkingdataNetworkType) {
        if (hasDisabled()) {
            return;
        }
        this.mConfig.setNetworkType(thinkingdataNetworkType);
    }

    public void setSuperProperties(JSONObject jSONObject) {
        if (hasDisabled()) {
            return;
        }
        if (jSONObject != null) {
            try {
                if (cn.thinkingdata.android.utils.g.b(jSONObject)) {
                    synchronized (this.mSuperProperties) {
                        JSONObject e2 = this.mSuperProperties.e();
                        n.v(jSONObject, e2, this.mConfig.getDefaultTimeZone());
                        this.mSuperProperties.d(e2);
                    }
                    return;
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                return;
            }
        }
        if (this.mConfig.shouldThrowException()) {
            throw new m("Set super properties failed. Please refer to the SDK debug log for details.");
        }
    }

    public void setTrackStatus(TATrackStatus tATrackStatus) {
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = Boolean.FALSE;
        int i2 = a.a[tATrackStatus.ordinal()];
        if (i2 == 1) {
            this.mOptOutFlag.d(bool2);
            this.mPausePostFlag.d(bool2);
            this.mMessages.f(getToken(), false);
            enableTracking(false);
        } else if (i2 == 2) {
            this.mEnableFlag.d(bool);
            this.mPausePostFlag.d(bool2);
            this.mMessages.f(getToken(), false);
            optOutTracking();
        } else if (i2 == 3) {
            this.mEnableFlag.d(bool);
            this.mOptOutFlag.d(bool2);
            this.mPausePostFlag.d(bool);
            this.mMessages.f(getToken(), true);
        } else if (i2 != 4) {
        } else {
            this.mEnableFlag.d(bool);
            this.mOptOutFlag.d(bool2);
            this.mPausePostFlag.d(bool2);
            this.mMessages.f(getToken(), false);
            flush();
        }
    }

    public void setViewID(Dialog dialog, String str) {
        if (hasDisabled() || dialog == null) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) || dialog.getWindow() == null) {
                return;
            }
            n.t(getToken(), dialog.getWindow().getDecorView(), R.id.thinking_analytics_tag_view_id, str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setViewID(View view, String str) {
        if (hasDisabled() || view == null || TextUtils.isEmpty(str)) {
            return;
        }
        n.t(getToken(), view, R.id.thinking_analytics_tag_view_id, str);
    }

    public void setViewProperties(View view, JSONObject jSONObject) {
        if (hasDisabled() || view == null || jSONObject == null) {
            return;
        }
        n.t(getToken(), view, R.id.thinking_analytics_tag_view_properties, jSONObject);
    }

    public boolean shouldTrackCrash() {
        if (hasDisabled()) {
            return false;
        }
        return this.mTrackCrash;
    }

    public void timeEvent(String str) {
        if (hasDisabled()) {
            return;
        }
        try {
            if (cn.thinkingdata.android.utils.g.a(str)) {
                TDLog.w(TAG, "timeEvent event name[" + str + "] is not valid");
            }
            synchronized (this.mTrackTimer) {
                this.mTrackTimer.put(str, new d.a.a.c(TimeUnit.SECONDS));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void track(d.a.a.l lVar) {
        if (hasDisabled()) {
            return;
        }
        if (lVar == null) {
            TDLog.w(TAG, "Ignoring empty event...");
            return;
        }
        e time = lVar.getEventTime() != null ? getTime(lVar.getEventTime(), lVar.getTimeZone()) : getTime();
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(lVar.getExtraField())) {
            TDLog.w(TAG, "Invalid ExtraFields. Ignoring...");
        } else {
            hashMap.put(lVar.getExtraField(), ((lVar instanceof TDFirstEvent) && lVar.getExtraValue() == null) ? getDeviceId() : lVar.getExtraValue());
        }
        track(lVar.getEventName(), lVar.getProperties(), time, true, hashMap, lVar.getDataType());
    }

    public void track(String str) {
        if (hasDisabled()) {
            return;
        }
        track(str, (JSONObject) null, getTime());
    }

    public void track(String str, JSONObject jSONObject) {
        if (hasDisabled()) {
            return;
        }
        track(str, jSONObject, getTime());
    }

    public void track(String str, JSONObject jSONObject, Date date) {
        if (hasDisabled()) {
            return;
        }
        track(str, jSONObject, getTime(date, (TimeZone) null));
    }

    public void track(String str, JSONObject jSONObject, Date date, TimeZone timeZone) {
        if (hasDisabled()) {
            return;
        }
        track(str, jSONObject, getTime(date, timeZone));
    }

    public void trackAppCrashAndEndEvent(JSONObject jSONObject) {
        this.mLifecycleCallbacks.f(jSONObject);
    }

    public void trackAppInstall() {
        if (hasDisabled()) {
            return;
        }
        enableAutoTrack(new ArrayList(Collections.singletonList(AutoTrackEventType.APP_INSTALL)));
    }

    public void trackFragmentAppViewScreen() {
        if (hasDisabled()) {
            return;
        }
        this.mTrackFragmentAppViewScreen = true;
    }

    public void trackFromH5(String str) {
        if (hasDisabled() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("data");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String string = jSONObject.getString("#time");
                Double d2 = null;
                if (jSONObject.has("#zone_offset") && !TDPresetProperties.disableList.contains("#zone_offset")) {
                    d2 = Double.valueOf(jSONObject.getDouble("#zone_offset"));
                }
                e time = getTime(string, d2);
                cn.thinkingdata.android.utils.l a2 = cn.thinkingdata.android.utils.l.a(jSONObject.getString("#type"));
                if (a2 == null) {
                    TDLog.w(TAG, "Unknown data type from H5. ignoring...");
                    return;
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("properties");
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.equals("#account_id") || next.equals("#distinct_id") || this.mSystemInformation.n().containsKey(next)) {
                        keys.remove();
                    }
                }
                if (a2.b()) {
                    String string2 = jSONObject.getString("#event_name");
                    HashMap hashMap = new HashMap();
                    if (jSONObject.has("#first_check_id")) {
                        hashMap.put("#first_check_id", jSONObject.getString("#first_check_id"));
                    }
                    if (jSONObject.has("#event_id")) {
                        hashMap.put("#event_id", jSONObject.getString("#event_id"));
                    }
                    track(string2, jSONObject2, time, false, hashMap, a2);
                } else {
                    trackInternal(new d.a.a.a(this, a2, jSONObject2, time));
                }
            }
        } catch (Exception e2) {
            TDLog.w(TAG, "Exception occurred when track data from H5.");
            e2.printStackTrace();
        }
    }

    public void trackInternal(d.a.a.a aVar) {
        if (this.mConfig.isDebugOnly() || this.mConfig.isDebug()) {
            this.mMessages.i(aVar);
        } else if (aVar.f9274h) {
            this.mMessages.l(aVar);
        } else {
            this.mMessages.d(aVar);
        }
    }

    public void trackViewScreen(Activity activity) {
        if (hasDisabled() || activity == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TDPresetProperties.disableList.contains("#screen_name")) {
                jSONObject.put("#screen_name", activity.getClass().getCanonicalName());
            }
            n.u(jSONObject, activity);
            if (!(activity instanceof ScreenAutoTracker)) {
                autoTrack("ta_app_view", jSONObject);
                return;
            }
            ScreenAutoTracker screenAutoTracker = (ScreenAutoTracker) activity;
            String screenUrl = screenAutoTracker.getScreenUrl();
            JSONObject trackProperties = screenAutoTracker.getTrackProperties();
            if (trackProperties != null) {
                n.v(trackProperties, jSONObject, this.mConfig.getDefaultTimeZone());
            }
            trackViewScreenInternal(screenUrl, jSONObject);
        } catch (Exception e2) {
            TDLog.i(TAG, "trackViewScreen:" + e2);
        }
    }

    public void trackViewScreen(Fragment fragment) {
        if (hasDisabled() || fragment == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            Object canonicalName = fragment.getClass().getCanonicalName();
            String l2 = n.l(fragment, getToken());
            Activity activity = fragment.getActivity();
            if (activity != null) {
                if (TextUtils.isEmpty(l2)) {
                    l2 = n.i(activity);
                }
                canonicalName = String.format(Locale.CHINA, "%s|%s", activity.getClass().getCanonicalName(), canonicalName);
            }
            if (!TextUtils.isEmpty(l2) && !TDPresetProperties.disableList.contains("#title")) {
                jSONObject.put("#title", l2);
            }
            if (!TDPresetProperties.disableList.contains("#screen_name")) {
                jSONObject.put("#screen_name", canonicalName);
            }
            autoTrack("ta_app_view", jSONObject);
        } catch (Exception e2) {
            TDLog.i(TAG, "trackViewScreen:" + e2);
        }
    }

    public void trackViewScreen(Object obj) {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        if (hasDisabled() || obj == null) {
            return;
        }
        Activity activity = null;
        try {
            cls = Class.forName("androidx.fragment.app.Fragment");
        } catch (Exception unused) {
            cls = null;
        }
        try {
            cls2 = Class.forName("android.app.Fragment");
        } catch (Exception unused2) {
            cls2 = null;
        }
        try {
            cls3 = Class.forName("androidx.fragment.app.Fragment");
        } catch (Exception unused3) {
            cls3 = null;
        }
        if ((cls == null || !cls.isInstance(obj)) && ((cls2 == null || !cls2.isInstance(obj)) && (cls3 == null || !cls3.isInstance(obj)))) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            Object canonicalName = obj.getClass().getCanonicalName();
            String l2 = n.l(obj, getToken());
            try {
                activity = (Activity) obj.getClass().getMethod("getActivity", new Class[0]).invoke(obj, new Object[0]);
            } catch (Exception unused4) {
            }
            if (activity != null) {
                if (TextUtils.isEmpty(l2)) {
                    l2 = n.i(activity);
                }
                canonicalName = String.format(Locale.CHINA, "%s|%s", activity.getClass().getCanonicalName(), canonicalName);
            }
            if (!TextUtils.isEmpty(l2) && !TDPresetProperties.disableList.contains("#title")) {
                jSONObject.put("#title", l2);
            }
            if (!TDPresetProperties.disableList.contains("#screen_name")) {
                jSONObject.put("#screen_name", canonicalName);
            }
            autoTrack("ta_app_view", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void trackViewScreenInternal(String str, JSONObject jSONObject) {
        if (hasDisabled()) {
            return;
        }
        try {
            if (TextUtils.isEmpty(str) && jSONObject == null) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.mLastScreenUrl) && !TDPresetProperties.disableList.contains("#referrer")) {
                jSONObject2.put("#referrer", this.mLastScreenUrl);
            }
            if (!TDPresetProperties.disableList.contains("#url")) {
                jSONObject2.put("#url", str);
            }
            this.mLastScreenUrl = str;
            if (jSONObject != null) {
                n.v(jSONObject, jSONObject2, this.mConfig.getDefaultTimeZone());
            }
            autoTrack("ta_app_view", jSONObject2);
        } catch (JSONException e2) {
            TDLog.i(TAG, "trackViewScreen:" + e2);
        }
    }

    public void unsetSuperProperty(String str) {
        if (hasDisabled() || str == null) {
            return;
        }
        try {
            synchronized (this.mSuperProperties) {
                JSONObject e2 = this.mSuperProperties.e();
                e2.remove(str);
                this.mSuperProperties.d(e2);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public void user_add(String str, Number number) {
        if (hasDisabled()) {
            return;
        }
        try {
            if (number == null) {
                TDLog.d(TAG, "user_add value must be Number");
                if (this.mConfig.shouldThrowException()) {
                    throw new m("Invalid property values for user add.");
                }
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(str, number);
            user_add(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
            if (this.mConfig.shouldThrowException()) {
                throw new m(e2);
            }
        }
    }

    public void user_add(JSONObject jSONObject) {
        user_add(jSONObject, (Date) null);
    }

    public void user_add(JSONObject jSONObject, Date date) {
        if (hasDisabled()) {
            return;
        }
        user_operations(cn.thinkingdata.android.utils.l.USER_ADD, jSONObject, date);
    }

    public void user_append(JSONObject jSONObject) {
        user_append(jSONObject, null);
    }

    public void user_append(JSONObject jSONObject, Date date) {
        if (hasDisabled()) {
            return;
        }
        user_operations(cn.thinkingdata.android.utils.l.USER_APPEND, jSONObject, date);
    }

    public void user_delete() {
        user_delete(null);
    }

    public void user_delete(Date date) {
        if (hasDisabled()) {
            return;
        }
        user_operations(cn.thinkingdata.android.utils.l.USER_DEL, null, date);
    }

    public void user_operations(cn.thinkingdata.android.utils.l lVar, JSONObject jSONObject, Date date) {
        if (hasDisabled()) {
            return;
        }
        if (!cn.thinkingdata.android.utils.g.b(jSONObject)) {
            TDLog.w(TAG, "The data contains invalid key or value: " + jSONObject.toString());
            if (this.mConfig.shouldThrowException()) {
                throw new m("Invalid properties. Please refer to SDK debug log for detail reasons.");
            }
        }
        try {
            e time = date == null ? getTime() : getTime(date, (TimeZone) null);
            JSONObject jSONObject2 = new JSONObject();
            if (jSONObject != null) {
                n.v(jSONObject, jSONObject2, this.mConfig.getDefaultTimeZone());
            }
            trackInternal(new d.a.a.a(this, lVar, jSONObject2, time));
        } catch (Exception e2) {
            TDLog.w(TAG, e2.getMessage());
        }
    }

    public void user_set(JSONObject jSONObject) {
        user_set(jSONObject, null);
    }

    public void user_set(JSONObject jSONObject, Date date) {
        user_operations(cn.thinkingdata.android.utils.l.USER_SET, jSONObject, date);
    }

    public void user_setOnce(JSONObject jSONObject) {
        user_setOnce(jSONObject, null);
    }

    public void user_setOnce(JSONObject jSONObject, Date date) {
        if (hasDisabled()) {
            return;
        }
        user_operations(cn.thinkingdata.android.utils.l.USER_SET_ONCE, jSONObject, date);
    }

    public void user_uniqAppend(JSONObject jSONObject) {
        user_uniqAppend(jSONObject, null);
    }

    public void user_uniqAppend(JSONObject jSONObject, Date date) {
        user_operations(cn.thinkingdata.android.utils.l.USER_UNIQ_APPEND, jSONObject, date);
    }

    public void user_unset(JSONObject jSONObject, Date date) {
        if (hasDisabled()) {
            return;
        }
        user_operations(cn.thinkingdata.android.utils.l.USER_UNSET, jSONObject, date);
    }

    public void user_unset(String... strArr) {
        if (hasDisabled() || strArr == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : strArr) {
            try {
                jSONObject.put(str, 0);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (jSONObject.length() > 0) {
            user_unset(jSONObject, null);
        }
    }
}
