package com.tencent.tpns.mqttchannel.core.services;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.util.Pair;
import com.baidu.mobads.sdk.internal.bp;
import com.moor.imkf.lib.jobqueue.base.JobManager;
import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttDeliveryToken;
import com.tencent.android.tpns.mqtt.IMqttToken;
import com.tencent.android.tpns.mqtt.MqttAsyncClient;
import com.tencent.android.tpns.mqtt.MqttCallbackExtended;
import com.tencent.android.tpns.mqtt.MqttMessage;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpush.common.Constants;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import com.tencent.tpns.mqttchannel.api.MqttConnectState;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;
import com.tencent.tpns.mqttchannel.core.common.data.Request;
import com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback;
import com.tencent.tpns.mqttchannel.core.common.inf.IMqttService;
import com.tencent.tpns.mqttchannel.services.BaseMqttClientService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class IMqttServiceImpl extends IMqttService.Stub implements MqttCallbackExtended {

    /* renamed from: m */
    private Context f6943m;
    private boolean o;
    private boolean r;
    private volatile int u;
    private volatile int v;
    private BaseMqttClientService w;

    /* renamed from: c */
    private static long f6933c = System.currentTimeMillis();

    /* renamed from: d */
    private static boolean f6934d = true;

    /* renamed from: e */
    private static ExecutorService f6935e = Executors.newSingleThreadExecutor();

    /* renamed from: l */
    private static int f6936l = 4;
    private static ConcurrentHashMap<Long, IMqttCallback> y = new ConcurrentHashMap<>();
    public static int b = 0;

    /* renamed from: f */
    private volatile MqttAsyncClient f6937f = null;

    /* renamed from: g */
    private volatile MqttConnectState f6938g = MqttConnectState.DISCONNECTED;

    /* renamed from: h */
    private volatile int f6939h = 0;

    /* renamed from: i */
    private volatile int f6940i = 0;

    /* renamed from: j */
    private volatile int f6941j = 0;

    /* renamed from: k */
    private volatile int[] f6942k = {4, 16, 32, 64, 128};
    private Map<Long, Pair<IMqttCallback, TTask>> n = new ConcurrentHashMap();
    private Class p = null;
    private Handler q = null;
    private boolean s = false;
    private boolean t = false;
    private List<IMqttCallback> x = new CopyOnWriteArrayList();
    private Queue<Request> z = new ConcurrentLinkedQueue();
    private long A = 0;
    private volatile boolean B = false;
    public Object a = new Object();
    private ReentrantLock C = new ReentrantLock();

    /* renamed from: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl$10 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass10 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            a = iArr;
            try {
                iArr[a.CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum a {
        CONNECTED,
        CONNECTING,
        IDLE,
        STOPED,
        UNKNOWN
    }

    /* loaded from: classes3.dex */
    public class b extends TTask {
        public IMqttCallback a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(IMqttCallback iMqttCallback, int i2) {
            super("tpns-mqtt" + i2);
            IMqttServiceImpl.this = r2;
            this.a = iMqttCallback;
        }

        @Override // com.tencent.tpns.baseapi.base.util.TTask
        public void TRun() {
            if (IMqttServiceImpl.this.a(this.a, true) && !IMqttServiceImpl.this.d(this.a)) {
                com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "CreateMqttAsyncClientAndConnect failed");
            }
        }
    }

    public IMqttServiceImpl(Context context) {
        this.r = false;
        this.f6943m = context;
        this.o = a(context);
        this.r = GuidInfoManager.isServerDestroy(context);
        e();
        this.u = GuidInfoManager.getEncryptLevel(context);
        com.tencent.tpns.mqttchannel.core.common.a.a.c("IMqttServiceImpl", "init IMqttServiceImpl encryptLevel: " + this.u + ", compressLevel: " + this.v);
        if (this.q == null) {
            o();
        }
        g();
    }

    public static /* synthetic */ int j(IMqttServiceImpl iMqttServiceImpl) {
        int i2 = iMqttServiceImpl.f6940i;
        iMqttServiceImpl.f6940i = i2 + 1;
        return i2;
    }

    public synchronized void m() {
        int i2;
        int recons = CloudManager.getInstance(this.f6943m).getRecons();
        if (recons <= 0) {
            recons = f6936l;
        }
        this.f6939h++;
        if (this.f6939h <= recons && this.f6940i <= f6936l) {
            Message obtainMessage = this.q.obtainMessage(1);
            this.q.removeMessages(1);
            int max = Math.max(this.f6939h, this.f6940i);
            if (max > this.f6942k.length) {
                i2 = this.f6942k[this.f6942k.length - 1];
            } else {
                i2 = this.f6942k[max - 1];
            }
            long j2 = i2 * 1000;
            if (DeviceInfos.isScreenOn(this.f6943m) || DeviceInfos.getChangedStatus(this.f6943m) > 0) {
                j2 /= 2;
            }
            this.q.sendMessageDelayed(obtainMessage, j2);
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "tryReConnect -> retryCount:" + this.f6939h + ", subRetryCount:" + this.f6940i + ", delay:" + j2);
        } else {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "tryReConnect too times, give up connect retryCount: " + this.f6939h + ", sub retryCount: " + this.f6940i);
            if (!f6934d && System.currentTimeMillis() - f6933c <= 1800000) {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "get offline msg by HTTP time not reached");
            }
            ArrayList<String> b2 = b(this.f6943m);
            if (b2 != null && b2.size() != 0) {
                f6934d = false;
                f6933c = System.currentTimeMillis();
                Iterator<String> it = b2.iterator();
                while (it.hasNext()) {
                    Request request = new Request(0L, "/_xg/push/" + XGApiConfig.getAccessId(this.f6943m) + MqttTopic.TOPIC_LEVEL_SEPARATOR + GuidInfoManager.getToken(this.f6943m), it.next());
                    this.w.onMessageArrived(request.getTopic(), request.getContent());
                }
            }
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "can't get any offline msg");
        }
    }

    public synchronized void n() {
        String[] strArr;
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - initAfterConnected, encryptLevel:" + this.u);
        if (this.f6937f != null && this.f6937f.getClientId() != null) {
            if (this.u == 1) {
                strArr = this.v == 1 ? new String[]{com.tencent.tpns.mqttchannel.core.common.a.b.g(this.f6943m, this.f6937f.getClientId()), com.tencent.tpns.mqttchannel.core.common.a.b.h(this.f6943m, this.f6937f.getClientId())} : new String[]{com.tencent.tpns.mqttchannel.core.common.a.b.c(this.f6943m, this.f6937f.getClientId()), com.tencent.tpns.mqttchannel.core.common.a.b.d(this.f6943m, this.f6937f.getClientId())};
            } else {
                strArr = this.v == 1 ? new String[]{com.tencent.tpns.mqttchannel.core.common.a.b.e(this.f6943m, this.f6937f.getClientId()), com.tencent.tpns.mqttchannel.core.common.a.b.f(this.f6943m, this.f6937f.getClientId())} : new String[]{com.tencent.tpns.mqttchannel.core.common.a.b.a(this.f6943m, this.f6937f.getClientId()), com.tencent.tpns.mqttchannel.core.common.a.b.b(this.f6943m, this.f6937f.getClientId())};
            }
            this.f6937f.subscribe(strArr, new int[]{1, 1}, (Object) null, new IMqttActionListener() { // from class: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.6
                {
                    IMqttServiceImpl.this = this;
                }

                @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                public void onFailure(IMqttToken iMqttToken, Throwable th) {
                    IMqttServiceImpl.j(IMqttServiceImpl.this);
                    IMqttServiceImpl.this.stopConnect(null);
                    IMqttServiceImpl.this.m();
                    com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "subscribe INIT TOPIC error: ", th);
                }

                @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                public void onSuccess(IMqttToken iMqttToken) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "subscribe INIT TOPIC success");
                    IMqttServiceImpl.this.f6940i = 0;
                    IMqttServiceImpl.this.f6938g = MqttConnectState.SUBTOPICS;
                    IMqttServiceImpl.this.t();
                }
            });
        }
    }

    @SuppressLint({"HandlerLeak"})
    private void o() {
        if (this.q != null) {
            return;
        }
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "initHandler");
        this.q = new Handler() { // from class: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.7
            {
                IMqttServiceImpl.this = this;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message != null) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "handler cmd: " + message.what);
                    int i2 = message.what;
                    if (i2 == 1) {
                        if (com.tencent.tpns.mqttchannel.core.common.a.b.a(IMqttServiceImpl.this.f6943m)) {
                            IMqttServiceImpl.this.b((IMqttCallback) null);
                        } else {
                            com.tencent.tpns.mqttchannel.core.common.a.a.c("IMqttServiceImpl", "net Work is not alive, stop connect");
                        }
                    } else if (i2 == 2) {
                        IMqttServiceImpl.this.startConnect(null);
                    } else if (i2 == 1006) {
                        IMqttServiceImpl.this.p();
                    } else if (i2 == 1010) {
                        IMqttServiceImpl.this.a(1010, message);
                    } else if (i2 == 1011) {
                        try {
                            IMqttServiceImpl.this.h();
                        } catch (Throwable th) {
                            com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "handle HANDLER_SEND_PING error " + message.what + ": " + th.toString());
                        }
                    } else {
                        switch (i2) {
                            case 1001:
                                IMqttServiceImpl.this.a(1001, message);
                                return;
                            case 1002:
                                IMqttServiceImpl.this.a(1002, message);
                                return;
                            case 1003:
                                IMqttServiceImpl.this.a(1003, message);
                                return;
                            default:
                                com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "unknown handler msg = " + message.what);
                                return;
                        }
                    }
                }
            }
        };
    }

    public void p() {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "handlePingTimeOut");
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.9
            {
                IMqttServiceImpl.this = this;
            }

            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                IMqttServiceImpl.this.r();
            }
        });
    }

    private boolean q() {
        return this.B;
    }

    public void r() {
        if (q()) {
            return;
        }
        try {
            if (this.C.isLocked()) {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "Handling ping failed, return this time");
                try {
                    this.C.unlock();
                    Util.stopWakeCpu();
                    return;
                } catch (Exception unused) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "pingLock Exception");
                    return;
                }
            }
            this.C.lock();
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "handlePingFailed");
            stopConnect(null);
            if (s()) {
                startConnect(null);
            }
            try {
                this.C.unlock();
                Util.stopWakeCpu();
            } catch (Exception unused2) {
                com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "pingLock Exception");
            }
        } catch (Throwable th) {
            try {
                this.C.unlock();
                Util.stopWakeCpu();
            } catch (Exception unused3) {
                com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "pingLock Exception");
            }
            throw th;
        }
    }

    private boolean s() {
        NetworkInfo activeNetworkInfo;
        if (Util.checkPermission(this.f6943m, "android.permission.INTERNET") && Util.checkPermission(this.f6943m, "android.permission.ACCESS_NETWORK_STATE")) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.f6943m.getSystemService("connectivity");
                if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                    if (activeNetworkInfo.isConnected()) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public synchronized void t() {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "Action : sendCachedMessage");
        com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "Cache message length: " + this.z.size());
        while (true) {
            Request poll = this.z.poll();
            if (poll != null) {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "Action : sendCachedMessage " + poll);
                a(poll);
            }
        }
    }

    @Override // com.tencent.android.tpns.mqtt.MqttCallbackExtended
    public void connectComplete(boolean z, String str) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "connectComplete: " + str + ", reconnect:" + z);
        this.w.onConnectComplete(z);
    }

    @Override // com.tencent.android.tpns.mqtt.MqttCallback
    public void connectionLost(Throwable th) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "connectionLost, cause:" + th + " retryCount:" + this.f6939h);
        th.printStackTrace();
        this.f6938g = MqttConnectState.DISCONNECTED;
        this.w.onConnectionLost();
        m();
    }

    @Override // com.tencent.android.tpns.mqtt.MqttCallback
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - deliveryComplete");
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
    public void getConnectState(IMqttCallback iMqttCallback) {
        a(iMqttCallback, 0, this.f6938g.toString());
    }

    @Override // com.tencent.android.tpns.mqtt.MqttCallback
    public void messageArrived(String str, MqttMessage mqttMessage) {
        byte[] payload;
        byte[] payload2;
        if (mqttMessage == null) {
            com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived mqttMessage null");
        } else if (!com.tencent.tpns.mqttchannel.core.common.a.b.i(this.f6943m, str) && !com.tencent.tpns.mqttchannel.core.common.a.b.k(this.f6943m, str) && !com.tencent.tpns.mqttchannel.core.common.a.b.m(this.f6943m, str) && !com.tencent.tpns.mqttchannel.core.common.a.b.o(this.f6943m, str)) {
            if (com.tencent.tpns.mqttchannel.core.common.a.b.p(this.f6943m, str)) {
                byte[] decryptSrvData = Security.decryptSrvData(mqttMessage.getPayload());
                if (decryptSrvData == null) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived push message decrypt failed");
                    return;
                }
                payload2 = CommonHelper.decodeGZipContent(decryptSrvData);
                if (payload2 == null) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived push message unzip after decrypt failed");
                    return;
                }
            } else if (com.tencent.tpns.mqttchannel.core.common.a.b.n(this.f6943m, str)) {
                payload2 = CommonHelper.decodeGZipContent(mqttMessage.getPayload());
                if (payload2 == null) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived push message unzip failed");
                    return;
                }
            } else if (com.tencent.tpns.mqttchannel.core.common.a.b.l(this.f6943m, str)) {
                payload2 = Security.decryptSrvData(mqttMessage.getPayload());
                if (payload2 == null) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived push message decrypt failed");
                    return;
                }
            } else {
                payload2 = mqttMessage.getPayload();
            }
            String str2 = new String(payload2);
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "MessageArrived, topic :" + str + ", payload:" + str2);
            Request request = new Request(0L, str, str2);
            this.w.onMessageArrived(request.getTopic(), request.getContent());
        } else {
            try {
                if (com.tencent.tpns.mqttchannel.core.common.a.b.o(this.f6943m, str)) {
                    byte[] decryptSrvData2 = Security.decryptSrvData(mqttMessage.getPayload());
                    if (decryptSrvData2 == null) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived rpc response decrypt failed");
                        return;
                    }
                    payload = CommonHelper.decodeGZipContent(decryptSrvData2);
                    if (payload == null) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived rpc response unzip after decrypt failed");
                        return;
                    }
                } else if (com.tencent.tpns.mqttchannel.core.common.a.b.m(this.f6943m, str)) {
                    payload = CommonHelper.decodeGZipContent(mqttMessage.getPayload());
                    if (payload == null) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived rpc response unzip failed");
                        return;
                    }
                } else if (com.tencent.tpns.mqttchannel.core.common.a.b.k(this.f6943m, str)) {
                    payload = Security.decryptSrvData(mqttMessage.getPayload());
                    if (payload == null) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived rpc response decrypt failed");
                        return;
                    }
                } else {
                    payload = mqttMessage.getPayload();
                }
                String str3 = new String(payload);
                com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "MessageArrived, rpc topic :" + str + ", payload:" + str3);
                JSONObject jSONObject = new JSONObject(str3);
                long j2 = jSONObject.getLong("id");
                int optInt = jSONObject.optInt("ret", 0);
                String optString = jSONObject.optString("result", "");
                Pair<IMqttCallback, TTask> remove = this.n.remove(Long.valueOf(j2));
                if (remove != null) {
                    CommonWorkingThread.getInstance().getHandler().removeCallbacks((Runnable) remove.second);
                    a((IMqttCallback) remove.first, optInt, optString);
                    return;
                }
                com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "Not found the rpc Request id");
            } catch (Throwable th) {
                com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "messageArrived handle RpcReceiveTopic throw JSONException " + th.toString() + ", payload: " + new String(mqttMessage.getPayload()));
            }
        }
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
    public void ping(IMqttCallback iMqttCallback) {
        i();
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
    public void sendPublishData(Request request, IMqttCallback iMqttCallback) {
        if (request.getId() > 0) {
            a(1001, request);
        }
        b(request, iMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
    public void sendRequest(Request request, IMqttCallback iMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - sendRequest");
        if (!this.r && !this.s && !this.t) {
            if (request.getId() > 0) {
                a(1010, request);
            }
            if (this.u == 1) {
                if (this.v == 1) {
                    a(request, iMqttCallback, "_xg/rpc/send/gzip_aes");
                    return;
                } else {
                    a(request, iMqttCallback, "_xg/rpc/send/aes");
                    return;
                }
            } else if (this.v == 1) {
                a(request, iMqttCallback, "_xg/rpc/send/gzip");
                return;
            } else {
                a(request, iMqttCallback, "_xg/rpc/send");
                return;
            }
        }
        f(iMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
    public void startConnect(IMqttCallback iMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - startConnect");
        b(iMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
    public void stopConnect(final IMqttCallback iMqttCallback) {
        synchronized (this) {
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "stopConnect");
            if (this.f6938g != MqttConnectState.CONNECTED && this.f6938g != MqttConnectState.CONNECTING && this.f6938g != MqttConnectState.SUBTOPICS) {
                com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "Mqtt is not conneted");
                a(iMqttCallback, 0, "Mqtt is not conneted");
            } else if (this.f6937f == null) {
                com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "stopConnect error: mqttAsyncClient is null");
                a(iMqttCallback, ErrCode.MQTT_DISCONNECT_FAIL_NULL, "stopConnect error: mqttAsyncClient is null");
            } else {
                this.f6938g = MqttConnectState.DISCONNECTING;
                this.f6937f.disconnect(com.heytap.mcssdk.constant.a.q, null, new IMqttActionListener() { // from class: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.15
                    {
                        IMqttServiceImpl.this = this;
                    }

                    @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                    public void onFailure(IMqttToken iMqttToken, Throwable th) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "stopConnect -> callback onFailure:", th);
                        IMqttServiceImpl.this.f6938g = MqttConnectState.DISCONNECTED;
                        IMqttServiceImpl.this.l();
                        IMqttServiceImpl iMqttServiceImpl = IMqttServiceImpl.this;
                        IMqttCallback iMqttCallback2 = iMqttCallback;
                        iMqttServiceImpl.a(iMqttCallback2, -6, "stopConnect onFailure: " + th.toString());
                    }

                    @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                    public void onSuccess(IMqttToken iMqttToken) {
                        IMqttServiceImpl.this.f6938g = MqttConnectState.DISCONNECTED;
                        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "disconnect success");
                        IMqttServiceImpl.this.l();
                        IMqttServiceImpl.this.a(iMqttCallback, 0, bp.o);
                    }
                });
            }
        }
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
    public void subscrbie(Request request, IMqttCallback iMqttCallback) {
        if (request.getId() > 0) {
            a(1002, request);
        }
        c(request, iMqttCallback);
    }

    @Override // com.tencent.tpns.mqttchannel.core.common.inf.IMqttService
    public void unSubscrbie(Request request, IMqttCallback iMqttCallback) {
        if (request.getId() > 0) {
            a(1003, request);
        }
        d(request, iMqttCallback);
    }

    private void e() {
        int refuseRate = GuidInfoManager.getRefuseRate(this.f6943m);
        if (refuseRate > 0 && new Random().nextInt(100) < refuseRate) {
            this.s = true;
            com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "Resources exceeded Limit, refuse this connect!");
            return;
        }
        this.s = false;
    }

    private a f() {
        if (this.f6937f == null) {
            return a.IDLE;
        }
        if (this.f6937f.isConnected() && (this.f6938g == MqttConnectState.CONNECTED || this.f6938g == MqttConnectState.SUBTOPICS)) {
            return a.CONNECTED;
        }
        if (this.f6937f.isConnecting()) {
            return a.CONNECTING;
        }
        return a.STOPED;
    }

    private void g() {
        try {
            if (this.q == null) {
                o();
            }
            CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.1
                {
                    IMqttServiceImpl.this = this;
                }

                @Override // com.tencent.tpns.baseapi.base.util.TTask
                public void TRun() {
                    int keepAliveInterval = MqttConfigImpl.getKeepAliveInterval(IMqttServiceImpl.this.f6943m);
                    com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "ping starRtc at " + keepAliveInterval);
                    Message message = new Message();
                    message.what = 1011;
                    IMqttServiceImpl.this.q.sendMessageDelayed(message, (long) (keepAliveInterval * 1000));
                    com.tencent.tpns.mqttchannel.core.common.a.b.b(IMqttServiceImpl.this.f6943m);
                }
            });
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "schedulePing failed ", th);
        }
    }

    public void h() {
        try {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "startNextPing");
            if (this.q == null) {
                o();
            }
            CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.11
                {
                    IMqttServiceImpl.this = this;
                }

                @Override // com.tencent.tpns.baseapi.base.util.TTask
                public void TRun() {
                    int keepAliveInterval = MqttConfigImpl.getKeepAliveInterval(IMqttServiceImpl.this.f6943m);
                    Message message = new Message();
                    message.what = 1011;
                    IMqttServiceImpl.this.q.sendMessageDelayed(message, keepAliveInterval * 1000);
                    com.tencent.tpns.mqttchannel.core.common.a.b.b(IMqttServiceImpl.this.f6943m);
                }
            });
            Util.getWakeCpu(this.f6943m);
            ping(null);
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "startNextPing error: " + th.toString());
        }
    }

    private void i() {
        a f2 = f();
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - ping: " + f2);
        try {
            int i2 = AnonymousClass10.a[f2.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    startConnect(null);
                    Util.stopWakeCpu();
                } else {
                    com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "The client is connecting");
                    Util.stopWakeCpu();
                }
            } else if (Math.abs(System.currentTimeMillis() - this.A) < 15000) {
            } else {
                j();
                b();
                this.f6937f.ping(new IMqttActionListener() { // from class: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.12
                    {
                        IMqttServiceImpl.this = this;
                    }

                    @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                    public void onFailure(IMqttToken iMqttToken, Throwable th) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "Ping onFailure", th);
                        IMqttServiceImpl.this.k();
                        IMqttServiceImpl.this.r();
                    }

                    @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                    public void onSuccess(IMqttToken iMqttToken) {
                        IMqttServiceImpl.this.k();
                        com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "Ping succeed");
                        IMqttServiceImpl.this.A = System.currentTimeMillis();
                        Util.stopWakeCpu();
                    }
                });
            }
        } catch (Throwable th) {
            k();
            Util.stopWakeCpu();
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "ping", th);
        }
    }

    private void j() {
        this.q.removeMessages(1006);
        this.q.sendEmptyMessageDelayed(1006, com.heytap.mcssdk.constant.a.q);
    }

    public void k() {
        this.q.removeMessages(1006);
    }

    public void l() {
        try {
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "destroyMqttClient");
            this.f6937f.destroy();
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "stopConnect close error:", th);
        }
        this.f6938g = MqttConnectState.DISCONNECTED;
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.16
            {
                IMqttServiceImpl.this = this;
            }

            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                if (XGApiConfig.isEnableService(IMqttServiceImpl.this.f6943m)) {
                    return;
                }
                Process.killProcess(Process.myPid());
            }
        });
    }

    private synchronized void d() {
        for (IMqttCallback iMqttCallback : this.x) {
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "callAllConnectBackFailed");
            a(iMqttCallback, ErrCode.INNER_ERROR_TOKEN_NULL, "connect failed beacuse token is null");
        }
    }

    private IMqttCallback b(Long l2) {
        boolean z = false;
        try {
            Iterator<Request> it = this.z.iterator();
            while (it.hasNext()) {
                if (l2.longValue() == it.next().getId()) {
                    it.remove();
                    z = true;
                }
            }
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "removeCacheMessages", th);
        }
        if (!z) {
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "removeCacheMessages error id " + l2);
        }
        return a(l2);
    }

    private synchronized void c() {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - callAllConnectBackSuccess");
        if (!com.tencent.tpns.mqttchannel.core.common.a.b.a(GuidInfoManager.getToken(this.f6943m))) {
            for (IMqttCallback iMqttCallback : this.x) {
                com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "callAllBackSucess");
                a(iMqttCallback, 0, bp.o);
            }
        } else {
            d();
        }
        this.x.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x01cd, code lost:
        a(r11, -5, "getFinalMqttServerAddrAndGuidInfo GUID is null");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean d(final com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback r11) {
        /*
            Method dump skipped, instructions count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.d(com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback):boolean");
    }

    public void e(IMqttCallback iMqttCallback) {
        if (iMqttCallback != null && this.x.remove(iMqttCallback)) {
            com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "remove old callback success");
        }
        c();
    }

    private void f(IMqttCallback iMqttCallback) {
        if (this.r) {
            com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "MQTTThread: Resources have been destroyed");
            a(iMqttCallback, -3, "connect onFailure: Resources have been destroyed");
        } else if (this.s) {
            com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "MQTTThread: Resources exceeded limit");
            a(iMqttCallback, -4, "connect onFailure: Resources exceeded limit");
        } else if (this.t) {
            com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "MQTTThread: Resources have been destroyed by cloud");
            a(iMqttCallback, -4, "connect onFailure: Resources have been destroyed by cloud");
        }
    }

    private synchronized void a(IMqttCallback iMqttCallback) {
        if (this.x.size() > 100) {
            this.x.remove(0);
        }
        this.x.add(iMqttCallback);
    }

    public void b(final IMqttCallback iMqttCallback) {
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.13
            {
                IMqttServiceImpl.this = this;
            }

            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                IMqttServiceImpl.this.c(iMqttCallback);
            }
        });
    }

    private Request c(Long l2) {
        for (Request request : this.z) {
            if (l2.longValue() == request.getId()) {
                return request;
            }
        }
        return null;
    }

    private void b(final Request request, final IMqttCallback iMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - sendRealPublishData");
        int i2 = AnonymousClass10.a[f().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                a(request, iMqttCallback);
                startConnect(null);
                return;
            }
            a(request, iMqttCallback);
            return;
        }
        try {
            if (this.f6937f.getClientId() == null) {
                a(iMqttCallback, ErrCode.INNER_ERROR_TOKEN_NULL, "sendPublishData token is null");
                return;
            }
            request.setToken(this.f6937f.getClientId());
            MqttMessage mqttMessage = new MqttMessage(request.getContent().getBytes());
            mqttMessage.setQos(1);
            this.f6937f.publish(request.getTopic(), mqttMessage, (Object) null, new IMqttActionListener() { // from class: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.3
                {
                    IMqttServiceImpl.this = this;
                }

                @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                public void onFailure(IMqttToken iMqttToken, Throwable th) {
                    IMqttServiceImpl.this.b(1001, request);
                    com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "sendPublishData -> callback onFailure:", th);
                    IMqttServiceImpl iMqttServiceImpl = IMqttServiceImpl.this;
                    IMqttCallback iMqttCallback2 = iMqttCallback;
                    iMqttServiceImpl.a(iMqttCallback2, -8, "sendPublishData onFailure: " + th.toString());
                }

                @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                public void onSuccess(IMqttToken iMqttToken) {
                    IMqttServiceImpl.this.b(1001, request);
                    com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "sendPublishData success, body: " + request.getContent());
                    IMqttServiceImpl.this.a(iMqttCallback, 0, bp.o);
                }
            });
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "sendPublishData error MqttException ", th);
            a(iMqttCallback, ErrCode.MQTT_SEND_PUB_ERROR, "sendPublishData error: " + th);
        }
    }

    public void c(IMqttCallback iMqttCallback) {
        if (f() == a.CONNECTED) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "Action:restartConnectThread - CONNECTED");
            if (iMqttCallback != null) {
                a(iMqttCallback, 0, bp.o);
            }
        } else if (a(iMqttCallback, true)) {
            f6935e.execute(new b(iMqttCallback, 0));
        }
    }

    private static void a(Long l2, IMqttCallback iMqttCallback) {
        try {
            if (y.size() > 2000) {
                ArrayList arrayList = new ArrayList(y.keySet());
                Collections.sort(arrayList);
                y.remove(arrayList.get(0));
            }
            y.put(l2, iMqttCallback);
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "putTagAliasCallback", th);
        }
    }

    private void c(final Request request, final IMqttCallback iMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - subscrbieReal");
        int i2 = AnonymousClass10.a[f().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                a(request, iMqttCallback);
                startConnect(null);
                return;
            }
            a(request, iMqttCallback);
            return;
        }
        try {
            this.f6937f.subscribe(request.getTopic(), 1, (Object) null, new IMqttActionListener() { // from class: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.4
                {
                    IMqttServiceImpl.this = this;
                }

                @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                public void onFailure(IMqttToken iMqttToken, Throwable th) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "subscrbie -> callback onFailure:", th);
                    IMqttServiceImpl iMqttServiceImpl = IMqttServiceImpl.this;
                    IMqttCallback iMqttCallback2 = iMqttCallback;
                    iMqttServiceImpl.a(iMqttCallback2, -9, "subscribe onFailure: " + th.toString());
                    IMqttServiceImpl.this.b(1002, request);
                }

                @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                public void onSuccess(IMqttToken iMqttToken) {
                    IMqttServiceImpl.this.a(iMqttCallback, 0, bp.o);
                    IMqttServiceImpl.this.b(1002, request);
                }
            });
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "subscrbie error MqttException ", th);
            a(iMqttCallback, ErrCode.MQTT_SUB_ERROR, "subscrbie error " + th);
        }
    }

    private static IMqttCallback a(Long l2) {
        try {
            return y.remove(l2);
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "getTagAliasCallback", th);
            return null;
        }
    }

    private void a(Request request, IMqttCallback iMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "addCacheMessage " + request);
        try {
            this.z.offer(request);
            if (this.z.size() > 100) {
                this.z.poll();
            }
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "addCacheMessage", th);
        }
        if (request.getId() <= 0 || iMqttCallback == null) {
            return;
        }
        a(Long.valueOf(request.getId()), iMqttCallback);
    }

    public void b() {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "onHeartBeat ");
        if (this.f6937f != null && !this.f6937f.isConnected()) {
            com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "onHeartBeat: mqttAsyncClient not connect!");
            this.f6938g = MqttConnectState.DISCONNECTED;
            b((IMqttCallback) null);
        }
        this.w.onHeartBeat();
    }

    public IMqttServiceImpl(Context context, BaseMqttClientService baseMqttClientService) {
        this.r = false;
        this.f6943m = context;
        this.w = baseMqttClientService;
        this.o = a(context);
        this.r = GuidInfoManager.isServerDestroy(context);
        e();
        this.u = GuidInfoManager.getEncryptLevel(context);
        com.tencent.tpns.mqttchannel.core.common.a.a.c("IMqttServiceImpl", "init IMqttServiceImpl encryptLevel: " + this.u + ", compressLevel: " + this.v);
        if (this.q == null) {
            o();
        }
        g();
    }

    private boolean a(Context context) {
        try {
            this.p = Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            Intent intent = new Intent(context, this.p);
            intent.setPackage(context.getPackageName());
            try {
                List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 512);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "Has Xgpush!!!");
                    return true;
                }
                com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "No Xgpush, querey intent info is null or empty");
                return false;
            } catch (Throwable unused) {
                com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "No Xgpush, querey intent fail");
                return false;
            }
        } catch (Throwable unused2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "No Xgpush, Not found xgpush class");
            return false;
        }
    }

    public void b(int i2, Request request) {
        this.q.removeMessages(i2, request);
        b(Long.valueOf(request.getId()));
    }

    private ArrayList<String> b(Context context) {
        if (!Util.checkAccessId(XGApiConfig.getAccessId(context)) || !Util.checkAccessKey(XGApiConfig.getAccessKey(context)) || com.tencent.tpns.mqttchannel.core.common.a.b.a(GuidInfoManager.getToken(context)) || CloudManager.getInstance(context).disablePullMsg()) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        long accessId = XGApiConfig.getAccessId(context);
        String accessKey = XGApiConfig.getAccessKey(context);
        try {
            jSONObject.put("accessId", accessId);
            jSONObject.put("accessKey", accessKey);
            jSONObject.put("deviceType", 0);
            jSONObject.put(com.heytap.mcssdk.constant.b.C, "1.3.5.0");
            jSONObject.put("seq", currentTimeMillis);
            String token = GuidInfoManager.getToken(context);
            if (token != null) {
                jSONObject.put("token", token);
            }
            JSONArray jSONArray = new JSONArray();
            String notifiedMsgIds = Util.getNotifiedMsgIds(context, accessId);
            if (notifiedMsgIds != null && notifiedMsgIds.length() > 0) {
                for (String str : notifiedMsgIds.split(context.getPackageName() + TIMMentionEditText.TIM_MENTION_TAG)) {
                    try {
                        jSONArray.put(Long.parseLong(str.substring(1)));
                    } catch (Throwable unused) {
                    }
                }
            }
            jSONObject.put("recMsgIdList", jSONArray);
            jSONObject.put("protocolVersion", 1);
            String offlineMsg = CommonHelper.getOfflineMsg(context, XGApiConfig.getOfflineMsgServerAddr(context), jSONObject.toString(), null);
            if (offlineMsg != null && offlineMsg.length() > 0) {
                try {
                    JSONObject jSONObject2 = new JSONObject(offlineMsg);
                    int optInt = jSONObject2.optInt("retCode");
                    if (optInt != 0) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "get offline msg error with retCode: " + optInt + ", msg: " + jSONObject2.optString("msg"));
                        return null;
                    }
                    JSONArray optJSONArray = jSONObject2.optJSONArray("msgList");
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (optJSONArray == null) {
                        com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "no offline msg send to this package");
                    } else {
                        com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "get offline msg number: " + optJSONArray.length());
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            arrayList.add(optJSONArray.optJSONObject(i2).toString());
                        }
                    }
                    return arrayList;
                } catch (Throwable th) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "parse offline msg response error: ", th);
                    return null;
                }
            }
            com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "get offline msg http request error");
            return null;
        } catch (Throwable th2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "generate offline msg request error: ", th2);
            return null;
        }
    }

    public boolean a(IMqttCallback iMqttCallback, boolean z) {
        com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "doMqttConnect -> try connect, state: " + this.f6938g);
        if (this.f6938g != MqttConnectState.CONNECTED && this.f6938g != MqttConnectState.SUBTOPICS) {
            if (z && q()) {
                com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "doMqttConnect -> Mqtt is connecting, give up");
                if (iMqttCallback != null) {
                    a(iMqttCallback);
                }
                return false;
            }
            return true;
        }
        com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "doMqttConnect -> Mqtt already connected, give up");
        if (iMqttCallback != null) {
            a(iMqttCallback, 0, bp.o);
        }
        return false;
    }

    public void a(final Request request, final IMqttCallback iMqttCallback, final String str) {
        byte[] bytes;
        String jSONObject;
        String jSONObject2;
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - sendRealRequest");
        int i2 = AnonymousClass10.a[f().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                a(request, iMqttCallback);
                startConnect(null);
                return;
            }
            a(request, iMqttCallback);
        } else if (this.f6938g != MqttConnectState.SUBTOPICS) {
            com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "sub topic not finish!");
            a(request, iMqttCallback);
        } else if (this.f6937f.getClientId() == null) {
            a(iMqttCallback, ErrCode.INNER_ERROR_TOKEN_NULL, "sendRealRequest token is null");
        } else {
            request.setToken(this.f6937f.getClientId());
            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "sendRequest " + request);
            final JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("id", request.getId());
                jSONObject3.put(Constants.MQTT_STATISTISC_MSGTYPE_KEY, request.getTopic());
                jSONObject3.put("paramsMd5", request.getParamsMd5());
                jSONObject3.put("params", new JSONObject(request.getContent()));
                TTask tTask = new TTask() { // from class: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.17
                    {
                        IMqttServiceImpl.this = this;
                    }

                    @Override // com.tencent.tpns.baseapi.base.util.TTask
                    public void TRun() {
                        IMqttServiceImpl.this.n.remove(Long.valueOf(request.getId()));
                        request.addRetryCount();
                        if (request.getRetryCount() <= 1) {
                            com.tencent.tpns.mqttchannel.core.common.a.a.b("IMqttServiceImpl", "sendRealRequest timeout and retry, request:" + request);
                            IMqttServiceImpl.this.a(request, iMqttCallback, str);
                        } else if (request.isSent) {
                            IMqttServiceImpl.this.a(iMqttCallback, -2, "Waiting for server response timeout!");
                        } else {
                            IMqttServiceImpl.this.a(iMqttCallback, (int) ErrCode.MQTT_SEND_REQ_TIMEOUT, "sendRequest timeout!");
                        }
                    }
                };
                this.n.put(Long.valueOf(request.getId()), new Pair<>(iMqttCallback, tTask));
                CommonWorkingThread.getInstance().execute(tTask, com.heytap.mcssdk.constant.a.q);
                try {
                    if (str.equals("_xg/rpc/send/gzip_aes")) {
                        byte[] encodeGZipContent = CommonHelper.encodeGZipContent(jSONObject3.toString().getBytes());
                        if (encodeGZipContent == null) {
                            a(iMqttCallback, ErrCode.MQTT_SEND_REQ_COMPRESS_FAIL, "sendRequest " + request.getTopic() + " compress failed");
                            return;
                        }
                        com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "gzip mqtt request size before: " + jSONObject2.length() + ", after: " + encodeGZipContent.length);
                        bytes = Security.encryptSrvData(encodeGZipContent);
                        if (bytes == null) {
                            a(iMqttCallback, ErrCode.MQTT_SEND_REQ_ENCRYPT_FAIL, "sendRequest " + request.getTopic() + " encrypt failed");
                            return;
                        }
                    } else if (str.equals("_xg/rpc/send/gzip")) {
                        byte[] encodeGZipContent2 = CommonHelper.encodeGZipContent(jSONObject3.toString().getBytes());
                        if (encodeGZipContent2 == null) {
                            a(iMqttCallback, ErrCode.MQTT_SEND_REQ_COMPRESS_FAIL, "sendRequest " + request.getTopic() + " compress failed");
                            return;
                        }
                        com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "gzip mqtt request size before: " + jSONObject.length() + ", after: " + encodeGZipContent2.length);
                        bytes = encodeGZipContent2;
                    } else if (str.equals("_xg/rpc/send/aes")) {
                        bytes = Security.encryptSrvData(jSONObject3.toString().getBytes());
                        if (bytes == null) {
                            a(iMqttCallback, ErrCode.MQTT_SEND_REQ_ENCRYPT_FAIL, "sendRequest " + request.getTopic() + " encrypt failed");
                            return;
                        }
                    } else {
                        bytes = jSONObject3.toString().getBytes();
                    }
                    MqttMessage mqttMessage = new MqttMessage(bytes);
                    mqttMessage.setQos(1);
                    this.f6937f.publish(str, mqttMessage, (Object) null, new IMqttActionListener() { // from class: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.18
                        {
                            IMqttServiceImpl.this = this;
                        }

                        @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                        public void onFailure(IMqttToken iMqttToken, Throwable th) {
                            IMqttServiceImpl.this.b(1010, request);
                            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "sendRequest -> callback onFailure:", th);
                            Pair pair = (Pair) IMqttServiceImpl.this.n.remove(Long.valueOf(request.getId()));
                            if (pair != null) {
                                CommonWorkingThread.getInstance().getHandler().removeCallbacks((Runnable) pair.second);
                                IMqttServiceImpl iMqttServiceImpl = IMqttServiceImpl.this;
                                IMqttCallback iMqttCallback2 = iMqttCallback;
                                iMqttServiceImpl.a(iMqttCallback2, -7, "sendRequest onFailure: " + th.toString());
                                return;
                            }
                            com.tencent.tpns.mqttchannel.core.common.a.a.d("IMqttServiceImpl", "onFailure but Not found the rpc Request id");
                        }

                        @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                        public void onSuccess(IMqttToken iMqttToken) {
                            request.isSent = true;
                            IMqttServiceImpl.this.f6941j = 0;
                            IMqttServiceImpl.this.b(1010, request);
                            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "sendRequest onSuccess topic:" + str + " body: " + jSONObject3.toString());
                        }
                    });
                } catch (Throwable th) {
                    b(1010, request);
                    com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "sendRequest error MqttException ", th);
                    Pair<IMqttCallback, TTask> remove = this.n.remove(Long.valueOf(request.getId()));
                    if (remove != null) {
                        CommonWorkingThread.getInstance().getHandler().removeCallbacks((Runnable) remove.second);
                        if (this.f6941j >= 1) {
                            a(iMqttCallback, ErrCode.MQTT_SEND_REQ_ERROR, "sendRequest error: " + th.toString());
                            return;
                        }
                        this.f6941j++;
                        com.tencent.tpns.mqttchannel.core.common.a.a.c("IMqttServiceImpl", "stop connect and retry sendRequest");
                        stopConnect(new OnMqttCallback() { // from class: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.2
                            {
                                IMqttServiceImpl.this = this;
                            }

                            @Override // com.tencent.tpns.mqttchannel.core.a.b
                            public void callback(int i3, String str2) {
                                IMqttServiceImpl.this.sendRequest(request, iMqttCallback);
                            }
                        });
                    }
                }
            } catch (JSONException e2) {
                b(1010, request);
                a(iMqttCallback, ErrCode.INNER_ERROR_JSON, "sendRealRequest JSONException: " + e2);
            }
        }
    }

    private void d(final Request request, final IMqttCallback iMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - unSubscrbieReal");
        int i2 = AnonymousClass10.a[f().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                a(request, iMqttCallback);
                startConnect(null);
                return;
            }
            a(request, iMqttCallback);
            return;
        }
        try {
            this.f6937f.unsubscribe(request.getTopic(), (Object) null, new IMqttActionListener() { // from class: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.5
                {
                    IMqttServiceImpl.this = this;
                }

                @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                public void onFailure(IMqttToken iMqttToken, Throwable th) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "unSubscrbie -> callback onFailure:", th);
                    IMqttServiceImpl.this.b(1003, request);
                    IMqttServiceImpl iMqttServiceImpl = IMqttServiceImpl.this;
                    IMqttCallback iMqttCallback2 = iMqttCallback;
                    iMqttServiceImpl.a(iMqttCallback2, -10, "unSubscrbie onFailure: " + th.toString());
                }

                @Override // com.tencent.android.tpns.mqtt.IMqttActionListener
                public void onSuccess(IMqttToken iMqttToken) {
                    IMqttServiceImpl.this.b(1003, request);
                    IMqttServiceImpl.this.a(iMqttCallback, 0, bp.o);
                }
            });
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "subscrbie error MqttException ", th);
            a(iMqttCallback, -1001, "unSubscrbie error " + th);
        }
    }

    public void a(IMqttCallback iMqttCallback, int i2, String str) {
        if (iMqttCallback != null) {
            try {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - doCallback, code:" + i2 + ", message:" + str);
                iMqttCallback.handleCallback(i2, str);
            } catch (Throwable th) {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "Callback code:" + i2 + ", message:" + str + " RemoteException:", th);
            }
        }
    }

    private void a(int i2, Request request) {
        Message message = new Message();
        message.obj = request;
        message.what = i2;
        if (this.q.hasMessages(i2, Long.valueOf(request.getId()))) {
            return;
        }
        this.q.sendMessageDelayed(message, JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS);
    }

    public void a(int i2, Message message) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "handleTimeOut " + i2 + " obj : " + message.obj);
        try {
            long id = ((Request) message.obj).getId();
            Request c2 = c(Long.valueOf(id));
            if (c2 != null && c2.type == 6) {
                this.n.remove(Long.valueOf(c2.getId()));
            }
            final IMqttCallback b2 = b(Long.valueOf(id));
            if (b2 != null) {
                f6935e.execute(new Runnable() { // from class: com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl.8
                    {
                        IMqttServiceImpl.this = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IMqttServiceImpl.this.a(b2, (int) ErrCode.MQTT_CONNECT_TIMEOUT, "Mqtt is not connected, timeout");
                    }
                });
            }
        } catch (Throwable th) {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "Unknown msg " + i2, th);
        }
    }

    public synchronized void a(boolean z) {
        this.B = z;
    }

    private void a(Request request) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("IMqttServiceImpl", "action - handMQTTMsg");
        switch (request.type) {
            case 1:
                c(request, a(Long.valueOf(request.getId())));
                return;
            case 2:
                b(request, a(Long.valueOf(request.getId())));
                return;
            case 3:
                d(request, a(Long.valueOf(request.getId())));
                return;
            case 4:
                return;
            case 5:
                b(request, a(Long.valueOf(request.getId())));
                return;
            case 6:
                IMqttCallback a2 = a(Long.valueOf(request.getId()));
                if (this.u == 1) {
                    if (this.v == 1) {
                        a(request, a2, "_xg/rpc/send/gzip_aes");
                        return;
                    } else {
                        a(request, a2, "_xg/rpc/send/aes");
                        return;
                    }
                } else if (this.v == 1) {
                    a(request, a2, "_xg/rpc/send/gzip");
                    return;
                } else {
                    a(request, a2, "_xg/rpc/send");
                    return;
                }
            default:
                com.tencent.tpns.mqttchannel.core.common.a.a.e("IMqttServiceImpl", "Error type of MQTTMessage");
                return;
        }
    }
}
