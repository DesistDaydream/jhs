package com.xiaomi.push.service;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.android.tpush.common.MessageKey;
import com.xiaomi.push.gg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes3.dex */
public class aa {

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f9068g = {"com.mi.globalbrowser", "com.android.browser"};

    /* renamed from: h  reason: collision with root package name */
    private static String f9069h = null;
    public static final a<String, String, String> a = new a<>("setSound", "canSound", "canSound");
    public static final a<String, String, String> b = new a<>("setVibrate", "canVibrate", "canVibrate");

    /* renamed from: c  reason: collision with root package name */
    public static final a<String, String, String> f9064c = new a<>("setLights", "canLights", "canLights");

    /* renamed from: d  reason: collision with root package name */
    public static final a<String, String, String> f9065d = new a<>("setShowOnKeyguard", "canShowOnKeyguard", "canShowOnKeyguard");

    /* renamed from: e  reason: collision with root package name */
    public static final a<String, String, String> f9066e = new a<>("setFloat", "canFloat", "canShowFloat");

    /* renamed from: f  reason: collision with root package name */
    public static final a<String, String, String> f9067f = new a<>("setShowBadge", "canShowBadge", "canShowBadge");

    /* loaded from: classes3.dex */
    public static class a<F, S, T> {
        public F a;
        public S b;

        /* renamed from: c  reason: collision with root package name */
        public T f9070c;

        private a(F f2, S s, T t) {
            this.a = f2;
            this.b = s;
            this.f9070c = t;
        }
    }

    public static int a(ContentResolver contentResolver) {
        try {
            return Settings.Global.getInt(contentResolver, "user_aggregate", 0);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("get user aggregate failed, " + e2);
            return 0;
        }
    }

    public static int a(Context context, String str) {
        return gg.g(context, str);
    }

