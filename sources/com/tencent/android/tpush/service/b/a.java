package com.tencent.android.tpush.service.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.moor.imkf.lib.jobqueue.base.JobManager;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.e;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.inappmessage.g;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.MessageManager;
import com.tencent.android.tpush.rpc.a;
import com.tencent.android.tpush.rpc.c;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.service.b;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.service.d;
import com.tencent.android.tpush.service.protocol.j;
import com.tencent.android.tpush.service.util.f;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import e.t.u.b0;
import java.io.PrintStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.INTENTSCHEMECHECK, EType.INTENTCHECK, EType.RECEIVERCHECK})
/* loaded from: classes3.dex */
public class a {
    private static a a = new a();
    private static final byte[] b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    private static long f6238c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f6239d = false;

    /* renamed from: e  reason: collision with root package name */
    private static volatile boolean f6240e = false;

    /* renamed from: f  reason: collision with root package name */
    private static volatile boolean f6241f = false;

    /* renamed from: g  reason: collision with root package name */
    private static volatile boolean f6242g = false;

    /* renamed from: h  reason: collision with root package name */
    private static ConcurrentHashMap<Long, Map<String, List<Long>>> f6243h = null;

    private a() {
    }

    public static a a() {
        c();
        return a;
    }

    private static synchronized void c() {
        synchronized (a.class) {
            try {
                if (f6243h == null) {
                    f6243h = new ConcurrentHashMap<>();
                    String string = PushPreferences.getString(b.e(), "ChannelGroupKeysConfig", null);
                    if (!i.b(string)) {
                        JSONArray jSONArray = new JSONArray(string);
                        if (jSONArray.length() > 0) {
                            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                                Iterator<String> keys = jSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    Long valueOf = Long.valueOf(next);
                                    JSONArray jSONArray2 = jSONObject.getJSONArray(next);
                                    if (jSONArray2 != null && jSONArray2.length() > 0) {
                                        HashMap hashMap = new HashMap();
                                        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i3);
                                            Iterator<String> keys2 = jSONObject2.keys();
                                            while (keys2.hasNext()) {
                                                String next2 = keys2.next();
                                                hashMap.put(next2, a(jSONObject2.getJSONArray(next2)));
                                            }
                                        }
                                        f6243h.put(valueOf, hashMap);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                TLogger.e("SrvMessageManager", "initChanellGroupKey", th);
            }
        }
    }

    public void b(ArrayList<j> arrayList, long j2, com.tencent.android.tpush.service.channel.a aVar) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        if (b.e() == null) {
            Context e2 = b.e();
            ServiceStat.reportErrCode(e2, ErrCode.INNER_ERROR_RECV_PKG_NULL, "context is null, msgid:" + arrayList.get(0).a, 0L, "inner");
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            TLogger.ii("SrvMessageManager", "receive msg from service msgId = " + arrayList.get(i2).a + " pkg = " + arrayList.get(i2).f6321g + " type = " + arrayList.get(i2).f6320f);
        }
        Iterator<j> it = arrayList.iterator();
        while (it.hasNext()) {
            j next = it.next();
            TLogger.d("SrvMessageManager", "distributeFromServer : accid=" + next.b + " ,channelId=" + next.f6327m + ",busiId=" + next.f6317c + ",pkg=" + next.f6321g + ",msgId=" + next.a + ",type=" + next.f6320f + ",ts=" + next.f6322h + ",multi=" + next.f6323i + ",date=" + next.f6324j + ",serverTime=" + next.f6325k + ",ttl=" + next.f6326l + ", size = " + arrayList.size() + ", groupId=" + next.r + ", mgroupId=" + next.s + ", revokeId=" + next.v);
            StringBuilder sb = new StringBuilder();
            sb.append("distributeFromServer content:");
            sb.append(next.f6319e);
            TLogger.d("SrvMessageManager", sb.toString());
            long j3 = next.f6320f;
            if (j3 == 3) {
                try {
                    String str = next.f6319e;
                    if (str == null) {
                        return;
                    }
                    a(str);
                } catch (Throwable th) {
                    TLogger.e("SrvMessageManager", "distributeFromServerInAppMsg exception: ", th);
                }
            } else if (j3 == 6) {
                try {
                    if (next.y == null) {
                        return;
                    }
                    g.a(b.e()).a(next);
                } catch (Throwable th2) {
                    TLogger.e("SrvMessageManager", "distributeFromServerInAppMsg exception:" + th2.toString());
                }
            } else if (j3 == 1000) {
                try {
                    if (next.f6319e == null) {
                        return;
                    }
                    String optString = new JSONObject(next.f6319e).optString("custom_content", null);
                    CloudManager.getInstance(b.e()).parseCloudConfig(optString, 0L);
                    b(b.e(), optString);
                } catch (Throwable th3) {
                    TLogger.w("SrvMessageManager", "unexpected for type:1000", th3);
                }
            } else if (i.b(next.f6321g) && next.f6323i == 0 && next.f6327m <= 0) {
                TLogger.d("SrvMessageManager", ">> messageDistribute, msg.appPkgName is null!");
                Context e3 = b.e();
                ServiceStat.reportErrCode(e3, ErrCode.INNER_ERROR_RECV_PKG_NULL, "msgId:" + next.a, 0L, "inner");
            } else {
                a(next, j2, aVar);
            }
        }
    }

    public synchronized void a(Context context, Intent intent) {
        if (context != null && intent != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                MessageId messageId = new MessageId();
                long longExtra = intent.getLongExtra("msgId", -1L);
                messageId.id = longExtra;
                if (longExtra < 0) {
                    TLogger.v("SrvMessageManager", "@@ msgSendSDKAck: Not add LocalMsg");
                    return;
                }
                messageId.accessId = intent.getLongExtra("accId", -1L);
                messageId.host = intent.getLongExtra(MessageKey.MSG_EXTRA_HOST, -1L);
                messageId.port = intent.getIntExtra(MessageKey.MSG_EXTRA_PORT, -1);
                messageId.pact = intent.getByteExtra(MessageKey.MSG_EXTRA_PACT, (byte) -1);
                messageId.apn = DeviceInfos.getNetworkType(b.e());
                messageId.isp = i.o(b.e());
                messageId.serviceHost = b.e().getPackageName();
                messageId.receivedTime = currentTimeMillis;
                messageId.pkgName = intent.getPackage();
                messageId.busiMsgId = intent.getLongExtra("busiMsgId", -1L);
                messageId.timestamp = intent.getLongExtra("timestamps", -1L);
                messageId.msgType = intent.getLongExtra("type", -1L);
                messageId.multiPkg = intent.getLongExtra(MessageKey.MSG_CREATE_MULTIPKG, -1L);
                messageId.date = intent.getStringExtra(MessageKey.MSG_DATE);
                messageId.channelId = intent.getLongExtra(MessageKey.MSG_CHANNEL_ID, -1L);
                String stringExtra = intent.getStringExtra("group_id");
                if (!i.b(stringExtra)) {
                    messageId.groupId = stringExtra;
                }
                String stringExtra2 = intent.getStringExtra(MessageKey.MSG_STAT_TAG);
                if (!i.b(stringExtra2)) {
                    messageId.statTag = stringExtra2;
                }
                a(context, "all", messageId);
                a(context, messageId);
            } catch (Throwable th) {
                TLogger.e("SrvMessageManager", "msgSendSDKAck", th);
            }
        }
    }

