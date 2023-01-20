package cn.thinkingdata.android;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.LocaleList;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import cn.thinkingdata.android.utils.TDLog;
import com.tencent.android.tpns.mqtt.MqttTopic;
import d.a.a.h;
import d.a.a.n.i;
import d.a.a.o.b;
import d.a.a.o.g;
import d.a.a.o.k;
import d.a.a.o.n;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class j {

    /* renamed from: i  reason: collision with root package name */
    private static String f1357i = "Android";

    /* renamed from: j  reason: collision with root package name */
    private static String f1358j = "2.8.2";

    /* renamed from: k  reason: collision with root package name */
    private static j f1359k;

    /* renamed from: l  reason: collision with root package name */
    private static final Object f1360l = new Object();
    private boolean a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private final TimeZone f1361c;

    /* renamed from: d  reason: collision with root package name */
    private String f1362d;

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Object> f1363e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f1364f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f1365g;

    /* renamed from: h  reason: collision with root package name */
    private String f1366h;

    /* loaded from: classes.dex */
    public static class a extends HashMap<String, String> {
        public a() {
            put("46000", "中国移动");
            put("46002", "中国移动");
            put("46007", "中国移动");
            put("46008", "中国移动");
            put("46001", "中国联通");
            put("46006", "中国联通");
            put("46009", "中国联通");
            put("46003", "中国电信");
            put("46005", "中国电信");
            put("46011", "中国电信");
            put("46004", "中国卫通");
            put("46020", "中国铁通");
        }
    }

    private j(Context context, TimeZone timeZone) {
        Context applicationContext = context.getApplicationContext();
        this.f1364f = applicationContext;
        this.f1361c = timeZone;
        this.f1365g = h(applicationContext, "android.permission.ACCESS_NETWORK_STATE");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (!TDPresetProperties.disableList.contains("#app_version")) {
                this.f1362d = packageInfo.versionName;
            }
            long j2 = packageInfo.firstInstallTime;
            this.b = j2;
            this.a = j2 == packageInfo.lastUpdateTime;
            TDLog.d("ThinkingAnalytics.SystemInformation", "First Install Time: " + packageInfo.firstInstallTime);
            TDLog.d("ThinkingAnalytics.SystemInformation", "Last Update Time: " + packageInfo.lastUpdateTime);
        } catch (Exception unused) {
            TDLog.d("ThinkingAnalytics.SystemInformation", "Exception occurred in getting app version");
        }
        this.f1363e = s(context);
    }

    private static int a(int i2, int i3, int i4) {
        return (i2 == 0 || i2 == 2) ? i4 : i3;
    }

    public static j b(Context context, TimeZone timeZone) {
        j jVar;
        synchronized (f1360l) {
            if (f1359k == null) {
                f1359k = new j(context, timeZone);
            }
            jVar = f1359k;
        }
        return jVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0032 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0035 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0038 A[RETURN] */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d(android.content.Context r3, android.telephony.TelephonyManager r4, android.net.ConnectivityManager r5) {
        /*
            r2 = this;
            if (r4 == 0) goto L1a
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L1a
            r1 = 30
            if (r0 < r1) goto L15
            java.lang.String r0 = "android.permission.READ_PHONE_STATE"
            boolean r3 = r2.h(r3, r0)     // Catch: java.lang.Exception -> L1a
            if (r3 == 0) goto L15
            int r3 = r4.getDataNetworkType()     // Catch: java.lang.Exception -> L1a
            goto L1b
        L15:
            int r3 = r4.getNetworkType()     // Catch: java.lang.Exception -> L1a
            goto L1b
        L1a:
            r3 = 0
        L1b:
            if (r3 != 0) goto L29
            if (r5 == 0) goto L29
            android.net.NetworkInfo r4 = r5.getActiveNetworkInfo()
            if (r4 == 0) goto L29
            int r3 = r4.getSubtype()
        L29:
            switch(r3) {
                case 1: goto L38;
                case 2: goto L38;
                case 3: goto L35;
                case 4: goto L38;
                case 5: goto L35;
                case 6: goto L35;
                case 7: goto L38;
                case 8: goto L35;
                case 9: goto L35;
                case 10: goto L35;
                case 11: goto L38;
                case 12: goto L35;
                case 13: goto L32;
                case 14: goto L35;
                case 15: goto L35;
                case 16: goto L2c;
                case 17: goto L2c;
                case 18: goto L32;
                case 19: goto L32;
                case 20: goto L2f;
                default: goto L2c;
            }
        L2c:
            java.lang.String r3 = "NULL"
            return r3
        L2f:
            java.lang.String r3 = "5G"
            return r3
        L32:
            java.lang.String r3 = "4G"
            return r3
        L35:
            java.lang.String r3 = "3G"
            return r3
        L38:
            java.lang.String r3 = "2G"
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.thinkingdata.android.j.d(android.content.Context, android.telephony.TelephonyManager, android.net.ConnectivityManager):java.lang.String");
    }

    public static void g(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            f1357i = str;
            TDLog.d("ThinkingAnalytics.SystemInformation", "#lib has been changed to: " + str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        f1358j = str2;
        TDLog.d("ThinkingAnalytics.SystemInformation", "#lib_version has been changed to: " + str2);
    }

    private boolean h(Context context, String str) {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.core.content.ContextCompat");
        } catch (Exception unused) {
            cls = null;
        }
        if (cls == null) {
            try {
                cls = Class.forName("androidx.core.content.ContextCompat");
            } catch (Exception unused2) {
            }
        }
        if (cls == null) {
            return true;
        }
        try {
            if (((Integer) cls.getMethod("checkSelfPermission", Context.class, String.class).invoke(null, context, str)).intValue() != 0) {
                TDLog.w("ThinkingAnalytics.SystemInformation", "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"" + str + "\" />");
                return false;
            }
            return true;
        } catch (Exception e2) {
            TDLog.w("ThinkingAnalytics.SystemInformation", e2.toString());
            return true;
        }
    }

    private static int i(int i2, int i3, int i4) {
        return (i2 == 0 || i2 == 2) ? i3 : i4;
    }

    private static String l(Context context, boolean z) {
        int i2 = Build.VERSION.SDK_INT;
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Class<?> cls = Class.forName("android.os.storage.StorageVolume");
            Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
            Method method2 = i2 < 30 ? cls.getMethod("getPath", new Class[0]) : cls.getMethod("getDirectory", new Class[0]);
            Method method3 = cls.getMethod("isRemovable", new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i3 = 0; i3 < length; i3++) {
                Object obj = Array.get(invoke, i3);
                String absolutePath = i2 < 30 ? (String) method2.invoke(obj, new Object[0]) : ((File) method2.invoke(obj, new Object[0])).getAbsolutePath();
                if (z == ((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return absolutePath;
                }
            }
            return null;
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    private static String m(Context context) {
        a aVar = new a();
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            String simOperator = telephonyManager.getSimOperator();
            if (TextUtils.isEmpty(simOperator) || !aVar.containsKey(simOperator)) {
                String simOperatorName = telephonyManager.getSimOperatorName();
                return !TextUtils.isEmpty(simOperatorName) ? simOperatorName : "";
            }
            return (String) aVar.get(simOperator);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int[] p(Context context) {
        Display defaultDisplay;
        int rotation;
        Point point;
        int i2;
        int height;
        int i3;
        int[] iArr = new int[2];
        try {
            defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            rotation = defaultDisplay.getRotation();
            point = new Point();
            i2 = Build.VERSION.SDK_INT;
        } catch (Exception unused) {
            if (context.getResources() != null) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                iArr[0] = displayMetrics.widthPixels;
                iArr[1] = displayMetrics.heightPixels;
            }
        }
        if (i2 >= 17) {
            defaultDisplay.getRealSize(point);
        } else if (i2 < 13) {
            int width = defaultDisplay.getWidth();
            height = defaultDisplay.getHeight();
            i3 = width;
            iArr[0] = i(rotation, i3, height);
            iArr[1] = a(rotation, i3, height);
            return iArr;
        } else {
            defaultDisplay.getSize(point);
        }
        i3 = point.x;
        height = point.y;
        iArr[0] = i(rotation, i3, height);
        iArr[1] = a(rotation, i3, height);
        return iArr;
    }

    public static j q(Context context) {
        j jVar;
        synchronized (f1360l) {
            if (f1359k == null) {
                f1359k = new j(context, null);
            }
            jVar = f1359k;
        }
        return jVar;
    }

    private Map<String, Object> s(Context context) {
        HashMap hashMap = new HashMap();
        List<String> list = TDPresetProperties.disableList;
        if (!list.contains("#lib")) {
            hashMap.put("#lib", f1357i);
        }
        if (!list.contains("#lib_version")) {
            hashMap.put("#lib_version", f1358j);
        }
        if (this.f1361c != null && !list.contains("#install_time")) {
            hashMap.put("#install_time", new k(new Date(this.b), this.f1361c).b());
        }
        String w = n.w();
        if (!list.contains("#os")) {
            hashMap.put("#os", TextUtils.isEmpty(w) ? "Android" : "HarmonyOS");
        }
        if (!list.contains("#os_version")) {
            if (TextUtils.isEmpty(w)) {
                w = Build.VERSION.RELEASE;
            }
            hashMap.put("#os_version", w);
        }
        if (!list.contains("#bundle_id")) {
            hashMap.put("#bundle_id", n.y(context));
        }
        if (!list.contains("#manufacturer")) {
            hashMap.put("#manufacturer", Build.MANUFACTURER);
        }
        if (!list.contains("#device_model")) {
            hashMap.put("#device_model", Build.MODEL);
        }
        int[] p = p(context);
        if (!list.contains("#screen_width")) {
            hashMap.put("#screen_width", Integer.valueOf(p[0]));
        }
        if (!list.contains("#screen_height")) {
            hashMap.put("#screen_height", Integer.valueOf(p[1]));
        }
        if (!list.contains("#carrier")) {
            hashMap.put("#carrier", m(context));
        }
        if (!list.contains("#device_id")) {
            hashMap.put("#device_id", c(context));
        }
        if (!list.contains("#system_language")) {
            hashMap.put("#system_language", w());
        }
        if (!TextUtils.isEmpty(this.f1362d)) {
            hashMap.put("#app_version", this.f1362d);
        }
        if (!list.contains("#simulator")) {
            hashMap.put("#simulator", Boolean.valueOf(b.b()));
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static String u() {
        return f1357i;
    }

    public static String v() {
        return f1358j;
    }

    private String w() {
        return (Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault()).getLanguage();
    }

    @SuppressLint({"HardwareIds"})
    public String c(Context context) {
        i iVar = new i(new h().a(context, "com.thinkingdata.analyse"));
        String e2 = iVar.e();
        if (TextUtils.isEmpty(e2)) {
            Object a2 = g.a(g.b("cn.thinkingdata.android.utils.TASensitiveInfo"), "getAndroidID", new Object[]{context}, Context.class);
            String valueOf = a2 == null ? "" : String.valueOf(a2);
            if (TextUtils.isEmpty(valueOf)) {
                valueOf = iVar.a();
            }
            try {
                if (Integer.parseInt(valueOf) == 0) {
                    valueOf = iVar.a();
                }
            } catch (Exception unused) {
            }
            String str = valueOf;
            iVar.d(str);
            return str;
        }
        return e2;
    }

    public String e(Context context, boolean z) {
        if (TextUtils.isEmpty(this.f1366h)) {
            this.f1366h = l(context, z);
        }
        if (TextUtils.isEmpty(this.f1366h)) {
            return "0";
        }
        File file = new File(this.f1366h);
        if (file.exists()) {
            StatFs statFs = new StatFs(file.getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                long blockCountLong = statFs.getBlockCountLong();
                long blockSizeLong = statFs.getBlockSizeLong();
                double a2 = n.a((((blockCountLong * blockSizeLong) / 1024.0d) / 1024.0d) / 1024.0d);
                double a3 = n.a((((statFs.getAvailableBlocksLong() * blockSizeLong) / 1024.0d) / 1024.0d) / 1024.0d);
                return a3 + MqttTopic.TOPIC_LEVEL_SEPARATOR + a2;
            }
            return "0";
        }
        return "0";
    }

    public JSONObject f() {
        if (this.f1363e != null) {
            JSONObject jSONObject = new JSONObject(this.f1363e);
            jSONObject.remove("#lib");
            jSONObject.remove("#lib_version");
            return jSONObject;
        }
        return new JSONObject();
    }

    public String j() {
        return this.f1362d;
    }

    public String k(Context context) {
        if (Build.VERSION.SDK_INT >= 16) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
            long j2 = memoryInfo.totalMem;
            long j3 = memoryInfo.availMem;
            double a2 = n.a(((j2 / 1024.0d) / 1024.0d) / 1024.0d);
            double a3 = n.a(((j3 / 1024.0d) / 1024.0d) / 1024.0d);
            return a3 + MqttTopic.TOPIC_LEVEL_SEPARATOR + a2;
        }
        return "0";
    }

    public Map<String, Object> n() {
        return this.f1363e;
    }

    public String o() {
        NetworkInfo networkInfo;
        try {
            if (this.f1365g) {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.f1364f.getSystemService("connectivity");
                return (connectivityManager == null || (networkInfo = connectivityManager.getNetworkInfo(1)) == null || !networkInfo.isConnectedOrConnecting()) ? d(this.f1364f, (TelephonyManager) this.f1364f.getSystemService("phone"), connectivityManager) : "WIFI";
            }
            return "NULL";
        } catch (Exception unused) {
            return "NULL";
        }
    }

    public boolean r() {
        return this.a;
    }

    public boolean t() {
        if (this.f1365g) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f1364f.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
