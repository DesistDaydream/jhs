package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.hd;
import com.xiaomi.push.hu;
import java.util.List;

/* loaded from: classes3.dex */
public class PushMessageHelper {
    public static final String ERROR_MESSAGE = "error_message";
    public static final String ERROR_TYPE = "error_type";
    public static final String ERROR_TYPE_NEED_PERMISSION = "error_lack_of_permission";
    public static final String KEY_COMMAND = "key_command";
    public static final String KEY_MESSAGE = "key_message";
    public static final int MESSAGE_COMMAND = 3;
    public static final int MESSAGE_ERROR = 5;
    public static final int MESSAGE_QUIT = 4;
    public static final int MESSAGE_RAW = 1;
    public static final int MESSAGE_SENDMESSAGE = 2;
    public static final String MESSAGE_TYPE = "message_type";
    public static final int PUSH_MODE_BROADCAST = 2;
    public static final int PUSH_MODE_CALLBACK = 1;
    private static int pushMode;

    public static MiPushCommandMessage generateCommandMessage(String str, List<String> list, long j2, String str2, String str3, List<String> list2) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.setCommand(str);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(j2);
        miPushCommandMessage.setReason(str2);
        miPushCommandMessage.setCategory(str3);
        miPushCommandMessage.setAutoMarkPkgs(list2);
        return miPushCommandMessage;
    }

    public static MiPushMessage generateMessage(hu huVar, hd hdVar, boolean z) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.setMessageId(huVar.c());
        if (!TextUtils.isEmpty(huVar.j())) {
            miPushMessage.setMessageType(1);
            miPushMessage.setAlias(huVar.j());
        } else if (!TextUtils.isEmpty(huVar.h())) {
            miPushMessage.setMessageType(2);
            miPushMessage.setTopic(huVar.h());
        } else if (TextUtils.isEmpty(huVar.r())) {
            miPushMessage.setMessageType(0);
        } else {
            miPushMessage.setMessageType(3);
            miPushMessage.setUserAccount(huVar.r());
        }
        miPushMessage.setCategory(huVar.p());
        if (huVar.l() != null) {
            miPushMessage.setContent(huVar.l().f());
        }
        if (hdVar != null) {
            if (TextUtils.isEmpty(miPushMessage.getMessageId())) {
                miPushMessage.setMessageId(hdVar.b());
            }
            if (TextUtils.isEmpty(miPushMessage.getTopic())) {
                miPushMessage.setTopic(hdVar.f());
            }
            miPushMessage.setDescription(hdVar.j());
            miPushMessage.setTitle(hdVar.h());
            miPushMessage.setNotifyType(hdVar.l());
            miPushMessage.setNotifyId(hdVar.q());
            miPushMessage.setPassThrough(hdVar.o());
            miPushMessage.setExtra(hdVar.s());
        }
        miPushMessage.setNotified(z);
        return miPushMessage;
    }

    public static hd generateMessage(MiPushMessage miPushMessage) {
        hd hdVar = new hd();
        hdVar.a(miPushMessage.getMessageId());
        hdVar.b(miPushMessage.getTopic());
        hdVar.d(miPushMessage.getDescription());
        hdVar.c(miPushMessage.getTitle());
        hdVar.c(miPushMessage.getNotifyId());
        hdVar.a(miPushMessage.getNotifyType());
        hdVar.b(miPushMessage.getPassThrough());
        hdVar.a(miPushMessage.getExtra());
        return hdVar;
    }

    public static int getPushMode(Context context) {
        if (pushMode == 0) {
            setPushMode(isUseCallbackPushMode(context) ? 1 : 2);
        }
        return pushMode;
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            if (queryBroadcastReceivers != null) {
                if (!queryBroadcastReceivers.isEmpty()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isUseCallbackPushMode(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return isIntentAvailable(context, intent);
    }

    public static void sendCommandMessageBroadcast(Context context, MiPushCommandMessage miPushCommandMessage) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 3);
        intent.putExtra(KEY_COMMAND, miPushCommandMessage);
        new PushServiceReceiver().onReceive(context, intent);
    }

    public static void sendQuitMessageBroadcast(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 4);
        new PushServiceReceiver().onReceive(context, intent);
    }

    private static void setPushMode(int i2) {
        pushMode = i2;
    }
}
