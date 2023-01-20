package com.tencent.tpns.baseapi.core;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.PushMd5Pref;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.baseapi.core.c.a;
import java.net.URL;

/* loaded from: classes3.dex */
public class a {
    private static volatile long a = -1;
    private static volatile String b = "";

    /* renamed from: c */
    private static volatile long f6874c = -1;

    /* renamed from: d */
    private static String f6875d = null;

    /* renamed from: e */
    private static String f6876e = null;

    /* renamed from: f */
    private static String f6877f = null;

    /* renamed from: g */
    private static String f6878g = null;

    /* renamed from: h */
    private static String f6879h = null;

    /* renamed from: i */
    private static String f6880i = null;

    /* renamed from: j */
    private static String f6881j = null;

    /* renamed from: k */
    private static int f6882k = -1;

    public static synchronized long a(Context context) {
        Object metaData;
        synchronized (a.class) {
            if (context == null) {
                return a;
            }
            if (a != -1) {
                return a;
            }
            a = PushPreferences.getLong(context, XGPushConfig.TPUSH_ACCESS_ID, -1L);
            if (a == -1 && (metaData = CommonHelper.getMetaData(context, XGPushConfig.TPUSH_ACCESS_ID, null)) != null) {
                a = Long.valueOf(metaData.toString()).longValue();
            }
            if (a == -1) {
                Logger.e("XGApiConfigImpl", "accessId没有初始化");
            }
            return a;
        }
    }

    public static synchronized String b(Context context) {
        Object metaData;
        synchronized (a.class) {
            if (!Util.isNullOrEmptyString(b)) {
                return b;
            }
            b = PushPreferences.getString(context, XGPushConfig.TPUSH_ACCESS_KEY, null);
            if (Util.isNullOrEmptyString(b) && (metaData = CommonHelper.getMetaData(context, XGPushConfig.TPUSH_ACCESS_KEY, null)) != null) {
                b = metaData.toString();
            }
            if (Util.isNullOrEmptyString(b)) {
                Logger.e("XGApiConfigImpl", "accessKey is null");
            }
            return b;
        }
    }

    public static String c(Context context) {
        Object metaData;
        Object metaData2;
        if (TextUtils.isEmpty(f6875d)) {
            f6875d = PushPreferences.getString(context, "XG_SERVER_SUFFIX", null);
        }
        if (TextUtils.isEmpty(f6875d) && (metaData2 = CommonHelper.getMetaData(context, "XG_SERVER_SUFFIX", null)) != null) {
            f6875d = metaData2.toString();
        }
        if (TextUtils.isEmpty(f6875d)) {
            try {
                String string = PushPreferences.getString(context, "XG_GUID_SERVER", null);
                if (TextUtils.isEmpty(string) && (metaData = CommonHelper.getMetaData(context, "XG_GUID_SERVER", null)) != null) {
                    string = metaData.toString();
                }
                if (!TextUtils.isEmpty(string)) {
                    a.EnumC0270a enumC0270a = a.EnumC0270a.CLUSTER_SGP;
                    if (string.contains(enumC0270a.a())) {
                        f6875d = enumC0270a.b();
                    } else {
                        a.EnumC0270a enumC0270a2 = a.EnumC0270a.CLUSTER_HK;
                        if (string.contains(enumC0270a2.a())) {
                            f6875d = enumC0270a2.b();
                        } else {
                            Logger.w("XGApiConfigImpl", "unexpected serverSuffix from old version config: " + string);
                        }
                    }
                }
            } catch (Throwable th) {
                Logger.w("XGApiConfigImpl", "getServerSuffix from old version config error: " + th.toString());
            }
        }
        if (TextUtils.isEmpty(f6875d)) {
            f6875d = "tpns.tencent.com";
        }
        return f6875d;
    }

