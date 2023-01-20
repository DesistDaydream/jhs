package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.m;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.v;
import com.tencent.bugly.proguard.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class b {
    public static boolean a = true;
    public static List<a> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static boolean f6489c;

    /* renamed from: d  reason: collision with root package name */
    private static o f6490d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f6491e;

    private static boolean a(com.tencent.bugly.crashreport.common.info.a aVar) {
        List<String> list = aVar.n;
        aVar.getClass();
        return list != null && list.contains("bugly");
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            a(context, null);
        }
    }

    public static synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (b.class) {
            if (f6491e) {
                y.d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(y.a, "[init] context of init() is null, check it.");
            } else {
                com.tencent.bugly.crashreport.common.info.a a2 = com.tencent.bugly.crashreport.common.info.a.a(context);
                if (a(a2)) {
                    a = false;
                    return;
                }
                String f2 = a2.f();
                if (f2 == null) {
                    Log.e(y.a, "[init] meta data of BUGLY_APPID in AndroidManifest.xml should be set.");
                } else {
                    a(context, f2, a2.t, buglyStrategy);
                }
            }
        }
    }

    public static synchronized void a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        byte[] bArr;
        synchronized (b.class) {
            if (f6491e) {
                y.d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                Log.w(y.a, "[init] context is null, check it.");
            } else if (str == null) {
                Log.e(y.a, "init arg 'crashReportAppID' should not be null!");
            } else {
                f6491e = true;
                if (z) {
                    f6489c = true;
                    y.b = true;
                    y.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                    y.e("--------------------------------------------------------------------------------------------", new Object[0]);
                    y.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                    y.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                    y.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                    y.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                    y.e("--------------------------------------------------------------------------------------------", new Object[0]);
                    y.b("[init] Open debug mode of Bugly.", new Object[0]);
                }
                y.a(" crash report start initializing...", new Object[0]);
                y.b("[init] Bugly start initializing...", new Object[0]);
                y.a("[init] Bugly complete version: v%s", "4.0.4");
                Context a2 = ab.a(context);
                com.tencent.bugly.crashreport.common.info.a a3 = com.tencent.bugly.crashreport.common.info.a.a(a2);
                a3.s();
                aa.a(a2);
                f6490d = o.a(a2, b);
                v.a(a2);
                com.tencent.bugly.crashreport.common.strategy.a.a(a2, b);
                m a4 = m.a(a2);
                if (a(a3)) {
                    a = false;
                    return;
                }
                a3.a(str);
                y.a("[param] Set APP ID:%s", str);
                if (buglyStrategy != null) {
                    String appVersion = buglyStrategy.getAppVersion();
                    if (!TextUtils.isEmpty(appVersion)) {
                        if (appVersion.length() > 100) {
                            String substring = appVersion.substring(0, 100);
                            y.d("appVersion %s length is over limit %d substring to %s", appVersion, 100, substring);
                            appVersion = substring;
                        }
                        a3.f6525i = appVersion;
                        y.a("[param] Set App version: %s", buglyStrategy.getAppVersion());
                    }
                    try {
                        if (buglyStrategy.isReplaceOldChannel()) {
                            String appChannel = buglyStrategy.getAppChannel();
                            if (!TextUtils.isEmpty(appChannel)) {
                                if (appChannel.length() > 100) {
                                    String substring2 = appChannel.substring(0, 100);
                                    y.d("appChannel %s length is over limit %d substring to %s", appChannel, 100, substring2);
                                    appChannel = substring2;
                                }
                                f6490d.a(556, "app_channel", appChannel.getBytes(), (n) null, false);
                                a3.f6527k = appChannel;
                            }
                        } else {
                            Map<String, byte[]> a5 = f6490d.a(556, (n) null, true);
                            if (a5 != null && (bArr = a5.get("app_channel")) != null) {
                                a3.f6527k = new String(bArr);
                            }
                        }
                        y.a("[param] Set App channel: %s", a3.f6527k);
                    } catch (Exception e2) {
                        if (f6489c) {
                            e2.printStackTrace();
                        }
                    }
                    String appPackageName = buglyStrategy.getAppPackageName();
                    if (!TextUtils.isEmpty(appPackageName)) {
                        if (appPackageName.length() > 100) {
                            String substring3 = appPackageName.substring(0, 100);
                            y.d("appPackageName %s length is over limit %d substring to %s", appPackageName, 100, substring3);
                            appPackageName = substring3;
                        }
                        a3.f6519c = appPackageName;
                        y.a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
                    }
                    String deviceID = buglyStrategy.getDeviceID();
                    if (deviceID != null) {
                        if (deviceID.length() > 100) {
                            String substring4 = deviceID.substring(0, 100);
                            y.d("deviceId %s length is over limit %d substring to %s", deviceID, 100, substring4);
                            deviceID = substring4;
                        }
                        a3.c(deviceID);
                        y.a("[param] Set device ID: %s", deviceID);
                    }
                    String deviceModel = buglyStrategy.getDeviceModel();
                    if (deviceModel != null) {
                        a3.d(deviceModel);
                        y.a("[param] Set device model: %s", deviceModel);
                    }
                    a3.f6521e = buglyStrategy.isUploadProcess();
                    aa.a = buglyStrategy.isBuglyLogUpload();
                }
                for (int i2 = 0; i2 < b.size(); i2++) {
                    if (a4.a(b.get(i2).id)) {
                        b.get(i2).init(a2, z, buglyStrategy);
                    }
                }
                com.tencent.bugly.crashreport.biz.b.a(a2, buglyStrategy);
                com.tencent.bugly.crashreport.common.strategy.a.a().a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0L);
                y.b("[init] Bugly initialization finished.", new Object[0]);
            }
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (!b.contains(aVar)) {
                b.add(aVar);
            }
        }
    }
}
