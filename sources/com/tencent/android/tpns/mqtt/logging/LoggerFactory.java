package com.tencent.android.tpns.mqtt.logging;

import java.util.ResourceBundle;

/* loaded from: classes3.dex */
public class LoggerFactory {
    private static final String CLASS_NAME = "LoggerFactory";
    public static final String MQTT_CLIENT_MSG_CAT = "com.tencent.android.tpns.mqtt.internal.nls.logcat";
    private static String jsr47LoggerClassName = JSR47Logger.class.getName();
    private static String overrideloggerClassName;

    public static Logger getLogger(String str, String str2) {
        return new MLogger();
    }

    public static String getLoggingProperty(String str) {
        return null;
    }

    public static void setLogger(String str) {
        overrideloggerClassName = str;
    }

    private static Logger getLogger(String str, ResourceBundle resourceBundle, String str2, String str3) {
        try {
            Class<?> cls = Class.forName(str);
            if (cls != null) {
                Logger logger = (Logger) cls.newInstance();
                logger.initialise(resourceBundle, str2, str3);
                return logger;
            }
            return null;
        } catch (ClassNotFoundException | ExceptionInInitializerError | IllegalAccessException | InstantiationException | NoClassDefFoundError | SecurityException unused) {
            return null;
        }
    }
}
