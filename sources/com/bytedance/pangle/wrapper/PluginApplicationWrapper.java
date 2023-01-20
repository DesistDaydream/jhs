package com.bytedance.pangle.wrapper;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.pangle.PluginContext;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.i;
import java.io.File;

@Keep
@SuppressLint({"MissingSuperCall", "NewApi"})
/* loaded from: classes.dex */
public class PluginApplicationWrapper extends Application {
    public Application mOriginApplication;
    public PluginContext mPluginContext;

    public PluginApplicationWrapper(Application application, PluginContext pluginContext) {
        this.mOriginApplication = application;
        this.mPluginContext = pluginContext;
        try {
            FieldUtils.writeField(this, "mBase", pluginContext);
            if (i.a()) {
                return;
            }
            FieldUtils.writeField(FieldUtils.getField(ContextWrapper.class, "mBase"), this, pluginContext);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0000, code lost:
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String PluginApplicationWrapper1663646904334dc(java.lang.String r2) {
        /*
        L0:
            r0 = 73
            r1 = 96
        L4:
            switch(r0) {
                case 72: goto L26;
                case 73: goto L8;
                case 74: goto Lb;
                default: goto L7;
            }
        L7:
            goto L2b
        L8:
            switch(r1) {
                case 94: goto L0;
                case 95: goto L26;
                case 96: goto L26;
                default: goto Lb;
            }
        Lb:
            switch(r1) {
                case 55: goto Lf;
                case 56: goto L26;
                case 57: goto L26;
                default: goto Le;
            }
        Le:
            goto L0
        Lf:
            char[] r2 = r2.toCharArray()
            r0 = 0
        L14:
            int r1 = r2.length
            if (r0 >= r1) goto L20
            char r1 = r2[r0]
            r1 = r1 ^ r0
            char r1 = (char) r1
            r2[r0] = r1
            int r0 = r0 + 1
            goto L14
        L20:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            return r0
        L26:
            r0 = 74
            r1 = 55
            goto L4
        L2b:
            r0 = 72
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.wrapper.PluginApplicationWrapper.PluginApplicationWrapper1663646904334dc(java.lang.String):java.lang.String");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDataDir() {
        return this.mPluginContext.getDataDir();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        this.mOriginApplication.onConfigurationChanged(configuration);
    }

    @Override // android.app.Application
    public void onCreate() {
        this.mOriginApplication.onCreate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mOriginApplication.onLowMemory();
    }

    @Override // android.app.Application
    public void onTerminate() {
        this.mOriginApplication.onTerminate();
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        this.mOriginApplication.onTrimMemory(i2);
    }

    @Override // android.app.Application
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mOriginApplication.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Application
    public void registerOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        this.mOriginApplication.registerOnProvideAssistDataListener(onProvideAssistDataListener);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i2) {
        this.mOriginApplication.setTheme(i2);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        this.mOriginApplication.startActivities(intentArr);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        this.mOriginApplication.startActivities(intentArr, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        this.mOriginApplication.startActivity(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        this.mOriginApplication.startActivity(intent, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4) {
        this.mOriginApplication.startIntentSender(intentSender, intent, i2, i3, i4);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        this.mOriginApplication.startIntentSender(intentSender, intent, i2, i3, i4, bundle);
    }

    @Override // android.app.Application
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.mOriginApplication.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    @Override // android.app.Application
    public void unregisterOnProvideAssistDataListener(Application.OnProvideAssistDataListener onProvideAssistDataListener) {
        this.mOriginApplication.unregisterOnProvideAssistDataListener(onProvideAssistDataListener);
    }
}
