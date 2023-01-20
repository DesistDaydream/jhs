package com.meizu.cloud.pushsdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.meizu.cloud.pushsdk.constants.PushConstants;

/* loaded from: classes2.dex */
public class b {
    public static String a(Context context, String str) {
        return a(context, PushConstants.PUSH_ID_PREFERENCE_NAME, str + "_" + PushConstants.KEY_PUSH_ID);
    }

    public static String a(Context context, String str, String str2) {
        return n(context, str).getString(str2, "");
    }

    public static void a(Context context, int i2, String str) {
        a(context, PushConstants.PUSH_ID_PREFERENCE_NAME, str + "_" + PushConstants.KEY_PUSH_ID_EXPIRE_TIME, i2);
    }

    public static void a(Context context, String str, int i2) {
        a(context, "mz_push_preference", str + ".notification_id", i2);
    }

    public static void a(Context context, String str, long j2) {
        a(context, "mz_push_preference_new", str + ".ad_last_close_time", j2);
    }

    public static void a(Context context, String str, String str2, int i2) {
        n(context, str).edit().putInt(str2, i2).apply();
    }

    public static void a(Context context, String str, String str2, long j2) {
        n(context, str).edit().putLong(str2, j2).apply();
    }

    public static void a(Context context, String str, String str2, String str3) {
        n(context, str).edit().putString(str2, str3).apply();
    }

    public static void a(Context context, String str, String str2, boolean z) {
        n(context, str).edit().putBoolean(str2, z).apply();
    }

    public static void a(Context context, String str, boolean z) {
        a(context, "mz_push_preference", "switch_notification_message_" + str, z);
    }

    public static int b(Context context, String str) {
        return b(context, PushConstants.PUSH_ID_PREFERENCE_NAME, str + "_" + PushConstants.KEY_PUSH_ID_EXPIRE_TIME);
    }

    public static int b(Context context, String str, String str2) {
        return n(context, str).getInt(str2, 0);
    }

    public static void b(Context context, String str, int i2) {
        a(context, "mz_push_preference", str + ".notification_push_task_id", i2);
    }

    public static void b(Context context, String str, String str2, int i2) {
        a(context, "mz_push_preference", str + "." + str2, i2);
    }

    public static void b(Context context, String str, boolean z) {
        a(context, "mz_push_preference", "switch_through_message_" + str, z);
    }

    public static int c(Context context, String str) {
        SharedPreferences n = n(context, "mz_push_preference");
        return n.getInt(str + ".notification_id", 0);
    }

    public static long c(Context context, String str, String str2) {
        return n(context, str).getLong(str2, 0L);
    }

    public static void c(Context context, String str, int i2) {
        a(context, "mz_push_preference", str + ".message_seq", i2);
    }

    public static void c(Context context, String str, boolean z) {
        a(context, "mz_push_preference", str + ".first_request_publicKey", z);
    }

    public static int d(Context context, String str) {
        SharedPreferences n = n(context, "mz_push_preference");
        return n.getInt(str + ".notification_push_task_id", 0);
    }

    public static boolean d(Context context, String str, String str2) {
        return n(context, str).getBoolean(str2, true);
    }

    public static boolean e(Context context, String str) {
        return d(context, "mz_push_preference", "switch_notification_message_" + str);
    }

    public static boolean e(Context context, String str, String str2) {
        return n(context, str).edit().remove(str2).commit();
    }

    public static boolean f(Context context, String str) {
        return f(context, "mz_push_preference", "switch_notification_message_" + str);
    }

    public static boolean f(Context context, String str, String str2) {
        return n(context, str).contains(str2);
    }

    public static String g(Context context, String str) {
        return a(context, "mz_push_preference", "push_alias_" + str);
    }

    public static void g(Context context, String str, String str2) {
        a(context, PushConstants.PUSH_ID_PREFERENCE_NAME, str2 + "_" + PushConstants.KEY_PUSH_ID, str);
    }

    public static void h(Context context, String str, String str2) {
        a(context, "mz_push_preference", "push_alias_" + str, str2);
    }

    public static boolean h(Context context, String str) {
        return d(context, "mz_push_preference", "switch_through_message_" + str);
    }

    public static int i(Context context, String str, String str2) {
        return b(context, "mz_push_preference", str + "." + str2);
    }

    public static boolean i(Context context, String str) {
        return f(context, "mz_push_preference", "switch_through_message_" + str);
    }

    public static int j(Context context, String str) {
        int b = b(context, "mz_push_preference", str + ".message_seq") + 1;
        c(context, str, b);
        e.p.a.a.a.f("mz_push_preference", "current messageSeq " + b);
        return b;
    }

    public static boolean j(Context context, String str, String str2) {
        return e(context, "mz_push_preference", str + "." + str2);
    }

    public static String k(Context context, String str) {
        return a(context, "mz_push_preference", str + ".encryption_public_key");
    }

    public static void k(Context context, String str, String str2) {
        a(context, "mz_push_preference", str + ".encryption_public_key", str2);
    }

    public static boolean l(Context context, String str) {
        return d(context, "mz_push_preference", str + ".first_request_publicKey");
    }

    public static long m(Context context, String str) {
        return c(context, "mz_push_preference_new", str + ".ad_last_close_time");
    }

    private static SharedPreferences n(Context context, String str) {
        return context.getSharedPreferences(str, 0);
    }
}
