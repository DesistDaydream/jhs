package com.tencent.android.tpush;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.android.tpush.c.d;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.SharePrefsUtil;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class XGPushNotificationBuilder {
    public static final String BASIC_NOTIFICATION_BUILDER_TYPE = "basic";
    public static final String CUSTOM_NOTIFICATION_BUILDER_TYPE = "custom";
    public String y;
    public String a = "xg-channle-id";
    public String b = "message";

    /* renamed from: c  reason: collision with root package name */
    public Integer f6012c = null;

    /* renamed from: d  reason: collision with root package name */
    public PendingIntent f6013d = null;

    /* renamed from: e  reason: collision with root package name */
    public RemoteViews f6014e = null;

    /* renamed from: f  reason: collision with root package name */
    public RemoteViews f6015f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f6016g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f6017h = 0;

    /* renamed from: i  reason: collision with root package name */
    public Integer f6018i = null;

    /* renamed from: j  reason: collision with root package name */
    public PendingIntent f6019j = null;

    /* renamed from: k  reason: collision with root package name */
    public Integer f6020k = null;

    /* renamed from: l  reason: collision with root package name */
    public Integer f6021l = null;

    /* renamed from: m  reason: collision with root package name */
    public Integer f6022m = null;
    public Integer n = null;
    public Integer o = null;
    public Integer p = null;
    public Integer q = null;
    public Uri r = null;
    public CharSequence s = null;
    public long[] t = null;
    public Long u = null;
    public Integer v = null;
    public Bitmap w = null;
    public Integer x = null;
    public Integer z = null;
    public Bitmap A = null;
    public Integer B = null;
    public String C = null;
    private String D = "xg-channle-id";
    private boolean E = false;

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:60:0x024f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private java.lang.Object a(android.app.Notification.Builder r24, android.content.Context r25) {
        /*
            Method dump skipped, instructions count: 962
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.XGPushNotificationBuilder.a(android.app.Notification$Builder, android.content.Context):java.lang.Object");
    }

    private int b(Context context) {
        int i2 = SharePrefsUtil.getInt(context, Constants.SOUND_CHANNEL_COUNT, 0);
        SharePrefsUtil.setInt(context, Constants.SOUND_CHANNEL_COUNT, i2 + 1);
        return i2;
    }

    private Notification c(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        Integer num = this.v;
        if (num != null) {
            builder.setSmallIcon(num.intValue());
        }
        Integer num2 = this.B;
        if (num2 != null) {
            builder.setColor(num2.intValue());
        }
        if (this.x != null) {
            try {
                if (this.f6016g <= 0) {
                    builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), this.x.intValue()));
                }
            } catch (OutOfMemoryError e2) {
                TLogger.w("XGPushNotificationBuilder", "getNotificationCompatBuilder setLargeIcon res oom " + e2.toString());
            }
        }
        Bitmap bitmap = this.w;
        if (bitmap != null && this.f6016g <= 0) {
            builder.setLargeIcon(bitmap);
        }
        String str = this.y;
        if (str == null) {
            this.y = getTitle(context);
        } else {
            builder.setContentTitle(str);
        }
        CharSequence charSequence = this.s;
        if (charSequence != null && this.f6014e == null) {
            bigTextStyle.bigText(charSequence);
            builder.setStyle(bigTextStyle);
            builder.setContentText(this.s);
            builder.setTicker(this.s);
        } else {
            builder.setContentText(charSequence);
            builder.setTicker(this.s);
        }
        if (this.A != null) {
            try {
                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(this.A));
            } catch (Throwable th) {
                TLogger.w("XGPushNotificationBuilder", "getNotificationCompatBuilder setStyle error " + th.toString());
            }
        }
        if (this.f6016g > 0 && (this.f6017h == 1 || i2 >= 31 || ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor())) {
            builder.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
        }
        if (this.C != null && i2 >= 24) {
            String h2 = d.h();
            if (!"oppo".equals(h2) && ((this.f6016g <= 0 || !"vivo".equals(h2)) && this.f6016g != 3)) {
                builder.setGroup(this.C);
            }
        }
        builder.setShowWhen(true);
        return builder.build();
    }

    public static void createNotificationChannel(Context context, Object obj) {
        TLogger.d("XGPushNotificationBuilder", "createNotificationChannel");
        if (obj != null) {
            try {
                Class<?> cls = Class.forName("android.app.NotificationChannel");
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
                notificationManager.getClass().getMethod("createNotificationChannel", cls).invoke(notificationManager, obj);
            } catch (Throwable th) {
                TLogger.ee("XGPushNotificationBuilder", "XGPushNotification createNotificationChannel Error: ", th);
            }
        }
    }

    public abstract void a(JSONObject jSONObject);

    public abstract void b(JSONObject jSONObject);

    public abstract Pair<Notification, Object> buildNotification(Context context);

    public void decode(String str) {
        JSONObject jSONObject = new JSONObject(str);
        b(jSONObject);
        this.f6012c = (Integer) CommonHelper.jsonGet(jSONObject, "audioStringType", null);
        this.f6018i = (Integer) CommonHelper.jsonGet(jSONObject, "defaults", null);
        this.f6020k = (Integer) CommonHelper.jsonGet(jSONObject, "flags", null);
        this.f6021l = (Integer) CommonHelper.jsonGet(jSONObject, "icon", null);
        this.f6022m = (Integer) CommonHelper.jsonGet(jSONObject, "iconLevel", null);
        this.n = (Integer) CommonHelper.jsonGet(jSONObject, "ledARGB", null);
        this.o = (Integer) CommonHelper.jsonGet(jSONObject, "ledOffMS", null);
        this.p = (Integer) CommonHelper.jsonGet(jSONObject, "ledOnMS", null);
        this.q = (Integer) CommonHelper.jsonGet(jSONObject, "number", null);
        String str2 = (String) CommonHelper.jsonGet(jSONObject, RemoteMessageConst.Notification.SOUND, null);
        this.v = (Integer) CommonHelper.jsonGet(jSONObject, "smallIcon", null);
        this.x = (Integer) CommonHelper.jsonGet(jSONObject, "notificationLargeIcon", null);
        if (str2 != null) {
            this.r = Uri.parse(str2);
        }
        String str3 = (String) CommonHelper.jsonGet(jSONObject, MessageKey.MSG_VIBRATE, null);
        if (str3 != null) {
            String[] split = str3.split(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            int length = split.length;
            this.t = new long[length];
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    this.t[i2] = Long.valueOf(split[i2]).longValue();
                } catch (NumberFormatException e2) {
                    TLogger.w("XGPushNotificationBuilder", "parse vibrate str error " + e2.toString());
                }
            }
        }
        this.z = (Integer) CommonHelper.jsonGet(jSONObject, "notificationId", null);
        this.C = (String) CommonHelper.jsonGet(jSONObject, "thread_id", null);
    }

    public void encode(JSONObject jSONObject) {
        a(jSONObject);
        CommonHelper.jsonPut(jSONObject, "audioStringType", this.f6012c);
        CommonHelper.jsonPut(jSONObject, "defaults", this.f6018i);
        CommonHelper.jsonPut(jSONObject, "flags", this.f6020k);
        CommonHelper.jsonPut(jSONObject, "icon", this.f6021l);
        CommonHelper.jsonPut(jSONObject, "iconLevel", this.f6022m);
        CommonHelper.jsonPut(jSONObject, "ledARGB", this.n);
        CommonHelper.jsonPut(jSONObject, "ledOffMS", this.o);
        CommonHelper.jsonPut(jSONObject, "ledOnMS", this.p);
        CommonHelper.jsonPut(jSONObject, "number", this.q);
        CommonHelper.jsonPut(jSONObject, RemoteMessageConst.Notification.SOUND, this.r);
        CommonHelper.jsonPut(jSONObject, "smallIcon", this.v);
        CommonHelper.jsonPut(jSONObject, "notificationLargeIcon", this.x);
        if (this.t != null) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (true) {
                long[] jArr = this.t;
                if (i2 >= jArr.length) {
                    break;
                }
                sb.append(String.valueOf(jArr[i2]));
                if (i2 != this.t.length - 1) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                i2++;
            }
            CommonHelper.jsonPut(jSONObject, MessageKey.MSG_VIBRATE, sb.toString());
        }
        CommonHelper.jsonPut(jSONObject, "notificationId", this.z);
        CommonHelper.jsonPut(jSONObject, "thread_id", this.C);
    }

    public int getApplicationIcon(Context context) {
        return context.getApplicationInfo().icon;
    }

    public int getAudioStringType() {
        return this.f6012c.intValue();
    }

    public String getChannelId(Context context) {
        String notificationChannelID;
        return (!this.a.equals("xg-channle-id") || (notificationChannelID = XGPushConfig.getNotificationChannelID(context)) == null || TextUtils.isEmpty(notificationChannelID)) ? this.a : notificationChannelID;
    }

    public String getChannelName(Context context) {
        String notificationChannelName;
        return (!this.b.equals("message") || (notificationChannelName = XGPushConfig.getNotificationChannelName(context)) == null || TextUtils.isEmpty(notificationChannelName)) ? this.b : notificationChannelName;
    }

    @SuppressLint({"NewApi"})
    public Pair<Notification, Object> getChannelNotification(Context context) {
        Notification.Builder builder = new Notification.Builder(context);
        Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
        Integer num = this.v;
        if (num != null) {
            builder.setSmallIcon(num.intValue());
        }
        Integer num2 = this.B;
        if (num2 != null) {
            builder.setColor(num2.intValue());
        }
        if (this.x != null) {
            try {
                if (this.f6016g <= 0) {
                    builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), this.x.intValue()));
                }
            } catch (OutOfMemoryError e2) {
                TLogger.w("XGPushNotificationBuilder", "getChannelNotification setLargeIcon res oom " + e2.toString());
            }
        }
        Bitmap bitmap = this.w;
        if (bitmap != null && this.f6016g <= 0) {
            builder.setLargeIcon(bitmap);
        }
        CharSequence charSequence = this.y;
        if (charSequence == null) {
            this.y = getTitle(context);
        } else {
            builder.setContentTitle(charSequence);
        }
        CharSequence charSequence2 = this.s;
        if (charSequence2 != null && this.f6014e == null) {
            bigTextStyle.bigText(charSequence2);
            builder.setStyle(bigTextStyle);
            builder.setContentText(this.s);
            builder.setTicker(this.s);
        } else {
            builder.setContentText(charSequence2);
            builder.setTicker(this.s);
        }
        if (this.A != null) {
            try {
                builder.setStyle(new Notification.BigPictureStyle().bigPicture(this.A));
            } catch (Throwable th) {
                TLogger.w("XGPushNotificationBuilder", "getChannelNotification setStyle error " + th.toString());
            }
        }
        if (this.f6016g > 0 && (this.f6017h == 1 || Build.VERSION.SDK_INT >= 31 || ChannelUtils.isBrandHuaWei() || ChannelUtils.isBrandHonor())) {
            builder.setStyle(new Notification.DecoratedCustomViewStyle());
        }
        if (this.C != null) {
            String h2 = d.h();
            if (!"oppo".equals(h2) && ((this.f6016g <= 0 || !"vivo".equals(h2)) && this.f6016g != 3)) {
                builder.setGroup(this.C);
            }
        }
        builder.setShowWhen(true);
        return new Pair<>(builder.build(), a(builder, context));
    }

    public Integer getColor() {
        return this.B;
    }

    public PendingIntent getContentIntent() {
        return this.f6013d;
    }

    public String getCurrentChannelId() {
        String str = this.D;
        return (str == null || str.length() <= 0) ? "xg-channle-id" : this.D;
    }

    public int getCustomLayoutType() {
        return this.f6016g;
    }

    public int getDefaults() {
        return this.f6018i.intValue();
    }

    public int getFlags() {
        return this.f6020k.intValue();
    }

    public Integer getIcon() {
        return this.f6021l;
    }

    public int getIconLevel() {
        return this.f6022m.intValue();
    }

    public Bitmap getLargeIcon() {
        return this.w;
    }

    public int getLedARGB() {
        return this.n.intValue();
    }

    public int getLedOffMS() {
        return this.o.intValue();
    }

    public int getLedOnMS() {
        return this.p.intValue();
    }

    public Integer getNotificationLargeIcon() {
        return this.x;
    }

    public int getNumber() {
        return this.q.intValue();
    }

    public Bitmap getRichIcon() {
        return this.A;
    }

    public Integer getSmallIcon() {
        return this.v;
    }

    public Uri getSound() {
        return this.r;
    }

    public String getThread_id() {
        return this.C;
    }

    public CharSequence getTickerText() {
        return this.s;
    }

    public String getTitle(Context context) {
        if (this.y == null) {
            this.y = (String) context.getApplicationContext().getPackageManager().getApplicationLabel(context.getApplicationInfo());
        }
        return this.y;
    }

    public abstract String getType();

    public long[] getVibrate() {
        return this.t;
    }

    public long getWhen() {
        return this.u.longValue();
    }

    public XGPushNotificationBuilder setAudioStringType(int i2) {
        this.f6012c = Integer.valueOf(i2);
        return this;
    }

    public void setChannelId(String str) {
        this.a = str;
    }

    public void setChannelName(String str) {
        this.b = str;
    }

    public XGPushNotificationBuilder setColor(Integer num) {
        this.B = num;
        return this;
    }

    public XGPushNotificationBuilder setContentIntent(PendingIntent pendingIntent) {
        this.f6013d = pendingIntent;
        return this;
    }

    public XGPushNotificationBuilder setContentView(RemoteViews remoteViews) {
        this.f6014e = remoteViews;
        return this;
    }

    public XGPushNotificationBuilder setCustomLayoutType(int i2) {
        this.f6016g = i2;
        return this;
    }

    public XGPushNotificationBuilder setDefaults(int i2) {
        Integer num = this.f6018i;
        if (num == null) {
            this.f6018i = Integer.valueOf(i2);
        } else {
            this.f6018i = Integer.valueOf(i2 | num.intValue());
        }
        return this;
    }

    public XGPushNotificationBuilder setFlags(int i2) {
        Integer num = this.f6020k;
        if (num == null) {
            this.f6020k = Integer.valueOf(i2);
        } else {
            this.f6020k = Integer.valueOf(i2 | num.intValue());
        }
        return this;
    }

    public XGPushNotificationBuilder setIcon(Integer num) {
        this.f6021l = num;
        return this;
    }

    public XGPushNotificationBuilder setIconLevel(int i2) {
        this.f6022m = Integer.valueOf(i2);
        return this;
    }

    public XGPushNotificationBuilder setLargeIcon(Bitmap bitmap) {
        this.w = bitmap;
        return this;
    }

    public XGPushNotificationBuilder setLedARGB(int i2) {
        this.n = Integer.valueOf(i2);
        return this;
    }

    public XGPushNotificationBuilder setLedOffMS(int i2) {
        this.o = Integer.valueOf(i2);
        return this;
    }

    public XGPushNotificationBuilder setLedOnMS(int i2) {
        this.p = Integer.valueOf(i2);
        return this;
    }

    public XGPushNotificationBuilder setNotificationLargeIcon(int i2) {
        this.x = Integer.valueOf(i2);
        return this;
    }

    public XGPushNotificationBuilder setNumber(int i2) {
        this.q = Integer.valueOf(i2);
        return this;
    }

    public XGPushNotificationBuilder setRichIcon(Bitmap bitmap) {
        this.A = bitmap;
        return this;
    }

    public void setRunAsSysAndAndBuildSdk26(boolean z) {
        this.E = z;
    }

    public XGPushNotificationBuilder setSmallIcon(Integer num) {
        this.v = num;
        return this;
    }

    public XGPushNotificationBuilder setSound(Uri uri) {
        this.r = uri;
        return this;
    }

    public void setThread_id(String str) {
        this.C = str;
    }

    public XGPushNotificationBuilder setTickerText(CharSequence charSequence) {
        this.s = charSequence;
        return this;
    }

    public void setTitle(String str) {
        this.y = str;
    }

    public void setUseStdStyle(int i2) {
        this.f6017h = i2;
    }

    public XGPushNotificationBuilder setVibrate(long[] jArr) {
        this.t = jArr;
        return this;
    }

    public XGPushNotificationBuilder setWhen(long j2) {
        this.u = Long.valueOf(j2);
        return this;
    }

    public XGPushNotificationBuilder setbigContentView(RemoteViews remoteViews) {
        this.f6015f = remoteViews;
        return this;
    }

    public Pair<Notification, Object> a(Context context) {
        Notification c2;
        Object obj;
        if (this.z == null) {
            this.z = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("XGPushNotification Build.VERSION.SDK_INT: ");
        int i2 = Build.VERSION.SDK_INT;
        sb.append(i2);
        sb.append(", targetSDK:");
        sb.append(context.getApplicationInfo().targetSdkVersion);
        TLogger.ii("XGPushNotificationBuilder", sb.toString());
        if (i2 >= 26 && (context.getApplicationInfo().targetSdkVersion >= 26 || this.E)) {
            Pair<Notification, Object> channelNotification = getChannelNotification(context);
            c2 = (Notification) channelNotification.first;
            obj = channelNotification.second;
        } else {
            c2 = c(context);
            obj = null;
        }
        Integer num = this.f6012c;
        if (num != null) {
            c2.audioStreamType = num.intValue();
        }
        PendingIntent pendingIntent = this.f6013d;
        if (pendingIntent != null) {
            c2.contentIntent = pendingIntent;
        }
        RemoteViews remoteViews = this.f6015f;
        if (remoteViews != null) {
            c2.bigContentView = remoteViews;
        }
        if (this.f6014e != null) {
            Build.MANUFACTURER.trim().toLowerCase();
            c2.contentView = this.f6014e;
        }
        Integer num2 = this.f6018i;
        if (num2 != null) {
            c2.defaults = num2.intValue();
        }
        Integer num3 = this.f6021l;
        if (num3 != null) {
            c2.icon = num3.intValue();
        }
        PendingIntent pendingIntent2 = this.f6019j;
        if (pendingIntent2 != null) {
            c2.deleteIntent = pendingIntent2;
        }
        Integer num4 = this.f6020k;
        if (num4 != null) {
            c2.flags = num4.intValue();
        } else {
            c2.flags = 16;
        }
        Integer num5 = this.f6022m;
        if (num5 != null) {
            c2.iconLevel = num5.intValue();
        }
        Integer num6 = this.n;
        if (num6 != null) {
            c2.ledARGB = num6.intValue();
        }
        Integer num7 = this.o;
        if (num7 != null) {
            c2.ledOffMS = num7.intValue();
        }
        Integer num8 = this.p;
        if (num8 != null) {
            c2.ledOnMS = num8.intValue();
        }
        Integer num9 = this.q;
        if (num9 != null) {
            c2.number = num9.intValue();
        }
        Uri uri = this.r;
        if (uri != null) {
            c2.sound = uri;
        }
        long[] jArr = this.t;
        if (jArr != null) {
            c2.vibrate = jArr;
        }
        Long l2 = this.u;
        if (l2 != null) {
            c2.when = l2.longValue();
        } else {
            c2.when = System.currentTimeMillis();
        }
        return new Pair<>(c2, obj);
    }
}
