package com.tencent.android.tpush.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.LocalServerSocket;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.AppInfos;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.f;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TGlobalHelper;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;

/* loaded from: classes3.dex */
public class b {
    private static Context a = null;
    private static String b = "";

    /* renamed from: c  reason: collision with root package name */
    private static LocalServerSocket f6230c = null;

    /* renamed from: d  reason: collision with root package name */
    private static LocalServerSocket f6231d = null;

    /* renamed from: e  reason: collision with root package name */
    private static volatile boolean f6232e = false;

    /* renamed from: f  reason: collision with root package name */
    private static volatile boolean f6233f = false;

    /* renamed from: g  reason: collision with root package name */
    private static volatile boolean f6234g = false;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f6235h = false;

    /* renamed from: i  reason: collision with root package name */
    private static ServiceConnection f6236i;

    /* renamed from: j  reason: collision with root package name */
    private Handler f6237j;

    /* loaded from: classes3.dex */
    public static class a {
        public static final b a = new b();
    }

    public static Context e() {
        Context context = a;
        return context != null ? context : XGPushManager.getContext();
    }

    public static ServiceConnection f() {
        return f6236i;
    }

    public static void g() {
        f6236i = null;
    }

    public static String h() {
        return b;
    }

    private void k() {
        this.f6237j = new Handler(Looper.getMainLooper()) { // from class: com.tencent.android.tpush.service.b.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message != null) {
                    TLogger.d("PushServiceManager", "initHandler, cmd:" + message.what);
                    int i2 = message.what;
                    if (i2 != 1) {
                        if (i2 == 2) {
                            d.a(XGVipPushService.a()).a((OnMqttCallback) null);
                            return;
                        } else if (i2 == 3) {
                            d.a(XGVipPushService.a()).c(null);
                            return;
                        } else if (i2 != 4) {
                            TLogger.e("PushServiceManager", "unknown handler msg = " + message.what);
                            return;
                        } else {
                            return;
                        }
                    }
                    TLogger.dd("PushServiceManager", "Service's running at " + b.a.getPackageName() + ",version : 1.3.5.0");
                    if (!f.a()) {
                        TLogger.e("PushServiceManager", "permission check failed, kill service!");
                        b.this.d();
                        com.tencent.android.tpush.service.util.f.e(b.e());
                    }
                    com.tencent.android.tpush.service.a.a().a(b.e());
                    d.a(XGVipPushService.a()).a((OnMqttCallback) null);
                    if (b.f6232e) {
                        return;
                    }
                    TLogger.d("PushServiceManager", "pull up xg services on 8s later");
                    CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.service.b.2.1
                        @Override // com.tencent.tpns.baseapi.base.util.TTask
                        public void TRun() {
                            TLogger.d("PushServiceManager", "8s time's over, now pull up xg services");
                            com.tencent.android.tpush.service.util.f.d(b.e());
                        }
                    }, 8000L);
                    boolean unused = b.f6232e = true;
                }
            }
        };
    }

    public void c() {
        try {
            TLogger.d("PushServiceManager", "@@ serviceExit()");
            i.a();
            Handler handler = this.f6237j;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f6237j = null;
            }
            if (CommonWorkingThread.getInstance().getHandler() != null) {
                CommonWorkingThread.getInstance().getHandler().removeCallbacksAndMessages(null);
            }
            com.tencent.android.tpush.service.a.a().c(a);
            d.a(XGVipPushService.a()).c(null);
            d();
            com.tencent.android.tpush.service.util.f.e(e());
        } catch (Throwable th) {
            TLogger.w("PushServiceManager", "unexpected for serviceExit:" + th.getMessage());
        }
    }

    public void d() {
        synchronized (this) {
            LocalServerSocket localServerSocket = f6230c;
            if (localServerSocket != null) {
                localServerSocket.close();
                f6230c = null;
            }
            f6232e = false;
        }
    }

    private b() {
        this.f6237j = null;
        b = AppInfos.getCurrentPackageName(e());
    }

    public static boolean a() {
        return f6235h;
    }

    public static b b() {
        return a.a;
    }

    public static void b(Context context) {
        if (context != null) {
            a = context;
            TGlobalHelper.setContext(context);
            b = context.getPackageName();
        }
    }

    public void a(Intent intent) {
        if (this.f6237j == null) {
            k();
        }
        synchronized (this) {
            if (!f6232e) {
                TLogger.d("PushServiceManager", "send WHAT_SERVICE_START msg at 100ms later on serviceStartHandler");
                this.f6237j.removeMessages(1);
                this.f6237j.sendMessageDelayed(this.f6237j.obtainMessage(1), 100L);
                return;
            }
            if (intent != null) {
                String action = intent.getAction();
                TLogger.v("PushServiceManager", "Start Service with action " + action);
                if (action != null) {
                    if (Constants.ACTION_KEEPALIVE.equals(action)) {
                        Message obtainMessage = this.f6237j.obtainMessage(2);
                        long longExtra = intent.getLongExtra(Constants.NETWORK_RESTAT_DELAY_TIME, 0L);
                        if (longExtra == 0) {
                            this.f6237j.removeMessages(2);
                            this.f6237j.sendMessageDelayed(obtainMessage, 100L);
                        } else {
                            this.f6237j.removeMessages(2);
                            this.f6237j.sendMessageDelayed(obtainMessage, longExtra);
                        }
                    } else if (Constants.ACTION_STOP_CONNECT.equals(action)) {
                        Message obtainMessage2 = this.f6237j.obtainMessage(3);
                        this.f6237j.removeMessages(3);
                        this.f6237j.sendMessageDelayed(obtainMessage2, 100L);
                    }
                }
            } else {
                TLogger.v("PushServiceManager", "Start Service with null action  but intent is not null");
                this.f6237j.removeMessages(1);
                this.f6237j.sendMessageDelayed(this.f6237j.obtainMessage(1), 100L);
            }
        }
    }

    public static void a(Context context) {
        a(context, Constants.ACTION_KEEPALIVE, 0L);
    }

    public static void a(Context context, long j2) {
        a(context, Constants.ACTION_KEEPALIVE, j2);
    }

    public static void a(Context context, String str, long j2) {
        Intent intent;
        Intent intent2;
        TLogger.d("PushServiceManager", "startService, action:" + str + ", delay:" + j2);
        if (!PushPreferences.getBoolean(context, Constants.KEY_START_SERVICE_BY_USER, false)) {
            TLogger.ii("PushServiceManager", "startService abolish, registerPush never called by user");
        } else if (!XGPushConfig.isUsedTpnsChannel(context)) {
            TLogger.ii("PushServiceManager", "startService abolish, not use Tpns channel service");
        } else {
            Intent intent3 = null;
            if (context != null) {
                try {
                    intent2 = new Intent();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    intent2.setClass(context, XGVipPushService.class);
                    intent2.setAction(str);
                    if (j2 != 0) {
                        intent2.putExtra(Constants.NETWORK_RESTAT_DELAY_TIME, j2);
                    }
                    if (i.a(context) <= 0) {
                        context.startService(intent2);
                        if (f6235h) {
                            return;
                        }
                        ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.tencent.android.tpush.service.b.1
                            @Override // android.content.ServiceConnection
                            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                                boolean unused = b.f6235h = true;
                                TLogger.d("PushServiceManager", "XGPushService onServiceConnected");
                            }

                            @Override // android.content.ServiceConnection
                            public void onServiceDisconnected(ComponentName componentName) {
                                boolean unused = b.f6235h = false;
                                TLogger.d("PushServiceManager", "XGPushService onServiceDisconnected");
                            }
                        };
                        f6236i = serviceConnection;
                        context.bindService(intent2, serviceConnection, 1);
                        TLogger.d("PushServiceManager", "bindService ret:" + f6235h);
                        return;
                    }
                    TLogger.e("PushServiceManager", "startService failed, libxgVipSecurity.so not found.");
                    context.stopService(intent2);
                } catch (Throwable th2) {
                    th = th2;
                    intent3 = intent2;
                    TLogger.e("PushServiceManager", "startService failed, intent:" + intent3 + ", ex:" + th);
                    try {
                        intent = new Intent();
                    } catch (Throwable th3) {
                        th = th3;
                    }
                    try {
                        intent.setClass(context, XGVipPushService.class);
                        if (i.a(context) <= 0) {
                            context.startService(intent);
                        } else {
                            TLogger.e("PushServiceManager", "startService failed, libxgVipSecurity.so not found.");
                            context.stopService(intent);
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        intent3 = intent;
                        TLogger.e("PushServiceManager", "222 startService failed, intent:" + intent3 + ", ex:" + th);
                    }
                }
            }
        }
    }
}
