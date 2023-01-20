package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.moor.imkf.model.entity.FromToMessage;
import com.qq.e.comm.constants.ErrorCode;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.dv;
import com.xiaomi.push.dw;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.hd;
import com.xiaomi.push.hn;
import com.xiaomi.push.jc;
import com.xiaomi.push.jm;
import com.xiaomi.push.service.y;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class n {
    public static long a;
    private static final LinkedList<Pair<Integer, hn>> b = new LinkedList<>();

    /* renamed from: c */
    private static ExecutorService f9182c = Executors.newCachedThreadPool();

    /* renamed from: d */
    private static volatile u f9183d;

    /* loaded from: classes3.dex */
    public static class a implements Callable<Bitmap> {
        private String a;
        private Context b;

        /* renamed from: c */
        private boolean f9184c;

        public a(String str, Context context, boolean z) {
            this.b = context;
            this.a = str;
            this.f9184c = z;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Bitmap call() {
            Bitmap bitmap = null;
            if (TextUtils.isEmpty(this.a)) {
                com.xiaomi.a.a.a.c.a("Failed get online picture/icon resource cause picUrl is empty");
                return null;
            }
            if (this.a.startsWith("http")) {
                y.b a = y.a(this.b, this.a, this.f9184c);
                if (a != null) {
                    return a.a;
                }
            } else {
                bitmap = y.a(this.b, this.a);
                if (bitmap != null) {
                    return bitmap;
                }
            }
            com.xiaomi.a.a.a.c.a("Failed get online picture/icon resource");
            return bitmap;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public Notification a;
        public long b = 0;
    }

    /* loaded from: classes3.dex */
    public static class c {
        public String a;
        public long b = 0;

        /* renamed from: c */
        public boolean f9185c = false;
    }

    private static int a(Context context, String str, String str2) {
        if (str.equals(context.getPackageName())) {
            return context.getResources().getIdentifier(str2, "drawable", str);
        }
        return 0;
    }

    private static Notification a(Notification notification) {
        Object a2 = com.xiaomi.push.am.a(notification, "extraNotification");
        if (a2 != null) {
            com.xiaomi.push.am.a(a2, "setCustomizedIcon", Boolean.TRUE);
        }
        return notification;
    }

    private static PendingIntent a(Context context, hn hnVar, String str, byte[] bArr, int i2) {
        return a(context, hnVar, str, bArr, i2, 0, a(context, hnVar, str));
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.app.PendingIntent a(android.content.Context r16, com.xiaomi.push.hn r17, java.lang.String r18, byte[] r19, int r20, int r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.n.a(android.content.Context, com.xiaomi.push.hn, java.lang.String, byte[], int, int, boolean):android.app.PendingIntent");
    }

    private static PendingIntent a(Context context, String str, hn hnVar, byte[] bArr, int i2, int i3) {
        Map<String, String> s = hnVar.m().s();
        if (s == null) {
            return null;
        }
        boolean a2 = a(context, hnVar, str);
        if (a2) {
            return a(context, hnVar, str, bArr, i2, i3, a2);
        }
        Intent a3 = a(context, str, s, i3);
        if (a3 != null) {
            return PendingIntent.getActivity(context, 0, a3, Build.VERSION.SDK_INT >= 31 ? 167772160 : 134217728);
        }
        return null;
    }

    public static ComponentName a(String str) {
        return new ComponentName(str, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    public static Intent a(Context context, String str, Map<String, String> map, int i2) {
        if (b(map)) {
            return a(context, str, map, String.format("cust_btn_%s_ne", Integer.valueOf(i2)), String.format("cust_btn_%s_iu", Integer.valueOf(i2)), String.format("cust_btn_%s_ic", Integer.valueOf(i2)), String.format("cust_btn_%s_wu", Integer.valueOf(i2)));
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return null;
                    }
                    return a(context, str, map, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri");
                }
                return a(context, str, map, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri");
            }
            return a(context, str, map, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri");
        }
        return a(context, str, map, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri");
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.content.Intent a(android.content.Context r3, java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.n.a(android.content.Context, java.lang.String, java.util.Map, java.lang.String, java.lang.String, java.lang.String, java.lang.String):android.content.Intent");
    }

    private static Bitmap a(Context context, int i2) {
        return a(context.getResources().getDrawable(i2));
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight > 0 ? intrinsicHeight : 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    @TargetApi(16)
    private static dv a(Context context, hn hnVar, byte[] bArr, String str, int i2) {
        PendingIntent a2;
        String a3 = a(hnVar);
        Map<String, String> s = hnVar.m().s();
        String str2 = s.get("notification_style_type");
        dv b2 = (!jc.a(context) || f9183d == null) ? null : f9183d.b(context, i2, a3, s);
        if (b2 != null) {
            b2.a(s);
            return b2;
        } else if ("2".equals(str2)) {
            dv dvVar = new dv(context);
            Bitmap b3 = TextUtils.isEmpty(s.get("notification_bigPic_uri")) ? null : b(context, s.get("notification_bigPic_uri"), false);
            if (b3 == null) {
                com.xiaomi.a.a.a.c.a("can not get big picture.");
                return dvVar;
            }
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(dvVar);
            bigPictureStyle.bigPicture(b3);
            bigPictureStyle.setSummaryText(str);
            bigPictureStyle.bigLargeIcon((Bitmap) null);
            dvVar.setStyle(bigPictureStyle);
            return dvVar;
        } else if ("1".equals(str2)) {
            dv dvVar2 = new dv(context);
            dvVar2.setStyle(new Notification.BigTextStyle().bigText(str));
            return dvVar2;
        } else if (PushConstants.PUSH_TYPE_WITHDRAW_NOTIFICATION.equals(str2) && jc.a()) {
            du duVar = new du(context, a3);
            if (!TextUtils.isEmpty(s.get("notification_banner_image_uri"))) {
                duVar.a(b(context, s.get("notification_banner_image_uri"), false));
            }
            if (!TextUtils.isEmpty(s.get("notification_banner_icon_uri"))) {
                duVar.b(b(context, s.get("notification_banner_icon_uri"), false));
            }
            duVar.a(s);
            return duVar;
        } else if ("3".equals(str2) && jc.a()) {
            dw dwVar = new dw(context, i2, a3);
            if (!TextUtils.isEmpty(s.get("notification_colorful_button_text")) && (a2 = a(context, a3, hnVar, bArr, i2, 4)) != null) {
                dwVar.a(s.get("notification_colorful_button_text"), a2).a(s.get("notification_colorful_button_bg_color"));
            }
            if (!TextUtils.isEmpty(s.get("notification_colorful_bg_color"))) {
                dwVar.d(s.get("notification_colorful_bg_color"));
            } else if (!TextUtils.isEmpty(s.get("notification_colorful_bg_image_uri"))) {
                dwVar.a(b(context, s.get("notification_colorful_bg_image_uri"), false));
            }
            dwVar.a(s);
            return dwVar;
        } else {
            return new dv(context);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:220:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:340:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0430  */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v23 */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.xiaomi.push.service.n.b a(android.content.Context r27, com.xiaomi.push.hn r28, byte[] r29, android.widget.RemoteViews r30, android.app.PendingIntent r31, int r32) {
        /*
            Method dump skipped, instructions count: 1210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.n.a(android.content.Context, com.xiaomi.push.hn, byte[], android.widget.RemoteViews, android.app.PendingIntent, int):com.xiaomi.push.service.n$b");
    }

    public static c a(Context context, hn hnVar, byte[] bArr) {
        int i2;
        Map<String, String> map;
        String str;
        c cVar = new c();
        gg.a a2 = gg.a(context, a(hnVar), true);
        hd m2 = hnVar.m();
        if (m2 != null) {
            i2 = m2.q();
            map = m2.s();
        } else {
            i2 = 0;
            map = null;
        }
        int b2 = jm.b(a(hnVar), i2);
        if (jc.a(context) && a2 == gg.a.NOT_ALLOWED) {
            if (m2 != null) {
                dt.a(context.getApplicationContext()).a(hnVar.j(), g(hnVar), m2.b(), "10:" + a(hnVar));
            }
            str = "Do not notify because user block " + a(hnVar) + "‘s notification";
        } else if (jc.a(context) && f9183d != null && f9183d.a(context, b2, a(hnVar), map)) {
            if (m2 != null) {
                dt.a(context.getApplicationContext()).a(hnVar.j(), g(hnVar), m2.b(), "14:" + a(hnVar));
            }
            str = "Do not notify because card notification is canceled or sequence incorrect";
        } else {
            RemoteViews b3 = b(context, hnVar, bArr);
            PendingIntent a3 = a(context, hnVar, hnVar.j(), bArr, b2);
            if (a3 != null) {
                b a4 = a(context, hnVar, bArr, b3, a3, b2);
                cVar.b = a4.b;
                cVar.a = a(hnVar);
                Notification notification = a4.a;
                if (jc.a()) {
                    if (!TextUtils.isEmpty(m2.b())) {
                        notification.extras.putString("message_id", m2.b());
                    }
                    notification.extras.putString("local_paid", hnVar.h());
                    aa.a(map, notification.extras, "msg_busi_type");
                    aa.a(map, notification.extras, "disable_notification_flags");
                    String str2 = m2.u() == null ? null : m2.u().get("score_info");
                    if (!TextUtils.isEmpty(str2)) {
                        notification.extras.putString("score_info", str2);
                    }
                    notification.extras.putString("pushUid", a(m2.f8784j, "n_stats_expose"));
                    int i3 = -1;
                    if (d(hnVar)) {
                        i3 = 1000;
                    } else if (b(hnVar)) {
                        i3 = 3000;
                    }
                    notification.extras.putString("eventMessageType", String.valueOf(i3));
                    notification.extras.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, a(hnVar));
                }
                String str3 = m2.s() == null ? null : m2.s().get("message_count");
                if (jc.a() && str3 != null) {
                    try {
                        aa.a(notification, Integer.parseInt(str3));
                    } catch (NumberFormatException e2) {
                        if (m2 != null) {
                            dt.a(context.getApplicationContext()).b(hnVar.j(), g(hnVar), m2.b(), "8");
                        }
                        com.xiaomi.a.a.a.c.d("fail to set message count. " + e2);
                    }
                }
                String a5 = a(hnVar);
                if (!jc.e() && jc.a(context)) {
                    aa.b(notification, a5);
                }
                z a6 = z.a(context, a5);
                if (jc.a(context) && f9183d != null) {
                    f9183d.a(hnVar, m2.s(), b2, notification);
                }
                if (jc.a(context) && f9183d != null && f9183d.a(m2.s(), b2, notification)) {
                    com.xiaomi.a.a.a.c.b("consume this notificaiton by agent");
                } else {
                    a6.a(b2, notification);
                    cVar.f9185c = true;
                    com.xiaomi.a.a.a.c.a("notification: " + m2.b() + " is notifyied");
                }
                if (jc.a() && jc.a(context)) {
                    w.a().a(context, b2, notification);
                    bg.a(context, a5, b2, m2.b(), notification);
                }
                if (b(hnVar)) {
                    dt.a(context.getApplicationContext()).a(hnVar.j(), g(hnVar), m2.b(), ErrorCode.NETWORK_TIMEOUT, null);
                }
                if (d(hnVar)) {
                    dt.a(context.getApplicationContext()).a(hnVar.j(), g(hnVar), m2.b(), 1002, null);
                }
                if (Build.VERSION.SDK_INT < 26) {
                    String b4 = m2 != null ? m2.b() : null;
                    com.xiaomi.push.m a7 = com.xiaomi.push.m.a(context);
                    int c2 = c(m2.s());
                    if (c2 > 0 && !TextUtils.isEmpty(b4)) {
                        String str4 = "n_timeout_" + b4;
                        a7.a(str4);
                        a7.b(new o(str4, a6, b2), c2);
                    }
                }
                Pair<Integer, hn> pair = new Pair<>(Integer.valueOf(b2), hnVar);
                LinkedList<Pair<Integer, hn>> linkedList = b;
                synchronized (linkedList) {
                    linkedList.add(pair);
                    if (linkedList.size() > 100) {
                        linkedList.remove();
                    }
                }
                return cVar;
            }
            if (m2 != null) {
                dt.a(context.getApplicationContext()).a(hnVar.j(), g(hnVar), m2.b(), "11");
            }
            str = "The click PendingIntent is null. ";
        }
        com.xiaomi.a.a.a.c.a(str);
        return cVar;
    }

    private static String a(Context context, String str, Map<String, String> map) {
        return (map == null || TextUtils.isEmpty(map.get("channel_name"))) ? gg.f(context, str) : map.get("channel_name");
    }

    public static String a(hn hnVar) {
        hd m2;
        if ("com.xiaomi.xmsf".equals(hnVar.f8859f) && (m2 = hnVar.m()) != null && m2.s() != null) {
            String str = m2.s().get("miui_package_name");
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return hnVar.f8859f;
    }

    public static String a(Map<String, String> map, int i2) {
        String format = i2 == 0 ? "notify_effect" : b(map) ? String.format("cust_btn_%s_ne", Integer.valueOf(i2)) : i2 == 1 ? "notification_style_button_left_notify_effect" : i2 == 2 ? "notification_style_button_mid_notify_effect" : i2 == 3 ? "notification_style_button_right_notify_effect" : i2 == 4 ? "notification_colorful_button_notify_effect" : null;
        if (map == null || format == null) {
            return null;
        }
        return map.get(format);
    }

    private static String a(Map<String, String> map, String str) {
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    private static void a(Context context, Intent intent, hn hnVar, hd hdVar, String str, int i2) {
        if (hnVar == null || hdVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        String a2 = a(hdVar.s(), i2);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        if (an.a.equals(a2) || an.b.equals(a2) || an.f9092c.equals(a2)) {
            intent.putExtra("messageId", str);
            intent.putExtra("local_paid", hnVar.f8858e);
            if (!TextUtils.isEmpty(hnVar.f8859f)) {
                intent.putExtra(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, hnVar.f8859f);
            }
            intent.putExtra("job_key", a(hdVar.s(), "jobkey"));
            intent.putExtra(i2 + "_target_component", c(context, hnVar.f8859f, hdVar.s(), i2));
        }
    }

    public static void a(Context context, String str, int i2) {
        a(context, str, i2, -1);
    }

    public static void a(Context context, String str, int i2, int i3) {
        int hashCode;
        if (context == null || TextUtils.isEmpty(str) || i2 < -1) {
            return;
        }
        z a2 = z.a(context, str);
        List<StatusBarNotification> e2 = a2.e();
        if (jm.a(e2)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        boolean z = false;
        if (i2 == -1) {
            hashCode = 0;
            z = true;
        } else {
            hashCode = ((str.hashCode() / 10) * 10) + i2;
        }
        Iterator<StatusBarNotification> it = e2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StatusBarNotification next = it.next();
            if (!TextUtils.isEmpty(String.valueOf(next.getId()))) {
                int id = next.getId();
                if (z) {
                    linkedList.add(next);
                    a2.a(id);
                } else if (hashCode == id) {
                    bz.a(context, next, i3);
                    linkedList.add(next);
                    a2.a(id);
                    break;
                }
            }
        }
        a(context, linkedList);
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        z a2 = z.a(context, str);
        List<StatusBarNotification> e2 = a2.e();
        if (jm.a(e2)) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (StatusBarNotification statusBarNotification : e2) {
            Notification notification = statusBarNotification.getNotification();
            if (notification != null && !TextUtils.isEmpty(String.valueOf(statusBarNotification.getId()))) {
                int id = statusBarNotification.getId();
                String a3 = aa.a(notification);
                String b2 = aa.b(notification);
                if (!TextUtils.isEmpty(a3) && !TextUtils.isEmpty(b2) && a(a3, str2) && a(b2, str3)) {
                    linkedList.add(statusBarNotification);
                    a2.a(id);
                }
            }
        }
        a(context, linkedList);
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return;
        }
        bc.a(context, "category_clear_notification", "clear_notification", linkedList.size(), "");
    }

    private static void a(Intent intent) {
        try {
            Method declaredMethod = intent.getClass().getDeclaredMethod("addMiuiFlags", Integer.TYPE);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(intent, 2);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.b("insert flags error " + e2);
        }
    }

    @TargetApi(16)
    private static void a(dv dvVar, Context context, String str, hn hnVar, byte[] bArr, int i2) {
        PendingIntent a2;
        PendingIntent a3;
        PendingIntent a4;
        PendingIntent a5;
        Map<String, String> s = hnVar.m().s();
        if (TextUtils.equals("3", s.get("notification_style_type")) || TextUtils.equals(PushConstants.PUSH_TYPE_WITHDRAW_NOTIFICATION, s.get("notification_style_type"))) {
            return;
        }
        if (b(s)) {
            for (int i3 = 1; i3 <= 3; i3++) {
                String str2 = s.get(String.format("cust_btn_%s_n", Integer.valueOf(i3)));
                if (!TextUtils.isEmpty(str2) && (a5 = a(context, str, hnVar, bArr, i2, i3)) != null) {
                    dvVar.addAction(0, str2, a5);
                }
            }
            return;
        }
        if (!TextUtils.isEmpty(s.get("notification_style_button_left_name")) && (a4 = a(context, str, hnVar, bArr, i2, 1)) != null) {
            dvVar.addAction(0, s.get("notification_style_button_left_name"), a4);
        }
        if (!TextUtils.isEmpty(s.get("notification_style_button_mid_name")) && (a3 = a(context, str, hnVar, bArr, i2, 2)) != null) {
            dvVar.addAction(0, s.get("notification_style_button_mid_name"), a3);
        }
        if (TextUtils.isEmpty(s.get("notification_style_button_right_name")) || (a2 = a(context, str, hnVar, bArr, i2, 3)) == null) {
            return;
        }
        dvVar.addAction(0, s.get("notification_style_button_right_name"), a2);
    }

    private static boolean a(Context context, hn hnVar, String str) {
        if (hnVar != null && hnVar.m() != null && hnVar.m().s() != null && !TextUtils.isEmpty(str)) {
            return Boolean.parseBoolean(hnVar.m().s().get("use_clicked_activity")) && ch.a(context, a(str));
        }
        com.xiaomi.a.a.a.c.a("should clicked activity params are null.");
        return false;
    }

    public static boolean a(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static boolean a(Context context, String str, boolean z) {
        return jc.a() && !z && a(context, str);
    }

    private static boolean a(hd hdVar) {
        if (hdVar != null) {
            String b2 = hdVar.b();
            return !TextUtils.isEmpty(b2) && b2.length() == 22 && "satuigmo".indexOf(b2.charAt(0)) >= 0;
        }
        return false;
    }

    private static boolean a(String str, String str2) {
        return TextUtils.isEmpty(str) || str2.contains(str);
    }

    public static boolean a(Map<String, String> map) {
        if (map == null || !map.containsKey("notify_foreground")) {
            return true;
        }
        return "1".equals(map.get("notify_foreground"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x004e, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0070, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0072, code lost:
        r1 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String[] a(android.content.Context r3, com.xiaomi.push.hd r4) {
        /*
            java.lang.String r0 = r4.h()
            java.lang.String r1 = r4.j()
            java.util.Map r4 = r4.s()
            if (r4 == 0) goto L73
            android.content.res.Resources r2 = r3.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            float r3 = r3.density
            float r2 = (float) r2
            float r2 = r2 / r3
            r3 = 1056964608(0x3f000000, float:0.5)
            float r2 = r2 + r3
            java.lang.Float r3 = java.lang.Float.valueOf(r2)
            int r3 = r3.intValue()
            r2 = 320(0x140, float:4.48E-43)
            if (r3 > r2) goto L51
            java.lang.String r3 = "title_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L42
            r0 = r3
        L42:
            java.lang.String r3 = "description_short"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L73
            goto L72
        L51:
            r2 = 360(0x168, float:5.04E-43)
            if (r3 <= r2) goto L73
            java.lang.String r3 = "title_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L64
            r0 = r3
        L64:
            java.lang.String r3 = "description_long"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L73
        L72:
            r1 = r3
        L73:
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]
            r4 = 0
            r3[r4] = r0
            r4 = 1
            r3[r4] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.n.a(android.content.Context, com.xiaomi.push.hd):java.lang.String[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:166:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.Intent b(android.content.Context r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7, int r8) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.n.b(android.content.Context, java.lang.String, java.util.Map, int):android.content.Intent");
    }

    private static Bitmap b(Context context, String str, boolean z) {
        Future submit = f9182c.submit(new a(str, context, z));
        try {
            try {
                Bitmap bitmap = (Bitmap) submit.get(180L, TimeUnit.SECONDS);
                return bitmap == null ? bitmap : bitmap;
            } catch (InterruptedException | ExecutionException | TimeoutException e2) {
                com.xiaomi.a.a.a.c.a(e2);
                submit.cancel(true);
                return null;
            }
        } finally {
            submit.cancel(true);
        }
    }

    private static RemoteViews b(Context context, hn hnVar, byte[] bArr) {
        hd m2 = hnVar.m();
        String a2 = a(hnVar);
        if (m2 != null && m2.s() != null) {
            Map<String, String> s = m2.s();
            String str = s.get("layout_name");
            String str2 = s.get("layout_value");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a2);
                    int identifier = resourcesForApplication.getIdentifier(str, "layout", a2);
                    if (identifier == 0) {
                        return null;
                    }
                    RemoteViews remoteViews = new RemoteViews(a2, identifier);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.has("text")) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject("text");
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String string = jSONObject2.getString(next);
                                int identifier2 = resourcesForApplication.getIdentifier(next, "id", a2);
                                if (identifier2 > 0) {
                                    remoteViews.setTextViewText(identifier2, string);
                                }
                            }
                        }
                        if (jSONObject.has(FromToMessage.MSG_TYPE_IMAGE)) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject(FromToMessage.MSG_TYPE_IMAGE);
                            Iterator<String> keys2 = jSONObject3.keys();
                            while (keys2.hasNext()) {
                                String next2 = keys2.next();
                                String string2 = jSONObject3.getString(next2);
                                int identifier3 = resourcesForApplication.getIdentifier(next2, "id", a2);
                                int identifier4 = resourcesForApplication.getIdentifier(string2, "drawable", a2);
                                if (identifier3 > 0) {
                                    remoteViews.setImageViewResource(identifier3, identifier4);
                                }
                            }
                        }
                        if (jSONObject.has("time")) {
                            JSONObject jSONObject4 = jSONObject.getJSONObject("time");
                            Iterator<String> keys3 = jSONObject4.keys();
                            while (keys3.hasNext()) {
                                String next3 = keys3.next();
                                String string3 = jSONObject4.getString(next3);
                                if (string3.length() == 0) {
                                    string3 = "yy-MM-dd hh:mm";
                                }
                                int identifier5 = resourcesForApplication.getIdentifier(next3, "id", a2);
                                if (identifier5 > 0) {
                                    remoteViews.setTextViewText(identifier5, new SimpleDateFormat(string3).format(new Date(System.currentTimeMillis())));
                                }
                            }
                        }
                        return remoteViews;
                    } catch (JSONException e2) {
                        com.xiaomi.a.a.a.c.a(e2);
                        return null;
                    }
                } catch (PackageManager.NameNotFoundException e3) {
                    com.xiaomi.a.a.a.c.a(e3);
                }
            }
        }
        return null;
    }

    public static void b(Context context, String str) {
        a(context, str, -1);
    }

    public static void b(Context context, String str, int i2) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i2).commit();
    }

    private static void b(Intent intent) {
        if (intent == null) {
            return;
        }
        int flags = intent.getFlags() & (-2) & (-3) & (-65);
        if (Build.VERSION.SDK_INT >= 21) {
            flags &= -129;
        }
        intent.setFlags(flags);
    }

    public static boolean b(hn hnVar) {
        hd m2 = hnVar.m();
        return a(m2) && m2.w();
    }

    private static boolean b(Map<String, String> map) {
        if (map == null) {
            com.xiaomi.a.a.a.c.a("meta extra is null");
            return false;
        }
        return "6".equals(map.get("notification_style_type"));
    }

    private static int c(Context context, String str, Map<String, String> map, int i2) {
        ComponentName a2;
        Intent b2 = b(context, str, map, i2);
        if (b2 == null || (a2 = ch.a(context, b2)) == null) {
            return 0;
        }
        return a2.hashCode();
    }

    private static int c(Map<String, String> map) {
        String str = map == null ? null : map.get("timeout");
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void c(Context context, String str) {
        if (!jc.a(context) || f9183d == null || TextUtils.isEmpty(str)) {
            return;
        }
        f9183d.a(str);
    }

    public static boolean c(hn hnVar) {
        hd m2 = hnVar.m();
        return a(m2) && m2.f8782h == 1 && !b(hnVar);
    }

    public static int d(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    private static int d(Map<String, String> map) {
        if (map != null) {
            String str = map.get("channel_importance");
            if (TextUtils.isEmpty(str)) {
                return 3;
            }
            try {
                com.xiaomi.a.a.a.c.c("importance=" + str);
                return Integer.parseInt(str);
            } catch (Exception e2) {
                com.xiaomi.a.a.a.c.d("parsing channel importance error: " + e2);
                return 3;
            }
        }
        return 3;
    }

    public static boolean d(hn hnVar) {
        hd m2 = hnVar.m();
        return a(m2) && m2.f8782h == 0 && !b(hnVar);
    }

    private static int e(Map<String, String> map) {
        if (map != null) {
            String str = map.get("notification_priority");
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                com.xiaomi.a.a.a.c.c("priority=" + str);
                return Integer.parseInt(str);
            } catch (Exception e2) {
                com.xiaomi.a.a.a.c.d("parsing notification priority error: " + e2);
                return 0;
            }
        }
        return 0;
    }

    public static void e(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    public static boolean e(hn hnVar) {
        return hnVar.a() == gq.Registration;
    }

    public static boolean f(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    public static boolean f(hn hnVar) {
        return b(hnVar) || d(hnVar) || c(hnVar);
    }

    private static int g(Context context, String str) {
        int a2 = a(context, str, "mipush_notification");
        int a3 = a(context, str, "mipush_small_notification");
        if (a2 <= 0) {
            a2 = a3 > 0 ? a3 : context.getApplicationInfo().icon;
        }
        return a2 == 0 ? context.getApplicationInfo().logo : a2;
    }

    public static String g(hn hnVar) {
        return b(hnVar) ? "E100002" : d(hnVar) ? "E100000" : c(hnVar) ? "E100001" : e(hnVar) ? "E100003" : "";
    }
}
