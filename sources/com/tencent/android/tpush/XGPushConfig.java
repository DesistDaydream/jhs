package com.tencent.android.tpush;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.jg.JgMethodChecked;
import com.tencent.android.tpush.c.d;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.c;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.android.tpush.service.util.f;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.logger.LoggerInterface;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.CacheHelper;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.MqttConfig;
import com.umeng.analytics.pro.am;
import java.util.ArrayList;
import java.util.List;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.RECEIVERCHECK, EType.INTENTCHECK})
/* loaded from: classes3.dex */
public class XGPushConfig {
    public static final String TPUSH_ACCESS_CHANNAL = "XG_V4_CHANNEL_ID";
    public static final String TPUSH_ACCESS_ID = "XG_V2_ACCESS_ID";
    public static final String TPUSH_ACCESS_KEY = "XG_V2_ACCESS_KEY";
    public static final String TPUSH_IS_FOREIGINPUSH = "TPUSH_IS_FOREIGINPUSH";
    public static boolean _isHuaweiDebug = false;
    private static String a = "";
    public static boolean autoInit = true;
    private static String b = "";

    /* renamed from: c */
    private static boolean f5941c = true;

    /* renamed from: d */
    private static String f5942d = "";

    /* renamed from: e */
    private static long f5943e = -1;
    public static Boolean enableApplist = null;
    public static boolean enableDebug = false;
    public static Boolean enableLocation;
    public static Boolean enableNotification;

    /* renamed from: f */
    private static Boolean f5944f;
    public static Boolean fcmIsSuccess;

    /* renamed from: g */
    private static Boolean f5945g;

    /* renamed from: h */
    private static Boolean f5946h;

    /* renamed from: i */
    private static Boolean f5947i;
    public static Boolean isUsedFcmPush;
    public static Boolean isUsedOtherPush;

    /* renamed from: j */
    private static Boolean f5948j;

    /* renamed from: k */
    private static Boolean f5949k;

    /* renamed from: l */
    private static SharedPreferences f5950l;
    public static String notificationChannelID;
    public static String notificationChannelName;
    public static Boolean useFcmFirst;

    /* loaded from: classes3.dex */
    public static class Build {
        private Context context;

        public Build(Context context) {
            this.context = context.getApplicationContext();
        }

        public Build enableDebug(boolean z) {
            XGPushConfig.enableDebug(this.context, z);
            return this;
        }

        public Build enableFcmPush(boolean z) {
            XGPushConfig.enableOtherPush(this.context, z);
            return this;
        }

        public Build enableOtherPush(boolean z) {
            XGPushConfig.enableOtherPush(this.context, z);
            return this;
        }

        public Build setHuaweiDebug(boolean z) {
            XGPushConfig.setHuaweiDebug(z);
            return this;
        }

