package com.bytedance.pangle.plugin;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.PluginClassLoader;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusApplication;
import com.bytedance.pangle.ZeusConstants;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.c.e;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.f;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.h;
import com.bytedance.pangle.util.k;
import com.bytedance.pangle.util.m;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpush.common.Constants;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

@Keep
/* loaded from: classes.dex */
public class Plugin {
    public static final int LIFE_INSTALLED = 2;
    public static final int LIFE_LOADED = 3;
    public static final int LIFE_PENDING = 1;
    private static final String TAG = "Plugin";
    private int mApiVersionCode;
    public final String mAppKey;
    public final String mAppSecretKey;
    public ZeusApplication mApplication;
    public PluginClassLoader mClassLoader;
    public PluginApplicationWrapper mHostApplication;
    public ApplicationInfo mHostApplicationInfoHookSomeField;
    private volatile boolean mInitialized;
    private String mInternalPath;
    private int mInternalVersionCode;
    public boolean mIsSupportLibIso;
    public int mMaxVersionCode;
    public int mMinVersionCode;
    public final boolean mOpenLoadClassOpt;
    private String mPackageDir;
    public String mPkgName;
    public Resources mResources;
    public String mSignature;
    public final boolean mUnInstallPluginWhenHostChange;
    private int mVersionCode;
    public HashMap<String, ActivityInfo> pluginActivities = new HashMap<>();
    public HashMap<String, ServiceInfo> pluginServices = new HashMap<>();
    public HashMap<String, ActivityInfo> pluginReceiver = new HashMap<>();
    public HashMap<String, ProviderInfo> pluginProvider = new HashMap<>();
    private volatile int mLifeCycle = 1;
    public final Object installLock = new Object();
    public final Object initializeLock = new Object();

    public Plugin(JSONObject jSONObject) {
        this.mInternalVersionCode = -1;
        this.mMaxVersionCode = Integer.MAX_VALUE;
        this.mPkgName = jSONObject.getString(Constants.FLAG_PACKAGE_NAME);
        this.mMinVersionCode = jSONObject.optInt("minPluginVersion", 0);
        this.mMaxVersionCode = jSONObject.optInt("maxPluginVersion", Integer.MAX_VALUE);
        this.mApiVersionCode = jSONObject.getInt(TTLiveConstants.LIVE_API_VERSION_KEY);
        this.mSignature = jSONObject.optString("signature", "");
        this.mIsSupportLibIso = jSONObject.optBoolean("isSupportLibIsolate", false);
        this.mInternalPath = jSONObject.optString("internalPath", "");
        this.mInternalVersionCode = jSONObject.optInt("internalVersionCode", -1);
        this.mAppKey = jSONObject.optString(com.heytap.mcssdk.constant.b.z, "");
        this.mAppSecretKey = jSONObject.optString("appSecretKey", "");
        this.mOpenLoadClassOpt = jSONObject.optBoolean("loadClassOpt", false);
        this.mUnInstallPluginWhenHostChange = jSONObject.optBoolean("unInstallPluginWhenHostChange", false);
        setupInternalPlugin();
    }

