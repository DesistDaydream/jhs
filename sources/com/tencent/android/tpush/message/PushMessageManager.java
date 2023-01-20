package com.tencent.android.tpush.message;

import android.content.Context;
import android.content.Intent;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;

/* loaded from: classes3.dex */
public class PushMessageManager {
    public static final int CUSTOM_LAYOUT_TYPE_1 = 1;
    public static final int CUSTOM_LAYOUT_TYPE_2 = 2;
    public static final int CUSTOM_LAYOUT_TYPE_3 = 3;
    public static final int MESSAGE_TYPE_CLOUD_CTRL = 1000;
    public static final int MESSAGE_TYPE_CTRL = 3;
    public static final int MESSAGE_TYPE_IN_MSG = 7;
    public static final int MESSAGE_TYPE_NOTIFICATION = 1;
    public static final int MESSAGE_TYPE_TEXT = 2;

    /* renamed from: m  reason: collision with root package name */
    private Context f6144m;
    private Intent n;
    private long a = -1;
    private long b = -1;

    /* renamed from: c  reason: collision with root package name */
    private long f6134c = -1;

    /* renamed from: d  reason: collision with root package name */
    private String f6135d = "";

    /* renamed from: e  reason: collision with root package name */
    private long f6136e = -1;

    /* renamed from: f  reason: collision with root package name */
    private String f6137f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f6138g = "";

    /* renamed from: h  reason: collision with root package name */
    private long f6139h = -1;

    /* renamed from: i  reason: collision with root package name */
    private long f6140i = -1;

    /* renamed from: j  reason: collision with root package name */
    private String f6141j = "";

    /* renamed from: k  reason: collision with root package name */
    private String f6142k = "";

    /* renamed from: l  reason: collision with root package name */
    private String f6143l = "";
    public int pushChannel = 100;
    public long pushTime = 0;
    public long targetType = 0;
    public long source = 0;
    private a o = null;
    private int p = 0;

    private PushMessageManager(Context context, Intent intent) {
        this.f6144m = null;
        this.n = null;
        this.f6144m = context;
        this.n = intent;
    }

    public static PushMessageManager getInstance(Context context, Intent intent) {
        PushMessageManager pushMessageManager = new PushMessageManager(context, intent);
        String decrypt = Rijndael.decrypt(intent.getStringExtra("content"));
        TLogger.d("PushMessageManager", "PushMessageManager content:" + decrypt);
        pushMessageManager.f6137f = decrypt;
        String decrypt2 = Rijndael.decrypt(intent.getStringExtra(MessageKey.MSG_IN_MSG));
        TLogger.d("PushMessageManager", "PushMessageManager inMsg:" + decrypt2);
        pushMessageManager.f6138g = decrypt2;
        pushMessageManager.b = intent.getLongExtra("msgId", -1L);
        TLogger.d("PushMessageManager", "PushMessageManager msgId:" + pushMessageManager.b);
        pushMessageManager.f6134c = intent.getLongExtra("accId", -1L);
        pushMessageManager.f6135d = intent.getStringExtra(Constants.XG_SYS_INTENT_KEY_THIRD_APP);
        pushMessageManager.f6136e = intent.getLongExtra("busiMsgId", -1L);
        pushMessageManager.a = intent.getLongExtra(MessageKey.MSG_CHANNEL_ID, -1L);
        pushMessageManager.f6139h = intent.getLongExtra("timestamps", -1L);
        pushMessageManager.f6140i = intent.getLongExtra("type", -1L);
        TLogger.d("PushMessageManager", "PushMessageManager type:" + pushMessageManager.f6140i);
        int intExtra = intent.getIntExtra("pushChannel", 100);
        pushMessageManager.pushTime = intent.getLongExtra(MessageKey.MSG_PUSH_TIME, -1L);
        pushMessageManager.pushChannel = intExtra;
        String stringExtra = intent.getStringExtra("group_id");
        pushMessageManager.f6141j = stringExtra;
        if (i.b(stringExtra)) {
            pushMessageManager.f6141j = intent.getStringExtra("groupId");
        }
        pushMessageManager.targetType = intent.getLongExtra(MessageKey.MSG_TARGET_TYPE, 0L);
        pushMessageManager.source = intent.getLongExtra(MessageKey.MSG_SOURCE, 0L);
        pushMessageManager.f6142k = intent.getStringExtra(MessageKey.MSG_TEMPLATE_ID);
        pushMessageManager.f6143l = intent.getStringExtra(MessageKey.MSG_TRACE_ID);
        a aVar = null;
        int i2 = (int) pushMessageManager.f6140i;
        if (i2 == 1) {
            aVar = new d(decrypt);
        } else if (i2 == 2) {
            aVar = new f(decrypt);
        } else if (i2 == 3) {
            MessageManager.getInstance().onCrtlMsgHandle(context, decrypt);
            XGPushManager.msgAck(context, pushMessageManager);
        } else if (i2 != 7 && i2 != 1000) {
            TLogger.e("PushMessageManager", "error type for message, drop it, type:" + pushMessageManager.f6140i + ",intent:" + intent);
            XGPushManager.msgAck(context, pushMessageManager);
        }
        if (aVar != null) {
            pushMessageManager.o = aVar;
            aVar.a();
        }
        pushMessageManager.p = intent.getIntExtra(MessageKey.MSG_REVOKEID, 0);
        return pushMessageManager;
    }

    public long getAccessId() {
        return this.f6134c;
    }

    public String getAppPkgName() {
        return this.f6135d;
    }

    public long getBusiMsgId() {
        return this.f6136e;
    }

    public long getChannelId() {
        return this.a;
    }

    public String getContent() {
        return this.f6137f;
    }

    public Context getContext() {
        return this.f6144m;
    }

    public String getGroupId() {
        return this.f6141j;
    }

    public String getInMsg() {
        return this.f6138g;
    }

    public Intent getIntent() {
        return this.n;
    }

    public a getMessageHolder() {
        return this.o;
    }

    public long getMsgId() {
        return this.b;
    }

    public int getRevokeId() {
        return this.p;
    }

    public long getSource() {
        return this.source;
    }

    public long getTargetType() {
        return this.targetType;
    }

    public String getTemplateId() {
        return this.f6142k;
    }

    public long getTimestamps() {
        return this.f6139h;
    }

    public String getTraceId() {
        return this.f6143l;
    }

    public long getType() {
        return this.f6140i;
    }

    public void setAppPkgName(String str) {
        this.f6135d = str;
    }

    public void setChannelId(long j2) {
        this.a = j2;
    }

    public void setGroupId(String str) {
        this.f6141j = str;
    }

    public void setSource(long j2) {
        this.source = j2;
    }

    public void setTargetType(long j2) {
        this.targetType = j2;
    }

    public void showNotifacition() {
        if (this.o.b() != 1) {
            return;
        }
        b.a(this.f6144m, this);
    }

    public String toString() {
        return "PushMessageManager [msgId=" + this.b + ", accessId=" + this.f6134c + ", busiMsgId=" + this.f6136e + ", content=" + this.f6137f + ", timestamps=" + this.f6139h + ", type=" + this.f6140i + ", intent=" + this.n + ", messageHolder=" + this.o + ", appPkgName=" + this.f6135d + ", revokeId=" + this.p + ", templateId=" + this.f6142k + ", traceId=" + this.f6143l + "]";
    }
}
