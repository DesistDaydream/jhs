package com.tencent.tpns.dataacquisition.a;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.m7.imkfsdk.utils.permission.PermissionConstants;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import com.umeng.analytics.pro.am;
import com.xiaomi.mipush.sdk.Constants;
import h.u2.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {
    private static String a = null;
    private static final String[] b = {"com.mumu.launcher", "com.ami.duosupdater.ui", "com.ami.launchmetro", "com.ami.syncduosservices", "com.bluestacks.home", "com.bluestacks.windowsfilemanager", "com.bluestacks.settings", "com.bluestacks.bluestackslocationprovider", "com.bluestacks.appsettings", "com.bluestacks.bstfolder", "com.bluestacks.BstCommandProcessor", "com.bluestacks.s2p", "com.bluestacks.setup", "com.bluestacks.appmart", "com.kaopu001.tiantianserver", "com.kpzs.helpercenter", "com.kaopu001.tiantianime", "com.android.development_settings", "com.android.development", "com.android.customlocale2", "com.genymotion.superuser", "com.genymotion.clipboardproxy", "com.uc.xxzs.keyboard", "com.uc.xxzs", "com.blue.huang17.agent", "com.blue.huang17.launcher", "com.blue.huang17.ime", "com.microvirt.guide", "com.microvirt.market", "com.microvirt.memuime", "cn.itools.vm.launcher", "cn.itools.vm.proxy", "cn.itools.vm.softkeyboard", "cn.itools.avdmarket", "com.syd.IME", "com.bignox.app.store.hd", "com.bignox.launcher", "com.bignox.app.phone", "com.bignox.app.noxservice", "com.android.noxpush", "com.haimawan.push", "me.haima.helpcenter", "com.windroy.launcher", "com.windroy.superuser", "com.windroy.launcher", "com.windroy.ime", "com.android.flysilkworm", "com.android.emu.inputservice", "com.tiantian.ime", "com.microvirt.launcher", "me.le8.androidassist", "com.vphone.helper", "com.vphone.launcher", "com.duoyi.giftcenter.giftcenter"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f6911c = {"/data/data/com.android.flysilkworm", "/data/data/com.bluestacks.filemanager"};

    /* renamed from: d  reason: collision with root package name */
    private static DisplayMetrics f6912d = null;

    /* renamed from: e  reason: collision with root package name */
    private static int f6913e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static Boolean f6914f = null;

    /* renamed from: g  reason: collision with root package name */
    private static String f6915g = null;

    /* renamed from: h  reason: collision with root package name */
    private static long f6916h = -1;

    /* renamed from: i  reason: collision with root package name */
    private static C0272a f6917i;

    /* renamed from: com.tencent.tpns.dataacquisition.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0272a {

        /* renamed from: com.tencent.tpns.dataacquisition.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0273a implements FileFilter {
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return Pattern.matches("cpu[0-9]", file.getName());
            }
        }

        public static int a() {
            try {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new C0273a());
                if (listFiles != null) {
                    return listFiles.length;
                }
                return 1;
            } catch (Throwable th) {
                th.printStackTrace();
                return 1;
            }
        }

        public static int b() {
            StringBuilder sb;
            byte[] bArr;
            InputStream inputStream = null;
            try {
                String str = "";
                inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
                while (inputStream.read(new byte[24]) != -1) {
                    str = str + new String(bArr);
                }
                String trim = str.trim();
                r1 = trim.length() > 0 ? Integer.valueOf(trim).intValue() : 0;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        sb = new StringBuilder();
                        sb.append("unexpected for:");
                        sb.append(th.getMessage());
                        com.tencent.tpns.dataacquisition.b.a.a(sb.toString());
                        return r1 * 1000;
                    }
                }
            } catch (Throwable th2) {
                try {
                    com.tencent.tpns.dataacquisition.b.a.a("getMaxCpuFreq err", th2);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th3) {
                            th = th3;
                            sb = new StringBuilder();
                            sb.append("unexpected for:");
                            sb.append(th.getMessage());
                            com.tencent.tpns.dataacquisition.b.a.a(sb.toString());
                            return r1 * 1000;
                        }
                    }
                } catch (Throwable th4) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th5) {
                            com.tencent.tpns.dataacquisition.b.a.a("unexpected for:" + th5.getMessage());
                        }
                    }
                    throw th4;
                }
            }
            return r1 * 1000;
        }

        public static int c() {
            StringBuilder sb;
            byte[] bArr;
            InputStream inputStream = null;
            try {
                try {
                    String str = "";
                    inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
                    while (inputStream.read(new byte[24]) != -1) {
                        str = str + new String(bArr, "UTF-8");
                    }
                    String trim = str.trim();
                    r1 = trim.length() > 0 ? Integer.valueOf(trim).intValue() : 0;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th) {
                            th = th;
                            sb = new StringBuilder();
                            sb.append("unexpected for: ");
                            sb.append(th.getMessage());
                            com.tencent.tpns.dataacquisition.b.a.a(sb.toString());
                            return r1 * 1000;
                        }
                    }
                } catch (Throwable th2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th3) {
                            com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + th3.getMessage());
                        }
                    }
                    throw th2;
                }
            } catch (IOException e2) {
                com.tencent.tpns.dataacquisition.b.a.a("getMinCpuFreq", e2);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th4) {
                        th = th4;
                        sb = new StringBuilder();
                        sb.append("unexpected for: ");
                        sb.append(th.getMessage());
                        com.tencent.tpns.dataacquisition.b.a.a(sb.toString());
                        return r1 * 1000;
                    }
                }
            }
            return r1 * 1000;
        }

        public static String d() {
            BufferedReader bufferedReader;
            Throwable th;
            StringBuilder sb;
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            } catch (Throwable th2) {
                bufferedReader = null;
                th = th2;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    String[] split = readLine.split(":\\s+", 2);
                    if (split.length > 0) {
                        String str = split[1];
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + th3.getMessage());
                        }
                        return str;
                    }
                }
                try {
                    bufferedReader.close();
                    return "";
                } catch (Throwable th4) {
                    th = th4;
                    sb = new StringBuilder();
                    sb.append("unexpected for: ");
                    sb.append(th.getMessage());
                    com.tencent.tpns.dataacquisition.b.a.a(sb.toString());
                    return "";
                }
            } catch (Throwable th5) {
                th = th5;
                try {
                    com.tencent.tpns.dataacquisition.b.a.a("getCpuName", th);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            return "";
                        } catch (Throwable th6) {
                            th = th6;
                            sb = new StringBuilder();
                            sb.append("unexpected for: ");
                            sb.append(th.getMessage());
                            com.tencent.tpns.dataacquisition.b.a.a(sb.toString());
                            return "";
                        }
                    }
                    return "";
                } catch (Throwable th7) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th8) {
                            com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + th8.getMessage());
                        }
                    }
                    throw th7;
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
            r1 = r2[1];
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.String e() {
            /*
                java.lang.String r0 = "unexpected for br.close"
                java.lang.String r1 = ""
                r2 = 0
                java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L40
                java.lang.String r4 = "/proc/cpuinfo"
                r3.<init>(r4)     // Catch: java.lang.Throwable -> L40
                java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L40
                r4.<init>(r3)     // Catch: java.lang.Throwable -> L40
            L11:
                java.lang.String r2 = r4.readLine()     // Catch: java.lang.Throwable -> L3e
                if (r2 == 0) goto L36
                java.lang.String r3 = ":\\s+"
                r5 = 2
                java.lang.String[] r2 = r2.split(r3, r5)     // Catch: java.lang.Throwable -> L3e
                if (r2 == 0) goto L11
                r3 = 0
                r3 = r2[r3]     // Catch: java.lang.Throwable -> L3e
                java.lang.String r3 = r3.trim()     // Catch: java.lang.Throwable -> L3e
                java.lang.String r3 = r3.toLowerCase()     // Catch: java.lang.Throwable -> L3e
                java.lang.String r5 = "hardware"
                boolean r3 = r3.startsWith(r5)     // Catch: java.lang.Throwable -> L3e
                if (r3 == 0) goto L11
                r3 = 1
                r1 = r2[r3]     // Catch: java.lang.Throwable -> L3e
            L36:
                r4.close()     // Catch: java.lang.Throwable -> L3a
                goto L4b
            L3a:
                com.tencent.tpns.dataacquisition.b.a.a(r0)
                goto L4b
            L3e:
                r2 = move-exception
                goto L43
            L40:
                r3 = move-exception
                r4 = r2
                r2 = r3
            L43:
                java.lang.String r3 = "getCpuManufacturer"
                com.tencent.tpns.dataacquisition.b.a.a(r3, r2)     // Catch: java.lang.Throwable -> L4c
                if (r4 == 0) goto L4b
                goto L36
            L4b:
                return r1
            L4c:
                r1 = move-exception
                if (r4 == 0) goto L56
                r4.close()     // Catch: java.lang.Throwable -> L53
                goto L56
            L53:
                com.tencent.tpns.dataacquisition.b.a.a(r0)
            L56:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.dataacquisition.a.a.C0272a.e():java.lang.String");
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        private static int a = -1;

        public static boolean a() {
            int i2 = a;
            if (i2 == 1) {
                return true;
            }
            if (i2 == 0) {
                return false;
            }
            String[] strArr = {"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
            for (int i3 = 0; i3 < 6; i3++) {
                try {
                    if (new File(strArr[i3] + "su").exists()) {
                        a = 1;
                        return true;
                    }
                } catch (Throwable th) {
                    com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + th.getMessage());
                }
            }
            a = 0;
            return false;
        }
    }

    public static Integer a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return Integer.valueOf(telephonyManager.getNetworkType());
            }
            return null;
        } catch (Throwable unused) {
            com.tencent.tpns.dataacquisition.b.a.a("unexpected for getTelephonyNetworkType");
            return null;
        }
    }

    public static synchronized String a() {
        String str;
        synchronized (a.class) {
            if (a == null) {
                a = Build.MODEL;
            }
            if (a == null) {
                a = "";
            }
            str = a;
        }
        return str;
    }

    private static String a(List<String> list) {
        if (list.size() == 0) {
            return "unknown";
        }
        String str = list.get(0);
        return str.contains("mumu") ? "mumu" : str.contains("ami") ? "AMIDuOS" : str.contains("bluestacks") ? "蓝叠" : (str.contains("kaopu001") || str.contains("tiantian")) ? "天天" : str.contains("kpzs") ? "靠谱助手" : str.contains("genymotion") ? DeviceInfos.getDM().contains("iTools") ? "iTools" : DeviceInfos.getDM().contains("ChangWan") ? "畅玩" : "genymotion" : str.contains("uc") ? "uc" : str.contains("blue") ? "blue" : str.contains("microvirt") ? "逍遥" : str.contains("itools") ? "itools" : str.contains("syd") ? "手游岛" : str.contains("bignox") ? "夜神" : str.contains("haimawan") ? "海马玩" : str.contains("windroy") ? "windroy" : str.contains("flysilkworm") ? "雷电" : str.contains("emu") ? "emu" : str.contains("le8") ? "le8" : str.contains("vphone") ? "vphone" : str.contains("duoyi") ? "多益" : Build.MANUFACTURER.toLowerCase().contains("google") ? "Google" : "unknown";
    }

    public static boolean b() {
        try {
            String str = Build.CPU_ABI;
            if (TextUtils.isEmpty(str) || str.toLowerCase().contains("x86")) {
                return false;
            }
            return !str.toLowerCase().contains("amd");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        try {
            if (!com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                com.tencent.tpns.dataacquisition.b.a.a("Network error");
                return false;
            }
            return true;
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("isNetworkAvailable error", th);
            return false;
        }
    }

    public static byte c(Context context) {
        if (context != null) {
            try {
                if (com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        return (byte) 0;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                        if (activeNetworkInfo.getType() == 1) {
                            return (byte) 1;
                        }
                        if (activeNetworkInfo.getType() == 0) {
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                    return (byte) 2;
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 15:
                                    return (byte) 3;
                                case 12:
                                case 14:
                                default:
                                    return (byte) 0;
                                case 13:
                                    return (byte) 4;
                            }
                        }
                        return (byte) 0;
                    }
                    return (byte) -1;
                }
            } catch (Throwable th) {
                com.tencent.tpns.dataacquisition.b.a.a("getNetworkType: ", th);
            }
        }
        return (byte) -1;
    }

    public static String c() {
        RandomAccessFile randomAccessFile;
        Throwable th;
        StringBuilder sb;
        byte[] bArr;
        if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
            return "Intel";
        }
        String str = "";
        try {
            bArr = new byte[1024];
            randomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
        } catch (Throwable th2) {
            randomAccessFile = null;
            th = th2;
        }
        try {
        } catch (Throwable th3) {
            th = th3;
            try {
                com.tencent.tpns.dataacquisition.b.a.a("getCpuString", th);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th4) {
                        th = th4;
                        sb = new StringBuilder();
                        sb.append("unexpected for: ");
                        sb.append(th.getMessage());
                        com.tencent.tpns.dataacquisition.b.a.a(sb.toString());
                        return str;
                    }
                }
                return str;
            } catch (Throwable th5) {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th6) {
                        com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + th6.getMessage());
                    }
                }
                throw th5;
            }
        }
        if (randomAccessFile.read(bArr) < 0) {
            try {
                randomAccessFile.close();
            } catch (Throwable th7) {
                com.tencent.tpns.dataacquisition.b.a.a("unexpected for: " + th7.getMessage());
            }
            return "";
        }
        String str2 = new String(bArr);
        int indexOf = str2.indexOf(0);
        str = indexOf != -1 ? str2.substring(0, indexOf) : str2;
        try {
            randomAccessFile.close();
        } catch (Throwable th8) {
            th = th8;
            sb = new StringBuilder();
            sb.append("unexpected for: ");
            sb.append(th.getMessage());
            com.tencent.tpns.dataacquisition.b.a.a(sb.toString());
            return str;
        }
        return str;
    }

    public static String d() {
        String str;
        StringBuilder sb;
        String str2;
        String c2 = c();
        if (c2.contains("ARMv5")) {
            str = "armv5";
        } else if (c2.contains("ARMv6")) {
            str = "armv6";
        } else if (c2.contains("ARMv7")) {
            str = "armv7";
        } else if (!c2.contains("Intel")) {
            return "unknown";
        } else {
            str = "x86";
        }
        if (c2.contains("neon")) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_neon";
        } else if (c2.contains("vfpv3")) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_vfpv3";
        } else if (c2.contains(" vfp")) {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_vfp";
        } else {
            sb = new StringBuilder();
            sb.append(str);
            str2 = "_none";
        }
        sb.append(str2);
        return sb.toString();
    }

    public static boolean d(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            if (com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.ACCESS_NETWORK_STATE") && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                return "WIFI".equalsIgnoreCase(activeNetworkInfo.getTypeName());
            }
            return false;
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("Check isWiFiActive error", th);
            return false;
        }
    }

    public static String e() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return String.valueOf((statFs.getBlockSize() * statFs.getAvailableBlocks()) / 1000000) + MqttTopic.TOPIC_LEVEL_SEPARATOR + String.valueOf(f() / 1000000);
    }

    public static String e(Context context) {
        String str = null;
        try {
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.b(th);
        }
        if (com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.INTERNET") && com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                String typeName = activeNetworkInfo.getTypeName();
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (typeName != null) {
                    if (!"WIFI".equalsIgnoreCase(typeName)) {
                        if ("MOBILE".equalsIgnoreCase(typeName)) {
                            str = extraInfo != null ? extraInfo : "MOBILE";
                        } else {
                            if (extraInfo == null) {
                                str = typeName;
                            }
                        }
                        com.tencent.tpns.dataacquisition.b.a.b(th);
                        return str;
                    }
                    str = "WIFI";
                }
            }
        } else {
            com.tencent.tpns.dataacquisition.b.a.b("can not get the permission of android.permission.ACCESS_WIFI_STATE");
        }
        return str;
    }

    public static long f() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCount() * statFs.getBlockSize();
    }

    public static DisplayMetrics f(Context context) {
        if (f6912d == null) {
            f6912d = new DisplayMetrics();
            Display defaultDisplay = ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay();
            if (defaultDisplay != null) {
                defaultDisplay.getMetrics(f6912d);
            }
        }
        return f6912d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005b, code lost:
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long g() {
        /*
            long r0 = com.tencent.tpns.dataacquisition.a.a.f6916h
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L9
            return r0
        L9:
            java.lang.String r0 = "/proc/meminfo"
            r1 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3f
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3f
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3f
            r5 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r4, r5)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L3f
            java.lang.String r1 = r0.readLine()     // Catch: java.io.IOException -> L38 java.lang.Throwable -> L61
            if (r1 == 0) goto L34
            java.lang.String r4 = "\\s+"
            java.lang.String[] r1 = r1.split(r4)     // Catch: java.io.IOException -> L38 java.lang.Throwable -> L61
            r4 = 1
            r1 = r1[r4]     // Catch: java.io.IOException -> L38 java.lang.Throwable -> L61
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.io.IOException -> L38 java.lang.Throwable -> L61
            int r1 = r1.intValue()     // Catch: java.io.IOException -> L38 java.lang.Throwable -> L61
            long r1 = (long) r1
            r3 = 1024(0x400, double:5.06E-321)
            long r2 = r1 * r3
        L34:
            r0.close()     // Catch: java.lang.Throwable -> L5e
            goto L5e
        L38:
            r1 = move-exception
            goto L43
        L3a:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L62
        L3f:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L43:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61
            r4.<init>()     // Catch: java.lang.Throwable -> L61
            java.lang.String r5 = "unexpected for: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L61
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L61
            r4.append(r1)     // Catch: java.lang.Throwable -> L61
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L61
            com.tencent.tpns.dataacquisition.b.a.a(r1)     // Catch: java.lang.Throwable -> L61
            if (r0 == 0) goto L5e
            goto L34
        L5e:
            com.tencent.tpns.dataacquisition.a.a.f6916h = r2
            return r2
        L61:
            r1 = move-exception
        L62:
            if (r0 == 0) goto L67
            r0.close()     // Catch: java.lang.Throwable -> L67
        L67:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.dataacquisition.a.a.g():long");
    }

    public static boolean g(Context context) {
        return ((SensorManager) context.getSystemService(am.ac)) != null;
    }

    public static int h(Context context) {
        int i2 = f6913e;
        if (i2 >= 0) {
            return i2;
        }
        try {
            return b.a() ? 1 : 0;
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("call hasRootAccess Error:", th);
            return 0;
        }
    }

    public static boolean h() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("isSDCardMounted", th);
            return false;
        }
    }

    public static String i() {
        try {
            NumberFormat numberFormat = NumberFormat.getInstance();
            numberFormat.setGroupingUsed(false);
            return numberFormat.format((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000.0d);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String i(Context context) {
        String path;
        try {
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("getExternalStorageInfo err:", th);
        }
        if (!com.tencent.tpns.dataacquisition.b.a.a(context, PermissionConstants.STORE)) {
            com.tencent.tpns.dataacquisition.b.a.a("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        }
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState != null && externalStorageState.equals("mounted") && (path = Environment.getExternalStorageDirectory().getPath()) != null) {
            StatFs statFs = new StatFs(path);
            return String.valueOf((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1000000) + MqttTopic.TOPIC_LEVEL_SEPARATOR + String.valueOf((statFs.getBlockCount() * statFs.getBlockSize()) / 1000000);
        }
        return null;
    }

    public static int j(Context context) {
        if (com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.BLUETOOTH")) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                return -1;
            }
            return defaultAdapter.isEnabled() ? 1 : 0;
        }
        return 0;
    }

    public static String j() {
        return "";
    }

    public static boolean k(Context context) {
        if (com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.BLUETOOTH")) {
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter == null) {
                    return false;
                }
                return !TextUtils.isEmpty(defaultAdapter.getName());
            } catch (Exception unused) {
                return true;
            }
        }
        return true;
    }

    public static boolean l(Context context) {
        if (f6914f == null) {
            f6914f = Boolean.valueOf((b() && k(context)) ? false : true);
        }
        return f6914f.booleanValue();
    }

    public static String m(Context context) {
        if (f6915g == null) {
            f6915g = a(v(context));
        }
        return f6915g;
    }

    public static String n(Context context) {
        return String.valueOf(w(context) / 1000000) + MqttTopic.TOPIC_LEVEL_SEPARATOR + String.valueOf(g() / 1000000);
    }

    public static JSONObject o(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            x(context);
            int b2 = C0272a.b();
            if (b2 > 0) {
                jSONObject.put("fx", b2 / e.a);
            }
            x(context);
            int c2 = C0272a.c();
            if (c2 > 0) {
                jSONObject.put("fn", c2 / e.a);
            }
            x(context);
            int a2 = C0272a.a();
            if (a2 > 0) {
                jSONObject.put("n", a2);
            }
            x(context);
            String d2 = C0272a.d();
            if (d2 != null && d2.length() != 0) {
                x(context);
                jSONObject.put("na", C0272a.d());
            }
            x(context);
            jSONObject.put("m", C0272a.e());
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("getCpuInfo", th);
        }
        return jSONObject;
    }

    public static String p(Context context) {
        List<Sensor> sensorList;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService(am.ac);
            if (sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < sensorList.size(); i2++) {
                sb.append(sensorList.get(i2).getType());
                if (i2 != sensorList.size() - 1) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            return sb.toString();
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("getAllSensors", th);
            return "";
        }
    }

    public static JSONArray q(Context context) {
        List<Sensor> sensorList;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService(am.ac);
            if (sensorManager == null || (sensorList = sensorManager.getSensorList(-1)) == null || sensorList.size() <= 0) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < sensorList.size(); i2++) {
                Sensor sensor = sensorList.get(i2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", sensor.getName());
                jSONObject.put("vendor", sensor.getVendor());
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("getSensors:" + th.toString());
            return null;
        }
    }

    public static boolean r(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable th) {
            com.tencent.tpns.dataacquisition.b.a.a("Util -> isScreenOn", th);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0020 A[Catch: all -> 0x0027, TRY_LEAVE, TryCatch #0 {all -> 0x0027, blocks: (B:3:0x0001, B:12:0x0020), top: B:17:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int s(android.content.Context r3) {
        /*
            r0 = -1
            android.content.IntentFilter r1 = new android.content.IntentFilter     // Catch: java.lang.Throwable -> L27
            java.lang.String r2 = "android.intent.action.BATTERY_CHANGED"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L27
            r2 = 0
            android.content.Intent r3 = r3.registerReceiver(r2, r1)     // Catch: java.lang.Throwable -> L27
            java.lang.String r1 = "status"
            int r1 = r3.getIntExtra(r1, r0)     // Catch: java.lang.Throwable -> L27
            r2 = 2
            if (r1 == r2) goto L1c
            r2 = 5
            if (r1 != r2) goto L1a
            goto L1c
        L1a:
            r1 = 0
            goto L1d
        L1c:
            r1 = 1
        L1d:
            if (r1 != 0) goto L20
            return r0
        L20:
            java.lang.String r1 = "plugged"
            int r3 = r3.getIntExtra(r1, r0)     // Catch: java.lang.Throwable -> L27
            return r3
        L27:
            r3 = move-exception
            java.lang.String r1 = "Util -> getChangedStatus"
            com.tencent.tpns.dataacquisition.b.a.a(r1, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.dataacquisition.a.a.s(android.content.Context):int");
    }

    public static String t(Context context) {
        if (com.tencent.tpns.dataacquisition.b.a.a(context, "android.permission.BLUETOOTH")) {
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                if (defaultAdapter != null) {
                    String name = defaultAdapter.getName();
                    return name != null ? name : "";
                }
                return "";
            } catch (Throwable unused) {
                return "";
            }
        }
        return "";
    }

    public static String u(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static List<String> v(Context context) {
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            try {
                String[] strArr = b;
                if (i3 >= strArr.length) {
                    break;
                }
                try {
                    context.getPackageManager().getPackageInfo(strArr[i3], 1);
                    arrayList.add(strArr[i3]);
                } catch (PackageManager.NameNotFoundException unused) {
                }
                i3++;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (arrayList.size() == 0) {
            while (true) {
                String[] strArr2 = f6911c;
                if (i2 >= strArr2.length) {
                    break;
                }
                if (new File(strArr2[i2]).exists()) {
                    arrayList.add(strArr2[i2]);
                }
                i2++;
            }
        }
        return arrayList;
    }

    private static long w(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    private static synchronized C0272a x(Context context) {
        C0272a c0272a;
        synchronized (a.class) {
            if (f6917i == null) {
                f6917i = new C0272a();
            }
            c0272a = f6917i;
        }
        return c0272a;
    }
}
