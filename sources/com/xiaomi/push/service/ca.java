package com.xiaomi.push.service;

import android.app.NotificationChannel;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.SparseArray;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.jc;
import com.xiaomi.push.jl;
import com.xiaomi.push.jm;
import com.xiaomi.push.service.aa;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ca {
    private static final int[] a = {1, 2, 4, 8, 16};
    private static final SparseArray<aa.a<String, String, String>> b = new cb(5);

    /* renamed from: c  reason: collision with root package name */
    private static final SparseArray<Integer> f9139c = new cc(5);

    public static int a(String str, String str2) {
        int i2 = a(str, str2, 8) ? 8 : 0;
        if (a(str, str2, 16)) {
            i2 |= 16;
        }
        if (a(str, str2, 1)) {
            i2 |= 1;
        }
        if (a(str, str2, 2)) {
            i2 |= 2;
        }
        return a(str, str2, 4) ? i2 | 4 : i2;
    }

    private static SharedPreferences a(Context context) {
        return context.getSharedPreferences("ch_permission_cache_file", 0);
    }

    public static void a(Context context, String str) {
        List<NotificationChannel> d2;
        if (!jc.a(context) || TextUtils.isEmpty(str) || (d2 = z.a(context, str).d()) == null) {
            return;
        }
        synchronized (ca.class) {
            SharedPreferences a2 = a(context);
            ArrayList arrayList = new ArrayList();
            for (NotificationChannel notificationChannel : d2) {
                String str2 = (String) com.xiaomi.push.am.a(notificationChannel, "mId");
                if (!TextUtils.isEmpty(str2) && a2.contains(str2)) {
                    arrayList.add(str2);
                }
            }
            if (arrayList.size() > 0) {
                a(a2, arrayList);
            }
        }
    }

    public static void a(Context context, String str, String str2, int i2, String str3, boolean z, int i3) {
        if (!jc.a(context) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            if (jc.a(context)) {
                com.xiaomi.a.a.a.c.a("ChannelPC: can`t setup permission with permissionCode:" + String.valueOf(str3) + " channelId:" + String.valueOf(str2) + " targetPkg:" + str);
                return;
            }
            return;
        }
        int a2 = jm.a(str3, 0);
        boolean a3 = a(i2, a2);
        if (z) {
            a(str, str2, a2, i3);
            if (a3) {
                synchronized (ca.class) {
                    a(a(context), a2, str2);
                }
                return;
            }
            return;
        }
        synchronized (ca.class) {
            SharedPreferences a4 = a(context);
            if (a3 || a4.contains(str2)) {
                a(a4, a2, str, str2, i3);
                if (a3) {
                    a(a4, a2, str2);
                } else {
                    a(a4, str2);
                }
            }
        }
    }

    private static void a(SharedPreferences sharedPreferences, int i2, String str) {
        sharedPreferences.edit().putInt(str, i2).commit();
    }

    private static void a(SharedPreferences sharedPreferences, int i2, String str, String str2, int i3) {
        if (sharedPreferences.getInt(str2, 0) != i2) {
            a(str, str2, i2, i3);
        }
    }

    private static void a(SharedPreferences sharedPreferences, String str) {
        a(sharedPreferences, new cd(str));
    }

    private static void a(SharedPreferences sharedPreferences, List<String> list) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String str : list) {
            edit.remove(str);
        }
        edit.commit();
    }

    public static void a(String str, String str2, int i2, int i3) {
        int[] iArr;
        for (int i4 : a) {
            if ((f9139c.get(i4).intValue() & i3) == 0) {
                a(str, str2, i4, (i2 & i4) > 0);
            } else {
                com.xiaomi.a.a.a.c.a("ChannelPermissions.grantPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i4 + "> :stoped by userLock");
            }
        }
    }

    private static void a(String str, String str2, int i2, boolean z) {
        boolean a2 = aa.a(jl.a(), str, str2, b.get(i2), z);
        com.xiaomi.a.a.a.c.a("ChannelPermissions.grantPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i2 + "=" + z + "> :" + a2);
    }

    private static boolean a(int i2, int i3) {
        return i2 >= 4 || (i3 & 2) > 0 || (i3 & 1) > 0 || (i3 & 8) > 0 || (i3 & 16) > 0;
    }

    private static boolean a(String str, String str2, int i2) {
        boolean z = aa.a(jl.a(), str, str2, b.get(i2)) == 1;
        com.xiaomi.a.a.a.c.a("ChannelPermissions.checkPermission:" + str + Constants.COLON_SEPARATOR + str2 + ": <" + i2 + "=" + z + SimpleComparison.GREATER_THAN_OPERATION);
        return z;
    }
}
