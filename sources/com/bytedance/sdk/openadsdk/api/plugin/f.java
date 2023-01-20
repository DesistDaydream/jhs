package com.bytedance.sdk.openadsdk.api.plugin;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bp;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.IZeusLogger;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.sdk.openadsdk.TTAdEvent;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTPluginListener;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f {

    /* renamed from: d  reason: collision with root package name */
    private static volatile DexClassLoader f2431d;

    /* renamed from: f  reason: collision with root package name */
    private static volatile boolean f2433f;

    /* renamed from: l  reason: collision with root package name */
    private static volatile TTPluginListener f2434l;

    /* renamed from: j  reason: collision with root package name */
    private final Context f2438j;
    private static final String a = "next" + File.separator;
    private static final HashMap<String, TTPluginListener> b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<String, Handler> f2430c = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private static volatile f f2432e = null;

    /* renamed from: g  reason: collision with root package name */
    private final CountDownLatch f2435g = new CountDownLatch(1);

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f2436h = false;

    /* renamed from: i  reason: collision with root package name */
    private volatile String f2437i = "none";

    /* renamed from: k  reason: collision with root package name */
    private JSONObject f2439k = new JSONObject();

    /* loaded from: classes.dex */
    public static final class a implements IZeusLogger {
        private a() {
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void e(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.a.b(str, str2, th);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void i(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.a.c(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void v(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.a.a(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2) {
            com.bytedance.sdk.openadsdk.api.a.a(str, str2);
        }

        @Override // com.bytedance.pangle.log.IZeusLogger
        public void w(String str, String str2, Throwable th) {
            com.bytedance.sdk.openadsdk.api.a.a(str, str2, th);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements TTAdEvent {
        @Override // com.bytedance.sdk.openadsdk.TTAdEvent
        public void onEvent(int i2, Bundle bundle) {
            if (i2 == 1) {
                String string = bundle.getString("config");
                String string2 = bundle.getString("plugin_pkg_name");
                int i3 = bundle.getInt("code");
                if (i3 == 0) {
                    com.bytedance.sdk.openadsdk.api.plugin.b c2 = f.c(string);
                    if (c2 != null && !TextUtils.isEmpty(c2.mPackageName)) {
                        if (!bundle.getBoolean(bp.o)) {
                            f.c(c2.mPackageName, 1004);
                            return;
                        }
                        com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "plugin update received: " + c2.mPackageName);
                        if (!c2.isRevert()) {
                            if (f.b(c2)) {
                                bundle.putBoolean("installed", true);
                                return;
                            }
                            return;
                        }
                        Zeus.unInstallPlugin(c2.mPackageName);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "plugin update received with invalid config");
                    return;
                }
                f.c(string2, i3);
            }
        }
    }

    private f(Context context) {
        this.f2438j = context.getApplicationContext();
        d.a(context);
        b(context.getApplicationContext());
    }

    private static File c(Context context) {
        return new File(new File(context.getDir("tt_pangle_bykv_file", 0), "pangle_com.byted.pangle"), a);
    }

    public JSONObject b() {
        return this.f2439k;
    }

    private void b(Context context) {
        try {
            IZeusReporter iZeusReporter = new IZeusReporter() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.1
                @Override // com.bytedance.pangle.log.IZeusReporter
                public void report(String str, JSONObject jSONObject) {
                    if (str == "load_finish" && jSONObject != null && "com.byted.pangle".endsWith(jSONObject.optString("plugin_package_name"))) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("duration", jSONObject.opt("duration"));
                            jSONObject2.put("message", jSONObject.opt("message"));
                            f.this.f2439k.put("zeus", jSONObject2);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (f.f2433f) {
                        d.a(str, jSONObject);
                    } else {
                        d.c(str, jSONObject);
                    }
                }
            };
            GlobalParam globalParam = GlobalParam.getInstance();
            globalParam.setCloseDefaultReport(true);
            globalParam.setReporter(iZeusReporter);
            globalParam.setCheckPermission(false);
            globalParam.setDownloadDir(c(context));
            globalParam.setLogger(new a());
            Zeus.registerPluginStateListener(new ZeusPluginStateListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.2
                @Override // com.bytedance.pangle.ZeusPluginStateListener
                public void onPluginStateChange(final String str, final int i2, Object... objArr) {
                    com.bytedance.sdk.openadsdk.api.a.b("TTPluginManager", str + " state changed, " + i2);
                    if (i2 == 7) {
                        f.this.b(str, i2);
                    } else if (i2 == 6) {
                        com.bytedance.sdk.openadsdk.b.a.a().a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                f.this.b(str, i2);
                            }
                        });
                    }
                }
            });
            Zeus.init((Application) context, true);
            this.f2436h = true;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.a.a("TTPluginManager", "Unexpected error for init zeus.", th);
            this.f2437i = th.getMessage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.api.plugin.b c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(new JSONObject(str));
        } catch (JSONException unused) {
            com.bytedance.sdk.openadsdk.api.a.e("TTPluginManager", "Invalid plugin info:" + str);
            return null;
        }
    }

    public static f a(Context context) {
        if (f2432e == null) {
            synchronized (f.class) {
                if (f2432e == null) {
                    f2432e = new f(context);
                }
            }
        }
        return f2432e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str, int i2) {
        com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "plugin update failed");
        Bundle bundle = new Bundle();
        bundle.putInt("code", i2);
        TTPluginListener tTPluginListener = b.get(str);
        if (tTPluginListener != null) {
            tTPluginListener.onPluginListener(1001, null, null, bundle);
        }
    }

    public void a() {
        f2433f = true;
        d.a(new ArrayList());
    }

    public DexClassLoader a(e eVar) throws Exception {
        if (this.f2436h) {
            if (!Zeus.isPluginInstalled("com.byted.pangle")) {
                try {
                    this.f2435g.await(com.heytap.mcssdk.constant.a.f3314d, TimeUnit.MILLISECONDS);
                    eVar.b("wait_install_cost");
                } catch (Exception unused) {
                    com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "Install wait time out");
                    throw new c(8, "install wait timeout");
                }
            }
            boolean z = false;
            if (Zeus.isPluginLoaded("com.byted.pangle") || Zeus.loadPlugin("com.byted.pangle")) {
                f2431d = Zeus.getPlugin("com.byted.pangle").mClassLoader;
                z = true;
            }
            eVar.b("get_classloader_cost");
            Zeus.installFromDownloadDir();
            if (f2431d == null) {
                if (this.f2435g.getCount() != 0) {
                    com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "Install wait time out");
                    throw new c(8, "install wait timeout");
                } else if (z) {
                    com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "Get null after load");
                    throw new c(9, "Get null after load");
                }
            }
            eVar.b("get_classloader_done");
            return f2431d;
        }
        com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "Zeus init failed.");
        throw new c(4, this.f2437i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i2) {
        if ("com.byted.pangle".equals(str) && i2 == 6) {
            this.f2435g.countDown();
        }
        a(i2 == 6, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(com.bytedance.sdk.openadsdk.api.plugin.b bVar) {
        File file;
        if (bVar != null && (file = bVar.b) != null) {
            boolean syncInstallPlugin = Zeus.syncInstallPlugin(bVar.mPackageName, file.getAbsolutePath());
            a(syncInstallPlugin, bVar.mPackageName);
            return syncInstallPlugin;
        }
        com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "plugin config is null");
        return false;
    }

    public Bundle a(String str, Bundle bundle) {
        String a2 = a(str);
        if (!TextUtils.isEmpty(a2)) {
            bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, a2);
        }
        g.a(str, bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(str, bundle);
        Bundle bundle3 = new Bundle();
        bundle3.putBundle(PluginConstants.KEY_PL_CONFIG_INFO, bundle2);
        return bundle3;
    }

    public static String a(String str) {
        Plugin plugin;
        try {
            if (!Zeus.isPluginInstalled(str) || (plugin = Zeus.getPlugin(str)) == null) {
                return null;
            }
            return a(plugin.getVersion());
        } catch (Throwable unused) {
            com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "Get local version failed");
            return null;
        }
    }

    public void a(final TTPluginListener tTPluginListener) {
        if (!this.f2436h) {
            com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "Zeus init failed.");
            if (tTPluginListener != null) {
                tTPluginListener.onPluginListener(1002, null, null, null);
                return;
            }
            return;
        }
        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.plugin.f.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.api.a.b("TTPluginManager", "Load plugin failed, caused by timeout.");
                tTPluginListener.onPluginListener(1001, null, null, null);
            }
        }, 180000L);
        String packageName = tTPluginListener.packageName();
        Plugin plugin = (Zeus.isPluginInstalled(packageName) && (Zeus.isPluginLoaded(packageName) || Zeus.loadPlugin(packageName))) ? Zeus.getPlugin(packageName) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("Find plugin:");
        sb.append(plugin != null);
        com.bytedance.sdk.openadsdk.api.a.b("TTPluginManager", sb.toString());
        if (plugin != null) {
            a(plugin);
            handler.removeCallbacksAndMessages(null);
            tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
            return;
        }
        b.put(packageName, tTPluginListener);
        f2430c.put(packageName, handler);
    }

    private static com.bytedance.sdk.openadsdk.api.plugin.b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.api.plugin.b bVar = new com.bytedance.sdk.openadsdk.api.plugin.b();
        bVar.mPackageName = jSONObject.optString("package_name");
        bVar.mVersionCode = jSONObject.optInt("version_code");
        bVar.mUrl = jSONObject.optString("download_url");
        bVar.mMd5 = jSONObject.optString("md5");
        bVar.mApiVersionMin = jSONObject.optInt("min_version");
        bVar.mApiVersionMax = jSONObject.optInt("max_version");
        bVar.a = jSONObject.optString("sign");
        bVar.mFlag = jSONObject.optBoolean("is_revert") ? 3 : 2;
        bVar.b = new File(jSONObject.optString("plugin_file"));
        return bVar;
    }

    private static void a(Plugin plugin) {
        if (plugin == null) {
            com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "plugin is null.");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("action", 0);
        bundle.putString("plugin_pkg_name", plugin.mPkgName);
        bundle.putString(PluginConstants.KEY_PLUGIN_VERSION, a(plugin.getVersion()));
        TTAdManager adManager = TTAdSdk.getAdManager();
        if (adManager != null) {
            adManager.getExtra(Bundle.class, bundle);
        }
    }

    public static String a(int i2) {
        char[] charArray = String.valueOf(i2).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            sb.append(charArray[i3]);
            if (i3 < charArray.length - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    private static boolean a(TTPluginListener tTPluginListener, String str) {
        if (tTPluginListener == null || tTPluginListener.packageName() == null) {
            return false;
        }
        return tTPluginListener.packageName().equals(str);
    }

    private static void a(boolean z, String str) {
        HashMap<String, TTPluginListener> hashMap = b;
        TTPluginListener tTPluginListener = hashMap.get(str);
        StringBuilder sb = new StringBuilder();
        sb.append("Install dl plugin ");
        sb.append(str);
        sb.append(z ? " success" : " failed");
        sb.append(", need notify: ");
        sb.append(tTPluginListener != null);
        com.bytedance.sdk.openadsdk.api.a.b("TTPluginManager", sb.toString());
        HashMap<String, Handler> hashMap2 = f2430c;
        Handler handler = hashMap2.get(str);
        if (z) {
            TTPluginListener tTPluginListener2 = f2434l;
            if (!a(tTPluginListener2, str) && (tTPluginListener == null || handler == null)) {
                return;
            }
            if (Zeus.loadPlugin(str)) {
                Plugin plugin = Zeus.getPlugin(str);
                a(plugin);
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                if (tTPluginListener != null) {
                    tTPluginListener.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                }
                if (a(tTPluginListener2, str)) {
                    tTPluginListener2.onPluginListener(1000, plugin.mClassLoader, plugin.mResources, null);
                    f2434l = null;
                }
            } else {
                c(str, 1002);
            }
        } else {
            c(str, 1003);
        }
        hashMap.remove(str);
        hashMap2.remove(str);
    }

    public static void a(Throwable th) {
        if (th instanceof AbstractMethodError) {
            Zeus.unInstallPlugin("com.byted.pangle");
            com.bytedance.sdk.openadsdk.api.a.d("TTPluginManager", "AbstractMethodError, rollback to builtin version.");
        }
    }
}
