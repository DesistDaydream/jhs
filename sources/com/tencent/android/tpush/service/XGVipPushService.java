package com.tencent.android.tpush.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.channel.security.TpnsSecurity;
import com.tencent.android.tpush.service.protocol.k;
import com.tencent.android.tpush.service.util.f;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;
import com.tencent.tpns.mqttchannel.core.services.MqttServiceImpl;
import com.tencent.tpns.mqttchannel.services.BaseMqttClientService;
import org.json.JSONArray;
import org.json.JSONException;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.SERVICESCHECK})
/* loaded from: classes3.dex */
public class XGVipPushService extends BaseMqttClientService {
    private static volatile String b = null;

    /* renamed from: c */
    private static long f6180c = 0;

    /* renamed from: d */
    private static JSONArray f6181d = null;

    /* renamed from: e */
    private static long f6182e = 270000;

    /* renamed from: f */
    private static Service f6183f;

    /* renamed from: k */
    private static MqttServiceImpl f6184k;

    /* renamed from: g */
    private Handler f6185g;

    /* renamed from: h */
    private boolean f6186h = false;

    /* renamed from: i */
    private com.tencent.android.tpush.service.channel.a f6187i = new com.tencent.android.tpush.service.channel.a();

    /* renamed from: j */
    private boolean f6188j = false;
    public TTask a = new TTask() { // from class: com.tencent.android.tpush.service.XGVipPushService.4
        {
            XGVipPushService.this = this;
        }

        @Override // com.tencent.tpns.baseapi.base.util.TTask
        public void TRun() {
            CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.service.XGVipPushService.4.1
                {
                    AnonymousClass4.this = this;
                }

                @Override // com.tencent.tpns.baseapi.base.util.TTask
                public void TRun() {
                    TLogger.d("XGVipPushService", "--CheckMessage--interval time:" + XGVipPushService.f6182e);
                    com.tencent.android.tpush.a.c(XGVipPushService.this);
                    if (MqttConfigImpl.getKeepAliveInterval(XGVipPushService.this.getApplicationContext()) >= 285) {
                        if (DeviceInfos.isScreenOn(XGVipPushService.this.getApplicationContext())) {
                            long unused = XGVipPushService.f6182e = 120000L;
                        } else {
                            long unused2 = XGVipPushService.f6182e = 270000L;
                        }
                        if (XGVipPushService.this.f6185g != null) {
                            XGVipPushService xGVipPushService = XGVipPushService.this;
                            if (xGVipPushService.a != null) {
                                xGVipPushService.f6185g.postDelayed(XGVipPushService.this.a, XGVipPushService.f6182e);
                            }
                        }
                    }
                }
            });
        }
    };

    private void b(final Context context) {
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.service.XGVipPushService.3
            {
                XGVipPushService.this = this;
            }

            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                TpnsSecurity.getEncryptAPKSignature(context);
                c.a(context);
            }
        });
    }

    private void d() {
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.service.XGVipPushService.1
            {
                XGVipPushService.this = this;
            }

            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                Context applicationContext = XGVipPushService.this.getApplicationContext();
                StringBuilder sb = new StringBuilder();
                sb.append("com.tencent.android.tpush.debug,");
                sb.append(XGVipPushService.this.getApplicationContext().getPackageName());
                boolean z = PushPreferences.getInt(applicationContext, sb.toString(), 0) == 1;
                XGPushConfig.enableDebug = true;
                TLogger.enableDebug(XGVipPushService.this.getApplicationContext(), z);
                Context applicationContext2 = XGVipPushService.this.getApplicationContext();
                TBaseLogger.setDebugLevel(PushPreferences.getInt(applicationContext2, "com.tencent.android.tpush.log_level," + XGVipPushService.this.getApplicationContext().getPackageName(), -1));
            }
        });
    }

    private void e() {
        TLogger.d("XGVipPushService", "action - initCheckMessageHandler, on 60s later");
        Handler handler = new Handler();
        this.f6185g = handler;
        handler.postDelayed(this.a, com.heytap.mcssdk.constant.a.f3314d);
    }

    @Override // com.tencent.tpns.mqttchannel.services.BaseMqttClientService, android.app.Service
    public IBinder onBind(Intent intent) {
        TLogger.ii("XGVipPushService", "Service onBind()");
        if (!this.f6186h) {
            a(intent, "onBind");
            this.f6186h = true;
        }
        return super.onBind(intent);
    }

    @Override // com.tencent.tpns.mqttchannel.services.BaseMqttClientService
    public void onConnectComplete(boolean z) {
        TLogger.ii("XGVipPushService", "onConnectComplete isReconnect:" + z);
    }

    @Override // com.tencent.tpns.mqttchannel.services.BaseMqttClientService
    public void onConnectionLost() {
        TLogger.ii("XGVipPushService", "onConnectionLost");
    }

    @Override // com.tencent.tpns.mqttchannel.services.BaseMqttClientService, android.app.Service
    public void onCreate() {
        super.onCreate();
        Security.checkTpnsSecurityLibSo(this);
        f6180c = System.currentTimeMillis();
        f6183f = this;
        if (f6184k == null) {
            f6184k = new MqttServiceImpl(getApplicationContext(), this);
        }
        try {
            d.a(f6184k).a((OnMqttCallback) null);
        } catch (Throwable th) {
            TLogger.ee("XGVipPushService", "Service startConnect error : ", th);
        }
        Context applicationContext = getApplicationContext();
        b.b(applicationContext);
        ServiceStat.init(applicationContext);
        a.a().b(applicationContext);
        d();
        a(applicationContext);
        TLogger.ii("XGVipPushService", "Service onCreate() : " + getPackageName());
        if (i.a(getApplicationContext()) > 0) {
            f.e(getApplicationContext());
        }
        b(applicationContext);
        e();
    }

    @Override // com.tencent.tpns.mqttchannel.services.BaseMqttClientService, android.app.Service
    public void onDestroy() {
        b.b().c();
        TLogger.flush();
        super.onDestroy();
    }

    @Override // com.tencent.tpns.mqttchannel.services.BaseMqttClientService
    public void onHeartBeat() {
        TLogger.ii("XGVipPushService", "heartBeat");
        com.tencent.android.tpush.a.b(this);
        f.d(this);
    }

    @Override // com.tencent.tpns.mqttchannel.services.BaseMqttClientService
    public void onMessageArrived(String str, String str2) {
        TLogger.ii("XGVipPushService", "onMessageArrived: topic:" + str + ", message:" + str2);
        if (i.b(this, str)) {
            try {
                k kVar = new k();
                kVar.a(str2);
                com.tencent.android.tpush.service.b.a.a().a(kVar.b, kVar.a, this.f6187i);
            } catch (JSONException e2) {
                TLogger.ee("XGVipPushService", "decode push msg fail", e2);
                ServiceStat.reportErrCode(this, ErrCode.INNER_ERROR_JSON, "onMessageArrived:" + str2, 0L, "inner");
            }
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i2) {
        TLogger.i("XGVipPushService", "Service onStart() : " + getPackageName());
        super.onStart(intent, i2);
    }

    @Override // android.app.Service
    @SuppressLint({"WrongConstant"})
    public int onStartCommand(Intent intent, int i2, int i3) {
        TLogger.ii("XGVipPushService", "Service onStartCommand() : " + getPackageName());
        super.onStartCommand(intent, i2, i3);
        a(intent, "onStartCommand");
        return 2;
    }

    public static Service b() {
        return f6183f;
    }

    public static MqttServiceImpl a() {
        return f6184k;
    }

    public static void a(final Context context) {
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.service.XGVipPushService.2
            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                try {
                    if (CloudManager.getInstance(context).disableShareBugly()) {
                        TLogger.d("XGVipPushService", "initBuglyInfo | disable share bugly");
                        return;
                    }
                    SharedPreferences.Editor edit = context.getSharedPreferences("BuglySdkInfos", 0).edit();
                    edit.putString("42510ae4dd", "1.3.5.0");
                    edit.apply();
                } catch (Throwable th) {
                    TLogger.e("XGVipPushService", "initBuglyInfo :", th);
                }
            }
        });
    }

    private synchronized void a(Intent intent, String str) {
        JSONArray jSONArray;
        TLogger.d("XGVipPushService", "initServiceHandler with method : " + str);
        if (i.a(getApplicationContext()) > 0) {
            TLogger.ee("XGVipPushService", "initGlobal error");
            f.e(getApplicationContext());
            return;
        }
        if (intent != null) {
            if (f6181d == null) {
                f6181d = new JSONArray();
            }
            String action = intent.getAction();
            if (!i.b(action) && (jSONArray = f6181d) != null && jSONArray.length() < 10) {
                try {
                    action = action.replace("com.tencent.android.tpush.action", "");
                } catch (Throwable th) {
                    TLogger.w("XGVipPushService", "unexpected for initServiceHandler:" + th.getMessage());
                }
                f6181d.put(action);
            }
        }
        d();
        b.b().a(intent);
    }
}
