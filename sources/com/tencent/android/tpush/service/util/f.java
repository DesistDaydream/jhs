package com.tencent.android.tpush.service.util;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpush.TypeStr;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.TPushAlarmManager;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.crosssp.ProviderMessage;
import e.t.u.b0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class f {
    public static List<String> a = new ArrayList();
    private static long b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static long f6375c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static int f6376d = -1;

    public static List<ResolveInfo> a(Context context) {
        TLogger.d("ServiceUtil", "action - getLocalPushAppsInfo");
        if (context != null) {
            try {
                HashMap hashMap = new HashMap();
                PackageManager packageManager = context.getPackageManager();
                List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(new Intent("android.intent.action"), 32);
                queryIntentActivities.addAll(packageManager.queryIntentActivities(new Intent(""), 32));
                queryIntentActivities.addAll(packageManager.queryBroadcastReceivers(new Intent(Constants.ACTION_SDK_INSTALL), 512));
                for (ResolveInfo resolveInfo : queryIntentActivities) {
                    hashMap.put(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo);
                }
                return new ArrayList(hashMap.values());
            } catch (Throwable th) {
                TLogger.e("ServiceUtil", "getLocalPushAppsInfo", th);
                return null;
            }
        }
        return null;
    }

    public static void b(Context context) {
        TLogger.d("ServiceUtil", "action - pullUpServerConfigPkgs");
        try {
            Map<String, String> map = com.tencent.android.tpush.service.a.a.a(context).K;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!h(context, entry.getKey())) {
                        String str = "am startservice -n " + entry.getKey() + MqttTopic.TOPIC_LEVEL_SEPARATOR + entry.getValue();
                        Process exec = Runtime.getRuntime().exec(str);
                        int waitFor = exec.waitFor();
                        if (waitFor != 0) {
                            str = "am startservice --user 0 -n " + entry.getKey() + MqttTopic.TOPIC_LEVEL_SEPARATOR + entry.getValue();
                            TLogger.d("ServiceUtil", "start service:" + str);
                            exec = Runtime.getRuntime().exec(str);
                            waitFor = exec.waitFor();
                        }
                        if (waitFor != 0) {
                            TLogger.e("ServiceUtil", "pullUpServerConfigPkgs error exec cmd:" + str + ",exitValud:" + exec.exitValue());
                        }
                    }
                }
                return;
            }
            TLogger.d("ServiceUtil", "pullUpServerConfigPkgs no pull up packages map");
        } catch (Throwable th) {
            TLogger.e("ServiceUtil", "", th);
        }
    }

    public static void c(Context context) {
        try {
            if (CloudManager.getInstance(context).getAppClsAlive() == 1) {
                TLogger.d("ServiceUtil", "disable pull up group");
                return;
            }
            JSONArray pullupArrProviderAndActivity = CloudManager.getInstance(context).getPullupArrProviderAndActivity();
            if (pullupArrProviderAndActivity != null && pullupArrProviderAndActivity.length() != 0) {
                for (int i2 = 0; i2 < pullupArrProviderAndActivity.length(); i2++) {
                    a(context, pullupArrProviderAndActivity.optJSONObject(i2));
                }
                return;
            }
            TLogger.i("ServiceUtil", "pullupOtherServiceByProviderAndActivity no running");
        } catch (Throwable th) {
            TLogger.e("ServiceUtil", "pullupOtherServiceByProviderAndActivity" + th);
        }
    }

    public static void d(Context context) {
        if (com.tencent.android.tpush.e.a.a(context)) {
            TLogger.dd("ServiceUtil", "Run As SysPush, Not pull up other XGService");
        } else if (GuidInfoManager.isServerDestroy(context)) {
            TLogger.ii("ServiceUtil", "server destroy, Not pull up other app");
        } else if (ChannelUtils.isMiuiV12()) {
            TLogger.dd("ServiceUtil", "Run As MIUI 12, Not pull up other XGService");
        } else if (CloudManager.getInstance(context).disablePullUp()) {
            TLogger.dd("ServiceUtil", " Not pull up other XGService with cloud");
        } else if (a(context.getPackageName())) {
            TLogger.dd("ServiceUtil", context.getPackageName() + " ignore pull up");
        } else {
            TLogger.d("ServiceUtil", "not in ignore app list");
            if (PushPreferences.getBoolean(context, Constants.ENABLE_PULL_UP_OTHER_APP, false)) {
                TLogger.i("ServiceUtil", "default pull up other app");
                try {
                    g(context);
                } catch (Throwable th) {
                    TLogger.e("ServiceUtil", "pullUpXGServiceByProvider" + th);
                }
                c(context);
                b(context);
                return;
            }
            TLogger.ii("ServiceUtil", "disable pull up other app");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(Context context, String str) {
        String str2;
        if (str == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo != null && (str2 = runningAppProcessInfo.processName) != null && str2.startsWith(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(Context context, String str) {
        if (i.b(str)) {
            return false;
        }
        String pullupBlackList = CloudManager.getInstance(context).getPullupBlackList();
        if (i.b(pullupBlackList)) {
            return false;
        }
        return pullupBlackList.contains(str);
    }

    public static void e(Context context) {
        try {
            String d2 = com.tencent.android.tpush.stat.b.b.d(context);
            TLogger.d("ServiceUtil", "serviceSafeExit @ " + d2);
            if (d2 == null || !d2.contains(":xg_vip_service")) {
                return;
            }
            XGVipPushService.b().stopSelf();
        } catch (Throwable th) {
            TLogger.e("ServiceUtil", "unexpected for serviceSafeExit", th);
        }
    }

    public static void f(Context context) {
        try {
            TLogger.d("ServiceUtil", "cancelPingAlarmManager");
            Intent intent = new Intent(Constants.XG_PUSH_SERVICE_PING_ACTION);
            intent.setClassName(context, "com.tencent.android.tpush.XGPushReceiver");
            intent.setPackage(context.getPackageName());
            TPushAlarmManager.getAlarmManager(context).cancal(PendingIntent.getBroadcast(context, 0, intent, Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728));
        } catch (Throwable th) {
            TLogger.w("ServiceUtil", "cancelPingAlarmManager error: " + th.toString());
        }
    }

    private static void g(final Context context) {
        TLogger.d("ServiceUtil", "action - pullUpXGServiceByProvider on 2s later");
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.service.util.f.2
            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                List<ResolveInfo> a2 = f.a(context);
                if (a2 != null) {
                    int i2 = 0;
                    for (ResolveInfo resolveInfo : a2) {
                        i2++;
                        if ("oppo".equals(i.b())) {
                            if (i2 > 2) {
                                return;
                            }
                        } else if (i2 > 4) {
                            return;
                        }
                        String str = resolveInfo.activityInfo.applicationInfo.packageName;
                        if (!f.h(context, str) && !i.b(str) && !context.getPackageName().equals(str) && !f.b(context, str) && f.a(context, str)) {
                            try {
                                String str2 = "content://" + str + ".XGVIP_PUSH_AUTH/" + TypeStr.pullupxg.getStr();
                                Uri parse = Uri.parse(str2);
                                TLogger.d("ServiceUtil", "pull up by provider, pkgName: " + str + ", uri:" + str2);
                                ProviderMessage.getType(context, parse);
                                Thread.sleep(200L);
                            } catch (Throwable th) {
                                TLogger.e("ServiceUtil", "pull up by provider error" + th);
                            }
                        }
                    }
                    return;
                }
                TLogger.ii("ServiceUtil", "pullupXGServices  with null content");
            }
        }, 2000L);
    }

    public static List<ResolveInfo> c(Context context, String str) {
        if (context != null) {
            try {
                return context.getPackageManager().queryIntentServices(new Intent(str), 512);
            } catch (Throwable th) {
                TLogger.e("ServiceUtil", "getLocalPushServicesInfo", th);
                return null;
            }
        }
        TLogger.e("ServiceUtil", "getLocalPushServicesInfo the context == null");
        return null;
    }

    public static List<String> a() {
        if (a.isEmpty()) {
            a.add("com.jingdong.app.mall");
            a.add("com.ifeng.news2");
        }
        return a;
    }

    public static boolean a(String str) {
        return a().contains(str);
    }

    public static void a(final Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        final String optString = jSONObject.optString("name", "");
        if (i.b(optString) || h(context, optString) || g(context, optString)) {
            return;
        }
        TLogger.d("ServiceUtil", "action - pullUpOtherServiceByProviderAndActivityJSONOject, proName:" + optString);
        String optString2 = jSONObject.optString(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "");
        if (!i.b(optString2)) {
            try {
                Intent intent = new Intent(optString2);
                intent.setFlags(268435456);
                context.startActivity(intent);
            } catch (Throwable unused) {
                TLogger.d("ServiceUtil", "unexpected for start activity for action:" + optString2);
            }
        } else {
            String optString3 = jSONObject.optString("schema", "");
            if (!i.b(optString3)) {
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(optString3));
                    intent2.setFlags(268435456);
                    context.startActivity(intent2);
                } catch (Throwable unused2) {
                    TLogger.d("ServiceUtil", "unexpected for start activity for schema:" + optString3);
                }
            }
        }
        final String optString4 = jSONObject.optString("url", "");
        if (i.b(optString4)) {
            return;
        }
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.service.util.f.1
            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                try {
                    if (f.g(context, optString)) {
                        return;
                    }
                    ProviderMessage.getType(context, Uri.parse("content://" + optString4));
                } catch (Throwable unused3) {
                    TLogger.d("ServiceUtil", "unexpected for start provider for providerUrl:" + optString4);
                }
            }
        }, 2000L);
    }

    public static boolean b(Context context, String str) {
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
            if (runningServices == null || runningServices.size() <= 0) {
                return false;
            }
            String name = XGVipPushService.class.getName();
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if (runningServiceInfo.pid != 0 && name.equals(runningServiceInfo.service.getClassName())) {
                    String packageName = runningServiceInfo.service.getPackageName();
                    if (i.c(packageName) && packageName.equals(str)) {
                        TLogger.d("ServiceUtil", "isSurvive srvPkg :" + packageName);
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            TLogger.e("ServiceUtil", "checkXGServiceV3IsRunningByPkgName", th);
            return false;
        }
    }

    public static boolean d(Context context, String str) {
        List<String> registerInfos;
        if (context == null || (registerInfos = CacheManager.getRegisterInfos(context)) == null) {
            return false;
        }
        for (String str2 : registerInfos) {
            if (str2.equals(str) && !context.getPackageName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static long b(Intent intent) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(b0.a.t, Locale.getDefault());
            String stringExtra = intent.getStringExtra(MessageKey.MSG_DATE);
            if (i.b(stringExtra)) {
                stringExtra = simpleDateFormat.format(new Date());
            }
            long time = simpleDateFormat.parse(stringExtra).getTime();
            JSONObject jSONObject = new JSONObject(Rijndael.decrypt(intent.getStringExtra("content")));
            if (jSONObject.isNull("accept_time")) {
                return time;
            }
            String string = jSONObject.getString("accept_time");
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() == 0) {
                return time;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = new JSONObject(new JSONObject(jSONArray.getString(i3)).getString(MessageKey.MSG_ACCEPT_TIME_START));
                int intValue = (Integer.valueOf(jSONObject2.getString(MessageKey.MSG_ACCEPT_TIME_HOUR)).intValue() * 60) + Integer.valueOf(jSONObject2.getString(MessageKey.MSG_ACCEPT_TIME_MIN)).intValue();
                if (intValue < i2 || i2 == 0) {
                    i2 = intValue;
                }
            }
            long j2 = time + (i2 * 60 * 1000);
            TLogger.i("Utils", "get acceptTime = " + string + " , acceptBeginTime= " + j2);
            return j2;
        } catch (Throwable th) {
            TLogger.d("ServiceUtil", "getAcceptBeginTime " + th.toString());
            return 0L;
        }
    }

    public static boolean a(Context context, String str) {
        List<ResolveInfo> queryIntentServices;
        try {
            queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(context.createPackageContext(str, 0), XGVipPushService.class), 0);
        } catch (Throwable th) {
            TLogger.w("ServiceUtil", "unexpected for isXGServiceV4ProcssNameConfigByName:" + th.getMessage());
        }
        if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (resolveInfo.serviceInfo.processName.contains("xg_vip_service")) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static Intent a(int i2, String str, int i3) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
        if (str != null && str.length() != 0) {
            intent.setPackage(str);
        }
        intent.putExtra("TPUSH.FEEDBACK", i3);
        intent.putExtra("TPUSH.ERRORCODE", i2);
        return intent;
    }

    public static boolean a(Intent intent) {
        try {
            JSONObject jSONObject = new JSONObject(Rijndael.decrypt(intent.getStringExtra("content")));
            if (jSONObject.isNull("accept_time")) {
                return true;
            }
            String string = jSONObject.getString("accept_time");
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() == 0) {
                return true;
            }
            Calendar calendar = Calendar.getInstance();
            int i2 = (calendar.get(11) * 60) + calendar.get(12);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i3));
                JSONObject jSONObject3 = new JSONObject(jSONObject2.getString(MessageKey.MSG_ACCEPT_TIME_START));
                int intValue = (Integer.valueOf(jSONObject3.getString(MessageKey.MSG_ACCEPT_TIME_HOUR)).intValue() * 60) + Integer.valueOf(jSONObject3.getString(MessageKey.MSG_ACCEPT_TIME_MIN)).intValue();
                JSONObject jSONObject4 = new JSONObject(jSONObject2.getString(MessageKey.MSG_ACCEPT_TIME_END));
                int intValue2 = (Integer.valueOf(jSONObject4.getString(MessageKey.MSG_ACCEPT_TIME_HOUR)).intValue() * 60) + Integer.valueOf(jSONObject4.getString(MessageKey.MSG_ACCEPT_TIME_MIN)).intValue();
                TLogger.i("ServiceUtil", ">> check accept time, current:" + i2 + ", startTime:" + intValue + ", endTime:" + intValue2);
                if (intValue <= i2 && i2 <= intValue2) {
                    return true;
                }
            }
            TLogger.w("Utils", " discurd the msg due to time not accepted! acceptTime = " + string + " , curTime= " + i2);
            return false;
        } catch (Throwable th) {
            TLogger.d("ServiceUtil", "checkAcceptTime " + th.toString());
            return true;
        }
    }
}