    public static int a(Context context, String str, String str2, a<String, String, String> aVar) {
        if (aVar != null) {
            try {
                Bundle a2 = a(context, aVar.b, str, str2, (Bundle) null);
                if (a2 == null || !a2.containsKey(aVar.f9070c)) {
                    return -1;
                }
                return a2.getBoolean(aVar.f9070c) ? 1 : 0;
            } catch (Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    private static Bundle a(Context context, String str, String str2, String str3, Bundle bundle) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("call notification provider failed!");
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("package", str2);
        if (!TextUtils.isEmpty(str3)) {
            bundle2.putString(MessageKey.MSG_CHANNEL_ID, str3);
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        return context.getContentResolver().call(Uri.parse("content://statusbar.notification"), str, (String) null, bundle2);
    }

    public static <T> T a(Notification notification, String str) {
        Bundle bundle = notification.extras;
        if (bundle != null) {
            try {
                return (T) bundle.get(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> T a(java.lang.Object r2, java.lang.String r3, T r4) {
        /*
            r0 = 0
            boolean r1 = r2 instanceof android.app.Notification     // Catch: java.lang.Exception -> L38
            if (r1 == 0) goto Ld
            android.app.Notification r2 = (android.app.Notification) r2     // Catch: java.lang.Exception -> L38
            java.lang.Object r2 = a(r2, r3)     // Catch: java.lang.Exception -> L38
        Lb:
            r0 = r2
            goto L4d
        Ld:
            boolean r1 = r2 instanceof java.util.Map     // Catch: java.lang.Exception -> L38
            if (r1 == 0) goto L18
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.lang.Exception -> L38
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Exception -> L38
            goto Lb
        L18:
            boolean r1 = r2 instanceof android.os.Bundle     // Catch: java.lang.Exception -> L38
            if (r1 == 0) goto L23
            android.os.Bundle r2 = (android.os.Bundle) r2     // Catch: java.lang.Exception -> L38
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Exception -> L38
            goto Lb
        L23:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L38
            r3.<init>()     // Catch: java.lang.Exception -> L38
            java.lang.String r1 = "not support get value from classType:"
            r3.append(r1)     // Catch: java.lang.Exception -> L38
            r3.append(r2)     // Catch: java.lang.Exception -> L38
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Exception -> L38
            com.xiaomi.a.a.a.c.a(r2)     // Catch: java.lang.Exception -> L38
            goto L4d
        L38:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = "get value error "
            r3.append(r1)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            com.xiaomi.a.a.a.c.a(r2)
        L4d:
            if (r0 != 0) goto L50
            goto L51
        L50:
            r4 = r0
        L51:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.aa.a(java.lang.Object, java.lang.String, java.lang.Object):java.lang.Object");
    }

    public static String a(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TITLE);
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customTitle");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    public static String a(Object obj) {
        return (String) a(obj, "msg_busi_type", "");
    }

    public static void a(Notification notification, int i2) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putInt("miui.messageCount", i2);
            }
            Object a2 = com.xiaomi.push.am.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.am.a(a2, "setMessageCount", Integer.valueOf(i2));
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Notification notification, int i2, int i3) {
        if (notification != null) {
            if (notification.extras == null) {
                notification.extras = new Bundle();
            }
            notification.extras.putInt("is_priority", i2);
            notification.extras.putInt("mipush_class", i3);
        }
    }

    public static void a(Notification notification, boolean z) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putBoolean("miui.enableFloat", z);
            }
            Object a2 = com.xiaomi.push.am.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.am.a(a2, "setEnableFloat", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Context context, String str, Intent intent) {
        if (intent == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        arrayList.addAll(Arrays.asList(f9068g));
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str2 = (String) arrayList.get(i2);
            if (!TextUtils.isEmpty(str2)) {
                Intent intent2 = new Intent(intent);
                intent2.setPackage(str2);
                try {
                    if (context.getPackageManager().resolveActivity(intent2, 65536) != null) {
                        intent.setPackage(str2);
                        break;
                    }
                    continue;
                } catch (Exception e2) {
                    com.xiaomi.a.a.a.c.a("can't match url intent. " + e2);
                }
            }
        }
        intent.setPackage(intent.getPackage());
    }

    public static void a(Map<String, String> map, Bundle bundle, String str) {
        if (map == null || bundle == null || TextUtils.isEmpty(str)) {
            com.xiaomi.a.a.a.c.a("cp map to b fail:" + str);
        } else if (TextUtils.isEmpty(map.get(str))) {
            bundle.remove(str);
        } else {
            bundle.putString(str, map.get(str));
        }
    }

    public static boolean a(Notification.Builder builder, boolean z) {
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setGroupAlertBehavior(z ? 2 : 1);
            return true;
        }
        com.xiaomi.a.a.a.c.b("not support setGroupAlertBehavior");
        return false;
    }

    public static boolean a(Context context, String str, String str2, a<String, String, String> aVar, boolean z) {
        if (aVar != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean(aVar.f9070c, z);
                a(context, aVar.a, str, str2, bundle);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean a(Map<String, String> map) {
        return Boolean.parseBoolean((String) a(map, "not_suppress", "true"));
    }

    public static String b(Notification notification) {
        CharSequence charSequence;
        Bundle bundle = notification.extras;
        if (bundle != null) {
            charSequence = bundle.getCharSequence(NotificationCompat.EXTRA_TEXT);
            if (TextUtils.isEmpty(charSequence) && Build.VERSION.SDK_INT >= 21) {
                charSequence = notification.extras.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = notification.extras.getCharSequence("mipush.customContent");
            }
        } else {
            charSequence = null;
        }
        return charSequence != null ? charSequence.toString() : "";
    }

    public static void b(Notification notification, String str) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, str);
            }
            Object a2 = com.xiaomi.push.am.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.am.a(a2, "setTargetPkg", str);
            }
        } catch (Exception unused) {
        }
    }

    public static void b(Notification notification, boolean z) {
        try {
            Bundle bundle = notification.extras;
            if (bundle != null) {
                bundle.putBoolean("miui.enableKeyguard", z);
            }
            Object a2 = com.xiaomi.push.am.a(notification, "extraNotification");
            if (a2 != null) {
                com.xiaomi.push.am.a(a2, "setEnableKeyguard", Boolean.valueOf(z));
            }
        } catch (Exception unused) {
        }
    }

    public static boolean b(ContentResolver contentResolver) {
        int a2 = a(contentResolver);
        return a2 == 1 || a2 == 2;
    }

    public static Notification.Action[] c(Notification notification) {
        Parcelable[] parcelableArray;
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr;
        }
        Bundle bundle = notification.extras;
        if (bundle == null || (parcelableArray = bundle.getParcelableArray("mipush.customActions")) == null) {
            return null;
        }
        return (Notification.Action[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Notification.Action[].class);
    }

    public static String d(Notification notification) {
        Object a2;
        try {
            Bundle bundle = notification.extras;
            r0 = bundle != null ? bundle.getString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE) : null;
            return (!TextUtils.isEmpty(r0) || (a2 = com.xiaomi.push.am.a(notification, "extraNotification")) == null) ? r0 : (String) com.xiaomi.push.am.a(a2, "getTargetPkg", new Object[0]);
        } catch (Exception unused) {
            return r0;
        }
    }
}