    private boolean checkValid(File file, String str, int i2) {
        String format;
        StringBuilder sb;
        String sb2;
        StringBuilder sb3;
        String str2;
        if (TextUtils.equals(this.mPkgName, str)) {
            if (i2 < this.mMinVersionCode || i2 > this.mMaxVersionCode) {
                format = String.format(" pluginApk ver[%s] not match plugin VerRange[%s, %s].", Integer.valueOf(i2), Integer.valueOf(this.mMinVersionCode), Integer.valueOf(this.mMaxVersionCode));
                sb = new StringBuilder("Plugin checkValid ");
                sb.append(str);
                str = ExpandableTextView.N;
            } else if (i2 < this.mVersionCode && isInstalled()) {
                format = String.format(" pluginApk ver[%s] lower than installed plugin[%s].", Integer.valueOf(i2), Integer.valueOf(this.mVersionCode));
                sb = new StringBuilder("Plugin checkValid ");
            } else if (file == null || !file.exists()) {
                sb3 = new StringBuilder("Plugin checkValid ");
                sb3.append(str);
                str2 = " pluginApk not exist.";
            } else if (i2 != this.mVersionCode || !m.a().a.getString("MD5_".concat(String.valueOf(str)), "").equals(f.a(file))) {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin checkValid " + str + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + i2 + " true");
                return true;
            } else {
                sb3 = new StringBuilder("Plugin checkValid ");
                sb3.append(str);
                str2 = " pluginApk with the same md5 has already installed.";
            }
            sb.append(str);
            sb.append(format);
            sb2 = sb.toString();
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb2);
            return false;
        }
        sb3 = new StringBuilder("Plugin checkValid ");
        sb3.append(str);
        str2 = " package name not match !!!";
        sb3.append(str2);
        sb2 = sb3.toString();
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, sb2);
        return false;
    }

    private boolean checkVersionValid(int i2, int i3, boolean z) {
        int a = m.a().a(this.mPkgName);
        boolean z2 = false;
        if (a > i3) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid %s apiVersion downgrade , lastApiVersion=%s , currentApiVersion=%s", this.mPkgName, Integer.valueOf(a), Integer.valueOf(i3)))));
            return false;
        }
        boolean z3 = i2 >= 0 && i2 >= this.mMinVersionCode && i2 <= this.mMaxVersionCode;
        if (z3 && i3 != -1) {
            m a2 = m.a();
            String str = this.mPkgName;
            SharedPreferences sharedPreferences = a2.a;
            int i4 = sharedPreferences.getInt("API_MIN_" + str + "_" + i2, 0);
            m a3 = m.a();
            String str2 = this.mPkgName;
            SharedPreferences sharedPreferences2 = a3.a;
            int i5 = sharedPreferences2.getInt("API_MAX_" + str2 + "_" + i2, Integer.MAX_VALUE);
            int i6 = i5 != 0 ? i5 : Integer.MAX_VALUE;
            if (i3 < i4 || i3 > i6) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] is not compatible with api[ver_code=%s], apiCompatibleVer=[%s,%s]", this.mPkgName, Integer.valueOf(this.mVersionCode), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i6)))));
                z3 = false;
            }
        }
        if (z3 && z && com.bytedance.pangle.c.b.b(new File(com.bytedance.pangle.c.c.b(this.mPkgName, i2)))) {
            ZeusLogger.w(ZeusLogger.TAG_INIT, TAG.concat(String.valueOf(String.format(" checkVersionValid plugin[%s, ver=%s] not match hostAbi", this.mPkgName, Integer.valueOf(i2)))));
        } else {
            z2 = z3;
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin checkVersionValid, pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", valid=" + z2);
        return z2;
    }

    private void deleteIfNeeded() {
        if (com.bytedance.pangle.c.d.a(Zeus.getAppApplication()) && m.a().a.getBoolean("UNINSTALL__".concat(String.valueOf(this.mPkgName)), false)) {
            m a = m.a();
            String str = this.mPkgName;
            SharedPreferences.Editor edit = a.a.edit();
            edit.remove("UNINSTALL__".concat(String.valueOf(str)));
            edit.apply();
            deleteInstalledPlugin();
            ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteIfNeeded " + this.mPkgName);
        }
    }

    private void deleteInstalledPlugin() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.c.c.a(this.mPkgName);
        }
        new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.3
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                if (file.getName().matches("^version-(\\d+)$")) {
                    m.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1]), false);
                }
                return false;
            }
        });
        g.a(this.mPackageDir);
    }

    private void deleteOtherExpiredVer(int i2) {
        if (com.bytedance.pangle.c.d.a(Zeus.getAppApplication())) {
            if (TextUtils.isEmpty(this.mPackageDir)) {
                this.mPackageDir = com.bytedance.pangle.c.c.a(this.mPkgName);
            }
            final String concat = "version-".concat(String.valueOf(i2));
            new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.4
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    if (file != null && !concat.equals(file.getName()) && !"data".equals(file.getName())) {
                        g.a(file.getAbsolutePath());
                        ZeusLogger.w(ZeusLogger.TAG_INIT, "Plugin deleteOtherExpired " + file.getAbsolutePath());
                        if (file.getName().matches("^version-(\\d+)$")) {
                            m.a().a(Plugin.this.mPkgName, Integer.parseInt(file.getName().split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1]), false);
                        }
                    }
                    return false;
                }
            });
        }
    }

    private void installInternalPlugin() {
        if (!com.bytedance.pangle.c.d.a(Zeus.getAppApplication()) || getVersion() >= this.mInternalVersionCode || TextUtils.isEmpty(this.mInternalPath)) {
            return;
        }
        e.a.execute(new Runnable() { // from class: com.bytedance.pangle.plugin.Plugin.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    String b = com.bytedance.pangle.c.c.b();
                    File file = new File(b, Plugin.this.mPkgName + ".apk");
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin copyInternalPlugin " + Plugin.this.mInternalPath + " --> " + file.getAbsolutePath());
                    h.a(Zeus.getAppApplication().getAssets().open(Plugin.this.mInternalPath), new FileOutputStream(file));
                    if (file.exists()) {
                        PluginManager.getInstance().asyncInstall(Plugin.this.mPkgName, file);
                        return;
                    }
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + file.getAbsolutePath() + " is not exists.");
                } catch (Throwable th) {
                    ZeusLogger.w(ZeusLogger.TAG_INSTALL, "installInternalPlugin failed. " + th.getMessage());
                }
            }
        });
    }

    private int modifyResIfNeed(int i2) {
        String b = com.bytedance.pangle.util.b.b(Zeus.getAppApplication());
        if (TextUtils.isEmpty(b) || !TextUtils.equals(m.a().b(this.mPkgName), b)) {
            if (this.mUnInstallPluginWhenHostChange || GlobalParam.getInstance().unInstallPluginWhenHostChange(this.mPkgName)) {
                ZeusLogger.d(ZeusLogger.TAG_INIT, "uninstall plugin by host update. " + this.mPkgName + ExpandableTextView.N + i2);
                return 0;
            }
            ZeusLogger.d(ZeusLogger.TAG_INIT, "modifyRes by init. " + this.mPkgName + ExpandableTextView.N + i2);
            int a = new com.bytedance.pangle.res.a.c().a(new File(com.bytedance.pangle.c.c.b(this.mPkgName, i2)), true, new StringBuilder());
            if (a == 100 || a == 200) {
                return i2;
            }
            return 0;
        }
        return i2;
    }

    private void setupInternalPlugin() {
        String[] list;
        int a;
        if (m.a().a.getInt(String.format(Locale.getDefault(), "OFFLINE_INTERNAL_%s", this.mPkgName), -1) == this.mApiVersionCode) {
            return;
        }
        if (TextUtils.isEmpty(this.mInternalPath) || this.mInternalVersionCode == -1) {
            try {
                for (String str : Zeus.getAppApplication().getAssets().list(ZeusConstants.f2200d)) {
                    if (str.startsWith(this.mPkgName + "_") && (a = k.a(str.split("_")[1])) != -1) {
                        this.mInternalPath = ZeusConstants.f2200d + MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
                        this.mInternalVersionCode = a;
                        return;
                    }
                }
            } catch (IOException e2) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "setupInternalPlugin failed.", e2);
            }
        }
    }

    private void updateInstallStateFromMainProcess() {
        com.bytedance.pangle.c a;
        try {
            if (com.bytedance.pangle.c.d.a(Zeus.getAppApplication()) || this.mLifeCycle >= 2 || (a = com.bytedance.pangle.servermanager.b.a()) == null || !a.a(this.mPkgName)) {
                return;
            }
            updateToInstalled(a.b(this.mPkgName));
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder("updateInstallStateFromMainProcess error. process = ");
            Zeus.getAppApplication();
            sb.append(com.bytedance.pangle.c.d.a());
            ZeusLogger.w(ZeusLogger.TAG_PPM, sb.toString(), th);
        }
    }

    private void updateToInstalled(int i2) {
        this.mVersionCode = i2;
        this.mLifeCycle = 2;
    }

    public int getApiVersionCode() {
        return this.mApiVersionCode;
    }

    public int getInstalledMaxVer() {
        if (TextUtils.isEmpty(this.mPackageDir)) {
            this.mPackageDir = com.bytedance.pangle.c.c.a(this.mPkgName);
        }
        File[] listFiles = new File(this.mPackageDir).listFiles(new FileFilter() { // from class: com.bytedance.pangle.plugin.Plugin.2
            @Override // java.io.FileFilter
            public final boolean accept(File file) {
                return file != null && file.getName().matches("^version-(\\d+)$");
            }
        });
        int i2 = -1;
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                int parseInt = Integer.parseInt(file.getName().split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER)[1]);
                if (parseInt > i2 && m.a().a(this.mPkgName, parseInt) && new File(com.bytedance.pangle.c.c.b(this.mPkgName, parseInt)).exists()) {
                    i2 = parseInt;
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin getInstalledMaxVersion, pkg=" + this.mPkgName + ", maxVer=" + i2);
        return i2;
    }

    public int getInternalVersionCode() {
        return this.mInternalVersionCode;
    }

    public int getLifeCycle() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle;
    }

    public String getNativeLibraryDir() {
        int i2 = this.mVersionCode;
        return i2 > 0 ? com.bytedance.pangle.c.c.d(this.mPkgName, i2) : com.bytedance.pangle.c.c.a(this.mPkgName);
    }

    public int getVersion() {
        updateInstallStateFromMainProcess();
        return this.mVersionCode;
    }

    public void init() {
        boolean z;
        if (this.mInitialized) {
            return;
        }
        synchronized (this.initializeLock) {
            if (this.mInitialized) {
                return;
            }
            if (com.bytedance.pangle.c.d.a(Zeus.getAppApplication())) {
                int i2 = 0;
                if (!TextUtils.isEmpty(m.a().a.getString("HOST_ABI_".concat(String.valueOf(this.mPkgName)), ""))) {
                    m a = m.a();
                    String str = this.mPkgName;
                    z = !TextUtils.equals(a.a.getString("HOST_ABI_".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
                    ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + a.a.getString("HOST_ABI_".concat(String.valueOf(str)), "") + ", " + Zeus.getHostAbi() + ", result=" + z);
                } else {
                    z = false;
                }
                deleteIfNeeded();
                int installedMaxVer = getInstalledMaxVer();
                if (checkVersionValid(installedMaxVer, this.mApiVersionCode, z)) {
                    i2 = modifyResIfNeed(installedMaxVer);
                    updateToInstalled(i2);
                }
                deleteOtherExpiredVer(i2);
                ZeusLogger.i(ZeusLogger.TAG_INIT, "Plugin initPlugins result=".concat(String.valueOf(this)));
                m a2 = m.a();
                String str2 = this.mPkgName;
                SharedPreferences.Editor edit = a2.a.edit();
                edit.putString("ROM_LAST_".concat(String.valueOf(str2)), Build.VERSION.INCREMENTAL);
                edit.apply();
                m a3 = m.a();
                String str3 = this.mPkgName;
                String string = a3.a.getString("HOST_ABI_".concat(String.valueOf(str3)), "");
                SharedPreferences.Editor edit2 = a3.a.edit();
                edit2.putString("HOST_ABI_".concat(String.valueOf(str3)), Zeus.getHostAbi());
                edit2.apply();
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
                m a4 = m.a();
                String str4 = this.mPkgName;
                String b = com.bytedance.pangle.util.b.b(Zeus.getAppApplication());
                String b2 = a4.b(str4);
                if (!TextUtils.equals(b2, b)) {
                    SharedPreferences.Editor edit3 = a4.a.edit();
                    edit3.putString("HOST_IDENTITY_".concat(String.valueOf(str4)), b);
                    edit3.apply();
                }
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostIdentity(" + str4 + ") " + b2 + " --> " + b);
                m a5 = m.a();
                String str5 = this.mPkgName;
                int i3 = this.mApiVersionCode;
                int a6 = a5.a(str5);
                if (a6 != i3) {
                    SharedPreferences.Editor edit4 = a5.a.edit();
                    edit4.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str5)), i3);
                    edit4.apply();
                }
                ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + a6 + " --> " + i3);
            } else {
                updateInstallStateFromMainProcess();
            }
            this.mInitialized = true;
            installInternalPlugin();
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0156 -> B:30:0x0157). Please submit an issue!!! */
    public boolean install(File file, com.bytedance.pangle.f.a.e eVar) {
        boolean z;
        String str;
        String str2;
        boolean z2 = false;
        try {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin install from local file " + file + ", " + Thread.currentThread().getName());
            String str3 = eVar.a;
            int i2 = eVar.b;
            synchronized (this.installLock) {
                try {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin synchronized begin, plugin=".concat(String.valueOf(this)));
                    boolean checkValid = checkValid(file, str3, i2);
                    if (checkValid) {
                        z = b.a(file, str3, i2);
                        if (z) {
                            try {
                                String b = f.b(com.bytedance.pangle.c.c.b(this.mPkgName, i2));
                                m a = m.a();
                                String str4 = this.mPkgName;
                                SharedPreferences.Editor edit = a.a.edit();
                                edit.putString("MD5_".concat(String.valueOf(str4)), b);
                                edit.apply();
                                m.a().a(this.mPkgName, i2, true);
                                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin markPluginInstalled, " + this.mPkgName + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + i2 + " md5=" + b);
                                g.a(file);
                            } catch (Throwable th) {
                                th = th;
                                z2 = z;
                            }
                        }
                    } else {
                        z = false;
                    }
                    synchronized (this) {
                        if (!checkValid) {
                            g.a(file);
                            str = ZeusLogger.TAG_INSTALL;
                            str2 = "Plugin deleting invalid " + str3 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + i2;
                        } else if (this.mLifeCycle == 3) {
                            str = ZeusLogger.TAG_INSTALL;
                            str2 = "Plugin LIFE_LOADED, valid next restart " + str3 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + i2;
                        } else if (z) {
                            updateToInstalled(i2);
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALLED " + str3 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + i2);
                            ZeusPluginStateListener.postStateChange(this.mPkgName, 6, new Object[0]);
                        } else {
                            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "Plugin INSTALL_FAILED" + str3 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + i2);
                            ZeusPluginStateListener.postStateChange(this.mPkgName, 7, "Internal error.");
                            g.a(file);
                            str = ZeusLogger.TAG_INSTALL;
                            str2 = "Plugin delete file by failedCount > 0 " + str3 + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + i2;
                        }
                        ZeusLogger.w(str, str2);
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            throw th;
        } catch (Throwable th3) {
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "Plugin IMPOSSIBLE!!!", th3);
            return z2;
        }
    }

    public boolean isInstalled() {
        updateInstallStateFromMainProcess();
        return this.mLifeCycle >= 2;
    }

    public boolean isLoaded() {
        return this.mLifeCycle == 3;
    }

    public boolean isVersionInstalled(int i2) {
        return m.a().a(this.mPkgName, i2);
    }

    public void setApiCompatVersion(int i2, int i3, int i4) {
        m a = m.a();
        String str = this.mPkgName;
        SharedPreferences.Editor edit = a.a.edit();
        edit.putInt("API_MIN_" + str + "_" + i2, i3);
        edit.putInt("API_MAX_" + str + "_" + i2, i4);
        edit.apply();
    }

    public void setLifeCycle(int i2) {
        this.mLifeCycle = i2;
    }

    public String toString() {
        return "Plugin{pkg=" + this.mPkgName + ", ver=" + this.mVersionCode + ", life=" + this.mLifeCycle + '}';
    }
}
