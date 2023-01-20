package com.tencent.tpns.mqttchannel.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.IMqttChannel;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import com.tencent.tpns.mqttchannel.core.common.data.Request;
import com.tencent.tpns.mqttchannel.core.common.inf.IMqttService;
import com.tencent.tpns.mqttchannel.services.MqttService;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c implements IMqttChannel {
    private Context a;
    private Intent b;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f6919c = Boolean.FALSE;

    /* renamed from: e  reason: collision with root package name */
    private ServiceConnection f6921e = null;

    /* renamed from: d  reason: collision with root package name */
    private volatile long f6920d = a();

    /* renamed from: com.tencent.tpns.mqttchannel.core.a.c$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends TTask {
        public final /* synthetic */ a b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6922c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ OnMqttCallback f6923d;
        public IMqttService a = null;

        /* renamed from: f  reason: collision with root package name */
        private ServiceConnection f6925f = new ServiceConnection() { // from class: com.tencent.tpns.mqttchannel.core.a.c.1.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("MqttChannelImpl", "doConnect - onServiceConnected");
                AnonymousClass1.this.a = IMqttService.Stub.a(iBinder);
                try {
                    if (AnonymousClass1.this.a != null) {
                        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.tpns.mqttchannel.core.a.c.1.1.1
                            @Override // com.tencent.tpns.baseapi.base.util.TTask
                            public void TRun() {
                                try {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    anonymousClass1.b.a(anonymousClass1.a);
                                } catch (Throwable th) {
                                    com.tencent.tpns.mqttchannel.core.common.a.a.a("MqttChannelImpl", AnonymousClass1.this.f6922c + "connectAction.action error:", th);
                                }
                            }
                        });
                    }
                    c.this.a.unbindService(this);
                } catch (Throwable unused) {
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                anonymousClass1.a = null;
                anonymousClass1.f6925f = null;
            }
        };

        public AnonymousClass1(a aVar, String str, OnMqttCallback onMqttCallback) {
            this.b = aVar;
            this.f6922c = str;
            this.f6923d = onMqttCallback;
        }

        @Override // com.tencent.tpns.baseapi.base.util.TTask
        public void TRun() {
            try {
                boolean bindService = c.this.a.bindService(c.this.b, this.f6925f, 1);
                com.tencent.tpns.mqttchannel.core.common.a.a.a("MqttChannelImpl", "actionName:" + this.f6922c + " bind MqttService:" + bindService);
            } catch (Throwable th) {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("MqttChannelImpl", this.f6922c + " -> bindService", th);
                OnMqttCallback onMqttCallback = this.f6923d;
                if (onMqttCallback != null) {
                    onMqttCallback.handleCallback(-1, this.f6922c + " error: bindService Error: " + th);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a(IMqttService iMqttService);
    }

    public c(Context context) {
        this.b = null;
        this.a = context.getApplicationContext();
        this.b = new Intent(this.a, MqttService.class);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void bindAccount(String str, OnMqttCallback onMqttCallback) {
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void getConnectState(final OnMqttCallback onMqttCallback) {
        a(new a() { // from class: com.tencent.tpns.mqttchannel.core.a.c.9
            @Override // com.tencent.tpns.mqttchannel.core.a.c.a
            public void a(IMqttService iMqttService) {
                if (iMqttService != null) {
                    iMqttService.getConnectState(onMqttCallback);
                }
            }
        }, "getConnectState", onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void ping(final OnMqttCallback onMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("MqttChannelImpl", "action - ping");
        try {
            this.a.startService(this.b);
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.a.a.e("MqttChannelImpl", "MqttChannel startService failed, ex:" + th);
            Util.stopWakeCpu();
        }
        if (!this.f6919c.booleanValue()) {
            try {
                ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.tencent.tpns.mqttchannel.core.a.c.6
                    @Override // android.content.ServiceConnection
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                    }
                };
                this.f6921e = serviceConnection;
                this.f6919c = Boolean.valueOf(this.a.bindService(this.b, serviceConnection, 1));
            } catch (Throwable th2) {
                com.tencent.tpns.mqttchannel.core.common.a.a.e("MqttChannelImpl", "MqttChannel bindService failed, ex:" + th2);
                Util.stopWakeCpu();
            }
        }
        a(new a() { // from class: com.tencent.tpns.mqttchannel.core.a.c.7
            @Override // com.tencent.tpns.mqttchannel.core.a.c.a
            public void a(IMqttService iMqttService) {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("MqttChannelImpl", "ping doConnect action");
                if (iMqttService != null) {
                    iMqttService.ping(onMqttCallback);
                } else {
                    Util.stopWakeCpu();
                }
            }
        }, "ping", onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void sendPublishData(String str, String str2, final OnMqttCallback onMqttCallback) {
        if (str2 == null) {
            if (onMqttCallback != null) {
                onMqttCallback.handleCallback(ErrCode.INNER_ERROR_JSON, "sendPublishData content not alow to null");
                return;
            }
            return;
        }
        long j2 = this.f6920d + 1;
        this.f6920d = j2;
        final Request request = new Request(j2, str, str2);
        request.type = 5;
        a(new a() { // from class: com.tencent.tpns.mqttchannel.core.a.c.11
            @Override // com.tencent.tpns.mqttchannel.core.a.c.a
            public void a(IMqttService iMqttService) {
                if (iMqttService != null) {
                    iMqttService.sendPublishData(request, onMqttCallback);
                }
            }
        }, "sendPublishData", onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void sendRequest(String str, JSONObject jSONObject, final OnMqttCallback onMqttCallback) {
        if (jSONObject == null) {
            if (onMqttCallback != null) {
                onMqttCallback.handleCallback(ErrCode.INNER_ERROR_JSON, "sendRequest jsonParm not alow to null");
                return;
            }
            return;
        }
        long j2 = this.f6920d + 1;
        this.f6920d = j2;
        onMqttCallback.requestId = j2;
        final Request request = new Request(j2, str, jSONObject.toString());
        request.type = 6;
        a(new a() { // from class: com.tencent.tpns.mqttchannel.core.a.c.10
            @Override // com.tencent.tpns.mqttchannel.core.a.c.a
            public void a(IMqttService iMqttService) {
                if (iMqttService != null) {
                    iMqttService.sendRequest(request, onMqttCallback);
                }
            }
        }, "sendRequest", onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void startConnect(final OnMqttCallback onMqttCallback) {
        try {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("MqttChannelImpl", "action - startConnect, start MqttService");
            this.a.startService(this.b);
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.a.a.e("MqttChannelImpl", "MqttChannel startService failed, ex:" + th);
        }
        if (!this.f6919c.booleanValue()) {
            try {
                ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.tencent.tpns.mqttchannel.core.a.c.4
                    @Override // android.content.ServiceConnection
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    }

                    @Override // android.content.ServiceConnection
                    public void onServiceDisconnected(ComponentName componentName) {
                    }
                };
                this.f6921e = serviceConnection;
                this.f6919c = Boolean.valueOf(this.a.bindService(this.b, serviceConnection, 1));
            } catch (Throwable th2) {
                com.tencent.tpns.mqttchannel.core.common.a.a.e("MqttChannelImpl", "MqttChannel bindService failed, ex:" + th2);
            }
        }
        a(new a() { // from class: com.tencent.tpns.mqttchannel.core.a.c.5
            @Override // com.tencent.tpns.mqttchannel.core.a.c.a
            public void a(IMqttService iMqttService) {
                if (iMqttService != null) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.a("MqttChannelImpl", "doConnect action on startConnect");
                    iMqttService.startConnect(onMqttCallback);
                }
            }
        }, "startConnect", onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void stopConnect(final OnMqttCallback onMqttCallback) {
        a(new a() { // from class: com.tencent.tpns.mqttchannel.core.a.c.8
            @Override // com.tencent.tpns.mqttchannel.core.a.c.a
            public void a(IMqttService iMqttService) {
                if (iMqttService != null) {
                    iMqttService.stopConnect(onMqttCallback);
                }
            }
        }, "stopConnect", onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void subscrbie(String str, final OnMqttCallback onMqttCallback) {
        long j2 = this.f6920d + 1;
        this.f6920d = j2;
        final Request request = new Request(j2, str, null);
        request.type = 1;
        a(new a() { // from class: com.tencent.tpns.mqttchannel.core.a.c.2
            @Override // com.tencent.tpns.mqttchannel.core.a.c.a
            public void a(IMqttService iMqttService) {
                if (iMqttService != null) {
                    iMqttService.subscrbie(request, onMqttCallback);
                }
            }
        }, "subscrbie", onMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void unBindAccount(OnMqttCallback onMqttCallback) {
    }

    @Override // com.tencent.tpns.mqttchannel.api.IMqttChannel
    public void unSubscrbie(String str, final OnMqttCallback onMqttCallback) {
        long j2 = this.f6920d + 1;
        this.f6920d = j2;
        final Request request = new Request(j2, str, null);
        request.type = 3;
        a(new a() { // from class: com.tencent.tpns.mqttchannel.core.a.c.3
            @Override // com.tencent.tpns.mqttchannel.core.a.c.a
            public void a(IMqttService iMqttService) {
                if (iMqttService != null) {
                    iMqttService.unSubscrbie(request, onMqttCallback);
                }
            }
        }, "unSubscrbie", onMqttCallback);
    }

    private long a() {
        return (((System.currentTimeMillis() % 100000000000L) * 1000) + (Process.myPid() % 1000)) * 1000;
    }

    private void a(a aVar, String str, OnMqttCallback onMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("MqttChannelImpl", "action - doConnect, actionName:" + str);
        CommonWorkingThread.getInstance().execute(new AnonymousClass1(aVar, str, onMqttCallback));
    }
}
