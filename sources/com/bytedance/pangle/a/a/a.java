package com.bytedance.pangle.a.a;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class a {
    private static Map<String, Field> a = new HashMap();
    private static Map<String, Method> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, Constructor> f2204c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private static Map<String, Class> f2205d = new HashMap();

    static {
        try {
            FieldUtils.writeField(b.class, "classLoader", (Object) null);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "HackHelperinit failed", e2);
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String b2 = b(cls, str, clsArr);
        synchronized (b) {
            method = b.get(b2);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method a2 = b.a(cls, str, clsArr);
            if (a2 != null) {
                synchronized (b) {
                    b.put(b2, a2);
                }
            }
            return a2;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    private static String b(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
        sb.append(str);
        if (clsArr != null && clsArr.length > 0) {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.getName());
                sb.append(MqttTopic.MULTI_LEVEL_WILDCARD);
            }
        } else {
            sb.append(Void.class.getName());
        }
        return sb.toString();
    }

    public static Constructor a(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String b2 = b(cls, "clinit", clsArr);
        synchronized (f2204c) {
            constructor = f2204c.get(b2);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor a2 = b.a(cls, clsArr);
            if (a2 != null) {
                synchronized (f2204c) {
                    f2204c.put(b2, a2);
                }
            }
            return a2;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th);
            return null;
        }
    }

    public static Field a(Class<?> cls, String str) {
        Field field;
        String str2 = cls.getName() + MqttTopic.MULTI_LEVEL_WILDCARD + str;
        synchronized (a) {
            field = a.get(str2);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field a2 = b.a(cls, str);
            if (a2 != null) {
                synchronized (a) {
                    a.put(str2, a2);
                }
            }
            return a2;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }
}
