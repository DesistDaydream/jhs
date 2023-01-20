package com.tencent.android.mzpush;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.meizu.cloud.pushsdk.MzPushMessageReceiver;
import com.meizu.cloud.pushsdk.handler.MzPushMessage;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import e.k.a.a.a.c;
import java.io.Serializable;
import java.security.MessageDigest;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MZPushMessageReceiver extends MzPushMessageReceiver {
    private static String a;

    private void a(Context context, RegisterStatus registerStatus) {
        String str;
        try {
            String code = registerStatus.getCode();
            if (TextUtils.isEmpty(code)) {
                str = "errCode : null, errMsg : unknown";
            } else {
                if (!code.equals(BasicPushStatus.SUCCESS_CODE) && !code.equals("0")) {
                    str = "errCode : " + code + ", errMsg : unknown";
                }
                str = "errCode : 200, errMsg : success";
            }
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("tpush.vip.shareprefs", 0);
            String str2 = a;
            if (str2 == null || str2.length() <= 0) {
                a = sharedPreferences.getString(a(Constants.OTHER_PUSH_ERROR_CODE), "");
            }
            if (str == null || str.equals(a)) {
                return;
            }
            a = str;
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(a(Constants.OTHER_PUSH_ERROR_CODE), str);
            edit.commit();
        } catch (Throwable th) {
            Log.w(c.a, "[OtherPush_XG_MZ] onRegister save errMsg error: " + th.getMessage());
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onMessage(Context context, String str) {
        String str2;
        try {
            Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            str2 = "com.tencent.android.xg.vip.action.PUSH_MESSAGE";
        } catch (ClassNotFoundException e2) {
            Log.e(c.a, "[OtherPush_XG_MZ] onMessage ", e2);
            str2 = c.f11777d;
        }
        try {
            Log.i(c.a, "[OtherPush_XG_MZ] onMessage: " + str);
            Intent intent = new Intent(str2);
            intent.putExtra("PUSH.CHANNEL", 106);
            intent.putExtra("pushChannel", 106);
            intent.putExtra("content", str);
            intent.putExtra("custom_content", "");
            intent.putExtra("type", (Serializable) 2L);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            Log.e(c.a, "[OtherPush_XG_MZ] onMessage ", th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onNotificationArrived(Context context, MzPushMessage mzPushMessage) {
        String str;
        try {
            Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            str = "com.tencent.android.xg.vip.action.FEEDBACK";
        } catch (ClassNotFoundException e2) {
            Log.e(c.a, "[OtherPush_XG_MZ] onNotificationArrived ", e2);
            str = c.f11776c;
        }
        try {
            Log.i(c.a, "[OtherPush_XG_MZ] onNotificationArrived : title : " + mzPushMessage.getTitle() + " , content = " + mzPushMessage.getContent() + " , selfDefineContentString = " + mzPushMessage.getSelfDefineContentString());
            Intent intent = new Intent(str);
            intent.putExtra("pushChannel", 106);
            intent.putExtra("TPUSH.FEEDBACK", 5);
            intent.putExtra("PUSH.CHANNEL", 106);
            intent.putExtra("content", mzPushMessage.getContent());
            intent.putExtra("title", mzPushMessage.getTitle());
            intent.putExtra("custom_content", mzPushMessage.getSelfDefineContentString());
            intent.putExtra("type", (Serializable) 1L);
            if (mzPushMessage.getSelfDefineContentString() != null && !TextUtils.isEmpty(mzPushMessage.getSelfDefineContentString())) {
                JSONObject jSONObject = new JSONObject(mzPushMessage.getSelfDefineContentString());
                if (!jSONObject.isNull("msgId")) {
                    intent.putExtra("msgId", Long.valueOf(jSONObject.getString("msgId")));
                }
                if (!jSONObject.isNull("busiMsgId")) {
                    intent.putExtra("busiMsgId", Long.valueOf(jSONObject.getString("busiMsgId")).longValue());
                }
                if (!jSONObject.isNull("groupId")) {
                    intent.putExtra("groupId", jSONObject.getString("groupId"));
                }
                if (!jSONObject.isNull("ts")) {
                    intent.putExtra(MessageKey.MSG_PUSH_TIME, Long.valueOf(jSONObject.getString("ts")).longValue() * 1000);
                } else {
                    intent.putExtra(MessageKey.MSG_PUSH_TIME, System.currentTimeMillis());
                }
                if (!jSONObject.isNull(MessageKey.MSG_TARGET_TYPE)) {
                    intent.putExtra(MessageKey.MSG_TARGET_TYPE, Long.valueOf(jSONObject.getString(MessageKey.MSG_TARGET_TYPE)).longValue());
                }
                if (!jSONObject.isNull(MessageKey.MSG_SOURCE)) {
                    intent.putExtra(MessageKey.MSG_SOURCE, Long.valueOf(jSONObject.getString(MessageKey.MSG_SOURCE)).longValue());
                }
            }
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
            super.onNotificationArrived(context, mzPushMessage);
        } catch (Throwable th) {
            Log.e(c.a, "[OtherPush_XG_MZ] onNotificationArrived ", th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onNotificationClicked(Context context, MzPushMessage mzPushMessage) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onNotificationDeleted(Context context, MzPushMessage mzPushMessage) {
        String str;
        try {
            Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            str = "com.tencent.android.xg.vip.action.FEEDBACK";
        } catch (ClassNotFoundException e2) {
            Log.e(c.a, "[OtherPush_XG_MZ] onNotificationDeleted  ", e2);
            str = c.f11776c;
        }
        try {
            Log.i(c.a, "[OtherPush_XG_MZ] onNotificationDeleted title " + mzPushMessage.getTitle() + "content " + mzPushMessage.getContent() + " selfDefineContentString " + mzPushMessage.getSelfDefineContentString());
            super.onNotificationDeleted(context, mzPushMessage);
            Intent intent = new Intent(str);
            intent.putExtra("pushChannel", 106);
            intent.putExtra("TPUSH.FEEDBACK", 4);
            intent.putExtra("PUSH.CHANNEL", 106);
            intent.putExtra("content", mzPushMessage.getContent());
            intent.putExtra("title", mzPushMessage.getTitle());
            intent.putExtra("custom_content", mzPushMessage.getSelfDefineContentString());
            intent.putExtra("action", 2);
            intent.putExtra("timestamps", System.currentTimeMillis() / 1000);
            intent.putExtra("type", (Serializable) 1L);
            if (mzPushMessage.getSelfDefineContentString() != null && !TextUtils.isEmpty(mzPushMessage.getSelfDefineContentString())) {
                JSONObject jSONObject = new JSONObject(mzPushMessage.getSelfDefineContentString());
                if (!jSONObject.isNull("msgId")) {
                    intent.putExtra("msgId", Long.valueOf(jSONObject.getString("msgId")));
                }
                if (!jSONObject.isNull("busiMsgId")) {
                    intent.putExtra("busiMsgId", Long.valueOf(jSONObject.getString("busiMsgId")));
                }
                if (!jSONObject.isNull("ts")) {
                    intent.putExtra(MessageKey.MSG_PUSH_TIME, Long.valueOf(jSONObject.getString("ts")).longValue() * 1000);
                } else {
                    intent.putExtra(MessageKey.MSG_PUSH_TIME, System.currentTimeMillis());
                }
                if (!jSONObject.isNull("groupId")) {
                    intent.putExtra("groupId", jSONObject.getString("groupId"));
                }
            }
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            Log.e(c.a, "[OtherPush_XG_MZ] onNotificationClicked title ", th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onPushStatus(Context context, PushSwitchStatus pushSwitchStatus) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            Log.i(c.a, "[OtherPush_XG_MZ] onReceive : Intent Package" + intent.getPackage() + "///" + intent.describeContents());
            super.onReceive(context, intent);
        } catch (Throwable th) {
            Log.e(c.a, "[OtherPush_XG_MZ] onReceive ", th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    @Deprecated
    public void onRegister(Context context, String str) {
        Log.i(c.a, "[OtherPush_XG_MZ] onRegister - pushId: " + str);
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onRegisterStatus(Context context, RegisterStatus registerStatus) {
        String str;
        try {
            Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            str = "com.tencent.android.xg.vip.action.FEEDBACK";
        } catch (ClassNotFoundException e2) {
            Log.e(c.a, "[OtherPush_XG_MZ] onRegisterStatus ", e2);
            str = c.f11776c;
        }
        try {
            Log.i(c.a, "[OtherPush_XG_MZ] onRegisterStatus " + registerStatus + ExpandableTextView.N + context.getPackageName());
            StringBuilder sb = new StringBuilder();
            sb.append("[OtherPush_XG_MZ] onRegister pushID ");
            sb.append(registerStatus.getPushId());
            Log.i(c.a, sb.toString());
            a(context, registerStatus);
            Intent intent = new Intent(str);
            intent.putExtra("TPUSH.ERRORCODE", Integer.valueOf(registerStatus.code));
            intent.putExtra("other_push_token", registerStatus.getPushId());
            intent.putExtra("TPUSH.FEEDBACK", 1);
            intent.putExtra("PUSH.CHANNEL", 106);
            intent.putExtra("pushChannel", 106);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
        } catch (Throwable th) {
            Log.e(c.a, "[OtherPush_XG_MZ] onRegisterStatus ", th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onSubAliasStatus(Context context, SubAliasStatus subAliasStatus) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onSubTagsStatus(Context context, SubTagsStatus subTagsStatus) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    @Deprecated
    public void onUnRegister(Context context, boolean z) {
    }

    @Override // com.meizu.cloud.pushsdk.MzPushMessageReceiver
    public void onUnRegisterStatus(Context context, UnRegisterStatus unRegisterStatus) {
    }

    private static String a(String str) {
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
        } catch (Throwable th) {
            Log.e(c.a, "[OtherPush_XG_MZ] md5 ", th);
            return "";
        }
    }
}
