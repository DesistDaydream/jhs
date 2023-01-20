package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.e;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.y;
import com.umeng.analytics.process.UMProcessDBDatasSender;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class u implements y.a {
    public static final String a = "session_start_time";
    public static final String b = "session_end_time";

    /* renamed from: c */
    public static final String f7268c = "session_id";

    /* renamed from: d */
    public static final String f7269d = "pre_session_id";

    /* renamed from: e */
    public static final String f7270e = "a_start_time";

    /* renamed from: f */
    public static final String f7271f = "a_end_time";

    /* renamed from: g */
    public static final String f7272g = "fg_count";

    /* renamed from: h */
    private static String f7273h = null;

    /* renamed from: i */
    private static Context f7274i = null;

    /* renamed from: j */
    private static boolean f7275j = false;

    /* renamed from: k */
    private static long f7276k = 0;

    /* renamed from: l */
    private static boolean f7277l = true;

    /* renamed from: m */
    private static long f7278m;

    /* loaded from: classes3.dex */
    public static class a {
        private static final u a = new u();

        private a() {
        }
    }

    public static u a() {
        return a.a;
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f7274i);
        if (sharedPreferences != null) {
            long j2 = sharedPreferences.getLong(f7272g, 0L);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.putLong(f7272g, j2 + 1);
                edit.commit();
            }
        }
    }

    private void d(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putLong(f7272g, 0L);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private String e(Context context) {
        if (f7274i == null && context != null) {
            f7274i = context.getApplicationContext();
        }
        String d2 = y.a().d(f7274i);
        try {
            f(context);
            o.a(f7274i).d((Object) null);
        } catch (Throwable unused) {
        }
        return d2;
    }

    private void f(Context context) {
        o.a(context).b(context);
        o.a(context).d();
    }

    public void c(Context context, Object obj) {
        try {
            if (f7274i == null && context != null) {
                f7274i = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            if (sharedPreferences.getLong(f7270e, 0L) == 0) {
                MLog.e("onPause called before onResume");
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onEndSessionInternal: write activity end time = " + longValue);
            edit.putLong(f7271f, longValue);
            edit.putLong(b, longValue);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private u() {
        y.a().a(this);
    }

    public static long a(Context context) {
        try {
            return PreferenceWrapper.getDefault(context).getLong(f7272g, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public void a(Context context, long j2) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f7274i);
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putLong(a, j2);
        edit.commit();
    }

    public void b(Context context, Object obj) {
        long longValue;
        try {
            if (f7274i == null) {
                f7274i = UMGlobalContext.getAppContext(context);
            }
            if (obj == null) {
                longValue = System.currentTimeMillis();
            } else {
                longValue = ((Long) obj).longValue();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f7274i);
            if (sharedPreferences == null) {
                return;
            }
            f7276k = sharedPreferences.getLong(f7271f, 0L);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime: " + f7276k);
            String string = sharedPreferences.getString(d.az, "");
            String appVersionName = UMUtils.getAppVersionName(f7274i);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null) {
                return;
            }
            if (!TextUtils.isEmpty(string) && !string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> requestNewInstantSessionIf: version upgrade");
                edit.putLong(a, longValue);
                edit.commit();
                o.a(f7274i).a((Object) null, true);
                String c2 = y.a().c(f7274i);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> force generate new session: session id = " + c2);
                f7275j = true;
                a(f7274i, longValue, true);
            } else if (y.a().e(f7274i)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> More then 30 sec from last session.");
                f7275j = true;
                edit.putLong(a, longValue);
                edit.commit();
                a(f7274i, longValue, false);
            } else {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> less then 30 sec from last session, do nothing.");
                f7275j = false;
            }
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, Object obj) {
        SharedPreferences.Editor edit;
        try {
            if (f7274i == null && context != null) {
                f7274i = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f7274i);
            if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                return;
            }
            String string = sharedPreferences.getString(d.az, "");
            String appVersionName = UMUtils.getAppVersionName(f7274i);
            if (TextUtils.isEmpty(string)) {
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(d.az, appVersionName);
                edit.commit();
            } else if (!string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                int i2 = sharedPreferences.getInt("versioncode", 0);
                String string2 = sharedPreferences.getString("pre_date", "");
                String string3 = sharedPreferences.getString("pre_version", "");
                String string4 = sharedPreferences.getString(d.az, "");
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(d.az, appVersionName);
                edit.putString("vers_date", string2);
                edit.putString("vers_pre_version", string3);
                edit.putString("cur_version", string4);
                edit.putInt("vers_code", i2);
                edit.putString("vers_name", string);
                edit.commit();
                if (f7277l) {
                    f7277l = false;
                }
                if (f7275j) {
                    f7275j = false;
                    b(f7274i, longValue, true);
                    b(f7274i, longValue);
                    return;
                }
                return;
            }
            if (f7275j) {
                f7275j = false;
                if (f7277l) {
                    f7277l = false;
                }
                f7273h = e(context);
                MLog.d("创建新会话: " + f7273h);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "mSessionChanged flag has been set, Start new session: " + f7273h);
                return;
            }
            f7273h = sharedPreferences.getString("session_id", null);
            edit.putLong(f7270e, longValue);
            edit.putLong(f7271f, 0L);
            edit.commit();
            MLog.d("延续上一个会话: " + f7273h);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "Extend current session: " + f7273h);
            if (f7277l) {
                f7277l = false;
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    Context context2 = f7274i;
                    UMWorkDispatch.sendEventEx(context2, o.a.D, CoreProtocol.getInstance(context2), null, 0L);
                }
            }
            f(context);
            o.a(f7274i).a(false);
        } catch (Throwable unused) {
        }
    }

    public String c(Context context) {
        try {
            if (f7273h == null) {
                return PreferenceWrapper.getDefault(context).getString("session_id", null);
            }
        } catch (Throwable unused) {
        }
        return f7273h;
    }

    public String c() {
        return c(f7274i);
    }

    public boolean b(Context context, long j2, boolean z) {
        SharedPreferences sharedPreferences;
        String a2;
        long j3;
        boolean z2 = false;
        try {
            sharedPreferences = PreferenceWrapper.getDefault(context);
        } catch (Throwable unused) {
        }
        if (sharedPreferences == null || (a2 = y.a().a(f7274i)) == null) {
            return false;
        }
        long j4 = sharedPreferences.getLong(f7270e, 0L);
        long j5 = sharedPreferences.getLong(f7271f, 0L);
        if (j4 > 0 && j5 == 0) {
            z2 = true;
            if (z) {
                j3 = f7276k;
                if (j3 == 0) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime = 0, In-app upgrade, use currentTime: = " + j2);
                    j3 = j2;
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime != 0, app upgrade, use lastActivityEndTime: = " + f7276k);
                }
                c(f7274i, Long.valueOf(j3));
            } else {
                c(f7274i, Long.valueOf(j2));
                j3 = j2;
            }
            JSONObject jSONObject = new JSONObject();
            if (z) {
                jSONObject.put(e.d.a.f7171g, j3);
            } else {
                jSONObject.put(e.d.a.f7171g, j2);
            }
            JSONObject b2 = com.umeng.analytics.b.a().b();
            if (b2 != null && b2.length() > 0) {
                jSONObject.put("__sp", b2);
            }
            JSONObject c2 = com.umeng.analytics.b.a().c();
            if (c2 != null && c2.length() > 0) {
                jSONObject.put("__pp", c2);
            }
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foregroundCount = " + f7278m);
                jSONObject.put(e.d.a.f7172h, f7278m);
                f7278m = 0L;
            } else {
                jSONObject.put(e.d.a.f7172h, 0L);
            }
            i.a(context).a(a2, jSONObject, i.a.END);
            o.a(f7274i).e();
        }
        return z2;
    }

    public void b(Context context, long j2) {
        if (PreferenceWrapper.getDefault(context) == null) {
            return;
        }
        try {
            o.a(f7274i).c((Object) null);
        } catch (Throwable unused) {
        }
    }

    public String a(Context context, long j2, boolean z) {
        String b2 = y.a().b(context);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onInstantSessionInternal: current session id = " + b2);
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j2);
            JSONObject b3 = com.umeng.analytics.b.a().b();
            if (b3 != null && b3.length() > 0) {
                jSONObject.put("__sp", b3);
            }
            JSONObject c2 = com.umeng.analytics.b.a().c();
            if (c2 != null && c2.length() > 0) {
                jSONObject.put("__pp", c2);
            }
            i.a(context).a(b2, jSONObject, i.a.INSTANTSESSIONBEGIN);
            o.a(context).a(jSONObject, z);
        } catch (Throwable unused) {
        }
        return b2;
    }

    public String b() {
        return f7273h;
    }

    @Override // com.umeng.analytics.pro.y.a
    public void a(String str, String str2, long j2, long j3, long j4) {
        a(f7274i, str2, j2, j3, j4);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            Context context = f7274i;
            UMWorkDispatch.sendEvent(context, UMProcessDBDatasSender.UM_PROCESS_EVENT_KEY, UMProcessDBDatasSender.getInstance(context), Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.umeng.analytics.pro.y.a
    public void a(String str, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, j2);
    }

    private void a(Context context, String str, long j2, long j3, long j4) {
        if (TextUtils.isEmpty(f7273h)) {
            f7273h = y.a().a(f7274i);
        }
        if (TextUtils.isEmpty(str) || str.equals(f7273h)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(e.d.a.f7171g, j3);
            jSONObject.put(e.d.a.f7172h, j4);
            JSONObject b2 = com.umeng.analytics.b.a().b();
            if (b2 != null && b2.length() > 0) {
                jSONObject.put("__sp", b2);
            }
            JSONObject c2 = com.umeng.analytics.b.a().c();
            if (c2 != null && c2.length() > 0) {
                jSONObject.put("__pp", c2);
            }
            i.a(context).a(f7273h, jSONObject, i.a.END);
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__e", j2);
            i.a(context).a(str, jSONObject2, i.a.BEGIN);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                f7278m = j4;
                d(context);
                Context context2 = f7274i;
                UMWorkDispatch.sendEventEx(context2, o.a.D, CoreProtocol.getInstance(context2), null, 0L);
            }
        } catch (Exception unused2) {
        }
        f7273h = str;
    }

    private void a(String str, long j2) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f7274i);
        if (sharedPreferences == null) {
            return;
        }
        long j3 = sharedPreferences.getLong(b, 0L);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", str);
            jSONObject.put("__e", j2);
            jSONObject.put(e.d.a.f7171g, j3);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(d.C, location[0]);
                jSONObject2.put(d.D, location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put(e.d.a.f7169e, jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("getUidRxBytes", cls2);
            Method method2 = cls.getMethod("getUidTxBytes", cls2);
            int i2 = f7274i.getApplicationInfo().uid;
            if (i2 == -1) {
                return;
            }
            long longValue = ((Long) method.invoke(null, Integer.valueOf(i2))).longValue();
            long longValue2 = ((Long) method2.invoke(null, Integer.valueOf(i2))).longValue();
            if (longValue > 0 && longValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(d.H, longValue);
                jSONObject3.put(d.G, longValue2);
                jSONObject.put(e.d.a.f7168d, jSONObject3);
            }
            i.a(f7274i).a(str, jSONObject, i.a.NEWSESSION);
            v.a(f7274i);
            l.c(f7274i);
        } catch (Throwable unused) {
        }
    }
}
