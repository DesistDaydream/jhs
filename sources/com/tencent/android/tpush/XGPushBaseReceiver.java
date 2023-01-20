package com.tencent.android.tpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.data.MessageId;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.PushMessageManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import e.t.u.b0;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class XGPushBaseReceiver extends BroadcastReceiver {
    public static final int SUCCESS = 0;
    private long a = 0;

    private void d(Context context, Intent intent) {
        XGPushConfig.changeHuaweiBadgeNum(context, -1);
        int intExtra = intent.getIntExtra("PUSH.CHANNEL", 100);
        long longExtra = intent.getLongExtra("accId", 0L);
        List<Long> accessidList = XGPushConfig.getAccessidList(context);
        if (accessidList != null && accessidList.size() > 0) {
            if (accessidList.contains(Long.valueOf(longExtra)) && (intExtra == 100 || intExtra == 101 || intExtra == 99)) {
                XGPushClickedResult xGPushClickedResult = new XGPushClickedResult();
                xGPushClickedResult.parseIntent(intent);
                onNotificationClickedResult(context, xGPushClickedResult);
                return;
            }
            XGPushClickedResult xGPushClickedResult2 = new XGPushClickedResult();
            xGPushClickedResult2.content = intent.getStringExtra("content");
            xGPushClickedResult2.title = intent.getStringExtra("title");
            xGPushClickedResult2.customContent = intent.getStringExtra("custom_content");
            xGPushClickedResult2.pushChannel = intent.getIntExtra("PUSH.CHANNEL", 0);
            xGPushClickedResult2.actionType = intent.getIntExtra("action", 0);
            xGPushClickedResult2.customContent = intent.getStringExtra("custom_content");
            xGPushClickedResult2.msgId = intent.getLongExtra("msgId", 0L);
            xGPushClickedResult2.notificationActionType = intent.getIntExtra("notificationActionType", NotificationAction.activity.getType());
            xGPushClickedResult2.activityName = intent.getStringExtra("activity");
            xGPushClickedResult2.templateId = intent.getStringExtra(MessageKey.MSG_TEMPLATE_ID);
            xGPushClickedResult2.traceId = intent.getStringExtra(MessageKey.MSG_TRACE_ID);
            onNotificationClickedResult(context, xGPushClickedResult2);
            return;
        }
        TLogger.e("XGPushBaseReceiver", "accessIdList " + accessidList + " local accessid " + longExtra);
        TLogger.e("XGPushBaseReceiver", "give up msg");
    }

    private void e(Context context, Intent intent, int i2) {
        XGPushRegisterResult xGPushRegisterResult = new XGPushRegisterResult();
        if (intent.getBooleanExtra(Constants.FLAG_REGISTER_FROM_CLOUDCTRL, false)) {
            return;
        }
        if (intent.getIntExtra("PUSH.CHANNEL", 100) == 100) {
            xGPushRegisterResult.parseIntent(intent);
        } else {
            xGPushRegisterResult.f6031h = intent.getIntExtra("PUSH.CHANNEL", 0);
            String stringExtra = intent.getStringExtra("other_push_token");
            xGPushRegisterResult.f6030g = stringExtra;
            if (i2 == 0 && !i.b(stringExtra)) {
                com.tencent.android.tpush.c.b.a(context);
            }
        }
        onRegisterResult(context, i2, xGPushRegisterResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context, Intent intent) {
        XGPushTextMessage xGPushTextMessage = new XGPushTextMessage();
        xGPushTextMessage.a = intent.getLongExtra("msgId", 0L);
        xGPushTextMessage.f6041e = intent.getIntExtra("PUSH.CHANNEL", 100);
        xGPushTextMessage.b = Rijndael.decrypt(intent.getStringExtra("title"));
        xGPushTextMessage.f6039c = Rijndael.decrypt(intent.getStringExtra("content"));
        xGPushTextMessage.f6040d = Rijndael.decrypt(intent.getStringExtra("custom_content"));
        xGPushTextMessage.f6042f = intent.getStringExtra(MessageKey.MSG_TEMPLATE_ID);
        xGPushTextMessage.f6043g = intent.getStringExtra(MessageKey.MSG_TRACE_ID);
        xGPushTextMessage.a(intent);
        onInMsgReceivedResult(context, xGPushTextMessage);
    }

    private void g(Context context, Intent intent) {
        XGPushShowedResult xGPushShowedResult = new XGPushShowedResult();
        xGPushShowedResult.parseIntent(intent);
        onInMsgShowedResult(context, xGPushShowedResult);
    }

    private void h(Context context, Intent intent) {
        XGPushClickedResult xGPushClickedResult = new XGPushClickedResult();
        xGPushClickedResult.parseIntent(intent);
        onInMsgClickedResult(context, xGPushClickedResult);
    }

    public abstract void onDeleteAccountResult(Context context, int i2, String str);

    public abstract void onDeleteAttributeResult(Context context, int i2, String str);

    public abstract void onDeleteTagResult(Context context, int i2, String str);

    public void onInMsgClickedResult(Context context, XGPushClickedResult xGPushClickedResult) {
    }

    public void onInMsgReceivedResult(Context context, XGPushTextMessage xGPushTextMessage) {
    }

    public void onInMsgShowedResult(Context context, XGPushShowedResult xGPushShowedResult) {
    }

    public abstract void onNotificationClickedResult(Context context, XGPushClickedResult xGPushClickedResult);

    public abstract void onNotificationShowedResult(Context context, XGPushShowedResult xGPushShowedResult);

    public abstract void onQueryTagsResult(Context context, int i2, String str, String str2);

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context context, final Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.XGPushBaseReceiver.1
            @Override // com.tencent.tpns.baseapi.base.util.TTask
            public void TRun() {
                try {
                    if (i.a(context) > 0) {
                        return;
                    }
                    String action = intent.getAction();
                    if ("com.tencent.android.xg.vip.action.PUSH_MESSAGE".equals(action)) {
                        if (intent.getLongExtra("type", -1L) == 7) {
                            XGPushBaseReceiver.this.f(context, intent);
                        } else {
                            XGPushBaseReceiver.this.a(context, intent);
                        }
                    } else if ("com.tencent.android.xg.vip.action.FEEDBACK".equals(action)) {
                        XGPushBaseReceiver.this.b(context, intent);
                    } else {
                        TLogger.e("XGPushBaseReceiver", "未知的action:" + action);
                    }
                } catch (Throwable th) {
                    TLogger.e("XGPushBaseReceiver", "onReceive handle error.", th);
                }
            }
        });
    }

    public abstract void onRegisterResult(Context context, int i2, XGPushRegisterResult xGPushRegisterResult);

    public abstract void onSetAccountResult(Context context, int i2, String str);

    public abstract void onSetAttributeResult(Context context, int i2, String str);

    public abstract void onSetTagResult(Context context, int i2, String str);

    public abstract void onTextMessage(Context context, XGPushTextMessage xGPushTextMessage);

    public abstract void onUnregisterResult(Context context, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("PUSH.CHANNEL", 100);
        if (intExtra == 100) {
            PushMessageManager pushMessageManager = PushMessageManager.getInstance(context, intent);
            if (pushMessageManager.getMessageHolder().b() == 2) {
                XGPushTextMessage xGPushTextMessage = new XGPushTextMessage();
                xGPushTextMessage.a = pushMessageManager.getMsgId();
                xGPushTextMessage.f6041e = intExtra;
                xGPushTextMessage.b = pushMessageManager.getMessageHolder().d();
                xGPushTextMessage.f6039c = pushMessageManager.getMessageHolder().e();
                xGPushTextMessage.f6040d = pushMessageManager.getMessageHolder().f();
                xGPushTextMessage.f6042f = pushMessageManager.getTemplateId();
                xGPushTextMessage.f6043g = pushMessageManager.getTraceId();
                xGPushTextMessage.a(intent);
                onTextMessage(context, xGPushTextMessage);
                return;
            }
            return;
        }
        XGPushTextMessage xGPushTextMessage2 = new XGPushTextMessage();
        xGPushTextMessage2.a = intent.getLongExtra("msgId", -1L);
        xGPushTextMessage2.f6041e = intExtra;
        xGPushTextMessage2.f6039c = intent.getStringExtra("content");
        xGPushTextMessage2.b = intent.getStringExtra("title");
        xGPushTextMessage2.f6040d = intent.getStringExtra("custom_content");
        xGPushTextMessage2.f6042f = intent.getStringExtra(MessageKey.MSG_TEMPLATE_ID);
        xGPushTextMessage2.f6043g = intent.getStringExtra(MessageKey.MSG_TRACE_ID);
        intent.putExtra("accId", XGPushConfig.getAccessId(context));
        e(context, intent);
        onTextMessage(context, xGPushTextMessage2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("TPUSH.FEEDBACK", -1);
        int intExtra2 = intent.getIntExtra("TPUSH.ERRORCODE", -1);
        TLogger.i("XGPushBaseReceiver", "action - feedbackHandler, feedbackType: " + intExtra);
        switch (intExtra) {
            case 1:
                e(context, intent, intExtra2);
                return;
            case 2:
                new XGPushRegisterResult().parseIntent(intent);
                onUnregisterResult(context, intExtra2);
                return;
            case 3:
                d(context, intent, intExtra2);
                return;
            case 4:
                d(context, intent);
                return;
            case 5:
                c(context, intent);
                return;
            case 6:
                c(context, intent, intExtra2);
                return;
            case 7:
                b(context, intent, intExtra2);
                return;
            case 8:
                a(context, intent, intExtra2);
                return;
            case 9:
            default:
                TLogger.e("XGPushBaseReceiver", "未知的feedbackType:" + intExtra);
                return;
            case 10:
                g(context, intent);
                return;
            case 11:
                h(context, intent);
                return;
        }
    }

    private void c(Context context, Intent intent) {
        XGPushShowedResult xGPushShowedResult = new XGPushShowedResult();
        int intExtra = intent.getIntExtra("PUSH.CHANNEL", 100);
        if (intExtra != 100 && intExtra != 101 && intExtra != 99) {
            xGPushShowedResult.f6032c = intent.getStringExtra("content");
            xGPushShowedResult.b = intent.getStringExtra("title");
            xGPushShowedResult.f6033d = intent.getStringExtra("custom_content");
            xGPushShowedResult.f6037h = intent.getIntExtra("PUSH.CHANNEL", 0);
            intent.putExtra("accId", XGPushConfig.getAccessId(context));
        } else {
            xGPushShowedResult.parseIntent(intent);
        }
        onNotificationShowedResult(context, xGPushShowedResult);
    }

    private void e(Context context, Intent intent) {
        MessageId messageId = new MessageId();
        messageId.id = intent.getLongExtra("msgId", 0L);
        messageId.isAck = (short) 0;
        messageId.accessId = intent.getLongExtra("accId", 0L);
        messageId.host = intent.getLongExtra(MessageKey.MSG_EXTRA_HOST, 0L);
        messageId.port = intent.getIntExtra(MessageKey.MSG_EXTRA_PORT, 0);
        messageId.pact = intent.getByteExtra(MessageKey.MSG_EXTRA_PACT, (byte) 0);
        messageId.apn = DeviceInfos.getNetworkType(context);
        messageId.isp = i.o(context);
        messageId.serviceHost = intent.getStringExtra(MessageKey.MSG_SERVICE_PACKAGE_NAME);
        messageId.receivedTime = System.currentTimeMillis();
        messageId.pkgName = context.getPackageName();
        messageId.busiMsgId = intent.getLongExtra("busiMsgId", 0L);
        messageId.timestamp = intent.getLongExtra("timestamps", 0L);
        messageId.msgType = intent.getLongExtra("type", 0L);
        messageId.multiPkg = intent.getLongExtra(MessageKey.MSG_CREATE_MULTIPKG, 0L);
        messageId.date = new SimpleDateFormat(b0.a.t).format(new Date());
        String stringExtra = intent.getStringExtra("group_id");
        if (!i.b(stringExtra)) {
            messageId.groupId = stringExtra;
        }
        intent.putExtra("MessageId", messageId);
        Intent intent2 = new Intent(context.getPackageName() + "com.tencent.android.xg.vip.action.MSG_ACK.V4");
        intent2.putExtras(intent);
        BroadcastAgent.sendBroadcast(context, intent2);
    }

    private void c(Context context, Intent intent, int i2) {
        String decrypt = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_ACCOUNT_NAME));
        int intExtra = intent.getIntExtra(Constants.FLAG_ACCOUNT_OP_TYPE, -1);
        String stringExtra = intent.getStringExtra(Constants.FLAG_ACCOUNT_FEEDBACK);
        if (intExtra == 1) {
            onDeleteAccountResult(context, i2, stringExtra);
        } else if (i.b(decrypt)) {
        } else {
            if (intExtra == 0 || intExtra == 2 || intExtra == 6) {
                onSetAccountResult(context, i2, stringExtra);
            } else if (intExtra != 3 && intExtra != 1 && intExtra != 7) {
                TLogger.e("XGPushBaseReceiver", "错误的帐号处理类型：" + intExtra + " ,accountName：" + decrypt);
            } else {
                onDeleteAccountResult(context, i2, stringExtra);
            }
        }
    }

    private void b(Context context, Intent intent, int i2) {
        String decrypt = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_ATTRIBUTES_NAME));
        if (i.b(decrypt)) {
            return;
        }
        int intExtra = intent.getIntExtra(Constants.FLAG_ATTRIBUTES_TYPE, -1);
        String stringExtra = intent.getStringExtra(Constants.FLAG_ATTRIBUTES_OPER_NAME);
        TLogger.i("XGPushBaseReceiver", "attributes, opType:" + intExtra + " ,attributesName:" + decrypt + ", operateName:" + stringExtra);
        if (intExtra == 2 || intExtra == 1) {
            onSetAttributeResult(context, i2, stringExtra);
        } else if (intExtra != 4 && intExtra != 3) {
            TLogger.e("XGPushBaseReceiver", "error attributes：" + intExtra + " ,attributesName：" + decrypt + ", intent:" + intent.getExtras());
        } else {
            onDeleteAttributeResult(context, i2, stringExtra);
        }
    }

    private void d(Context context, Intent intent, int i2) {
        String decrypt = Rijndael.decrypt(intent.getStringExtra(Constants.FLAG_TAG_NAME));
        int intExtra = intent.getIntExtra(Constants.FLAG_TAG_TYPE, -1);
        String stringExtra = intent.getStringExtra(Constants.FLAG_TAG_OPER_NAME);
        if (intExtra == 8) {
            onDeleteTagResult(context, i2, stringExtra);
        } else if (i.b(decrypt)) {
        } else {
            if (intExtra == 1 || intExtra == 6 || intExtra == 5) {
                onSetTagResult(context, i2, stringExtra);
            } else if (intExtra != 2 && intExtra != 7 && intExtra != 8) {
                TLogger.e("XGPushBaseReceiver", "错误的标签处理类型：" + intExtra + " ,标签名：" + decrypt);
            } else {
                onDeleteTagResult(context, i2, stringExtra);
            }
        }
    }

    private void a(Context context, Intent intent, int i2) {
        try {
            String stringExtra = intent.getStringExtra("data");
            onQueryTagsResult(context, i2, Rijndael.decrypt(stringExtra), intent.getStringExtra(Constants.FLAG_QUERY_TAGS_OPER_NAME));
        } catch (Throwable th) {
            TLogger.e("XGPushBaseReceiver", "feekbackQueryTags:", th);
        }
    }
}
