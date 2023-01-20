package com.m7.imkfsdk.utils;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.m7.imkfsdk.constant.NotifyConstants;
import com.moor.imkf.utils.MoorUtils;

/* loaded from: classes2.dex */
public class NotificationUtils extends ContextWrapper {
    private static volatile NotificationUtils instance;
    private boolean cancel;
    private Class<?> cls;
    private int defaults;
    private int[] flags;
    private boolean highPriority;
    private PendingIntent intent;
    private int[] intentFlags;
    private Context mContext;
    private NotificationManager mManager;
    private boolean ongoing;
    private boolean onlyAlertOnce;
    private long[] pattern;
    private int priority;
    private RemoteViews remoteViews;
    private Uri sound;
    private String ticker;
    private long when;

    private NotificationUtils(Context context) {
        super(context);
        this.intent = null;
        this.ongoing = false;
        this.remoteViews = null;
        this.ticker = "";
        this.priority = 0;
        this.onlyAlertOnce = false;
        this.cancel = true;
        this.when = 0L;
        this.sound = null;
        this.defaults = 0;
        this.pattern = null;
        this.highPriority = false;
        this.mContext = context;
        if (Build.VERSION.SDK_INT >= 26) {
            createNotificationChannel();
        }
    }

    @TargetApi(26)
    private void createNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel("default", NotifyConstants.CHANNEL_NAME, 3);
        notificationChannel.canBypassDnd();
        notificationChannel.enableLights(false);
        notificationChannel.setLockscreenVisibility(-1);
        notificationChannel.setLightColor(-65536);
        notificationChannel.canShowBadge();
        notificationChannel.enableVibration(false);
        notificationChannel.getAudioAttributes();
        notificationChannel.getGroup();
        notificationChannel.setBypassDnd(true);
        notificationChannel.setVibrationPattern(new long[]{100, 100, 200});
        notificationChannel.shouldShowLights();
        getManager().createNotificationChannel(notificationChannel);
    }

    @RequiresApi(api = 26)
    private Notification.Builder getChannelNotification(String str, String str2, int i2) {
        Notification.Builder autoCancel = new Notification.Builder(getApplicationContext(), "default").setContentTitle(str).setContentText(str2).setSmallIcon(i2).setOngoing(this.ongoing).setPriority(this.priority).setOnlyAlertOnce(this.onlyAlertOnce).setAutoCancel(this.cancel);
        RemoteViews remoteViews = this.remoteViews;
        if (remoteViews != null) {
            autoCancel.setContent(remoteViews);
        }
        PendingIntent pendingIntent = this.intent;
        if (pendingIntent != null) {
            autoCancel.setContentIntent(pendingIntent);
        }
        String str3 = this.ticker;
        if (str3 != null && str3.length() > 0) {
            autoCancel.setTicker(this.ticker);
        }
        long j2 = this.when;
        if (j2 != 0) {
            autoCancel.setWhen(j2);
        }
        Uri uri = this.sound;
        if (uri != null) {
            autoCancel.setSound(uri);
        }
        int i3 = this.defaults;
        if (i3 != 0) {
            autoCancel.setDefaults(i3);
        }
        long[] jArr = this.pattern;
        if (jArr != null) {
            autoCancel.setVibrate(jArr);
        }
        return autoCancel;
    }

    public static NotificationUtils getInstance(Context context) {
        if (instance == null) {
            synchronized (NotificationUtils.class) {
                if (instance == null) {
                    instance = new NotificationUtils(context);
                }
            }
        }
        return instance;
    }

    private NotificationCompat.Builder getNotificationCompat(String str, String str2, int i2) {
        NotificationCompat.Builder builder;
        if (Build.VERSION.SDK_INT >= 26) {
            builder = new NotificationCompat.Builder(getApplicationContext(), "default");
        } else {
            builder = new NotificationCompat.Builder(getApplicationContext());
            builder.setPriority(0);
        }
        builder.setContentTitle(str);
        builder.setContentText(str2);
        builder.setSmallIcon(i2);
        builder.setPriority(this.priority);
        builder.setOnlyAlertOnce(this.onlyAlertOnce);
        builder.setOngoing(this.ongoing);
        RemoteViews remoteViews = this.remoteViews;
        if (remoteViews != null) {
            builder.setContent(remoteViews);
        }
        PendingIntent pendingIntent = this.intent;
        if (pendingIntent != null) {
            builder.setContentIntent(pendingIntent);
        }
        String str3 = this.ticker;
        if (str3 != null && str3.length() > 0) {
            builder.setTicker(this.ticker);
        }
        long j2 = this.when;
        if (j2 != 0) {
            builder.setWhen(j2);
        }
        Uri uri = this.sound;
        if (uri != null) {
            builder.setSound(uri);
        }
        int i3 = this.defaults;
        if (i3 != 0) {
            builder.setDefaults(i3);
        }
        builder.setAutoCancel(this.cancel);
        return builder;
    }

    public void clearNotification() {
        getManager().cancelAll();
    }

    public NotificationManager getManager() {
        if (this.mManager == null) {
            this.mManager = (NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION);
        }
        return this.mManager;
    }

    public Notification getNotification(String str, String str2, int i2) {
        Notification build;
        if (Build.VERSION.SDK_INT >= 26) {
            build = getChannelNotification(str, str2, i2).build();
        } else {
            build = getNotificationCompat(str, str2, i2).build();
        }
        int[] iArr = this.flags;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.flags;
                if (i3 >= iArr2.length) {
                    break;
                }
                build.flags = iArr2[i3] | build.flags;
                i3++;
            }
        }
        return build;
    }

    public void sendNotification(int i2, String str, String str2, int i3) {
        Notification build;
        if (Build.VERSION.SDK_INT >= 26) {
            build = getChannelNotification(str, str2, i3).build();
        } else {
            build = getNotificationCompat(str, str2, i3).build();
        }
        int[] iArr = this.flags;
        if (iArr != null && iArr.length > 0) {
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.flags;
                if (i4 >= iArr2.length) {
                    break;
                }
                build.flags = iArr2[i4] | build.flags;
                i4++;
            }
        }
        getManager().notify(i2, build);
    }

    public void sendNotificationCompat(int i2, String str, String str2, int i3) {
        Notification build = getNotificationCompat(str, str2, i3).build();
        int[] iArr = this.flags;
        if (iArr != null && iArr.length > 0) {
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.flags;
                if (i4 >= iArr2.length) {
                    break;
                }
                build.flags = iArr2[i4] | build.flags;
                i4++;
            }
        }
        getManager().notify(i2, build);
    }

    public NotificationUtils setAutoCancel(boolean z) {
        this.cancel = z;
        return this;
    }

    public NotificationUtils setClass(Class<?> cls) {
        this.cls = cls;
        return this;
    }

    public NotificationUtils setContent(RemoteViews remoteViews) {
        this.remoteViews = remoteViews;
        return this;
    }

    public NotificationUtils setContentIntent(String str) {
        Intent intent = new Intent(this.mContext, this.cls);
        intent.putExtra("type", str);
        intent.putExtra("PeerId", "");
        int[] iArr = this.intentFlags;
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                intent.addFlags(i2);
            }
        }
        this.intent = PendingIntent.getActivity(MoorUtils.getApp(), 0, intent, Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728);
        return this;
    }

    public NotificationUtils setDefaults(int i2) {
        this.defaults = i2;
        return this;
    }

    public NotificationUtils setFlags(int... iArr) {
        this.flags = iArr;
        return this;
    }

    public NotificationUtils setFullScreen(boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.highPriority = z;
        }
        return this;
    }

    public NotificationUtils setIntentFlags(int... iArr) {
        this.intentFlags = iArr;
        return this;
    }

    public NotificationUtils setOngoing(boolean z) {
        this.ongoing = z;
        return this;
    }

    public NotificationUtils setOnlyAlertOnce(boolean z) {
        this.onlyAlertOnce = z;
        return this;
    }

    public NotificationUtils setPriority(int i2) {
        this.priority = i2;
        return this;
    }

    public NotificationUtils setSound(Uri uri) {
        this.sound = uri;
        return this;
    }

    public NotificationUtils setTicker(String str) {
        this.ticker = str;
        return this;
    }

    public NotificationUtils setVibrate(long[] jArr) {
        this.pattern = jArr;
        return this;
    }

    public NotificationUtils setWhen(long j2) {
        this.when = j2;
        return this;
    }
}
