package com.meizu.cloud.pushsdk.notification.c;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.media.RingtoneManager;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class b {
    private static Field a;
    private static Field b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f4918c;

    /* renamed from: d  reason: collision with root package name */
    private static final Object f4919d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static final Map<String, Set<String>> f4920e = new ConcurrentHashMap();

    /* renamed from: f  reason: collision with root package name */
    private static Map<String, Uri> f4921f;

    static {
        try {
            a = Notification.class.getDeclaredField("mFlymeNotification");
            Field declaredField = Class.forName("android.app.NotificationExt").getDeclaredField("internalApp");
            b = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = Notification.class.getDeclaredField("replyIntent");
            f4918c = declaredField2;
            declaredField2.setAccessible(true);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (NoSuchFieldException e3) {
            e.p.a.a.a.f("NotificationUtils", "init NotificationUtils error " + e3.getMessage());
        }
    }

    public static void a(Notification notification, PendingIntent pendingIntent) {
        Field field = f4918c;
        if (field != null) {
            try {
                field.set(notification, pendingIntent);
            } catch (IllegalAccessException e2) {
                e.p.a.a.a.f("NotificationUtils", "setReplyIntent error " + e2.getMessage());
            }
        }
    }

    public static void a(Notification notification, boolean z) {
        Field field = a;
        if (field == null || b == null) {
            return;
        }
        try {
            b.set(field.get(notification), Integer.valueOf(z ? 1 : 0));
        } catch (IllegalAccessException e2) {
            e.p.a.a.a.f("NotificationUtils", "setInternalApp error " + e2.getMessage());
        }
    }

    public static void a(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
    }

    public static void a(Context context, String str) {
        Set<String> set;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
        if (notificationManager == null || TextUtils.isEmpty(str) || (set = f4920e.get(str)) == null) {
            return;
        }
        for (String str2 : set) {
            e.p.a.a.a.c("NotificationUtils", "clear notifyId " + str2 + " notification");
            notificationManager.cancel(Integer.parseInt(str2));
        }
        set.clear();
    }

    public static void a(Context context, String str, int i2) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
        if (notificationManager != null) {
            e.p.a.a.a.c("NotificationUtils", "clear clearNotification notifyId " + i2);
            notificationManager.cancel(i2);
            Set<String> set = f4920e.get(str);
            if (set != null) {
                set.remove(String.valueOf(i2));
            }
        }
    }

    public static boolean a(Context context, String str, String str2) {
        synchronized (f4919d) {
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            int i2 = com.meizu.cloud.pushsdk.util.b.i(context, str, str2);
            e.p.a.a.a.f("NotificationUtils", "removeNotifyKey " + str2 + " notifyId " + i2);
            c(context, str, i2);
            return com.meizu.cloud.pushsdk.util.b.j(context, str, str2);
        }
    }

    public static Uri b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str) || RingtoneManager.getActualDefaultRingtoneUri(context, 2) == null) {
            return null;
        }
        if (f4921f == null) {
            b(context);
        }
        Map<String, Uri> map = f4921f;
        if (map != null && map.size() != 0) {
            return f4921f.get(str.toLowerCase());
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005d, code lost:
        if (r1 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
        if (0 == 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized void b(android.content.Context r6) {
        /*
            java.lang.Class<com.meizu.cloud.pushsdk.notification.c.b> r0 = com.meizu.cloud.pushsdk.notification.c.b.class
            monitor-enter(r0)
            java.util.Map<java.lang.String, android.net.Uri> r1 = com.meizu.cloud.pushsdk.notification.c.b.f4921f     // Catch: java.lang.Throwable -> L8b
            if (r1 == 0) goto L9
            monitor-exit(r0)
            return
        L9:
            r1 = 0
            android.media.RingtoneManager r2 = new android.media.RingtoneManager     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            r6 = 2
            r2.setType(r6)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            android.database.Cursor r1 = r2.getCursor()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            if (r1 != 0) goto L20
            if (r1 == 0) goto L1e
            r1.close()     // Catch: java.lang.Throwable -> L8b
        L1e:
            monitor-exit(r0)
            return
        L20:
            java.util.HashMap r2 = new java.util.HashMap     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            int r3 = r1.getCount()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            com.meizu.cloud.pushsdk.notification.c.b.f4921f = r2     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
        L2f:
            if (r2 == 0) goto L5d
            r2 = 1
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            java.lang.String r3 = r1.getString(r6)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            r4 = 0
            long r4 = r1.getLong(r4)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            android.net.Uri r3 = android.content.ContentUris.withAppendedId(r3, r4)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            if (r4 != 0) goto L58
            if (r3 == 0) goto L58
            java.util.Map<java.lang.String, android.net.Uri> r4 = com.meizu.cloud.pushsdk.notification.c.b.f4921f     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            java.lang.String r2 = r2.toLowerCase()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            r4.put(r2, r3)     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
        L58:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L63 java.lang.Exception -> L65
            goto L2f
        L5d:
            if (r1 == 0) goto L83
        L5f:
            r1.close()     // Catch: java.lang.Throwable -> L8b
            goto L83
        L63:
            r6 = move-exception
            goto L85
        L65:
            r6 = move-exception
            java.lang.String r2 = "NotificationUtils"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L63
            r3.<init>()     // Catch: java.lang.Throwable -> L63
            java.lang.String r4 = "get ringtone info error, "
            r3.append(r4)     // Catch: java.lang.Throwable -> L63
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Throwable -> L63
            r3.append(r6)     // Catch: java.lang.Throwable -> L63
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L63
            e.p.a.a.a.f(r2, r6)     // Catch: java.lang.Throwable -> L63
            if (r1 == 0) goto L83
            goto L5f
        L83:
            monitor-exit(r0)
            return
        L85:
            if (r1 == 0) goto L8a
            r1.close()     // Catch: java.lang.Throwable -> L8b
        L8a:
            throw r6     // Catch: java.lang.Throwable -> L8b
        L8b:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.notification.c.b.b(android.content.Context):void");
    }

    public static void b(Context context, String str, int i2) {
        Map<String, Set<String>> map = f4920e;
        Set<String> set = map.get(str);
        e.p.a.a.a.c("NotificationUtils", "store notifyId " + i2);
        if (set != null) {
            set.add(String.valueOf(i2));
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(String.valueOf(i2));
        map.put(str, hashSet);
    }

    public static void c(Context context, String str, int i2) {
        Set<String> set = f4920e.get(str);
        if (set != null) {
            set.remove(String.valueOf(i2));
            e.p.a.a.a.c("NotificationUtils", "remove notifyId " + i2);
        }
    }
}
