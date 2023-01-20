package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import java.io.File;

/* loaded from: classes3.dex */
public class NativeCrashHandler implements com.tencent.bugly.crashreport.a {
    private static NativeCrashHandler a = null;
    private static int b = 1;

    /* renamed from: m  reason: collision with root package name */
    private static boolean f6642m = false;
    private static boolean n = false;
    private static boolean p = true;

    /* renamed from: c  reason: collision with root package name */
    private final Context f6643c;

    /* renamed from: d  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f6644d;

    /* renamed from: e  reason: collision with root package name */
    private final x f6645e;

    /* renamed from: f  reason: collision with root package name */
    private NativeExceptionHandler f6646f;

    /* renamed from: g  reason: collision with root package name */
    private String f6647g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f6648h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6649i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean f6650j = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f6651k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f6652l = false;
    private com.tencent.bugly.crashreport.crash.b o;

    @SuppressLint({"SdCardPath"})
    private NativeCrashHandler(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, x xVar, boolean z, String str) {
        this.f6643c = ab.a(context);
        try {
            if (ab.a(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = "/data/data/" + com.tencent.bugly.crashreport.common.info.a.a(context).f6519c + "/app_bugly";
        }
        this.o = bVar;
        this.f6647g = str;
        this.f6644d = aVar;
        this.f6645e = xVar;
        this.f6648h = z;
        this.f6646f = new a(context, aVar, bVar, com.tencent.bugly.crashreport.common.strategy.a.a());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, com.tencent.bugly.crashreport.common.info.a aVar, com.tencent.bugly.crashreport.crash.b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2, x xVar, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (a == null) {
                a = new NativeCrashHandler(context, aVar, bVar, xVar, z, str);
            }
            nativeCrashHandler = a;
        }
        return nativeCrashHandler;
    }

    private native String getSoCpuAbi();

    public static boolean isShouldHandleInJava() {
        return p;
    }

    public static void setShouldHandleInJava(boolean z) {
        p = z;
        NativeCrashHandler nativeCrashHandler = a;
        if (nativeCrashHandler != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(z);
            nativeCrashHandler.a(999, sb.toString());
        }
    }

    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((this.f6649i || this.f6650j) && f6642m && str != null && str2 != null && str3 != null) {
            try {
                if (this.f6650j) {
                    return appendNativeLog(str, str2, str3);
                }
                Boolean bool = (Boolean) ab.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f6642m = false;
            } catch (Throwable th) {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public native boolean appendNativeLog(String str, String str2, String str3);

    public native boolean appendWholeNativeLog(String str);

    public void checkUploadRecordCrash() {
        this.f6645e.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                if (!ab.a(NativeCrashHandler.this.f6643c, "native_record_lock", (long) com.heytap.mcssdk.constant.a.q)) {
                    y.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                    return;
                }
                if (!NativeCrashHandler.p) {
                    NativeCrashHandler.this.a(999, Bugly.SDK_IS_DEV);
                }
                CrashDetailBean a2 = b.a(NativeCrashHandler.this.f6643c, NativeCrashHandler.this.f6647g, NativeCrashHandler.this.f6646f);
                if (a2 != null) {
                    y.a("[Native] Get crash from native record.", new Object[0]);
                    if (!NativeCrashHandler.this.o.a(a2)) {
                        NativeCrashHandler.this.o.a(a2, 3000L, false);
                    }
                    b.a(false, NativeCrashHandler.this.f6647g);
                }
                NativeCrashHandler.this.a();
                ab.b(NativeCrashHandler.this.f6643c, "native_record_lock");
            }
        });
    }

    public void dumpAnrNativeStack() {
        a(19, "1");
    }

