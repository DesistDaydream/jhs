package com.tencent.android.tpush.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Process;
import android.text.TextUtils;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.ReturnCode;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.protocol.m;
import com.tencent.android.tpush.service.protocol.n;
import com.tencent.android.tpush.service.protocol.r;
import com.tencent.android.tpush.service.util.f;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.device.GuidInfoManager;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.CacheHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.mqttchannel.api.MqttConfig;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import com.umeng.analytics.pro.am;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.INTENTCHECK})
/* loaded from: classes3.dex */
public class a {
    private static a a;
    private static volatile C0226a b;

    /* renamed from: c */
    private static volatile c f6189c;

    /* renamed from: d */
    private static volatile d f6190d;

    /* renamed from: e */
    private volatile boolean f6191e = false;

    /* renamed from: f */
    private ArrayList<Intent> f6192f = new ArrayList<>();

    /* renamed from: com.tencent.android.tpush.service.a$a */
    /* loaded from: classes3.dex */
    public class C0226a extends BroadcastReceiver {
        private C0226a() {
            a.this = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TLogger.d("PushServiceBroadcastHandler", "PackageChangesReceiver - onReceiver");
            if (intent == null || context == null) {
                return;
            }
            if (!a.this.f6191e) {
                if (a.this.f6192f.size() < 10) {
                    a.this.f6192f.add(intent);
                    TLogger.ii("PushServiceBroadcastHandler", "PackageChangesReceiver add intend to beforeInitedIntents,action:" + intent.getAction() + ", size:" + a.this.f6192f.size());
                    return;
                }
                TLogger.ee("PushServiceBroadcastHandler", "Too much beforeInitedIntents. discard it");
                return;
            }
            CommonWorkingThread.getInstance().execute(new b(context, intent));
        }
    }

