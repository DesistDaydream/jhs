package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.pangle.servermanager.MainServerManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.pangle.util.i;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g {

    /* renamed from: d  reason: collision with root package name */
    private static volatile g f2284d;
    public boolean a;
    public final List<ZeusPluginStateListener> b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    public final List<ZeusPluginEventCallback> f2285c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final Handler f2286e = new Handler(Looper.getMainLooper());

    public static g a() {
        if (f2284d == null) {
            synchronized (g.class) {
                if (f2284d == null) {
                    f2284d = new g();
                }
            }
        }
        return f2284d;
    }

    private static void b() {
        ProviderInfo[] providerInfoArr;
        String str;
        try {
            for (ProviderInfo providerInfo : Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8).providers) {
                if (!TextUtils.isEmpty(providerInfo.authority)) {
                    if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ZeusConstants.f2201e)) {
                        if (!TextUtils.isEmpty(providerInfo.processName) && providerInfo.processName.contains(Constants.COLON_SEPARATOR)) {
                            str = providerInfo.processName.split(Constants.COLON_SEPARATOR)[1];
                            if (Zeus.getServerManagerHashMap().get(str) != null || !TextUtils.equals(str, "main") || !TextUtils.equals(providerInfo.name, MainServerManager.class.getName())) {
                                Zeus.getServerManagerHashMap().put(str, providerInfo);
                            }
                        }
                        str = "main";
                        if (Zeus.getServerManagerHashMap().get(str) != null) {
                        }
                        Zeus.getServerManagerHashMap().put(str, providerInfo);
                    }
                }
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private Object[] c() {
        Object[] array;
        synchronized (this.f2285c) {
            array = !this.f2285c.isEmpty() ? this.f2285c.toArray() : null;
        }
        return array == null ? new Object[0] : array;
    }

    public final synchronized void a(Application application) {
        if (this.a) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager zeus has been inited!");
            return;
        }
        a(3000, 0, null, -1, null);
        Zeus.setAppContext(application);
        GlobalParam globalParam = GlobalParam.getInstance();
        globalParam.init();
        if (application != null) {
            ZeusLogger.setDebug(globalParam.isDebug());
            ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusManager init, context = " + application + ", hParam = " + globalParam);
            com.bytedance.pangle.b.b a = com.bytedance.pangle.b.b.a();
            com.bytedance.pangle.b.a aVar = new com.bytedance.pangle.b.a() { // from class: com.bytedance.pangle.g.1
                @Override // com.bytedance.pangle.b.a
                public final void a(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
                    }
                    String str2 = null;
                    if (Zeus.getAppApplication() != null) {
                        Zeus.getAppApplication();
                        str2 = com.bytedance.pangle.c.d.a(com.bytedance.pangle.c.d.a());
                    }
                    String packageName = Zeus.getAppApplication() != null ? Zeus.getAppApplication().getPackageName() : "";
                    if (str2 == null) {
                        str2 = "unknown";
                    }
                    try {
                        jSONObject.putOpt(HiAnalyticsConstant.BI_KEY_NET_TYPE, com.bytedance.pangle.log.c.a(Integer.valueOf(com.bytedance.pangle.download.a.a(Zeus.getAppApplication()).f2239h)));
                        jSONObject.putOpt(ContentProviderManager.PLUGIN_PROCESS_NAME, com.bytedance.pangle.log.c.a(str2));
                        jSONObject.putOpt("host_package_name", packageName);
                        Plugin plugin = Zeus.getPlugin(jSONObject.optString("plugin_package_name", ""), false);
                        jSONObject.putOpt("plugin_api_version", com.bytedance.pangle.log.c.a(Integer.valueOf(plugin != null ? plugin.getApiVersionCode() : -1)));
                        jSONObject.putOpt("zeus_sdk_version", com.bytedance.pangle.log.c.a("0.0.1-beta.4200.87-pangle"));
                        ZeusLogger.v(ZeusLogger.TAG_REPORTER, "eventName: " + str + "\ncategoryData:" + jSONObject.toString(1) + "\nmetricData:" + jSONObject2.toString(1) + "\nlogExtrData:" + jSONObject3.toString(1));
                        IZeusReporter reporter = GlobalParam.getInstance().getReporter();
                        if (reporter != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                jSONObject4.putOpt(next, jSONObject.opt(next));
                            }
                            Iterator<String> keys2 = jSONObject2.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                jSONObject4.putOpt(next2, jSONObject2.opt(next2));
                            }
                            Iterator<String> keys3 = jSONObject3.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                jSONObject4.putOpt(next3, jSONObject3.opt(next3));
                            }
                            reporter.report(str, jSONObject4);
                        }
                        com.bytedance.pangle.log.a.a();
                        com.bytedance.pangle.log.a.b();
                    } catch (JSONException e2) {
                        ZeusLogger.w(ZeusLogger.TAG_REPORTER, e2.getMessage(), e2);
                    }
                }
            };
            synchronized (a.a) {
                a.a.add(aVar);
            }
            if (!globalParam.isCloseFlipped()) {
                b.a();
            }
            if (Build.VERSION.SDK_INT == 29) {
                com.bytedance.pangle.c.e.a.execute(new Runnable() { // from class: com.bytedance.pangle.g.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            MethodUtils.invokeStaticMethod(Class.forName("com.android.server.SystemConfig"), "getInstance", new Object[0]);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
            if (i.d()) {
                try {
                    FieldUtils.writeField(com.bytedance.pangle.c.a.a(), "mHiddenApiWarningShown", Boolean.TRUE);
                    ZeusLogger.w(ZeusLogger.TAG_INIT, "ZeusManager disableApiWarningShownForAndroidP, true");
                } catch (Exception e2) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INIT, "disableApiWarningShownForAndroidP failed", e2);
                }
            }
            b();
            ContentProviderManager.getInstance().initSystemContentProviderInfo();
            com.bytedance.pangle.receiver.b.a(application);
            this.a = true;
            a(ZeusPluginEventCallback.EVENT_FINISH_INITIALIZATION, 0, null, -1, null);
            return;
        }
        throw new IllegalArgumentException("context must be not null !!!");
    }

    public final void a(final int i2, final int i3, @Nullable final String str, final int i4, @Nullable final Throwable th) {
        Object[] c2;
        for (final Object obj : c()) {
            this.f2286e.post(new Runnable() { // from class: com.bytedance.pangle.g.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        ((ZeusPluginEventCallback) obj).onPluginEvent(i2, i3, str, i4, th);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
