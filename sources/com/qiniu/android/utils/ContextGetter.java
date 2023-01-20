package com.qiniu.android.utils;

import android.app.Application;
import android.content.Context;
import com.qiniu.android.storage.GlobalConfiguration;

/* loaded from: classes3.dex */
public final class ContextGetter {
    private static Context context = applicationContext();

    public static Context applicationContext() {
        Context context2 = context;
        if (context2 != null) {
            return context2;
        }
        Context context3 = GlobalConfiguration.appContext;
        if (context3 != null) {
            return context3;
        }
        Application applicationUsingReflection = getApplicationUsingReflection();
        if (applicationUsingReflection != null) {
            context = applicationUsingReflection.getApplicationContext();
        }
        return context;
    }

    private static Application getApplicationUsingReflection() {
        Application application;
        Exception e2;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            application = (Application) cls.getMethod("currentApplication", new Class[0]).invoke(null, null);
            if (application == null) {
                try {
                    return (Application) cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, null), null);
                } catch (Exception e3) {
                    e2 = e3;
                    e2.printStackTrace();
                    return application;
                }
            }
            return application;
        } catch (Exception e4) {
            application = null;
            e2 = e4;
        }
    }
}
