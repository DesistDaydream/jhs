package com.tencent.android.tpush.common;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import com.tencent.android.tpush.SettingsContentProvider;
import com.tencent.android.tpush.TpnsActivity;
import com.tencent.android.tpush.XGPushBaseReceiver;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.XGPushProvider;
import com.tencent.android.tpush.XGPushReceiver;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.android.tpush.stat.StatServiceImpl;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.RC4;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import com.tencent.tpns.mqttchannel.api.MqttTools;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.security.auth.x500.X500Principal;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class i {
    private static AtomicBoolean b = new AtomicBoolean(false);

    /* renamed from: c */
    private static boolean f6096c = false;

    /* renamed from: d */
    private static final X500Principal f6097d = new X500Principal("CN=Android Debug,O=Android,C=US");

    /* renamed from: e */
    private static String f6098e = "";

    /* renamed from: f */
    private static String f6099f = "";
    public static String a = null;

    public static boolean b(String str, String str2) {
        try {
            return Float.valueOf(str2.replace(".", "")).floatValue() > Float.valueOf(str.replace(".", "")).floatValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int c(Context context) {
        TLogger.d("Util", "action getServiceStatus");
        if (context != null) {
            try {
                List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
                if (runningServices == null || runningServices.size() <= 0) {
                    return 0;
                }
                String name = XGVipPushService.class.getName();
                for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                    String className = runningServiceInfo.service.getClassName();
                    String packageName = runningServiceInfo.service.getPackageName();
                    if (name.equals(className) && packageName.equals(context.getPackageName())) {
                        return runningServiceInfo.pid != 0 ? 1 : 2;
                    }
                }
                return 0;
            } catch (Throwable th) {
                TLogger.e("Util", "getServiceStatus", th);
                return 0;
            }
        }
        return 0;
    }

    public static void d(Context context) {
        TLogger.d("Util", "startCurrentAppService " + context.getPackageName());
        context.startService(new Intent(context, XGVipPushService.class));
    }

    public static void e(final Context context) {
        if (context != null) {
            if (!XGPushConfig.isUsedTpnsChannel(context)) {
                TLogger.ii("Util", "startService abolish, not use Tpns channel service");
                return;
            }
            try {
            } catch (Throwable th) {
                TLogger.e("Util", "StartService", th);
            }
            if (com.tencent.android.tpush.service.util.f.a(context.getPackageName())) {
                d(context);
                return;
            }
            com.tencent.android.tpush.service.b.b(context.getApplicationContext());
            com.tencent.android.tpush.service.b.a(context);
            TLogger.v("Util", "Action -> start Local Service()");
            CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.common.i.3
                @Override // com.tencent.tpns.baseapi.base.util.TTask
                public void TRun() {
                    if (i.c(context) != 1) {
                        try {
                            TLogger.v("Util", "Action2 -> start Local Service()");
                            com.tencent.android.tpush.service.b.a(context);
                        } catch (Throwable th2) {
                            TLogger.e("Util", "CommonWorkingThread StartService", th2);
                        }
                    }
                }
            }, 1500L);
        }
    }

    private static void f(Context context, String str) {
        PackageManager packageManager;
        if (context == null || str == null) {
            return;
        }
        try {
            if (str.trim().length() == 0 || (packageManager = context.getPackageManager()) == null) {
                return;
            }
            ComponentName componentName = new ComponentName(context.getPackageName(), str);
            if (packageManager.getComponentEnabledSetting(componentName) != 1) {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            }
        } catch (Throwable unused) {
        }
    }

    public static void g(final Context context) {
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.common.i.4
            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                Boolean bool = Boolean.TRUE;
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager == null) {
                        return;
                    }
                    String b2 = i.b();
                    TLogger.i("filter components", "deviceType: " + b2);
                    if (!ChannelUtils.isBrandXiaoMi() && !ChannelUtils.isBrandBlackShark() && ((Boolean) CommonHelper.getMetaData(context, "tpns-disable-component-xiaomi", bool)).booleanValue()) {
                        i.b(packageManager, context, "com.xiaomi.push.service.XMPushService");
                        i.b(packageManager, context, "com.xiaomi.push.service.XMJobService");
                        i.b(packageManager, context, "com.xiaomi.mipush.sdk.PushMessageHandler");
                        i.b(packageManager, context, "com.xiaomi.mipush.sdk.MessageHandleService");
                        i.b(packageManager, context, "com.xiaomi.push.service.receivers.NetworkStatusReceiver");
                        i.b(packageManager, context, "com.xiaomi.push.service.receivers.PingReceiver");
                        i.b(packageManager, context, "com.tencent.android.mipush.XMPushMessageReceiver");
                    }
                    if (!ChannelUtils.isBrandHuaWei() && !ChannelUtils.isBrandHonor() && !ChannelUtils.isEmuiOrOhosVersion()) {
                        TLogger.i("filter components", "disable device huawei");
                        if (((Boolean) CommonHelper.getMetaData(context, "tpns-disable-component-huawei-v4", bool)).booleanValue()) {
                            i.b(packageManager, context, "com.huawei.agconnect.core.provider.AGConnectInitializeProvider");
                            i.b(packageManager, context, "com.huawei.agconnect.core.ServiceDiscovery");
                            i.b(packageManager, context, "com.tencent.android.hwpushv3.HWHmsMessageService");
                            i.b(packageManager, context, "com.huawei.hms.support.api.push.PushMsgReceiver");
                            i.b(packageManager, context, "com.huawei.hms.support.api.push.PushReceiver");
                            i.b(packageManager, context, "com.huawei.hms.support.api.push.PushProvider");
                        }
                    }
                    if (!ChannelUtils.isBrandMeiZu() && ((Boolean) CommonHelper.getMetaData(context, "tpns-disable-component-meizu", bool)).booleanValue()) {
                        i.b(packageManager, context, "com.tencent.android.mzpush.MZPushMessageReceiver");
                        i.b(packageManager, context, "com.meizu.cloud.pushsdk.SystemReceiver");
                        i.b(packageManager, context, "com.meizu.cloud.pushsdk.NotificationService");
                    }
                    if (!"oppo".equals(b2) && !"oneplus".equals(b2) && !"realme".equals(b2) && ((Boolean) CommonHelper.getMetaData(context, "tpns-disable-component-oppo", bool)).booleanValue()) {
                        i.b(packageManager, context, "com.heytap.msp.push.service.CompatibleDataMessageCallbackService");
                        i.b(packageManager, context, "com.heytap.msp.push.service.DataMessageCallbackService");
                    }
                    if ("vivo".equals(b2) || !((Boolean) CommonHelper.getMetaData(context, "tpns-disable-component-vivo", bool)).booleanValue()) {
                        return;
                    }
                    i.b(packageManager, context, "com.vivo.push.sdk.service.CommandClientService");
                    i.b(packageManager, context, "com.vivo.push.sdk.LinkProxyClientActivity");
                    i.b(packageManager, context, "com.tencent.android.vivopush.VivoPushMessageReceiver");
                } catch (Throwable th) {
                    TLogger.w("Util", "unexpected for disableComponents", th);
                }
            }
        });
    }

    public static boolean h(Context context) {
        return XGApiConfig.isEnableService(context);
    }

    public static void i(Context context) {
        try {
            if ("oppo".equals(b())) {
                Intent intent = new Intent("oppo.safecenter.intent.action.CHANGE_NOTIFICATION_STATE");
                intent.putExtra("package_name", context.getPackageName());
                intent.putExtra("allow_notify", true);
                BroadcastAgent.sendBroadcast(context, intent);
            }
        } catch (Throwable th) {
            TLogger.d("openNotification", "openNotification", th);
        }
    }

    public static void j(Context context) {
        String b2 = b();
        if (!"meizu".equals(b2) && "oppo".equals(b2)) {
            try {
                Intent intent = new Intent();
                intent.setClassName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity");
                intent.setAction("com.coloros.notificationmanager.app.detail");
                intent.setData(Uri.parse("package:" + context.getPackageName()));
                intent.putExtra("pkg_name", context.getPackageName());
                intent.putExtra("app_name", AppInfos.getApplicationName(context));
                intent.putExtra("class_name", context.getPackageName());
                context.startActivity(intent);
            } catch (Throwable th) {
                TLogger.d("Util", "openNotificationSettings", th);
            }
        }
    }

    public static void k(Context context) {
        String a2 = a(context, "otherpush_config.json");
        if (b(a2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(a2);
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject("xiaomi");
                if (optJSONObject != null) {
                    com.tencent.android.tpush.c.d.a = optJSONObject.optString("appid", null);
                    com.tencent.android.tpush.c.d.b = optJSONObject.optString("appkey", null);
                }
            } catch (Throwable unused) {
            }
            try {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("meizu");
                if (optJSONObject2 != null) {
                    com.tencent.android.tpush.c.d.f6077c = optJSONObject2.optString("appid", null);
                    com.tencent.android.tpush.c.d.f6078d = optJSONObject2.optString("appkey", null);
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable th) {
            TLogger.e("Util", "", th);
        }
    }

    public static String l(Context context) {
        try {
            if (b(f6098e)) {
                f6098e = String.valueOf(CommonHelper.getMetaData(context, com.xiaomi.mipush.sdk.Constants.HUAWEI_HMS_CLIENT_APPID, ""));
            }
            if (TextUtils.isEmpty(f6098e)) {
                f6098e = com.tencent.android.tpush.c.d.f6082h;
            }
        } catch (Throwable unused) {
            TLogger.w("Util", "unexpected for getHwConfig");
        }
        return f6098e;
    }

    public static String m(Context context) {
        try {
            if (b(f6099f)) {
                f6099f = String.valueOf(CommonHelper.getMetaData(context, "com.vivo.push.app_id", ""));
            }
        } catch (Throwable unused) {
            TLogger.w("Util", "unexpected for getVivoConfig");
        }
        return f6099f;
    }

    public static boolean n(Context context) {
        try {
            return ((Boolean) CommonHelper.getMetaData(context, "ENABLE_OTHER_PUSH", Boolean.FALSE)).booleanValue();
        } catch (Throwable unused) {
            TLogger.w("Util", "unexpected for init isUsedOtherPush4Plugin");
            return false;
        }
    }

    public static byte o(Context context) {
        byte type = MobileType.UNKNOWN.getType();
        if (context != null) {
            try {
                String simOperator = CustomDeviceInfos.getSimOperator(context);
                if (simOperator != null) {
                    if (!simOperator.equals("46000") && !simOperator.equals("46002") && !simOperator.equals("46007") && !simOperator.equals("46020")) {
                        if (!simOperator.equals("46001") && !simOperator.equals("46006")) {
                            if (simOperator.equals("46003") || simOperator.equals("46005")) {
                                type = MobileType.TELCOM.getType();
                            }
                        }
                        type = MobileType.UNICOM.getType();
                    }
                    type = MobileType.CHINAMOBILE.getType();
                }
            } catch (Throwable th) {
                TLogger.e("Util", "getIsp", th);
            }
        }
        return type;
    }

    public static String p(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.LAUNCHER");
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
                if (resolveInfo.activityInfo.applicationInfo.packageName.equalsIgnoreCase(context.getPackageName())) {
                    return resolveInfo.activityInfo.name;
                }
            }
            return "";
        } catch (Throwable th) {
            TLogger.e("Util", "get launcher class name error: " + th.toString());
            return "";
        }
    }

    private static void q(final Context context) {
        try {
            CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.common.i.1
                @Override // com.tencent.tpns.baseapi.base.util.TTask
                public void TRun() {
                    TLogger.d("Util", "load sdk config data");
                    XGPushConfig.getAccessId(context);
                    XGPushConfig.getAccessKey(context);
                    XGPushConfig.getToken(context);
                }
            });
        } catch (Throwable th) {
            TLogger.w("Util", "loadConfigData error: " + th.toString());
        }
    }

    private static void r(final Context context) {
        if ((context.getApplicationInfo().flags & 2) != 0) {
            try {
                new Thread(new TTask() { // from class: com.tencent.android.tpush.common.i.2
                    /* JADX WARN: Removed duplicated region for block: B:282:0x0248 A[Catch: all -> 0x024c, TRY_ENTER, TRY_LEAVE, TryCatch #9 {all -> 0x024c, blocks: (B:267:0x022e, B:282:0x0248), top: B:317:0x001c }] */
                    /* JADX WARN: Removed duplicated region for block: B:306:0x023e A[EXC_TOP_SPLITTER, SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:329:? A[RETURN, SYNTHETIC] */
                    @Override // com.tencent.tpns.baseapi.base.util.TTask
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void TRun() {
                        /*
                            Method dump skipped, instructions count: 615
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.common.i.AnonymousClass2.TRun():void");
                    }
                }).start();
                return;
            } catch (Throwable th) {
                Logger.e("Util", "checkVersionUpdate error " + th.toString());
                return;
            }
        }
        Logger.d("Util", "It is release");
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.length() >= 32;
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        if (str2 != null) {
            try {
                if (str2.length() > 0) {
                    jSONObject.put(str, str2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static long d(String str) {
        if (str == null || str.equals("0") || str.equals("")) {
            return 0L;
        }
        String trim = str.trim();
        long[] jArr = new long[4];
        int indexOf = trim.indexOf(".");
        int i2 = indexOf + 1;
        int indexOf2 = trim.indexOf(".", i2);
        int i3 = indexOf2 + 1;
        int indexOf3 = trim.indexOf(".", i3);
        try {
            jArr[3] = Long.parseLong(trim.substring(0, indexOf));
            jArr[2] = Long.parseLong(trim.substring(i2, indexOf2));
            jArr[1] = Long.parseLong(trim.substring(i3, indexOf3));
            jArr[0] = Long.parseLong(trim.substring(indexOf3 + 1));
        } catch (Throwable th) {
            for (int i4 = 0; i4 < 4; i4++) {
                jArr[i4] = 0;
            }
            TLogger.e("Util", "service Util@@parseIpAddress(" + trim + ")", th);
        }
        return (jArr[0] << 24) + (jArr[1] << 16) + (jArr[2] << 8) + jArr[3];
    }

    public static boolean b(Context context) {
        try {
            List<ResolveInfo> c2 = com.tencent.android.tpush.service.util.f.c(context, context.getPackageName() + Constants.RPC_SUFFIX);
            if (c2 != null) {
                return c2.size() > 0;
            }
            return false;
        } catch (Throwable th) {
            TLogger.e("Util", "Util -> isAIDLConfiged", th);
            return false;
        }
    }

    public static void a(JSONObject jSONObject, String str, long j2) {
        if (str == null || j2 <= 0) {
            return;
        }
        try {
            jSONObject.put(str, j2);
        } catch (Throwable unused) {
        }
    }

    public static int a(Context context) {
        if (b.get()) {
            return 0;
        }
        try {
            TBaseLogger.init(context);
            if (XGPushManager.getContext() == null) {
                XGPushManager.setContext(context);
            }
            if (com.tencent.android.tpush.service.b.e() == null) {
                com.tencent.android.tpush.service.b.b(context);
            }
            XGPushProvider.fetchProviderAuthorities(context);
            if (!h(context)) {
                TLogger.ee("Util", "XG is disable");
                return ReturnCode.CODE_SERVICE_DISABLED.getType();
            } else if (!Security.checkTpnsSecurityLibSo(context)) {
                TLogger.ee("Util", "can not load library from so file");
                ReturnCode returnCode = ReturnCode.CODE_SO_ERROR;
                ServiceStat.reportErrCode(context, returnCode.getType(), "can not load library from so file", 0L, "inner");
                return returnCode.getType();
            } else {
                AppInfos.checkApplicationIcon(context);
                StatServiceImpl.init(context);
                q(context);
                g(context);
                r(context);
                b.set(true);
                return 0;
            }
        } catch (Throwable th) {
            TLogger.e("Util", "Util -> initGlobal", th);
            return -1;
        }
    }

    public static void f(Context context) {
        if (context == null || f6096c) {
            return;
        }
        try {
            f(context, XGVipPushService.class.getName());
            f(context, TpnsActivity.class.getName());
            f(context, XGPushProvider.class.getName());
            f(context, SettingsContentProvider.class.getName());
            for (ActivityInfo activityInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 2).receivers) {
                String str = activityInfo.name;
                try {
                    Class<?> loadClass = context.getClassLoader().loadClass(str);
                    if (XGPushBaseReceiver.class.isAssignableFrom(loadClass) || loadClass.getName().equals(XGPushReceiver.class.getName())) {
                        f(context, str);
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
        } catch (Throwable th) {
            TLogger.e("Util", "enableComponents", th);
        }
        f6096c = true;
    }

    public static boolean b(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String e(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(RC4.decrypt(com.tencent.android.tpush.service.channel.security.a.a(str.getBytes("UTF-8"), 0)), "UTF-8");
        } catch (Throwable th) {
            TLogger.e("Util", "decode error", th);
            return str;
        }
    }

    public static void b(PackageManager packageManager, Context context, String str) {
        if (context == null || str == null) {
            return;
        }
        try {
            if (str.trim().length() == 0 || packageManager == null) {
                return;
            }
            ComponentName componentName = new ComponentName(context.getPackageName(), str);
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean c(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static String b() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) ? str.trim().toLowerCase() : str;
    }

    public static boolean c(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            return packageInfo.firstInstallTime == packageInfo.lastUpdateTime;
        } catch (Throwable th) {
            TLogger.e("Util", "unexpected for isFirstInstall: " + th.getMessage());
            return false;
        }
    }

    public static boolean d(Context context, String str) {
        if (context != null) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mActivities");
                declaredField.setAccessible(true);
                Map map = (Map) declaredField.get(invoke);
                if (map == null) {
                    Logger.w("Util", "get current activities for currentActivityThread, activities is null");
                    return false;
                }
                for (Object obj : map.values()) {
                    Class<?> cls2 = obj.getClass();
                    Field declaredField2 = cls2.getDeclaredField("paused");
                    declaredField2.setAccessible(true);
                    if (!declaredField2.getBoolean(obj)) {
                        Field declaredField3 = cls2.getDeclaredField("activity");
                        declaredField3.setAccessible(true);
                        Activity activity = (Activity) declaredField3.get(obj);
                        if (activity == null) {
                            Logger.w("Util", "[getCurrentActivity] activity is null");
                            return false;
                        } else if (activity.getPackageName().equals(context.getPackageName())) {
                            Logger.d("Util", "getCurrentActivity: " + activity.getLocalClassName());
                            return true;
                        } else {
                            Logger.w("Util", "current activity packageName: " + activity.getPackageName() + ", appPackageName: " + context.getPackageName());
                            return false;
                        }
                    }
                }
            } catch (Throwable th) {
                Logger.w("Util", "[getCurrentActivity] error: " + th.getMessage());
                return e(context, str);
            }
        }
        return false;
    }

    public static boolean e(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        } catch (Throwable unused) {
        }
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(str) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Context context, String str) {
        return MqttTools.isPushMsgTopic(context, str) || MqttTools.isAesPushMsgTopic(context, str) || MqttTools.isGZipPushMsgTopic(context, str) || MqttTools.isGZipAesPushMsgTopic(context, str);
    }

    public static boolean a(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            BroadcastAgent.unregisterReceiver(context, broadcastReceiver);
            return true;
        } catch (Throwable th) {
            TLogger.e("Util", "safeUnregisterReceiver error", th);
            return false;
        }
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(com.tencent.android.tpush.service.channel.security.a.b(RC4.encrypt(str.getBytes("UTF-8")), 0), "UTF-8");
        } catch (Throwable th) {
            TLogger.e("Util", "encode error", th);
            return str;
        }
    }

    public static void a() {
        try {
            PowerManager.WakeLock b2 = com.tencent.android.tpush.service.e.a().b();
            if (b2 != null) {
                if (b2.isHeld()) {
                    b2.release();
                }
                TLogger.d("Util", "stop WakeLock CPU");
            }
        } catch (Throwable th) {
            TLogger.e("Util", "stopWakeLock", th);
        }
    }

    public static void a(Context context, int i2) {
        if (2 == i2) {
            try {
                com.tencent.android.tpush.c.d.f6077c = ((String) CommonHelper.getMetaData(context, "com.meizu.push.api_id", "")).substring(4);
                com.tencent.android.tpush.c.d.f6078d = ((String) CommonHelper.getMetaData(context, "com.meizu.push.api_key", "")).substring(4);
                TLogger.d("Util", "mz:" + com.tencent.android.tpush.c.d.f6077c + ", " + com.tencent.android.tpush.c.d.f6078d);
            } catch (Throwable unused) {
                TLogger.w("Util", "unexpected for init mz");
            }
        } else if (1 == i2) {
            try {
                com.tencent.android.tpush.c.d.a = ((String) CommonHelper.getMetaData(context, "com.xiaomi.push.api_id", "")).substring(4);
                com.tencent.android.tpush.c.d.b = ((String) CommonHelper.getMetaData(context, "com.xiaomi.push.api_key", "")).substring(4);
                TLogger.d("Util", "mi:" + com.tencent.android.tpush.c.d.a + ", " + com.tencent.android.tpush.c.d.b);
            } catch (Throwable unused2) {
                TLogger.w("Util", "unexpected for init xm");
            }
        } else if (6 == i2) {
            try {
                com.tencent.android.tpush.c.d.f6079e = ((String) CommonHelper.getMetaData(context, "com.oppo.push.api_id", "")).substring(4);
                com.tencent.android.tpush.c.d.f6080f = ((String) CommonHelper.getMetaData(context, "com.oppo.push.api_key", "")).substring(4);
                TLogger.d("Util", "oppo:" + com.tencent.android.tpush.c.d.f6079e + ", " + com.tencent.android.tpush.c.d.f6080f);
            } catch (Throwable unused3) {
                TLogger.w("Util", "unexpected for init oppo");
            }
        }
    }

    public static String a(Context context, String str) {
        BufferedReader bufferedReader;
        InputStreamReader inputStreamReader;
        if (!b(a)) {
            return a;
        }
        try {
            InputStream open = context.getResources().getAssets().open(str);
            if (open == null) {
                return null;
            }
            inputStreamReader = new InputStreamReader(open, "UTF-8");
            try {
                bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    String stringBuffer2 = stringBuffer.toString();
                    a = stringBuffer2;
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused) {
                    }
                    try {
                        inputStreamReader.close();
                    } catch (Throwable unused2) {
                    }
                    return stringBuffer2;
                } catch (Throwable unused3) {
                    try {
                        TLogger.d("Util", "assets is null");
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Throwable unused4) {
                            }
                        }
                        return null;
                    } finally {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused5) {
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (Throwable unused6) {
                            }
                        }
                    }
                }
            } catch (Throwable unused7) {
                bufferedReader = null;
            }
        } catch (Throwable unused8) {
            bufferedReader = null;
            inputStreamReader = null;
        }
    }

    public static boolean a(Activity activity) {
        if (activity != null) {
            try {
                TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{16842838, 16842841, 16842836, 16842840, 16843435});
                boolean z = obtainStyledAttributes.getBoolean(0, false);
                Drawable drawable = obtainStyledAttributes.getDrawable(1);
                int color = obtainStyledAttributes.getColor(2, -1);
                boolean z2 = obtainStyledAttributes.getBoolean(3, false);
                Drawable drawable2 = obtainStyledAttributes.getDrawable(4);
                obtainStyledAttributes.recycle();
                if (z && z2 && drawable == null && drawable2 == null) {
                    if (color == activity.getResources().getColor(17170445)) {
                        return true;
                    }
                }
            } catch (Throwable th) {
                Logger.w("Util", "run TranslucentNotitleTheme failed: " + th.getMessage());
            }
        }
        return false;
    }

    public static boolean a(long j2, long j3) {
        try {
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            String format = simpleDateFormat.format(Long.valueOf(j2));
            String format2 = simpleDateFormat2.format(Long.valueOf(j3));
            Date parse = simpleDateFormat.parse(format);
            Date parse2 = simpleDateFormat2.parse(format2);
            calendar.setTime(parse);
            calendar2.setTime(parse2);
            return a(calendar, calendar2);
        } catch (Throwable unused) {
            Logger.w("Util", "");
            return false;
        }
    }

    public static boolean a(Calendar calendar, Calendar calendar2) {
        if (calendar == null || calendar2 == null) {
            return false;
        }
        try {
            if (calendar.get(0) == calendar2.get(0) && calendar.get(1) == calendar2.get(1)) {
                return calendar.get(6) == calendar2.get(6);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
