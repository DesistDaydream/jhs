package com.tencent.android.tpush.message;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import e.t.u.b0;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class e {
    public static ArrayList<Long> a;
    private static volatile e b;

    /* renamed from: c  reason: collision with root package name */
    private static long f6176c;

    /* renamed from: d  reason: collision with root package name */
    private Context f6177d = null;

    /* loaded from: classes3.dex */
    public class a extends TTask {
        private Context b;

        /* renamed from: c  reason: collision with root package name */
        private Intent f6178c;

        /* renamed from: d  reason: collision with root package name */
        private XGIOperateCallback f6179d;

        public a(Context context, Intent intent, XGIOperateCallback xGIOperateCallback) {
            this.b = context;
            this.f6178c = intent;
            this.f6179d = xGIOperateCallback;
        }

        private void a() {
            Intent intent = new Intent("com.tencent.android.xg.vip.action.PUSH_MESSAGE");
            intent.putExtras(this.f6178c);
            if (com.tencent.android.tpush.e.a.a(this.b)) {
                String stringExtra = this.f6178c.getStringExtra(Constants.XG_SYS_INTENT_KEY_THIRD_APP);
                if (!i.b(stringExtra)) {
                    TLogger.ii("PushMessageRunnable", "ACTION_PUSH_MESSAGE otherApp -> " + stringExtra);
                    intent.setPackage(stringExtra);
                    this.b.sendBroadcast(intent);
                } else {
                    intent.setPackage(this.b.getPackageName());
                    BroadcastAgent.sendBroadcast(this.b, intent);
                }
            } else {
                intent.setPackage(this.b.getPackageName());
                BroadcastAgent.sendBroadcast(this.b, intent);
            }
            String stringExtra2 = this.f6178c.getStringExtra(MessageKey.MSG_SERVICE_PACKAGE_NAME);
            if (i.b(stringExtra2)) {
                return;
            }
            Intent intent2 = new Intent(this.b.getPackageName() + "com.tencent.android.xg.vip.action.ack.sdk2srv.V4");
            intent2.setPackage(stringExtra2);
            intent2.putExtras(this.f6178c);
            BroadcastAgent.sendBroadcast(this.b, intent2);
        }

        @Override // com.tencent.tpns.baseapi.base.util.TTask
        public void TRun() {
            Throwable th;
            long longExtra;
            long currentTimeMillis;
            long longExtra2;
            PushMessageManager pushMessageManager;
            String str;
            long longExtra3;
            String notifiedMsgIds;
            synchronized (e.this) {
                if (XGPushConfig.enableDebug) {
                    TLogger.d("PushMessageRunnable", "Action -> handlerPushMessage");
                }
                try {
                    longExtra = this.f6178c.getLongExtra("expire_time", 0L);
                    if (longExtra <= 0) {
                        long longExtra4 = this.f6178c.getLongExtra(MessageKey.MSG_SERVER_TIME, -1L);
                        if (longExtra4 > 0) {
                            int intExtra = this.f6178c.getIntExtra("ttl", 0);
                            int i2 = intExtra <= 0 ? 259200 : intExtra;
                            try {
                                if (String.valueOf(System.currentTimeMillis()).length() - String.valueOf(longExtra4).length() == 3) {
                                    longExtra4 *= 1000;
                                }
                            } catch (Throwable th2) {
                                TLogger.e("PushMessageHandler", "", th2);
                            }
                            longExtra = (i2 * 1000) + longExtra4;
                        }
                    }
                    String str2 = this.f6178c.getPackage();
                    currentTimeMillis = System.currentTimeMillis();
                    longExtra2 = this.f6178c.getLongExtra("msgId", -1L);
                    pushMessageManager = PushMessageManager.getInstance(this.b, this.f6178c);
                    str = TIMMentionEditText.TIM_MENTION_TAG + longExtra2 + str2 + TIMMentionEditText.TIM_MENTION_TAG;
                    longExtra3 = this.f6178c.getLongExtra("accId", -1L);
                    notifiedMsgIds = MessageManager.getNotifiedMsgIds(this.b, longExtra3);
                } catch (IllegalArgumentException e2) {
                    th = e2;
                    TLogger.e("PushMessageRunnable", "push msg type error", th);
                } catch (JSONException e3) {
                    th = e3;
                    TLogger.e("PushMessageRunnable", "push parse error", th);
                }
                if (pushMessageManager.getType() == 7) {
                    if (!notifiedMsgIds.contains(str) && !i.b(pushMessageManager.getInMsg())) {
                        com.tencent.android.tpush.b.a.a(this.b, pushMessageManager);
                    }
                } else if (longExtra > 0 && currentTimeMillis > longExtra) {
                    TLogger.e("PushMessageHandler", "msg is expired, currentTimeMillis=" + currentTimeMillis + ", expire_time=" + longExtra + ". msgid = " + longExtra2);
                    XGPushManager.msgAck(this.b, pushMessageManager);
                } else if (!e.a(Long.valueOf(longExtra2))) {
                    XGPushManager.msgAck(this.b, pushMessageManager);
                } else {
                    long longExtra5 = this.f6178c.getLongExtra("busiMsgId", 0L);
                    long longExtra6 = this.f6178c.getLongExtra("timestamps", 0L);
                    List<Long> accessidList = XGPushConfig.getAccessidList(this.b);
                    if (!com.tencent.android.tpush.e.a.a(this.b) && accessidList != null && accessidList.size() > 0 && !accessidList.contains(Long.valueOf(longExtra3))) {
                        TLogger.ee("PushMessageRunnable", "PushMessageRunnable match accessId failed, message droped cause accessId:" + longExtra3 + " not in " + accessidList + " msgId = " + str);
                        MessageManager.getInstance().deleteCachedMsgIntent(this.b, longExtra2);
                        XGPushManager.msgAck(this.b, pushMessageManager);
                        return;
                    }
                    th = null;
                    if (!notifiedMsgIds.contains(str)) {
                        if (!MessageManager.setNotifiedMsgIds(this.b, longExtra3, str, notifiedMsgIds)) {
                            return;
                        }
                        TLogger.i("PushMessageRunnable", "Receiver msg from server :" + pushMessageManager.toString());
                        XGPushManager.msgAck(this.b, pushMessageManager);
                        String stringExtra = this.f6178c.getStringExtra(MessageKey.MSG_SERVICE_PACKAGE_NAME);
                        if (!this.b.getPackageName().equals(stringExtra)) {
                            TLogger.ii("PushMessageRunnable", "Receiver msg from other app :" + stringExtra);
                            ServiceStat.appReportPullupAck(this.b, this.f6178c);
                        }
                        com.tencent.android.tpush.message.a messageHolder = pushMessageManager.getMessageHolder();
                        if (messageHolder != null && !i.b(pushMessageManager.getContent())) {
                            try {
                                if (new c(this.b, this.f6178c).a(pushMessageManager, longExtra6, longExtra5, longExtra2)) {
                                    a();
                                    MessageManager.getInstance().updateCachedMsgIntentToShowed(this.b, pushMessageManager.getMsgId());
                                    if (messageHolder.b() == 1) {
                                        pushMessageManager.showNotifacition();
                                    }
                                } else {
                                    MessageManager.getInstance().updateCachedMsgIntentToVerifyErr(this.b, pushMessageManager.getMsgId());
                                }
                            } catch (Throwable th3) {
                                TLogger.e("PushMessageRunnable", "unknown error", th3);
                                MessageManager.getInstance().updateCachedMsgIntentToVerifyErr(this.b, pushMessageManager.getMsgId());
                                th = th3;
                            }
                        }
                    } else {
                        this.f6179d = null;
                    }
                    XGIOperateCallback xGIOperateCallback = this.f6179d;
                    if (xGIOperateCallback != null) {
                        if (th != null) {
                            xGIOperateCallback.onFail("", -1, th.toString());
                        } else {
                            xGIOperateCallback.onSuccess("", 0);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Intent intent) {
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.message.e.1
            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                if (intent.getLongExtra("type", -1L) == 7 && !XGPushConfig.isEnableShowInMsg(e.this.f6177d)) {
                    TLogger.w("PushMessageHandler", "handle pushMessage inMsg not allowed");
                    ServiceStat.appReportInMsgUserDisabled(e.this.f6177d, intent);
                    return;
                }
                String stringExtra = intent.getStringExtra(MessageKey.MSG_DATE);
                if (intent.getLongExtra("msgId", -1L) < 0) {
                    try {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(b0.a.t);
                        if (!i.b(stringExtra) && (i.b(stringExtra) || simpleDateFormat.parse(stringExtra).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date()))) != 0)) {
                            if (!i.b(stringExtra) && simpleDateFormat.parse(stringExtra).compareTo(simpleDateFormat.parse(simpleDateFormat.format(new Date()))) < 0) {
                                e.this.a(intent);
                                return;
                            } else {
                                TLogger.w("PushMessageHandler", "can not handle the local message because of the date");
                                return;
                            }
                        }
                        if (com.tencent.android.tpush.service.util.f.a(intent)) {
                            e.this.a(intent);
                        } else {
                            TLogger.w("PushMessageHandler", "can not handle the local message because of the time");
                        }
                    } catch (ParseException e2) {
                        TLogger.ee("PushMessageHandler", "try to handlerPushMessage, but ParseException : " + e2);
                    }
                } else if (com.tencent.android.tpush.service.util.f.a(intent)) {
                    e.this.a(intent);
                } else {
                    TLogger.w("PushMessageHandler", "can not handle the message because of the time");
                }
            }
        });
    }

    public void b(final Intent intent) {
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.message.e.2
            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                if (XGPushConfig.enableDebug) {
                    TLogger.d("PushMessageHandler", "Action -> handleRemotePushMessage");
                }
                long longExtra = intent.getLongExtra("msgId", 0L);
                long longExtra2 = intent.getLongExtra("timestamps", 0L);
                long longExtra3 = intent.getLongExtra(MessageKey.MSG_SERVER_TIME, 0L);
                int intExtra = intent.getIntExtra("ttl", 0);
                long longExtra4 = intent.getLongExtra("type", 1L);
                int intExtra2 = intent.getIntExtra(MessageKey.MSG_REVOKEID, 0);
                if (intExtra2 <= 0) {
                    if (!XGPushConfig.isNotificationShowEnable(e.this.f6177d)) {
                        TLogger.ii("PushMessageHandler", "XINGE NotificationShow is not enabe, so discard this notification, msgid:" + longExtra);
                        return;
                    }
                    long longExtra5 = intent.getLongExtra("accId", 0L);
                    String str = intent.getPackage();
                    try {
                        RegisterEntity currentAppRegisterEntity = CacheManager.getCurrentAppRegisterEntity(e.this.f6177d);
                        if (currentAppRegisterEntity != null && !i.b(currentAppRegisterEntity.packageName) && str.equals(currentAppRegisterEntity.packageName) && longExtra5 == currentAppRegisterEntity.accessId) {
                            if (currentAppRegisterEntity.state == 1) {
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        TLogger.e("PushMessageHandler", th.toString());
                    }
                    String stringExtra = intent.getStringExtra(MessageKey.MSG_DATE);
                    long longExtra6 = intent.getLongExtra(MessageKey.MSG_EXTRA_PUSHTIME, 0L);
                    long longExtra7 = intent.getLongExtra("busiMsgId", 0L);
                    long longExtra8 = intent.getLongExtra(MessageKey.MSG_CREATE_MULTIPKG, 0L);
                    long longExtra9 = intent.getLongExtra(MessageKey.MSG_CHANNEL_ID, -1L);
                    String stringExtra2 = intent.getStringExtra("group_id");
                    String stringExtra3 = intent.getStringExtra(MessageKey.MSG_STAT_TAG);
                    long currentTimeMillis = System.currentTimeMillis();
                    MessageId messageId = new MessageId();
                    messageId.id = longExtra;
                    messageId.isAck = (short) 0;
                    messageId.accessId = longExtra5;
                    messageId.host = intent.getLongExtra(MessageKey.MSG_EXTRA_HOST, 0L);
                    messageId.port = intent.getIntExtra(MessageKey.MSG_EXTRA_PORT, 0);
                    messageId.pact = intent.getByteExtra(MessageKey.MSG_EXTRA_PACT, (byte) 0);
                    messageId.apn = DeviceInfos.getNetworkType(e.this.f6177d);
                    messageId.isp = i.o(e.this.f6177d);
                    messageId.serviceHost = intent.getStringExtra(MessageKey.MSG_SERVICE_PACKAGE_NAME);
                    messageId.receivedTime = currentTimeMillis;
                    messageId.pkgName = str;
                    messageId.busiMsgId = longExtra7;
                    messageId.timestamp = longExtra2;
                    messageId.msgType = longExtra4;
                    messageId.multiPkg = longExtra8;
                    messageId.date = stringExtra;
                    messageId.channelId = longExtra9;
                    messageId.pushTime = intent.getLongExtra(MessageKey.MSG_PUSH_TIME, 0L);
                    messageId.pushChannel = intent.getIntExtra("pushChannel", 100);
                    String stringExtra4 = intent.getStringExtra("groupId");
                    if (!i.b(stringExtra4)) {
                        messageId.nGroupId = stringExtra4;
                    }
                    if (!i.b(stringExtra2)) {
                        messageId.groupId = stringExtra2;
                    }
                    if (!i.b(stringExtra3)) {
                        messageId.statTag = stringExtra3;
                    }
                    TLogger.i("PushMessageHandler", ">> msg from service,  @msgId=" + messageId.id + " @accId=" + messageId.accessId + " @timeUs=" + longExtra6 + " @recTime=" + messageId.receivedTime + " @msg.date=" + stringExtra + " @msg.busiMsgId=" + longExtra7 + " @msg.timestamp=" + longExtra2 + " @msg.type=" + longExtra4 + " @msg.multiPkg=" + longExtra8 + " @msg.serverTime=" + longExtra3 + " @msg.ttl=" + intExtra + " @currentTimeMillis=" + currentTimeMillis);
                    String notifiedMsgIds = MessageManager.getNotifiedMsgIds(e.this.f6177d, longExtra5);
                    StringBuilder sb = new StringBuilder();
                    sb.append(TIMMentionEditText.TIM_MENTION_TAG);
                    sb.append(messageId.id);
                    sb.append(str);
                    sb.append(TIMMentionEditText.TIM_MENTION_TAG);
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("cache msgIds:");
                    sb3.append(notifiedMsgIds);
                    sb3.append(", vs current msgIdstr:");
                    sb3.append(sb2);
                    TLogger.i("PushMessageHandler", sb3.toString());
                    if (!notifiedMsgIds.contains(sb2)) {
                        if (MessageManager.getInstance().isMsgAcked(e.this.f6177d, str, messageId.id)) {
                            TLogger.ee("PushMessageHandler", ">> msgId:" + messageId.id + " has been acked, return");
                            return;
                        }
                        messageId.pkgName = str;
                        if (messageId.id > 0) {
                            MessageManager.getInstance().addMsgId(e.this.f6177d, str, messageId);
                        }
                        MessageManager.getInstance().addNewCachedMsgIntent(e.this.f6177d, intent);
                        e.this.c(intent);
                        return;
                    }
                    TLogger.ee("PushMessageHandler", "getNotifiedMsgIds contain the msgId id:" + sb2 + ", return");
                    return;
                }
                try {
                    TLogger.i("PushMessageHandler", "message revokeId of notifyId " + intExtra2);
                    ((NotificationManager) e.this.f6177d.getSystemService(RemoteMessageConst.NOTIFICATION)).cancel(intExtra2);
                } catch (Throwable th2) {
                    TLogger.e("PushMessageHandler", "NotificationManager.cancel error: " + th2.toString());
                }
            }
        });
    }

    public static e a(Context context) {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e();
                    b.f6177d = context.getApplicationContext();
                    com.tencent.android.tpush.service.b.b(b.f6177d);
                }
            }
        }
        return b;
    }

    public void a(Intent intent) {
        CommonWorkingThread.getInstance().execute(new a(this.f6177d, intent, null));
    }

    public static synchronized boolean a(Long l2) {
        synchronized (e.class) {
            try {
                if (a == null) {
                    a = new ArrayList<>();
                }
            } finally {
                return true;
            }
            if (a.contains(l2)) {
                return false;
            }
            a.add(l2);
            if (a.size() > 200) {
                a.remove(0);
            }
            return true;
        }
    }

    public synchronized void a(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - f6176c > 120000 || z) {
            f6176c = currentTimeMillis;
            CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.message.e.3
                @Override // com.tencent.tpns.baseapi.base.util.TTask
                public void TRun() {
                    ArrayList<Intent> newCachedMsgIntentList;
                    if (e.this.f6177d == null || i.b(e.this.f6177d.getPackageName()) || (newCachedMsgIntentList = MessageManager.getInstance().getNewCachedMsgIntentList(e.this.f6177d)) == null || newCachedMsgIntentList.size() <= 0) {
                        return;
                    }
                    if (XGPushConfig.enableDebug) {
                        TLogger.d("PushMessageHandler", "Action -> trySendCachedMsg with CachedMsgList size = " + newCachedMsgIntentList.size());
                    }
                    for (int i2 = 0; i2 < newCachedMsgIntentList.size(); i2++) {
                        try {
                            e.this.c(newCachedMsgIntentList.get(i2));
                        } catch (Throwable th) {
                            TLogger.e("PushMessageHandler", "", th);
                        }
                    }
                }
            });
        }
    }
}
