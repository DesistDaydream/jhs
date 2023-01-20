package com.tencent.tpns.mqttchannel.core.common.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.mqttchannel.core.common.a.a;

/* loaded from: classes3.dex */
public class MqttConfigImpl {
    public static final int DEFAULT_KEEP_ALIVE_INTERVAL = 285;
    private static Integer a;

    private static boolean a(Context context) {
        Object metaData;
        int i2 = PushPreferences.getInt(context, "com.tencent.android.tpush.enable_FOREIGIN_XG_WEAK_ALARM," + context.getPackageName(), -1);
        if (i2 == -1 && (metaData = CommonHelper.getMetaData(context, "XG_WEAK_ALARM", null)) != null) {
            if (metaData.toString().equals("true")) {
                i2 = 1;
            }
            a.e("MqttConfigImpl", "getMetaData key:" + i2);
        }
        return i2 == 1;
    }

    public static void enableAlarmManager(Context context, boolean z) {
        PushPreferences.putBoolean(context, "MQTT_ENABLE_ALARM_MANAGER", z);
    }

    public static long getAccessId(Context context) {
        return XGApiConfig.getAccessId(context);
    }

    public static String getAccessKey(Context context) {
        return XGApiConfig.getAccessKey(context);
    }

    public static int getAlarmManagerKeepAliveInterval(Context context) {
        return getKeepAliveInterval(context) + 10;
    }

    public static int getKeepAliveInterval(Context context) {
        try {
            int interval = CloudManager.getInstance(context).getInterval() / 1000;
            if (interval >= 60) {
                a = Integer.valueOf(interval);
            }
            if (a == null) {
                if (a(context)) {
                    a.b("MqttConfigImpl", "isForeignWeakAlarmMode KeepAlive set to : 3600");
                    return 3600;
                }
                Integer valueOf = Integer.valueOf(PushPreferences.getInt(context, "MQTT_KEEPALIVE_INTERVAL", 0));
                a = valueOf;
                if (valueOf.intValue() == 0) {
                    a = Integer.valueOf((int) DEFAULT_KEEP_ALIVE_INTERVAL);
                }
            }
            return a.intValue();
        } catch (Throwable unused) {
            return DEFAULT_KEEP_ALIVE_INTERVAL;
        }
    }

    public static String getServerAddr(Context context) {
        String string = PushPreferences.getString(context, "MQTT_HOST", null);
        return TextUtils.isEmpty(string) ? "tcp://127.0.0.1:1883" : string;
    }

    public static boolean isEnabledAlarmManager(Context context) {
        return PushPreferences.getBoolean(context, "MQTT_ENABLE_ALARM_MANAGER", false);
    }

    public static void setAccessId(Context context, long j2) {
        XGApiConfig.setAccessId(context, j2);
    }

    public static void setAccessKey(Context context, String str) {
        XGApiConfig.setAccessKey(context, str);
    }

    public static void setForeignWeakAlarmMode(Context context, boolean z) {
        PushPreferences.putInt(context, "com.tencent.android.tpush.enable_FOREIGIN_XG_WEAK_ALARM," + context.getPackageName(), z ? 1 : 0);
    }

    public static boolean setKeepAliveInterval(Context context, int i2) {
        if (i2 < 10 || i2 > 36000) {
            return false;
        }
        a = Integer.valueOf(i2);
        PushPreferences.putInt(context, "MQTT_KEEPALIVE_INTERVAL", i2);
        return true;
    }

    public static void setServerAddr(Context context, String str) {
        PushPreferences.putString(context, "MQTT_HOST", str);
    }
}
