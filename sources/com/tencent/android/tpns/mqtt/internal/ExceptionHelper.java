package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttSecurityException;

/* loaded from: classes3.dex */
public class ExceptionHelper {
    private ExceptionHelper() {
    }

    public static MqttException createMqttException(int i2) {
        if (i2 != 4 && i2 != 5) {
            return new MqttException(i2);
        }
        return new MqttSecurityException(i2);
    }

    public static boolean isClassAvailable(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static MqttException createMqttException(Throwable th) {
        if (th.getClass().getName().equals("java.security.GeneralSecurityException")) {
            return new MqttSecurityException(th);
        }
        return new MqttException(th);
    }
}
