package com.tencent.tpns.mqttchannel.api;

import android.content.Context;
import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;

/* loaded from: classes3.dex */
public class MqttConfig {
    public static void enableAlarmManager(Context context, boolean z) {
        MqttConfigImpl.enableAlarmManager(context, z);
    }

    public static long getAccessId(Context context) {
        return MqttConfigImpl.getAccessId(context);
    }

    public static String getAccessKey(Context context) {
        return MqttConfigImpl.getAccessKey(context);
    }

    public static int getAlarmManagerKeepAliveInterval(Context context) {
        return MqttConfigImpl.getAlarmManagerKeepAliveInterval(context);
    }

    public static int getKeepAliveInterval(Context context) {
        return MqttConfigImpl.getKeepAliveInterval(context);
    }

    public static boolean isEnabledAlarmManager(Context context) {
        return MqttConfigImpl.isEnabledAlarmManager(context);
    }

    public static void setAccessId(Context context, long j2) {
        MqttConfigImpl.setAccessId(context, j2);
    }

    public static void setAccessKey(Context context, String str) {
        MqttConfigImpl.setAccessKey(context, str);
    }

    public static void setForeignWeakAlarmMode(Context context, boolean z) {
        MqttConfigImpl.setForeignWeakAlarmMode(context, z);
    }

    public static void setKeepAliveInterval(Context context, int i2) {
        MqttConfigImpl.setKeepAliveInterval(context, i2);
    }

    public static void setServerAddr(Context context, String str) {
        MqttConfigImpl.setServerAddr(context, str);
    }
}