    private void b(Context context, String str) {
        int i2;
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("losePkt", 0);
            long optLong = jSONObject.optLong("loseStart", 0L) * 1000;
            long optLong2 = jSONObject.optLong("loseEnd", 0L) * 1000;
            long currentTimeMillis = System.currentTimeMillis();
            TLogger.i("SrvMessageManager", "checkIfCloudRefuse | losePkt : " + optInt + "; loseStart : " + optLong + "; loseEnd : " + optLong2 + "; current : " + currentTimeMillis);
            if (optInt == 1) {
                int i3 = (currentTimeMillis > optLong2 ? 1 : (currentTimeMillis == optLong2 ? 0 : -1));
                if ((i3 > 0 || currentTimeMillis < optLong) && (!(optLong == 0 && optLong2 == 0) && ((i3 > 0 || i2 != 0) && (currentTimeMillis < optLong || optLong2 != 0)))) {
                    return;
                }
                d.a(XGVipPushService.a()).c(null);
                TLogger.i("SrvMessageManager", "checkIfCloudRefuse | stopConnect ");
            }
        } catch (JSONException e2) {
            TLogger.e("SrvMessageManager", "checkIfCloudRefuse", e2);
        }
    }

    private synchronized void a(Context context, MessageId messageId) {
    }

    public void a(Context context, String str, MessageId messageId) {
        synchronized (b) {
            if (context != null) {
                if (!i.b(str) && messageId != null) {
                    ArrayList<MessageId> a2 = a(context, str);
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < a2.size(); i2++) {
                        MessageId messageId2 = a2.get(i2);
                        if (messageId2.id == messageId.id) {
                            arrayList.add(messageId2);
                        }
                    }
                    a2.removeAll(arrayList);
                    a2.add(messageId);
                    a(context, str, a2);
                }
            }
        }
    }

    private static JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<Long, Map<String, List<Long>>> entry : f6243h.entrySet()) {
            JSONObject jSONObject = new JSONObject();
            PrintStream printStream = System.out;
            printStream.println("Key = " + entry.getKey());
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, List<Long>> entry2 : entry.getValue().entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(entry2.getKey(), new JSONArray((Collection) entry2.getValue()));
                jSONArray2.put(jSONObject2);
            }
            jSONObject.put(entry.getKey().toString(), jSONArray2);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    private ArrayList<MessageId> a(Context context, String str) {
        Object a2;
        ArrayList<MessageId> arrayList = (context == null || i.b(str) || (a2 = a(context, str, ".tpns.msg.id.send.sdk")) == null) ? null : (ArrayList) a2;
        return arrayList == null ? new ArrayList<>() : arrayList;
    }

    public void a(Context context, String str, ArrayList<MessageId> arrayList) {
        synchronized (b) {
            if (context != null && arrayList != null) {
                a(context, str, ".tpns.msg.id.send.sdk", arrayList);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v15, types: [java.lang.String[], java.io.Serializable] */
    private void a(j jVar, long j2, com.tencent.android.tpush.service.channel.a aVar) {
        Context context;
        Context context2;
        TLogger.d("SrvMessageManager", "distribute2SDK: " + jVar.toString());
        Context e2 = b.e();
        Intent intent = new Intent(Constants.ACTION_INTERNAL_PUSH_MESSAGE);
        intent.setPackage(jVar.f6321g);
        intent.putExtra("msgId", jVar.a);
        intent.putExtra("title", Rijndael.encrypt(jVar.f6318d));
        intent.putExtra("content", Rijndael.encrypt(jVar.f6319e));
        intent.putExtra(MessageKey.MSG_DATE, jVar.f6324j);
        intent.putExtra("type", jVar.f6320f);
        intent.putExtra("accId", jVar.b);
        intent.putExtra("busiMsgId", jVar.f6317c);
        intent.putExtra("timestamps", jVar.f6322h);
        intent.putExtra(MessageKey.MSG_CREATE_MULTIPKG, jVar.f6323i);
        intent.putExtra(MessageKey.MSG_SERVER_TIME, jVar.f6325k);
        intent.putExtra("ttl", jVar.f6326l);
        intent.putExtra("group_id", jVar.r);
        intent.putExtra(MessageKey.MSG_TARGET_TYPE, jVar.t);
        intent.putExtra(MessageKey.MSG_SOURCE, jVar.u);
        intent.putExtra(MessageKey.MSG_REVOKEID, jVar.v);
        intent.putExtra(MessageKey.MSG_TEMPLATE_ID, jVar.w);
        intent.putExtra(MessageKey.MSG_TRACE_ID, jVar.x);
        intent.putExtra(MessageKey.MSG_IN_MSG, Rijndael.encrypt(jVar.y));
        long j3 = jVar.f6327m;
        if (com.tencent.android.tpush.e.a.a(e2) && !jVar.f6321g.equals(e2.getPackageName())) {
            intent.putExtra("pushChannel", com.tencent.android.tpush.e.a.a());
        } else {
            intent.putExtra("pushChannel", 100);
        }
        intent.putExtra("groupId", jVar.s);
        intent.putExtra(MessageKey.MSG_SERVICE_ACK, true);
        intent.putExtra(MessageKey.MSG_SERVICE_PACKAGE_NAME, b.h());
        if (jVar.v > 0) {
            ServiceStat.appReportRevokeMessageServiceReceived(b.e(), intent);
        } else {
            ServiceStat.appReportServiceReceived(b.e(), intent);
        }
        if (jVar.f6320f == 7 && com.tencent.android.tpush.e.a.a(b.e())) {
            TLogger.w("SrvMessageManager", "receive inMsg but run as SysPush, discard it");
            return;
        }
        int i2 = jVar.f6326l;
        long j4 = jVar.f6325k;
        long j5 = jVar.f6322h;
        long currentTimeMillis = System.currentTimeMillis();
        long j6 = 259200000;
        if (i2 > 0) {
            j6 = i2 * 1000;
            context = e2;
        } else {
            context = e2;
            if (jVar.a > 0 && i2 == 0) {
                j6 = JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS;
            }
        }
        long j7 = (j4 <= 0 || j5 <= 0) ? currentTimeMillis + j6 : ((j4 - j5) * 1000) + currentTimeMillis + j6;
        Long.signum(j4);
        intent.putExtra(MessageKey.MSG_TIME_GAP, currentTimeMillis - (j4 * 1000));
        intent.putExtra("expire_time", j7);
        try {
            intent.putExtra("enKeySet", e.a((Serializable) new String[]{"title", "content"}));
        } catch (Throwable th) {
            TLogger.e("SrvMessageManager", "distribute2SDK", th);
        }
        intent.putExtra(MessageKey.MSG_EXTRA_PUSHTIME, j2);
        long j8 = jVar.f6323i;
        long j9 = jVar.b;
        String str = null;
        if (!com.tencent.android.tpush.e.a.a(context) || jVar.f6321g.equals(context.getPackageName())) {
            context2 = context;
            if (j8 == 0) {
                if (jVar.f6321g.equals(context2.getPackageName())) {
                    str = jVar.f6321g;
                } else {
                    TLogger.w("SrvMessageManager", "receive message but package name is not right");
                }
            } else {
                String findValidPackageByAccessid = CacheManager.findValidPackageByAccessid(j9);
                if (!i.b(findValidPackageByAccessid)) {
                    str = findValidPackageByAccessid;
                }
            }
        } else if (j8 == 0) {
            context2 = context;
            if (com.tencent.android.tpush.e.a.a(context2, jVar.b, jVar.f6321g)) {
                intent.putExtra(Constants.XG_SYS_INTENT_KEY_THIRD_APP, jVar.f6321g);
                str = context2.getPackageName();
            }
        } else {
            context2 = context;
            String a2 = com.tencent.android.tpush.e.a.a(context2, jVar.b);
            if (a2 != null) {
                intent.putExtra(Constants.XG_SYS_INTENT_KEY_THIRD_APP, a2);
                str = context2.getPackageName();
            }
        }
        TLogger.i("SrvMessageManager", "distribute2SDK appPkgName: " + str);
        try {
            TLogger.i("SrvMessageManager", "distribute2SDK pkgs msgid " + jVar.a + "  pkg " + jVar.f6321g);
            if (i.b(str)) {
                TLogger.d("SrvMessageManager", ">> msg.appPkgName is null!");
                ServiceStat.reportErrCode(context2, ErrCode.INNER_ERROR_RECV_PKG_NULL, "distribute2SDK msgId:" + jVar.a, 0L, "inner");
                return;
            }
            if (!com.tencent.android.tpush.e.a.a(context2)) {
                com.tencent.android.tpush.a.a.a(b.e()).a(str);
            }
            RegisterEntity registerInfoByPkgName = CacheManager.getRegisterInfoByPkgName(str);
            try {
                if (registerInfoByPkgName == null) {
                    TLogger.v("SrvMessageManager", "RegInfo is null " + str);
                    a(jVar.f6324j, intent, str);
                } else if (registerInfoByPkgName.state > 0) {
                    MessageManager.getInstance().deleteAllCachedMsgIntentByPkgName(b.e(), str);
                    ServiceStat.reportErrCode(context2, ErrCode.INNER_ERROR_MSG_SHOW_ERROR, "regInfo.state:" + registerInfoByPkgName.state, 0L, "inner");
                } else {
                    intent.setPackage(str);
                    if (!com.tencent.android.tpush.a.a(b.e(), intent.getPackage(), intent)) {
                        a(jVar.f6324j, intent, str);
                    } else {
                        a(b.e(), intent);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                TLogger.e("SrvMessageManager", "dispatchMessageOnTime", th);
                ServiceStat.reportErrCode(context2, ErrCode.INNER_ERROR_MSG_SHOW_ERROR, "sendMsgByPkgName err:" + Util.getThrowableToString(th), 0L, "inner");
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void a(String str, Intent intent, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(b0.a.t);
        if (!i.b(str) && (i.b(str) || simpleDateFormat.parse(str).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date()))) != 0)) {
            if (i.b(str) || simpleDateFormat.parse(str).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date()))) >= 0) {
                return;
            }
            a(intent);
        } else if (f.a(intent)) {
            TLogger.d("SrvMessageManager", ">> send rpc message intent:" + intent);
            a(intent);
        }
    }

    public void a(final Intent intent) {
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.service.b.a.1

            /* renamed from: c  reason: collision with root package name */
            private com.tencent.android.tpush.rpc.a f6244c;

            /* renamed from: d  reason: collision with root package name */
            private c f6245d = new c();

            /* renamed from: e  reason: collision with root package name */
            private ServiceConnection f6246e = new ServiceConnection() { // from class: com.tencent.android.tpush.service.b.a.1.1
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    try {
                        AnonymousClass1.this.f6244c = a.AbstractBinderC0223a.a(iBinder);
                        if (AnonymousClass1.this.f6244c != null) {
                            AnonymousClass1.this.f6244c.a(intent.toURI(), AnonymousClass1.this.f6245d);
                        }
                    } catch (Throwable th) {
                        TLogger.e("SrvMessageManager", "SendBroadcastByRPC", th);
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    AnonymousClass1.this.f6246e = null;
                    AnonymousClass1.this.f6244c = null;
                    AnonymousClass1.this.f6245d = null;
                }
            };

            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                try {
                    Intent intent2 = intent;
                    intent2.setAction(intent.getPackage() + Constants.RPC_SUFFIX);
                    this.f6245d.a(this.f6246e);
                    if (!b.e().bindService(intent, this.f6246e, 1)) {
                        TLogger.e("SrvMessageManager", "Failed Send AIDL" + intent + " failed  msgid = " + intent.getLongExtra("msgId", -1L));
                        MessageManager.getInstance().addCachedMsgIntentByPkgName(b.e(), intent.getPackage(), intent);
                        ServiceStat.reportErrCode(b.e(), ErrCode.INNER_ERROR_MSG_SHOW_ERROR, "bind aidl remote service return false", 0L, "inner");
                    } else {
                        TLogger.d("SrvMessageManager", "Succeed Send AIDL" + intent + " success  msgid = " + intent.getLongExtra("msgId", -1L));
                        a.this.a(b.e(), intent);
                    }
                } catch (Throwable th) {
                    TLogger.e("SrvMessageManager", "SendBroadcastByRPC -> bindService", th);
                    MessageManager.getInstance().addCachedMsgIntentByPkgName(b.e(), intent.getPackage(), intent);
                    Context e2 = b.e();
                    ServiceStat.reportErrCode(e2, ErrCode.INNER_ERROR_MSG_SHOW_ERROR, "bind aidl remote service err:" + Util.getThrowableToString(th), 0L, "inner");
                }
            }
        });
    }

    public void a(ArrayList<j> arrayList, long j2, com.tencent.android.tpush.service.channel.a aVar) {
        b(arrayList, j2, aVar);
    }

    private synchronized void a(String str) {
        if (i.b(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject(str).getJSONObject("custom_content");
        JSONArray jSONArray = jSONObject.getJSONArray("config");
        int i2 = jSONObject.getInt("version");
        int i3 = 0;
        if (jSONArray != null && jSONArray.length() > 0) {
            int i4 = false;
            while (i3 < jSONArray.length()) {
                boolean a2 = a(jSONArray.getJSONObject(i3));
                if (a2) {
                    i4 = a2;
                }
                i3++;
            }
            i3 = i4;
        }
        if (i3 != 0) {
            JSONArray b2 = b();
            PushPreferences.putInt(b.e(), "GroupKeysConfigVersion", i2);
            PushPreferences.putString(b.e(), "ChannelGroupKeysConfig", b2.toString());
        }
    }

    private synchronized boolean a(JSONObject jSONObject) {
        Long valueOf = Long.valueOf(jSONObject.getLong(RemoteMessageConst.Notification.CHANNEL_ID));
        boolean z = false;
        z = false;
        if (valueOf.longValue() <= 0) {
            return false;
        }
        JSONArray jSONArray = jSONObject.getJSONArray("infos");
        if (jSONArray != null && jSONArray.length() > 0) {
            if (!f6243h.containsKey(valueOf)) {
                f6243h.put(valueOf, new HashMap());
            }
            boolean z2 = false;
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                Map<String, List<Long>> map = f6243h.get(valueOf);
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                String string = jSONObject2.getString("groupKey");
                int i3 = jSONObject2.getInt("op");
                JSONArray jSONArray2 = jSONObject2.getJSONArray("apps");
                if (jSONArray2 != null && jSONArray2.length() > 0) {
                    if (!map.containsKey(string)) {
                        map.put(string, new ArrayList());
                    }
                    List<Long> list = map.get(string);
                    List<Long> a2 = a(jSONArray2);
                    if (i3 == 1) {
                        list = a2;
                    } else if (i3 == 2) {
                        a2.removeAll(list);
                        list.addAll(a2);
                    } else if (i3 == 3) {
                        list.removeAll(a2);
                    } else {
                        TLogger.e("SrvMessageManager", "error op type " + i3);
                        map.put(string, list);
                    }
                    z2 = true;
                    map.put(string, list);
                }
                f6243h.put(valueOf, map);
            }
            z = z2;
        }
        return z;
    }

    private static List<Long> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                arrayList.add(Long.valueOf(jSONArray.getLong(i2)));
            }
        }
        return arrayList;
    }

    private void a(Context context, String str, String str2, ArrayList<?> arrayList) {
        try {
            if (arrayList.size() > 50) {
                arrayList.subList(0, 10).clear();
            }
            String encrypt = Rijndael.encrypt(e.a(arrayList));
            com.tencent.android.tpush.service.util.d.a(context, str + str2, encrypt);
        } catch (Throwable th) {
            TLogger.e("SrvMessageManager", "putSettings", th);
        }
    }

    private Object a(Context context, String str, String str2) {
        try {
            return e.a(Rijndael.decrypt(com.tencent.android.tpush.service.util.d.a(context, str + str2)));
        } catch (Throwable th) {
            TLogger.e("SrvMessageManager", "getSettings", th);
            return null;
        }
    }
}
