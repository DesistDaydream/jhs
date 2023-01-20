package com.tencent.android.tpush.service.c;

import android.content.Context;
import android.os.Process;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.service.protocol.d;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.MqttConnectState;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b {
    private static volatile boolean a = true;
    private static volatile boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private long f6251c;

    /* loaded from: classes3.dex */
    public static class a extends OnMqttCallback {
        private com.tencent.android.tpush.service.c.a a;
        private d b;

        /* renamed from: c  reason: collision with root package name */
        private Context f6256c;

        public a(Context context, com.tencent.android.tpush.service.c.a aVar, d dVar) {
            this.f6256c = context.getApplicationContext();
            this.a = aVar;
            this.b = dVar;
        }

        @Override // com.tencent.tpns.mqttchannel.core.a.b
        public void callback(int i2, String str) {
            if (i2 >= 0) {
                this.a.a(i2, str, this.b);
            } else {
                this.a.b(i2, str, this.b);
            }
            b.b(this.f6256c, i2, str, this.requestId, this.b);
        }
    }

    /* renamed from: com.tencent.android.tpush.service.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0228b {
        void a();

        void a(int i2, String str);
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static b a = new b();
    }

    public static /* synthetic */ long a(b bVar) {
        long j2 = bVar.f6251c;
        bVar.f6251c = 1 + j2;
        return j2;
    }

    private long b() {
        return (((System.currentTimeMillis() % 100000000000L) * 1000) + (Process.myPid() % 1000)) * 1000;
    }

    private b() {
        this.f6251c = b();
    }

    public static b a() {
        return c.a;
    }

    public void b(final Context context, final d dVar, final com.tencent.android.tpush.service.c.a aVar) {
        a(context, new InterfaceC0228b() { // from class: com.tencent.android.tpush.service.c.b.2
            @Override // com.tencent.android.tpush.service.c.b.InterfaceC0228b
            public void a() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", b.a(b.this));
                    jSONObject.put(Constants.MQTT_STATISTISC_MSGTYPE_KEY, dVar.a().getStr());
                    jSONObject.put("params", dVar.a(context));
                    com.tencent.android.tpush.service.d.a(XGVipPushService.a()).a(Constants.MQTT_STATISTISC_TOPIC, jSONObject.toString(), new a(context, aVar, dVar));
                } catch (Throwable th) {
                    TLogger.ee("XGMqttChannel", "sendStatMsg throwable: ", th);
                    com.tencent.android.tpush.service.c.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b(ErrCode.INNER_ERROR_JSON, "sendStatMsg request error", dVar);
                    }
                }
            }

            @Override // com.tencent.android.tpush.service.c.b.InterfaceC0228b
            public void a(int i2, String str) {
                com.tencent.android.tpush.service.c.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b(i2, str, dVar);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, int i2, String str, long j2, d dVar) {
        try {
            if (i2 == 0) {
                a = true;
            } else if (i2 == -1103) {
                if (a) {
                    a = false;
                    ServiceStat.reportErrCode(context, i2, str, j2, dVar.a().getStr());
                }
            } else {
                if (i2 != -3 && i2 != -4) {
                    if (i2 > 1010000 && i2 < 1011000) {
                        return;
                    }
                    ServiceStat.reportErrCode(context, i2, str, j2, dVar.a().getStr());
                }
                if (b) {
                    b = false;
                    ServiceStat.reportErrCode(context, i2, str, j2, dVar.a().getStr());
                }
            }
        } catch (Throwable th) {
            TLogger.e("XGMqttChannel", "handleErrCodeReport error: " + th.getMessage());
        }
    }

    public void a(final Context context, final d dVar, final com.tencent.android.tpush.service.c.a aVar) {
        a(context, new InterfaceC0228b() { // from class: com.tencent.android.tpush.service.c.b.1
            @Override // com.tencent.android.tpush.service.c.b.InterfaceC0228b
            public void a() {
                try {
                    com.tencent.android.tpush.service.d.a(XGVipPushService.a()).a(dVar.a().getStr(), dVar.a(context), new a(context, aVar, dVar));
                } catch (Throwable th) {
                    TLogger.ee("XGMqttChannel", "sendMessage throwable: ", th);
                    ServiceStat.reportErrCode(context, ErrCode.INNER_ERROR_JSON, "sendMessage request error", 0L, dVar.a().getStr());
                    com.tencent.android.tpush.service.c.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b(ErrCode.INNER_ERROR_JSON, "sendMessage request error", dVar);
                    }
                }
            }

            @Override // com.tencent.android.tpush.service.c.b.InterfaceC0228b
            public void a(int i2, String str) {
                com.tencent.android.tpush.service.c.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b(i2, str, dVar);
                }
                b.b(context, i2, str, 0L, dVar);
            }
        });
    }

    private void a(Context context, final InterfaceC0228b interfaceC0228b) {
        TLogger.d("XGMqttChannel", "doActionWhenConnected");
        if (!Util.isNullOrEmptyString(GuidInfoManager.getToken(context))) {
            interfaceC0228b.a();
        } else {
            com.tencent.android.tpush.service.d.a(XGVipPushService.a()).d(new OnMqttCallback() { // from class: com.tencent.android.tpush.service.c.b.3
                @Override // com.tencent.tpns.mqttchannel.core.a.b
                public void callback(int i2, String str) {
                    if (i2 == 0 && (MqttConnectState.valueOf(str) == MqttConnectState.CONNECTED || MqttConnectState.valueOf(str) == MqttConnectState.SUBTOPICS)) {
                        interfaceC0228b.a();
                    } else {
                        com.tencent.android.tpush.service.d.a(XGVipPushService.a()).a(new OnMqttCallback() { // from class: com.tencent.android.tpush.service.c.b.3.1
                            @Override // com.tencent.tpns.mqttchannel.core.a.b
                            public void callback(int i3, String str2) {
                                if (i3 == 0) {
                                    interfaceC0228b.a();
                                    return;
                                }
                                InterfaceC0228b interfaceC0228b2 = interfaceC0228b;
                                interfaceC0228b2.a(i3, "mqtt connect error:" + str2);
                            }
                        });
                    }
                }
            });
        }
    }
}
