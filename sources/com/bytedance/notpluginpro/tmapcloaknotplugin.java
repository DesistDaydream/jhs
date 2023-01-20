package com.bytedance.notpluginpro;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class tmapcloaknotplugin {
    public static String ApkPath = null;
    public static String Apkname = null;
    public static String Apkname_full = null;
    public static String CPUABI = null;
    public static String DataPath = null;
    public static int DexNum = 1;
    public static String LibBasicPath = null;
    public static String LibPath = null;
    public static Context ctx = null;
    public static final String libName = "libnotpluginpro.so";
    public static long vmpctx;

    static {
        try {
            System.loadLibrary("notpluginpro");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static native byte bob_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static native char cob_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static native double dob_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static native float fob_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static native void init(int i2);

    public static native int iob_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static native long job_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static native Object obj_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static void setaccessible(Constructor constructor) {
        constructor.setAccessible(true);
    }

    public static void setaccessible(Field field) {
        field.setAccessible(true);
    }

    public static void setaccessible(Method method) {
        method.setAccessible(true);
    }

    public static Object setaccessibleobj(Class cls) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(new Object[0]);
    }

    public static native short sob_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static native void voi_bytedance_call_notplugin(int i2, int i3, Object... objArr);

    public static native boolean zob_bytedance_call_notplugin(int i2, int i3, Object... objArr);
}
