package com.huawei.android.hms.tpns;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import e.k.a.a.a.b;
import e.k.a.a.a.c;
import java.io.Serializable;
import java.security.MessageDigest;

/* loaded from: classes2.dex */
public class HWHmsMessageService extends HmsMessageService {
    private static String b;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            String str2 = this.a;
            int i2 = 0;
            if (str2 != null && str2.length() != 0) {
                try {
                    SharedPreferences sharedPreferences = HWHmsMessageService.this.getApplicationContext().getSharedPreferences("tpush.vip.shareprefs", 0);
                    if (HWHmsMessageService.b == null || HWHmsMessageService.b.length() <= 0) {
                        String unused = HWHmsMessageService.b = sharedPreferences.getString(HWHmsMessageService.f("huawei_token"), "");
                    }
                    if (!this.a.equals(HWHmsMessageService.b)) {
                        String unused2 = HWHmsMessageService.b = this.a;
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(HWHmsMessageService.f("huawei_token"), this.a);
                        edit.apply();
                    }
                } catch (Throwable th) {
                    Log.e(c.a, "[XG_HWPUSH_V3] otherpush huawei save newToken error: " + th.getMessage());
                }
            }
            try {
                Class.forName("com.tencent.android.tpush.service.XGVipPushService");
                str = "com.tencent.android.xg.vip.action.FEEDBACK";
            } catch (ClassNotFoundException e2) {
                Log.w(c.a, "[XG_HWPUSH_V3] onNewToken:" + e2.getMessage());
                str = c.f11776c;
            }
            try {
                Intent intent = new Intent(str);
                if (this.a == null) {
                    i2 = -1;
                }
                intent.putExtra("TPUSH.ERRORCODE", i2);
                intent.putExtra("other_push_token", this.a);
                intent.putExtra("TPUSH.FEEDBACK", 1);
                intent.putExtra("PUSH.CHANNEL", 102);
                intent.setPackage(HWHmsMessageService.this.getApplicationContext().getPackageName());
                HWHmsMessageService.this.getApplicationContext().sendBroadcast(intent);
            } catch (Throwable th2) {
                Log.w(c.a, "[XG_HWPUSH_V3] onNewToken:" + th2.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String f(String str) {
        if (str == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                int i2 = b2 & 255;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            Log.e(c.a, "[XG_HWPUSH_V3] md5:" + th.getMessage());
            return "";
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str;
        super.onMessageReceived(remoteMessage);
        Log.w(c.a, "[XG_HWPUSH_V3] On messageReceived: " + remoteMessage.getMessageId() + ", " + remoteMessage.getMessageType());
        try {
            Class.forName("com.tencent.android.tpush.service.XGVipPushService");
            str = "com.tencent.android.xg.vip.action.PUSH_MESSAGE";
        } catch (ClassNotFoundException e2) {
            Log.w(c.a, "[XG_HWPUSH_V3] onMessageReceived:" + e2.getMessage());
            str = c.f11777d;
        }
        try {
            if (remoteMessage.getData().length() > 0) {
                String data = remoteMessage.getData();
                Log.i(c.a, "[XG_HWPUSH_V3] Message data payload: " + data);
                Intent intent = new Intent(str);
                intent.putExtra("PUSH.CHANNEL", 102);
                intent.putExtra("content", data);
                intent.putExtra("custom_content", "");
                intent.putExtra("type", (Serializable) 2L);
                intent.setPackage(getPackageName());
                sendBroadcast(intent);
            }
            if (remoteMessage.getNotification() != null) {
                Log.d(c.a, "[XG_HWPUSH_V3] Message Notification Body: " + remoteMessage.getNotification().getBody());
            }
        } catch (Throwable th) {
            Log.e(c.a, "[XG_HWPUSH_V3] onMessageReceived:" + th.getMessage());
        }
    }

    @Override // com.huawei.hms.push.HmsMessageService
    public void onNewToken(String str) {
        super.onNewToken(str);
        Log.i(c.a, "[XG_HWPUSH_V3] otherpush huawei register onNewToken: " + str);
        b.b().a(new a(str));
    }
}
