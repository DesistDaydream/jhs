package com.tencent.tpns.mqttchannel.core.common.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpush.common.Constants;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.TPushAlarmManager;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.MqttConfig;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: classes3.dex */
public class b {
    public static int a;

    public static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String b(Context context, String str) {
        return "/_xg/push/" + MqttConfig.getAccessId(context) + MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
    }

    public static String c(Context context, String str) {
        return "/_xg/rpc/recv/aes/" + MqttConfig.getAccessId(context) + MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
    }

    public static String d(Context context, String str) {
        return "/_xg/push/aes/" + MqttConfig.getAccessId(context) + MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
    }

    public static String e(Context context, String str) {
        return "/_xg/rpc/recv/gzip/" + MqttConfig.getAccessId(context) + MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
    }

    public static String f(Context context, String str) {
        return "/_xg/push/gzip/" + MqttConfig.getAccessId(context) + MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
    }

    public static String g(Context context, String str) {
        return "/_xg/rpc/recv/gzip_aes/" + MqttConfig.getAccessId(context) + MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
    }

    public static String h(Context context, String str) {
        return "/_xg/push/gzip_aes/" + MqttConfig.getAccessId(context) + MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
    }

    public static boolean i(Context context, String str) {
        return str.startsWith("/_xg/rpc/recv/" + MqttConfig.getAccessId(context) + MqttTopic.TOPIC_LEVEL_SEPARATOR);
    }

    public static boolean j(Context context, String str) {
        return str.startsWith("/_xg/push/" + MqttConfig.getAccessId(context) + MqttTopic.TOPIC_LEVEL_SEPARATOR);
    }

    public static boolean k(Context context, String str) {
        return str.startsWith("/_xg/rpc/recv/aes/" + MqttConfig.getAccessId(context) + MqttTopic.TOPIC_LEVEL_SEPARATOR);
    }

    public static boolean l(Context context, String str) {
        return str.startsWith("/_xg/push/aes/" + MqttConfig.getAccessId(context) + MqttTopic.TOPIC_LEVEL_SEPARATOR);
    }

    public static boolean m(Context context, String str) {
        return str.startsWith("/_xg/rpc/recv/gzip/" + MqttConfig.getAccessId(context) + MqttTopic.TOPIC_LEVEL_SEPARATOR);
    }

    public static boolean n(Context context, String str) {
        return str.startsWith("/_xg/push/gzip/" + MqttConfig.getAccessId(context) + MqttTopic.TOPIC_LEVEL_SEPARATOR);
    }

    public static boolean o(Context context, String str) {
        return str.startsWith("/_xg/rpc/recv/gzip_aes/" + MqttConfig.getAccessId(context) + MqttTopic.TOPIC_LEVEL_SEPARATOR);
    }

    public static boolean p(Context context, String str) {
        return str.startsWith("/_xg/push/gzip_aes/" + MqttConfig.getAccessId(context) + MqttTopic.TOPIC_LEVEL_SEPARATOR);
    }

    public static String a(Context context, String str) {
        return "/_xg/rpc/recv/" + MqttConfig.getAccessId(context) + MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
    }

    public static void b(Context context) {
        Intent intent = new Intent(Constants.XG_PUSH_SERVICE_PING_ACTION);
        intent.setClassName(context, "com.tencent.android.tpush.XGPushReceiver");
        intent.setPackage(context.getPackageName());
        b(context, intent);
        if (MqttConfig.isEnabledAlarmManager(context)) {
            a(context, intent);
        }
    }

    public static boolean a(Context context) {
        try {
            if (Util.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null) {
                    return false;
                }
                return connectivityManager.getActiveNetworkInfo().isConnected();
            }
            return true;
        } catch (Throwable th) {
            if (a()) {
                return true;
            }
            a.a("com.tencent.tpns.mqttchannel.core.common.util", "APNUtil -> checkNetWork", th);
            int i2 = a + 1;
            a = i2;
            if (i2 >= 5) {
                a = 0;
                return true;
            }
        }
    }

    private static void b(Context context, Intent intent) {
        try {
            a.a("com.tencent.tpns.mqttchannel.core.common.util", "cancelPingAlarmManager");
            TPushAlarmManager.getAlarmManager(context).cancal(PendingIntent.getBroadcast(context, 0, intent, Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728));
        } catch (Throwable th) {
            a.d("com.tencent.tpns.mqttchannel.core.common.util", "cancelPingAlarmManager error: " + th.toString());
        }
    }

    public static boolean a() {
        try {
            Process exec = Runtime.getRuntime().exec("ping -c 1 -w 10 www.qq.com");
            int waitFor = exec.waitFor();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (bufferedReader.readLine() != null) {
            }
            bufferedReader.close();
            exec.destroy();
            return waitFor == 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static void a(Context context, Intent intent) {
        try {
            a.a("com.tencent.tpns.mqttchannel.core.common.util", "startPingByAlarmManager");
            int alarmManagerKeepAliveInterval = MqttConfig.getAlarmManagerKeepAliveInterval(context);
            TPushAlarmManager.getAlarmManager(context).set(0, (alarmManagerKeepAliveInterval * 1000) + System.currentTimeMillis(), PendingIntent.getBroadcast(context, 0, intent, Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728), XGApiConfig.isPowerSaveMode(context));
            a.a("com.tencent.tpns.mqttchannel.core.common.util", "Alarm started with interval: " + alarmManagerKeepAliveInterval);
        } catch (Throwable th) {
            a.d("com.tencent.tpns.mqttchannel.core.common.util", "startPingByAlarmManager error: " + th.toString());
        }
    }
}
