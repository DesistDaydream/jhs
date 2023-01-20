package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.am;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public class b {
    public static final int a = 273;
    private static Context b = null;

    /* renamed from: c  reason: collision with root package name */
    private static HandlerThread f7443c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Handler f7444d = null;

    /* renamed from: f  reason: collision with root package name */
    private static final int f7446f = 274;

    /* renamed from: g  reason: collision with root package name */
    private static final int f7447g = 275;

    /* renamed from: h  reason: collision with root package name */
    private static final int f7448h = 512;

    /* renamed from: i  reason: collision with root package name */
    private static a f7449i = null;

    /* renamed from: j  reason: collision with root package name */
    private static IntentFilter f7450j = null;

    /* renamed from: k  reason: collision with root package name */
    private static volatile boolean f7451k = false;

    /* renamed from: e  reason: collision with root package name */
    private static Object f7445e = new Object();

    /* renamed from: l  reason: collision with root package name */
    private static LinkedList<String> f7452l = new LinkedList<>();

    /* loaded from: classes3.dex */
    public static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i2, String str) {
            if ((i2 & 8) != 8) {
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            b.a(274);
        }
    }

    public b(Context context) {
        synchronized (f7445e) {
            if (context != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    b = applicationContext;
                    if (applicationContext != null && f7443c == null) {
                        HandlerThread handlerThread = new HandlerThread("SL-NetWorkSender");
                        f7443c = handlerThread;
                        handlerThread.start();
                        if (f7449i == null) {
                            String str = b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f7437f;
                            File file = new File(str);
                            if (!file.exists()) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓目录不存在，创建之。");
                                file.mkdir();
                            }
                            a aVar = new a(str);
                            f7449i = aVar;
                            aVar.startWatching();
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓File Monitor启动.");
                        }
                        if (f7444d == null) {
                            f7444d = new Handler(f7443c.getLooper()) { // from class: com.umeng.commonsdk.stateless.b.1
                                @Override // android.os.Handler
                                public void handleMessage(Message message) {
                                    int i2 = message.what;
                                    if (i2 != 512) {
                                        switch (i2) {
                                            case 273:
                                                b.l();
                                                return;
                                            case 274:
                                                b.n();
                                                return;
                                            case 275:
                                                b.p();
                                                break;
                                            default:
                                                return;
                                        }
                                    }
                                    b.q();
                                }
                            };
                        }
                    }
                }
            }
        }
    }

    public static void a(boolean z) {
        f7451k = z;
        if (z) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
            b(274);
            return;
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
    }

    public static void b(int i2) {
        Handler handler;
        try {
            if (!f7451k || (handler = f7444d) == null || handler.hasMessages(i2)) {
                return;
            }
            Message obtainMessage = f7444d.obtainMessage();
            obtainMessage.what = i2;
            f7444d.sendMessage(obtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(b, th);
        }
    }

    public static void c() {
        b(275);
    }

    public static void d() {
        b(512);
    }

    private static void i() {
        File[] c2 = d.c(b);
        if (c2 != null) {
            if (f7452l.size() > 0) {
                f7452l.clear();
            }
            for (File file : c2) {
                f7452l.add(file.getAbsolutePath());
            }
        }
    }

    private static String j() {
        String str = null;
        try {
            String peek = f7452l.peek();
            if (peek != null) {
                try {
                    f7452l.removeFirst();
                    return peek;
                } catch (Throwable unused) {
                    str = peek;
                    return str;
                }
            }
            return peek;
        } catch (Throwable unused2) {
        }
    }

    private static void k() {
        String j2;
        if (f7452l.size() <= 0) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            if (Build.VERSION.SDK_INT >= 9) {
                j2 = f7452l.pollFirst();
            } else {
                j2 = j();
            }
            if (!TextUtils.isEmpty(j2)) {
                File file = new File(j2);
                if (!file.exists()) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                    continue;
                } else {
                    c cVar = new c(b);
                    byte[] bArr = null;
                    try {
                        bArr = d.a(j2);
                    } catch (Exception unused) {
                    }
                    String name = file.getName();
                    String substring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : am.aH;
                    String c2 = d.c(d.d(name));
                    if (cVar.a(bArr, c2, com.umeng.commonsdk.vchannel.a.f7622c.equalsIgnoreCase(c2) ? com.umeng.commonsdk.vchannel.a.a : "", substring) && !file.delete()) {
                        file.delete();
                        continue;
                    }
                }
            }
        } while (j2 != null);
        f7452l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        File a2;
        if (!f7451k || b == null) {
            return;
        }
        do {
            try {
                a2 = d.a(b);
                if (a2 != null && a2.getParentFile() != null && !TextUtils.isEmpty(a2.getParentFile().getName())) {
                    c cVar = new c(b);
                    String str = new String(Base64.decode(a2.getParentFile().getName(), 0));
                    if (!com.umeng.commonsdk.internal.a.a.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.b.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.G.equalsIgnoreCase(str)) {
                        ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                        byte[] bArr = null;
                        try {
                            bArr = d.a(a2.getAbsolutePath());
                        } catch (Exception unused) {
                        }
                        String str2 = com.umeng.commonsdk.vchannel.a.f7622c.equalsIgnoreCase(str) ? com.umeng.commonsdk.vchannel.a.a : "";
                        String str3 = am.aH;
                        if (UMServerURL.PATH_SHARE.equalsIgnoreCase(str)) {
                            str3 = "s";
                        }
                        if (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) {
                            str3 = am.ax;
                        }
                        if (cVar.a(bArr, str, str2, str3)) {
                            ULog.i("walle", "[stateless] Send envelope file success, delete it.");
                            File file = new File(a2.getAbsolutePath());
                            if (file.delete()) {
                                continue;
                            } else {
                                ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                                file.delete();
                                continue;
                            }
                        } else {
                            ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                    }
                    new File(a2.getAbsolutePath()).delete();
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(b, th);
            }
        } while (a2 != null);
        m();
    }

    private static void m() {
        try {
            File file = new File(b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f7436e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                d.a(file);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        if (!f7451k || b == null) {
            return;
        }
        i();
        k();
        c();
    }

    private static void o() {
        try {
            File file = new File(b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f7436e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                b(273);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p() {
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
    }

    public static boolean a() {
        synchronized (f7445e) {
            return f7449i != null;
        }
    }

    public static void b() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        b(274);
    }

    public static void a(int i2) {
        Handler handler;
        if (!f7451k || (handler = f7444d) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i2;
        f7444d.sendMessage(obtainMessage);
    }
}
