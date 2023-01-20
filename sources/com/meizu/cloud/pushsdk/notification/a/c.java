package com.meizu.cloud.pushsdk.notification.a;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;

/* loaded from: classes2.dex */
public class c extends com.meizu.cloud.pushsdk.notification.a {
    public c(Context context, PushNotificationBuilder pushNotificationBuilder) {
        super(context, pushNotificationBuilder);
    }

    @Override // com.meizu.cloud.pushsdk.notification.a
    public void b(Notification.Builder builder, MessageV3 messageV3) {
        AppIconSetting appIconSetting;
        Bitmap a;
        String str;
        if ((!MzSystemUtils.isInternational() || MzSystemUtils.isMeizuAndFlyme()) && (appIconSetting = messageV3.getAppIconSetting()) != null) {
            if (appIconSetting.isDefaultLargeIcon()) {
                PushNotificationBuilder pushNotificationBuilder = this.b;
                if (pushNotificationBuilder == null || pushNotificationBuilder.getLargeIcon() == 0) {
                    PushNotificationBuilder pushNotificationBuilder2 = this.b;
                    if (pushNotificationBuilder2 == null || pushNotificationBuilder2.getAppLargeIcon() == null) {
                        a = a(this.a, messageV3.getUploadDataPackageName());
                        str = "set largeIcon by package default large icon";
                    } else {
                        a = this.b.getAppLargeIcon();
                        str = "set largeIcon by bitmap provided by user setting";
                    }
                } else {
                    a = BitmapFactory.decodeResource(this.a.getResources(), this.b.getLargeIcon());
                    str = "set largeIcon by resource id";
                }
                e.p.a.a.a.c("AbstractPushNotification", str);
            } else if (Thread.currentThread() == this.a.getMainLooper().getThread()) {
                return;
            } else {
                Bitmap a2 = a(appIconSetting.getLargeIconUrl());
                if (a2 != null) {
                    e.p.a.a.a.c("AbstractPushNotification", "On other Thread down load largeIcon image success");
                    builder.setLargeIcon(a2);
                    return;
                }
                a = a(this.a, messageV3.getUploadDataPackageName());
            }
            builder.setLargeIcon(a);
        }
    }
}
