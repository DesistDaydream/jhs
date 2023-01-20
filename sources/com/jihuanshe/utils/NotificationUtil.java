package com.jihuanshe.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.SplashActivity;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageParser;
import e.t.a;
import h.w;
import h.z;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class NotificationUtil {
    @d
    private static final String b = "jihuanshe";
    @d
    public static final NotificationUtil a = new NotificationUtil();
    @d

    /* renamed from: c  reason: collision with root package name */
    private static final w f4344c = z.c(NotificationUtil$notificationManager$2.INSTANCE);

    /* renamed from: d  reason: collision with root package name */
    private static int f4345d = 234;

    /* renamed from: e  reason: collision with root package name */
    private static int f4346e = 3000;

    private NotificationUtil() {
    }

    private final NotificationManager b() {
        return (NotificationManager) f4344c.getValue();
    }

    public final void a() {
        if (Build.VERSION.SDK_INT >= 26 && b().getNotificationChannel(b) == null) {
            NotificationChannel notificationChannel = new NotificationChannel(b, b, 3);
            notificationChannel.setDescription(b);
            notificationChannel.enableVibration(false);
            notificationChannel.setShowBadge(true);
            b().createNotificationChannel(notificationChannel);
        }
    }

    public final void c(@e V2TIMMessage v2TIMMessage) {
        if (v2TIMMessage == null) {
            return;
        }
        TUIMessageBean parseMessage = ChatMessageParser.parseMessage(v2TIMMessage);
        Intent intent = new Intent(a.b(), SplashActivity.class);
        intent.putExtra("localNotification", true);
        intent.putExtra("chatId", parseMessage.getSender());
        intent.putExtra(TUIConstants.TUIChat.CHAT_NAME, parseMessage.onGetDisplayString());
        int i2 = Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728;
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(a.b(), b).setAutoCancel(false).setSmallIcon(R.mipmap.ic_launcher).setContentTitle(parseMessage.getUserDisplayName()).setContentText(parseMessage.onGetDisplayString());
        Context b2 = a.b();
        int i3 = f4345d + 1;
        f4345d = i3;
        NotificationCompat.Builder contentIntent = contentText.setContentIntent(PendingIntent.getActivity(b2, i3, intent, i2));
        NotificationManager b3 = b();
        int i4 = f4346e;
        f4346e = i4 + 1;
        b3.notify(i4, contentIntent.build());
    }
}
