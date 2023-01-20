package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import com.m7.imkfsdk.utils.permission.PermissionConstants;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpush.stat.ServiceStat;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"MissingPermission"})
/* loaded from: classes.dex */
public class v {
    private static volatile String a;
    private static volatile String b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile String f1040c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile String f1041d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile String f1042e;

    /* renamed from: f  reason: collision with root package name */
    private static volatile String f1043f;

    /* renamed from: g  reason: collision with root package name */
    private static volatile String f1044g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile String f1045h;

    /* renamed from: i  reason: collision with root package name */
    private static volatile String f1046i;

    /* renamed from: j  reason: collision with root package name */
    private static final AtomicInteger f1047j = new AtomicInteger(0);

    private static String a() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (b0.t()) {
            str = "MIUI-";
        } else if (!b0.q()) {
            String f2 = b0.f();
            if (b0.d(f2)) {
                sb.append("EMUI-");
            }
            if (!TextUtils.isEmpty(f2)) {
                sb.append(f2);
                str = Constants.ACCEPT_TIME_SEPARATOR_SERVER;
            }
            sb.append(Build.VERSION.INCREMENTAL);
            return sb.toString();
        } else {
            str = "FLYME-";
        }
        sb.append(str);
        sb.append(Build.VERSION.INCREMENTAL);
        return sb.toString();
    }

    public static String a(Context context) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().s().isCanUseAndroidId()) {
            if (TextUtils.isEmpty(b)) {
                synchronized (v.class) {
                    if (TextUtils.isEmpty(b)) {
                        n(context);
                    }
                }
            }
            return b;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r2.length() >= 13) goto L26;
     */
    @android.annotation.SuppressLint({"TrulyRandom", "HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r6, boolean r7) {
        /*
            java.lang.String r0 = "openudid"
            android.content.Context r6 = c(r6)
            r1 = 0
            if (r6 != 0) goto Lb
            goto L8a
        Lb:
            android.content.ContentResolver r2 = r6.getContentResolver()     // Catch: java.lang.Exception -> L16
            java.lang.String r3 = "android_id"
            java.lang.String r2 = android.provider.Settings.Secure.getString(r2, r3)     // Catch: java.lang.Exception -> L16
            goto L17
        L16:
            r2 = r1
        L17:
            r3 = 13
            if (r2 == 0) goto L29
            java.lang.String r4 = "9774d56d682e549c"
            boolean r4 = r2.equals(r4)     // Catch: java.lang.Exception -> L89
            if (r4 != 0) goto L29
            int r4 = r2.length()     // Catch: java.lang.Exception -> L89
            if (r4 >= r3) goto L89
        L29:
            java.lang.String r4 = "tt_device_info"
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0 r6 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0.a(r4, r6)     // Catch: java.lang.Exception -> L89
            java.lang.String r1 = r6.a(r0, r1)     // Catch: java.lang.Exception -> L89
            boolean r4 = a(r1)     // Catch: java.lang.Exception -> L89
            if (r4 != 0) goto L8a
            java.security.SecureRandom r1 = new java.security.SecureRandom     // Catch: java.lang.Exception -> L89
            r1.<init>()     // Catch: java.lang.Exception -> L89
            java.math.BigInteger r4 = new java.math.BigInteger     // Catch: java.lang.Exception -> L89
            r5 = 64
            r4.<init>(r5, r1)     // Catch: java.lang.Exception -> L89
            r1 = 16
            java.lang.String r1 = r4.toString(r1)     // Catch: java.lang.Exception -> L89
            r4 = 0
            char r4 = r1.charAt(r4)     // Catch: java.lang.Exception -> L89
            r5 = 45
            if (r4 != r5) goto L59
            r4 = 1
            java.lang.String r1 = r1.substring(r4)     // Catch: java.lang.Exception -> L89
        L59:
            int r4 = r1.length()     // Catch: java.lang.Exception -> L89
            int r3 = r3 - r4
            if (r3 <= 0) goto L76
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L89
            r4.<init>()     // Catch: java.lang.Exception -> L89
        L65:
            if (r3 <= 0) goto L6f
            r5 = 70
            r4.append(r5)     // Catch: java.lang.Exception -> L89
            int r3 = r3 + (-1)
            goto L65
        L6f:
            r4.append(r1)     // Catch: java.lang.Exception -> L89
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Exception -> L89
        L76:
            if (r7 == 0) goto L85
            java.lang.String r7 = "openudid.dat"
            java.lang.String r7 = a(r7, r1)     // Catch: java.lang.Exception -> L89
            boolean r3 = a(r7)     // Catch: java.lang.Exception -> L89
            if (r3 == 0) goto L85
            r1 = r7
        L85:
            r6.b(r0, r1)     // Catch: java.lang.Exception -> L89
            goto L8a
        L89:
            r1 = r2
        L8a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.v.a(android.content.Context, boolean):java.lang.String");
    }

    private static String a(WifiManager wifiManager, Context context) {
        String str = "02:00:00:00:00:00";
        if (wifiManager != null && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().s().isCanUseLocation() && k(context)) {
            try {
                List<ScanResult> scanResults = wifiManager.getScanResults();
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (scanResults != null && connectionInfo != null && connectionInfo.getBSSID() != null) {
                    for (int i2 = 0; i2 < scanResults.size(); i2++) {
                        ScanResult scanResult = scanResults.get(i2);
                        if (connectionInfo.getBSSID().equals(scanResult.BSSID)) {
                            str = scanResult.BSSID;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    private static String a(String str, String str2) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        File file;
        byte[] bArr;
        int read;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return str2;
        }
        String str3 = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.snssdk.api/cache";
        String str4 = str3 + MqttTopic.TOPIC_LEVEL_SEPARATOR + str;
        FileLock fileLock = null;
        try {
            file = new File(str3);
        } catch (Exception unused) {
            randomAccessFile2 = null;
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        if (!file.exists() && !file.mkdirs()) {
            return str2;
        }
        File file2 = new File(str4);
        randomAccessFile2 = new RandomAccessFile(file2, "rwd");
        try {
            fileLock = randomAccessFile2.getChannel().lock();
            if (file2.isFile() && (read = randomAccessFile2.read((bArr = new byte[ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED]), 0, ServiceStat.EnumPushAction_IN_MSG_ACTION_MOBILE_USER_DISABLED)) > 0 && read < 129) {
                String str5 = new String(bArr, 0, read, "UTF-8");
                if (a(str5)) {
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception unused2) {
                        }
                    }
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused3) {
                    }
                    return str5;
                }
            }
            byte[] bytes = str2.getBytes("UTF-8");
            randomAccessFile2.setLength(0L);
            randomAccessFile2.write(bytes);
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Exception unused4) {
                }
            }
        } catch (Exception unused5) {
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Exception unused6) {
                }
            }
            if (randomAccessFile2 == null) {
                return str2;
            }
            randomAccessFile2.close();
        } catch (Throwable th2) {
            randomAccessFile = randomAccessFile2;
            th = th2;
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Exception unused7) {
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception unused8) {
                }
            }
            throw th;
        }
        try {
            randomAccessFile2.close();
        } catch (Exception unused9) {
            return str2;
        }
    }

    public static void a(Context context, String str) {
        synchronized (v.class) {
            if (!TextUtils.isEmpty(str) && !str.equals(a)) {
                c0.a("tt_device_info", context).b("did", str);
                a = str;
            }
        }
    }

    private static boolean a(String str) {
        int length;
        if (str != null && (length = str.length()) >= 13 && length <= 128) {
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(f1044g)) {
            synchronized (v.class) {
                if (TextUtils.isEmpty(f1044g)) {
                    b();
                }
            }
        }
        return f1044g;
    }

    private static void b() {
        synchronized (v.class) {
            f1044g = String.valueOf(Build.TIME);
        }
    }

    private static Context c(Context context) {
        return context == null ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() : context;
    }

    private static void c() {
        synchronized (v.class) {
            a();
        }
    }

    public static String d(Context context) {
        if (TextUtils.isEmpty(a)) {
            synchronized (v.class) {
                if (TextUtils.isEmpty(a)) {
                    p(context);
                }
            }
        }
        return a;
    }

    public static String e(Context context) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().s().isCanUsePhoneState()) {
            if (TextUtils.isEmpty(f1040c)) {
                synchronized (v.class) {
                    if (TextUtils.isEmpty(f1040c)) {
                        s(context);
                    }
                }
            }
            return f1040c;
        }
        return null;
    }

    public static String f(Context context) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().s().isCanUsePhoneState()) {
            if (TextUtils.isEmpty(f1043f)) {
                synchronized (v.class) {
                    if (TextUtils.isEmpty(f1043f)) {
                        s(context);
                    }
                }
            }
            return f1043f;
        }
        return null;
    }

    public static String g(Context context) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().s().isCanUseLocation()) {
            if (TextUtils.isEmpty(f1041d)) {
                synchronized (v.class) {
                    if (TextUtils.isEmpty(f1041d)) {
                        r(context);
                    }
                }
            }
            return f1041d;
        }
        return null;
    }

    public static String h(Context context) {
        if (TextUtils.isEmpty(f1045h)) {
            synchronized (v.class) {
                if (TextUtils.isEmpty(f1045h)) {
                    q(context);
                }
            }
        }
        return f1045h;
    }

    public static String i(Context context) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().s().isCanUseLocation()) {
            if (TextUtils.isEmpty(f1042e)) {
                synchronized (v.class) {
                    if (TextUtils.isEmpty(f1042e)) {
                        r(context);
                    }
                }
            }
            return f1042e;
        }
        return null;
    }

    public static String j(Context context) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().s().isCanUsePhoneState()) {
            if (TextUtils.isEmpty(f1046i)) {
                synchronized (v.class) {
                    if (TextUtils.isEmpty(f1046i)) {
                        o(context);
                    }
                }
            }
            return f1046i;
        }
        return null;
    }

    private static boolean k(Context context) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.c.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.c.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    private static boolean l(Context context) {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.c.a(context, PermissionConstants.PHONE_STATE) == 0;
    }

    public static void m(Context context) {
        synchronized (v.class) {
            Context c2 = c(context);
            if (c2 != null) {
                s(c2);
                r(context);
                o(context);
                n(context);
                p(context);
                c();
                b();
                q(context);
            }
        }
    }

    private static void n(Context context) {
        synchronized (v.class) {
            if (context != null) {
                if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().s().isCanUseAndroidId()) {
                    b = a(context, true);
                }
            }
        }
    }

    @RequiresPermission(PermissionConstants.PHONE_STATE)
    private static void o(Context context) {
        synchronized (v.class) {
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().s().isCanUsePhoneState() && l(context)) {
                try {
                    f1046i = Build.VERSION.SDK_INT >= 28 ? Build.getSerial() : Build.SERIAL;
                } catch (Exception unused) {
                }
            }
        }
    }

    private static void p(Context context) {
        synchronized (v.class) {
            if (context != null) {
                a = p.c();
                if (TextUtils.isEmpty(a)) {
                    a = c0.a("tt_device_info", context).a("did", (String) null);
                } else {
                    a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d(), a);
                }
            }
        }
    }

    private static void q(Context context) {
        synchronized (v.class) {
            if (context != null) {
                f1045h = c0.a("tt_device_info", context).a("uuid", (String) null);
            }
        }
    }

    private static void r(Context context) {
        WifiInfo connectionInfo;
        synchronized (v.class) {
            if (context != null) {
                try {
                    WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                    if (wifiManager != null) {
                        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().s().isCanUseLocation() && k(context) && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                            f1041d = connectionInfo.getSSID();
                        }
                        f1042e = a(wifiManager, context);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static void s(Context context) {
        synchronized (v.class) {
            AtomicInteger atomicInteger = f1047j;
            if (atomicInteger.intValue() <= 5 && bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().s().isCanUsePhoneState() && l(context)) {
                try {
                    atomicInteger.incrementAndGet();
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        f1040c = telephonyManager.getDeviceId();
                        f1043f = telephonyManager.getSubscriberId();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void t(Context context) {
        Context c2;
        synchronized (v.class) {
            if (TextUtils.isEmpty(f1040c) && (c2 = c(context)) != null) {
                try {
                    s(c2);
                } catch (Exception unused) {
                }
            }
        }
    }
}
