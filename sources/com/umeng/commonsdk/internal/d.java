package com.umeng.commonsdk.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.inputmethod.InputMethodInfo;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.umeng.analytics.pro.am;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.a;
import com.umeng.commonsdk.internal.utils.d;
import com.umeng.commonsdk.internal.utils.j;
import com.umeng.commonsdk.internal.utils.k;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class d {
    public static void a(Context context) {
        try {
            ULog.i("walle", "[internal] workEvent send envelope");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(am.aN, a.f7392e);
            JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, d(context), UMServerURL.PATH_ANALYTICS, "i", a.f7392e);
            if (buildEnvelopeWithExtHeader == null || buildEnvelopeWithExtHeader.has("exception")) {
                return;
            }
            ULog.i("walle", "[internal] workEvent send envelope back, result is ok");
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
        }
    }

    public static void b(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context != null) {
            j(context);
        }
    }

    public static void c(Context context) {
        ULog.i("walle", "[internal] begin by stateful--->>>");
        if (context == null || !UMEnvelopeBuild.getTransmissionSendFlag()) {
            return;
        }
        j(context);
    }

    public static JSONObject d(Context context) {
        JSONObject b;
        JSONArray h2;
        JSONObject a;
        JSONArray l2;
        JSONArray k2;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.J) && (k2 = k(applicationContext)) != null && k2.length() > 0) {
                    jSONObject2.put("rs", k2);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(applicationContext, e2);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.ao) && (l2 = l(applicationContext)) != null && l2.length() > 0) {
                    jSONObject2.put("by", l2);
                }
            } catch (Exception e3) {
                UMCrashManager.reportCrash(applicationContext, e3);
            }
            try {
                a(applicationContext, jSONObject2);
            } catch (Exception e4) {
                UMCrashManager.reportCrash(applicationContext, e4);
            }
            try {
                b(applicationContext, jSONObject2);
            } catch (Exception e5) {
                UMCrashManager.reportCrash(applicationContext, e5);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.ap) && (a = a()) != null && a.length() > 0) {
                    jSONObject2.put("build", a);
                }
            } catch (Exception e6) {
                UMCrashManager.reportCrash(applicationContext, e6);
            }
            try {
                JSONObject e7 = e(applicationContext);
                if (e7 != null && e7.length() > 0) {
                    jSONObject2.put("scr", e7);
                }
            } catch (Exception e8) {
                UMCrashManager.reportCrash(applicationContext, e8);
            }
            try {
                JSONObject f2 = f(applicationContext);
                if (f2 != null && f2.length() > 0) {
                    jSONObject2.put("sinfo", f2);
                }
            } catch (Exception e9) {
                UMCrashManager.reportCrash(applicationContext, e9);
            }
            try {
                JSONArray g2 = g(applicationContext);
                if (g2 != null && g2.length() > 0) {
                    jSONObject2.put("input", g2);
                }
            } catch (Exception e10) {
                UMCrashManager.reportCrash(applicationContext, e10);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.ag) && (h2 = h(applicationContext)) != null && h2.length() > 0) {
                    jSONObject2.put("appls", h2);
                }
            } catch (Exception e11) {
                UMCrashManager.reportCrash(applicationContext, e11);
            }
            try {
                JSONObject i2 = i(applicationContext);
                if (i2 != null && i2.length() > 0) {
                    jSONObject2.put("mem", i2);
                }
            } catch (Exception e12) {
                UMCrashManager.reportCrash(applicationContext, e12);
            }
            try {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.aq) && (b = b()) != null && b.length() > 0) {
                    jSONObject2.put("cpu", b);
                }
            } catch (Exception unused) {
            }
            try {
                jSONObject.put("inner", jSONObject2);
            } catch (JSONException e13) {
                UMCrashManager.reportCrash(applicationContext, e13);
            }
        }
        return jSONObject;
    }

    public static JSONObject e(Context context) {
        DisplayMetrics displayMetrics;
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            try {
                jSONObject.put("a_st_h", com.umeng.commonsdk.internal.utils.a.c(context));
                jSONObject.put("a_nav_h", com.umeng.commonsdk.internal.utils.a.d(context));
                if (context.getResources() != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
                    jSONObject.put("a_den", displayMetrics.density);
                    jSONObject.put("a_dpi", displayMetrics.densityDpi);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(context, e2);
            }
        }
        return jSONObject;
    }

    public static JSONObject f(Context context) {
        JSONObject jSONObject = new JSONObject();
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            String packageName = applicationContext.getPackageName();
            try {
                jSONObject.put("a_fit", com.umeng.commonsdk.internal.utils.a.a(applicationContext, packageName));
                jSONObject.put("a_alut", com.umeng.commonsdk.internal.utils.a.b(applicationContext, packageName));
                jSONObject.put("a_c", com.umeng.commonsdk.internal.utils.a.c(applicationContext, packageName));
                jSONObject.put("a_uid", com.umeng.commonsdk.internal.utils.a.d(applicationContext, packageName));
                if (com.umeng.commonsdk.internal.utils.a.a()) {
                    jSONObject.put("a_root", 1);
                } else {
                    jSONObject.put("a_root", 0);
                }
                jSONObject.put("tf", com.umeng.commonsdk.internal.utils.a.b());
                jSONObject.put("s_fs", com.umeng.commonsdk.internal.utils.a.a(applicationContext));
                jSONObject.put("a_meid", DeviceConfig.getMeid(applicationContext));
                jSONObject.put("a_imsi", DeviceConfig.getImsi(applicationContext));
                jSONObject.put("st", com.umeng.commonsdk.internal.utils.a.c());
                String simICCID = DeviceConfig.getSimICCID(applicationContext);
                if (!TextUtils.isEmpty(simICCID)) {
                    try {
                        jSONObject.put("a_iccid", simICCID);
                    } catch (Exception unused) {
                    }
                }
                String secondSimIMEi = DeviceConfig.getSecondSimIMEi(applicationContext);
                if (!TextUtils.isEmpty(secondSimIMEi)) {
                    try {
                        jSONObject.put("a_simei", secondSimIMEi);
                    } catch (Exception unused2) {
                    }
                }
                jSONObject.put(AdvanceSetting.HEAD_UP_NOTIFICATION, com.umeng.commonsdk.internal.utils.a.d());
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e2) {
                UMCrashManager.reportCrash(applicationContext, e2);
            }
        }
        return jSONObject;
    }

    public static JSONArray g(Context context) {
        Context applicationContext;
        List<InputMethodInfo> f2;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (f2 = com.umeng.commonsdk.internal.utils.a.f((applicationContext = context.getApplicationContext()))) != null) {
            for (InputMethodInfo inputMethodInfo : f2) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("a_id", inputMethodInfo.getId());
                    jSONObject.put("a_pn", inputMethodInfo.getPackageName());
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONArray.put(jSONObject);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(applicationContext, th);
                }
            }
        }
        return jSONArray;
    }

    public static JSONArray h(Context context) {
        Context applicationContext;
        List<a.C0286a> g2;
        JSONArray jSONArray = new JSONArray();
        if (context != null && (g2 = com.umeng.commonsdk.internal.utils.a.g((applicationContext = context.getApplicationContext()))) != null && !g2.isEmpty()) {
            for (a.C0286a c0286a : g2) {
                if (c0286a != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("a_pn", c0286a.a);
                        jSONObject.put("a_la", c0286a.b);
                        jSONObject.put("ts", System.currentTimeMillis());
                        jSONArray.put(jSONObject);
                    } catch (Exception e2) {
                        UMCrashManager.reportCrash(applicationContext, e2);
                    }
                }
            }
        }
        return jSONArray;
    }

    public static JSONObject i(Context context) {
        Context applicationContext;
        ActivityManager.MemoryInfo h2;
        JSONObject jSONObject = new JSONObject();
        if (context != null && (h2 = com.umeng.commonsdk.internal.utils.a.h((applicationContext = context.getApplicationContext()))) != null) {
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    jSONObject.put(am.aI, h2.totalMem);
                }
                jSONObject.put("f", h2.availMem);
                jSONObject.put("ts", System.currentTimeMillis());
            } catch (Exception e2) {
                UMCrashManager.reportCrash(applicationContext, e2);
            }
        }
        return jSONObject;
    }

    private static void j(Context context) {
        try {
            if (UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                UMWorkDispatch.sendEvent(context, a.f7393f, b.a(context).a(), null, 5000L);
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 冷启动：5秒后触发2号数据仓遗留信封检查动作。");
            UMWorkDispatch.sendEvent(context, a.v, b.a(context).a(), null, 5000L);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    private static JSONArray k(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        JSONArray jSONArray = null;
        if (context == null) {
            return null;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
            if (activityManager == null || (runningServices = activityManager.getRunningServices(Integer.MAX_VALUE)) == null || runningServices.isEmpty()) {
                return null;
            }
            for (int i2 = 0; i2 < runningServices.size(); i2++) {
                if (runningServices.get(i2) != null && runningServices.get(i2).service != null && runningServices.get(i2).service.getClassName() != null && runningServices.get(i2).service.getPackageName() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("sn", runningServices.get(i2).service.getClassName().toString());
                        jSONObject.put("pn", runningServices.get(i2).service.getPackageName().toString());
                        if (jSONArray == null) {
                            jSONArray = new JSONArray();
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException unused) {
                    }
                }
            }
            if (jSONArray != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ts", System.currentTimeMillis());
                    jSONObject2.put("ls", jSONArray);
                } catch (JSONException unused2) {
                }
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("sers", jSONObject2);
                } catch (JSONException unused3) {
                }
                JSONArray jSONArray2 = new JSONArray();
                try {
                    jSONArray2.put(jSONObject3);
                    return jSONArray2;
                } catch (Throwable th) {
                    th = th;
                    jSONArray = jSONArray2;
                    UMCrashManager.reportCrash(context, th);
                    return jSONArray;
                }
            }
            return jSONArray;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static JSONArray l(Context context) {
        JSONArray jSONArray = new JSONArray();
        String a = j.a(context);
        if (!TextUtils.isEmpty(a)) {
            try {
                jSONArray.put(new JSONObject(a));
            } catch (Exception unused) {
            }
        }
        return jSONArray;
    }

    private static JSONObject b() {
        try {
            d.a a = com.umeng.commonsdk.internal.utils.d.a();
            if (a != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("pro", a.a);
                    jSONObject.put("pla", a.b);
                    jSONObject.put("cpus", a.f7419c);
                    jSONObject.put("fea", a.f7420d);
                    jSONObject.put("imp", a.f7421e);
                    jSONObject.put("arc", a.f7422f);
                    jSONObject.put("var", a.f7423g);
                    jSONObject.put("par", a.f7424h);
                    jSONObject.put("rev", a.f7425i);
                    jSONObject.put("har", a.f7426j);
                    jSONObject.put("rev", a.f7427k);
                    jSONObject.put("ser", a.f7428l);
                    jSONObject.put("cur_cpu", com.umeng.commonsdk.internal.utils.d.d());
                    jSONObject.put("max_cpu", com.umeng.commonsdk.internal.utils.d.b());
                    jSONObject.put("min_cpu", com.umeng.commonsdk.internal.utils.d.c());
                    jSONObject.put("ts", System.currentTimeMillis());
                } catch (Exception unused) {
                }
                return jSONObject;
            }
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getApplicationContext().getPackageManager()) == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        a(jSONObject, "gp", packageManager.hasSystemFeature("android.hardware.location.gps"));
        a(jSONObject, "to", packageManager.hasSystemFeature("android.hardware.touchscreen"));
        a(jSONObject, "mo", packageManager.hasSystemFeature("android.hardware.telephony"));
        a(jSONObject, "ca", packageManager.hasSystemFeature("android.hardware.camera"));
        a(jSONObject, "fl", packageManager.hasSystemFeature("android.hardware.camera.flash"));
    }

    private static void a(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (z) {
                jSONObject.put(str, 1);
            } else {
                jSONObject.put(str, 0);
            }
        } catch (Exception unused) {
        }
    }

    public static JSONObject a() {
        int i2 = Build.VERSION.SDK_INT;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("a_pr", Build.PRODUCT);
            jSONObject.put("a_bl", Build.BOOTLOADER);
            if (i2 >= 14) {
                jSONObject.put("a_rv", Build.getRadioVersion());
            }
            jSONObject.put("a_fp", Build.FINGERPRINT);
            jSONObject.put("a_hw", Build.HARDWARE);
            jSONObject.put("a_host", Build.HOST);
            int i3 = 0;
            if (i2 >= 21) {
                JSONArray jSONArray = new JSONArray();
                int i4 = 0;
                while (true) {
                    String[] strArr = Build.SUPPORTED_32_BIT_ABIS;
                    if (i4 >= strArr.length) {
                        break;
                    }
                    jSONArray.put(strArr[i4]);
                    i4++;
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("a_s32", jSONArray);
                }
            }
            if (i2 >= 21) {
                JSONArray jSONArray2 = new JSONArray();
                int i5 = 0;
                while (true) {
                    String[] strArr2 = Build.SUPPORTED_64_BIT_ABIS;
                    if (i5 >= strArr2.length) {
                        break;
                    }
                    jSONArray2.put(strArr2[i5]);
                    i5++;
                }
                if (jSONArray2.length() > 0) {
                    jSONObject.put("a_s64", jSONArray2);
                }
            }
            if (i2 >= 21) {
                JSONArray jSONArray3 = new JSONArray();
                while (true) {
                    String[] strArr3 = Build.SUPPORTED_ABIS;
                    if (i3 >= strArr3.length) {
                        break;
                    }
                    jSONArray3.put(strArr3[i3]);
                    i3++;
                }
                if (jSONArray3.length() > 0) {
                    jSONObject.put("a_sa", jSONArray3);
                }
            }
            jSONObject.put("a_ta", Build.TAGS);
            jSONObject.put("a_uk", "unknown");
            jSONObject.put("a_user", Build.USER);
            jSONObject.put("a_cpu1", Build.CPU_ABI);
            jSONObject.put("a_cpu2", Build.CPU_ABI2);
            jSONObject.put("a_ra", Build.RADIO);
            if (i2 >= 23) {
                jSONObject.put("a_bos", Build.VERSION.BASE_OS);
                jSONObject.put("a_pre", Build.VERSION.PREVIEW_SDK_INT);
                jSONObject.put("a_sp", Build.VERSION.SECURITY_PATCH);
            }
            jSONObject.put("a_cn", Build.VERSION.CODENAME);
            jSONObject.put("a_intl", Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private static void b(Context context, JSONObject jSONObject) {
        if (context != null) {
            String a = k.a(context);
            if (TextUtils.isEmpty(a)) {
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(a);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                if (jSONObject2.has(k.f7432d)) {
                    jSONObject.put(k.f7432d, jSONObject2.opt(k.f7432d));
                }
                if (jSONObject2.has(k.f7431c)) {
                    jSONObject.put(k.f7431c, jSONObject2.opt(k.f7431c));
                }
                if (jSONObject2.has(k.b)) {
                    jSONObject.put(k.b, jSONObject2.opt(k.b));
                }
            } catch (Exception unused) {
            }
        }
    }
}
