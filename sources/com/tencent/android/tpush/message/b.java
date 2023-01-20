package com.tencent.android.tpush.message;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpush.InnerTpnsActivity;
import com.tencent.android.tpush.NotificationAction;
import com.tencent.android.tpush.XGBasicPushNotificationBuilder;
import com.tencent.android.tpush.XGCustomPushNotificationBuilder;
import com.tencent.android.tpush.XGNotifaction;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.XGPushNotifactionCallback;
import com.tencent.android.tpush.XGPushNotificationBuilder;
import com.tencent.android.tpush.XGSysNotifaction;
import com.tencent.android.tpush.XGSysPushNotifactionCallback;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.inappmessage.SizeUtil;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.d;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CommonHelper;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import e.t.u.b0;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b {
    private static volatile BroadcastReceiver a;
    private static volatile BroadcastReceiver b;

    /* renamed from: c */
    private static MediaPlayer f6150c;

    /* renamed from: com.tencent.android.tpush.message.b$3 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[NotificationAction.values().length];
            a = iArr;
            try {
                iArr[NotificationAction.activity.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[NotificationAction.url.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[NotificationAction.intent.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[NotificationAction.intent_with_action.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[NotificationAction.action_package.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String b(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(context.getPackageName());
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null) {
                    return activityInfo.name;
                }
            }
        } catch (Throwable th) {
            TLogger.e("MessageHelper", "get Activity error", th);
        }
        return null;
    }

    private static void c(Context context, d dVar, XGPushNotificationBuilder xGPushNotificationBuilder) {
        Object metaData;
        int identifier;
        String s = dVar.s();
        if (s != null && !TextUtils.isEmpty(s) && (identifier = context.getResources().getIdentifier(s, "drawable", context.getPackageName())) > 0) {
            xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(identifier));
        }
        if (xGPushNotificationBuilder.getSmallIcon() == null && (metaData = CommonHelper.getMetaData(context, "com.google.firebase.messaging.default_notification_icon", null)) != null) {
            try {
                int intValue = ((Integer) metaData).intValue();
                TLogger.i("MessageHelper", "get meta-data fcm_default_notification_icon " + intValue);
                if (intValue > 0) {
                    xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(intValue));
                }
            } catch (Throwable unused) {
                TLogger.w("MessageHelper", "get meta-data fcm_default_notification_icon invalid resource id: " + metaData);
            }
        }
        if (xGPushNotificationBuilder.getSmallIcon() == null) {
            if (com.tencent.android.tpush.c.d.h().equals("google")) {
                int identifier2 = context.getResources().getIdentifier("notification_icon", "drawable", context.getPackageName());
                if (identifier2 > 0) {
                    xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(identifier2));
                    return;
                } else {
                    xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(context.getApplicationInfo().icon));
                    return;
                }
            }
            xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(context.getApplicationInfo().icon));
        }
    }

    private static String a(int i2) {
        return "TPUSH_NOTIF_BUILDID_" + String.valueOf(i2);
    }

    public static synchronized XGPushNotificationBuilder a(Context context) {
        XGPushNotificationBuilder flags;
        synchronized (b.class) {
            flags = new XGBasicPushNotificationBuilder().setFlags(16);
        }
        return flags;
    }

    public static void a(Context context, int i2, XGPushNotificationBuilder xGPushNotificationBuilder) {
        String a2 = a(i2);
        JSONObject jSONObject = new JSONObject();
        xGPushNotificationBuilder.encode(jSONObject);
        JSONObject jSONObject2 = new JSONObject();
        CommonHelper.jsonPut(jSONObject2, xGPushNotificationBuilder.getType(), jSONObject.toString());
        PushPreferences.putString(context, a2, jSONObject2.toString());
    }

    private static XGPushNotificationBuilder b(Context context, d dVar, XGPushNotificationBuilder xGPushNotificationBuilder) {
        Object metaData;
        if (xGPushNotificationBuilder == null) {
            xGPushNotificationBuilder = XGPushManager.getDefaultNotificationBuilder(context);
        }
        if (xGPushNotificationBuilder == null) {
            xGPushNotificationBuilder = a(context);
        }
        if (dVar.j() != 0) {
            xGPushNotificationBuilder.setFlags(16);
        }
        if (XGPushConfig.isEnableNotificationSound(context) && dVar.h() != 0) {
            if (!TextUtils.isEmpty(dVar.q())) {
                int identifier = context.getResources().getIdentifier(dVar.q(), "raw", context.getPackageName());
                if (identifier > 0) {
                    xGPushNotificationBuilder.setSound(Uri.parse("android.resource://" + context.getPackageName() + MqttTopic.TOPIC_LEVEL_SEPARATOR + identifier));
                } else {
                    xGPushNotificationBuilder.setDefaults(1);
                }
            } else {
                xGPushNotificationBuilder.setDefaults(1);
            }
        }
        if (dVar.i() != 0) {
            xGPushNotificationBuilder.setDefaults(2);
        }
        if (dVar.p() != 0) {
            xGPushNotificationBuilder.setDefaults(4);
            xGPushNotificationBuilder.setFlags(1);
        }
        c(context, dVar, xGPushNotificationBuilder);
        int t = dVar.t();
        String r = dVar.r();
        Integer layoutIconId = xGPushNotificationBuilder instanceof XGCustomPushNotificationBuilder ? ((XGCustomPushNotificationBuilder) xGPushNotificationBuilder).getLayoutIconId() : null;
        if (r != null && !TextUtils.isEmpty(r)) {
            if (t <= 0) {
                int identifier2 = context.getResources().getIdentifier(r, "drawable", context.getPackageName());
                if (identifier2 > 0) {
                    xGPushNotificationBuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), identifier2));
                    if (layoutIconId != null) {
                        ((XGCustomPushNotificationBuilder) xGPushNotificationBuilder).setLayoutIconDrawableId(identifier2);
                    }
                } else {
                    xGPushNotificationBuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), context.getApplicationInfo().icon));
                }
            } else {
                Bitmap a2 = a(r);
                if (a2 == null) {
                    xGPushNotificationBuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), context.getApplicationInfo().icon));
                } else {
                    xGPushNotificationBuilder.setLargeIcon(a2);
                    if (layoutIconId != null) {
                        ((XGCustomPushNotificationBuilder) xGPushNotificationBuilder).setLayoutIconDrawableBmp(a2);
                    }
                }
            }
        }
        int B = dVar.B();
        if (B > 0) {
            xGPushNotificationBuilder.setColor(Integer.valueOf(B));
        }
        if (xGPushNotificationBuilder.getColor() == null && (metaData = CommonHelper.getMetaData(context, "com.google.firebase.messaging.default_notification_color", null)) != null) {
            try {
                int intValue = ((Integer) metaData).intValue();
                TLogger.i("MessageHelper", "get meta-data fcm_default_notification_color " + intValue);
                if (intValue > 0) {
                    xGPushNotificationBuilder.setColor(Integer.valueOf(context.getResources().getColor(intValue)));
                }
            } catch (Throwable unused) {
                TLogger.w("MessageHelper", "get meta-data fcm_default_notification_color invalid resource id: " + metaData);
            }
        }
        return xGPushNotificationBuilder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v7 */
    public static XGPushNotificationBuilder a(Context context, int i2) {
        String string;
        XGPushNotificationBuilder xGPushNotificationBuilder = null;
        if (context == null) {
            return null;
        }
        String string2 = PushPreferences.getString(context, a(i2), null);
        if (string2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(string2);
                ?? has = jSONObject.has("basic");
                try {
                    if (has != 0) {
                        XGBasicPushNotificationBuilder xGBasicPushNotificationBuilder = new XGBasicPushNotificationBuilder();
                        string = jSONObject.getString("basic");
                        has = xGBasicPushNotificationBuilder;
                    } else if (!jSONObject.has(XGPushNotificationBuilder.CUSTOM_NOTIFICATION_BUILDER_TYPE)) {
                        return null;
                    } else {
                        XGCustomPushNotificationBuilder xGCustomPushNotificationBuilder = new XGCustomPushNotificationBuilder();
                        string = jSONObject.getString(XGPushNotificationBuilder.CUSTOM_NOTIFICATION_BUILDER_TYPE);
                        has = xGCustomPushNotificationBuilder;
                    }
                    xGPushNotificationBuilder = has;
                    xGPushNotificationBuilder.decode(string);
                } catch (JSONException e2) {
                    e = e2;
                    xGPushNotificationBuilder = has;
                    TLogger.e("MessageHelper", "unexpected for getNotificationBuilder", e);
                    return xGPushNotificationBuilder;
                }
            } catch (JSONException e3) {
                e = e3;
            }
        } else {
            TLogger.i("MessageHelper", "PushNotificationBuilder not found :" + i2);
        }
        return xGPushNotificationBuilder;
    }

    public static Intent a(Context context, d.a aVar, boolean z, PushMessageManager pushMessageManager, boolean z2) {
        int i2;
        int i3;
        NotificationAction notificationAction = NotificationAction.getNotificationAction(aVar.a);
        Intent intent = null;
        if (notificationAction == null) {
            return null;
        }
        int i4 = AnonymousClass3.a[notificationAction.ordinal()];
        if (i4 == 1) {
            intent = new Intent(Constants.ACTION_INTERNAL_PUSH_MESSAGE);
            String str = aVar.b;
            if (i.b(str)) {
                str = b(context);
            }
            d.a.C0222a c0222a = aVar.f6168c;
            if (c0222a != null && (i2 = c0222a.a) > 0) {
                intent.setFlags(i2);
            } else {
                intent.setFlags(67108864);
            }
            intent.putExtra("activity", str);
            NotificationAction notificationAction2 = NotificationAction.activity;
            intent.putExtra("notificationActionType", notificationAction2.getType());
            intent.putExtra(Constants.FLAG_ACTION_TYPE, notificationAction2.getType());
            intent.putExtra("PUSH.CHANNEL", pushMessageManager.pushChannel);
            intent.setClass(context, InnerTpnsActivity.class);
        } else if (i4 == 2) {
            intent = new Intent(Constants.ACTION_INTERNAL_PUSH_MESSAGE);
            intent.putExtra("activity", aVar.f6171f);
            intent.putExtra(Constants.FLAG_ACTION_TYPE, aVar.a);
            intent.putExtra("notificationActionType", NotificationAction.url.getType());
            intent.putExtra("PUSH.CHANNEL", pushMessageManager.pushChannel);
            intent.setClass(context, InnerTpnsActivity.class);
        } else if (i4 == 3 || i4 == 4) {
            intent = new Intent(Constants.ACTION_INTERNAL_PUSH_MESSAGE);
            intent.putExtra("activity", aVar.f6169d);
            intent.putExtra(Constants.FLAG_ACTION_TYPE, aVar.a);
            int i5 = aVar.a;
            NotificationAction notificationAction3 = NotificationAction.intent_with_action;
            if (i5 == notificationAction3.getType()) {
                intent.putExtra("notificationActionType", notificationAction3.getType());
            } else {
                intent.putExtra("notificationActionType", NotificationAction.intent.getType());
            }
            intent.putExtra("PUSH.CHANNEL", pushMessageManager.pushChannel);
            intent.setClass(context, InnerTpnsActivity.class);
        } else if (i4 != 5) {
            TLogger.e("MessageHelper", "getIntentByOpenType unknown action_type: " + aVar.a);
        } else {
            intent = new Intent(Constants.ACTION_INTERNAL_PUSH_MESSAGE);
            String str2 = aVar.f6173h;
            if (i.b(str2)) {
                return intent;
            }
            intent.putExtra(Constants.FLAG_ACTION_TYPE, aVar.a);
            intent.putExtra(Constants.FLAG_PACKAGE_DOWNLOAD_URL, aVar.f6175j);
            intent.putExtra(Constants.FLAG_PACKAGE_NAME, str2);
            intent.putExtra("activity", str2);
            intent.putExtra("notificationActionType", NotificationAction.action_package.getType());
            intent.putExtra("PUSH.CHANNEL", pushMessageManager.pushChannel);
            intent.setClass(context, InnerTpnsActivity.class);
        }
        if (intent != null) {
            intent.putExtra(Constants.FLAG_ACTION_CONFIRM, aVar.f6172g);
            intent.putExtra("msgId", pushMessageManager.getMsgId());
            intent.putExtra("busiMsgId", pushMessageManager.getBusiMsgId());
            intent.putExtra(MessageKey.MSG_PUSH_TIME, pushMessageManager.pushTime);
            intent.putExtra("pushChannel", pushMessageManager.pushChannel);
            intent.putExtra("groupId", pushMessageManager.getGroupId());
            intent.putExtra(MessageKey.MSG_TARGET_TYPE, pushMessageManager.getTargetType());
            intent.putExtra(MessageKey.MSG_SOURCE, pushMessageManager.getSource());
            d dVar = (d) pushMessageManager.getMessageHolder();
            intent.putExtra(Constants.TAG_TPUSH_MESSAGE, "true");
            intent.putExtra("title", Rijndael.encrypt(dVar.d()));
            intent.putExtra("content", Rijndael.encrypt(dVar.e()));
            if (dVar.f() != null) {
                intent.putExtra("custom_content", Rijndael.encrypt(dVar.f()));
            }
            intent.putExtra("msgId", pushMessageManager.getMsgId());
            intent.putExtra("accId", pushMessageManager.getAccessId());
            intent.putExtra("busiMsgId", pushMessageManager.getBusiMsgId());
            intent.putExtra("timestamps", pushMessageManager.getTimestamps());
            intent.putExtra("group_id", pushMessageManager.getGroupId());
            intent.putExtra(MessageKey.MSG_TEMPLATE_ID, pushMessageManager.getTemplateId());
            intent.putExtra(MessageKey.MSG_TRACE_ID, pushMessageManager.getTraceId());
            intent.putExtra(MessageKey.MSG_PORTECT_TAG, Rijndael.encrypt("" + (System.currentTimeMillis() - 1000)));
            int k2 = dVar.k();
            if (k2 <= 0) {
                k2 = b(context, dVar.g());
            }
            intent.putExtra(MessageKey.NOTIFACTION_ID, k2);
        }
        if (intent != null && z2) {
            d.a.C0222a c0222a2 = aVar.f6168c;
            if (c0222a2 != null && (i3 = c0222a2.a) > 0) {
                intent.setFlags(i3);
            } else {
                intent.setFlags(67108864);
            }
        }
        return intent;
    }

    private static synchronized int b(Context context, int i2) {
        int i3;
        synchronized (b.class) {
            i3 = 0;
            try {
                String str = "_XINGE_NOTIF_NUMBER_" + String.valueOf(i2);
                int i4 = PushPreferences.getInt(context, str, 0);
                if (i4 < 2147483646) {
                    i3 = i4;
                }
                PushPreferences.putInt(context, str, i3 + 1);
            } finally {
                return i3;
            }
        }
        return i3;
    }

    @JgMethodChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.RECEIVERCHECK, EType.INTENTCHECK})
    public static void a(Context context, Context context2, PushMessageManager pushMessageManager) {
        Context context3;
        boolean z;
        PushMessageManager pushMessageManager2;
        boolean z2;
        int i2;
        String str;
        Intent intent;
        String str2;
        boolean z3;
        String str3;
        Notification notification;
        int i3;
        if (context2 == null) {
            context3 = context;
            z = false;
        } else {
            context3 = context2;
            z = true;
        }
        d dVar = (d) pushMessageManager.getMessageHolder();
        d.a l2 = dVar.l();
        XGPushNotificationBuilder a2 = a(context, dVar.g());
        if (a2 == null || dVar.u() == 1) {
            a2 = b(context, dVar, a2);
        }
        XGPushNotificationBuilder xGPushNotificationBuilder = a2;
        a(context, dVar, xGPushNotificationBuilder);
        String f2 = dVar.f();
        if (i.b(f2) || "{}".equalsIgnoreCase(f2)) {
            pushMessageManager2 = pushMessageManager;
            z2 = false;
        } else {
            pushMessageManager2 = pushMessageManager;
            z2 = true;
        }
        Intent a3 = a(context, l2, z2, pushMessageManager2, z);
        if (a3 == null) {
            TLogger.e("MessageHelper", "unexpected action intent null, Action -> showNotification terminate");
            return;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
        int k2 = dVar.k();
        if (k2 == -1) {
            notificationManager.cancelAll();
        }
        int i4 = 134217728;
        d.a.C0222a c0222a = l2.f6168c;
        if (c0222a != null && (i3 = c0222a.b) > 0) {
            i4 = i3;
        }
        int i5 = i4 | 33554432;
        boolean a4 = a(context, pushMessageManager, dVar, xGPushNotificationBuilder, k2, i5);
        if (dVar.D() > 0 && !a4 && TextUtils.isEmpty(dVar.d()) && TextUtils.isEmpty(dVar.e())) {
            TLogger.w("MessageHelper", "customLayout but title and content null");
            return;
        }
        a3.putExtra(Constants.FLAG_IS_SHOW_IN_CUSTOM_LAYOUT, a4);
        if (a == null) {
            a = new BroadcastReceiver() { // from class: com.tencent.android.tpush.message.b.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(final Context context4, final Intent intent2) {
                    final String stringExtra = intent2.getStringExtra(Constants.FLAG_PACK_NAME);
                    TLogger.ii("MessageHelper", "onReceive: Notification has canceled! pkg name: " + stringExtra);
                    if (com.tencent.android.tpush.e.a.a(context4.getApplicationContext()) || (!i.b(stringExtra) && stringExtra.equals(context4.getPackageName()))) {
                        CommonWorkingThread.getInstance().execute(new TTask() { // from class: com.tencent.android.tpush.message.b.1.1
                            {
                                AnonymousClass1.this = this;
                            }

                            @Override // com.tencent.tpns.baseapi.base.util.TTask
                            public void TRun() {
                                MessageManager.getInstance().updateCachedMsgIntentToCancel(context4, intent2.getLongExtra("msgId", -1L));
                                Intent intent3 = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
                                intent3.setPackage(stringExtra);
                                intent3.putExtras(intent2);
                                intent3.putExtra("TPUSH.FEEDBACK", 4);
                                BroadcastAgent.sendBroadcast(context4, intent3);
                                Intent intent4 = new Intent("com.tencent.android.xg.vip.action.PUSH_CANCELLED.RESULT.V4");
                                intent4.putExtras(intent2);
                                intent4.putExtra(Constants.FLAG_CLICK_TIME, System.currentTimeMillis() / 1000);
                                ServiceStat.appReportNotificationCleared(context4, intent4);
                                BroadcastAgent.sendBroadcast(context4, intent4);
                            }
                        });
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(context3.getPackageName() + ".APP_PUSH_CANCELLED.RESULT");
            BroadcastAgent.registerReceiver(context3, a, intentFilter);
        }
        Intent intent2 = new Intent(context3.getPackageName() + ".APP_PUSH_CANCELLED.RESULT");
        intent2.setPackage(context3.getPackageName());
        intent2.putExtra(Constants.FLAG_PACK_NAME, context.getPackageName());
        intent2.putExtra("action", NotificationAction.delete.getType());
        intent2.putExtras(a3);
        int i6 = Build.VERSION.SDK_INT;
        if (i6 == 19) {
            i2 = i5;
            PendingIntent.getActivity(context, k2, a3, i2).cancel();
        } else {
            i2 = i5;
        }
        if (!z) {
            xGPushNotificationBuilder.setContentIntent(PendingIntent.getActivity(context, k2, a3, i2));
        } else if (i6 >= 26) {
            xGPushNotificationBuilder.setRunAsSysAndAndBuildSdk26(true);
        }
        if (b == null) {
            b = new BroadcastReceiver() { // from class: com.tencent.android.tpush.message.b.2
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context4, Intent intent3) {
                    String action = intent3.getAction();
                    if (action != null) {
                        String stringExtra = intent3.getStringExtra(MessageKey.MSG_AUDIO_URL);
                        if (action.equals(context4.getPackageName() + ".APP_PUSH_MEDIA.PLAY") && !TextUtils.isEmpty(stringExtra)) {
                            try {
                                if (b.f6150c == null) {
                                    MediaPlayer unused = b.f6150c = new MediaPlayer();
                                    b.f6150c.setAudioStreamType(3);
                                }
                                b.f6150c.reset();
                                b.f6150c.setDataSource(stringExtra);
                                b.f6150c.prepare();
                                b.f6150c.start();
                                return;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                return;
                            } catch (IllegalArgumentException e3) {
                                e3.printStackTrace();
                                return;
                            } catch (IllegalStateException e4) {
                                e4.printStackTrace();
                                return;
                            }
                        }
                        if (action.equals(context4.getPackageName() + ".APP_PUSH_MEDIA.STOP")) {
                            try {
                                if (b.f6150c != null) {
                                    b.f6150c.stop();
                                    b.f6150c.release();
                                    MediaPlayer unused2 = b.f6150c = null;
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                }
            };
            IntentFilter intentFilter2 = new IntentFilter();
            StringBuilder sb = new StringBuilder();
            str = Constants.FLAG_IS_SHOW_IN_CUSTOM_LAYOUT;
            sb.append(context.getPackageName());
            sb.append(".APP_PUSH_MEDIA.PLAY");
            intentFilter2.addAction(sb.toString());
            intentFilter2.addAction(context.getPackageName() + ".APP_PUSH_MEDIA.STOP");
            BroadcastAgent.registerReceiver(context, b, intentFilter2);
        } else {
            str = Constants.FLAG_IS_SHOW_IN_CUSTOM_LAYOUT;
        }
        Pair<Notification, Object> buildNotification = xGPushNotificationBuilder.buildNotification(context);
        Notification notification2 = (Notification) buildNotification.first;
        Object obj = buildNotification.second;
        notification2.deleteIntent = PendingIntent.getBroadcast(context3, k2, intent2, i2);
        boolean d2 = i.d(context3, context.getPackageName());
        boolean z4 = dVar.x() == 1 && d2;
        TLogger.d("MessageHelper", "is_show_type:" + dVar.x() + ", OnForeground:" + d2);
        if (z) {
            XGSysPushNotifactionCallback sysNotifactionCallback = XGPushManager.getSysNotifactionCallback();
            if (sysNotifactionCallback == null) {
                TLogger.ee("MessageHelper", "XG Sys Push init Error, no notifactionCallback!");
                return;
            } else if (z4) {
                TLogger.d("MessageHelper", "appOnForeground ");
                intent = a3;
            } else {
                intent = a3;
                sysNotifactionCallback.handleNotify(new XGSysNotifaction(context.getPackageName(), k2, notification2, a3, i2, obj));
            }
        } else {
            intent = a3;
            XGPushNotifactionCallback notifactionCallback = XGPushManager.getNotifactionCallback();
            if (obj != null) {
                XGPushNotificationBuilder.createNotificationChannel(context, obj);
            }
            if (z4) {
                TLogger.d("MessageHelper", "appOnForeground ");
            } else {
                if (notifactionCallback == null) {
                    int y = dVar.y();
                    if (y == -2) {
                        XGPushConfig.changeHuaweiBadgeNum(context, 1);
                    } else if (y >= 0) {
                        XGPushConfig.setBadgeNum(context, y);
                    }
                    try {
                        String h2 = com.tencent.android.tpush.c.d.h();
                        String z5 = dVar.z();
                        if (TextUtils.isEmpty(z5) || i6 < 24 || "oppo".equals(h2) || ((a4 && "vivo".equals(h2)) || (a4 && xGPushNotificationBuilder.getCustomLayoutType() == 3))) {
                            str3 = str;
                            notification = notification2;
                            z3 = a4;
                        } else {
                            String A = dVar.A();
                            int intValue = xGPushNotificationBuilder.getSmallIcon().intValue();
                            Integer color = xGPushNotificationBuilder.getColor();
                            String currentChannelId = xGPushNotificationBuilder.getCurrentChannelId();
                            String d3 = dVar.d();
                            str3 = str;
                            notification = notification2;
                            z3 = a4;
                            try {
                                notificationManager.notify(-z5.hashCode(), a(context, d3, currentChannelId, z5, A, intValue, color));
                                TLogger.i("MessageHelper", "show group notification " + z5);
                            } catch (Throwable th) {
                                th = th;
                                TLogger.e("MessageHelper", "show group notification error: " + th.toString());
                                notificationManager.notify(k2, notification);
                                str2 = str3;
                                Intent intent3 = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
                                intent3.putExtra("TPUSH.ERRORCODE", 0);
                                intent3.setPackage(context.getPackageName());
                                intent3.putExtras(intent);
                                intent3.putExtra("TPUSH.FEEDBACK", 5);
                                intent3.putExtra(MessageKey.NOTIFACTION_ID, k2);
                                intent3.putExtra(str2, z3);
                                BroadcastAgent.sendBroadcast(context, intent3);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        str3 = str;
                        notification = notification2;
                        z3 = a4;
                    }
                    notificationManager.notify(k2, notification);
                    str2 = str3;
                } else {
                    str2 = str;
                    z3 = a4;
                    TLogger.i("MessageHelper", "call notifactionCallback:" + notification2);
                    notifactionCallback.handleNotify(new XGNotifaction(context, k2, notification2, dVar));
                    TLogger.d("MessageHelper", "not appOnForeground ");
                }
                Intent intent32 = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
                intent32.putExtra("TPUSH.ERRORCODE", 0);
                intent32.setPackage(context.getPackageName());
                intent32.putExtras(intent);
                intent32.putExtra("TPUSH.FEEDBACK", 5);
                intent32.putExtra(MessageKey.NOTIFACTION_ID, k2);
                intent32.putExtra(str2, z3);
                BroadcastAgent.sendBroadcast(context, intent32);
            }
        }
        str2 = str;
        z3 = a4;
        Intent intent322 = new Intent("com.tencent.android.xg.vip.action.FEEDBACK");
        intent322.putExtra("TPUSH.ERRORCODE", 0);
        intent322.setPackage(context.getPackageName());
        intent322.putExtras(intent);
        intent322.putExtra("TPUSH.FEEDBACK", 5);
        intent322.putExtra(MessageKey.NOTIFACTION_ID, k2);
        intent322.putExtra(str2, z3);
        BroadcastAgent.sendBroadcast(context, intent322);
    }

    private static boolean a(Context context, PushMessageManager pushMessageManager, d dVar, XGPushNotificationBuilder xGPushNotificationBuilder, int i2, int i3) {
        RemoteViews a2 = a(context, pushMessageManager, dVar, xGPushNotificationBuilder);
        if (a2 != null) {
            xGPushNotificationBuilder.setCustomLayoutType(dVar.D());
            xGPushNotificationBuilder.setUseStdStyle(dVar.E());
            xGPushNotificationBuilder.setContentView(a2);
            xGPushNotificationBuilder.setbigContentView(a2);
            return true;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            int identifier = context.getResources().getIdentifier("xg_notification", "layout", context.getPackageName());
            if (identifier != 0) {
                TLogger.d("MessageHelper", "has xg_notification layout");
                int identifier2 = context.getResources().getIdentifier("xg_notification_icon", "id", context.getPackageName());
                int identifier3 = context.getResources().getIdentifier("xg_notification_style_title", "id", context.getPackageName());
                int identifier4 = context.getResources().getIdentifier("xg_notification_date", "id", context.getPackageName());
                int identifier5 = context.getResources().getIdentifier("xg_notification_style_content", "id", context.getPackageName());
                int identifier6 = context.getResources().getIdentifier("xg_notification_audio_play", "id", context.getPackageName());
                int identifier7 = context.getResources().getIdentifier("xg_notification_audio_stop", "id", context.getPackageName());
                RemoteViews remoteViews = new RemoteViews(context.getPackageName(), identifier);
                if (identifier2 != 0 && identifier3 != 0 && identifier5 != 0) {
                    remoteViews.setTextViewText(identifier3, dVar.d());
                    remoteViews.setTextViewText(identifier5, dVar.e());
                    if (!TextUtils.isEmpty(dVar.r())) {
                        Bitmap a3 = a(dVar.r());
                        if (a3 == null) {
                            remoteViews.setImageViewResource(identifier2, context.getApplicationInfo().icon);
                        } else {
                            remoteViews.setImageViewBitmap(identifier2, a3);
                        }
                    } else {
                        remoteViews.setImageViewResource(identifier2, context.getApplicationInfo().icon);
                    }
                }
                if (identifier4 != 0) {
                    remoteViews.setTextViewText(identifier4, String.valueOf(new SimpleDateFormat(b0.a.p).format(new Date(System.currentTimeMillis()))));
                }
                if (identifier6 != 0 && identifier7 != 0 && !TextUtils.isEmpty(dVar.o())) {
                    remoteViews.setViewVisibility(identifier6, 0);
                    remoteViews.setViewVisibility(identifier7, 0);
                    Intent intent = new Intent(context.getPackageName() + ".APP_PUSH_MEDIA.PLAY");
                    intent.putExtra("msgId", pushMessageManager.getMsgId());
                    intent.putExtra(MessageKey.MSG_AUDIO_URL, dVar.o());
                    intent.putExtra(Constants.FLAG_PACK_NAME, context.getPackageName());
                    remoteViews.setOnClickPendingIntent(identifier6, PendingIntent.getBroadcast(context, i2, intent, i3));
                    Intent intent2 = new Intent(context.getPackageName() + ".APP_PUSH_MEDIA.STOP");
                    intent2.putExtra("msgId", pushMessageManager.getMsgId());
                    intent2.putExtra(MessageKey.MSG_AUDIO_URL, dVar.o());
                    intent2.putExtra(Constants.FLAG_PACK_NAME, context.getPackageName());
                    remoteViews.setOnClickPendingIntent(identifier7, PendingIntent.getBroadcast(context, i2, intent2, i3));
                }
                xGPushNotificationBuilder.setContentView(remoteViews);
                return true;
            }
            TLogger.d("MessageHelper", "no xg_notification layout");
        }
        return false;
    }

    private static RemoteViews a(Context context, PushMessageManager pushMessageManager, d dVar, XGPushNotificationBuilder xGPushNotificationBuilder) {
        String str;
        String str2;
        Bitmap a2;
        JSONObject optJSONObject;
        Bitmap a3;
        int i2;
        try {
            String packageName = context.getPackageName();
            int D = dVar.D();
            if (D <= 0) {
                TLogger.d("MessageHelper", "no valid custom layout type");
                return null;
            }
            String C = dVar.C();
            if (TextUtils.isEmpty(C)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(C);
            TLogger.i("MessageHelper", "custom layout param: " + jSONObject.toString());
            int identifier = context.getResources().getIdentifier("custom_notification_layout", "layout", packageName);
            if (identifier == 0) {
                TLogger.d("MessageHelper", "no custom_notification_layout");
                return null;
            }
            String optString = jSONObject.optString(MessageKey.CUSTOM_LAYOUT_TEXT_COLOR);
            int parseColor = !TextUtils.isEmpty(optString) ? Color.parseColor(optString) : 0;
            RemoteViews remoteViews = new RemoteViews(packageName, identifier);
            int identifier2 = context.getResources().getIdentifier("custom_layout_bg", "id", packageName);
            if (identifier2 == 0) {
                return null;
            }
            String d2 = dVar.d();
            String e2 = dVar.e();
            String n = dVar.n();
            if (TextUtils.isEmpty(n)) {
                return null;
            }
            Bitmap a4 = a(n);
            if (a4 == null) {
                TLogger.w("MessageHelper", "custom layout load background failed");
                return null;
            } else if (D == 1) {
                int identifier3 = context.getResources().getIdentifier("custom_layout_title", "id", packageName);
                int identifier4 = context.getResources().getIdentifier("custom_layout_content", "id", packageName);
                int identifier5 = context.getResources().getIdentifier("custom_layout_icon_left", "id", packageName);
                int identifier6 = context.getResources().getIdentifier("custom_layout_icon_right", "id", packageName);
                int identifier7 = context.getResources().getIdentifier("custom_layout_main_board", "id", packageName);
                if (identifier3 != 0 && identifier4 != 0 && identifier5 != 0 && identifier6 != 0 && identifier7 != 0) {
                    if (TextUtils.isEmpty(d2) && TextUtils.isEmpty(e2)) {
                        TLogger.w("MessageHelper", "custom layout type 1 but null title and content");
                        return null;
                    }
                    JSONObject optJSONObject2 = jSONObject.optJSONObject(MessageKey.CUSTOM_LAYOUT_ELEMENTS);
                    str = "";
                    if (optJSONObject2 != null) {
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject(MessageKey.CUSTOM_LAYOUT_LEFT_ICON);
                        String optString2 = optJSONObject3 != null ? optJSONObject3.optString(MessageKey.CUSTOM_LAYOUT_BG_URL) : "";
                        JSONObject optJSONObject4 = optJSONObject2.optJSONObject(MessageKey.CUSTOM_LAYOUT_RIGHT_ICON);
                        str2 = optJSONObject4 != null ? optJSONObject4.optString(MessageKey.CUSTOM_LAYOUT_BG_URL) : "";
                        str = optString2;
                    } else {
                        str2 = "";
                    }
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    Bitmap a5 = a(str);
                    if (a5 == null) {
                        TLogger.w("MessageHelper", "custom layout load left icon failed");
                        return null;
                    }
                    remoteViews.setImageViewBitmap(identifier5, a5);
                    if (!TextUtils.isEmpty(str2) && (a2 = a(str2)) != null) {
                        remoteViews.setImageViewBitmap(identifier6, a2);
                    }
                    if (TextUtils.isEmpty(dVar.d())) {
                        remoteViews.setViewVisibility(identifier3, 8);
                    }
                    if (TextUtils.isEmpty(dVar.e())) {
                        remoteViews.setViewVisibility(identifier4, 8);
                    }
                    remoteViews.setTextViewText(identifier3, dVar.d());
                    remoteViews.setTextViewText(identifier4, dVar.e());
                    if (parseColor != 0) {
                        remoteViews.setTextColor(identifier3, parseColor);
                        remoteViews.setTextColor(identifier4, parseColor);
                    }
                    remoteViews.setImageViewBitmap(identifier2, a4);
                    remoteViews.setInt(identifier2, "setMaxHeight", SizeUtil.dpToPx(context, 80));
                    remoteViews.setViewVisibility(identifier7, 0);
                    return remoteViews;
                }
                return null;
            } else if (D == 2) {
                remoteViews.setInt(identifier2, "setMaxHeight", SizeUtil.dpToPx(context, 120));
                remoteViews.setImageViewBitmap(identifier2, a4);
                return remoteViews;
            } else if (D != 3) {
                return null;
            } else {
                int identifier8 = context.getResources().getIdentifier("custom_layout_top_right_button", "id", packageName);
                int identifier9 = context.getResources().getIdentifier("custom_layout_top_right_icon", "id", packageName);
                int identifier10 = context.getResources().getIdentifier("custom_layout_bottom_content", "id", packageName);
                int identifier11 = context.getResources().getIdentifier("custom_layout_bottom_timestamp", "id", packageName);
                int identifier12 = context.getResources().getIdentifier("custom_layout_main_board_3", "id", packageName);
                if (identifier8 != 0 && identifier9 != 0 && identifier10 != 0 && identifier11 != 0 && identifier12 != 0) {
                    if (TextUtils.isEmpty(e2)) {
                        TLogger.w("MessageHelper", "custom layout type 3 but null content");
                        return null;
                    }
                    JSONObject optJSONObject5 = jSONObject.optJSONObject(MessageKey.CUSTOM_LAYOUT_ELEMENTS);
                    if (optJSONObject5 != null && (optJSONObject = optJSONObject5.optJSONObject(MessageKey.CUSTOM_LAYOUT_TOP_RIGHT_BUTTON)) != null) {
                        String optString3 = optJSONObject.optString("text");
                        JSONObject optJSONObject6 = optJSONObject.optJSONObject("action");
                        if (!TextUtils.isEmpty(optString3) && optJSONObject6 != null) {
                            d.a aVar = new d.a();
                            aVar.a(optJSONObject6.toString());
                            Intent a6 = a(context, aVar, false, pushMessageManager, false);
                            if (a6 == null) {
                                TLogger.d("MessageHelper", "unexpected action top right button intent null");
                            } else {
                                remoteViews.setViewVisibility(identifier8, 0);
                                remoteViews.setTextViewText(identifier8, optString3);
                                if (parseColor != 0) {
                                    remoteViews.setTextColor(identifier8, parseColor);
                                }
                                a6.putExtra(Constants.FLAG_IS_SHOW_IN_CUSTOM_LAYOUT, true);
                                a6.putExtra(Constants.FLAG_BUTTON_CLICK_IN_CUSTOM_LAYOUT, true);
                                int i3 = 134217728;
                                d.a.C0222a c0222a = aVar.f6168c;
                                if (c0222a != null && (i2 = c0222a.b) > 0) {
                                    i3 = i2;
                                }
                                if (Build.VERSION.SDK_INT >= 31) {
                                    i3 |= 33554432;
                                }
                                int k2 = dVar.k();
                                a6.setAction(null);
                                PendingIntent activity = PendingIntent.getActivity(context, k2, a6, i3);
                                remoteViews.setOnClickPendingIntent(identifier8, activity);
                                String optString4 = optJSONObject.optString(MessageKey.CUSTOM_LAYOUT_BG_URL);
                                if (!TextUtils.isEmpty(optString4) && (a3 = a(optString4)) != null) {
                                    remoteViews.setViewVisibility(identifier9, 0);
                                    remoteViews.setImageViewBitmap(identifier9, a3);
                                    remoteViews.setOnClickPendingIntent(identifier9, activity);
                                }
                            }
                        }
                        TLogger.d("MessageHelper", "custom layout type 3 but null top right button info");
                    }
                    String format = new SimpleDateFormat("hh:mm aa").format(Long.valueOf(new Date(System.currentTimeMillis()).getTime()));
                    remoteViews.setTextViewText(identifier10, e2);
                    remoteViews.setTextViewText(identifier11, format);
                    if (parseColor != 0) {
                        remoteViews.setTextColor(identifier10, parseColor);
                        remoteViews.setTextColor(identifier11, parseColor);
                    }
                    remoteViews.setImageViewBitmap(identifier2, a4);
                    remoteViews.setViewVisibility(identifier12, 0);
                    return remoteViews;
                }
                return null;
            }
        } catch (Throwable th) {
            TLogger.w("MessageHelper", "setCustomRemoteViews error: " + th.toString());
            return null;
        }
    }

    private static void a(Context context, d dVar, XGPushNotificationBuilder xGPushNotificationBuilder) {
        Bitmap a2;
        if (dVar.m() > 0) {
            xGPushNotificationBuilder.setIcon(Integer.valueOf(dVar.m()));
        }
        if (dVar.n() != null && !TextUtils.isEmpty(dVar.n()) && (a2 = a(dVar.n())) != null) {
            xGPushNotificationBuilder.setRichIcon(a2);
        }
        if (xGPushNotificationBuilder.getSmallIcon() == null && xGPushNotificationBuilder.getLargeIcon() == null && xGPushNotificationBuilder.getIcon() == null) {
            int identifier = context.getResources().getIdentifier("notification_icon", "drawable", context.getPackageName());
            if (identifier > 0) {
                xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(identifier));
            } else {
                xGPushNotificationBuilder.setSmallIcon(Integer.valueOf(context.getApplicationInfo().icon));
            }
            xGPushNotificationBuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), context.getApplicationInfo().icon));
        }
        xGPushNotificationBuilder.setTitle(dVar.d());
        xGPushNotificationBuilder.setTickerText(dVar.e());
        if (XGPushConfig.isEnableNotificationSound(context)) {
            String v = dVar.v();
            if (!TextUtils.isEmpty(v)) {
                xGPushNotificationBuilder.setChannelId(v);
            }
            if (!TextUtils.isEmpty(dVar.w())) {
                xGPushNotificationBuilder.setChannelName(dVar.w());
            }
        }
        if (TextUtils.isEmpty(dVar.z())) {
            return;
        }
        xGPushNotificationBuilder.setThread_id(dVar.z());
    }

    private static Notification a(Context context, String str, String str2, String str3, String str4, int i2, Integer num) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setGroup(str3).setGroupSummary(true).setAutoCancel(true);
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                builder.getClass().getMethod("setChannelId", String.class).invoke(builder, str2);
            } catch (Throwable th) {
                TLogger.e("MessageHelper", "NotificationGroup setChannelId error", th);
            }
        }
        if (i2 > 0) {
            builder.setSmallIcon(i2);
        } else {
            builder.setSmallIcon(context.getApplicationInfo().icon);
        }
        if (num != null) {
            builder.setColor(num.intValue());
        }
        if (!TextUtils.isEmpty(str4)) {
            builder.setStyle(new NotificationCompat.BigTextStyle().setSummaryText(str4));
        }
        if (ChannelUtils.isBrandBlackShark()) {
            if (!TextUtils.isEmpty(str)) {
                builder.setContentTitle(str);
            } else {
                builder.setContentTitle(ExpandableTextView.N);
            }
        }
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00e3 A[Catch: IOException -> 0x00ec, TryCatch #9 {IOException -> 0x00ec, blocks: (B:139:0x00de, B:141:0x00e3, B:143:0x00e8), top: B:175:0x00de }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x00e8 A[Catch: IOException -> 0x00ec, TRY_LEAVE, TryCatch #9 {IOException -> 0x00ec, blocks: (B:139:0x00de, B:141:0x00e3, B:143:0x00e8), top: B:175:0x00de }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap a(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.message.b.a(java.lang.String):android.graphics.Bitmap");
    }

    public static void a(Context context, PushMessageManager pushMessageManager) {
        if (pushMessageManager.getMessageHolder() instanceof d) {
            TLogger.ii("MessageHelper", "Action -> showNotification " + pushMessageManager.getContent());
            d dVar = (d) pushMessageManager.getMessageHolder();
            if (dVar != null && dVar.l() != null) {
                try {
                    Context applicationContext = context.getApplicationContext();
                    if (com.tencent.android.tpush.e.a.a(applicationContext) && pushMessageManager.getAppPkgName() != null && !pushMessageManager.getAppPkgName().equals(applicationContext.getPackageName())) {
                        TLogger.ii("MessageHelper", "receive otehr app notification: " + pushMessageManager.getAppPkgName());
                        a(applicationContext.createPackageContext(pushMessageManager.getAppPkgName(), 3), applicationContext, pushMessageManager);
                    } else {
                        a(applicationContext, (Context) null, pushMessageManager);
                    }
                    return;
                } catch (Throwable th) {
                    TLogger.ww("MessageHelper", "showNotification Throwable:", th);
                    return;
                }
            }
            TLogger.e("MessageHelper", "showNotification holder == null || holder.getAction() == null");
        }
    }
}
