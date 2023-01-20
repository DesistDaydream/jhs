package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.gv;
import com.xiaomi.push.ii;
import com.xiaomi.push.jc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class z {
    private static Context a;
    private static Object b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f9196c;

    /* renamed from: d  reason: collision with root package name */
    private static WeakHashMap<Integer, z> f9197d = new WeakHashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private String f9198e;

    /* renamed from: f  reason: collision with root package name */
    private String f9199f;

    private z(String str) {
        this.f9198e = str;
    }

    public static z a(Context context, String str) {
        b(context);
        int hashCode = str.hashCode();
        z zVar = f9197d.get(Integer.valueOf(hashCode));
        if (zVar == null) {
            z zVar2 = new z(str);
            f9197d.put(Integer.valueOf(hashCode), zVar2);
            return zVar2;
        }
        return zVar;
    }

    private static <T> T a(Object obj) {
        if (obj != null) {
            try {
                return (T) obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private static Object a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(List.class).newInstance(list);
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a2 = a("mipush|%s|%s", str2, "");
        return str.startsWith(a2) ? a("mipush_%s_%s", str2, str.replace(a2, "")) : str;
    }

    private static String a(String str, String str2, String str3) {
        return TextUtils.isEmpty(str) ? "" : String.format(str, str2, str3);
    }

    public static boolean a(Context context) {
        b(context);
        return g();
    }

    private static void b(Context context) {
        if (a == null) {
            a = context.getApplicationContext();
            NotificationManager f2 = f();
            Boolean bool = (Boolean) com.xiaomi.push.am.a((Object) f2, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            d("fwk is support.init:" + bool);
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            f9196c = booleanValue;
            if (booleanValue) {
                b = com.xiaomi.push.am.a((Object) f2, "getService", new Object[0]);
            }
        }
    }

    public static void d(String str) {
        com.xiaomi.a.a.a.c.a("NMHelper:" + str);
    }

    private static int e(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return a.getPackageManager().getPackageUid(str, 0);
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    private static NotificationManager f() {
        return (NotificationManager) a.getSystemService(RemoteMessageConst.NOTIFICATION);
    }

    private String f(String str) {
        return a(g() ? "mipush|%s|%s" : "mipush_%s_%s", this.f9198e, str);
    }

    private static boolean g() {
        if (jc.a() && ad.a(a).a(gv.NotificationBelongToAppSwitch.a(), true)) {
            return f9196c;
        }
        return false;
    }

    private StatusBarNotification[] h() {
        if (jc.a(a())) {
            try {
                Object a2 = com.xiaomi.push.am.a(b, "getActiveNotifications", a().getPackageName());
                if (a2 instanceof StatusBarNotification[]) {
                    return (StatusBarNotification[]) a2;
                }
                return null;
            } catch (Throwable th) {
                d("getAllNotifications error " + th);
                return null;
            }
        }
        return null;
    }

    public Context a() {
        return a;
    }

    public void a(int i2) {
        String str = this.f9198e;
        try {
            if (!g()) {
                f().cancel(i2);
                return;
            }
            int a2 = ii.a();
            String packageName = a().getPackageName();
            if (Build.VERSION.SDK_INT >= 30) {
                com.xiaomi.push.am.b(b, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i2), Integer.valueOf(a2));
            } else {
                com.xiaomi.push.am.b(b, "cancelNotificationWithTag", str, null, Integer.valueOf(i2), Integer.valueOf(a2));
            }
            d("cancel succ:" + i2);
        } catch (Exception e2) {
            d("cancel error" + e2);
        }
    }

    public void a(int i2, Notification notification) {
        String str = this.f9198e;
        NotificationManager f2 = f();
        try {
            int i3 = Build.VERSION.SDK_INT;
            if (g()) {
                if (i3 >= 19) {
                    notification.extras.putString("xmsf_target_package", str);
                }
                if (i3 >= 29) {
                    f2.notifyAsPackage(str, null, i2, notification);
                    return;
                }
            }
            f2.notify(i2, notification);
        } catch (Exception unused) {
        }
    }

    @TargetApi(26)
    public void a(NotificationChannel notificationChannel) {
        String str = this.f9198e;
        try {
            if (g()) {
                int e2 = e(str);
                if (e2 != -1) {
                    com.xiaomi.push.am.b(b, "createNotificationChannelsForPackage", str, Integer.valueOf(e2), a(Arrays.asList(notificationChannel)));
                }
            } else {
                f().createNotificationChannel(notificationChannel);
            }
        } catch (Exception e3) {
            d("createNotificationChannel error" + e3);
        }
    }

    public void a(NotificationChannel notificationChannel, boolean z) {
        String str = this.f9198e;
        try {
            if (z) {
                int e2 = e(str);
                if (e2 != -1) {
                    com.xiaomi.push.am.b(b, "updateNotificationChannelForPackage", str, Integer.valueOf(e2), notificationChannel);
                }
            } else {
                a(notificationChannel);
            }
        } catch (Exception e3) {
            d("updateNotificationChannel error " + e3);
        }
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(f(""));
    }

    public String b() {
        return this.f9198e;
    }

    public String b(String str) {
        return TextUtils.isEmpty(str) ? c() : jc.a(a()) ? f(str) : str;
    }

    public String b(String str, String str2) {
        return g() ? str : str2;
    }

    @TargetApi(26)
    public NotificationChannel c(String str) {
        NotificationChannel notificationChannel = null;
        try {
            if (g()) {
                List<NotificationChannel> d2 = d();
                if (d2 != null) {
                    for (NotificationChannel notificationChannel2 : d2) {
                        if (str.equals(notificationChannel2.getId())) {
                            notificationChannel = notificationChannel2;
                            break;
                        }
                    }
                }
            } else {
                notificationChannel = f().getNotificationChannel(str);
            }
        } catch (Exception e2) {
            d("getNotificationChannel error" + e2);
        }
        return notificationChannel;
    }

    public String c() {
        if (TextUtils.isEmpty(this.f9199f)) {
            this.f9199f = f("default");
        }
        return this.f9199f;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0036
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @android.annotation.TargetApi(26)
    public java.util.List<android.app.NotificationChannel> d() {
        /*
            r8 = this;
            java.lang.String r0 = r8.f9198e
            r1 = 0
            boolean r2 = g()     // Catch: java.lang.Exception -> L78
            if (r2 == 0) goto L3b
            int r2 = e(r0)     // Catch: java.lang.Exception -> L78
            r3 = -1
            if (r2 == r3) goto L39
            java.lang.Object r3 = com.xiaomi.push.service.z.b     // Catch: java.lang.Exception -> L78
            java.lang.String r4 = "getNotificationChannelsForPackage"
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L78
            r6 = 0
            r5[r6] = r0     // Catch: java.lang.Exception -> L78
            r6 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L78
            r5[r6] = r2     // Catch: java.lang.Exception -> L78
            r2 = 2
            java.lang.Boolean r6 = java.lang.Boolean.FALSE     // Catch: java.lang.Exception -> L78
            r5[r2] = r6     // Catch: java.lang.Exception -> L78
            java.lang.Object r2 = com.xiaomi.push.am.a(r3, r4, r5)     // Catch: java.lang.Exception -> L78
            java.lang.Object r2 = a(r2)     // Catch: java.lang.Exception -> L78
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Exception -> L78
            java.lang.String r1 = "mipush|%s|%s"
            r7 = r2
            r2 = r1
            r1 = r7
            goto L45
        L36:
            r0 = move-exception
            r1 = r2
            goto L79
        L39:
            r2 = r1
            goto L45
        L3b:
            android.app.NotificationManager r2 = f()     // Catch: java.lang.Exception -> L78
            java.util.List r1 = r2.getNotificationChannels()     // Catch: java.lang.Exception -> L78
            java.lang.String r2 = "mipush_%s_%s"
        L45:
            boolean r3 = com.xiaomi.push.jc.a()     // Catch: java.lang.Exception -> L78
            if (r3 == 0) goto L8d
            if (r1 == 0) goto L8d
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Exception -> L78
            r3.<init>()     // Catch: java.lang.Exception -> L78
            java.lang.String r4 = ""
            java.lang.String r0 = a(r2, r0, r4)     // Catch: java.lang.Exception -> L78
            java.util.Iterator r2 = r1.iterator()     // Catch: java.lang.Exception -> L78
        L5c:
            boolean r4 = r2.hasNext()     // Catch: java.lang.Exception -> L78
            if (r4 == 0) goto L76
            java.lang.Object r4 = r2.next()     // Catch: java.lang.Exception -> L78
            android.app.NotificationChannel r4 = (android.app.NotificationChannel) r4     // Catch: java.lang.Exception -> L78
            java.lang.String r5 = r4.getId()     // Catch: java.lang.Exception -> L78
            boolean r5 = r5.startsWith(r0)     // Catch: java.lang.Exception -> L78
            if (r5 == 0) goto L5c
            r3.add(r4)     // Catch: java.lang.Exception -> L78
            goto L5c
        L76:
            r1 = r3
            goto L8d
        L78:
            r0 = move-exception
        L79:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getNotificationChannels error "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            d(r0)
        L8d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.z.d():java.util.List");
    }

    public List<StatusBarNotification> e() {
        String str = this.f9198e;
        NotificationManager f2 = f();
        ArrayList arrayList = null;
        try {
            if (g()) {
                int a2 = ii.a();
                if (a2 != -1) {
                    return (List) a(com.xiaomi.push.am.a(b, "getAppActiveNotifications", str, Integer.valueOf(a2)));
                }
                return null;
            }
            StatusBarNotification[] activeNotifications = Build.VERSION.SDK_INT >= 23 ? f2.getActiveNotifications() : h();
            boolean a3 = jc.a();
            if (activeNotifications == null || activeNotifications.length <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (StatusBarNotification statusBarNotification : activeNotifications) {
                    if (!a3 || str.equals(aa.d(statusBarNotification.getNotification()))) {
                        arrayList2.add(statusBarNotification);
                    }
                }
                return arrayList2;
            } catch (Throwable th) {
                th = th;
                arrayList = arrayList2;
                d("getActiveNotifications error " + th);
                return arrayList;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f9198e + "}";
    }
}
