package com.umeng.commonsdk.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import cn.thinkingdata.android.TDConfig;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.c;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public class a implements UMImprintChangeCallback {
    private static HandlerThread a = null;
    private static Handler b = null;

    /* renamed from: c */
    private static Handler f7379c = null;

    /* renamed from: d */
    private static final int f7380d = 200;

    /* renamed from: e */
    private static final int f7381e = 273;

    /* renamed from: f */
    private static final int f7382f = 274;

    /* renamed from: g */
    private static final int f7383g = 512;

    /* renamed from: h */
    private static final int f7384h = 769;

    /* renamed from: i */
    private static FileObserverC0285a f7385i = null;

    /* renamed from: j */
    private static ConnectivityManager f7386j = null;

    /* renamed from: k */
    private static IntentFilter f7387k = null;

    /* renamed from: l */
    private static volatile boolean f7388l = false;

    /* renamed from: m */
    private static ArrayList<UMSenderStateNotify> f7389m = null;
    private static final String p = "report_policy";
    private static final String q = "report_interval";
    private static final int s = 15;
    private static final int t = 3;
    private static final int u = 90;
    private static BroadcastReceiver x;
    private static Object n = new Object();
    private static ReentrantLock o = new ReentrantLock();
    private static boolean r = false;
    private static int v = 15;
    private static Object w = new Object();

    /* renamed from: com.umeng.commonsdk.framework.a$a */
    /* loaded from: classes3.dex */
    public static class FileObserverC0285a extends FileObserver {
        public FileObserverC0285a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i2, String str) {
            if ((i2 & 8) != 8) {
                return;
            }
            ULog.d("--->>> envelope file created >>> " + str);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            a.c(273);
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f7386j = (ConnectivityManager) appContext.getSystemService("connectivity");
        }
        x = new BroadcastReceiver() { // from class: com.umeng.commonsdk.framework.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, b.a(context).a(), null);
                }
            }
        };
    }

    public a(Context context, Handler handler) {
        if (f7386j == null) {
            Context appContext = UMGlobalContext.getAppContext();
            if (f7386j != null) {
                f7386j = (ConnectivityManager) appContext.getSystemService("connectivity");
            }
        }
        f7379c = handler;
        try {
            if (a == null) {
                HandlerThread handlerThread = new HandlerThread("NetWorkSender");
                a = handlerThread;
                handlerThread.start();
                if (f7385i == null) {
                    FileObserverC0285a fileObserverC0285a = new FileObserverC0285a(UMFrUtils.getEnvelopeDirPath(context));
                    f7385i = fileObserverC0285a;
                    fileObserverC0285a.startWatching();
                    ULog.d("--->>> FileMonitor has already started!");
                }
                j();
                if (b == null) {
                    b = new Handler(a.getLooper()) { // from class: com.umeng.commonsdk.framework.a.2
                        {
                            a.this = this;
                        }

                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            int i2 = message.what;
                            if (i2 == 273) {
                                ULog.d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                                try {
                                    a.o.tryLock(1L, TimeUnit.SECONDS);
                                    try {
                                        a.n();
                                    } catch (Throwable unused) {
                                    }
                                    a.o.unlock();
                                } catch (Throwable unused2) {
                                }
                            } else if (i2 == 274) {
                                a.l();
                            } else if (i2 != 512) {
                            } else {
                                a.m();
                            }
                        }
                    };
                }
                ImprintHandler.getImprintService(context).registImprintCallback(p, this);
                ImprintHandler.getImprintService(context).registImprintCallback(q, this);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static int b() {
        int i2;
        synchronized (w) {
            i2 = v;
        }
        return i2;
    }

    public static void c() {
    }

    public static void c(int i2) {
        Handler handler;
        if (!f7388l || (handler = b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i2;
        b.sendMessage(obtainMessage);
    }

    public static void d() {
        if (o.tryLock()) {
            try {
                b(273);
            } finally {
                o.unlock();
            }
        }
    }

    public static void e() {
        a(274, 3000);
    }

    private void j() {
        synchronized (w) {
            if ("11".equals(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), p, ""))) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                r = true;
                v = 15;
                int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), q, "15")).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3 && intValue <= 90) {
                    v = intValue * 1000;
                }
                v = 15;
            } else {
                r = false;
            }
        }
    }

    private static void k() {
        if (a != null) {
            a = null;
        }
        if (b != null) {
            b = null;
        }
        if (f7379c != null) {
            f7379c = null;
        }
    }

    public static void l() {
        int size;
        synchronized (n) {
            ArrayList<UMSenderStateNotify> arrayList = f7389m;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    f7389m.get(i2).onSenderIdle();
                }
            }
        }
    }

    public static void m() {
    }

    public static void n() {
        ULog.d("--->>> handleProcessNext: Enter...");
        if (f7388l) {
            Context appContext = UMModuleRegister.getAppContext();
            try {
                if (UMFrUtils.envelopeFileNumber(appContext) > 0) {
                    ULog.d("--->>> The envelope file exists.");
                    if (UMFrUtils.envelopeFileNumber(appContext) > 200) {
                        ULog.d("--->>> Number of envelope files is greater than 200, remove old files first.");
                        UMFrUtils.removeRedundantEnvelopeFiles(appContext, 200);
                    }
                    File envelopeFile = UMFrUtils.getEnvelopeFile(appContext);
                    if (envelopeFile != null) {
                        String path = envelopeFile.getPath();
                        ULog.d("--->>> Ready to send envelope file [" + path + "].");
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send envelope file [ " + path + "].");
                        if (new c(appContext).a(envelopeFile)) {
                            ULog.d("--->>> Send envelope file success, delete it.");
                            if (!UMFrUtils.removeEnvelopeFile(envelopeFile)) {
                                ULog.d("--->>> Failed to delete already processed file. We try again after delete failed.");
                                UMFrUtils.removeEnvelopeFile(envelopeFile);
                            }
                            c(273);
                            return;
                        }
                        ULog.d("--->>> Send envelope file failed, abandon and wait next trigger!");
                        return;
                    }
                }
                e();
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
            }
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        synchronized (w) {
            if (p.equals(str)) {
                if ("11".equals(str2)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                    r = true;
                } else {
                    r = false;
                }
            }
            if (q.equals(str)) {
                int intValue = Integer.valueOf(str2).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + intValue);
                if (intValue >= 3 && intValue <= 90) {
                    v = intValue * 1000;
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + v);
                }
                v = TDConfig.DEFAULT_FLUSH_INTERVAL;
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + v);
            }
        }
    }

    public static void a(Context context) {
        if (f7386j != null || context == null) {
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        f7386j = connectivityManager;
        if (connectivityManager != null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> createCMIfNeeded:注册网络状态监听器。");
            b(context);
        }
    }

    public static void b(Context context) {
        if (DeviceConfig.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") && f7386j != null && f7387k == null) {
            IntentFilter intentFilter = new IntentFilter();
            f7387k = intentFilter;
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (x != null) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器。");
                context.registerReceiver(x, f7387k);
            }
        }
    }

    public static void a(UMSenderStateNotify uMSenderStateNotify) {
        synchronized (n) {
            if (f7389m == null) {
                f7389m = new ArrayList<>();
            }
            if (uMSenderStateNotify != null) {
                for (int i2 = 0; i2 < f7389m.size(); i2++) {
                    if (uMSenderStateNotify == f7389m.get(i2)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> addConnStateObserver: input item has exist.");
                        return;
                    }
                }
                f7389m.add(uMSenderStateNotify);
            }
        }
    }

    private static void b(int i2) {
        Handler handler;
        if (!f7388l || (handler = b) == null || handler.hasMessages(i2)) {
            return;
        }
        Message obtainMessage = b.obtainMessage();
        obtainMessage.what = i2;
        b.sendMessage(obtainMessage);
    }

    public static boolean a() {
        boolean z;
        synchronized (w) {
            z = r;
        }
        return z;
    }

    public static void a(boolean z) {
        int size;
        f7388l = z;
        if (z) {
            synchronized (n) {
                ArrayList<UMSenderStateNotify> arrayList = f7389m;
                if (arrayList != null && (size = arrayList.size()) > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        f7389m.get(i2).onConnectionAvailable();
                    }
                }
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "网络状态通知：尝试发送 MSG_PROCESS_NEXT");
            d();
            return;
        }
        ULog.i("--->>> network disconnected.");
        f7388l = false;
    }

    private static void a(int i2, long j2) {
        Handler handler;
        if (!f7388l || (handler = b) == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = i2;
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> sendMsgDelayed: " + j2);
        b.sendMessageDelayed(obtainMessage, j2);
    }

    private static void a(int i2, int i3) {
        Handler handler;
        if (!f7388l || (handler = b) == null) {
            return;
        }
        handler.removeMessages(i2);
        Message obtainMessage = b.obtainMessage();
        obtainMessage.what = i2;
        b.sendMessageDelayed(obtainMessage, i3);
    }
}
