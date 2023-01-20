package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.xiaomi.push.gv;
import com.xiaomi.push.jc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TargetApi(24)
/* loaded from: classes3.dex */
public class w {
    private static w a = new w();

    /* loaded from: classes3.dex */
    public class a {
        public List<b> a;
        public List<b> b;

        private a() {
            this.a = new ArrayList();
            this.b = new ArrayList();
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public int a;
        public Notification b;

        public b(int i2, Notification notification) {
            this.a = i2;
            this.b = notification;
        }

        public String toString() {
            return "id:" + this.a;
        }
    }

    private w() {
    }

    private int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    public static w a() {
        return a;
    }

    private String a(Notification notification) {
        Bundle bundle;
        if (notification == null || (bundle = notification.extras) == null) {
            return null;
        }
        return bundle.getString("push_src_group_name");
    }

    private List<StatusBarNotification> a(z zVar) {
        List<StatusBarNotification> e2 = zVar != null ? zVar.e() : null;
        if (e2 == null || e2.size() == 0) {
            return null;
        }
        return e2;
    }

    private void a(Context context, int i2, Notification notification, boolean z) {
        String str;
        String d2 = aa.d(notification);
        if (TextUtils.isEmpty(d2)) {
            str = "group auto not extract pkg from notification:" + i2;
        } else {
            List<StatusBarNotification> a2 = a(z.a(context, d2));
            if (a2 != null) {
                String b2 = b(notification);
                HashMap hashMap = new HashMap();
                for (StatusBarNotification statusBarNotification : a2) {
                    if (statusBarNotification.getNotification() != null && statusBarNotification.getId() != i2) {
                        a(hashMap, statusBarNotification);
                    }
                }
                for (Map.Entry<String, a> entry : hashMap.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        a value = entry.getValue();
                        if (z && key.equals(b2) && !d(notification)) {
                            (c(notification) ? value.b : value.a).add(new b(i2, notification));
                        }
                        int size = value.a.size();
                        if (value.b.size() <= 0) {
                            if (z && size >= 2) {
                                a(context, d2, key, value.a.get(0).b);
                            }
                        } else if (size <= 0) {
                            a(context, d2, key);
                        }
                    }
                }
                return;
            }
            str = "group auto not get notifications";
        }
        com.xiaomi.a.a.a.c.a(str);
    }

    private void a(Context context, String str, String str2) {
        com.xiaomi.a.a.a.c.b("group cancel summary:" + str2);
        z.a(context, str).a(a(str, str2));
    }

    private void a(Context context, String str, String str2, Notification notification) {
        Notification.Builder defaults;
        try {
            if (TextUtils.isEmpty(str2)) {
                com.xiaomi.a.a.a.c.a("group show summary group is null");
                return;
            }
            int a2 = aa.a(context, str);
            if (a2 == 0) {
                com.xiaomi.a.a.a.c.a("group show summary not get icon from " + str);
                return;
            }
            z a3 = z.a(context, str);
            if (Build.VERSION.SDK_INT >= 26) {
                String b2 = a3.b(notification.getChannelId(), "groupSummary");
                NotificationChannel c2 = a3.c(b2);
                if ("groupSummary".equals(b2) && c2 == null) {
                    a3.a(new NotificationChannel(b2, "group_summary", 3));
                }
                defaults = new Notification.Builder(context, b2);
            } else {
                defaults = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            aa.a(defaults, true);
            Notification build = defaults.setContentTitle("GroupSummary").setContentText("GroupSummary").setSmallIcon(Icon.createWithResource(str, a2)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (!jc.e() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                aa.b(build, str);
            }
            int a4 = a(str, str2);
            a3.a(a4, build);
            com.xiaomi.a.a.a.c.b("group show summary notify:" + a4);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("group show summary error " + e2);
        }
    }

    private void a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String b2 = b(statusBarNotification.getNotification());
        a aVar = map.get(b2);
        if (aVar == null) {
            aVar = new a();
            map.put(b2, aVar);
        }
        (c(statusBarNotification.getNotification()) ? aVar.b : aVar.a).add(new b(statusBarNotification.getId(), statusBarNotification.getNotification()));
    }

    private boolean a(Context context) {
        if (b(context) && z.a(context)) {
            return ad.a(context).a(gv.LatestNotificationNotIntoGroupSwitch.a(), false);
        }
        return false;
    }

    private String b(Notification notification) {
        if (notification == null) {
            return null;
        }
        return d(notification) ? a(notification) : notification.getGroup();
    }

    private void b(Context context, int i2, Notification notification) {
        String str;
        String d2 = aa.d(notification);
        if (TextUtils.isEmpty(d2)) {
            str = "group restore not extract pkg from notification:" + i2;
        } else {
            z a2 = z.a(context, d2);
            List<StatusBarNotification> a3 = a(a2);
            if (a3 != null) {
                for (StatusBarNotification statusBarNotification : a3) {
                    Notification notification2 = statusBarNotification.getNotification();
                    if (notification2 != null && d(notification2) && statusBarNotification.getId() != i2) {
                        Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, statusBarNotification.getNotification());
                        recoverBuilder.setGroup(a(notification2));
                        aa.a(recoverBuilder, c(notification2));
                        a2.a(statusBarNotification.getId(), recoverBuilder.build());
                        com.xiaomi.a.a.a.c.b("group restore notification:" + statusBarNotification.getId());
                    }
                }
                return;
            }
            str = "group restore not get notifications";
        }
        com.xiaomi.a.a.a.c.a(str);
    }

    private boolean b() {
        return Build.VERSION.SDK_INT >= 24;
    }

    private boolean b(Context context) {
        return ad.a(context).a(gv.NotificationAutoGroupSwitch.a(), true);
    }

    private boolean c(Notification notification) {
        if (notification != null) {
            Object a2 = com.xiaomi.push.am.a((Object) notification, "isGroupSummary", (Object[]) null);
            if (a2 instanceof Boolean) {
                return ((Boolean) a2).booleanValue();
            }
            return false;
        }
        return false;
    }

    private boolean d(Notification notification) {
        Bundle bundle;
        if (notification == null || notification.getGroup() == null || (bundle = notification.extras) == null) {
            return false;
        }
        return notification.getGroup().equals(String.format("pushmask_%s_%s", Long.valueOf(bundle.getLong("push_src_group_time")), a(notification)));
    }

    public String a(Context context, Notification.Builder builder, String str) {
        if (b() && a(context)) {
            long currentTimeMillis = System.currentTimeMillis();
            Bundle extras = builder.getExtras();
            extras.putString("push_src_group_name", str);
            extras.putLong("push_src_group_time", currentTimeMillis);
            return String.format("pushmask_%s_%s", Long.valueOf(currentTimeMillis), str);
        }
        return str;
    }

    public void a(Context context, int i2, Notification notification) {
        if (b()) {
            if (a(context)) {
                try {
                    b(context, i2, notification);
                } catch (Exception e2) {
                    com.xiaomi.a.a.a.c.a("group notify handle restore error " + e2);
                }
            }
            if (b(context)) {
                try {
                    a(context, i2, notification, true);
                } catch (Exception e3) {
                    com.xiaomi.a.a.a.c.a("group notify handle auto error " + e3);
                }
            }
        }
    }
}
