package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.util.HiAnalyticTools;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.c;
import com.huawei.hms.support.log.HMSLog;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class HiAnalyticsUtils {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f3685c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static final Object f3686d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static HiAnalyticsUtils f3687e;
    public int a = 0;
    public boolean b = c.a();

    public static LinkedHashMap<String, String> a(Map<String, String> map) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static HiAnalyticsUtils getInstance() {
        HiAnalyticsUtils hiAnalyticsUtils;
        synchronized (f3685c) {
            if (f3687e == null) {
                f3687e = new HiAnalyticsUtils();
            }
            hiAnalyticsUtils = f3687e;
        }
        return hiAnalyticsUtils;
    }

    public static String versionCodeToName(String str) {
        if (!TextUtils.isEmpty(str) && (str.length() == 8 || str.length() == 9)) {
            try {
                Integer.parseInt(str);
                return Integer.parseInt(str.substring(0, str.length() - 7)) + "." + Integer.parseInt(str.substring(str.length() - 7, str.length() - 5)) + "." + Integer.parseInt(str.substring(str.length() - 5, str.length() - 3)) + "." + Integer.parseInt(str.substring(str.length() - 3));
            } catch (NumberFormatException unused) {
            }
        }
        return "";
    }

    public void enableLog(Context context) {
        HMSLog.i("HiAnalyticsUtils", "Enable Log");
        if (!this.b) {
            HmsHiAnalyticsUtils.enableLog();
        } else {
            HiAnalyticTools.enableLog(context);
        }
    }

    public boolean getInitFlag() {
        if (!this.b) {
            return HmsHiAnalyticsUtils.getInitFlag();
        }
        return HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    public boolean hasError(Context context) {
        return com.huawei.hms.stats.a.c(context);
    }

    public void onBuoyEvent(Context context, String str, String str2) {
        if (hasError(context) || context == null) {
            return;
        }
        onEvent2(context, str, str2);
    }

    public void onEvent(Context context, String str, Map<String, String> map) {
        if (hasError(context) || map == null || map.isEmpty() || context == null || !getInitFlag()) {
            return;
        }
        if (!this.b) {
            HmsHiAnalyticsUtils.onEvent(0, str, a(map));
            HmsHiAnalyticsUtils.onEvent(1, str, a(map));
        } else {
            com.huawei.hms.stats.b.a(context, 0, str, a(map));
            com.huawei.hms.stats.b.a(context, 1, str, a(map));
        }
        a(context);
    }

    public void onEvent2(Context context, String str, String str2) {
        if (hasError(context) || context == null || !getInitFlag()) {
            return;
        }
        if (!this.b) {
            HmsHiAnalyticsUtils.onEvent(context, str, str2);
        } else {
            com.huawei.hms.stats.b.a(context, str, str2);
        }
    }

    public void onNewEvent(Context context, String str, Map map) {
        if (hasError(context) || map == null || map.isEmpty() || context == null || !getInitFlag()) {
            return;
        }
        if (!this.b) {
            HmsHiAnalyticsUtils.onEvent(0, str, a(map));
            HmsHiAnalyticsUtils.onEvent(1, str, a(map));
        } else {
            com.huawei.hms.stats.b.a(context, 0, str, a(map));
            com.huawei.hms.stats.b.a(context, 1, str, a(map));
        }
        a(context);
    }

    public void onReport(Context context, String str, Map map) {
        if (hasError(context) || map == null || map.isEmpty() || context == null || !getInitFlag()) {
            return;
        }
        if (!this.b) {
            HmsHiAnalyticsUtils.onEvent(0, str, a(map));
            HmsHiAnalyticsUtils.onEvent(1, str, a(map));
            HmsHiAnalyticsUtils.onReport();
            return;
        }
        com.huawei.hms.stats.b.a(context, 0, str, a(map));
        com.huawei.hms.stats.b.a(context, 1, str, a(map));
        com.huawei.hms.stats.b.a(context, 0);
        com.huawei.hms.stats.b.a(context, 1);
    }

    public void enableLog() {
        HMSLog.i("HiAnalyticsUtils", "Enable Log");
        if (!this.b) {
            HmsHiAnalyticsUtils.enableLog();
        } else {
            HMSLog.i("HiAnalyticsUtils", "cp needs to pass in the context, this method is not supported");
        }
    }

    public final void a(Context context) {
        synchronized (f3686d) {
            int i2 = this.a;
            if (i2 < 60) {
                this.a = i2 + 1;
            } else {
                this.a = 0;
                if (!this.b) {
                    HmsHiAnalyticsUtils.onReport();
                } else {
                    com.huawei.hms.stats.b.a(context, 0);
                    com.huawei.hms.stats.b.a(context, 1);
                }
            }
        }
    }

    public void onNewEvent(Context context, String str, Map map, int i2) {
        if (hasError(context)) {
            return;
        }
        if (i2 != 0 && i2 != 1) {
            HMSLog.e("HiAnalyticsUtils", "Data reporting type is not supported");
        } else if (map == null || map.isEmpty() || context == null || !getInitFlag()) {
        } else {
            if (!this.b) {
                HmsHiAnalyticsUtils.onEvent(i2, str, a(map));
            } else {
                com.huawei.hms.stats.b.a(context, i2, str, a(map));
            }
            a(context);
        }
    }

    public void onReport(Context context, String str, Map map, int i2) {
        if (hasError(context)) {
            return;
        }
        if (i2 != 0 && i2 != 1) {
            HMSLog.e("HiAnalyticsUtils", "Data reporting type is not supported");
        } else if (map == null || map.isEmpty() || context == null || !getInitFlag()) {
        } else {
            if (!this.b) {
                HmsHiAnalyticsUtils.onEvent(i2, str, a(map));
                HmsHiAnalyticsUtils.onReport();
                return;
            }
            com.huawei.hms.stats.b.a(context, i2, str, a(map));
            com.huawei.hms.stats.b.a(context, i2);
        }
    }
}