        public Build setLogLevel(final int i2) {
            TBaseLogger.setDebugLevel(i2);
            CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.XGPushConfig.Build.1
                {
                    Build.this = this;
                }

                @Override // com.tencent.tpns.baseapi.base.util.TTask
                public void TRun() {
                    try {
                        Context context = Build.this.context;
                        PushPreferences.putInt(context, "com.tencent.android.tpush.log_level," + Build.this.context.getPackageName(), i2);
                    } catch (Throwable th) {
                        TLogger.w("XGPushConfig", "XGPushConfig.Build.setLogLevel sharedPf put error " + th.toString());
                    }
                }
            });
            return this;
        }

        public Build setMiPushAppId(String str) {
            XGPushConfig.setMiPushAppId(this.context, str);
            return this;
        }

        public Build setMiPushAppKey(String str) {
            XGPushConfig.setMiPushAppKey(this.context, str);
            return this;
        }

        public Build setMzPushAppId(String str) {
            XGPushConfig.setMzPushAppId(this.context, str);
            return this;
        }

        public Build setMzPushAppKey(String str) {
            XGPushConfig.setMzPushAppKey(this.context, str);
            return this;
        }

        public Build setOppoPushAppId(String str) {
            XGPushConfig.setOppoPushAppId(this.context, str);
            return this;
        }

        public Build setOppoPushAppKey(String str) {
            XGPushConfig.setOppoPushAppKey(this.context, str);
            return this;
        }
    }

    private static void a(Context context, boolean z) {
        if (context == null) {
            return;
        }
        MqttConfig.enableAlarmManager(context, z);
        if (z) {
            return;
        }
        f.f(context);
    }

    public static void changeHuaweiBadgeNum(Context context, int i2) {
        c.a(context, i2);
    }

    public static void enableAutoStart(Context context, boolean z) {
        if (context == null) {
            return;
        }
        TLogger.i("XGPushConfig", "enableAutoStart: " + z);
        a(context, z);
    }

    public static void enableDebug(final Context context, final boolean z) {
        if (context != null) {
            enableDebug = z;
            CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.XGPushConfig.1
                @Override // com.tencent.tpns.baseapi.base.util.TTask
                @JgMethodChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.RECEIVERCHECK, EType.INTENTCHECK})
                public void TRun() {
                    try {
                        TLogger.enableDebug(context, z);
                        Context context2 = context;
                        PushPreferences.putInt(context2, "com.tencent.android.tpush.debug," + context.getPackageName(), z ? 1 : 0);
                        Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.ENABLE_DEBUG.V4");
                        intent.putExtra("debugMode", z);
                        BroadcastAgent.sendBroadcast(context, intent);
                    } catch (Throwable th) {
                        TLogger.e("XGPushConfig", "enableDebug ", th);
                    }
                }
            });
        }
    }

    public static void enableFcmPush(Context context, boolean z) {
        if (context == null) {
            return;
        }
        Boolean bool = isUsedFcmPush;
        if (bool == null || bool.booleanValue() != z) {
            isUsedFcmPush = Boolean.valueOf(z);
            CacheHelper.set(context, com.tencent.android.tpush.d.b.a.d().set(Integer.valueOf(z ? 1 : 0)));
            setNotTryFcm(context, z);
        }
    }

    public static void enableHttpAccountOperate(Context context, boolean z) {
        if (context == null) {
            return;
        }
        Boolean bool = f5945g;
        if (bool == null || bool.booleanValue() != z) {
            f5945g = Boolean.valueOf(z);
            CacheHelper.set(context, com.tencent.android.tpush.d.b.a.c(getAccessId(context) + "").set(Boolean.valueOf(z)));
        }
    }

    public static void enableHuaweiV3Update(Context context, boolean z) {
        if (z && context != null) {
            if (!(context instanceof Activity)) {
                TLogger.i("XGPushConfig", "enableHuaweiV3Update context not instanceof Activity, would not update");
            } else if (!ChannelUtils.isBrandHuaWei() && !ChannelUtils.isBrandHonor()) {
                TLogger.i("XGPushConfig", "enableHuaweiV3Update not Huawei device");
            } else {
                try {
                    Class<?> cls = Class.forName("com.huawei.hms.aaid.HmsInstanceId");
                    cls.getDeclaredMethod("getInstance", Context.class).invoke(cls, context);
                } catch (Throwable th) {
                    TLogger.e("XGPushConfig", "enableHuaweiV3Update error, not find Hms V3 Sdk", th);
                }
            }
        }
    }

    public static void enableNotificationSound(Context context, boolean z, String str, String str2) {
        if (context == null) {
            return;
        }
        Boolean bool = f5947i;
        if (bool == null || bool.booleanValue() != z) {
            f5947i = Boolean.valueOf(z);
            CacheHelper.set(context, com.tencent.android.tpush.d.b.a.i().set(Boolean.valueOf(z)));
            if (!z) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    TLogger.i("XGPushConfig", "enableNotificationSound false with channelId: " + str + " and channelName: " + str2);
                    XGPushManager.createNotificationChannel(context, str, str2, true, true, false, null);
                    setNotificationChannelID(context, str);
                    setNotificationChannelName(context, str2);
                    return;
                }
                TLogger.i("XGPushConfig", "enableNotificationSound false should assign a pair of notification channelId and channelName.");
                return;
            }
            TLogger.i("XGPushConfig", "enableNotificationSound true");
            setNotificationChannelID(context, null);
            setNotificationChannelName(context, null);
        }
    }

    public static void enableOppoNotification(Context context, boolean z) {
        d.a(context, z);
    }

    public static void enableOtherPush(Context context, boolean z) {
        if (context == null) {
            return;
        }
        Boolean bool = isUsedOtherPush;
        if (bool == null || bool.booleanValue() != z) {
            isUsedOtherPush = Boolean.valueOf(z);
            CacheHelper.set(context, com.tencent.android.tpush.d.b.a.c().set(Integer.valueOf(z ? 1 : 0)));
            enableFcmPush(context, z);
        }
    }

    public static void enablePullUpOtherApp(Context context, boolean z) {
        if (context == null) {
            TLogger.ww("XGPushConfig", "context is null");
            return;
        }
        Boolean bool = f5944f;
        if (bool == null || z != bool.booleanValue()) {
            f5944f = Boolean.valueOf(z);
            TLogger.d("XGPushConfig", "action - enablePullUpOtherApp:" + z);
            PushPreferences.putBoolean(context, Constants.ENABLE_PULL_UP_OTHER_APP, z);
        }
    }

    public static void enableShowInMsg(Context context, boolean z) {
        if (context == null) {
            return;
        }
        Boolean bool = f5948j;
        if (bool == null || bool.booleanValue() != z) {
            f5948j = Boolean.valueOf(z);
            CacheHelper.set(context, com.tencent.android.tpush.d.b.a.g().set(Boolean.valueOf(z)));
        }
    }

    public static void enableTpnsChannel(Context context, boolean z) {
        if (context == null) {
            return;
        }
        Boolean bool = f5946h;
        if (bool == null || bool.booleanValue() != z) {
            f5946h = Boolean.valueOf(z);
            CacheHelper.set(context, com.tencent.android.tpush.d.b.a.h().set(Boolean.valueOf(z)));
        }
    }

    public static synchronized long getAccessId(Context context) {
        long accessId;
        synchronized (XGPushConfig.class) {
            accessId = XGApiConfig.getAccessId(context);
        }
        return accessId;
    }

    public static synchronized String getAccessKey(Context context) {
        String accessKey;
        synchronized (XGPushConfig.class) {
            accessKey = XGApiConfig.getAccessKey(context);
        }
        return accessKey;
    }

    public static List<Long> getAccessidList(Context context) {
        ArrayList arrayList = new ArrayList(2);
        if (context == null) {
            return arrayList;
        }
        long accessId = getAccessId(context);
        if (accessId > 0) {
            arrayList.add(Long.valueOf(accessId));
        }
        long qQAccessId = XGPush4Msdk.getQQAccessId(context);
        if (qQAccessId > 0) {
            arrayList.add(Long.valueOf(qQAccessId));
        }
        Object metaData = CommonHelper.getMetaData(context, TPUSH_ACCESS_ID, null);
        if (metaData != null) {
            try {
                long longValue = Long.valueOf(metaData.toString()).longValue();
                if (!arrayList.contains(Long.valueOf(longValue))) {
                    arrayList.add(Long.valueOf(longValue));
                }
            } catch (Throwable th) {
                TLogger.w("XGPushConfig", "get accessId from getMetaData failed: ", th);
            }
        }
        return arrayList;
    }

    public static synchronized long getChannelId(Context context) {
        Object metaData;
        synchronized (XGPushConfig.class) {
            if (context == null) {
                return f5943e;
            }
            long j2 = f5943e;
            if (j2 != -1) {
                return j2;
            }
            if (!Security.checkTpnsSecurityLibSo(context)) {
                return f5943e;
            }
            if (f5943e == -1 && (metaData = CommonHelper.getMetaData(context, TPUSH_ACCESS_CHANNAL, null)) != null) {
                f5943e = Long.valueOf(metaData.toString()).longValue();
            }
            if (f5943e == -1) {
                TLogger.d("XGPushConfig", "channelId is not empty");
            }
            return f5943e;
        }
    }

    public static String getFacilityImei(Context context) {
        return f5942d;
    }

    public static String getGameServer(Context context) {
        return b;
    }

    public static String getInstallChannel(Context context) {
        return a;
    }

    public static String getNotificationChannelID(Context context) {
        if (context != null) {
            String str = notificationChannelID;
            if (str != null && !TextUtils.isEmpty(str)) {
                return notificationChannelID;
            }
            String string = PushPreferences.getString(context, context.getPackageName() + ".notification.channelID", "");
            notificationChannelID = string;
            return string;
        }
        return null;
    }

    public static String getNotificationChannelName(Context context) {
        if (context != null) {
            String str = notificationChannelName;
            if (str != null && !TextUtils.isEmpty(str)) {
                return notificationChannelName;
            }
            String string = PushPreferences.getString(context, context.getPackageName() + ".notification.channelName", "");
            notificationChannelName = string;
            return string;
        }
        return null;
    }

    public static String getOtherPushErrCode(Context context) {
        if (context == null) {
            return "errCode : -102 , errMsg : context == null";
        }
        try {
            Boolean valueOf = Boolean.valueOf(isUsedOtherPush(context));
            isUsedOtherPush = valueOf;
            return !valueOf.booleanValue() ? "errCode : -101 , errMsg : Manufacturer channel is not opened" : SharePrefsUtil.getString(context, Constants.OTHER_PUSH_ERROR_CODE, "errCode : -100 , errMsg : unknown");
        } catch (Throwable th) {
            TLogger.dd("XGPushConfig", "getOtherPushErrCode error: " + th.getMessage());
            return "";
        }
    }

    public static String getOtherPushToken(Context context) {
        try {
            return d.a(context).e();
        } catch (Throwable th) {
            TLogger.e("XGPushConfig", "getOtherPushToken", th);
            return null;
        }
    }

    public static String getOtherPushType(Context context) {
        try {
            return d.a(context).i();
        } catch (Throwable th) {
            TLogger.e("XGPushConfig", "getOtherPushToken", th);
            return null;
        }
    }

    public static boolean getReportDebugMode(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getPackageName());
        sb.append(".report.mode");
        return PushPreferences.getInt(context, sb.toString(), 0) != 0;
    }

    public static XGServerInfo getServerIpList(Context context) {
        if (context != null) {
            return new XGServerInfo(PushPreferences.getString(context, "com.tencent.android.xg.vip.action.custom.iplist.local", null));
        }
        return null;
    }

    public static boolean getStatAutoPage(Context context) {
        return f5941c;
    }

    public static String getToken(Context context) {
        if (context == null) {
            TLogger.e("XGPushConfig", "null context");
            return null;
        }
        return CacheManager.getToken(context);
    }

    public static Build init(Context context) {
        if (context == null) {
            TLogger.ee("XGPushConfig", "context is null");
            return null;
        }
        return new Build(context);
    }

    public static boolean isEnableDebug(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("com.tencent.android.tpush.debug,");
        sb.append(context.getPackageName());
        return PushPreferences.getInt(context, sb.toString(), 0) != 0;
    }

    public static boolean isEnableNotificationSound(Context context) {
        if (context == null) {
            return true;
        }
        if (f5947i == null) {
            f5947i = (Boolean) CacheHelper.get(context, com.tencent.android.tpush.d.b.a.i());
        }
        if (!f5947i.booleanValue()) {
            TLogger.i("XGPushConfig", "isEnableNotificationSound false, ignore channelId or ring config from backend");
        }
        return f5947i.booleanValue();
    }

    public static boolean isEnableShowInMsg(Context context) {
        if (context == null) {
            return false;
        }
        if (f5948j == null) {
            f5948j = (Boolean) CacheHelper.get(context, com.tencent.android.tpush.d.b.a.g());
        }
        return f5948j.booleanValue();
    }

    public static boolean isForeiginPush(Context context) {
        Boolean bool = Boolean.FALSE;
        if (f5949k == null) {
            try {
                Object metaData = CommonHelper.getMetaData(context, TPUSH_IS_FOREIGINPUSH, null);
                if (metaData == null) {
                    f5949k = bool;
                    return bool.booleanValue();
                } else if ("true".equals(metaData.toString())) {
                    f5949k = Boolean.TRUE;
                } else {
                    f5949k = bool;
                }
            } catch (Throwable unused) {
                f5949k = bool;
            }
        }
        return f5949k.booleanValue();
    }

    public static boolean isHuaweiDebug() {
        return _isHuaweiDebug;
    }

    public static boolean isLocationEnable(Context context) {
        if (enableLocation == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("com.tencent.android.tpush.enable_location,");
            sb.append(context.getPackageName());
            enableLocation = Boolean.valueOf(PushPreferences.getInt(context, sb.toString(), 1) != 0);
        }
        return enableLocation.booleanValue();
    }

    public static boolean isNotTryFcm(Context context) {
        if (context == null) {
            return false;
        }
        if (fcmIsSuccess == null) {
            fcmIsSuccess = Boolean.valueOf(((Integer) CacheHelper.get(context, com.tencent.android.tpush.d.b.a.e())).intValue() != 0);
        }
        return fcmIsSuccess.booleanValue();
    }

    public static boolean isNotificationShowEnable(Context context) {
        if (context != null) {
            try {
                if (f5950l == null) {
                    f5950l = context.getSharedPreferences(Constants.APP_PREF_NAME, 0);
                }
                return f5950l.getBoolean(Util.getKey(Constants.SETTINGS_ENABLE_SHOW_NOTIFICATION), true);
            } catch (Throwable th) {
                TLogger.e("XGPushConfig", "isNotificationShowEnable", th);
            }
        }
        return true;
    }

    public static boolean isReportApplistEnable(Context context) {
        if (enableApplist == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("com.tencent.android.tpush.enable_applist,");
            sb.append(context.getPackageName());
            enableApplist = Boolean.valueOf(PushPreferences.getInt(context, sb.toString(), 1) != 0);
        }
        if (com.tencent.android.tpush.service.a.a.a(context).F == -1) {
            return enableApplist.booleanValue();
        }
        return com.tencent.android.tpush.service.a.a.a(context).F == 1;
    }

    public static boolean isReportNotificationStatusEnable(Context context) {
        if (enableNotification == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("com.tencent.android.tpush.enable_NOTIICATION,");
            sb.append(context.getPackageName());
            enableNotification = Boolean.valueOf(PushPreferences.getInt(context, sb.toString(), 1) != 0);
        }
        if (com.tencent.android.tpush.service.a.a.a(context).G == -1) {
            return enableNotification.booleanValue();
        }
        return com.tencent.android.tpush.service.a.a.a(context).G == 1;
    }

    public static boolean isUseFcmFirst(Context context) {
        if (context == null) {
            return false;
        }
        if (useFcmFirst == null) {
            useFcmFirst = Boolean.valueOf(((Integer) CacheHelper.get(context, com.tencent.android.tpush.d.b.a.f())).intValue() != 0);
        }
        return useFcmFirst.booleanValue();
    }

    public static boolean isUsedFcmPush(Context context) {
        if (context == null) {
            return false;
        }
        if (isUsedFcmPush == null) {
            isUsedFcmPush = Boolean.valueOf(((Integer) CacheHelper.get(context, com.tencent.android.tpush.d.b.a.d())).intValue() != 0);
        }
        return isUsedFcmPush.booleanValue();
    }

    public static boolean isUsedHttpAccountOperate(Context context) {
        if (context == null) {
            return false;
        }
        if (!isUsedTpnsChannel(context)) {
            f5945g = Boolean.TRUE;
        }
        if (f5945g == null) {
            int useHttp = CloudManager.getInstance(context).useHttp();
            TLogger.d("XGPushConfig", "accountManagerByHttp from cloud: " + useHttp);
            if (useHttp == 0) {
                f5945g = (Boolean) CacheHelper.get(context, com.tencent.android.tpush.d.b.a.c(getAccessId(context) + ""));
            } else {
                f5945g = Boolean.valueOf(useHttp == 1);
            }
        }
        TLogger.d("XGPushConfig", "isUsedHttpAccountOperate: " + f5945g);
        return f5945g.booleanValue();
    }

    public static boolean isUsedOtherPush(Context context) {
        if (context == null) {
            return false;
        }
        if (isUsedOtherPush == null) {
            Boolean valueOf = Boolean.valueOf(((Integer) CacheHelper.get(context, com.tencent.android.tpush.d.b.a.c())).intValue() != 0);
            isUsedOtherPush = valueOf;
            if (!valueOf.booleanValue()) {
                isUsedOtherPush = Boolean.valueOf(d.a(context).b());
            }
            if (!isUsedOtherPush.booleanValue()) {
                isUsedOtherPush = Boolean.valueOf(i.n(context));
            }
        }
        TLogger.v("XGPushConfig", "isUsedOtherPush:" + isUsedOtherPush);
        return isUsedOtherPush.booleanValue();
    }

    public static boolean isUsedTpnsChannel(Context context) {
        if (context == null) {
            return false;
        }
        if (f5946h == null) {
            int useTpnsChannel = CloudManager.getInstance(context).useTpnsChannel();
            TLogger.d("XGPushConfig", "useTpnsChannel from cloud: " + useTpnsChannel);
            if (useTpnsChannel == 0) {
                f5946h = (Boolean) CacheHelper.get(context, com.tencent.android.tpush.d.b.a.h());
            } else {
                f5946h = Boolean.valueOf(useTpnsChannel == 1);
            }
        }
        TLogger.d("XGPushConfig", "isUsedTpnsChannel: " + f5946h);
        return f5946h.booleanValue();
    }

    public static void resetBadgeNum(Context context) {
        c.b(context);
    }

    public static void resetHuaweiBadgeNum(Context context) {
        c.a(context);
    }

    public static void setAccessId(Context context, long j2) {
        if (j2 != getAccessId(context)) {
            CacheHelper.set(context, com.tencent.android.tpush.d.b.a.b().set(""));
        }
        XGApiConfig.setAccessId(context, j2);
    }

    public static void setAccessKey(Context context, String str) {
        XGApiConfig.setAccessKey(context, str);
    }

    public static void setAutoInit(boolean z) {
        autoInit = z;
    }

    public static void setBadgeNum(Context context, int i2) {
        c.c(context, i2);
    }

    public static void setForeiginPushEnable(Context context, boolean z) {
    }

    public static void setForeignWeakAlarmMode(Context context, boolean z) {
        MqttConfig.setForeignWeakAlarmMode(context, z);
    }

    public static void setGameServer(Context context, String str) {
        if (context == null || str == null || str.trim().length() == 0) {
            return;
        }
        b = str;
    }

    public static void setHeartbeatInterval(final Context context, final int i2) {
        if (context == null || i2 < 10 || i2 >= 36000) {
            return;
        }
        try {
            MqttConfig.setKeepAliveInterval(context, i2);
            CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.XGPushConfig.2
                @Override // com.tencent.tpns.baseapi.base.util.TTask
                @JgMethodChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.RECEIVERCHECK, EType.INTENTCHECK})
                public void TRun() {
                    try {
                        Intent intent = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.SET_HTINTERVALMS.V4");
                        intent.putExtra(am.aU, i2);
                        BroadcastAgent.sendBroadcast(context, intent);
                    } catch (Throwable th) {
                        TLogger.e("XGPushConfig", "setHeartbeatInterval ", th);
                    }
                }
            });
        } catch (Throwable th) {
            TLogger.e("XGPushConfig", "setHeartbeatInterval", th);
        }
    }

    public static void setHeartbeatIntervalMs(Context context, int i2) {
        setHeartbeatInterval(context, i2 / 1000);
    }

    public static void setHuaweiBadgeNum(Context context, int i2) {
        c.b(context, i2);
    }

    public static void setHuaweiDebug(boolean z) {
        _isHuaweiDebug = z;
    }

    public static void setImei(Context context, String str) {
        f5942d = str;
    }

    public static void setInstallChannel(Context context, String str) {
        if (context == null || str == null || str.trim().length() == 0) {
            return;
        }
        a = str;
    }

    public static void setLocationEnable(Context context, boolean z) {
        Boolean bool = enableLocation;
        if (bool == null || bool.booleanValue() != z) {
            enableLocation = Boolean.valueOf(z);
            PushPreferences.putInt(context, "com.tencent.android.tpush.enable_location," + context.getPackageName(), z ? 1 : 0);
        }
    }

    public static void setMiPushAppId(Context context, String str) {
        d.a(context, str);
    }

    public static void setMiPushAppKey(Context context, String str) {
        d.b(context, str);
    }

    public static void setMzPushAppId(Context context, String str) {
        d.c(context, str);
    }

    public static void setMzPushAppKey(Context context, String str) {
        d.d(context, str);
    }

    public static void setNotTryFcm(Context context, boolean z) {
        if (context == null) {
            return;
        }
        Boolean bool = fcmIsSuccess;
        if (bool == null || bool.booleanValue() != z) {
            fcmIsSuccess = Boolean.valueOf(z);
            CacheHelper.set(context, com.tencent.android.tpush.d.b.a.e().set(Integer.valueOf(z ? 1 : 0)));
        }
    }

    public static void setNotificationChannelID(Context context, String str) {
        if (context != null) {
            notificationChannelID = str;
            PushPreferences.putString(context, context.getPackageName() + ".notification.channelID", str);
        }
    }

    public static void setNotificationChannelName(Context context, String str) {
        if (context != null) {
            notificationChannelName = str;
            PushPreferences.putString(context, context.getPackageName() + ".notification.channelName", str);
        }
    }

    public static void setNotificationShowEnable(Context context, boolean z) {
        if (context != null) {
            try {
                if (f5950l == null) {
                    f5950l = context.getSharedPreferences(Constants.APP_PREF_NAME, 0);
                }
                SharedPreferences.Editor edit = f5950l.edit();
                edit.putBoolean(Util.getKey(Constants.SETTINGS_ENABLE_SHOW_NOTIFICATION), z);
                edit.commit();
            } catch (Throwable th) {
                TLogger.e("XGPushConfig", "setNotificationShowEnable", th);
            }
        }
    }

    public static void setOPPOBadgeNum(Context context, int i2) {
        c.d(context, i2);
    }

    public static void setOppoPushAppId(Context context, String str) {
        d.e(context, str);
    }

    public static void setOppoPushAppKey(Context context, String str) {
        d.f(context, str);
    }

    public static void setPowerSaveMode(Context context, boolean z) {
        XGApiConfig.setPowerSaveMode(context, z);
    }

    public static void setReportApplistEnable(Context context, boolean z) {
        Boolean bool = enableApplist;
        if (bool == null || bool.booleanValue() != z) {
            enableApplist = Boolean.valueOf(z);
            PushPreferences.putInt(context, "com.tencent.android.tpush.enable_applist," + context.getPackageName(), z ? 1 : 0);
        }
    }

    public static void setReportDebugMode(Context context, boolean z) {
        if (context != null) {
            PushPreferences.putInt(context, context.getPackageName() + ".report.mode", z ? 1 : 0);
        }
    }

    public static void setReportNotificationStatusEnable(Context context, boolean z) {
        Boolean bool = enableNotification;
        if (bool == null || bool.booleanValue() != z) {
            enableNotification = Boolean.valueOf(z);
            PushPreferences.putInt(context, "com.tencent.android.tpush.enable_NOTIICATION," + context.getPackageName(), z ? 1 : 0);
        }
    }

    public static void setServerIpList(Context context, XGServerInfo xGServerInfo) {
        if (context == null || xGServerInfo == null) {
            return;
        }
        PushPreferences.putString(context, "com.tencent.android.xg.vip.action.custom.iplist.local", xGServerInfo.getIpArray().toString());
    }

    public static void setStatAutoPage(Context context, boolean z) {
        f5941c = z;
    }

    public static void setTPushLogger(LoggerInterface loggerInterface) {
        TBaseLogger.setLogger(loggerInterface);
    }

    public static void setUseFcmFirst(final Context context, boolean z) {
        if (context == null) {
            return;
        }
        Boolean bool = useFcmFirst;
        if (bool == null || bool.booleanValue() != z) {
            useFcmFirst = Boolean.valueOf(z);
            CacheHelper.set(context, com.tencent.android.tpush.d.b.a.f().set(Integer.valueOf(useFcmFirst.booleanValue() ? 1 : 0)));
            CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.XGPushConfig.3
                @Override // com.tencent.tpns.baseapi.base.util.TTask
                public void TRun() {
                    XGPushManager.loadOtherPushToken(context, false, -1L);
                    com.tencent.android.tpush.c.b.a(context);
                }
            });
        }
    }

    public static void setVivoBadgeNum(Context context, int i2) {
        c.e(context, i2);
    }

    public static void setfcmSenderId(Context context, String str) {
        com.tencent.android.tpush.c.a.b(context, str);
    }
}