    @JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.INTENTCHECK})
    /* loaded from: classes3.dex */
    public class b extends TTask {
        private Context b;

        /* renamed from: c */
        private Intent f6229c;

        public b(Context context, Intent intent) {
            a.this = r1;
            this.b = null;
            this.f6229c = null;
            this.b = context;
            this.f6229c = intent;
        }

        @Override // com.tencent.tpns.baseapi.base.util.TTask
        public void TRun() {
            try {
                String action = this.f6229c.getAction();
                if (action == null) {
                    return;
                }
                String replace = action.replace(this.b.getPackageName(), "");
                TLogger.d("PushServiceBroadcastHandler", "PushServiceRannable, intent action:" + replace);
                if (!"android.intent.action.PACKAGE_ADDED".equals(replace) && !"android.intent.action.PACKAGE_REPLACED".equals(replace)) {
                    if (!"android.intent.action.PACKAGE_REMOVED".equals(replace)) {
                        if ("com.tencent.android.xg.vip.action.REGISTER.V4".equals(replace)) {
                            a.this.b(this.b, this.f6229c);
                        } else if ("com.tencent.android.xg.vip.action.UNREGISTER.V4".equals(replace)) {
                            a.this.g(this.b, this.f6229c);
                        } else if ("com.tencent.android.xg.vip.action.ENABLE_DEBUG.V4".equals(replace)) {
                            a.this.k(this.b, this.f6229c);
                        } else if ("com.tencent.android.xg.vip.action.SET_HTINTERVALMS.V4".equals(replace)) {
                            a.this.j(this.b, this.f6229c);
                        } else if (!"com.tencent.android.xg.vip.action.MSG_ACK.V4".equals(replace)) {
                            if ("com.tencent.android.xg.vip.action.ACCOUNT.V4".equals(replace)) {
                                a.this.c(this.b, this.f6229c);
                            } else if ("com.tencent.android.xg.vip.action.TAG.V4".equals(replace)) {
                                a.this.f(this.b, this.f6229c);
                            } else if ("com.tencent.android.xg.vip.action.QUERYTAGS.V4".equals(replace)) {
                                a.this.e(this.b, this.f6229c);
                            } else if (!"com.tencent.android.xg.vip.action.PUSH_CLICK.RESULT.V4".equals(replace) && !"com.tencent.android.xg.vip.action.PUSH_CANCELLED.RESULT.V4".equals(replace) && !"com.tencent.android.xg.vip.action.ack.sdk2srv.V4".equals(replace)) {
                                if ("com.tencent.android.xg.vip.action.UPDATE_OTHER_PUSH_TOKEN.V4".equals(replace)) {
                                    a.this.h(this.b, this.f6229c);
                                } else if ("com.tencent.android.xg.vip.action.COMM_REPORT.V4".equals(replace)) {
                                    a.this.i(this.b, this.f6229c);
                                } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(replace)) {
                                    NetworkInfo networkInfo = (NetworkInfo) this.f6229c.getParcelableExtra("networkInfo");
                                    if (networkInfo == null) {
                                        return;
                                    }
                                    TLogger.d("PushServiceBroadcastHandler", "Connection state changed to --- " + networkInfo.toString());
                                    if (!this.f6229c.getBooleanExtra("noConnectivity", false)) {
                                        if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                                            TLogger.v("PushServiceBroadcastHandler", "network connected and start XGService 3s later");
                                            com.tencent.android.tpush.service.b.a(this.b, 3000L);
                                        } else if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
                                            TLogger.v("PushServiceBroadcastHandler", "Network is disconnected.");
                                            com.tencent.android.tpush.service.d.a(XGVipPushService.a()).c(null);
                                        } else {
                                            TLogger.v("PushServiceBroadcastHandler", "other network state - " + networkInfo.getState() + ". Do nothing.");
                                        }
                                    }
                                } else if ("com.tencent.android.xg.vip.action.FLUSH.V4".equals(replace)) {
                                    TBaseLogger.flush(new TBaseLogger.WriteFileCallback() { // from class: com.tencent.android.tpush.service.a.b.1
                                        {
                                            b.this = this;
                                        }

                                        @Override // com.tencent.tpns.baseapi.base.logger.TBaseLogger.WriteFileCallback
                                        public void onFinished() {
                                            TLogger.ii("PushServiceBroadcastHandler", "xg process log flush finished");
                                            String decrypt = Rijndael.decrypt(b.this.f6229c.getStringExtra(Constants.FLAG_PACK_NAME));
                                            if (TextUtils.isEmpty(decrypt) || !decrypt.equals(b.this.b.getPackageName())) {
                                                return;
                                            }
                                            BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), new Intent("com.tencent.android.xg.vip.action.FLUSH.RESULT.V4"));
                                        }
                                    });
                                } else if ("com.tencent.android.xg.vip.action.ATTRIBUTE.V4".equals(replace)) {
                                    a.this.d(this.b, this.f6229c);
                                } else if ("com.tencent.android.xg.vip.action.KILLSERVICEPROCESS.V4".equals(replace)) {
                                    TLogger.d("PushServiceBroadcastHandler", "receive kill process");
                                    com.tencent.android.tpush.service.b.b().c();
                                    Process.killProcess(Process.myPid());
                                }
                            }
                        }
                    }
                }
                a.this.a(this.b, this.f6229c);
            } catch (Throwable th) {
                TLogger.e("PushServiceBroadcastHandler", "PushServiceBroadcastHandler run error.", th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BroadcastReceiver {
        private c() {
            a.this = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TLogger.d("PushServiceBroadcastHandler", "TPushAppReceiver - onReceiver");
            if (intent == null || context == null) {
                return;
            }
            if (!a.this.f6191e) {
                if (a.this.f6192f.size() < 10) {
                    a.this.f6192f.add(intent);
                    TLogger.ii("PushServiceBroadcastHandler", "TPushAppReceiver add intend to beforeInitedIntents,action:" + intent.getAction() + ", size:" + a.this.f6192f.size());
                    return;
                }
                TLogger.ee("PushServiceBroadcastHandler", "Too much beforeInitedIntents. discard it");
                return;
            }
            CommonWorkingThread.getInstance().execute(new b(context, intent));
        }
    }

    /* loaded from: classes3.dex */
    public class d extends BroadcastReceiver {
        public long a;

        private d() {
            a.this = r3;
            this.a = 0L;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context context, Intent intent) {
            if (intent == null || context == null) {
                return;
            }
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                if (networkInfo == null) {
                    return;
                }
                TLogger.v("PushServiceBroadcastHandler", "Connection state changed to - " + networkInfo.toString());
                if (intent.getBooleanExtra("noConnectivity", false)) {
                    return;
                }
                if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                    TLogger.v("PushServiceBroadcastHandler", "Internl network connected and call MqttChannel.startConnect on 5s later");
                    CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.service.a.d.1
                        {
                            d.this = this;
                        }

                        @Override // com.tencent.tpns.baseapi.base.util.TTask
                        public void TRun() {
                            TLogger.dd("PushServiceBroadcastHandler", "Internl network connected, restart");
                            com.tencent.android.tpush.service.d.a(XGVipPushService.a()).a((OnMqttCallback) null);
                        }
                    }, 5000L);
                    return;
                } else if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
                    TLogger.v("PushServiceBroadcastHandler", "Network is disconnected.");
                    com.tencent.android.tpush.service.d.a(XGVipPushService.a()).c(null);
                    return;
                } else {
                    TLogger.v("PushServiceBroadcastHandler", "other network state - " + networkInfo.getState() + ". Do nothing.");
                    return;
                }
            }
            TLogger.d("PushServiceBroadcastHandler", "--UserPresentReceiver--");
            if (Math.abs(System.currentTimeMillis() - this.a) > 8000) {
                CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.service.a.d.2
                    {
                        d.this = this;
                    }

                    @Override // com.tencent.tpns.baseapi.base.util.TTask
                    public void TRun() {
                        TLogger.dd("PushServiceBroadcastHandler", "--start Connect UserPresentReceiver--");
                        com.tencent.android.tpush.service.d.a(XGVipPushService.a()).a((OnMqttCallback) null);
                        com.tencent.android.tpush.a.b(context);
                    }
                }, 2000L);
                this.a = System.currentTimeMillis();
            }
        }
    }

    private a() {
    }

    private static boolean a(Object obj) {
        return false;
    }

    public void d(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        final long longExtra = intent.getLongExtra("accId", -1L);
        String decrypt = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_ACC_KEY));
        final String decrypt2 = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_PACK_NAME));
        final int intExtra = intent.getIntExtra(Constants.FLAG_ATTRIBUTES_TYPE, -1);
        final String decrypt3 = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_ATTRIBUTES_NAME));
        final String stringExtra = intent.getStringExtra(Constants.FLAG_ATTRIBUTES_OPER_NAME);
        try {
            com.tencent.android.tpush.service.c.a().b(longExtra, decrypt, decrypt2, intExtra, decrypt3, new com.tencent.android.tpush.service.c.a() { // from class: com.tencent.android.tpush.service.a.5
                {
                    a.this = this;
                }

                @Override // com.tencent.android.tpush.service.c.a
                public void a(int i2, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    if (i2 == 0) {
                        TLogger.ii("PushServiceBroadcastHandler", "Set attributes ack success  [accId = " + longExtra + " ,attributesType = " + intExtra + " ,attributesName = " + decrypt3 + " ,packName = " + decrypt2 + "]");
                        a.this.a(i2, decrypt3, intExtra, decrypt2, stringExtra, str);
                        return;
                    }
                    TLogger.ee("PushServiceBroadcastHandler", "Set attributes ack failed with responseCode = " + i2 + " , attributesName = " + decrypt3);
                    a.this.a(i2, "服务器处理失败，返回错误", decrypt3, intExtra, decrypt2, stringExtra);
                }

                @Override // com.tencent.android.tpush.service.c.a
                public void b(int i2, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    TLogger.ee("PushServiceBroadcastHandler", "@@ attributesHandler onMessageSendFailed: " + i2 + ", " + str);
                    a.this.a(i2, str, decrypt3, intExtra, decrypt2, stringExtra);
                }
            });
        } catch (Throwable th) {
            TLogger.e("PushServiceBroadcastHandler", ">> attributes Handler error " + th);
        }
    }

    public void e(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        final long longExtra = intent.getLongExtra("accId", -1L);
        String decrypt = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_ACC_KEY));
        final String decrypt2 = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_PACK_NAME));
        final int intExtra = intent.getIntExtra("offset", -1);
        final int intExtra2 = intent.getIntExtra("limit", -1);
        final String stringExtra = intent.getStringExtra(Constants.FLAG_TAG_QUERY_TYPE);
        final String stringExtra2 = intent.getStringExtra(Constants.FLAG_QUERY_TAGS_OPER_NAME);
        try {
            com.tencent.android.tpush.service.c.a().a(longExtra, decrypt, decrypt2, intExtra, intExtra2, stringExtra, new com.tencent.android.tpush.service.c.a() { // from class: com.tencent.android.tpush.service.a.6
                {
                    a.this = this;
                }

                @Override // com.tencent.android.tpush.service.c.a
                public void a(int i2, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    if (i2 == 0) {
                        TLogger.ii("PushServiceBroadcastHandler", "Get tags ack success  [accId = " + longExtra + " , offset = " + intExtra + " , limit = " + intExtra2 + ", response = " + str + "]");
                        a.this.a(i2, intExtra, intExtra2, decrypt2, str, stringExtra2);
                        return;
                    }
                    TLogger.ee("PushServiceBroadcastHandler", "Set tag ack failed with responseCode = " + i2 + " , tagName = " + stringExtra);
                    a.this.b(i2, intExtra, intExtra2, decrypt2, str, stringExtra2);
                }

                @Override // com.tencent.android.tpush.service.c.a
                public void b(int i2, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    TLogger.ee("PushServiceBroadcastHandler", "@@ QueryTagsHandler onMessageSendFailed: " + i2 + ", " + str);
                    a.this.b(i2, intExtra, intExtra2, decrypt2, str, stringExtra2);
                }
            });
        } catch (Throwable th) {
            TLogger.e("PushServiceBroadcastHandler", ">> QueryTagsHandler error " + th);
            TLogger.e("PushServiceBroadcastHandler", ">> QueryTagsHandler error-> " + TLogger.getStackTraceString(th));
        }
    }

    public void f(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        final long longExtra = intent.getLongExtra("accId", -1L);
        String decrypt = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_ACC_KEY));
        final String decrypt2 = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_PACK_NAME));
        final int intExtra = intent.getIntExtra(Constants.FLAG_TAG_TYPE, -1);
        final String decrypt3 = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_TAG_NAME));
        final String stringExtra = intent.getStringExtra(Constants.FLAG_TAG_OPER_NAME);
        try {
            com.tencent.android.tpush.service.c.a().a(longExtra, decrypt, decrypt2, intExtra, decrypt3, new com.tencent.android.tpush.service.c.a() { // from class: com.tencent.android.tpush.service.a.7
                {
                    a.this = this;
                }

                @Override // com.tencent.android.tpush.service.c.a
                public void a(int i2, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    if (i2 == 0) {
                        TLogger.ii("PushServiceBroadcastHandler", "Set tag ack success  [accId = " + longExtra + " , tagtype = " + intExtra + " , tagName = " + decrypt3 + ", packName = " + decrypt2 + "]");
                        a.this.c(i2, decrypt3, intExtra, decrypt2, stringExtra);
                        return;
                    }
                    TLogger.ee("PushServiceBroadcastHandler", "Set tag ack failed with responseCode = " + i2 + " , tagName = " + decrypt3);
                    a.this.b(i2, "服务器处理失败，返回错误", decrypt3, intExtra, decrypt2, stringExtra);
                }

                @Override // com.tencent.android.tpush.service.c.a
                public void b(int i2, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    TLogger.ee("PushServiceBroadcastHandler", "@@ TagHandler onMessageSendFailed: " + i2 + ", " + str);
                    a.this.b(i2, str, decrypt3, intExtra, decrypt2, stringExtra);
                }
            });
        } catch (Throwable th) {
            TLogger.e("PushServiceBroadcastHandler", ">> TagHandler error " + th);
            TLogger.e("PushServiceBroadcastHandler", ">> TagHandler error-> " + TLogger.getStackTraceString(th));
        }
    }

    public void g(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        final String decrypt = Rijndael.decrypt(intent.getStringExtra("accId"));
        String decrypt2 = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_ACC_KEY));
        final String decrypt3 = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_PACK_NAME));
        String decrypt4 = Rijndael.decrypt(intent.getStringExtra("token"));
        CacheManager.UnregisterInfoByPkgName(decrypt3);
        try {
            com.tencent.android.tpush.service.c.a().a(decrypt4, com.tencent.android.tpush.service.util.a.a(), Long.parseLong(decrypt), decrypt2, decrypt3, new com.tencent.android.tpush.service.c.a() { // from class: com.tencent.android.tpush.service.a.8
                {
                    a.this = this;
                }

                @Override // com.tencent.android.tpush.service.c.a
                public void a(int i2, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    if (i2 == 0) {
                        TLogger.ii("PushServiceBroadcastHandler", ">> UnRegister ack with [accId = " + decrypt + " , packName = " + decrypt3 + " , rsp = ]");
                        a.this.a(i2, (r) dVar, decrypt3);
                        return;
                    }
                    TLogger.e("PushServiceBroadcastHandler", ">> unregeister ack failed responseCode=" + i2);
                    a.this.a(i2, "服务器处理失败，返回错误", (r) dVar, decrypt3);
                }

                @Override // com.tencent.android.tpush.service.c.a
                public void b(int i2, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    TLogger.e("PushServiceBroadcastHandler", "@@ unregister onMessageSendFailed " + i2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str);
                    a.this.a(i2, str, (r) dVar, decrypt3);
                }
            });
        } catch (Throwable th) {
            TLogger.e("PushServiceBroadcastHandler", ">>> unregister error " + th);
        }
    }

    public void h(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        final String decrypt = Rijndael.decrypt(intent.getStringExtra("accId"));
        String decrypt2 = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_ACC_KEY));
        final String decrypt3 = Rijndael.decrypt(intent.getStringExtra("token"));
        final String decrypt4 = Rijndael.decrypt(intent.getStringExtra("other_push_type"));
        final String decrypt5 = Rijndael.decrypt(intent.getStringExtra("other_push_token"));
        TLogger.i("PushServiceBroadcastHandler", "binding OtherPush token with accessId = " + decrypt + "  token = " + decrypt3 + " otherPushType = " + decrypt4 + " otherPushToken = " + decrypt5);
        com.tencent.android.tpush.service.c.a().a(Long.parseLong(decrypt), decrypt2, decrypt4, decrypt5, new com.tencent.android.tpush.service.c.a() { // from class: com.tencent.android.tpush.service.a.9
            {
                a.this = this;
            }

            @Override // com.tencent.android.tpush.service.c.a
            public void a(int i2, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                if (i2 == 0) {
                    TLogger.ii("PushServiceBroadcastHandler", ">> bind OtherPushToken success ack with [accessId = " + decrypt + "  , rsp = " + i2 + "]  token = " + decrypt3 + " otherPushType = " + decrypt4 + " otherPushToken = " + decrypt5);
                    a.this.b();
                    return;
                }
                TLogger.ee("PushServiceBroadcastHandler", ">> updateOtherPushToken ack failed responseCode=" + i2);
            }

            @Override // com.tencent.android.tpush.service.c.a
            public void b(int i2, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                TLogger.ee("PushServiceBroadcastHandler", "@@ updateOtherPushToken onMessageSendFailed " + i2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str);
            }
        });
    }

    public void i(final Context context, final Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        final String decrypt = Rijndael.decrypt(intent.getStringExtra("accessId"));
        final String stringExtra = intent.getStringExtra(PushClientConstants.TAG_PKG_NAME);
        com.tencent.android.tpush.service.c.a().a(intent, new com.tencent.android.tpush.service.c.a() { // from class: com.tencent.android.tpush.service.a.2
            {
                a.this = this;
            }

            @Override // com.tencent.android.tpush.service.c.a
            public void a(int i2, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                if (i2 == 0) {
                    TLogger.ii("PushServiceBroadcastHandler", ">> sendCommReportMessage ack with [accId = " + decrypt + "  , rsp = " + i2 + "]");
                    com.tencent.android.tpush.a.b(context, stringExtra, intent.toURI());
                    return;
                }
                TLogger.ee("PushServiceBroadcastHandler", ">> sendCommReportMessage ack failed responseCode=" + i2);
            }

            @Override // com.tencent.android.tpush.service.c.a
            public void b(int i2, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                TLogger.ee("PushServiceBroadcastHandler", "@@ sendCommReportMessage onMessageSendFailed " + i2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str);
            }
        });
    }

    public void j(Context context, Intent intent) {
        int intExtra;
        if (intent == null || context == null || (intExtra = intent.getIntExtra(am.aU, -1)) < 10 || intExtra >= 36000) {
            return;
        }
        MqttConfig.setKeepAliveInterval(context, intExtra);
    }

    public void k(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("debugMode", false);
        XGPushConfig.enableDebug = booleanExtra;
        TLogger.enableDebug(context, booleanExtra);
    }

    public synchronized void c(Context context) {
        this.f6192f.clear();
        if (context != null) {
            if (b != null) {
                i.a(context, b);
                b = null;
            }
            if (f6189c != null) {
                i.a(context, f6189c);
                f6189c = null;
            }
            if (f6190d != null) {
                i.a(context, f6190d);
                f6190d = null;
            }
        }
    }

    public synchronized void b(Context context) {
        TLogger.d("PushServiceBroadcastHandler", "action - registerReceiver");
        if (context != null) {
            if (b == null) {
                b = new C0226a();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addDataScheme("package");
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                BroadcastAgent.registerReceiver(context, b, intentFilter);
            }
            if (f6189c == null) {
                f6189c = new c();
                IntentFilter intentFilter2 = new IntentFilter();
                String packageName = context.getPackageName();
                intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.REGISTER.V4");
                intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.UNREGISTER.V4");
                intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.ENABLE_DEBUG.V4");
                intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.SET_HTINTERVALMS.V4");
                intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.MSG_ACK.V4");
                intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.ACCOUNT.V4");
                intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.TAG.V4");
                intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.QUERYTAGS.V4");
                intentFilter2.addAction("com.tencent.android.xg.vip.action.PUSH_CLICK.RESULT.V4");
                intentFilter2.addAction("com.tencent.android.xg.vip.action.PUSH_CANCELLED.RESULT.V4");
                intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.ack.sdk2srv.V4");
                intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.reserved.act.V4");
                intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.UPDATE_OTHER_PUSH_TOKEN.V4");
                intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.COMM_REPORT.V4");
                intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.FLUSH.V4");
                intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.ATTRIBUTE.V4");
                intentFilter2.addAction(packageName + "com.tencent.android.xg.vip.action.KILLSERVICEPROCESS.V4");
                BroadcastAgent.registerReceiver(context, f6189c, intentFilter2);
            }
            if (f6190d == null) {
                f6190d = new d();
                IntentFilter intentFilter3 = new IntentFilter();
                intentFilter3.addAction("android.intent.action.USER_PRESENT");
                intentFilter3.addAction("android.intent.action.SCREEN_ON");
                intentFilter3.addAction("android.intent.action.ACTION_POWER_CONNECTED");
                intentFilter3.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
                intentFilter3.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter3.addAction("android.intent.action.PACKAGE_REMOVED");
                intentFilter3.addAction("android.intent.action.PACKAGE_REPLACED");
                intentFilter3.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                context.getApplicationContext().registerReceiver(f6190d, intentFilter3);
            }
        }
    }

    public synchronized void a(Context context) {
        TLogger.ii("PushServiceBroadcastHandler", "handleServiceInited, beforeInitedIntents size:" + this.f6192f.size());
        this.f6191e = true;
        Intent intent = new Intent("com.tencent.android.xg.vip.action.SERVICE_START.V4");
        intent.putExtra("pkg", com.tencent.android.tpush.service.b.e().getPackageName());
        intent.putExtra("ver", "1.3.5.0");
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), intent);
        Iterator<Intent> it = this.f6192f.iterator();
        while (it.hasNext()) {
            TLogger.ii("PushServiceBroadcastHandler", "excute, beforeInitedIntents size:" + this.f6192f.size());
            CommonWorkingThread.getInstance().execute(new b(context, it.next()));
        }
        this.f6192f.clear();
    }

    public void c(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        final long longExtra = intent.getLongExtra("accId", -1L);
        String decrypt = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_ACC_KEY));
        final int intExtra = intent.getIntExtra(Constants.FLAG_ACCOUNT_OP_TYPE, -1);
        final String decrypt2 = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_ACCOUNT));
        final String stringExtra = intent.getStringExtra(Constants.FLAG_ACCOUNT_FEEDBACK);
        final String decrypt3 = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_PACK_NAME));
        try {
            com.tencent.android.tpush.service.c.a().a(longExtra, decrypt, decrypt2, intExtra, new com.tencent.android.tpush.service.c.a() { // from class: com.tencent.android.tpush.service.a.4
                {
                    a.this = this;
                }

                @Override // com.tencent.android.tpush.service.c.a
                public void a(int i2, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    if (i2 == 0) {
                        if (XGPushConfig.enableDebug) {
                            TLogger.d("PushServiceBroadcastHandler", ">> AccountHandler [accId = " + longExtra + ", packageNme: " + decrypt3 + "]");
                        }
                        a.this.b(i2, decrypt2, stringExtra, intExtra, decrypt3);
                        return;
                    }
                    TLogger.e("PushServiceBroadcastHandler", ">> AccountHandler ack fail responseCode = " + i2);
                    a.this.a(i2, "服务器处理失败，返回错误", decrypt2, stringExtra, intExtra, decrypt3);
                }

                @Override // com.tencent.android.tpush.service.c.a
                public void b(int i2, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    TLogger.ee("PushServiceBroadcastHandler", "@@ AccountHandler onMessageSendFailed: " + i2 + ", " + str);
                    a.this.a(i2, str, decrypt2, stringExtra, intExtra, decrypt3);
                }
            });
        } catch (Throwable th) {
            TLogger.e("PushServiceBroadcastHandler", ">> AccountHandler error " + th);
            TLogger.e("PushServiceBroadcastHandler", ">> AccountHandler error-> " + TLogger.getStackTraceString(th));
        }
    }

    public void c(int i2, String str, int i3, String str2, String str3) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.TAG.RESULT.V4");
        intent.putExtra("flag", i3);
        intent.putExtra("operation", 0);
        if (!i.b(str2)) {
            intent.setPackage(str2);
        }
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), intent);
        a(i2, str, i3, str2, str3);
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public void a(final Context context, Intent intent) {
        String dataString = intent.getDataString();
        if (dataString == null || context == null || !f.d(context, dataString.substring(8))) {
            return;
        }
        com.tencent.android.tpush.service.b.b().d();
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.service.a.1
            {
                a.this = this;
            }

            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                i.e(context);
            }
        }, 2000L);
    }

    private void a(int i2, String str, int i3, String str2) {
        if (i.b(str)) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.FLAG_ACCOUNT, str);
            jSONObject.put("accountType", i3);
            jSONArray.put(jSONObject);
            a(i2, jSONArray.toString(), str, 0, str2);
        } catch (Throwable th) {
            TLogger.ww("PushServiceBroadcastHandler", "getTypeAccountsJsonArrayStr:", th);
        }
    }

    public void a(int i2, String str, int i3, String str2, String str3, String str4) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.ATTRIBUTE.RESULT.V4");
        intent.putExtra("flag", i3);
        intent.putExtra("operation", 0);
        if (!i.b(str2)) {
            intent.setPackage(str2);
        }
        if (!i.b(str4)) {
            intent.putExtra("data", str4);
        }
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), intent);
        b(i2, str, i3, str2, str3);
    }

    public void b(final Context context, Intent intent) {
        final m a2 = m.a(context, intent, false);
        if (context == null || intent == null) {
            return;
        }
        try {
            com.tencent.android.tpush.service.c.a().a(context, a2, new com.tencent.android.tpush.service.c.a() { // from class: com.tencent.android.tpush.service.a.3
                {
                    a.this = this;
                }

                @Override // com.tencent.android.tpush.service.c.a
                public void a(int i2, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    if (i2 == 0) {
                        n nVar = new n();
                        try {
                            if (i.b(str)) {
                                str = i.e((String) CacheHelper.get(context, com.tencent.android.tpush.d.b.a.b()));
                            } else {
                                CacheHelper.set(context, com.tencent.android.tpush.d.b.a.b().set(i.f(str)));
                            }
                            nVar.a(str);
                            TLogger.dd("PushServiceBroadcastHandler", ">> Register onResponse [accId = " + a2.a + ", token:" + nVar.b + ", otherPushType:" + nVar.f6345d + ", otherToken:" + nVar.f6346e + " , packName = " + a2.J + "]");
                            m mVar = a2;
                            a.this.a(i2, nVar, (m) dVar, mVar.J, mVar.I, mVar.M);
                            XGApiConfig.setRegisterSuccess(context);
                            return;
                        } catch (Throwable unused) {
                            TLogger.ee("PushServiceBroadcastHandler", ">> Register onResponse fail, 解析返回内容格式错误 " + i2);
                            a.this.a((int) ErrCode.INNER_ERROR_JSON, "解析服务器返回内容失败", (m) dVar, a2.J);
                            return;
                        }
                    }
                    TLogger.ww("PushServiceBroadcastHandler", ">> Register ack fail, 服务器处理失败,返回错误; responseCode = " + i2);
                    a.this.a(i2, "服务器处理失败，返回错误", (m) dVar, a2.J);
                }

                @Override // com.tencent.android.tpush.service.c.a
                public void b(int i2, String str, com.tencent.android.tpush.service.protocol.d dVar) {
                    TLogger.ee("PushServiceBroadcastHandler", "@@ registetr onMessageSendFailed: " + i2 + ", " + str);
                    a.this.a(i2, str, (m) dVar, a2.J);
                }
            });
        } catch (Throwable th) {
            TLogger.e("PushServiceBroadcastHandler", ">> register error " + th);
            TLogger.e("PushServiceBroadcastHandler", ">> register error-> " + TLogger.getStackTraceString(th));
        }
    }

    public void a(int i2, String str, String str2, int i3, String str3, String str4) {
        TLogger.e("PushServiceBroadcastHandler", "attributesFailHandler failed with (" + i2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str3 + ")");
        Intent intent = new Intent("com.tencent.android.xg.vip.action.ATTRIBUTE.RESULT.V4");
        intent.putExtra("flag", i3);
        intent.putExtra("code", i2);
        intent.putExtra("msg", str);
        intent.putExtra("operation", 1);
        if (!i.b(str3)) {
            intent.setPackage(str3);
        }
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), intent);
        b(i2, str2, i3, str3, str4);
    }

    public void b() {
        try {
            Intent intent = new Intent("com.tencent.android.xg.vip.action.UPDATE.OTHER.TOKEN.RESULT.V4");
            intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
            intent.putExtra("operation", 0);
            intent.setPackage(com.tencent.android.tpush.service.b.e().getPackageName());
            BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), intent);
        } catch (Throwable th) {
            TLogger.ee("PushServiceBroadcastHandler", "updateOtherPushTokenSuccessHandler error: " + th.toString());
        }
    }

    private void b(int i2, String str, int i3, String str2, String str3) {
        Intent a2 = f.a(i2, str2, 7);
        a2.putExtra(Constants.FLAG_ATTRIBUTES_NAME, Rijndael.encrypt(str));
        a2.putExtra(Constants.FLAG_ATTRIBUTES_TYPE, i3);
        a2.putExtra(Constants.FLAG_ATTRIBUTES_OPER_NAME, str3);
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), a2);
    }

    private void a(int i2, m mVar, String str, String str2, long j2, String str3) {
        Intent a2 = f.a(i2, str2, 1);
        a2.putExtra("accId", mVar.a);
        if (str != null && str.length() != 0) {
            a2.putExtra("token", str);
        }
        String str4 = mVar.f6335e;
        if (str4 != null && str4.length() != 0) {
            a2.putExtra(Constants.FLAG_TICKET, mVar.f6335e);
            a2.putExtra(Constants.FLAG_TICKET_TYPE, mVar.f6336f);
        }
        String str5 = mVar.f6333c;
        if (str5 != null && str5.length() != 0) {
            a2.putExtra(Constants.FLAG_DEVICE_ID, mVar.f6333c);
        }
        if (j2 >= 0) {
            a2.putExtra("otherPushType", j2);
            if (!i.b(str3)) {
                a2.putExtra("otherPushToken", str3);
            }
        }
        if (a(mVar)) {
            a2.putExtra(Constants.FLAG_REGISTER_FROM_CLOUDCTRL, true);
        }
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), a2);
    }

    public void b(int i2, String str, String str2, int i3, String str3) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.ACCOUNT.RESULT.V4");
        intent.putExtra("flag", i3);
        intent.putExtra("operation", 0);
        if (!i.b(str3)) {
            intent.setPackage(str3);
        }
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), intent);
        a(i2, str, str2, i3, str3);
    }

    public void b(int i2, String str, String str2, int i3, String str3, String str4) {
        TLogger.e("PushServiceBroadcastHandler", "tagFailHandler failed with (" + i2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str3 + ")");
        Intent intent = new Intent("com.tencent.android.xg.vip.action.TAG.RESULT.V4");
        intent.putExtra("flag", i3);
        intent.putExtra("code", i2);
        intent.putExtra("msg", str);
        intent.putExtra("operation", 1);
        if (!i.b(str3)) {
            intent.setPackage(str3);
        }
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), intent);
        a(i2, str2, i3, str3, str4);
    }

    private void a(int i2, String str) {
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), f.a(i2, str, 2));
    }

    private void a(int i2, String str, String str2, int i3, String str3) {
        Intent a2 = f.a(i2, str3, 6);
        a2.putExtra(Constants.FLAG_ACCOUNT_NAME, Rijndael.encrypt(str));
        a2.putExtra(Constants.FLAG_ACCOUNT_FEEDBACK, str2);
        a2.putExtra(Constants.FLAG_ACCOUNT_OP_TYPE, i3);
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), a2);
    }

    public void b(int i2, int i3, int i4, String str, String str2, String str3) {
        TLogger.e("PushServiceBroadcastHandler", "tagFailHandler failed with (" + i2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str + ")");
        Intent intent = new Intent("com.tencent.android.xg.vip.action.TAG.RESULT.V4");
        intent.putExtra("code", i2);
        intent.putExtra("msg", str2);
        intent.putExtra("operation", 1);
        if (!i.b(str)) {
            intent.setPackage(str);
        }
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), intent);
        a(i2, str, str2, str3);
    }

    private void a(int i2, String str, int i3, String str2, String str3) {
        Intent a2 = f.a(i2, str2, 3);
        a2.putExtra(Constants.FLAG_TAG_NAME, Rijndael.encrypt(str));
        a2.putExtra(Constants.FLAG_TAG_TYPE, i3);
        a2.putExtra(Constants.FLAG_TAG_OPER_NAME, str3);
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), a2);
    }

    private void a(int i2, String str, String str2, String str3) {
        Intent a2 = f.a(i2, str, 8);
        if (!TextUtils.isEmpty(str2)) {
            a2.putExtra("data", Rijndael.encrypt(str2));
        }
        a2.putExtra(Constants.FLAG_QUERY_TAGS_OPER_NAME, str3);
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), a2);
    }

    public void a(int i2, n nVar, m mVar, String str, boolean z, String str2) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.REGISTER.RESULT.V4");
        intent.putExtra("accId", mVar.a);
        intent.putExtra("data", nVar.b);
        intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
        intent.putExtra("code", i2);
        intent.putExtra("operation", 0);
        intent.putExtra("otherPushType", nVar.f6345d);
        intent.putExtra("otherPushToken", nVar.f6346e);
        intent.putExtra("lastNMd5str", str2);
        RegisterEntity registerEntity = new RegisterEntity();
        registerEntity.accessId = mVar.a;
        registerEntity.accessKey = mVar.b;
        registerEntity.token = nVar.b;
        registerEntity.channelId = mVar.s;
        registerEntity.packageName = str;
        registerEntity.timestamp = System.currentTimeMillis() / 1000;
        CacheManager.addRegisterInfo(registerEntity);
        registerEntity.guid = nVar.f6344c;
        if (!i.b(str)) {
            intent.setPackage(str);
        }
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), intent);
        try {
            String str3 = nVar.f6350i;
            if (i.b(str3)) {
                a(i2, mVar, nVar.b, str, nVar.f6345d, nVar.f6346e);
            } else {
                a(i2, str3, nVar.f6351j, str);
            }
        } catch (Throwable unused) {
            TLogger.w("PushServiceBroadcastHandler", "unexpected for registerSuccessHandler");
        }
        if (com.tencent.android.tpush.service.b.e() != null) {
            com.tencent.android.tpush.a.b(com.tencent.android.tpush.service.b.e());
        }
    }

    public void a(int i2, String str, m mVar, String str2) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.REGISTER.RESULT.V4");
        intent.putExtra("data", "");
        intent.putExtra("code", i2);
        intent.putExtra("msg", str);
        intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
        intent.putExtra("operation", 1);
        if (!i.b(str2)) {
            intent.setPackage(str2);
        }
        try {
            BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), intent);
            if (mVar != null) {
                String str3 = mVar.f6335e;
                if (i.b(str3)) {
                    a(i2, mVar, GuidInfoManager.getToken(com.tencent.android.tpush.service.b.e()), str2, -1L, (String) null);
                } else {
                    a(i2, str3, mVar.f6336f, str2);
                }
            }
        } catch (Throwable unused) {
            TLogger.w("PushServiceBroadcastHandler", "unexpected for registerFailHandler");
        }
    }

    public void a(int i2, r rVar, String str) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.UNREGISTER.RESULT.V4");
        intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
        intent.putExtra("operation", 0);
        CacheManager.UnregisterInfoSuccessByPkgName(str);
        CacheManager.removeRegisterInfos(str);
        if (!i.b(str)) {
            intent.setPackage(str);
        }
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), intent);
        a(i2, str);
    }

    public void a(int i2, String str, r rVar, String str2) {
        TLogger.e("PushServiceBroadcastHandler", "unregisterFailHandler failed with (" + i2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + rVar + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + ")");
        Intent intent = new Intent("com.tencent.android.xg.vip.action.UNREGISTER.RESULT.V4");
        intent.putExtra("flag", ReturnCode.FLAG_ONLINE.getType());
        intent.putExtra("code", i2);
        intent.putExtra("msg", str);
        intent.putExtra("operation", 1);
        if (!i.b(str2)) {
            intent.setPackage(str2);
        }
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), intent);
        a(i2, str2);
    }

    public void a(int i2, String str, String str2, String str3, int i3, String str4) {
        TLogger.e("PushServiceBroadcastHandler", "accountFailHandler failed with (" + i2 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + str4 + ")");
        Intent intent = new Intent("com.tencent.android.xg.vip.action.ACCOUNT.RESULT.V4");
        intent.putExtra("flag", i3);
        intent.putExtra("code", i2);
        intent.putExtra("msg", str);
        intent.putExtra("operation", 1);
        if (!i.b(str4)) {
            intent.setPackage(str4);
        }
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), intent);
        a(i2, str2, str3, i3, str4);
    }

    public void a(int i2, int i3, int i4, String str, String str2, String str3) {
        Intent intent = new Intent("com.tencent.android.xg.vip.action.QUERYTAGS.RESULT.V4");
        intent.putExtra("data", str2);
        intent.putExtra("operation", 0);
        if (!i.b(str)) {
            intent.setPackage(str);
        }
        BroadcastAgent.sendBroadcast(com.tencent.android.tpush.service.b.e(), intent);
        a(i2, str, str2, str3);
    }
}
