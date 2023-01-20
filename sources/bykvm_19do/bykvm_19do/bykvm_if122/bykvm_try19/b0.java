package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class b0 {
    private static final CharSequence a = "amigo";
    private static final CharSequence b = "funtouch";

    /* renamed from: c  reason: collision with root package name */
    private static final ExecutorService f1010c = ThreadHelper.initSingleThreadExecutor("romutils", 2, new a());

    /* renamed from: d  reason: collision with root package name */
    public static boolean f1011d = false;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f1012e = false;

    /* loaded from: classes.dex */
    public static final class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Callable<String> {
        private final String a;

        public b(String str) {
            this.a = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            String b = b0.b(this.a);
            long currentTimeMillis2 = System.currentTimeMillis();
            Logger.d("RomUtils", "property:" + b + ",getSystemProperty use time :" + (currentTimeMillis2 - currentTimeMillis));
            if (!TextUtils.isEmpty(b)) {
                try {
                    Logger.w("RomUtils", "SP-getPropertyFromSP:" + b);
                    c0.a("rom_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).b("rom_property_info", b);
                } catch (Throwable unused) {
                }
            }
            return b;
        }
    }

    public static String a() {
        return c("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static String b() {
        return Build.DISPLAY + "_" + c("ro.gn.sv.version");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        BufferedReader bufferedReader;
        String str2 = "";
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                Process exec = runtime.exec("getprop " + str);
                bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
                try {
                    str2 = bufferedReader.readLine();
                    exec.destroy();
                    bufferedReader.close();
                } catch (Throwable th) {
                    th = th;
                    try {
                        Logger.e("ToolUtils", "Unable to read sysprop " + str, th);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return str2;
                    } catch (Throwable th2) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                Logger.e("ToolUtils", "Exception while closing InputStream", e2);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (IOException e3) {
            Logger.e("ToolUtils", "Exception while closing InputStream", e3);
        }
        return str2;
    }

    public static String c() {
        if (o()) {
            return "coloros_" + c("ro.build.version.opporom") + "_" + Build.DISPLAY;
        }
        return "";
    }

    private static String c(String str) {
        String str2;
        try {
            str2 = j();
            try {
                if (TextUtils.isEmpty(str2)) {
                    FutureTask futureTask = new FutureTask(new b(str));
                    f1010c.execute(futureTask);
                    str2 = (String) futureTask.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }

    public static String d() {
        String f2 = f();
        if (f2 == null || !f2.toLowerCase().contains("emotionui")) {
            return "";
        }
        return f2 + "_" + Build.DISPLAY;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = f();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || s();
    }

    public static String e() {
        if (p()) {
            return "eui_" + c("ro.letv.release.version") + "_" + Build.DISPLAY;
        }
        return "";
    }

    public static String f() {
        return c("ro.build.version.emui");
    }

    public static String g() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static String h() {
        return c("ro.vivo.os.build.display.id") + "_" + c("ro.vivo.product.version");
    }

    public static String i() {
        if (t()) {
            return "miui_" + c("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
        }
        return "";
    }

    private static String j() {
        try {
            String a2 = c0.a("rom_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).a("rom_property_info", "");
            Logger.i("RomUtils", "get Property From SP...=" + a2);
            return a2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String k() {
        if (u()) {
            return l();
        }
        if (t()) {
            return i();
        }
        if (q()) {
            return g();
        }
        if (o()) {
            return c();
        }
        String d2 = d();
        if (TextUtils.isEmpty(d2)) {
            if (r()) {
                return h();
            }
            if (n()) {
                return b();
            }
            if (m()) {
                return a();
            }
            String e2 = e();
            return TextUtils.isEmpty(e2) ? Build.DISPLAY : e2;
        }
        return d2;
    }

    public static String l() {
        if (u()) {
            try {
                String c2 = c("ro.smartisan.version");
                return "smartisan_" + c2;
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static boolean m() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
                return true;
            }
        }
        return false;
    }

    public static boolean n() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(a);
    }

    public static boolean o() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo");
    }

    public static boolean p() {
        return !TextUtils.isEmpty(c("ro.letv.release.version"));
    }

    public static boolean q() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static boolean r() {
        String c2 = c("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(c2) && c2.toLowerCase().contains(b);
    }

    public static boolean s() {
        String str;
        try {
            str = Build.BRAND;
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("huawei")) {
            String str2 = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str2)) {
                if (str2.toLowerCase().startsWith("huawei")) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean t() {
        if (!f1012e) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    f1011d = true;
                    f1012e = true;
                    return true;
                }
            } catch (Exception unused) {
            }
            f1012e = true;
        }
        return f1011d;
    }

    public static boolean u() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }
}
