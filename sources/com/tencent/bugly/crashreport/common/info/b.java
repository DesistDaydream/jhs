package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.y;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class b {
    private static final ArrayList<a> a = new ArrayList<a>() { // from class: com.tencent.bugly.crashreport.common.info.b.1
        {
            add(new l((byte) 0));
            add(new f((byte) 0));
            add(new g((byte) 0));
            add(new m((byte) 0));
            add(new h((byte) 0));
            add(new i((byte) 0));
            add(new k((byte) 0));
            add(new e((byte) 0));
            add(new j((byte) 0));
            add(new C0233b((byte) 0));
            add(new d((byte) 0));
            add(new c((byte) 0));
        }
    };
    private static final Map<Integer, String> b = new HashMap<Integer, String>() { // from class: com.tencent.bugly.crashreport.common.info.b.2
        {
            put(1, "GPRS");
            put(2, "EDGE");
            put(3, "UMTS");
            put(8, "HSDPA");
            put(9, "HSUPA");
            put(10, "HSPA");
            put(4, "CDMA");
            put(5, "EVDO_0");
            put(6, "EVDO_A");
            put(7, "1xRTT");
            put(11, "iDen");
            put(12, "EVDO_B");
            put(13, "LTE");
            put(14, "eHRPD");
            put(15, "HSPA+");
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f6530c = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* loaded from: classes3.dex */
    public static abstract class a {
        private a() {
        }

        public abstract String a(Context context);

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.bugly.crashreport.common.info.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0233b extends a {
        private C0233b() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.crashreport.common.info.b.a
        public final String a(Context context) {
            String a = ab.a(context, "ro.gn.gnromvernumber");
            if (ab.a(a) || a.equals("fail")) {
                return null;
            }
            return "amigo/" + a + MqttTopic.TOPIC_LEVEL_SEPARATOR + ab.a(context, "ro.build.display.id");
        }

        public /* synthetic */ C0233b(byte b) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends a {
        private c() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.crashreport.common.info.b.a
        public final String a(Context context) {
            return ab.a(context, "ro.build.fingerprint") + MqttTopic.TOPIC_LEVEL_SEPARATOR + ab.a(context, "ro.build.rom.id");
        }

        public /* synthetic */ c(byte b) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class d extends a {
        private d() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.crashreport.common.info.b.a
        public final String a(Context context) {
            String a = ab.a(context, "ro.build.tyd.kbstyle_version");
            if (ab.a(a) || a.equals("fail")) {
                return null;
            }
            return "dido/" + a;
        }

        public /* synthetic */ d(byte b) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends a {
        private e() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.crashreport.common.info.b.a
        public final String a(Context context) {
            String a = ab.a(context, "ro.aa.romver");
            if (ab.a(a) || a.equals("fail")) {
                return null;
            }
            return "htc/" + a + MqttTopic.TOPIC_LEVEL_SEPARATOR + ab.a(context, "ro.build.description");
        }

        public /* synthetic */ e(byte b) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends a {
        private f() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.crashreport.common.info.b.a
        public final String a(Context context) {
            String a = ab.a(context, "ro.build.version.emui");
            if (ab.a(a) || a.equals("fail")) {
                return null;
            }
            return "HuaWei/EMOTION/" + a;
        }

        public /* synthetic */ f(byte b) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends a {
        private g() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.crashreport.common.info.b.a
        public final String a(Context context) {
            String a = ab.a(context, "ro.lenovo.series");
            if (ab.a(a) || a.equals("fail")) {
                return null;
            }
            String a2 = ab.a(context, "ro.build.version.incremental");
            return "Lenovo/VIBE/" + a2;
        }

        public /* synthetic */ g(byte b) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class h extends a {
        private h() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.crashreport.common.info.b.a
        public final String a(Context context) {
            String a = ab.a(context, "ro.meizu.product.model");
            if (ab.a(a) || a.equals("fail")) {
                return null;
            }
            return "Meizu/FLYME/" + ab.a(context, "ro.build.display.id");
        }

        public /* synthetic */ h(byte b) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class i extends a {
        private i() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.crashreport.common.info.b.a
        public final String a(Context context) {
            String a = ab.a(context, "ro.build.version.opporom");
            if (ab.a(a) || a.equals("fail")) {
                return null;
            }
            return "Oppo/COLOROS/" + a;
        }

        public /* synthetic */ i(byte b) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class j extends a {
        private j() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.crashreport.common.info.b.a
        public final String a(Context context) {
            String a = ab.a(context, "ro.lewa.version");
            if (ab.a(a) || a.equals("fail")) {
                return null;
            }
            return "tcl/" + a + MqttTopic.TOPIC_LEVEL_SEPARATOR + ab.a(context, "ro.build.display.id");
        }

        public /* synthetic */ j(byte b) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class k extends a {
        private k() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.crashreport.common.info.b.a
        public final String a(Context context) {
            String a = ab.a(context, "ro.vivo.os.build.display.id");
            if (ab.a(a) || a.equals("fail")) {
                return null;
            }
            return "vivo/FUNTOUCH/" + a;
        }

        public /* synthetic */ k(byte b) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class l extends a {
        private l() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.crashreport.common.info.b.a
        public final String a(Context context) {
            String a = ab.a(context, "ro.miui.ui.version.name");
            if (ab.a(a) || a.equals("fail")) {
                return null;
            }
            return "XiaoMi/MIUI/" + a;
        }

        public /* synthetic */ l(byte b) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public static class m extends a {
        private m() {
            super((byte) 0);
        }

        @Override // com.tencent.bugly.crashreport.common.info.b.a
        public final String a(Context context) {
            String a = ab.a(context, "ro.build.nubia.rom.name");
            if (ab.a(a) || a.equals("fail")) {
                return null;
            }
            return "Zte/NUBIA/" + a + "_" + ab.a(context, "ro.build.nubia.rom.code");
        }

        public /* synthetic */ m(byte b) {
            this();
        }
    }

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (y.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String b() {
        try {
            return Build.VERSION.RELEASE;
        } catch (Throwable th) {
            if (y.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static int c() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable th) {
            if (y.a(th)) {
                return -1;
            }
            th.printStackTrace();
            return -1;
        }
    }

    public static long d() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCount() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!y.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long e() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable th) {
            if (!y.a(th)) {
                th.printStackTrace();
            }
            return -1L;
        }
    }

    public static long f() {
        return Debug.getPss() << 10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
        r0 = java.lang.Long.parseLong(r2.replaceAll("[^\\d]", ""));
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0034 -> B:33:0x0046). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long g() {
        /*
            r0 = 0
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3a
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3a
            java.lang.String r5 = "/proc/self/status"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L3a
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L38
        L13:
            if (r2 == 0) goto L2f
            java.lang.String r4 = "VmSize"
            boolean r4 = r2.startsWith(r4)     // Catch: java.lang.Throwable -> L38
            if (r4 == 0) goto L2a
            java.lang.String r4 = "[^\\d]"
            java.lang.String r5 = ""
            java.lang.String r2 = r2.replaceAll(r4, r5)     // Catch: java.lang.Throwable -> L38
            long r0 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> L38
            goto L2f
        L2a:
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L38
            goto L13
        L2f:
            r3.close()     // Catch: java.lang.Throwable -> L33
            goto L46
        L33:
            r2 = move-exception
            r2.printStackTrace()
            goto L46
        L38:
            r2 = move-exception
            goto L3e
        L3a:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L3e:
            com.tencent.bugly.proguard.y.a(r2)     // Catch: java.lang.Throwable -> L4a
            if (r3 == 0) goto L46
            r3.close()     // Catch: java.lang.Throwable -> L33
        L46:
            r2 = 10
            long r0 = r0 << r2
            return r0
        L4a:
            r0 = move-exception
            if (r3 == 0) goto L55
            r3.close()     // Catch: java.lang.Throwable -> L51
            goto L55
        L51:
            r1 = move-exception
            r1.printStackTrace()
        L55:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.g():long");
    }

    public static long h() {
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public static long i() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            fileReader = null;
            th = th3;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    if (!y.a(e2)) {
                        e2.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                    return -1L;
                } catch (IOException e3) {
                    if (y.a(e3)) {
                        return -1L;
                    }
                    e3.printStackTrace();
                    return -1L;
                }
            }
            long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10;
            try {
                bufferedReader.close();
            } catch (IOException e4) {
                if (!y.a(e4)) {
                    e4.printStackTrace();
                }
            }
            try {
                fileReader.close();
            } catch (IOException e5) {
                if (!y.a(e5)) {
                    e5.printStackTrace();
                }
            }
            return parseLong;
        } catch (Throwable th4) {
            th = th4;
            try {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                        if (!y.a(e6)) {
                            e6.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                        return -2L;
                    } catch (IOException e7) {
                        if (y.a(e7)) {
                            return -2L;
                        }
                        e7.printStackTrace();
                        return -2L;
                    }
                }
                return -2L;
            } catch (Throwable th5) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e8) {
                        if (!y.a(e8)) {
                            e8.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e9) {
                        if (!y.a(e9)) {
                            e9.printStackTrace();
                        }
                    }
                }
                throw th5;
            }
        }
    }

    public static long j() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileReader = null;
        }
        try {
            bufferedReader.readLine();
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    if (!y.a(e2)) {
                        e2.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e3) {
                    if (!y.a(e3)) {
                        e3.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong = (Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10) + 0;
            String readLine2 = bufferedReader.readLine();
            if (readLine2 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                    if (!y.a(e4)) {
                        e4.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e5) {
                    if (!y.a(e5)) {
                        e5.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong2 = parseLong + (Long.parseLong(readLine2.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
            String readLine3 = bufferedReader.readLine();
            if (readLine3 == null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                    if (!y.a(e6)) {
                        e6.printStackTrace();
                    }
                }
                try {
                    fileReader.close();
                } catch (IOException e7) {
                    if (!y.a(e7)) {
                        e7.printStackTrace();
                    }
                }
                return -1L;
            }
            long parseLong3 = parseLong2 + (Long.parseLong(readLine3.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) << 10);
            try {
                bufferedReader.close();
            } catch (IOException e8) {
                if (!y.a(e8)) {
                    e8.printStackTrace();
                }
            }
            try {
                fileReader.close();
            } catch (IOException e9) {
                if (!y.a(e9)) {
                    e9.printStackTrace();
                }
            }
            return parseLong3;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            try {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e10) {
                        if (!y.a(e10)) {
                            e10.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                        return -2L;
                    } catch (IOException e11) {
                        if (y.a(e11)) {
                            return -2L;
                        }
                        e11.printStackTrace();
                        return -2L;
                    }
                }
                return -2L;
            } catch (Throwable th4) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e12) {
                        if (!y.a(e12)) {
                            e12.printStackTrace();
                        }
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e13) {
                        if (!y.a(e13)) {
                            e13.printStackTrace();
                        }
                    }
                }
                throw th4;
            }
        }
    }

    public static long k() {
        if (p()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getBlockCount() * statFs.getBlockSize();
            } catch (Throwable th) {
                if (y.a(th)) {
                    return -2L;
                }
                th.printStackTrace();
                return -2L;
            }
        }
        return 0L;
    }

    public static long l() {
        if (p()) {
            try {
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return statFs.getAvailableBlocks() * statFs.getBlockSize();
            } catch (Throwable th) {
                if (y.a(th)) {
                    return -2L;
                }
                th.printStackTrace();
                return -2L;
            }
        }
        return 0L;
    }

    public static String m() {
        return "";
    }

    public static boolean n() {
        boolean z;
        String[] strArr = f6530c;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            } else if (new File(strArr[i2]).exists()) {
                z = true;
                break;
            } else {
                i2++;
            }
        }
        String str = Build.TAGS;
        return (str != null && str.contains("test-keys")) || z;
    }

    public static boolean o() {
        float maxMemory = (float) (Runtime.getRuntime().maxMemory() / 1048576.0d);
        float f2 = (float) (Runtime.getRuntime().totalMemory() / 1048576.0d);
        float f3 = maxMemory - f2;
        y.c("maxMemory : %f", Float.valueOf(maxMemory));
        y.c("totalMemory : %f", Float.valueOf(f2));
        y.c("freeMemory : %f", Float.valueOf(f3));
        return f3 < 10.0f;
    }

    private static boolean p() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            if (y.a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public static String a(Context context, boolean z) {
        try {
            String property = System.getProperty("os.arch");
            return property;
        } catch (Throwable th) {
            if (y.a(th)) {
                return "fail";
            }
            th.printStackTrace();
            return "fail";
        }
    }

    public static String b(Context context) {
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager;
        String str = "unknown";
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e2) {
            e = e2;
        }
        if (activeNetworkInfo == null) {
            return null;
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getType() == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            int networkType = telephonyManager.getNetworkType();
            String str2 = b.get(Integer.valueOf(networkType));
            if (str2 == null) {
                try {
                    str = "MOBILE(" + networkType + ")";
                } catch (Exception e3) {
                    e = e3;
                    str = str2;
                    if (!y.a(e)) {
                        e.printStackTrace();
                    }
                    return str;
                }
            } else {
                str = str2;
            }
        }
        return str;
    }

    public static String c(Context context) {
        Iterator<a> it = a.iterator();
        while (it.hasNext()) {
            String a2 = it.next().a(context);
            if (!TextUtils.isEmpty(a2)) {
                return a2;
            }
        }
        return null;
    }

    public static boolean d(Context context) {
        return !TextUtils.isEmpty(new i((byte) 0).a(context));
    }

    public static boolean e(Context context) {
        return !TextUtils.isEmpty(new k((byte) 0).a(context));
    }

    public static String a(Context context) {
        if (context != null && context.getApplicationInfo() != null) {
            String str = context.getApplicationInfo().nativeLibraryDir;
            if (TextUtils.isEmpty(str)) {
                return "fail";
            }
            if (str.endsWith("arm")) {
                return "armeabi-v7a";
            }
            if (str.endsWith("arm64")) {
                return "arm64-v8a";
            }
            if (str.endsWith("x86")) {
                return "x86";
            }
            if (str.endsWith("x86_64")) {
                return "x86_64";
            }
        }
        return "fail";
    }
}
