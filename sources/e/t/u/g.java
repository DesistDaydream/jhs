package e.t.u;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.camera2.CameraManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StrictMode;
import android.provider.Settings;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import h.k2.v.f0;
import h.k2.v.n0;
import h.q0;
import java.io.File;
import java.util.Locale;
import java.util.Objects;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010-\u001a\u00020.J\u0010\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u000201H\u0007J\u0016\u00102\u001a\u00020.2\u0006\u00100\u001a\u0002012\u0006\u00103\u001a\u000204R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0013\u0010\t\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0015\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0017\u001a\u00020\u00128F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00128G¢\u0006\f\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\u001a\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0006R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b!\u0010\u000eR\u001a\u0010\"\u001a\u00020#8FX\u0087\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0002\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b(\u0010\u0006R\u0011\u0010)\u001a\u00020*8G¢\u0006\u0006\u001a\u0004\b+\u0010,¨\u00065"}, d2 = {"Lcom/vector/util/DeviceUtil;", "", "()V", "brand", "", "getBrand", "()Ljava/lang/String;", "cachePath", "getCachePath", "clipboardText", "getClipboardText", "dataDir", "Ljava/io/File;", "getDataDir", "()Ljava/io/File;", "externalPath", "getExternalPath", "isAirplaneModeOn", "", "()Z", "isOverAndroidQ", "isOverMarshmallow", "isSdcardEnable", "isSdcardMounted", "isWifi", "isWifi$annotations", "mobileType", "getMobileType", "runtimeMaxMemory", "", "getRuntimeMaxMemory", "()J", "sdcardDir", "getSdcardDir", com.heytap.mcssdk.constant.b.C, "", "getSdkVersion$annotations", "getSdkVersion", "()I", "systemVersion", "getSystemVersion", "wifiInfo", "Landroid/net/wifi/WifiInfo;", "getWifiInfo", "()Landroid/net/wifi/WifiInfo;", "closeStrictMode", "", "getAndroidId", "context", "Landroid/content/Context;", "setResLocale", NotifyType.LIGHTS, "Ljava/util/Locale;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class g {
    @k.e.a.d
    public static final g a = new g();

    private g() {
    }

    @h.i(level = DeprecationLevel.ERROR, message = "", replaceWith = @q0(expression = "Build.VERSION.SDK_INT", imports = {"android.os.Build"}))
    public static /* synthetic */ void l() {
    }

    public static /* synthetic */ void u() {
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 24) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            builder.detectFileUriExposure();
            StrictMode.setVmPolicy(builder.build());
        }
    }

    @SuppressLint({"HardwareIds"})
    @k.e.a.d
    public final String b(@k.e.a.d Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    @k.e.a.d
    public final String c() {
        return Build.BRAND;
    }

    @k.e.a.d
    public final String d() {
        File cacheDir;
        if (r()) {
            cacheDir = e.t.a.b().getExternalCacheDir();
        } else {
            cacheDir = e.t.a.b().getCacheDir();
        }
        if (cacheDir == null && (cacheDir = e.t.a.b().getCacheDir()) == null) {
            cacheDir = j();
        }
        return cacheDir.getPath();
    }

    @k.e.a.e
    public final String e() {
        ClipboardManager clipboardManager;
        ClipData.Item itemAt;
        CharSequence text;
        Context b = e.t.a.b();
        h.p2.d d2 = n0.d(ClipboardManager.class);
        if (f0.g(d2, n0.d(ConnectivityManager.class))) {
            Object systemService = b.getApplicationContext().getSystemService("connectivity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService;
        } else if (f0.g(d2, n0.d(ActivityManager.class))) {
            Object systemService2 = b.getApplicationContext().getSystemService("activity");
            Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService2;
        } else if (f0.g(d2, n0.d(WifiManager.class))) {
            Object systemService3 = b.getApplicationContext().getSystemService("wifi");
            Objects.requireNonNull(systemService3, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService3;
        } else if (f0.g(d2, n0.d(PowerManager.class))) {
            Object systemService4 = b.getApplicationContext().getSystemService("power");
            Objects.requireNonNull(systemService4, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService4;
        } else if (f0.g(d2, n0.d(NotificationManager.class))) {
            Object systemService5 = b.getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION);
            Objects.requireNonNull(systemService5, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService5;
        } else if (f0.g(d2, n0.d(ClipboardManager.class))) {
            Object systemService6 = b.getApplicationContext().getSystemService("clipboard");
            Objects.requireNonNull(systemService6, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService6;
        } else if (f0.g(d2, n0.d(WindowManager.class))) {
            Object systemService7 = b.getApplicationContext().getSystemService("window");
            Objects.requireNonNull(systemService7, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService7;
        } else if (f0.g(d2, n0.d(InputMethodManager.class))) {
            Object systemService8 = b.getApplicationContext().getSystemService("input_method");
            Objects.requireNonNull(systemService8, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService8;
        } else if (f0.g(d2, n0.d(LocationManager.class))) {
            Object systemService9 = b.getApplicationContext().getSystemService("location");
            Objects.requireNonNull(systemService9, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService9;
        } else if (!f0.g(d2, n0.d(CameraManager.class))) {
            throw new IllegalArgumentException("can not find class");
        } else {
            Object systemService10 = b.getApplicationContext().getSystemService("camera");
            Objects.requireNonNull(systemService10, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService10;
        }
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        if (primaryClip == null || (itemAt = primaryClip.getItemAt(0)) == null || (text = itemAt.getText()) == null) {
            return null;
        }
        return text.toString();
    }

    @k.e.a.d
    public final File f() {
        File dataDirectory = Environment.getDataDirectory();
        if (!dataDirectory.exists()) {
            dataDirectory.mkdirs();
        }
        return dataDirectory;
    }

    @k.e.a.d
    public final String g() {
        File cacheDir;
        if (r()) {
            if (p()) {
                cacheDir = e.t.a.b().getExternalCacheDir();
            } else if (r()) {
                cacheDir = Environment.getExternalStorageDirectory();
            } else {
                cacheDir = e.t.a.b().getCacheDir();
            }
        } else {
            cacheDir = e.t.a.b().getCacheDir();
        }
        if (cacheDir == null && (cacheDir = e.t.a.b().getCacheDir()) == null) {
            cacheDir = j();
        }
        return cacheDir.getPath();
    }

    @k.e.a.d
    public final String h() {
        return h.t2.u.k2(Build.MODEL, ExpandableTextView.N, "", false, 4, null);
    }

    public final long i() {
        return Runtime.getRuntime().maxMemory();
    }

    @k.e.a.d
    public final File j() {
        File externalCacheDir;
        if (Build.VERSION.SDK_INT < 29) {
            externalCacheDir = Environment.getExternalStorageDirectory();
        } else {
            externalCacheDir = e.t.a.b().getExternalCacheDir();
        }
        return externalCacheDir == null ? e.t.a.b().getCacheDir() : externalCacheDir;
    }

    public final int k() {
        return Build.VERSION.SDK_INT;
    }

    @k.e.a.d
    public final String m() {
        return Build.VERSION.RELEASE;
    }

    @SuppressLint({"MissingPermission"})
    @k.e.a.d
    public final WifiInfo n() {
        WifiManager wifiManager;
        Context b = e.t.a.b();
        h.p2.d d2 = n0.d(WifiManager.class);
        if (f0.g(d2, n0.d(ConnectivityManager.class))) {
            Object systemService = b.getApplicationContext().getSystemService("connectivity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            wifiManager = (WifiManager) systemService;
        } else if (f0.g(d2, n0.d(ActivityManager.class))) {
            Object systemService2 = b.getApplicationContext().getSystemService("activity");
            Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            wifiManager = (WifiManager) systemService2;
        } else if (f0.g(d2, n0.d(WifiManager.class))) {
            Object systemService3 = b.getApplicationContext().getSystemService("wifi");
            Objects.requireNonNull(systemService3, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            wifiManager = (WifiManager) systemService3;
        } else if (f0.g(d2, n0.d(PowerManager.class))) {
            Object systemService4 = b.getApplicationContext().getSystemService("power");
            Objects.requireNonNull(systemService4, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            wifiManager = (WifiManager) systemService4;
        } else if (f0.g(d2, n0.d(NotificationManager.class))) {
            Object systemService5 = b.getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION);
            Objects.requireNonNull(systemService5, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            wifiManager = (WifiManager) systemService5;
        } else if (f0.g(d2, n0.d(ClipboardManager.class))) {
            Object systemService6 = b.getApplicationContext().getSystemService("clipboard");
            Objects.requireNonNull(systemService6, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            wifiManager = (WifiManager) systemService6;
        } else if (f0.g(d2, n0.d(WindowManager.class))) {
            Object systemService7 = b.getApplicationContext().getSystemService("window");
            Objects.requireNonNull(systemService7, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            wifiManager = (WifiManager) systemService7;
        } else if (f0.g(d2, n0.d(InputMethodManager.class))) {
            Object systemService8 = b.getApplicationContext().getSystemService("input_method");
            Objects.requireNonNull(systemService8, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            wifiManager = (WifiManager) systemService8;
        } else if (f0.g(d2, n0.d(LocationManager.class))) {
            Object systemService9 = b.getApplicationContext().getSystemService("location");
            Objects.requireNonNull(systemService9, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            wifiManager = (WifiManager) systemService9;
        } else if (!f0.g(d2, n0.d(CameraManager.class))) {
            throw new IllegalArgumentException("can not find class");
        } else {
            Object systemService10 = b.getApplicationContext().getSystemService("camera");
            Objects.requireNonNull(systemService10, "null cannot be cast to non-null type android.net.wifi.WifiManager");
            wifiManager = (WifiManager) systemService10;
        }
        return wifiManager.getConnectionInfo();
    }

    public final boolean o() {
        return Settings.System.getInt(e.t.a.b().getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    public final boolean p() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public final boolean q() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public final boolean r() {
        return s() && !f0.g(Environment.getExternalStorageState(), "shared");
    }

    public final boolean s() {
        return f0.g(Environment.getExternalStorageState(), "mounted");
    }

    @SuppressLint({"MissingPermission"})
    public final boolean t() {
        ConnectivityManager connectivityManager;
        Context b = e.t.a.b();
        h.p2.d d2 = n0.d(ConnectivityManager.class);
        if (f0.g(d2, n0.d(ConnectivityManager.class))) {
            Object systemService = b.getApplicationContext().getSystemService("connectivity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService;
        } else if (f0.g(d2, n0.d(ActivityManager.class))) {
            Object systemService2 = b.getApplicationContext().getSystemService("activity");
            Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService2;
        } else if (f0.g(d2, n0.d(WifiManager.class))) {
            Object systemService3 = b.getApplicationContext().getSystemService("wifi");
            Objects.requireNonNull(systemService3, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService3;
        } else if (f0.g(d2, n0.d(PowerManager.class))) {
            Object systemService4 = b.getApplicationContext().getSystemService("power");
            Objects.requireNonNull(systemService4, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService4;
        } else if (f0.g(d2, n0.d(NotificationManager.class))) {
            Object systemService5 = b.getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION);
            Objects.requireNonNull(systemService5, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService5;
        } else if (f0.g(d2, n0.d(ClipboardManager.class))) {
            Object systemService6 = b.getApplicationContext().getSystemService("clipboard");
            Objects.requireNonNull(systemService6, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService6;
        } else if (f0.g(d2, n0.d(WindowManager.class))) {
            Object systemService7 = b.getApplicationContext().getSystemService("window");
            Objects.requireNonNull(systemService7, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService7;
        } else if (f0.g(d2, n0.d(InputMethodManager.class))) {
            Object systemService8 = b.getApplicationContext().getSystemService("input_method");
            Objects.requireNonNull(systemService8, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService8;
        } else if (f0.g(d2, n0.d(LocationManager.class))) {
            Object systemService9 = b.getApplicationContext().getSystemService("location");
            Objects.requireNonNull(systemService9, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService9;
        } else if (!f0.g(d2, n0.d(CameraManager.class))) {
            throw new IllegalArgumentException("can not find class");
        } else {
            Object systemService10 = b.getApplicationContext().getSystemService("camera");
            Objects.requireNonNull(systemService10, "null cannot be cast to non-null type android.net.ConnectivityManager");
            connectivityManager = (ConnectivityManager) systemService10;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    public final void v(@k.e.a.d Context context, @k.e.a.d Locale locale) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }
}
