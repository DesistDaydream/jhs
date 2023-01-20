package com.tencent.android.vivopush;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.tencent.android.tpush.common.MessageKey;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;
import e.k.a.a.a.c;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class VivoPushMessageReceiver extends OpenClientPushMessageReceiver {
    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onNotificationMessageClicked(Context context, UPSNotificationMessage uPSNotificationMessage) {
        String str;
        String skipContent = uPSNotificationMessage.getSkipContent();
        Log.i(c.a, "[OtherPush_XG_VIVO] onNotificationMessageClicked = " + ("通知点击 msgId " + uPSNotificationMessage.getMsgId() + ", customContent = " + skipContent + ", content = " + uPSNotificationMessage.getContent() + ", title = " + uPSNotificationMessage.getTitle() + ", TragetContent = " + uPSNotificationMessage.getTragetContent() + ", params = " + uPSNotificationMessage.getParams()));
        try {
            Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            str = "com.tencent.android.xg.vip.action.FEEDBACK";
        } catch (ClassNotFoundException unused) {
            Log.w(c.a, "[OtherPush_XG_VIVO] find XGVipPushService error");
            str = c.f11776c;
        }
        try {
            Intent intent = new Intent(str);
            intent.putExtra("TPUSH.FEEDBACK", 4);
            intent.putExtra("PUSH.CHANNEL", 104);
            intent.putExtra("pushChannel", 104);
            intent.putExtra("content", uPSNotificationMessage.getContent());
            intent.putExtra("title", uPSNotificationMessage.getTitle());
            intent.putExtra("custom_content", skipContent);
            intent.putExtra("action", 0);
            intent.putExtra("timestamps", System.currentTimeMillis() / 1000);
            intent.putExtra("type", (Serializable) 1L);
            Map<String, String> params = uPSNotificationMessage.getParams();
            if (params != null) {
                if (params.containsKey("msgId")) {
                    intent.putExtra("msgId", Long.valueOf(params.get("msgId")));
                }
                if (params.containsKey("busiMsgId")) {
                    intent.putExtra("busiMsgId", Long.valueOf(params.get("busiMsgId")));
                }
                if (params.containsKey("ts")) {
                    intent.putExtra(MessageKey.MSG_PUSH_TIME, Long.valueOf(params.get("ts")).longValue() * 1000);
                } else {
                    intent.putExtra(MessageKey.MSG_PUSH_TIME, System.currentTimeMillis());
                }
                if (params.containsKey("groupId")) {
                    intent.putExtra("groupId", params.get("groupId"));
                }
                if (params.containsKey(MessageKey.MSG_TARGET_TYPE)) {
                    intent.putExtra(MessageKey.MSG_TARGET_TYPE, Long.valueOf(params.get(MessageKey.MSG_TARGET_TYPE)));
                }
                if (params.containsKey(MessageKey.MSG_SOURCE)) {
                    intent.putExtra(MessageKey.MSG_SOURCE, Long.valueOf(params.get(MessageKey.MSG_SOURCE)));
                }
                intent.putExtra("custom_content", new JSONObject(params).toString());
            }
            intent.setPackage(context.getPackageName());
            if (uPSNotificationMessage.getSkipType() == 3) {
                Uri parse = Uri.parse(skipContent);
                Intent intent2 = new Intent("android.intent.action.VIEW", parse);
                intent2.addFlags(268435456);
                intent2.setData(parse);
                if (intent2.resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(intent2);
                }
            }
        } catch (Throwable th) {
            Log.e(c.a, "[OtherPush_XG_VIVO] onNotificationMessageClicked ", th);
        }
    }

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onReceiveRegId(Context context, String str) {
        String str2;
        Log.i(c.a, "[OtherPush_XG_VIVO] onReceiveRegId - regId:" + str);
        try {
            Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            str2 = "com.tencent.android.xg.vip.action.FEEDBACK";
        } catch (ClassNotFoundException unused) {
            Log.w(c.a, "[OtherPush_XG_VIVO] find XGVipPushService error");
            str2 = c.f11776c;
        }
        try {
            Intent intent = new Intent(str2);
            intent.putExtra("TPUSH.ERRORCODE", str != null ? 0 : -1);
            intent.putExtra("other_push_token", str);
            intent.putExtra("TPUSH.FEEDBACK", 1);
            intent.putExtra("PUSH.CHANNEL", 104);
            intent.putExtra("pushChannel", 104);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            Log.w(c.a, "[OtherPush_XG_VIVO] onReceiveRegId sendBroadcast error" + th.toString());
        }
    }
}