    public static String d(Context context) {
        String str;
        URL url;
        String guid = CloudManager.getInstance(context).getGuid();
        if (TextUtils.isEmpty(guid)) {
            str = "";
        } else {
            str = "https://guid." + guid + "/guid/v4/register_device";
        }
        if (TextUtils.isEmpty(str)) {
            str = PushPreferences.getString(context, "XG_GUID_SERVER", null);
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (!TextUtils.isEmpty(new URL(str).getHost())) {
                        str = "https://" + url.getHost() + "/guid/v4/register_device";
                    }
                } catch (Throwable unused) {
                    str = null;
                }
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = "https://guid." + c(context) + "/guid/v4/register_device";
        }
        return TextUtils.isEmpty(str) ? "https://api.tpns.tencent.com/guid/v4/register_device" : str;
    }

    public static String e(Context context) {
        if (TextUtils.isEmpty(f6876e)) {
            String stat = CloudManager.getInstance(context).getStat();
            if (!TextUtils.isEmpty(stat)) {
                f6876e = "https://mstat." + stat + "/log/v4/statistics/push";
            }
        }
        if (TextUtils.isEmpty(f6876e)) {
            f6876e = PushPreferences.getString(context, "XG_STAT_SERVER", null);
        }
        if (TextUtils.isEmpty(f6876e)) {
            String c2 = c(context);
            f6876e = "https://mstat." + c2 + "/log/v4/statistics/push";
        }
        if (TextUtils.isEmpty(f6876e)) {
            f6876e = "https://stat.api.tpns.tencent.com/log/v4/statistics/push";
        }
        return f6876e;
    }

    public static String f(Context context) {
        if (TextUtils.isEmpty(f6877f)) {
            String stat = CloudManager.getInstance(context).getStat();
            if (!TextUtils.isEmpty(stat)) {
                f6877f = "https://log." + stat + "/log/v4/statistics/push";
            }
        }
        if (TextUtils.isEmpty(f6877f)) {
            f6877f = PushPreferences.getString(context, "XG_ERRCODE_SERVER", null);
        }
        if (TextUtils.isEmpty(f6877f)) {
            String c2 = c(context);
            f6877f = "https://log." + c2 + "/log/v4/statistics/push";
        }
        if (TextUtils.isEmpty(f6877f)) {
            f6877f = "https://log.tpns.tencent.com/log/v4/statistics/push";
        }
        return f6877f;
    }

    public static String g(Context context) {
        if (TextUtils.isEmpty(f6878g)) {
            String custom = CloudManager.getInstance(context).getCustom();
            if (!TextUtils.isEmpty(custom)) {
                f6878g = "https://log." + custom + "/log/v4/statistics/push";
            }
        }
        if (TextUtils.isEmpty(f6878g)) {
            f6878g = PushPreferences.getString(context, "XG_CUSTOMEVEN_SERVER", null);
        }
        if (TextUtils.isEmpty(f6878g)) {
            String c2 = c(context);
            f6878g = "https://log." + c2 + "/log/v4/statistics/push";
        }
        if (TextUtils.isEmpty(f6878g)) {
            f6878g = "https://stat.api.tpns.tencent.com/log/v4/statistics/push";
        }
        return f6878g;
    }

    public static String h(Context context) {
        if (TextUtils.isEmpty(f6879h)) {
            String log = CloudManager.getInstance(context).getLog();
            if (!TextUtils.isEmpty(log)) {
                f6879h = "https://mstat." + log + "/v3/mobile/log/upload";
            }
        }
        if (TextUtils.isEmpty(f6879h)) {
            String c2 = c(context);
            f6879h = "https://mstat." + c2 + "/v3/mobile/log/upload";
        }
        if (TextUtils.isEmpty(f6879h)) {
            f6879h = "https://stat.api.tpns.tencent.com/v3/mobile/log/upload";
        }
        return f6879h;
    }

    public static String i(Context context) {
        if (TextUtils.isEmpty(f6880i)) {
            String c2 = c(context);
            f6880i = "https://log." + c2 + "/device/v4/get_offline_msg";
        }
        return f6880i;
    }

    public static String j(Context context) {
        String str;
        URL url;
        if (TextUtils.isEmpty(f6881j)) {
            String guid = CloudManager.getInstance(context).getGuid();
            if (TextUtils.isEmpty(guid)) {
                str = "";
            } else {
                str = "https://guid." + guid + "/device/v4/account/batch_operate";
            }
            if (TextUtils.isEmpty(str)) {
                str = PushPreferences.getString(context, "XG_GUID_SERVER", null);
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if (!TextUtils.isEmpty(new URL(str).getHost())) {
                            str = "https://" + url.getHost() + "/guid/v4/register_device";
                        }
                    } catch (Throwable unused) {
                        str = null;
                    }
                }
            }
            if (TextUtils.isEmpty(str)) {
                str = "https://guid." + c(context) + "/device/v4/account/batch_operate";
            }
            if (Util.isNullOrEmptyString(str)) {
                str = "https://api.tpns.tencent.com/device/v4/account/batch_operate";
            }
            f6881j = str;
        }
        return f6881j;
    }

    public static boolean k(Context context) {
        try {
            return PushPreferences.getBoolean(context, "IS_POWER_SAVE_MODE", false);
        } catch (Throwable th) {
            Logger.w("XGApiConfigImpl", "isPowerSaveMode Throwable: " + th);
            return false;
        }
    }

    public static synchronized long l(Context context) {
        Object metaData;
        synchronized (a.class) {
            if (context == null) {
                return f6874c;
            }
            if (f6874c != -1) {
                return f6874c;
            }
            if (f6874c == -1 && (metaData = CommonHelper.getMetaData(context, "XG_OLD_ACCESS_ID", null)) != null) {
                f6874c = Long.valueOf(metaData.toString().replace("L", "")).longValue();
            }
            if (f6874c == -1) {
                Logger.d("XGApiConfigImpl", "Not set freeVersionAccessId");
            }
            return f6874c;
        }
    }

    public static boolean m(Context context) {
        if (context == null) {
            return true;
        }
        try {
            int i2 = PushMd5Pref.getInt(context, context.getPackageName() + ".enableService", f6882k);
            f6882k = i2;
            return i2 != 0;
        } catch (Throwable unused) {
            Logger.w("XGApiConfigImpl", "unexpected for isEnableService");
            return true;
        }
    }

    public static void n(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            PushPreferences.putBoolean(context, "IS_REGISTERED", true);
            PushPreferences.putLong(context, "REGISTERED_TIME", currentTimeMillis);
        } catch (Throwable th) {
            Logger.w("XGApiConfigImpl", "unexpected for setRegisterSuccess: " + th.getMessage());
        }
    }

    public static void o(Context context) {
        try {
            PushPreferences.putBoolean(context, "IS_REGISTERED", false);
            PushPreferences.putLong(context, "REGISTERED_TIME", 0L);
        } catch (Throwable th) {
            Logger.w("XGApiConfigImpl", "unexpected for clearRegistered: " + th.getMessage());
        }
    }

    public static boolean p(Context context) {
        if (q(context)) {
            return false;
        }
        try {
            return PushPreferences.getBoolean(context, "IS_REGISTERED", false);
        } catch (Throwable th) {
            Logger.w("XGApiConfigImpl", "unexpected for isRegistered: " + th.getMessage());
            return false;
        }
    }

    private static boolean q(Context context) {
        try {
            return System.currentTimeMillis() - PushPreferences.getLong(context, "REGISTERED_TIME", 0L) > com.heytap.mcssdk.constant.a.f3315e;
        } catch (Throwable th) {
            Logger.w("XGApiConfigImpl", "unexpected for isRegisterExpire: " + th.getMessage());
            return true;
        }
    }

    public static void b(Context context, String str) {
        if (TextUtils.isEmpty(str) || str.equals(c(context))) {
            return;
        }
        PushPreferences.putLong(context, "XG_GUID_LAST_REFRESH_TIME", 0L);
        Logger.w("XGApiConfigImpl", "refresh Token");
        f6875d = str;
        f6876e = null;
        f6877f = null;
        f6879h = null;
        f6880i = null;
        PushPreferences.putString(context, "XG_SERVER_SUFFIX", str);
    }

    public static synchronized void a(final Context context, final long j2) {
        synchronized (a.class) {
            if (context == null) {
                Logger.e("XGApiConfigImpl", "null  context");
                return;
            }
            if (j2 != a(context)) {
                GuidInfoManager.clearGuidInfo(context);
            }
            a = j2;
            CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.tpns.baseapi.core.a.1
                @Override // com.tencent.tpns.baseapi.base.util.TTask
                public void TRun() {
                    PushPreferences.putLong(context, XGPushConfig.TPUSH_ACCESS_ID, j2);
                }
            });
        }
    }

    public static void e(Context context, String str) {
        if (TextUtils.isEmpty(str) || str.equals(f(context))) {
            return;
        }
        f6877f = str;
        PushPreferences.putString(context, "XG_ERRCODE_SERVER", str);
    }

    public static void f(Context context, String str) {
        if (TextUtils.isEmpty(str) || str.equals(g(context))) {
            return;
        }
        f6878g = str;
        PushPreferences.putString(context, "XG_CUSTOMEVEN_SERVER", str);
    }

    public static void g(Context context, String str) {
        PushPreferences.putString(context, "XG_GUID_SERVER", str);
    }

    public static void d(Context context, String str) {
        if (TextUtils.isEmpty(str) || str.equals(e(context))) {
            return;
        }
        f6876e = str;
        PushPreferences.putString(context, "XG_STAT_SERVER", str);
    }

    public static synchronized void a(final Context context, final String str) {
        synchronized (a.class) {
            if (context != null && str != null) {
                if (b != str) {
                    b = str;
                    CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.tpns.baseapi.core.a.2
                        @Override // com.tencent.tpns.baseapi.base.util.TTask
                        public void TRun() {
                            PushPreferences.putString(context, XGPushConfig.TPUSH_ACCESS_KEY, str);
                        }
                    });
                }
                return;
            }
            Logger.e("XGApiConfigImpl", "null context or null accessKey");
        }
    }

    public static void c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String d2 = d(context);
        if (d2 != null && !d2.equals(str)) {
            PushPreferences.putLong(context, "XG_GUID_LAST_REFRESH_TIME", 0L);
            Logger.w("XGApiConfigImpl", "refresh Token");
        }
        PushPreferences.putString(context, "XG_GUID_SERVER", str);
    }

    public static void a(Context context, boolean z) {
        try {
            PushPreferences.putBoolean(context, "IS_POWER_SAVE_MODE", z);
        } catch (Throwable th) {
            Logger.w("XGApiConfigImpl", "setPowerSaveMode Throwable: " + th);
        }
    }
}
