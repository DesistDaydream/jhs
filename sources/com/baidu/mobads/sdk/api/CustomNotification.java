package com.baidu.mobads.sdk.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.baidu.mobads.proxy.R;
import com.baidu.mobads.sdk.internal.bc;

/* loaded from: classes.dex */
public class CustomNotification {
    private NotificationCompat.Style mStyle = new NotificationCompat.DecoratedCustomViewStyle();

    private void setRemoteViewText(RemoteViews remoteViews, int i2, String str) {
        if (remoteViews != null) {
            if (!TextUtils.isEmpty(str)) {
                remoteViews.setTextViewText(i2, str);
                remoteViews.setViewVisibility(i2, 0);
                return;
            }
            remoteViews.setViewVisibility(i2, 8);
        }
    }

    @TargetApi(16)
    public Notification getCustomNotification(Context context, String str, String str2, Bitmap bitmap, String str3, String str4, String str5, boolean z, int i2, int i3, String str6, PendingIntent pendingIntent) {
        NotificationCompat.Builder builder;
        if (bc.a(context).a() < 26) {
            builder = new NotificationCompat.Builder(context);
        } else {
            if (TextUtils.isEmpty(str)) {
                str = "down";
            }
            try {
                builder = new NotificationCompat.Builder(context, str);
            } catch (NoSuchMethodError unused) {
                builder = new NotificationCompat.Builder(context);
            }
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.mobads_cutom_notification_layout);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(R.id.left_icon, bitmap);
        } else {
            remoteViews.setImageViewResource(R.id.left_icon, R.drawable.ic_stat_bd_notif_download);
        }
        setRemoteViewText(remoteViews, R.id.notification_title, str3);
        if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5)) {
            remoteViews.setViewVisibility(R.id.content_layout, 8);
        } else {
            remoteViews.setViewVisibility(R.id.content_layout, 0);
            setRemoteViewText(remoteViews, R.id.content_text, str4);
            setRemoteViewText(remoteViews, R.id.content_status, str5);
        }
        if (i2 >= 0 && i2 <= 100) {
            int i4 = R.id.progress_bar;
            remoteViews.setProgressBar(i4, 100, i2, false);
            remoteViews.setViewVisibility(i4, 0);
        } else {
            remoteViews.setViewVisibility(R.id.progress_bar, 8);
        }
        int i5 = R.id.btn_action;
        remoteViews.setTextViewText(i5, str6);
        remoteViews.setOnClickPendingIntent(i5, pendingIntent);
        return builder.setSmallIcon(i3).setOngoing(false).setTicker(str2).setAutoCancel(z).setWhen(System.currentTimeMillis()).setCustomContentView(remoteViews).build();
    }
}
