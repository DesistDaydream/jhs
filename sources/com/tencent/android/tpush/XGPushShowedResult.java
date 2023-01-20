package com.tencent.android.tpush;

import android.content.Intent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* loaded from: classes3.dex */
public class XGPushShowedResult implements XGIResult {
    public long a = 0;
    public String b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f6032c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f6033d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f6034e = "";

    /* renamed from: f  reason: collision with root package name */
    public int f6035f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f6036g = NotificationAction.activity.getType();

    /* renamed from: h  reason: collision with root package name */
    public int f6037h = 100;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6038i = false;
    public String templateId = "";
    public String traceId = "";
    public static final int NOTIFICATION_ACTION_ACTIVITY = NotificationAction.activity.getType();
    public static final int NOTIFICATION_ACTION_URL = NotificationAction.url.getType();
    public static final int NOTIFICATION_ACTION_INTENT = NotificationAction.intent.getType();
    public static final int NOTIFICATION_ACTION_PACKAGE = NotificationAction.action_package.getType();
    public static final int NOTIFICATION_ACTION_INTENT_WIHT_ACTION = NotificationAction.intent_with_action.getType();

    public String getActivity() {
        return this.f6034e;
    }

    public String getContent() {
        return this.f6032c;
    }

    public String getCustomContent() {
        return this.f6033d;
    }

    public long getMsgId() {
        return this.a;
    }

    public int getNotifactionId() {
        return this.f6035f;
    }

    public int getNotificationActionType() {
        return this.f6036g;
    }

    public int getPushChannel() {
        return this.f6037h;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getTitle() {
        return this.b;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public boolean isCustomLayout() {
        return this.f6038i;
    }

    @Override // com.tencent.android.tpush.XGIResult
    public void parseIntent(Intent intent) {
        this.a = intent.getLongExtra("msgId", -1L);
        this.f6034e = intent.getStringExtra("activity");
        this.b = Rijndael.decrypt(intent.getStringExtra("title"));
        this.f6032c = Rijndael.decrypt(intent.getStringExtra("content"));
        this.f6036g = intent.getIntExtra("notificationActionType", NotificationAction.activity.getType());
        this.f6033d = Rijndael.decrypt(intent.getStringExtra("custom_content"));
        this.f6035f = intent.getIntExtra(MessageKey.NOTIFACTION_ID, 0);
        this.f6037h = intent.getIntExtra("PUSH.CHANNEL", 100);
        this.templateId = intent.getStringExtra(MessageKey.MSG_TEMPLATE_ID);
        this.traceId = intent.getStringExtra(MessageKey.MSG_TRACE_ID);
        this.f6038i = intent.getBooleanExtra(Constants.FLAG_IS_SHOW_IN_CUSTOM_LAYOUT, false);
        int i2 = this.f6037h;
        if (i2 == 101 || i2 == 99) {
            try {
                this.f6034e = URLDecoder.decode(this.f6034e, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                TLogger.d("XGPushShowedResult", "parseIntent activityName :" + e2.toString());
            }
        }
    }

    public String toString() {
        return "XGPushShowedResult [msgId = " + this.a + ", title = " + this.b + ", content = " + this.f6032c + ", customContent=" + this.f6033d + ", activity = " + this.f6034e + ", notificationActionType = " + this.f6036g + ", pushChannel = " + this.f6037h + ", templateId = " + this.templateId + ", traceId = " + this.traceId + ", isCustomLayout = " + this.f6038i + "]";
    }
}
