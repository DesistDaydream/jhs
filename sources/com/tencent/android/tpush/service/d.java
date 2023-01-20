package com.tencent.android.tpush.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.os.RemoteException;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import com.tencent.tpns.mqttchannel.core.common.data.Request;
import com.tencent.tpns.mqttchannel.core.services.MqttServiceImpl;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class d {
    private static d a;
    private static MqttServiceImpl b;

    /* renamed from: c */
    private static Context f6275c;

    /* renamed from: d */
    private volatile long f6276d = b();

    private d(MqttServiceImpl mqttServiceImpl) {
        b = mqttServiceImpl;
        if (f6275c == null) {
            f6275c = XGPushManager.getContext();
        }
        if (f6275c == null) {
            f6275c = b.e();
        }
    }

    public void c(OnMqttCallback onMqttCallback) {
        MqttServiceImpl mqttServiceImpl = b;
        if (mqttServiceImpl == null) {
            TLogger.e("SingleMqttServiceImpl", "Already stopped connect");
            return;
        }
        try {
            mqttServiceImpl.getIMqttService().stopConnect(onMqttCallback);
        } catch (RemoteException e2) {
            TLogger.e("SingleMqttServiceImpl", "", e2);
        }
    }

    public void d(final OnMqttCallback onMqttCallback) {
        MqttServiceImpl mqttServiceImpl = b;
        if (mqttServiceImpl == null) {
            try {
                BroadcastAgent.registerReceiver(f6275c, new BroadcastReceiver() { // from class: com.tencent.android.tpush.service.d.3
                    {
                        d.this = this;
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        try {
                            if (d.b == null) {
                                MqttServiceImpl unused = d.b = XGVipPushService.a();
                            }
                            d.b.getIMqttService().getConnectState(onMqttCallback);
                            i.a(context, this);
                        } catch (Throwable th) {
                            TLogger.e("SingleMqttServiceImpl", "Receiver not registered exception error : ", th);
                        }
                    }
                }, new IntentFilter("com.tencent.android.xg.vip.action.SERVICE_START.V4"));
            } catch (Throwable th) {
                TLogger.e("SingleMqttServiceImpl", "Receiver not registered exception error : ", th);
            }
            b.a(b.e());
            return;
        }
        try {
            mqttServiceImpl.getIMqttService().getConnectState(onMqttCallback);
        } catch (RemoteException e2) {
            TLogger.e("SingleMqttServiceImpl", "", e2);
        }
    }

    public static synchronized d a(MqttServiceImpl mqttServiceImpl) {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d(mqttServiceImpl);
            }
            dVar = a;
        }
        return dVar;
    }

    public void b(final OnMqttCallback onMqttCallback) {
        MqttServiceImpl mqttServiceImpl = b;
        if (mqttServiceImpl == null) {
            try {
                BroadcastAgent.registerReceiver(f6275c, new BroadcastReceiver() { // from class: com.tencent.android.tpush.service.d.2
                    {
                        d.this = this;
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        try {
                            if (d.b == null) {
                                MqttServiceImpl unused = d.b = XGVipPushService.a();
                            }
                            d.b.getIMqttService().ping(onMqttCallback);
                            i.a(context, this);
                        } catch (Throwable th) {
                            TLogger.e("SingleMqttServiceImpl", "Receiver not registered exception error : ", th);
                        }
                    }
                }, new IntentFilter("com.tencent.android.xg.vip.action.SERVICE_START.V4"));
            } catch (Throwable th) {
                TLogger.e("SingleMqttServiceImpl", "Receiver not registered exception error : ", th);
            }
            b.a(b.e());
            return;
        }
        try {
            mqttServiceImpl.getIMqttService().ping(onMqttCallback);
        } catch (RemoteException e2) {
            TLogger.e("SingleMqttServiceImpl", "", e2);
        }
    }

    public void a(final OnMqttCallback onMqttCallback) {
        MqttServiceImpl mqttServiceImpl = b;
        if (mqttServiceImpl == null) {
            try {
                BroadcastAgent.registerReceiver(f6275c, new BroadcastReceiver() { // from class: com.tencent.android.tpush.service.d.1
                    {
                        d.this = this;
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        try {
                            if (d.b == null) {
                                MqttServiceImpl unused = d.b = XGVipPushService.a();
                            }
                            d.b.getIMqttService().startConnect(onMqttCallback);
                            i.a(context, this);
                        } catch (Throwable th) {
                            TLogger.e("SingleMqttServiceImpl", "Receiver not registered exception error : ", th);
                        }
                    }
                }, new IntentFilter("com.tencent.android.xg.vip.action.SERVICE_START.V4"));
            } catch (Throwable th) {
                TLogger.e("SingleMqttServiceImpl", "Receiver not registered exception error : ", th);
            }
            b.a(b.e());
            return;
        }
        try {
            mqttServiceImpl.getIMqttService().startConnect(onMqttCallback);
        } catch (RemoteException e2) {
            TLogger.e("SingleMqttServiceImpl", "", e2);
        }
    }

    private long b() {
        return (((System.currentTimeMillis() % 100000000000L) * 1000) + (Process.myPid() % 1000)) * 1000;
    }

    public void a(String str, JSONObject jSONObject, final OnMqttCallback onMqttCallback) {
        try {
            if (jSONObject == null) {
                if (onMqttCallback != null) {
                    onMqttCallback.handleCallback(ErrCode.INNER_ERROR_JSON, "sendRequest jsonParm not alow to null");
                    return;
                }
                return;
            }
            long j2 = this.f6276d + 1;
            this.f6276d = j2;
            onMqttCallback.requestId = j2;
            final Request request = new Request(j2, str, jSONObject.toString());
            request.type = 6;
            MqttServiceImpl mqttServiceImpl = b;
            if (mqttServiceImpl == null) {
                BroadcastAgent.registerReceiver(f6275c, new BroadcastReceiver() { // from class: com.tencent.android.tpush.service.d.4
                    {
                        d.this = this;
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        try {
                            if (d.b == null) {
                                MqttServiceImpl unused = d.b = XGVipPushService.a();
                            }
                            d.b.getIMqttService().sendRequest(request, onMqttCallback);
                            i.a(context, this);
                        } catch (Throwable th) {
                            TLogger.e("SingleMqttServiceImpl", "Receiver not registered exception error : ", th);
                        }
                    }
                }, new IntentFilter("com.tencent.android.xg.vip.action.SERVICE_START.V4"));
                b.a(b.e());
                return;
            }
            try {
                mqttServiceImpl.getIMqttService().sendRequest(request, onMqttCallback);
            } catch (RemoteException e2) {
                TLogger.e("SingleMqttServiceImpl", "", e2);
            }
        } catch (Throwable th) {
            TLogger.e("SingleMqttServiceImpl", "", th);
        }
    }

    public void a(String str, String str2, final OnMqttCallback onMqttCallback) {
        try {
            if (str2 == null) {
                if (onMqttCallback != null) {
                    onMqttCallback.handleCallback(ErrCode.INNER_ERROR_JSON, "sendPublishData content not alow to null");
                    return;
                }
                return;
            }
            long j2 = this.f6276d + 1;
            this.f6276d = j2;
            final Request request = new Request(j2, str, str2);
            request.type = 5;
            MqttServiceImpl mqttServiceImpl = b;
            if (mqttServiceImpl == null) {
                BroadcastAgent.registerReceiver(f6275c, new BroadcastReceiver() { // from class: com.tencent.android.tpush.service.d.5
                    {
                        d.this = this;
                    }

                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        try {
                            if (d.b == null) {
                                MqttServiceImpl unused = d.b = XGVipPushService.a();
                            }
                            d.b.getIMqttService().sendPublishData(request, onMqttCallback);
                            i.a(context, this);
                        } catch (Throwable th) {
                            TLogger.e("SingleMqttServiceImpl", "Receiver not registered exception error : ", th);
                        }
                    }
                }, new IntentFilter("com.tencent.android.xg.vip.action.SERVICE_START.V4"));
                b.a(b.e());
                return;
            }
            try {
                mqttServiceImpl.getIMqttService().sendPublishData(request, onMqttCallback);
            } catch (RemoteException e2) {
                TLogger.e("SingleMqttServiceImpl", "", e2);
            }
        } catch (Throwable th) {
            TLogger.e("SingleMqttServiceImpl", "", th);
        }
    }
}
