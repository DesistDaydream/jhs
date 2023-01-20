package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public class ay {
    private static volatile ay a;
    private Context b;

    private ay(Context context) {
        this.b = context;
    }

    public static ay a(Context context) {
        if (a == null) {
            synchronized (ay.class) {
                if (a == null) {
                    a = new ay(context);
                }
            }
        }
        return a;
    }

    public synchronized void a(String str, String str2, long j2) {
        SharedPreferences.Editor edit = this.b.getSharedPreferences(str, 4).edit();
        edit.putLong(str2, j2);
        edit.commit();
    }

    public synchronized void a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = this.b.getSharedPreferences(str, 4).edit();
        edit.putString(str2, str3);
        edit.commit();
    }

    public synchronized long b(String str, String str2, long j2) {
        try {
        } catch (Throwable unused) {
            return j2;
        }
        return this.b.getSharedPreferences(str, 4).getLong(str2, j2);
    }

    public synchronized String b(String str, String str2, String str3) {
        try {
        } catch (Throwable unused) {
            return str3;
        }
        return this.b.getSharedPreferences(str, 4).getString(str2, str3);
    }
}
