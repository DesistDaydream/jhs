package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.dv;
import com.xiaomi.push.jc;
import com.xiaomi.push.jm;
import com.xiaomi.push.m;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class bg {
    @TargetApi(19)
    private static Notification a(Notification notification, int i2, String str, z zVar) {
        if (notification != null) {
            if (!str.equals(notification.extras.getString("message_id"))) {
                notification = null;
            }
            return notification;
        }
        List<StatusBarNotification> e2 = zVar.e();
        if (e2 != null) {
            for (StatusBarNotification statusBarNotification : e2) {
                Notification notification2 = statusBarNotification.getNotification();
                String string = notification2.extras.getString("message_id");
                if (i2 == statusBarNotification.getId() && str.equals(string)) {
                    return notification2;
                }
            }
            return null;
        }
        return null;
    }

    @TargetApi(19)
    public static void a(Context context, String str, int i2, String str2, Notification notification) {
        if (jc.a(context) && notification != null && notification.extras.getBoolean("mipush_n_top_flag", false)) {
            c(context, str, i2, str2, notification);
        }
    }

    public static void a(Context context, Map<String, String> map, dv dvVar, long j2) {
        if (map == null || dvVar == null || !jc.a(context) || !a(map)) {
            return;
        }
        int b = b(map);
        int c2 = c(map);
        if (b <= 0 || c2 > b) {
            com.xiaomi.a.a.a.c.d("set top notification failed - period:" + b + " frequency:" + c2);
            return;
        }
        dvVar.setPriority(2);
        Bundle bundle = new Bundle();
        bundle.putLong("mipush_org_when", j2);
        bundle.putBoolean("mipush_n_top_flag", true);
        if (c2 > 0) {
            bundle.putInt("mipush_n_top_fre", c2);
        }
        bundle.putInt("mipush_n_top_prd", b);
        dvVar.addExtras(bundle);
    }

    private static boolean a(Map<String, String> map) {
        String str = map.get("notification_top_repeat");
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean parseBoolean = Boolean.parseBoolean(str);
        com.xiaomi.a.a.a.c.c("top notification' repeat is " + parseBoolean);
        return parseBoolean;
    }

    private static int b(Map<String, String> map) {
        return Math.max(0, jm.a(map.get("notification_top_period"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i2, String str) {
        return "n_top_update_" + i2 + "_" + str;
    }

    private static int c(Map<String, String> map) {
        return Math.max(0, jm.a(map.get("notification_top_frequency"), 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(19)
    public static void c(Context context, String str, int i2, String str2, Notification notification) {
        z a;
        Notification a2;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || Build.VERSION.SDK_INT < 26 || (a2 = a(notification, i2, str2, (a = z.a(context, str)))) == null) {
            return;
        }
        boolean z = notification != null;
        if (a2.getGroupAlertBehavior() != 1) {
            com.xiaomi.push.am.a((Object) a2, "mGroupAlertBehavior", (Object) 1);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = a2.extras.getLong("mipush_org_when", 0L);
        int i3 = a2.extras.getInt("mipush_n_top_fre", 0);
        int i4 = a2.extras.getInt("mipush_n_top_prd", 0);
        if (i4 <= 0 || i4 < i3) {
            return;
        }
        long j3 = (i4 * 1000) + j2;
        int min = (j2 >= currentTimeMillis || currentTimeMillis >= j3) ? 0 : i3 > 0 ? (int) Math.min((j3 - currentTimeMillis) / 1000, i3) : i4;
        if (!z) {
            if (min > 0) {
                a2.when = currentTimeMillis;
                com.xiaomi.a.a.a.c.a("update top notification: " + str2);
                a.a(i2, a2);
            } else {
                Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, a2);
                recoverBuilder.setPriority(0);
                recoverBuilder.setWhen(currentTimeMillis);
                Bundle extras = recoverBuilder.getExtras();
                if (extras != null) {
                    extras.remove("mipush_n_top_flag");
                    extras.remove("mipush_org_when");
                    extras.remove("mipush_n_top_fre");
                    extras.remove("mipush_n_top_prd");
                    recoverBuilder.setExtras(extras);
                }
                com.xiaomi.a.a.a.c.a("update top notification to common: " + str2);
                a.a(i2, recoverBuilder.build());
            }
        }
        if (min > 0) {
            com.xiaomi.a.a.a.c.a("schedule top notification next update delay: " + min);
            com.xiaomi.push.m.a(context).a(b(i2, str2));
            com.xiaomi.push.m.a(context).b(d(context, str, i2, str2, null), min);
        }
    }

    private static m.a d(Context context, String str, int i2, String str2, Notification notification) {
        return new bh(i2, str2, context, str, notification);
    }
}
