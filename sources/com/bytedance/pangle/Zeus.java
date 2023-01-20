package com.bytedance.pangle;

import android.app.Application;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import java.util.HashMap;
import java.util.List;

@Keep
/* loaded from: classes.dex */
public class Zeus {
    private static Application sApplication;
    private static final HashMap<String, ProviderInfo> serverManagerHashMap = new HashMap<>();
    public static final Object wait = new Object();
    private static volatile boolean onPrivacyAgreed = false;

    public static void addExternalAssetsForPlugin(String str, String str2) {
        Plugin plugin;
        Resources resources;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (plugin = getPlugin(str)) == null || (resources = plugin.mResources) == null) {
            return;
        }
        new com.bytedance.pangle.res.a().a(resources.getAssets(), str2, false);
    }

    public static void addPluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        g a = g.a();
        if (zeusPluginEventCallback != null) {
            synchronized (a.f2285c) {
                a.f2285c.add(zeusPluginEventCallback);
            }
        }
    }

    public static void fetchPlugin(final String str) {
        com.bytedance.pangle.download.b a = com.bytedance.pangle.download.b.a();
        if (com.bytedance.pangle.c.d.a(getAppApplication())) {
            final com.bytedance.pangle.download.c a2 = com.bytedance.pangle.download.c.a();
            Runnable runnable = a2.f2241c.get(str);
            if (runnable != null) {
                a2.b.removeCallbacks(runnable);
            }
            Runnable runnable2 = new Runnable() { // from class: com.bytedance.pangle.download.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (com.bytedance.pangle.util.b.a(Zeus.getAppApplication())) {
                        c.this.b.postDelayed(this, 1800000L);
                    }
                }
            };
            a2.f2241c.put(str, runnable2);
            a2.b.postDelayed(runnable2, 1800000L);
            com.bytedance.pangle.download.c.a();
            if (a.a.contains(str)) {
                return;
            }
            a.a.add(str);
        }
    }

    public static Application getAppApplication() {
        if (sApplication == null) {
            b.a();
            try {
                sApplication = (Application) MethodUtils.invokeMethod(com.bytedance.pangle.c.a.a(), "getApplication", new Object[0]);
            } catch (Throwable unused) {
            }
        }
        return sApplication;
    }

    public static String getHostAbi() {
        return com.bytedance.pangle.c.b.a();
    }

    public static int getHostAbiBit() {
        return com.bytedance.pangle.c.b.b();
    }

    public static int getInstalledPluginVersion(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        if (plugin == null) {
            return -1;
        }
        int version = plugin.getVersion();
        ZeusLogger.d(ZeusLogger.TAG_DOWNLOAD, " getInstalledPluginVersion, " + str + " = " + version);
        return version;
    }

    public static int getMaxInstallVer(String str) {
        if (com.bytedance.pangle.c.d.a(getAppApplication())) {
            return getPlugin(str).getInstalledMaxVer();
        }
        return -1;
    }

    public static Plugin getPlugin(String str) {
        return getPlugin(str, true);
    }

    public static HashMap<String, ProviderInfo> getServerManagerHashMap() {
        return serverManagerHashMap;
    }

    public static String getZeusDid() {
        return com.bytedance.pangle.util.d.a();
    }

    public static boolean hasInit() {
        return g.a().a;
    }

    public static void init(Application application, boolean z) {
        g.a().a(application);
        Object obj = wait;
        synchronized (obj) {
            obj.notifyAll();
        }
    }

    public static void installFromDownloadDir() {
        if (com.bytedance.pangle.c.d.a(getAppApplication())) {
            PluginManager.getInstance().installFromDownloadDir();
        }
    }

    public static boolean isPluginInstalled(String str) {
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        return plugin != null && plugin.isInstalled();
    }

    public static boolean isPluginLoaded(String str) {
        return PluginManager.getInstance().isLoaded(str);
    }

    public static boolean loadPlugin(String str) {
        return PluginManager.getInstance().loadPlugin(str);
    }

    public static synchronized void onPrivacyAgreed() {
        synchronized (Zeus.class) {
        }
    }

    public static void registerPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        g.a().b.add(zeusPluginStateListener);
    }

    public static void removePluginEventCallback(ZeusPluginEventCallback zeusPluginEventCallback) {
        g a = g.a();
        if (zeusPluginEventCallback != null) {
            synchronized (a.f2285c) {
                a.f2285c.remove(zeusPluginEventCallback);
            }
        }
    }

    public static void setAllowDownloadPlugin(String str, int i2, boolean z) {
        PluginManager.getInstance().setAllowDownloadPlugin(str, i2, z);
    }

    public static void setAppContext(Application application) {
        if (application != null && TextUtils.equals(application.getClass().getSimpleName(), "PluginApplicationWrapper")) {
            try {
                sApplication = (Application) FieldUtils.readField(application, "mOriginApplication");
                return;
            } catch (Throwable unused) {
            }
        }
        sApplication = application;
    }

    public static boolean syncInstallPlugin(String str, String str2) {
        c a = com.bytedance.pangle.servermanager.b.a();
        if (a != null) {
            try {
                return a.a(str, str2);
            } catch (RemoteException e2) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "syncInstallPlugin error.", e2);
                return false;
            }
        }
        return false;
    }

    public static void unInstallPlugin(String str) {
        PluginManager.getInstance().unInstallPackage(str);
    }

    public static void unregisterPluginStateListener(ZeusPluginStateListener zeusPluginStateListener) {
        List<ZeusPluginStateListener> list = g.a().b;
        if (list != null) {
            list.remove(zeusPluginStateListener);
        }
    }

    public static boolean waitInit(int i2) {
        if (g.a().a) {
            return true;
        }
        Object obj = wait;
        synchronized (obj) {
            if (!g.a().a) {
                try {
                    if (i2 == -1) {
                        obj.wait();
                    } else {
                        obj.wait(i2);
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
        return g.a().a;
    }

    public static Plugin getPlugin(String str, boolean z) {
        if (!hasInit() && com.bytedance.pangle.util.b.a()) {
            throw new RuntimeException("Please init Zeus first!");
        }
        return PluginManager.getInstance().getPlugin(str, z);
    }
}
