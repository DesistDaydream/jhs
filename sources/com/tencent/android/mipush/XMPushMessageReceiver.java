package com.tencent.android.mipush;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import e.k.a.a.a.c;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class XMPushMessageReceiver extends PushMessageReceiver {
    private static String errMsg;

    /* JADX INFO: Access modifiers changed from: private */
    public static String md5(String str) {
        if (str == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i2 = b & 255;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onCommandResult(final Context context, final MiPushCommandMessage miPushCommandMessage) {
        a.a().a(new Runnable() { // from class: com.tencent.android.mipush.XMPushMessageReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                long resultCode;
                String str2;
                try {
                    Class.forName("com.tencent.android.tpush.service.XGVipPushService");
                    str = "com.tencent.android.xg.vip.action.FEEDBACK";
                } catch (ClassNotFoundException unused) {
                    Log.w(c.a, "[OtherPush_XG_MI] find XGVipPushService error");
                    str = c.f11776c;
                }
                try {
                    Intent intent = new Intent(str);
                    String command = miPushCommandMessage.getCommand();
                    Log.i(c.a, "[OtherPush_XG_MI] onCommandResult - command: " + command + ", result code: " + miPushCommandMessage.getResultCode());
                    List<String> commandArguments = miPushCommandMessage.getCommandArguments();
                    String str3 = null;
                    String str4 = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
                    if (commandArguments != null && commandArguments.size() > 1) {
                        str3 = commandArguments.get(1);
                    }
                    String str5 = "";
                    if (MiPushClient.COMMAND_REGISTER.equals(command)) {
                        String str6 = "errCode : " + miPushCommandMessage.getResultCode() + ", errMsg : unknown";
                        if (miPushCommandMessage.getResultCode() == 0) {
                            intent.putExtra("TPUSH.ERRORCODE", 0);
                            Log.i(c.a, "[OtherPush_XG_MI] register success， regid is ：" + str4);
                            str2 = "errCode : 0, errMsg : success";
                        } else {
                            if (miPushCommandMessage.getResultCode() == 70000002) {
                                intent.putExtra("TPUSH.ERRORCODE", (int) miPushCommandMessage.getResultCode());
                                Log.i(c.a, "[OtherPush_XG_MI] register failed， arg1: " + str4 + "arg2:" + str3 + ",code :" + miPushCommandMessage.getResultCode());
                            } else if (miPushCommandMessage.getResultCode() == 70000004) {
                                intent.putExtra("TPUSH.ERRORCODE", (int) miPushCommandMessage.getResultCode());
                                Log.i(c.a, "[OtherPush_XG_MI] register failed， arg1: " + str4 + "arg2:" + str3 + ",code :" + miPushCommandMessage.getResultCode());
                            } else if (miPushCommandMessage.getResultCode() == 70000003) {
                                intent.putExtra("TPUSH.ERRORCODE", (int) miPushCommandMessage.getResultCode());
                                Log.i(c.a, "[OtherPush_XG_MI] register failed， arg1: " + str4 + "arg2:" + str3 + ",code :" + miPushCommandMessage.getResultCode());
                            } else if (miPushCommandMessage.getResultCode() == 70000001) {
                                intent.putExtra("TPUSH.ERRORCODE", (int) miPushCommandMessage.getResultCode());
                                Log.i(c.a, "[OtherPush_XG_MI] register failed， arg1: " + str4 + "arg2:" + str3 + ",code :" + miPushCommandMessage.getResultCode());
                            } else {
                                intent.putExtra("TPUSH.ERRORCODE", (int) miPushCommandMessage.getResultCode());
                                Log.w(c.a, "[OtherPush_XG_MI] register failed, errorCode: " + miPushCommandMessage.getResultCode() + ", reason: " + miPushCommandMessage.getReason());
                            }
                            str2 = str6;
                            str4 = "";
                        }
                        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("tpush.vip.shareprefs", 0);
                        if (XMPushMessageReceiver.errMsg == null || XMPushMessageReceiver.errMsg.length() <= 0) {
                            try {
                                String unused2 = XMPushMessageReceiver.errMsg = sharedPreferences.getString(XMPushMessageReceiver.md5(Constants.OTHER_PUSH_ERROR_CODE), "");
                            } catch (Throwable th) {
                                Log.d(c.a, "[OtherPush_XG_MI] onCommandResult read returnMsg from sp error: " + th.getMessage());
                            }
                        }
                        if (str2 != null && !str2.equals(XMPushMessageReceiver.errMsg)) {
                            String unused3 = XMPushMessageReceiver.errMsg = str2;
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString(XMPushMessageReceiver.md5(Constants.OTHER_PUSH_ERROR_CODE), XMPushMessageReceiver.errMsg);
                            edit.apply();
                        }
                        str5 = str4;
                    } else {
                        if (MiPushClient.COMMAND_SET_ALIAS.equals(command)) {
                            resultCode = miPushCommandMessage.getResultCode();
                        } else if (MiPushClient.COMMAND_UNSET_ALIAS.equals(command)) {
                            resultCode = miPushCommandMessage.getResultCode();
                        } else if (MiPushClient.COMMAND_SUBSCRIBE_TOPIC.equals(command)) {
                            resultCode = miPushCommandMessage.getResultCode();
                        } else if (MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC.equals(command)) {
                            resultCode = miPushCommandMessage.getResultCode();
                        } else if (MiPushClient.COMMAND_SET_ACCEPT_TIME.equals(command)) {
                            miPushCommandMessage.getResultCode();
                        }
                        int i2 = (resultCode > 0L ? 1 : (resultCode == 0L ? 0 : -1));
                    }
                    intent.putExtra("other_push_token", str5);
                    intent.putExtra("TPUSH.FEEDBACK", 1);
                    intent.putExtra("PUSH.CHANNEL", 103);
                    intent.putExtra("pushChannel", 103);
                    intent.setPackage(context.getPackageName());
                    context.sendBroadcast(intent);
                } catch (Throwable th2) {
                    Log.w(c.a, "[OtherPush_XG_MI] onCommandResult ", th2);
                }
            }
        });
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        try {
            Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            str = "com.tencent.android.xg.vip.action.FEEDBACK";
        } catch (ClassNotFoundException unused) {
            Log.w(c.a, "[OtherPush_XG_MI] find XGVipPushService error");
            str = c.f11776c;
        }
        try {
            Log.i(c.a, "[OtherPush_XG_MI] onNotificationMessageArrived->  Title: " + miPushMessage.getTitle() + " Content: " + miPushMessage.getContent() + " Extra = " + miPushMessage.getExtra().toString() + "description :" + miPushMessage.getDescription());
            Intent intent = new Intent(str);
            intent.putExtra("TPUSH.FEEDBACK", 5);
            intent.putExtra("pushChannel", 103);
            intent.putExtra("PUSH.CHANNEL", 103);
            intent.putExtra("content", miPushMessage.getDescription());
            intent.putExtra("title", miPushMessage.getTitle());
            intent.putExtra("type", (Serializable) 1L);
            if (miPushMessage.getExtra() != null) {
                intent.putExtra("custom_content", new JSONObject(miPushMessage.getExtra()).toString());
                if (miPushMessage.getExtra().containsKey("msgId") && (str5 = miPushMessage.getExtra().get("msgId")) != null) {
                    intent.putExtra("msgId", Long.valueOf(str5));
                }
                if (miPushMessage.getExtra().containsKey("busiMsgId") && (str4 = miPushMessage.getExtra().get("busiMsgId")) != null) {
                    intent.putExtra("busiMsgId", Long.valueOf(str4));
                }
                if (miPushMessage.getExtra().containsKey("ts")) {
                    String str6 = miPushMessage.getExtra().get("ts");
                    if (str6 != null) {
                        intent.putExtra(MessageKey.MSG_PUSH_TIME, Long.valueOf(str6));
                    } else {
                        intent.putExtra(MessageKey.MSG_PUSH_TIME, System.currentTimeMillis());
                    }
                } else {
                    intent.putExtra(MessageKey.MSG_PUSH_TIME, System.currentTimeMillis());
                }
                if (miPushMessage.getExtra().containsKey("groupId")) {
                    intent.putExtra("groupId", miPushMessage.getExtra().get("groupId"));
                }
                if (miPushMessage.getExtra().containsKey(MessageKey.MSG_TARGET_TYPE) && (str3 = miPushMessage.getExtra().get(MessageKey.MSG_TARGET_TYPE)) != null) {
                    intent.putExtra(MessageKey.MSG_TARGET_TYPE, Long.valueOf(str3));
                }
                if (miPushMessage.getExtra().containsKey(MessageKey.MSG_SOURCE) && (str2 = miPushMessage.getExtra().get(MessageKey.MSG_SOURCE)) != null) {
                    intent.putExtra(MessageKey.MSG_SOURCE, Long.valueOf(str2));
                }
            } else {
                intent.putExtra("custom_content", "");
            }
            intent.putExtra("timestamps", System.currentTimeMillis() / 1000);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            Log.e(c.a, "[OtherPush_XG_MI] onNotificationMessageArrived ", th);
        }
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        String str;
        String str2;
        String str3;
        try {
            Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            str = "com.tencent.android.xg.vip.action.PUSH_MESSAGE";
        } catch (ClassNotFoundException unused) {
            Log.w(c.a, "[OtherPush_XG_MI] find XGVipPushService error");
            str = c.f11777d;
        }
        try {
            Log.i(c.a, "[OtherPush_XG_MI] onReceivePassThroughMessage->  Title: " + miPushMessage.getTitle() + " Content: " + miPushMessage.getContent() + "description :" + miPushMessage.getDescription());
            Intent intent = new Intent(str);
            intent.putExtra("PUSH.CHANNEL", 103);
            intent.putExtra("pushChannel", 103);
            intent.putExtra("content", miPushMessage.getContent());
            intent.putExtra("title", miPushMessage.getTitle());
            intent.putExtra("type", (Serializable) 2L);
            if (miPushMessage.getExtra() != null) {
                intent.putExtra("custom_content", new JSONObject(miPushMessage.getExtra()).toString());
                if (miPushMessage.getExtra().containsKey("msgId") && (str3 = miPushMessage.getExtra().get("msgId")) != null) {
                    intent.putExtra("msgId", Long.valueOf(str3));
                }
                if (miPushMessage.getExtra().containsKey("busiMsgId") && (str2 = miPushMessage.getExtra().get("busiMsgId")) != null) {
                    intent.putExtra("busiMsgId", Long.valueOf(str2));
                }
            } else {
                intent.putExtra("custom_content", "");
            }
            intent.putExtra("timestamps", System.currentTimeMillis() / 1000);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            Log.e(c.a, "[OtherPush_XG_MI] onReceivePassThroughMessage ", th);
        }
    }
}