    public void enableCatchAnrTrace() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 31 || i2 <= 19) {
            return;
        }
        b |= 2;
    }

    public boolean filterSigabrtSysLog() {
        return a(998, "true");
    }

    public synchronized String getDumpFilePath() {
        return this.f6647g;
    }

    public String getLogFromNative() {
        if ((this.f6649i || this.f6650j) && f6642m) {
            try {
                if (this.f6650j) {
                    return getNativeLog();
                }
                return (String) ab.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
            } catch (UnsatisfiedLinkError unused) {
                f6642m = false;
                return null;
            } catch (Throwable th) {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        return null;
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f6646f;
    }

    public native String getNativeKeyValueList();

    public native String getNativeLog();

    public String getRunningCpuAbi() {
        try {
            return getSoCpuAbi();
        } catch (Throwable unused) {
            y.d("get so cpu abi failed，please upgrade bugly so version", new Object[0]);
            return "";
        }
    }

    public boolean isEnableCatchAnrTrace() {
        return (b & 2) == 2;
    }

    public synchronized boolean isUserOpened() {
        return this.f6652l;
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            boolean z = strategyBean.f6533e;
            if (z != this.f6651k) {
                y.d("server native changed to %b", Boolean.valueOf(z));
            }
        }
        boolean z2 = com.tencent.bugly.crashreport.common.strategy.a.a().c().f6533e && this.f6652l;
        if (z2 != this.f6651k) {
            y.a("native changed to %b", Boolean.valueOf(z2));
            b(z2);
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f6649i || this.f6650j) && f6642m && str != null && str2 != null) {
            try {
                if (this.f6650j) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) ab.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f6642m = false;
            } catch (Throwable th) {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public native boolean putNativeKeyValue(String str, String str2);

    public native String regist(String str, boolean z, int i2);

    public void removeEmptyNativeRecordFiles() {
        b.c(this.f6647g);
    }

    public native String removeNativeKeyValue(String str);

    public synchronized void setDumpFilePath(String str) {
        this.f6647g = str;
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    public native void setNativeInfo(int i2, String str);

    @Override // com.tencent.bugly.crashreport.a
    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? "true" : Bugly.SDK_IS_DEV);
    }

    public boolean setNativeLaunchTime(long j2) {
        try {
            return a(15, String.valueOf(j2));
        } catch (NumberFormatException e2) {
            if (y.a(e2)) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    public synchronized void setUserOpened(boolean z) {
        c(z);
        boolean isUserOpened = isUserOpened();
        com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a2 != null) {
            isUserOpened = isUserOpened && a2.c().f6533e;
        }
        if (isUserOpened != this.f6651k) {
            y.a("native changed to %b", Boolean.valueOf(isUserOpened));
            b(isUserOpened);
        }
    }

    public synchronized void startNativeMonitor() {
        if (!this.f6650j && !this.f6649i) {
            boolean z = !ab.a(this.f6644d.f6528l);
            String str = "Bugly-ext";
            com.tencent.bugly.crashreport.common.info.a aVar = this.f6644d;
            String str2 = aVar.f6528l;
            if (z) {
                str = str2;
            } else {
                aVar.getClass();
            }
            boolean a2 = a(str, z);
            this.f6650j = a2;
            if (a2 || this.f6649i) {
                a(this.f6648h);
                if (f6642m) {
                    setNativeAppVersion(this.f6644d.f6525i);
                    setNativeAppChannel(this.f6644d.f6527k);
                    setNativeAppPackage(this.f6644d.f6519c);
                    setNativeUserId(this.f6644d.g());
                    setNativeIsAppForeground(this.f6644d.a());
                    setNativeLaunchTime(this.f6644d.a);
                }
                return;
            }
            return;
        }
        a(this.f6648h);
    }

    public native void testCrash();

    public void testNativeCrash() {
        if (!this.f6650j) {
            y.d("[Native] Bugly SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    public native String unregist();

    private synchronized void c() {
        if (!this.f6651k) {
            y.d("[Native] Native crash report has already unregistered.", new Object[0]);
        } else if (unregist() != null) {
            y.a("[Native] Successfully closed native crash report.", new Object[0]);
            this.f6651k = false;
        } else {
            ab.a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{Boolean.FALSE});
            this.f6651k = false;
            y.a("[Native] Successfully closed native crash report.", new Object[0]);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:15|(1:17)(17:44|(1:46)|19|20|(1:22)|23|(1:25)|27|(1:29)(1:42)|30|(1:32)(1:41)|33|(1:35)|36|(1:38)|39|40)|18|19|20|(0)|23|(0)|27|(0)(0)|30|(0)(0)|33|(0)|36|(0)|39|40) */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080 A[Catch: all -> 0x008e, TryCatch #3 {all -> 0x008e, blocks: (B:22:0x0076, B:24:0x0080, B:25:0x0082, B:27:0x008c), top: B:76:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c A[Catch: all -> 0x008e, TRY_LEAVE, TryCatch #3 {all -> 0x008e, blocks: (B:22:0x0076, B:24:0x0080, B:25:0x0082, B:27:0x008c), top: B:76:0x0076 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0092 A[Catch: all -> 0x00fc, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0008, B:9:0x0011, B:66:0x01cd, B:45:0x0105, B:12:0x0017, B:14:0x0021, B:16:0x0053, B:17:0x005d, B:28:0x008e, B:30:0x0092, B:32:0x00a1, B:34:0x00a5, B:36:0x00b4, B:38:0x00c8, B:39:0x00dc, B:41:0x00f5, B:35:0x00ad, B:31:0x009a, B:18:0x0065, B:20:0x006b), top: B:78:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009a A[Catch: all -> 0x00fc, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0008, B:9:0x0011, B:66:0x01cd, B:45:0x0105, B:12:0x0017, B:14:0x0021, B:16:0x0053, B:17:0x005d, B:28:0x008e, B:30:0x0092, B:32:0x00a1, B:34:0x00a5, B:36:0x00b4, B:38:0x00c8, B:39:0x00dc, B:41:0x00f5, B:35:0x00ad, B:31:0x009a, B:18:0x0065, B:20:0x006b), top: B:78:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a5 A[Catch: all -> 0x00fc, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0008, B:9:0x0011, B:66:0x01cd, B:45:0x0105, B:12:0x0017, B:14:0x0021, B:16:0x0053, B:17:0x005d, B:28:0x008e, B:30:0x0092, B:32:0x00a1, B:34:0x00a5, B:36:0x00b4, B:38:0x00c8, B:39:0x00dc, B:41:0x00f5, B:35:0x00ad, B:31:0x009a, B:18:0x0065, B:20:0x006b), top: B:78:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad A[Catch: all -> 0x00fc, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0008, B:9:0x0011, B:66:0x01cd, B:45:0x0105, B:12:0x0017, B:14:0x0021, B:16:0x0053, B:17:0x005d, B:28:0x008e, B:30:0x0092, B:32:0x00a1, B:34:0x00a5, B:36:0x00b4, B:38:0x00c8, B:39:0x00dc, B:41:0x00f5, B:35:0x00ad, B:31:0x009a, B:18:0x0065, B:20:0x006b), top: B:78:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c8 A[Catch: all -> 0x00fc, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0008, B:9:0x0011, B:66:0x01cd, B:45:0x0105, B:12:0x0017, B:14:0x0021, B:16:0x0053, B:17:0x005d, B:28:0x008e, B:30:0x0092, B:32:0x00a1, B:34:0x00a5, B:36:0x00b4, B:38:0x00c8, B:39:0x00dc, B:41:0x00f5, B:35:0x00ad, B:31:0x009a, B:18:0x0065, B:20:0x006b), top: B:78:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f5 A[Catch: all -> 0x00fc, TRY_LEAVE, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0008, B:9:0x0011, B:66:0x01cd, B:45:0x0105, B:12:0x0017, B:14:0x0021, B:16:0x0053, B:17:0x005d, B:28:0x008e, B:30:0x0092, B:32:0x00a1, B:34:0x00a5, B:36:0x00b4, B:38:0x00c8, B:39:0x00dc, B:41:0x00f5, B:35:0x00ad, B:31:0x009a, B:18:0x0065, B:20:0x006b), top: B:78:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void a(boolean r13) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.a(boolean):void");
    }

    private synchronized void b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            c();
        }
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = a;
        }
        return nativeCrashHandler;
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append(z);
        a(16, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z2);
        a(17, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z3);
        a(18, sb3.toString());
        testNativeCrash();
    }

    private synchronized void c(boolean z) {
        if (this.f6652l != z) {
            y.a("user change native %b", Boolean.valueOf(z));
            this.f6652l = z;
        }
    }

    private static boolean a(String str, boolean z) {
        boolean z2;
        try {
            y.a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                y.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                y.d(th.getMessage(), new Object[0]);
                y.d("[Native] Failed to load so: %s", str);
                return z2;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    public final void a() {
        long b2 = ab.b() - c.f6602g;
        long b3 = ab.b() + 86400000;
        File file = new File(this.f6647g);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i2 = 0;
                    int i3 = 0;
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (lastModified < b2 || lastModified >= b3) {
                            y.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i2++;
                            if (file2.delete()) {
                                i3++;
                            }
                        }
                    }
                    y.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i2), Integer.valueOf(i3));
                }
            } catch (Throwable th) {
                y.a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i2, String str) {
        if (this.f6650j && n) {
            try {
                setNativeInfo(i2, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                n = false;
            } catch (Throwable th) {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }
}
